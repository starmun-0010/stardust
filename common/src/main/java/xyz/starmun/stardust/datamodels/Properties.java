package xyz.starmun.stardust.datamodels;

public class Properties {
    public String name;
    public Properties(String name){
        this.name = name;
    }
    public double strength;
    public int harvestLevel;
    public ToolType toolType;
    public boolean toolRequired;

    ///TODO::Refactor to single set for each ore

    public int bottomOffset;
    public int topOffset;
    public int maximum;
    public int maxVeinSize;
    public int maxPerChunk;
}
