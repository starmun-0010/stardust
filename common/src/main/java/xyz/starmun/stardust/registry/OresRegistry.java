package xyz.starmun.stardust.registry;

import org.apache.commons.lang3.tuple.Pair;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.blocks.StateBasedOreBlock;
import xyz.starmun.stardust.datamodels.Ore;
import xyz.starmun.stardust.datamodels.Properties;
import xyz.starmun.stardust.item.StardustItem;
import xyz.starmun.stardust.platform.contracts.BlockRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.ItemRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.ModelRegistryExpectPlatform;
import xyz.starmun.stardust.platform.contracts.PathExpectPlatform;
import xyz.starmun.stardust.utils.ColorsUtil;
import xyz.starmun.stardust.utils.FilesUtils;
import xyz.starmun.stardust.utils.JsonUtils;
import xyz.starmun.stardust.utils.PropertiesUtil;

import java.io.File;
import java.io.Reader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static xyz.starmun.stardust.Stardust.LOGGER;

public class OresRegistry {
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
                    registerDynamicOreItems(JsonUtils.parseJson(pair.getRight(), Ore.CODEC));
                });
        LOGGER.info("Loaded Custom Ores!");
        return REGISTERED_ORE_BLOCKS;
    }

    private static void registerDynamicOreItems(Ore ore) {
            ore.getItems().forEach((s, dynamicItem) ->{
            if(dynamicItem.getRegistrationType() != Ore.Item.RegistrationType.Item){
                Properties properties = PropertiesUtil.assignProperties(ore, dynamicItem);
                StateBasedOreBlock block = (StateBasedOreBlock) BlockRegistryExpectPlatform.register(properties);
                REGISTERED_ORE_BLOCKS.put(ore.getId(), block);
                if(dynamicItem.getRegistrationType()== Ore.Item.RegistrationType.BlockItem){
                    block.dropSelf = dynamicItem.getDropSelf();
                    REGISTERED_ORE_ITEMS.add(ItemRegistryExpectPlatform.register(ore.getId(), block));
                }
           }
           else {
                StardustItem item = ItemRegistryExpectPlatform.register(ore.getId()+"_"+dynamicItem.getIdSuffix());
                ColorsUtil.assignColors(ore, dynamicItem, item);
                REGISTERED_DYNAMIC_ITEMS.put(ore.getId()+"_"+dynamicItem.getIdSuffix(), item);
                ModelRegistryExpectPlatform.register(Stardust.MOD_ID+":"+"item/"+dynamicItem.getIdSuffix());
            }
        });
    }




}