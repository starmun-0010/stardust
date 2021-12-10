package xyz.starmun.stardust.registry;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import net.minecraft.world.level.block.Block;
import xyz.starmun.stardust.datamodels.StardustOreModel;
import xyz.starmun.stardust.datamodels.Properties;
import xyz.starmun.stardust.platform.contracts.BlockRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.ItemRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.PathExpectPlatform;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static xyz.starmun.stardust.Stardust.LOGGER;

public class OreBlockRegistry {
    private static final String JSON = ".json";
    public static final Set<Block> REGISTERED_ORE_BLOCKS = new HashSet<>();
    public static Set<Block> register(){
        LOGGER.info("Loading Custom Ores...");
        crawlOreFiles();
        LOGGER.info("Loaded Custom Ores!");
        return REGISTERED_ORE_BLOCKS;
    }
    private static void crawlOreFiles(){

        try (Stream<Path> stream = Files.walk(PathExpectPlatform.getOresConfigPath())) {
            stream.filter(f -> f.getFileName().toString().endsWith(JSON)).forEach(OreBlockRegistry::loadFile);
        } catch (IOException e) {
            LOGGER.error("Ore stream failed.", e);
        }
    }
    public static void loadFile(Path path){
        File file = path.toFile();
        try {
            Reader reader = Files.newBufferedReader(file.toPath());
            registerOre(reader, file.getName());
        } catch (IOException e) {
            LOGGER.error("Ore file load failed: "+ file.getName());
        }
    }
    private static void registerOre(Reader reader, String fileName) {
        Gson gson = new Gson();
        try {
            StardustOreModel ore = gson.fromJson(reader, StardustOreModel.class);
            Block block = BlockRegistryExpectPlatform.register(new Properties(ore.getName()));
            REGISTERED_ORE_BLOCKS.add(block);
            ItemRegistryExpectPlatform.register(fileName, block);
        } catch (JsonSyntaxException e) {
            LOGGER.error(String.format("Error occurred parsing the ore file: %s, invalid syntax.", fileName));
        }
    }
}
