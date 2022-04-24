package xyz.starmun.stardust.registry;

import xyz.starmun.stardust.blocks.StrataBasedStateBlock;

import java.util.HashMap;

public class RegistryCore {
    public static void registerAll(){
        StrataRegistry.register();
        MaterialVariantsRegistry.register();
        HashMap<String, StrataBasedStateBlock> blocksMap = MaterialsRegistry.register();
        OreGenFeatureRegistry.register(blocksMap);
    }
}
