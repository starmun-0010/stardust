package xyz.starmun.stardust.data.generators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import net.minecraft.data.HashCache;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.constants.StardustPaths;
import xyz.starmun.stardust.datamodels.Ore;
import xyz.starmun.stardust.utils.FilesUtil;

import java.util.ArrayList;
import java.util.List;

public class OreConfigGenerator extends DataProviderBase {

    @Override
    public void run(HashCache hashCache) {
        List<Ore> ores = new ArrayList<Ore>(){{
            add(Ore.builder
                    .setId("iron")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.builder
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

        }};
        ores.forEach(ore -> {
            JsonOps.INSTANCE.withEncoder(Ore.CODEC)
                    .apply(ore)
                    .mapError(OreConfigGenerator::onError)
                    .result()
                    .ifPresent(jsonElement->
                            FilesUtil.saveJsonFile(StardustPaths.DataGen.DEFAULT_ORE_FILES_GENERATION_PATH + ore.id, jsonElement, hashCache));
        });
    }

    private static String onError(String error) {
        Stardust.LOGGER.error(error);
        return error;
    }

    @Override
    public String getName() {
        return "Default Ores";
    }
}
