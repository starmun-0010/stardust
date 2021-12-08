package xyz.starmun.stardust.forge;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.starmun.stardust.Stardust;

@Mod(Stardust.MOD_ID)
public class StardustForge {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Stardust.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Stardust.MOD_ID);

    public StardustForge() {

        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::postInit);
        Stardust.init();
    }

    private void postInit(FMLClientSetupEvent event) {
        for (RegistryObject<Block> block : BLOCKS.getEntries()) {
            ItemBlockRenderTypes.setRenderLayer(block.get(), layer -> layer == RenderType.solid() || layer == RenderType.translucent() || layer == RenderType.cutout());
        }
    }
}
