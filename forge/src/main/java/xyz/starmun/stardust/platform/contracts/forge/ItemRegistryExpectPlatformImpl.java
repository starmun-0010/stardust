package xyz.starmun.stardust.platform.contracts.forge;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import xyz.starmun.stardust.forge.StardustForge;
import xyz.starmun.stardust.item.StardustItem;

import static xyz.starmun.stardust.forge.StardustForge.ITEMS;

public class ItemRegistryExpectPlatformImpl {
    public static Item register(String name, Block block){
        Item item = new BlockItem(block, new Item.Properties().tab(StardustForge.ITEM_GROUP));
        ITEMS.register(name, () -> item);
        return item;
    }
    public static StardustItem register(String name){
        StardustItem item = new StardustItem(new Item.Properties().tab(StardustForge.ITEM_GROUP));
        ITEMS.register(name, () -> item);
        return item;
    }
}