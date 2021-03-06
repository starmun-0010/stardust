package xyz.starmun.stardust.platform.contracts.forge;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLPaths;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.constants.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathExpectPlatformImpl {
    public static Path getConfigPath() throws IOException {
        try {
            return Files.createDirectories(FMLPaths.CONFIGDIR.get().resolve(Stardust.MOD_ID));
        } catch (IOException exception) {
            Stardust.LOGGER.error("Error occurred trying to create config directory.");
            throw new IOException();
        }
    }

    public static Path getOresConfigPath() throws IOException {
        try {
            return Files.createDirectories(FMLPaths.CONFIGDIR.get().resolve(Stardust.MOD_ID).resolve(Constants.MATERIALS_DIRECTORY));
        } catch (IOException exception) {
            Stardust.LOGGER.error("Error occurred trying to create config directory.");
            throw new IOException();
        }
    }

    public static Path getStonesConfigPath() throws IOException {
        try {
            return Files.createDirectories(FMLPaths.CONFIGDIR.get().resolve(Stardust.MOD_ID).resolve(Constants.STONES_DIRECTORY));
        } catch (IOException exception) {
            Stardust.LOGGER.error("Error occurred trying to create config directory.");
            throw new IOException();
        }
    }

    public static Path getStardustModJarResourcesPath() {
        return ModList.get().getModFileById(Stardust.MOD_ID).getFile().getFilePath();
    }

    public static Path getDynamicItemsConfigPath() throws IOException {
        try {
            return Files.createDirectories(FMLPaths.CONFIGDIR.get().resolve(Stardust.MOD_ID).resolve(Constants.DYNAMIC_VARIANTS_DIRECTORY));
        } catch (IOException exception) {
            Stardust.LOGGER.error("Error occurred trying to create config directory.");
            throw new IOException();
        }
    }
}
