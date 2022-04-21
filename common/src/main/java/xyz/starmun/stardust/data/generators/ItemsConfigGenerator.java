package xyz.starmun.stardust.data.generators;

import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import xyz.starmun.stardust.constants.StardustPaths;
import xyz.starmun.stardust.datamodels.Ore;
import xyz.starmun.stardust.utils.FilesUtils;
import xyz.starmun.stardust.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class ItemsConfigGenerator implements DataProvider {

    @Override
    public String getName() {
        return "Default Strata Generator";
    }

    @Override
    public void run(HashCache hashCache) {
        List<Ore.Item> items = new ArrayList<Ore.Item>(){{
            add(Ore.Item.Builder.instance().setNameSuffix("gear").build());
            add(Ore.Item.Builder.instance().setNameSuffix("nugget").build());
            add(Ore.Item.Builder.instance().setNameSuffix("plate").build());
            add(Ore.Item.Builder.instance().setNameSuffix("rod").build());
            add(Ore.Item.Builder.instance().setNameSuffix("wire").build());
            add(Ore.Item.Builder.instance().setNameSuffix("ore")
                    .setRegistrationType(Ore.Item.RegistrationType.BlockItem)
                    .setGenerateInWorld(true)
                    .setBottomOffset(3)
                    .setTopOffset(3)
                    .setMaximum(225)
                    .setMaxVeinSize(16)
                    .setMaxPerChunk(64)
                    .build());
           }};
        items.forEach(item -> {
            JsonUtils.serializeToJson(item, Ore.Item.CODEC).ifPresent(jsonElement->
                    FilesUtils.saveJsonFile(StardustPaths.DataGen.DEFAULT_ITEMS_FILES_GENERATION_PATH
                            + item.getIdSuffix(), jsonElement, hashCache));
        });
    }
}
