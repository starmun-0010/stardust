package xyz.starmun.stardust.forge.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.SimpleModelTransform;
import net.minecraftforge.client.model.data.IModelData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.starmun.stardust.datamodels.Stratum;
import xyz.starmun.stardust.registry.StrataRegistry;

import java.util.*;

public class StratumBasedOreBlockModel implements BakedModel {
    private static final Material[] materials = new Material[StrataRegistry.STRATA.size()];
    private final Stratum stratum;
    static {
        StrataRegistry.STRATA.forEach(stratum -> {
            new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation(stratum.getBaseTexture()));
        });
    }

    public StratumBasedOreBlockModel(Stratum stratum){
        this.stratum = stratum;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState arg, @Nullable Direction arg2, Random random) {
        throw new AssertionError("IBakedModel::getQuads should never be called, only IForgeBakedModel::getQuads");
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
        return ModelLoader.instance().bake(new ResourceLocation("stardust:block/ore"), SimpleModelTransform.IDENTITY).getParticleIcon();
    }

    @Override
    public ItemOverrides getOverrides() {
        return null;
    }

    @NotNull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull Random rand, @NotNull IModelData extraData) {
        ImmutableList.Builder<BakedQuad> builder = ImmutableList.builder();
        BakedModel oreModel = ModelLoader.instance().bake(new ResourceLocation("stardust:block/ore"), SimpleModelTransform.IDENTITY);
        builder.addAll(ModelLoader.instance().bake(new ResourceLocation(stratum.getModId() +":block/"+ stratum.getBlockId()), SimpleModelTransform.IDENTITY).getQuads(state,side,rand));

        Vector3f scaleFactor = new Vector3f(0.005F, 0.005F, 0.005F);
        //Translate to world coordinates
        scaleFactor.mul(1.0F/16.0F);
        addScaledModelQuads(oreModel, scaleFactor, side, builder);
        return builder.build();
    }


    private void addScaledModelQuads(BakedModel original, Vector3f scaleFactor, Direction sides,
                                     ImmutableList.Builder<BakedQuad> quadListBuilder) {
        final Random random = new Random();
        for (BakedQuad bakedQuad : original.getQuads(null, sides, random)) {
            quadListBuilder.add(getTranslatedBakedQuadCopy(bakedQuad, scaleFactor,sides));
        }
    }


    /** Make a copy of the given BakedQuad and translate it to a new position
     * @param original
     * @param translateBy amount to translate by in model coordinates (i.e. 0 -> 16 = 1 metre world distance)
     * @return
     */
    private BakedQuad getTranslatedBakedQuadCopy(BakedQuad original, Vector3f translateBy, Direction side) {

        // directly manipulate the int array data for the vertices to update the x, y, z
        int [] vertexData = original.getVertices();
        int [] newVertexData = new int[vertexData.length];
        System.arraycopy(vertexData, 0, newVertexData, 0, newVertexData.length);

        int vertexSizeInts = DefaultVertexFormat.BLOCK.getIntegerSize();

        Optional<VertexFormatElement> positionElement = DefaultVertexFormat.BLOCK.getElements().stream()
                .filter(e -> VertexFormatElement.Usage.POSITION.equals(e.getUsage())).findFirst();
        if (!positionElement.isPresent()) throw new AssertionError("Position element not found");
        int positionOffset = positionElement.get().getIndex();

        if (vertexData.length != 4 * vertexSizeInts) {
            throw new AssertionError("Expected vertexdata to have size " + (4 * vertexSizeInts) + " but had " + vertexData.length + " instead.");
        }
        if (positionElement.get().getByteSize() != Float.BYTES * 3) {
            throw new AssertionError("Vertex PositionElement didn't match expected size");
        }

        // see DefaultVertexFormats.BLOCK for info on the packed vertex format
        for (int i = positionOffset; i < vertexData.length; i += vertexSizeInts) {
            newVertexData[i] = Float.floatToRawIntBits(Float.intBitsToFloat(vertexData[i]) + getXScaleValue(side,translateBy.x()));
            newVertexData[i + 1] = Float.floatToRawIntBits(Float.intBitsToFloat(vertexData[i+1]) + getYScaleValue(side,translateBy.y()));
            newVertexData[i + 2] = Float.floatToRawIntBits(Float.intBitsToFloat(vertexData[i+2]) + getZScaleValue(side, translateBy.z()));

        }

        BakedQuad translatedCopy = new BakedQuad(newVertexData, original.getTintIndex(), original.getDirection(),
                original.a(), original.isShade());
        return translatedCopy;
    }

    private float getYScaleValue(Direction side, float i) {
        if (side==Direction.UP)
            return i;
        else if(side==Direction.DOWN){
            return -i;
        }
        return 0;
    }

    private float getXScaleValue(Direction side, float i) {
        if (side==Direction.EAST)
            return i;
        else if(side==Direction.WEST){
            return -i;
        }
        return 0;
    }

    private float getZScaleValue(Direction side, float i) {
        if (side==Direction.SOUTH)
            return i;
        else if(side==Direction.NORTH){
            return -i;
        }
        return 0;
    }
}
