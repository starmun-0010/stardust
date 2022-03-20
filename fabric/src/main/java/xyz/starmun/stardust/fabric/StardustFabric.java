package xyz.starmun.stardust.fabric;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import xyz.starmun.stardust.Stardust;
import net.fabricmc.api.ModInitializer;

public class StardustFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Stardust.init();
    }
    public static final CreativeModeTab ITEM_GROUP = FabricItemGroupBuilder.build(
            new ResourceLocation("stardust", "minerals"),
            () -> new ItemStack(Items.REDSTONE));
}
