package xyz.starmun.stardust.platform.contracts.forge;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolType;
import xyz.starmun.stardust.blocks.StardustOreBlock;
import xyz.starmun.stardust.datamodels.Properties;

import static xyz.starmun.stardust.forge.StardustForge.BLOCKS;

public class BlockRegistryExpectPlatformImpl {
    public static Block register(Properties properties){

        Block block = new StardustOreBlock(Block.Properties.of(Material.STONE)
                .strength(3.0f,3.0f)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops());
        //final RegistryObject<Block> customHoneycombBlock = BLOCKS.register( properties.name, () -> new HoneycombBlock(name, customBeeData.getColorData(), AbstractBlock.Properties.copy(Blocks.HONEYCOMB_BLOCK)));

        BLOCKS.register(properties.name, () -> block);
        return block;
    }
}