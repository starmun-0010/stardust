package xyz.starmun.stardust.platform.contracts.forge;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static xyz.starmun.stardust.forge.StardustForge.ITEMS;

public class ItemRegistryExpectPlatformImpl {
    public static Item register(String name, Block block){
        Item item = new BlockItem(block, new Item.Properties().tab(CreativeModeTab.TAB_MISC));
         ITEMS.register(name, () -> item);
         return item;
    }
}