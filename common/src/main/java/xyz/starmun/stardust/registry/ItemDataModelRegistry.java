package xyz.starmun.stardust.registry;

import org.apache.commons.lang3.tuple.Pair;
import xyz.starmun.stardust.datamodels.DynamicItemModel;
import xyz.starmun.stardust.platform.contracts.PathExpectPlatform;
import xyz.starmun.stardust.utils.FilesUtil;
import xyz.starmun.stardust.utils.JsonUtil;

import java.io.File;
import java.io.Reader;
import java.util.HashMap;

import static xyz.starmun.stardust.Stardust.LOGGER;

public class ItemDataModelRegistry {
    public static HashMap<String, DynamicItemModel> REGISTERED_ITEM_MODEL = new HashMap<>();
    public static HashMap<String, DynamicItemModel> register(){
        LOGGER.info("Loading dynamic item models...");
        FilesUtil.crawlJsonFiles(PathExpectPlatform.getDynamicItemsConfigPath())
                .forEach((file)->{
                    Pair<File, Reader> pair = FilesUtil.loadFile(file);
                    registerItemModel(JsonUtil.parseJson(pair.getRight(), pair.getLeft().getName(), DynamicItemModel.class));
                });
        LOGGER.info("Loaded dynamic item models!");
        return REGISTERED_ITEM_MODEL;
    }

    private static void registerItemModel(DynamicItemModel dynamicItemModel) {
        REGISTERED_ITEM_MODEL.put(dynamicItemModel.getName(),  dynamicItemModel);
    }
}
