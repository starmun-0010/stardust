package xyz.starmun.stardust.platform.contracts.fabric;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class BiomeModificationExpectPlatformImpl {
    public static void addOreFeature(ConfiguredFeature<?,?> configuredFeature){
        if(!BuiltinRegistries.CONFIGURED_FEATURE.getResourceKey(configuredFeature).isPresent()) {
            return;
        }
        ResourceKey<ConfiguredFeature<?, ?>> key = BuiltinRegistries.CONFIGURED_FEATURE.getResourceKey(configuredFeature).get();
        //noinspection deprecation
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, key);
    }
}
