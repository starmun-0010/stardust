package xyz.starmun.stardust.data.generators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.constants.StardustPaths;
import xyz.starmun.stardust.datamodels.Stratum;
import xyz.starmun.stardust.utils.FilesUtil;

import java.util.ArrayList;
import java.util.List;

public class StrataConfigGenerator implements DataProvider {

    @Override
    public void run(HashCache hashCache) {
        List<Stratum> strata = new ArrayList<Stratum>(){{
            //vanilla strata[[[[[[[
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
                .ifPresent(jsonElement-> FilesUtil.saveJsonFile(StardustPaths.DataGen.DEFAULT_STRATA_FILE_GENERATION_PATH
                        ,jsonElement,hashCache));
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
