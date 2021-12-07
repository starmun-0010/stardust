package xyz.starmun.stardust;

import net.minecraft.world.level.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.starmun.stardust.registry.RegistryCore;

public class Stardust {
    public static final String MOD_ID = "stardust";
    public static final String MOD_NAME = "Stardust";
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
    public static void init() {
        RegistryCore.registerAll();
    }

}
