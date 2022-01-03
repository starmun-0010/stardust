package xyz.starmun.stardust.datagen;

import com.google.gson.GsonBuilder;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import xyz.starmun.stardust.constants.StardustPaths;
import xyz.starmun.stardust.datamodels.Stratum;
import xyz.starmun.stardust.utils.FilesUtil;

import java.util.ArrayList;
import java.util.List;

public class StrataGenerator {


    public StrataGenerator(List<Stratum> strata){
        this.STRATA = strata;
    }
    private  List<Stratum> STRATA;
    public static void generate(){

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
                .map(new GsonBuilder().setPrettyPrinting().create()::toJson)
                .ifPresent(StrataGenerator::writeFIle);
    }

    private static void writeFIle(String json) {
        FilesUtil.writeJsonFile(StardustPaths.DEFAULT_STRATA_FILE_GENERATION_PATH, json);
    }
}
