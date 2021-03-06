package xyz.starmun.stardust.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.RenderType;
import xyz.starmun.stardust.blocks.colorhandlers.BlockColorHandler;
import xyz.starmun.stardust.item.ItemColorHandler;
import xyz.starmun.stardust.registry.MaterialsRegistry;

public class StardustFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MaterialsRegistry.REGISTERED_ORE_BLOCKS.forEach((oreName, block) -> {
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) ->
                    new BlockColorHandler().getColor(state,view,pos,tintIndex), block);

            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
        });
        MaterialsRegistry.REGISTERED_ORE_ITEMS.forEach(item->
            ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
               new ItemColorHandler().getColor(stack,tintIndex)
            , item));
        MaterialsRegistry.REGISTERED_DYNAMIC_ITEMS.forEach((key, value)->
            ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
               new ItemColorHandler().getColor(stack,tintIndex)
            , value));
    }
}
