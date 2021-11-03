package xyz.starmun.stardust;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.starmun.stardust.data.Properties;
import xyz.starmun.stardust.platform.contracts.BlockRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.PathExpectPlatform;
import xyz.starmun.stardust.data.CustomOre;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.stream.Stream;

public class Stardust {
    public static final String MOD_ID = "stardust";
    public static final String MOD_NAME = "Stardust";
    private static final String JSON = ".json";
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
    public static void init() {
        LOGGER.info("Loading Custom Ores...");
        try (Stream<Path> stream = Files.walk(PathExpectPlatform.getConfigPath())) {
            stream.filter(f -> f.getFileName().toString().endsWith(JSON)).forEach(Stardust::addOre);
        } catch (IOException e) {
            LOGGER.error("Ore stream failed.", e);
        }
    }
    public static void addOre(Path path){
        File file = path.toFile();
        try {
            String name = file.getName();
            name = name.substring(0, name.indexOf('.'));
            Reader reader = Files.newBufferedReader(file.toPath());
            name = name.toLowerCase(Locale.ENGLISH).replace(" ", "_");
            parseOre(reader, name);
        } catch (IOException e) {
            LOGGER.error("File parse failed, file not found.");
        }
    }
    private static void parseOre(Reader reader, String name) {
        Gson gson = new Gson();
        try {
            CustomOre ore = gson.fromJson(reader, CustomOre.class);
           BlockRegistryExpectPlatform.Register(new Properties(ore.getName()));
            LOGGER.info(ore.getName());
        } catch (JsonSyntaxException e) {
            String exception = String.format("Error occurred parsing the ore: %s, invalid JSON.", name);
            throw new JsonSyntaxException(exception);
        }
    }
}
