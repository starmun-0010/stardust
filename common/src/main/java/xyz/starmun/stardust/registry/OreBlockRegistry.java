package xyz.starmun.stardust.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.apache.commons.lang3.tuple.Pair;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.blocks.StateBasedOreBlock;
import xyz.starmun.stardust.datamodels.Properties;
import xyz.starmun.stardust.datamodels.StardustOreModel;
import xyz.starmun.stardust.platform.contracts.BlockRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.ItemRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.ModelRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.PathExpectPlatform;
import xyz.starmun.stardust.utils.FilesUtil;
import xyz.starmun.stardust.utils.JsonUtil;

import java.io.File;
import java.io.Reader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static xyz.starmun.stardust.Stardust.LOGGER;

public class OreBlockRegistry {
    private static final String JSON = ".json";
    public static final HashMap<String, StateBasedOreBlock> REGISTERED_ORE_BLOCKS = new HashMap<>();
    public static final Set<Item> REGISTERED_ORE_ITEMS = new HashSet<>();
    public static final Map<String, Item> REGISTERED_DYNAMIC_ITEMS = new HashMap<>();
    public static HashMap<String, StateBasedOreBlock> register(){
        LOGGER.info("Loading Custom Ores...");
        FilesUtil.crawlJsonFiles(PathExpectPlatform.getOresConfigPath())
                .forEach((file)->{
                    Pair<File,Reader> pair = FilesUtil.loadFile(file);
                    registerOre(JsonUtil.parseJson(pair.getRight(), pair.getLeft().getName(),StardustOreModel.class));
                });
        LOGGER.info("Loaded Custom Ores!");
        return REGISTERED_ORE_BLOCKS;
    } 

    private static <T> void registerOre(StardustOreModel ore) {
        StateBasedOreBlock block = (StateBasedOreBlock) BlockRegistryExpectPlatform.register(new Properties(ore.getName()));
        REGISTERED_ORE_BLOCKS.put(ore.getName(), block);
        REGISTERED_ORE_ITEMS.add(ItemRegistryExpectPlatform.register(ore.getName(), block));
        registerDynamicOreItems(ore.getName());
    }

    private static void registerDynamicOreItems(String name) {
        ItemDataModelRegistry.REGISTERED_ITEM_MODEL.forEach((s, dynamicItemModel) ->{
            Item item = ItemRegistryExpectPlatform.register(name+"_"+dynamicItemModel.getName());
            REGISTERED_DYNAMIC_ITEMS.put(name+"_"+dynamicItemModel.getName(), item);
            ModelRegistryExpectPlatform.register(Stardust.MOD_ID+":"+"item/"+dynamicItemModel.getName());
        });
    }
}
