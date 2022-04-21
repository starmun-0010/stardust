package xyz.starmun.stardust.worldgen;

import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import xyz.starmun.stardust.blocks.StateBasedOreBlock;
import xyz.starmun.stardust.datamodels.Stratum;

public class StardustOreConfiguration {
    public static ConfiguredFeature<?, ?> getConfigured(StateBasedOreBlock block, Stratum stratum) {
        return Feature.ORE.configured(new OreConfiguration(
                new BlockMatchTest(stratum.getBlock().get()),
                block.getStateDefinition().any().setValue(StateBasedOreBlock.STRATUM, stratum.getId())
                , block.maxVeinSize))
                .decorated(FeatureDecorator.RANGE.configured(
                        new RangeDecoratorConfiguration(
                                block.bottomOffset,
                                block.topOffset,
                                block.maximum))).squared()
                .count(block.maxPerChunk);
    }
}