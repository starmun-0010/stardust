package xyz.starmun.stardust.platform.contracts.fabric;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.fabric.StardustFabric;
import xyz.starmun.stardust.item.StardustItem;

public class ItemRegistryExpectPlatformImpl {
    public static Item register(String name, Block block) {
       return Registry.register(Registry.ITEM, new ResourceLocation(Stardust.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(StardustFabric.ITEM_GROUP)));
    }
    public static StardustItem register(String name) {
       return Registry.register(Registry.ITEM, new ResourceLocation(Stardust.MOD_ID, name), new StardustItem(new FabricItemSettings().group(StardustFabric.ITEM_GROUP)));
    }
}
