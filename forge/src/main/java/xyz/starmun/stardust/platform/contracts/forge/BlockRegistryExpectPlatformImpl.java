package xyz.starmun.stardust.platform.contracts.forge;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.RegistryObject;
import xyz.starmun.stardust.data.Properties;
import xyz.starmun.stardust.forge.StardustForge;

import static xyz.starmun.stardust.forge.StardustForge.*;

public class BlockRegistryExpectPlatformImpl {
    public static void Register(Properties properties){
        RegistryObject<Block> block =  BLOCKS.register(properties.name, () -> new Block(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops()));
        ITEMS.register(properties.name, () -> new BlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    }
}