package xyz.starmun.stardust.data.inmemory;

import com.google.gson.JsonElement;
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
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InMemoryRepositorySource implements RepositorySource {
    private static final Map<ResourceLocation, Set<ResourceLocation>> TAGS = new HashMap<>();

    @Override
    public void loadPacks(Consumer<Pack> consumer, Pack.PackConstructor packConstructor) {


        try (InMemoryPackResource dataPack = new InMemoryPackResource()) {
            TAGS.forEach((location, resourceLocations) -> {
                Tag.Builder builder = Tag.Builder.tag();
                resourceLocations.forEach(t -> builder.addElement(t, Constants.IN_MEMORY_DATA_PACK_NAME));
                dataPack.putJson(PackType.SERVER_DATA, location, builder.serializeToJson());
            });

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
        @Nullable
        private HashMap<ResourceLocation, Supplier<? extends InputStream>> getResourcePackTypeMap(PackType type){
         return null;
        }

        public void putJson(PackType type, ResourceLocation location, JsonElement json) {
            HashMap<ResourceLocation, Supplier<? extends InputStream>> map = getResourcePackTypeMap(type);
            if (map != null){
                map.put(location, () -> new ByteArrayInputStream(JsonUtils.GSON.toJson(json).getBytes(StandardCharsets.UTF_8)));
            }
        }

        @Override
        public InputStream getRootResource(String string) throws IOException {
            return null;
        }

        @Override
        public InputStream getResource(PackType packType, ResourceLocation resourceLocation) throws IOException {
            return null;
        }

        @Override
        public Collection<ResourceLocation> getResources(PackType packType, String string, String string2, int i, Predicate<String> predicate) {
            return null;
        }

        @Override
        public boolean hasResource(PackType packType, ResourceLocation resourceLocation) {
            return false;
        }

        @Override
        public Set<String> getNamespaces(PackType packType) {
            return null;
        }

        @Nullable
        @Override
        public <T> T getMetadataSection(MetadataSectionSerializer<T> metadataSectionSerializer) throws IOException {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public void close() {

        }
    }

}
