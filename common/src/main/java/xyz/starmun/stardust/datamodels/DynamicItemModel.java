package xyz.starmun.stardust.datamodels;

public class DynamicItemModel {
    private String name;
    public TextureData textureData;

    private DynamicItemModel(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public TextureData getTextureData(){
        return textureData;
    }

    public static class Builder{
        private String name;

        public DynamicItemModel.Builder setName(String name){
            this.name = name;
            return this;
        }
    }
}
