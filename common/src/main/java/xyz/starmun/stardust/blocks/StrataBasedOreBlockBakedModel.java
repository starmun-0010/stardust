package xyz.starmun.stardust.blocks;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Function;

import static xyz.starmun.stardust.Stardust.LOGGER;

public class StrataBasedOreBlockBakedModel implements UnbakedModel,BakedModel {
    private BakedModel modelWhenNotCamouflaged;

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState arg, @Nullable Direction arg2, Random random) {
        BakedModel retrieval = modelWhenNotCamouflaged;  // default
        List<BakedQuad> baseQuad = getBaseQuads(arg);
        Minecraft mc = Minecraft.getInstance();
        BlockRenderDispatcher blockRendererDispatcher = mc.getBlockRenderer();
        retrieval = blockRendererDispatcher.getBlockModel(arg);
        return retrieval.getQuads(arg,arg2,random);

    }

    private List<BakedQuad> getBaseQuads(BlockState arg) {
        return null;
    }

    @Override
    public boolean useAmbientOcclusion() {
        return false;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }

    @Override
    public boolean usesBlockLight() {
        return false;
    }

    @Override
    public boolean isCustomRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleIcon() {
        return null;
    }

    @Override
    public ItemTransforms getTransforms() {
        return null;
    }

    @Override
    public ItemOverrides getOverrides() {
        return null;
    }

    @Override
    public Collection<ResourceLocation> getDependencies() {
        return null;
    }

    @Override
    public Collection<Material> getMaterials(Function<ResourceLocation, UnbakedModel> function, Set<Pair<String, String>> set) {
        return null;
    }

    @Nullable
    @Override
    public BakedModel bake(ModelBakery modelBakery, Function<Material, TextureAtlasSprite> function, ModelState modelState, ResourceLocation resourceLocation) {
        return null;
    }
}
