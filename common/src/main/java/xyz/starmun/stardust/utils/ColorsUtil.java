package xyz.starmun.stardust.utils;

import xyz.starmun.stardust.blocks.StateBasedOreBlock;
import xyz.starmun.stardust.datamodels.Ore;
import xyz.starmun.stardust.item.StardustItem;

public class ColorsUtil {
    public static void assignColors(Ore ore, Ore.Item dynamicItemModel, StardustItem item) {
        if (ore.getItems().containsKey(dynamicItemModel.getIdSuffix())) {
            item.colors = ore.getItems().get(dynamicItemModel.getIdSuffix()).getColors().toArray(new String[0]);
        } else if (ore.getColors() != null) {
            item.colors = ore.getColors().toArray(new String[0]);
        } else if (dynamicItemModel.getColors() != null) {
            item.colors = dynamicItemModel.getColors().toArray(new String[0]);
        }
    }

    public static void assignColors(Ore ore, Ore.Item dynamicItemModel, StateBasedOreBlock item) {
        if (ore.getItems().containsKey(dynamicItemModel.getIdSuffix())) {
            item.colors = ore.getItems().get(dynamicItemModel.getIdSuffix()).getColors().toArray(new String[0]);
        } else if (ore.getColors() != null) {
            item.colors = ore.getColors().toArray(new String[0]);
        } else if (dynamicItemModel.getColors() != null) {
            item.colors = dynamicItemModel.getColors().toArray(new String[0]);
        }
    }
}