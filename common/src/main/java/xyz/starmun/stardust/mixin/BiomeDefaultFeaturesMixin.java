package xyz.starmun.stardust.mixin;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BiomeDefaultFeatures.class)
public class BiomeDefaultFeaturesMixin {
    @Inject(method = "addDefaultOres",at = @At("HEAD"), cancellable = true)
    private static void addDefaultOres(BiomeGenerationSettings.Builder builder, CallbackInfo ci){
        ci.cancel();
    }
}
