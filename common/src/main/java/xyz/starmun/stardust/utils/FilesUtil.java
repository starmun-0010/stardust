package xyz.starmun.stardust.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.commons.lang3.tuple.Pair;
import xyz.starmun.stardust.platform.contracts.PathExpectPlatform;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.function.Consumer;
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
    public static Path getIntellijProjectRootPath(){
        return Paths.get(".").normalize().toAbsolutePath().getParent().toAbsolutePath();
    }
    public static List<Path> loadJsonFiles(Path directory){
        //PathExpectPlatform.getOresConfigPath()
        try (Stream<Path> stream = Files.walk(directory)) {
            return stream.filter(f -> f.getFileName().toString().endsWith(JSON)).collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("Ore stream failed.", e);
        }
        return null;
    }
    public static Pair<File,Reader> readFile(Path filePath){
        File file = null;
        try {
            file = filePath.toFile();
            return Pair.of(file, Files.newBufferedReader(file.toPath()));
        } catch (Exception e) {
            LOGGER.error("Ore file load failed: " + (file == null ? "" : file.getName()));
        }
        return null;
    }
}
