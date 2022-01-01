package xyz.starmun.stardust.platform.contracts;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ItemRegistryExpectPlatform {
    @ExpectPlatform
    public static Item register(String name, Block block){
        throw new AssertionError();
    }
}
