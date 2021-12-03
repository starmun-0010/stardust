package xyz.starmun.stardust.platform.contracts;

import dev.architectury.injectables.annotations.ExpectPlatform;
import org.apache.commons.lang3.NotImplementedException;

import java.io.IOException;
import java.nio.file.*;

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
}
