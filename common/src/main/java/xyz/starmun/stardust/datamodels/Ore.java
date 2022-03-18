package xyz.starmun.stardust.datamodels;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ore {
    private String id;
    private List<String> colors;
    private Map<String, Item> items;

    public static final Codec<Ore> CODEC = RecordCodecBuilder.create((instance)->
            instance.group(
                    Codec.STRING.fieldOf("id").forGetter((Ore ore)-> ore.id),
                    Codec.STRING.listOf().fieldOf("colors").forGetter((Ore ore)-> ore.colors),
                    Item.CODEC.listOf().fieldOf("items")
                            .flatXmap(Ore::toGenerationType, Ore::fromGenerationType)
                            .forGetter((Ore ore) -> ore.items))
                    .apply(instance, (id, colors, items)->
                            new Ore(id, colors, items))
    );

    private static  DataResult<List<Item>> fromGenerationType(Map<String, Item>  items) {
        return DataResult.success(new ArrayList<>(items.values()));
    }

    private static DataResult<Map<String, Item>> toGenerationType(List<Item> items) {
        return DataResult.success(items.stream().collect(Collectors.toMap(item->item.idSuffix, Function.identity())));
    }


    public static Builder builder = new Builder();
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
        private String idSuffix;
        private List<String> colors;
        private static Builder builder = new Builder();
        public static final Codec<Item> CODEC = RecordCodecBuilder.create((instance)->
                instance.group(
                        Codec.STRING.fieldOf("idSuffix").forGetter((Item item)-> item.idSuffix),
                        Codec.STRING.listOf().fieldOf("colors").forGetter((Item item)-> item.colors))
                        .apply(instance, (id, colors)-> new Item(id, colors)));
        private Item(String idSuffix, List<String> colors){
            this.idSuffix = idSuffix;
            this.colors = colors;
        }

        public static Builder getBuilder() {
            return builder;
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

        public static class Builder{
            private String nameSuffix;
            private List<String> colors;
            public Builder setNameSuffix(String nameSuffix){
                this.nameSuffix = nameSuffix;
                return this;
            }
            public Builder setColors(List<String> colors){
                this.colors = colors;
                return this;
            }

            public Item build(){
                return new Item(this.nameSuffix, this.colors);
            }
        }
    }
}
