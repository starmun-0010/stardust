package xyz.starmun.stardust.registry;

import xyz.starmun.stardust.blocks.StardustOreBlock;

import java.util.HashMap;

public class RegistryCore {
    public static void registerAll(){
        HashMap<String, StardustOreBlock> blocksMap = OreBlockRegistry.register();
        OreGenFeatureRegistry.register(blocksMap);
    }
}
