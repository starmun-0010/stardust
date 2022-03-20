package xyz.starmun.stardust.registry;

import org.apache.commons.lang3.tuple.Pair;
import xyz.starmun.stardust.datamodels.Ore;
import xyz.starmun.stardust.platform.contracts.PathExpectPlatform;
import xyz.starmun.stardust.utils.FilesUtils;
import xyz.starmun.stardust.utils.JsonUtils;

import java.io.File;
import java.io.Reader;
import java.util.HashMap;

import static xyz.starmun.stardust.Stardust.LOGGER;

public class ItemsRegistry {
    public static HashMap<String, Ore.Item> REGISTERED_ITEM_MODEL = new HashMap<>();
    public static HashMap<String, Ore.Item> register(){
        LOGGER.info("Loading dynamic item models...");
        FilesUtils.crawlJsonFiles(PathExpectPlatform.getDynamicItemsConfigPath())
                .forEach((file)->{
                    Pair<File, Reader> pair = FilesUtils.loadFile(file);
                    registerItemModel(JsonUtils.parseJson(pair.getRight(),Ore.Item.CODEC));
                });
        LOGGER.info("Loaded dynamic item models!");
        return REGISTERED_ITEM_MODEL;
    }

    private static void registerItemModel(Ore.Item dynamicItemModel) {
        REGISTERED_ITEM_MODEL.put(dynamicItemModel.getIdSuffix(),  dynamicItemModel);
    }
}
