package xyz.starmun.stardust.utils;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import xyz.starmun.stardust.Stardust;

public class ResourceKeyUtil {
    public static ResourceKey<?> getConfigureFeatureKey(String id){
        return ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY,
                new ResourceLocation(Stardust.MOD_ID, "ore_wool_overworld"));
    }
}
