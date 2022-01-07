package xyz.starmun.stardust.constants;

import xyz.starmun.stardust.platform.contracts.PathExpectPlatform;

import java.nio.file.Path;

public final class StardustPaths {
    public static final Path STARDUST_CONFIG_PATH = PathExpectPlatform.getConfigPath();
    public static final String DEFAULT_STRATA_FILE_CONFIG_PATH = STARDUST_CONFIG_PATH + "/strata";
    public static final String DEFAULT_STRATA_FILE_GENERATION_PATH = "/data/stardust/defaults/strata/strata.json";

    private StardustPaths(){}
}
