package xyz.starmun.stardust.utils;

import xyz.starmun.stardust.datamodels.Material;
import xyz.starmun.stardust.datamodels.Properties;

public class PropertiesUtil {
    public static Properties assignProperties(Material material, Material.Variant variant) {
        Properties properties =new Properties(material.getId()+"_"+ variant.getIdSuffix()){{

        }};
        if(variant.getGenerateInWorld()){
            properties.bottomOffset = variant.getBottomOffset();
            properties.maximum = variant.getMaximum();
            properties.maxPerChunk = variant.getMaxPerChunk();
            properties.maxVeinSize = variant.getMaxVeinSize();
            properties.topOffset = variant.getTopOffset();
            properties.maxPerChunk = variant.getMaxPerChunk();
        }
        return properties;
    }
}
