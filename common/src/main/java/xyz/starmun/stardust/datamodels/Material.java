package xyz.starmun.stardust.datamodels;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import xyz.starmun.stardust.utils.EnumUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Material {
    private final String id;
    private final List<String> colors;
    private final Map<String, Variant> items;

    public static final Codec<Material> CODEC = RecordCodecBuilder.create((instance)->
            instance.group(
                    Codec.STRING.fieldOf("id").forGetter((Material material)-> material.id),
                    Codec.STRING.listOf().optionalFieldOf("colors").forGetter((Material material)-> Optional.ofNullable(material.colors)),
                    Variant.CODEC.listOf().fieldOf("items")
                            .flatXmap(Material::fromListToMap, Material::fromMapToList)
                            .forGetter((Material material) -> material.items))
                    .apply(instance, (id, colors,items)->
                            new Material(id, colors.orElse(new ArrayList<>()), items))
    );

    private static  DataResult<List<Variant>> fromMapToList(Map<String, Variant>  items) {
        return DataResult.success(new ArrayList<>(items.values()));
    }

    private static DataResult<Map<String, Variant>> fromListToMap(List<Variant> variants) {
        return DataResult.success(variants.stream().collect(Collectors.toMap(item->item.idSuffix, Function.identity())));
    }

    private Material(String id, List<String> colors, Map<String, Variant> items){
        this.id = id;
        this.colors = colors;
        this.items = items;
    }

    public String getId() {
        return id;
    }
    public  Map<String, Variant>  getItems() {
        return items;
    }

    public List<String> getColors() {
        return colors;
    }

    public static class Builder{
        private String id;
        private List<String> colors;
        private Map<String, Variant>  itemModels = new HashMap<>();

        public static Builder instance(){return new Builder();};
        public Builder setId(String id){
            this.id = id;
            return this;
        }
        public Builder setColors(List<String> colors){
            this.colors = colors;
            return this;
        }
        public Builder addVariant(Variant variant){
            this.itemModels.put(variant.idSuffix, variant);
            return this;
        }

        public Material build(){
            return new Material(this.id, this.colors, this.itemModels);
        }
    }
    public static class Variant {
        protected final String idSuffix;
        protected final List<String> colors;
        protected Boolean dropSelf;
        protected final RegistrationType registrationType;
        protected Boolean generateInWorld;
        protected Integer bottomOffset;
        protected Integer topOffset;
        protected Integer maximum;
        protected Integer maxVeinSize;
        protected Integer maxPerChunk;
        public static final Codec<Variant> CODEC = RecordCodecBuilder.create((instance)->
                instance.group(
                        Codec.STRING.fieldOf("idSuffix").forGetter((item)-> item.idSuffix),
                        Codec.BOOL.optionalFieldOf("dropSelf").forGetter((item)-> Optional.ofNullable(item.dropSelf)),
                        Codec.BOOL.optionalFieldOf("generateInWorld")
                                .forGetter(( block) -> Optional.ofNullable(block.generateInWorld)),
                        Codec.INT.optionalFieldOf("bottomOffset")
                                .forGetter(( block)->Optional.ofNullable(block.bottomOffset)),
                        Codec.INT.optionalFieldOf("topOffset")
                                .forGetter(( block)->Optional.ofNullable(block.topOffset)),
                        Codec.INT.optionalFieldOf("maximum")
                                .forGetter(( block)->Optional.ofNullable(block.maximum)),
                        Codec.INT.optionalFieldOf("maxVeinSize")
                                .forGetter(( block)->Optional.ofNullable(block.maxVeinSize)),
                        Codec.INT.optionalFieldOf("maxPerChunk")
                                .forGetter(( block)->Optional.ofNullable(block.maxPerChunk)),
                        Codec.STRING.xmap(value-> EnumUtils.fromStringToEnum(RegistrationType.class,value),
                                EnumUtils::fromEnumToString)
                                .optionalFieldOf("generationType")
                                .forGetter(( item) -> (Optional.ofNullable(item.registrationType))),
                        Codec.STRING.listOf().optionalFieldOf("colors").forGetter((item)-> Optional.ofNullable(item.colors)))
                        .apply(instance, (id,
                                          dropSelf,
                                          generateInWorld,
                                          bottomOffset,
                                          topOffset,
                                          maximum,
                                          maxVeinSize,
                                          maxPerChunk,
                                          registrationType,
                                          colors
                                          )->
                        new Variant(id,
                                dropSelf.orElse(false),
                                generateInWorld.orElse(false),
                                bottomOffset.orElse(null),
                                topOffset.orElse(null),
                                maximum.orElse(null),
                                maxVeinSize.orElse(null),
                                maxPerChunk.orElse(null),
                                registrationType.orElse(RegistrationType.Item),
                                colors.orElse(new ArrayList<>())))

        );

        private Variant(String idSuffix,
                        Boolean dropSelf,
                        Boolean generateInWorld,
                        Integer bottomOffset,
                        Integer topOffset,
                        Integer maximum,
                        Integer maxVeinSize,
                        Integer maxPerChunk,
                        RegistrationType registrationType,
                        List<String> colors){
            this.idSuffix = idSuffix;
            this.registrationType = registrationType;
            this.dropSelf = dropSelf;
            this.generateInWorld=generateInWorld;
            this.bottomOffset=bottomOffset;
            this.topOffset=topOffset;
            this.maximum=maximum;
            this.maxVeinSize=maxVeinSize;
            this.maxPerChunk=maxPerChunk;
            this.colors = colors;
        }

        public List<String> getColors() {
            return colors;
        }
        public String getIdSuffix() {
            return idSuffix;
        }

        public Boolean getDropSelf() {
            return dropSelf;
        }

        public RegistrationType getRegistrationType() {
            return registrationType;
        }

        public Boolean getGenerateInWorld() {
            return generateInWorld;
        }

        public Integer getBottomOffset() {
            return bottomOffset;
        }

        public Integer getTopOffset() {
            return topOffset;
        }

        public Integer getMaximum() {
            return maximum;
        }

        public Integer getMaxVeinSize() {
            return maxVeinSize;
        }

        public Integer getMaxPerChunk() {
            return maxPerChunk;
        }


        public static class Builder{
            protected String nameSuffix;
            protected List<String> colors;
            protected RegistrationType registrationType;
            protected Boolean dropSelf;
            protected Boolean generateInWorld;
            protected Integer bottomOffset;
            protected Integer topOffset;
            protected Integer maximum;
            protected Integer maxVeinSize;
            protected Integer maxPerChunk;

            public static Builder instance(){return new Builder();};

            public Builder setNameSuffix(String nameSuffix){
                this.nameSuffix = nameSuffix;
                return this;
            }
            public Builder setColors(List<String> colors){
                this.colors = colors;
                return this;
            }
            public Builder setRegistrationType(RegistrationType registrationType) {
                this.registrationType = registrationType;
                return this;
            }
            public Builder setDropSelf(Boolean dropSelf) {
                this.dropSelf = dropSelf;
                return this;
            }
            public Builder setGenerateInWorld(Boolean generateInWorld){
                this.generateInWorld =  generateInWorld;
                return this;
            }
            public Builder setBottomOffset(Integer bottomOffset) {
                this.bottomOffset = bottomOffset;
                return this;
            }

            public Builder setTopOffset(Integer topOffset) {
                this.topOffset = topOffset;
                return this;
            }

            public Builder setMaximum(Integer maximum) {
                this.maximum = maximum;
                return this;
            }

            public Builder setMaxVeinSize(Integer maxVeinSize) {
                this.maxVeinSize = maxVeinSize;
                return this;
            }

            public Builder setMaxPerChunk(Integer maxPerChunk) {
                this.maxPerChunk = maxPerChunk;
                return this;
            }

            public Variant build(){
                return new Variant(this.nameSuffix,
                        this.dropSelf,
                        this.generateInWorld,
                        this.bottomOffset,
                        this.topOffset,
                        this.maximum,
                        this.maxVeinSize,
                        this.maxPerChunk,
                        this.registrationType,
                        this.colors);
            }


        }
        public enum RegistrationType {
            Item,
            Block,
            BlockItem
        }
    }
}
