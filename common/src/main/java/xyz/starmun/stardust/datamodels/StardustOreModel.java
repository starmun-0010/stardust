package xyz.starmun.stardust.datamodels;

public class StardustOreModel {
    private String name;
    public TextureData textureData;

    private StardustOreModel(String name){
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

        public Builder setName(String name){
            this.name = name;
            return this;
        }
    }

}
