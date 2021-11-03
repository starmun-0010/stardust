package xyz.starmun.stardust.platform.contracts;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.Item;

public class ItemRegistryExpectPlatform {
    @ExpectPlatform
    public static Item Register(String name, Object block){
        throw new AssertionError();
    }
}
