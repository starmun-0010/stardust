package xyz.starmun.stardust.utils;

import xyz.starmun.stardust.datamodels.Material;
import xyz.starmun.stardust.datamodels.Properties;

public class PropertiesUtil {
    public static Properties assignProperties(Material material, Material.Item item) {
        Properties properties =new Properties(material.getId()+"_"+item.getIdSuffix()){{

        }};
        if(item.getGenerateInWorld()){
            properties.bottomOffset = item.getBottomOffset();
            properties.maximum = item.getMaximum();
            properties.maxPerChunk = item.getMaxPerChunk();
            properties.maxVeinSize = item.getMaxVeinSize();
            properties.topOffset = item.getTopOffset();
            properties.maxPerChunk = item.getMaxPerChunk();
        }
        return properties;
    }
}
