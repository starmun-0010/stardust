package xyz.starmun.stardust.registry;

import org.apache.commons.lang3.tuple.Pair;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.blocks.StateBasedOreBlock;
import xyz.starmun.stardust.datamodels.DynamicItemModel;
import xyz.starmun.stardust.datamodels.Properties;
import xyz.starmun.stardust.datamodels.Ore;
import xyz.starmun.stardust.item.StardustItem;
import xyz.starmun.stardust.platform.contracts.BlockRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.ItemRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.ModelRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.PathExpectPlatform;
import xyz.starmun.stardust.utils.FilesUtils;
import xyz.starmun.stardust.utils.JsonUtils;

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
        FilesUtils.crawlJsonFiles(PathExpectPlatform.getOresConfigPath())
                .forEach((file)->{
                    Pair<File,Reader> pair = FilesUtils.loadFile(file);
                    if(pair == null){
                        Stardust.LOGGER.error("Could not load ore configuration file for "+file.toString());
                        return;
                    }
                    registerOre(JsonUtils.parseJson(pair.getRight(), Ore.CODEC));
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
            assignColors(ore, dynamicItemModel, item);
            item.name = dynamicItemModel.getName();

            REGISTERED_DYNAMIC_ITEMS.put(name+"_"+dynamicItemModel.getName(), item);
            ModelRegistryExpectPlatform.register(Stardust.MOD_ID+":"+"item/"+dynamicItemModel.getName());
        });
    }

    private static void assignColors(Ore ore, DynamicItemModel dynamicItemModel, StardustItem item) {
        if(ore.getItems().containsKey(dynamicItemModel.getName())){
            item.colors = ore.getItems().get(dynamicItemModel.getName()).getColor().toArray(new String[0]);
        }
        else if(ore.getColors()!=null){
            item.colors = ore.getColors().toArray(new String[0]);
        }
        else if(dynamicItemModel.getColor()!=null){
            item.colors = dynamicItemModel.getColor();
        }
    }
}
