package xyz.starmun.stardust.platform.contracts.forge;

import net.minecraftforge.fml.loading.FMLPaths;
import xyz.starmun.stardust.Stardust;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExpectPlatformImpl {
    public static Path getConfigPath(){
        return Paths.get(FMLPaths.CONFIGDIR.get().toString(), Stardust.MOD_ID, "ores");
    }
}
