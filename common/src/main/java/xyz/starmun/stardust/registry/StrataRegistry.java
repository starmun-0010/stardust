package xyz.starmun.stardust.registry;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import org.apache.commons.lang3.tuple.Pair;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.constants.StardustPaths;
import xyz.starmun.stardust.datamodels.Stratum;
import xyz.starmun.stardust.utils.FilesUtil;
import xyz.starmun.stardust.utils.JsonUtil;

import java.io.File;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StrataRegistry {

    public static ImmutableList<Stratum> STRATA =
            ImmutableList.<Stratum>builder()
            .build();

    public static void register(){
       List<Path> filePaths = FilesUtil.crawlJsonFiles(Paths.get(StardustPaths.DEFAULT_STRATA_FILE_CONFIG_PATH));
        if(filePaths == null){
            Stardust.LOGGER.error("Failed loading strata configuration files.");
            return;
        }
        filePaths.forEach(path -> {
            Pair<File, Reader> pair = FilesUtil.loadFile(path);
            if(pair == null){
                Stardust.LOGGER.error("Could not load strata configuration file.");
                return;
            }
            List<Stratum> strata =  JsonUtil.parseJson(pair.getRight(), Codec.list(Stratum.CODEC));
            if(strata==null){
                Stardust.LOGGER.error("Error processing strata configuration file, failed to load strata.");
                return;
            }
            STRATA = ImmutableList.copyOf(strata);
        });
    }
}
