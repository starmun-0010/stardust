package xyz.starmun.stardust.platform.contracts.fabric;

import net.fabricmc.loader.api.FabricLoader;
import xyz.starmun.stardust.Stardust;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathExpectPlatformImpl {
    public static Path getConfigPath() {
        try {
            Files.createDirectories(FabricLoader.getInstance().getConfigDir().resolve(Stardust.MOD_ID).resolve("ores"));
        }
        catch (IOException exception){

        }
        return FabricLoader.getInstance().getConfigDir().resolve(Stardust.MOD_ID).resolve("ores");
    }
}
