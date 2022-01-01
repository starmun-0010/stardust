package xyz.starmun.stardust.platform.contracts.fabric;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import xyz.starmun.stardust.Stardust;

public class ItemRegistryExpectPlatformImpl {
    public static Item register(String name, Block block) {
       return Registry.register(Registry.ITEM, new ResourceLocation(Stardust.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(CreativeModeTab.TAB_MISC)));
    }
}
