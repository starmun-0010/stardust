package xyz.starmun.stardust.registry;

import dev.architectury.injectables.annotations.PlatformOnly;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.blocks.StardustOreBlock;
import xyz.starmun.stardust.datamodels.Stratum;
import xyz.starmun.stardust.platform.contracts.BiomeModificationExpectPlatform;
import xyz.starmun.stardust.worldgen.StardustOreConfiguration;

import java.util.HashMap;
import java.util.Set;

public class OreGenFeatureRegistry {
    public static void register(HashMap<String, StardustOreBlock> blocks){

            StrataRegistry.STRATA.forEach(stratum -> blocks.forEach((oreName, block)->{
            ConfiguredFeature<?, ?> configuredFeature = StardustOreConfiguration
                    .getConfigured(block, stratum);
                BiomeModificationExpectPlatform.addOreFeature(oreName, stratum.id, configuredFeature);
            }));
    }
}
