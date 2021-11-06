package xyz.starmun.stardust.platform.contracts.forge;

import net.minecraftforge.fml.loading.FMLPaths;
import xyz.starmun.stardust.Stardust;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathExpectPlatformImpl {
    public static Path getConfigPath(){
        try {
            Files.createDirectories(FMLPaths.CONFIGDIR.get().resolve(Stardust.MOD_ID).resolve("ores"));
        }
        catch (IOException exception){

        }
        return FMLPaths.CONFIGDIR.get().resolve(Stardust.MOD_ID).resolve("ores");
    }
}
