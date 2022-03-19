package xyz.starmun.stardust.datamodels;

public class DynamicItemModel {
    private String name;
    private String[] colors;

    private DynamicItemModel(String name, String baseModel){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String[] getColor() {
        return colors;
    }

    public static class Builder{
        private String name;

        public DynamicItemModel.Builder setName(String name){
            this.name = name;
            return this;
        }
    }
}
