package xyz.starmun.stardust.worldgen;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.platform.contracts.BiomeModificationExpectPlatform;
import xyz.starmun.stardust.utils.ResourceKeyUtil;

import java.util.ArrayList;

public class OreGenRegistry {
    public static void register(ArrayList<Block> blocks){

        Registry<ConfiguredFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_FEATURE;
        blocks.forEach(block->{
            ConfiguredFeature<?, ?> configuredFeature = StardustOreConfiguration.getConfigured(block);
            Registry.register(registry, Stardust.MOD_ID, configuredFeature);
            BiomeModificationExpectPlatform.addOreFeature(configuredFeature);
        });
    }
}
