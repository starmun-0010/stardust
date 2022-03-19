package xyz.starmun.stardust.utils;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import org.apache.commons.lang3.tuple.Pair;
import xyz.starmun.stardust.data.generators.DataGeneratorsCore;
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

public final class FilesUtils {
    private FilesUtils(){

    }
    public static final String JSON_FILE_EXTENSION = ".json";
    public static Path getStardustModJarResourcesPath(){
        return PathExpectPlatform.getStardustModJarResourcesPath();
    }
    public static Path getIntellijProjectRootPath(){ return Paths.get(".").normalize().toAbsolutePath().getParent().toAbsolutePath(); }
    public static List<Path> crawlJsonFiles(Path directory){
        try (Stream<Path> stream = Files.find(directory,Integer.MAX_VALUE,(path,attributes) ->
                attributes.isRegularFile() && path.toString().toLowerCase(Locale.ROOT).endsWith(JSON_FILE_EXTENSION))) {
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
    public static void saveJsonFile(String path, JsonElement jsonElement, HashCache hashCache) {
        try {
            DataProvider.save(new GsonBuilder().setPrettyPrinting().create(),
                    hashCache,
                    jsonElement,
                    Paths.get(DataGeneratorsCore.dataGenerator.getOutputFolder().toString(),
                          path + FilesUtils.JSON_FILE_EXTENSION));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
