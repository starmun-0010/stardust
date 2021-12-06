package xyz.starmun.stardust.platform.contracts;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.level.block.Block;
import xyz.starmun.stardust.data.Properties;

public class BlockRegistryExpectPlatform {
    @ExpectPlatform
    public static Block
    register(Properties properties){
        throw new AssertionError();
    }
}
