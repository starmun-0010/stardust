package xyz.starmun.stardust.datamodels;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import xyz.starmun.stardust.utils.EnumUtil;

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

    public static Builder instance(){return new Builder();};
    private Ore(String id, List<String> colors, Map<String, Item> items){
        this.id = id;
        this.colors = colors;
        this.items = items;
    }

    public String getId() {
        return id;
    }
    public List<String> getColor() {
        return colors;
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
        private final String idSuffix;
        private final List<String> colors;
        private final RegistrationType registrationType;
        public static Builder instance(){return new Builder();};
        public static final Codec<Item> CODEC = RecordCodecBuilder.create((instance)->
                instance.group(
                        Codec.STRING.fieldOf("idSuffix").forGetter((Item item)-> item.idSuffix),
                        Codec.STRING.listOf().optionalFieldOf("colors").forGetter((Item item)-> Optional.ofNullable(item.colors)),
                        Codec.STRING.xmap(value->EnumUtil.fromStringToEnum(RegistrationType.class,value),
                                EnumUtil::fromEnumToString)
                                .optionalFieldOf("generationType")
                                .forGetter((Item item) -> (Optional.ofNullable(item.registrationType))))
                        .apply(instance, (id,colors,registrationType)->
                                new Item(id,colors.orElse(new ArrayList<>()),registrationType.orElse(RegistrationType.Item)))

        );

        private Item(String idSuffix, List<String> colors, RegistrationType registrationType){
            this.idSuffix = idSuffix;
            this.registrationType = registrationType;
            this.colors = colors;
        }

        public List<String> getColor() {
            return colors;
        }
        public String getIdSuffix() {
            return idSuffix;
        }

        public List<String> getColors() {
            return colors;
        }

        public RegistrationType getRegistrationType() {
            return registrationType;
        }

        public static class Builder{
            private String nameSuffix;
            private List<String> colors;
            private RegistrationType registrationType;

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

            public Item build(){
                return new Item(this.nameSuffix, this.colors, this.registrationType);
            }
        }
        public enum RegistrationType {
            Item,
            Block,
            BlockItem
        }
    }
}
