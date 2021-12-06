package xyz.starmun.stardust.platform.contracts.fabric;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.data.Properties;

public class BlockRegistryExpectPlatformImpl {
    public static Block register(Properties properties) {
        Block block = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));
        Registry.register(Registry.BLOCK, new ResourceLocation(Stardust.MOD_ID, properties.name), block);
        return block;
    }
}
