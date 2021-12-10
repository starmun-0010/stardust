package xyz.starmun.stardust.registry;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.platform.contracts.BiomeModificationExpectPlatform;
import xyz.starmun.stardust.worldgen.StardustOreConfiguration;

import java.util.Set;

public class OreGenRegistry {
    public static void register(Set<Block> blocks){

        Registry<ConfiguredFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_FEATURE;
        blocks.forEach(block->{
            ConfiguredFeature<?, ?> configuredFeature = StardustOreConfiguration.getConfigured(block);
            Registry.register(registry, Stardust.MOD_ID, configuredFeature);
            BiomeModificationExpectPlatform.addOreFeature(configuredFeature);
        });
    }
}
