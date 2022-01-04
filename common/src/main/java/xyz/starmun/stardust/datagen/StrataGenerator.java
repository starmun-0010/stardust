package xyz.starmun.stardust.datagen;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import xyz.starmun.stardust.constants.StardustPaths;
import xyz.starmun.stardust.datamodels.Stratum;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StrataGenerator extends DataProviderBase {

    private static void save(JsonElement jsonElement, HashCache hashCache) {
        try {
            DataProvider.save(new GsonBuilder().setPrettyPrinting().create(),
                    hashCache,
                    jsonElement,
                    Paths.get(DataProviderBase.dataGenerator.getOutputFolder().toString(), StardustPaths.DEFAULT_STRATA_FILE_GENERATION_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(HashCache hashCache) {
        List<Stratum> strata = new ArrayList<Stratum>(){{
            add(new Stratum("stone","minecraft"));
            add(new Stratum("gravel","minecraft"));
            add(new Stratum("andesite","minecraft"));
            add(new Stratum("diorite","minecraft"));
            add(new Stratum("granite","minecraft"));
            add(new Stratum("sandstone","minecraft"));
            add(new Stratum("sand","minecraft"));
        }};
        JsonOps.INSTANCE.withEncoder(Codec.list(Stratum.CODEC))
                .apply(strata)
                .result()
                .ifPresent(jsonElement-> save(jsonElement,hashCache));
    }

    @Override
    public String getName() {
        return "Default Strata";
    }
}
