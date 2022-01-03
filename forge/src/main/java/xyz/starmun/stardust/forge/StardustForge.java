package xyz.starmun.stardust.forge;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.blocks.colorhandlers.BlockColorHandler;
import xyz.starmun.stardust.item.ItemColorHandler;
import xyz.starmun.stardust.registry.OreBlockRegistry;

@Mod(Stardust.MOD_ID)
public class StardustForge {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Stardust.MOD_ID);
    public static final DeferredRegister<Item>  ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Stardust.MOD_ID);

    public StardustForge() {

        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::postInit);
        Stardust.init();
    }

    private void postInit(FMLClientSetupEvent event) {
        event.getMinecraftSupplier().get().tell(() -> {
            Minecraft.getInstance().getBlockColors()
                    .register(new BlockColorHandler(),
                            OreBlockRegistry.REGISTERED_ORE_BLOCKS.values()
                                    .toArray(new Block[0]));
            Minecraft.getInstance().getItemColors()
                    .register( new ItemColorHandler(),
                            OreBlockRegistry.REGISTERED_ORE_ITEMS
                                    .toArray(new Item[0]));
        });
        for (Block block : OreBlockRegistry.REGISTERED_ORE_BLOCKS.values()) {
            ItemBlockRenderTypes.setRenderLayer(block,
                    layer -> layer == RenderType.solid()
                            || layer == RenderType.translucent()
                            || layer == RenderType.cutout());
        }
    }
}
