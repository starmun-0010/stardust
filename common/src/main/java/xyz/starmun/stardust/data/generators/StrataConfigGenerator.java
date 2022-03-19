package xyz.starmun.stardust.data.generators;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.constants.StardustPaths;
import xyz.starmun.stardust.datamodels.Stratum;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StrataConfigGenerator extends DataProviderBase {

    private static void save(JsonElement jsonElement, HashCache hashCache) {
        try {
            DataProvider.save(new GsonBuilder().setPrettyPrinting().create(),
                    hashCache,
                    jsonElement,
                    Paths.get(DataProviderBase.dataGenerator.getOutputFolder().toString(), StardustPaths.DataGen.DEFAULT_STRATA_FILE_GENERATION_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(HashCache hashCache) {
        List<Stratum> strata = new ArrayList<Stratum>(){{
            add(Stratum.builder.setBlockId("stone").build());
            add(Stratum.builder.setBlockId("gravel").build());
            add(Stratum.builder.setBlockId("andesite").build());
            add(Stratum.builder.setBlockId("diorite").build());
            add(Stratum.builder.setBlockId("granite").build());
            add(Stratum.builder.setBlockId("sandstone").build());
            add(Stratum.builder.setBlockId("sand").build());
            add(Stratum.builder.setBlockId("netherrack").build());
           }};
        JsonOps.INSTANCE.withEncoder(Codec.list(Stratum.CODEC))
                .apply(strata)
                .mapError(StrataConfigGenerator::onError)
                .result()
                .ifPresent(jsonElement-> save(jsonElement,hashCache));
    }

    private static String onError(String error) {
        Stardust.LOGGER.error(error);
        return error;
    }

    @Override
    public String getName() {
        return "Default Strata Generator";
    }
}
