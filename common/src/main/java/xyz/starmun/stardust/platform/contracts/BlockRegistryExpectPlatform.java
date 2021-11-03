package xyz.starmun.stardust.platform.contracts;

import dev.architectury.injectables.annotations.ExpectPlatform;
import xyz.starmun.stardust.data.Properties;

public class BlockRegistryExpectPlatform {
    @ExpectPlatform
    public static void Register(Properties properties){
        throw new AssertionError();
    }
}
