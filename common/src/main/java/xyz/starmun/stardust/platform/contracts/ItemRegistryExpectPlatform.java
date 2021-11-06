package xyz.starmun.stardust.platform.contracts;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.level.block.Block;

public class ItemRegistryExpectPlatform {
    @ExpectPlatform
    public static void Register(String name, Block block){
        throw new AssertionError();
    }
}
