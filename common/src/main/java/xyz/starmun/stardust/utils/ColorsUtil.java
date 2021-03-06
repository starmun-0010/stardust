package xyz.starmun.stardust.utils;

import xyz.starmun.stardust.blocks.StrataBasedStateBlock;
import xyz.starmun.stardust.datamodels.Material;
import xyz.starmun.stardust.item.StardustItem;

public class ColorsUtil {
    public static void assignColors(Material material, Material.Variant dynamicVariantModel, StardustItem item) {
        if (material.getItems().containsKey(dynamicVariantModel.getIdSuffix())) {
            item.colors = material.getItems().get(dynamicVariantModel.getIdSuffix()).getColors().toArray(new String[0]);
        } else if (material.getColors() != null) {
            item.colors = material.getColors().toArray(new String[0]);
        } else if (dynamicVariantModel.getColors() != null) {
            item.colors = dynamicVariantModel.getColors().toArray(new String[0]);
        }
    }

    public static void assignColors(Material material, Material.Variant dynamicVariantModel, StrataBasedStateBlock item) {
        if (material.getItems().containsKey(dynamicVariantModel.getIdSuffix())) {
            item.colors = material.getItems().get(dynamicVariantModel.getIdSuffix()).getColors().toArray(new String[0]);
        } else if (material.getColors() != null) {
            item.colors = material.getColors().toArray(new String[0]);
        } else if (dynamicVariantModel.getColors() != null) {
            item.colors = dynamicVariantModel.getColors().toArray(new String[0]);
        }
    }
}