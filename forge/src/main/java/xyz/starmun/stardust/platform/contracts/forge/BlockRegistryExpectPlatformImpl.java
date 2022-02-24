package xyz.starmun.stardust.platform.contracts.forge;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolType;
import xyz.starmun.stardust.blocks.StateBasedOreBlock;
import xyz.starmun.stardust.datamodels.Properties;

import static xyz.starmun.stardust.forge.StardustForge.BLOCKS;

public class BlockRegistryExpectPlatformImpl {
    public static Block register(Properties properties){

        Block block = new StateBasedOreBlock(Block.Properties.of(Material.STONE)
                .strength(3.0f,3.0f)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops());
        BLOCKS.register(properties.name, () -> block);
        return block;
    }
}