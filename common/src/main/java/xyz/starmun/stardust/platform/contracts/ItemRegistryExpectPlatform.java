package xyz.starmun.stardust.platform.contracts;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.level.block.Block;

public class ItemRegistryExpectPlatform {
    @ExpectPlatform
    public static void register(String name, Block block){
        throw new AssertionError();
    }
}
