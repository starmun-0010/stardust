package xyz.starmun.stardust.utils;

import xyz.starmun.stardust.constants.StardustPaths;
import xyz.starmun.stardust.platform.contracts.PathExpectPlatform;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public final class FilesUtil {
    private FilesUtil(){}
    public static Path getStardustModJarResourcesPath(){
        return PathExpectPlatform.getStardustModJarResourcesPath();
    }
    public static Path getIntellijProjectRootPath(){
        return Paths.get(".").normalize().toAbsolutePath().getParent().toAbsolutePath();
    }

    public static void writeJsonFile(String path, String json) {
        try {
            Files.createDirectories(Paths.get(path).getParent());
            Files.write(Paths.get(path), json.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
