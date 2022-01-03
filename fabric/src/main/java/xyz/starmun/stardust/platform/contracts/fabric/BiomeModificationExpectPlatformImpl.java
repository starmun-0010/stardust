package xyz.starmun.stardust.platform.contracts.fabric;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import xyz.starmun.stardust.Stardust;

public class BiomeModificationExpectPlatformImpl {
    public static void addOreFeature(String oreName, String stratumId, ConfiguredFeature<?,?> configuredFeature){
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Stardust.MOD_ID,oreName+"_"+stratumId ), configuredFeature);
        if(!BuiltinRegistries.CONFIGURED_FEATURE.getResourceKey(configuredFeature).isPresent()) {
            return;
        }
        ResourceKey<ConfiguredFeature<?, ?>> key = BuiltinRegistries.CONFIGURED_FEATURE.getResourceKey(configuredFeature).get();
        //noinspection deprecation
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, key);
    }
}
