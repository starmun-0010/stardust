package xyz.starmun.stardust.registry;

import net.minecraft.world.level.block.Block;

import java.util.Set;

public class RegistryCore {
    public static void registerAll(){
        Set<Block> block = OreBlockRegistry.register();
        OreGenRegistry.register(block);

    }
}
