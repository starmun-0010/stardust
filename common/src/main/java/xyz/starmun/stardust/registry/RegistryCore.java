package xyz.starmun.stardust.registry;

import xyz.starmun.stardust.blocks.StateBasedOreBlock;

import java.util.HashMap;

public class RegistryCore {
    public static void registerAll(){
        StrataRegistry.register();
        ItemDataModelRegistry.register();
        HashMap<String, StateBasedOreBlock> blocksMap = OreBlockRegistry.register();
        OreGenFeatureRegistry.register(blocksMap);
    }
}
