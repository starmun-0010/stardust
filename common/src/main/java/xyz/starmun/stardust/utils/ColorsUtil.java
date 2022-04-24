package xyz.starmun.stardust.utils;

import xyz.starmun.stardust.blocks.StrataBasedStateBlock;
import xyz.starmun.stardust.datamodels.Material;
import xyz.starmun.stardust.item.StardustItem;

public class ColorsUtil {
    public static void assignColors(Material material, Material.Item dynamicItemModel, StardustItem item) {
        if (material.getItems().containsKey(dynamicItemModel.getIdSuffix())) {
            item.colors = material.getItems().get(dynamicItemModel.getIdSuffix()).getColors().toArray(new String[0]);
        } else if (material.getColors() != null) {
            item.colors = material.getColors().toArray(new String[0]);
        } else if (dynamicItemModel.getColors() != null) {
            item.colors = dynamicItemModel.getColors().toArray(new String[0]);
        }
    }

    public static void assignColors(Material material, Material.Item dynamicItemModel, StrataBasedStateBlock item) {
        if (material.getItems().containsKey(dynamicItemModel.getIdSuffix())) {
            item.colors = material.getItems().get(dynamicItemModel.getIdSuffix()).getColors().toArray(new String[0]);
        } else if (material.getColors() != null) {
            item.colors = material.getColors().toArray(new String[0]);
        } else if (dynamicItemModel.getColors() != null) {
            item.colors = dynamicItemModel.getColors().toArray(new String[0]);
        }
    }
}