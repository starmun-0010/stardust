package xyz.starmun.stardust.data.generators;

import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import xyz.starmun.stardust.constants.StardustPaths;
import xyz.starmun.stardust.datamodels.Material;
import xyz.starmun.stardust.utils.FilesUtils;
import xyz.starmun.stardust.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class VariantsConfigGenerator implements DataProvider {

    @Override
    public String getName() {
        return "Default Strata Generator";
    }

    @Override
    public void run(HashCache hashCache) {
        List<Material.Variant> variants = new ArrayList<Material.Variant>(){{
            add(Material.Variant.Builder.instance().setNameSuffix("gear").build());
            add(Material.Variant.Builder.instance().setNameSuffix("nugget").build());
            add(Material.Variant.Builder.instance().setNameSuffix("plate").build());
            add(Material.Variant.Builder.instance().setNameSuffix("rod").build());
            add(Material.Variant.Builder.instance().setNameSuffix("wire").build());
            add(Material.Variant.Builder.instance().setNameSuffix("ore")
                    .setRegistrationType(Material.Variant.RegistrationType.BlockItem)
                    .setGenerateInWorld(true)
                    .setBottomOffset(3)
                    .setTopOffset(3)
                    .setMaximum(225)
                    .setMaxVeinSize(16)
                    .setMaxPerChunk(64)
                    .build());
           }};
        variants.forEach(item -> {
            JsonUtils.serializeToJson(item, Material.Variant.CODEC).ifPresent(jsonElement->
                    FilesUtils.saveJsonFile(StardustPaths.DataGen.DEFAULT_ITEMS_FILES_GENERATION_PATH
                            + item.getIdSuffix(), jsonElement, hashCache));
        });
    }
}
