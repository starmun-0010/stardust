package xyz.starmun.stardust.platform.contracts.forge;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolType;
import xyz.starmun.stardust.blocks.StrataBasedStateBlock;
import xyz.starmun.stardust.datamodels.Properties;

import static xyz.starmun.stardust.forge.StardustForge.BLOCKS;

public class BlockRegistryExpectPlatformImpl {
    public static Block register(Properties props){

        Block block = new StrataBasedStateBlock(Block.Properties.of(Material.STONE)
                .strength(3.0f,3.0f)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops()){{
                    maximum = props.maximum;
                    bottomOffset = props.bottomOffset;
                    topOffset = props.topOffset;
                    maxVeinSize = props.maxVeinSize;
                    maxPerChunk = props.maxPerChunk;
        }};

        BLOCKS.register(props.name, () -> block);
        return block;
    }
}