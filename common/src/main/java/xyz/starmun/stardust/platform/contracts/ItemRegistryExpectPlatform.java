package xyz.starmun.stardust.platform.contracts;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import xyz.starmun.stardust.item.StardustItem;

public class ItemRegistryExpectPlatform {
    @ExpectPlatform
    public static Item register(String name, Block block){
        throw new AssertionError();
    }
    @ExpectPlatform
    public static StardustItem register(String name){
        throw new AssertionError();
    }
}
