package xyz.starmun.stardust.forge;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.blocks.StateBasedOreBlock;
import xyz.starmun.stardust.blocks.colorhandlers.BlockColorHandler;
import xyz.starmun.stardust.datamodels.Stratum;
import xyz.starmun.stardust.forge.datagen.StratumBasedOreBlockModel;
import xyz.starmun.stardust.item.ItemColorHandler;
import xyz.starmun.stardust.registry.OreBlockRegistry;
import xyz.starmun.stardust.registry.StrataRegistry;

@Mod(Stardust.MOD_ID)
@Mod.EventBusSubscriber(modid = Stardust.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class StardustForge {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Stardust.MOD_ID);
    public static final DeferredRegister<Item>  ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Stardust.MOD_ID);

    public StardustForge() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::postInit);
        Stardust.init();
    }
    @SubscribeEvent
    public static void onModelBakeEvent(ModelBakeEvent event){

        OreBlockRegistry.REGISTERED_ORE_BLOCKS.forEach((id,block)->{
            for (Stratum stratum : StrataRegistry.STRATA) {
                StratumBasedOreBlockModel customModel = new StratumBasedOreBlockModel(stratum);
                event.getModelRegistry()
                        .put(BlockModelShaper.stateToModelLocation(block.getStateDefinition()
                                .any().setValue(StateBasedOreBlock.STRATUM, stratum.id)),customModel);
            }
        });
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
                    layer -> layer == RenderType.cutout());
        }
    }
}
