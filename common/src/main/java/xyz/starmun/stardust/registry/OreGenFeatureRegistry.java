package xyz.starmun.stardust.registry;

import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import xyz.starmun.stardust.blocks.StateBasedOreBlock;
import xyz.starmun.stardust.platform.contracts.BiomeModificationExpectPlatform;
import xyz.starmun.stardust.worldgen.StardustOreConfiguration;

import java.util.HashMap;

public class OreGenFeatureRegistry {
    public static void register(HashMap<String, StateBasedOreBlock> blocks){

            StrataRegistry.STRATA.forEach(stratum -> blocks.forEach((oreName, block)->{
            ConfiguredFeature<?, ?> configuredFeature = StardustOreConfiguration
                    .getConfigured(block, stratum);
                BiomeModificationExpectPlatform.addOreFeature(oreName, stratum.getId(), configuredFeature);
            }));
    }
}
