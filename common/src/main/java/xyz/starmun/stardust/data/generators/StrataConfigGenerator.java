package xyz.starmun.stardust.data.generators;

import com.mojang.serialization.Codec;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import xyz.starmun.stardust.constants.StardustPaths;
import xyz.starmun.stardust.datamodels.Stratum;
import xyz.starmun.stardust.utils.FilesUtils;
import xyz.starmun.stardust.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class StrataConfigGenerator implements DataProvider {

    @Override
    public String getName() {
        return "Default Strata Generator";
    }

    @Override
    public void run(HashCache hashCache) {
        List<Stratum> strata = new ArrayList<Stratum>(){{
            //vanilla strata
            add(Stratum.Builder.instance().setBlockId("stone").build());
            add(Stratum.Builder.instance().setBlockId("gravel").build());
            add(Stratum.Builder.instance().setBlockId("andesite").build());
            add(Stratum.Builder.instance().setBlockId("diorite").build());
            add(Stratum.Builder.instance().setBlockId("granite").build());
            add(Stratum.Builder.instance().setBlockId("sandstone").build());
            add(Stratum.Builder.instance().setBlockId("sand").build());
            add(Stratum.Builder.instance().setBlockId("netherrack").build());
           }};
        JsonUtils.serializeToJson(strata, Codec.list(Stratum.CODEC))
                .ifPresent(jsonElement->
                        FilesUtils.saveJsonFile(StardustPaths.DataGen.DEFAULT_STRATA_FILE_GENERATION_PATH
                        ,jsonElement,hashCache));
    }
}
