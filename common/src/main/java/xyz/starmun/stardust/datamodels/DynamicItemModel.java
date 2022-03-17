package xyz.starmun.stardust.datamodels;

import net.minecraft.client.resources.model.ModelBakery;

public class DynamicItemModel {
    private String name;
    private String baseModel;

    private DynamicItemModel(String name, String baseModel){
        this.name = name;
        this.baseModel = baseModel;

    }
    public String getName() {
        return name;
    }
    public String getBaseModel(){
        return baseModel;
    }

    public static class Builder{
        private String name;

        public DynamicItemModel.Builder setName(String name){
            this.name = name;
            return this;
        }
    }
}
