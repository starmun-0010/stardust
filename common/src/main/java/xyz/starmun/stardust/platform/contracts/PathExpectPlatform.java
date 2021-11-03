package xyz.starmun.stardust.platform.contracts;

import dev.architectury.injectables.annotations.ExpectPlatform;
import org.apache.commons.lang3.NotImplementedException;

import java.nio.file.*;

public class PathExpectPlatform {
    @ExpectPlatform
    public static Path getConfigPath(){
        throw new NotImplementedException(getConfigPath().toString());
    }
}
