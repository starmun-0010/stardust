package xyz.starmun.stardust.platform.contracts;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.nio.file.Path;

public class PathExpectPlatform {
    @ExpectPlatform
    public static Path getConfigPath(){
        throw new AssertionError();
    }
    @ExpectPlatform

    public static Path getOresConfigPath(){
        throw new AssertionError();
    }
    @ExpectPlatform
    public static Path getStonesConfigPath(){
        throw new AssertionError();
    }
    @ExpectPlatform
    public static Path getStardustModJarResourcesPath() {
        throw new AssertionError();
    }
}
