package xyz.starmun.stardust.data.generators;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.constants.StardustPaths;
import xyz.starmun.stardust.datamodels.Ore;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OreGenerator extends DataProviderBase {

    private static void save(JsonElement jsonElement, HashCache hashCache) {
        try {
            DataProvider.save(new GsonBuilder().setPrettyPrinting().create(),
                    hashCache,
                    jsonElement,
                    Paths.get(DataProviderBase.dataGenerator.getOutputFolder().toString(), StardustPaths.DEFAULT_ORE_FILES_CONFIG_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(HashCache hashCache) {
        List<Ore> strata = new ArrayList<Ore>(){{
            add(Ore.builder
                    .setId("iron")
                    .addItem(Ore.Item.builder
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

        }};
        JsonOps.INSTANCE.withEncoder(Codec.list(Ore.CODEC))
                .apply(strata)
                .mapError(OreGenerator::onError)
                .result()
                .ifPresent(jsonElement-> save(jsonElement,hashCache));
    }

    private static String onError(String error) {
        Stardust.LOGGER.error(error);
        return error;
    }

    @Override
    public String getName() {
        return "Default Strata";
    }
}
