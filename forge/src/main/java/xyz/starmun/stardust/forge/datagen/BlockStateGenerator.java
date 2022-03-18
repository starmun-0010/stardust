package xyz.starmun.stardust.forge.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.starmun.stardust.blocks.StateBasedOreBlock;
import xyz.starmun.stardust.registry.OreBlockRegistry;
import xyz.starmun.stardust.registry.StrataRegistry;

public class BlockStateGenerator extends BlockStateProvider {


    public BlockStateGenerator(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        OreBlockRegistry.REGISTERED_ORE_BLOCKS.forEach((id, block)->{
            StrataRegistry.STRATA.forEach(strata->{
                String loc = block.getRegistryName().getPath()+"_"+ strata.getId();
                this.models().getBuilder(loc)
                        .parent(new ModelFile.UncheckedModelFile(mcLoc("block/block")))
                        .texture("base", new ResourceLocation(strata.getBaseTexture()))
                        .element()
                        .cube("#base")
                        .end();
                strataStateBasedOreBlock(block, strata.getId(), new ModelFile.UncheckedModelFile(modLoc("block/")));
            });
        });
    }
    public void strataStateBasedOreBlock(StateBasedOreBlock block, String stratumId, ModelFile modelFile) {

            getVariantBuilder(block)
                    .partialState().with(StateBasedOreBlock.STRATUM, stratumId)
                    .modelForState().modelFile(modelFile).addModel();


    }
}
