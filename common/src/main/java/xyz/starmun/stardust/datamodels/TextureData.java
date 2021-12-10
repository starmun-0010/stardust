package xyz.starmun.stardust.datamodels;

public class TextureData {
    private static final String DARK_GRAY = "#a9a9a9";
    private final String color;
    private TextureData(String color){
        this.color = color;
    }
    public String getColor() { return color == null ? DARK_GRAY :  color; }
    public static class Builder{
        private String color;
        public Builder setColor(String color) {
            this.color = color;
            return this;
        }
        public TextureData build(){
            return new TextureData(color);
        }
    }
}
