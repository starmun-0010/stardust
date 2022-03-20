package xyz.starmun.stardust.registry;

import xyz.starmun.stardust.blocks.StateBasedOreBlock;

import java.util.HashMap;

public class RegistryCore {
    public static void registerAll(){
        StrataRegistry.register();
        ItemsRegistry.register();
        HashMap<String, StateBasedOreBlock> blocksMap = OresRegistry.register();
        OreGenFeatureRegistry.register(blocksMap);
    }
}
