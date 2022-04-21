package xyz.starmun.stardust.datamodels;

import com.mojang.datafixers.Products;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import xyz.starmun.stardust.utils.EnumUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ore {
    private final String id;
    private final List<String> colors;
    private final Map<String, Item> items;

    public static final Codec<Ore> CODEC = RecordCodecBuilder.create((instance)->
            instance.group(
                    Codec.STRING.fieldOf("id").forGetter((Ore ore)-> ore.id),
                    Codec.STRING.listOf().optionalFieldOf("colors").forGetter((Ore ore)-> Optional.ofNullable(ore.colors)),
                    Item.CODEC.listOf().fieldOf("items")
                            .flatXmap(Ore::fromListToMap, Ore::fromMapToList)
                            .forGetter((Ore ore) -> ore.items))
                    .apply(instance, (id, colors,items)->
                            new Ore(id, colors.orElse(new ArrayList<>()), items))
    );

    private static  DataResult<List<Item>> fromMapToList(Map<String, Item>  items) {
        return DataResult.success(new ArrayList<>(items.values()));
    }

    private static DataResult<Map<String, Item>> fromListToMap(List<Item> items) {
        return DataResult.success(items.stream().collect(Collectors.toMap(item->item.idSuffix, Function.identity())));
    }

    private Ore(String id, List<String> colors, Map<String, Item> items){
        this.id = id;
        this.colors = colors;
        this.items = items;
    }

    public String getId() {
        return id;
    }
    public  Map<String, Item>  getItems() {
        return items;
    }

    public List<String> getColors() {
        return colors;
    }

    public static class Builder{
        private String id;
        private List<String> colors;
        private Map<String, Item>  itemModels = new HashMap<>();

        public static Builder instance(){return new Builder();};
        public Builder setId(String id){
            this.id = id;
            return this;
        }
        public Builder setColors(List<String> colors){
            this.colors = colors;
            return this;
        }
        public Builder addItem(Item item){
            this.itemModels.put(item.idSuffix, item);
            return this;
        }

        public Ore build(){
            return new Ore(this.id, this.colors, this.itemModels);
        }
    }
    public static class Item {
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
        public static final Codec<Item> CODEC = RecordCodecBuilder.create((instance)->
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
                        new Item(id,
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

        private Item(String idSuffix,
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

            public Item build(){
                return new Item(this.nameSuffix,
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
