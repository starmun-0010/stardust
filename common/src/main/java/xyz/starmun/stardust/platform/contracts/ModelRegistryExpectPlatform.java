package xyz.starmun.stardust.platform.contracts;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class ModelRegistryExpectPlatform {
    @ExpectPlatform
    public static void register(String path){
        throw new AssertionError();
    }
}
