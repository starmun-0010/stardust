package xyz.starmun.stardust.datamodels;

public class StardustOreModel {
    private String name;
    private String[] colors;
    private ItemModel[] items;
    private BlockModel[] blocks;
    private BlockItemModel[] blockItemModels;

    private StardustOreModel(){
    }
    public String getName() {
        return name;
    }
    public String[] getColor() {
        return colors;
    }
    public ItemModel[] getItems() {
        return items;
    }

    public static class Builder{
        private String name;
        public Builder setName(String name){
            this.name = name;
            return this;
        }
    }
    public static class ItemModel {
        private String item;
        private String[] colors;
        public String[] getColor() {
            return colors;
        }
        public String getItem() {
            return item;
        }
    }
    public static class BlockModel {
    }
    public static class BlockItemModel{

    }
}
