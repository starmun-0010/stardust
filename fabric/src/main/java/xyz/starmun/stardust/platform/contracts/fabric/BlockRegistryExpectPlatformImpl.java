package xyz.starmun.stardust.platform.contracts.fabric;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.blocks.StrataBasedStateBlock;
import xyz.starmun.stardust.datamodels.Properties;

public class BlockRegistryExpectPlatformImpl {
    public static Block register(Properties properties) {
        Block block = new StrataBasedStateBlock(FabricBlockSettings.of(Material.STONE)
                .strength(3.0f,3.0f)
                .breakByTool(FabricToolTags.PICKAXES,1)
                .requiresTool());
        Registry.register(Registry.BLOCK, new ResourceLocation(Stardust.MOD_ID, properties.name), block);
        return block;
    }
}
