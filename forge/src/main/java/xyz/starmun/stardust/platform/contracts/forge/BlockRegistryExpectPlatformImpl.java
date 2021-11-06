package xyz.starmun.stardust.platform.contracts.forge;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import xyz.starmun.stardust.data.Properties;

import static xyz.starmun.stardust.forge.StardustForge.BLOCKS;

public class BlockRegistryExpectPlatformImpl {
    public static Block Register(Properties properties){
        Block block = new Block(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops());
        BLOCKS.register(properties.name, () -> block);
        return block;
    }
}