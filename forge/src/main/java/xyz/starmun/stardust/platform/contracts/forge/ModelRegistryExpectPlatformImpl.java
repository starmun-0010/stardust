package xyz.starmun.stardust.platform.contracts.forge;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ModelRegistryExpectPlatformImpl {
    public static void register(String path){
        ModelLoader.addSpecialModel(new ResourceLocation(path));
    }
}
