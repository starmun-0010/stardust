package xyz.starmun.stardust.registry;

import org.apache.commons.lang3.tuple.Pair;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.blocks.StateBasedOreBlock;
import xyz.starmun.stardust.datamodels.Properties;
import xyz.starmun.stardust.datamodels.Ore;
import xyz.starmun.stardust.item.StardustItem;
import xyz.starmun.stardust.platform.contracts.BlockRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.ItemRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.ModelRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.PathExpectPlatform;
import xyz.starmun.stardust.utils.FilesUtil;
import xyz.starmun.stardust.utils.JsonUtil;

import java.io.File;
import java.io.Reader;
import java.util.*;

import static xyz.starmun.stardust.Stardust.LOGGER;

public class OreBlockRegistry {
    public static final HashMap<String, StateBasedOreBlock> REGISTERED_ORE_BLOCKS = new HashMap<>();
    public static final Set<net.minecraft.world.item.Item> REGISTERED_ORE_ITEMS = new HashSet<>();
    public static final Map<String, StardustItem> REGISTERED_DYNAMIC_ITEMS = new HashMap<>();
    public static HashMap<String, StateBasedOreBlock> register(){
        LOGGER.info("Loading Custom Ores...");
        FilesUtil.crawlJsonFiles(PathExpectPlatform.getOresConfigPath())
                .forEach((file)->{
                    Pair<File,Reader> pair = FilesUtil.loadFile(file);
                    registerOre(JsonUtil.parseJson(pair.getRight(), Ore.CODEC));
                });
        LOGGER.info("Loaded Custom Ores!");
        return REGISTERED_ORE_BLOCKS;
    } 

    private static <T> void registerOre(Ore ore) {
        StateBasedOreBlock block = (StateBasedOreBlock) BlockRegistryExpectPlatform.register(new Properties(ore.getId()));
        REGISTERED_ORE_BLOCKS.put(ore.getId(), block);
        REGISTERED_ORE_ITEMS.add(ItemRegistryExpectPlatform.register(ore.getId(), block));
        registerDynamicOreItems(ore.getId(),ore);
    }

    private static void registerDynamicOreItems(String name,  Ore ore) {
        ItemDataModelRegistry.REGISTERED_ITEM_MODEL.forEach((s, dynamicItemModel) ->{
            StardustItem item = ItemRegistryExpectPlatform.register(name+"_"+dynamicItemModel.getName());
            if(ore.getItems().containsKey(dynamicItemModel.getName())){
                item.colors = ore.getItems().get(dynamicItemModel.getName()).getColor().toArray(new String[0]);
            }
            else {
                item.colors = ore.getColors().toArray(new String[0]);
            }
            item.name = dynamicItemModel.getName();
            REGISTERED_DYNAMIC_ITEMS.put(name+"_"+dynamicItemModel.getName(), item);
            ModelRegistryExpectPlatform.register(Stardust.MOD_ID+":"+"item/"+dynamicItemModel.getName());
        });
    }
}
