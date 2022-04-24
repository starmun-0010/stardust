package xyz.starmun.stardust.forge.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.starmun.stardust.blocks.StrataBasedStateBlock;
import xyz.starmun.stardust.registry.OresRegistry;
import xyz.starmun.stardust.registry.StrataRegistry;

public class BlockStateGenerator extends BlockStateProvider {


    public BlockStateGenerator(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        OresRegistry.REGISTERED_ORE_BLOCKS.forEach((id, block)->{
            StrataRegistry.STRATA.forEach(strata->{
                RegisterStates(block, strata.getId(), new ModelFile.UncheckedModelFile(modLoc("block/ore")));
            });
        });
    }
    public void RegisterStates(StrataBasedStateBlock block, String stratumId, ModelFile modelFile) {
            getVariantBuilder(block)
                    .partialState().with(StrataBasedStateBlock.STRATUM, stratumId)
                    .modelForState().modelFile(modelFile).addModel();
    }
}
