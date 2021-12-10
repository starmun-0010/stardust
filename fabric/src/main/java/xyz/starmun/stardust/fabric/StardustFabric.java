package xyz.starmun.stardust.fabric;

import xyz.starmun.stardust.Stardust;
import net.fabricmc.api.ModInitializer;

public class StardustFabric implements ModInitializer {
    @Override
    public void onInitialize() {

        Stardust.init();
    }

}
