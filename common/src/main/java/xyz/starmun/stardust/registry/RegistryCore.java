package xyz.starmun.stardust.registry;

import net.minecraft.world.level.block.Block;
import xyz.starmun.stardust.blocks.OreBlockRegistry;
import xyz.starmun.stardust.worldgen.OreGenRegistry;

import java.util.ArrayList;

public class RegistryCore {
    public static void registerAll(){
        ArrayList<Block> block = OreBlockRegistry.register();
        OreGenRegistry.register(block);

    }
}
