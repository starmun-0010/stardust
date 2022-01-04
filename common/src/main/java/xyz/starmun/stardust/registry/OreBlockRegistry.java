package xyz.starmun.stardust.registry;

import net.minecraft.world.item.Item;
import org.apache.commons.lang3.tuple.Pair;
import xyz.starmun.stardust.blocks.StardustOreBlock;
import xyz.starmun.stardust.datamodels.Properties;
import xyz.starmun.stardust.datamodels.StardustOreModel;
import xyz.starmun.stardust.platform.contracts.BlockRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.ItemRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.PathExpectPlatform;
import xyz.starmun.stardust.utils.FilesUtil;
import xyz.starmun.stardust.utils.JsonUtil;

import java.io.File;
import java.io.Reader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static xyz.starmun.stardust.Stardust.LOGGER;

public class OreBlockRegistry {
    private static final String JSON = ".json";
    public static final HashMap<String,StardustOreBlock> REGISTERED_ORE_BLOCKS = new HashMap<>();
    public static final Set<Item> REGISTERED_ORE_ITEMS = new HashSet<>();
    public static HashMap<String, StardustOreBlock> register(){
        LOGGER.info("Loading Custom Ores...");
        FilesUtil.loadJsonFiles(PathExpectPlatform.getOresConfigPath())
                .forEach((file)->{
                    Pair<File,Reader> pair = FilesUtil.readFile(file);
                    registerOre(JsonUtil.parseJson(pair.getRight(), pair.getLeft().getName(),StardustOreModel.class));
                });
        LOGGER.info("Loaded Custom Ores!");
        return REGISTERED_ORE_BLOCKS;
    }

    private static <T> void registerOre(StardustOreModel ore) {
        StardustOreBlock block = (StardustOreBlock) BlockRegistryExpectPlatform.register(new Properties(ore.getName()));
        REGISTERED_ORE_BLOCKS.put(ore.getName(), block);
        REGISTERED_ORE_ITEMS.add(ItemRegistryExpectPlatform.register(ore.getName(), block));
    }
}
