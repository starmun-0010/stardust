package xyz.starmun.stardust.data.inmemory;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.MetadataSectionSerializer;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.repository.RepositorySource;
import net.minecraft.tags.Tag;
import org.jetbrains.annotations.Nullable;
import xyz.starmun.stardust.constants.Constants;
import xyz.starmun.stardust.utils.JsonUtils;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InMemoryRepositorySource implements RepositorySource {
    private static final Map<ResourceLocation, Set<ResourceLocation>> TAGS = new HashMap<>();
    public static final InMemoryRepositorySource INSTANCE = new InMemoryRepositorySource();

    @Override
    public void loadPacks(Consumer<Pack> consumer, Pack.PackConstructor packConstructor) {
        try (InMemoryPackResource dataPack = new InMemoryPackResource()) {
//            TAGS.forEach((location, resourceLocations) -> {
//                Tag.Builder builder = Tag.Builder.tag();
//                resourceLocations.forEach(t -> builder.addElement(t, Constants.IN_MEMORY_DATA_PACK_NAME));
               // dataPack.putJson(PackType.SERVER_DATA, new ResourceLocation(""), new JsonParser().parse(""));
           // });

            Pack pack = Pack.create(
                    Constants.IN_MEMORY_DATA_PACK_NAME,
                    true,
                    () -> dataPack,
                    packConstructor,
                    Pack.Position.BOTTOM,
                    PackSource.BUILT_IN
            );
            consumer.accept(pack);
        }
    }
    private static class InMemoryPackResource implements PackResources{

        private static final JsonObject meta = new JsonObject();
        static {
            meta.add("pack_format", new JsonPrimitive(4));
            meta.add("description", new JsonPrimitive("Data for stardust."));
        }

        private final HashMap<ResourceLocation, Supplier<? extends InputStream>> assets = new HashMap<>();
        private final HashMap<ResourceLocation, Supplier<? extends InputStream>> data = new HashMap<>();

        @Nullable
        private HashMap<ResourceLocation, Supplier<? extends InputStream>> getResourcePackTypeMap(PackType type){
            if (type.equals(PackType.CLIENT_RESOURCES)) return assets;
            else if (type.equals(PackType.SERVER_DATA)) return data;
            else return null;
        }

        public void putJson(PackType type, ResourceLocation location, JsonElement json) {
            HashMap<ResourceLocation, Supplier<? extends InputStream>> map = getResourcePackTypeMap(type);
            if (map != null){
                map.put(location, () -> new ByteArrayInputStream(JsonUtils.GSON.toJson(json).getBytes(StandardCharsets.UTF_8)));
            }
        }

        @Override
        public InputStream getRootResource(String file) throws IOException {
            if(file.contains("/") || file.contains("\\")) {
                throw new IllegalArgumentException("Root resources can only be filenames, not paths (no / allowed!)");
            }
            throw new FileNotFoundException(file);        }

        @Override
        public InputStream getResource(PackType type, ResourceLocation location) throws IOException {
            Map<ResourceLocation, Supplier<? extends InputStream>> map = getResourcePackTypeMap(type);
            if(map != null && map.containsKey(location)) {
                return map.get(location).get();
            }
            throw new FileNotFoundException(location.toString());        }

        @Override
        public Collection<ResourceLocation> getResources(PackType type, String namespace, String path, int maxFolderWalk, Predicate<String> predicate) {
            Map<ResourceLocation, Supplier<? extends InputStream>> map = getResourcePackTypeMap(type);
            if (map == null) return Collections.emptyList();

            return map.keySet().stream()
                    .filter(location->location.getNamespace().equals(namespace))
                    .filter(location->location.getPath().split("/").length < maxFolderWalk)
                    .filter(location->location.getPath().startsWith(path))
                    .filter(location-> predicate.test(location.getPath().substring(Math.max(location.getPath().lastIndexOf('/'), 0)))
                    ).collect(Collectors.toList());        }

        @Override
        public boolean hasResource(PackType type, ResourceLocation location) {
            Map<ResourceLocation, Supplier<? extends InputStream>> map = getResourcePackTypeMap(type);
            return map != null && map.containsKey(location);
        }

        @Override
        public Set<String> getNamespaces(PackType type) {
            Map<ResourceLocation, Supplier<? extends InputStream>> map = getResourcePackTypeMap(type);
            if (map == null) return Collections.emptySet();
            return map.keySet().stream().map(ResourceLocation::getNamespace).collect(Collectors.toSet());
        }

        @Nullable
        @Override
        public <T> T getMetadataSection(MetadataSectionSerializer<T> serializer) throws IOException {
            return serializer.fromJson(meta);
        }

        @Override
        public String getName() {
            return Constants.IN_MEMORY_DATA_PACK_NAME;
        }

        @Override
        public void close() {

        }
    }

}
