package xyz.starmun.stardust.worldgen;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;

public class StardustOreConfiguration {
    public static ConfiguredFeature<?, ?> getConfigured(Block block) {
        return Feature.ORE.configured(new OreConfiguration(
                OreConfiguration.Predicates.NATURAL_STONE,
                block.defaultBlockState(), 16))
                .decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(3, 3, 222))).squared()
                .count(64);
    }
}