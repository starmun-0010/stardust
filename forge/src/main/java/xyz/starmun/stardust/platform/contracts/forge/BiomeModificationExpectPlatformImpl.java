package xyz.starmun.stardust.platform.contracts.forge;

import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class BiomeModificationExpectPlatformImpl {
    protected static ArrayList<ConfiguredFeature<?, ?>> configuredFeatures = new ArrayList<>();
    public static void addOreFeature(ConfiguredFeature<?,?> configuredFeature){
        configuredFeatures.add(configuredFeature);
    }
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void biomeLoadingHandler(BiomeLoadingEvent event) {
        BiomeModificationExpectPlatformImpl.configuredFeatures.forEach(feature-> event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, feature));
    }
}
