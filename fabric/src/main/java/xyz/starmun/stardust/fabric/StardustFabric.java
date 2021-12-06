package xyz.starmun.stardust.fabric;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import xyz.starmun.stardust.Stardust;
import net.fabricmc.api.ModInitializer;

public class StardustFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Stardust.init();
    }
}
