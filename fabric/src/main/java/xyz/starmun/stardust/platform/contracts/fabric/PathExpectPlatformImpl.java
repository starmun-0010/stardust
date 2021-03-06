package xyz.starmun.stardust.platform.contracts.fabric;

import net.fabricmc.loader.api.FabricLoader;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.constants.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathExpectPlatformImpl {
    public static Path getConfigPath() throws IOException {
        try {
            return Files.createDirectories(FabricLoader.getInstance().getConfigDir().resolve(Stardust.MOD_ID));
        }
        catch (IOException exception){
            Stardust.LOGGER.error("Error occurred trying to create config directory.");
            throw new IOException();
        }
    }
    public static Path getOresConfigPath() throws IOException {
        try {
           return Files.createDirectories(FabricLoader.getInstance().getConfigDir().resolve(Stardust.MOD_ID).resolve(Constants.MATERIALS_DIRECTORY));
        }
        catch (IOException exception){
            Stardust.LOGGER.error("Error occurred trying to create config directory.");
            throw new IOException();
        }
    }
    public static Path getStonesConfigPath() throws IOException {
        try {
            return Files.createDirectories(FabricLoader.getInstance().getConfigDir().resolve(Stardust.MOD_ID).resolve(Constants.STONES_DIRECTORY));
        }
        catch (IOException exception){
            Stardust.LOGGER.error("Error occurred trying to create config directory.");
            throw new IOException();
        }
    }

    public static Path getStardustModJarResourcesPath() {
        //noinspection OptionalGetWithoutIsPresent
        return FabricLoader.getInstance().getModContainer(Stardust.MOD_ID).get().getRootPath();
    }
    public static Path getDynamicItemsConfigPath() throws IOException {
        try {
            return Files.createDirectories(FabricLoader.getInstance().getConfigDir().resolve(Stardust.MOD_ID).resolve(Constants.DYNAMIC_VARIANTS_DIRECTORY));
        }
        catch (IOException exception){
            Stardust.LOGGER.error("Error occurred trying to create config directory.");
            throw new IOException();
        }
    }

}
