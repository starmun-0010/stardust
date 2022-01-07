package xyz.starmun.stardust.utils;

import org.apache.commons.lang3.tuple.Pair;
import xyz.starmun.stardust.platform.contracts.PathExpectPlatform;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static xyz.starmun.stardust.Stardust.LOGGER;

public final class FilesUtil{
    private FilesUtil(){

    }
    private static final String JSON = ".json";
    public static Path getStardustModJarResourcesPath(){
        return PathExpectPlatform.getStardustModJarResourcesPath();
    }
    public static Path getIntellijProjectRootPath(){ return Paths.get(".").normalize().toAbsolutePath().getParent().toAbsolutePath(); }
    public static List<Path> crawlJsonFiles(Path directory){
        try (Stream<Path> stream = Files.find(directory,Integer.MAX_VALUE,(path,attributes) ->
                attributes.isRegularFile() && path.toString().toLowerCase(Locale.ROOT).endsWith(JSON))) {
            return stream.collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("Files crawl failed.", e);
        }
        return null;
    }
    public static Pair<File,Reader> loadFile(Path filePath){
        File file = null;
        try {
            file = filePath.toFile();
            return Pair.of(file, Files.newBufferedReader(file.toPath()));
        } catch (Exception e) {
            LOGGER.error("File load failed: " + (file == null ? "" : file.getName()));
        }
        return null;
    }
}
