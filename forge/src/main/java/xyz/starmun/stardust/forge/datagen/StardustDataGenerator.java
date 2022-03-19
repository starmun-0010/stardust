package xyz.starmun.stardust.forge.datagen;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.data.generators.DataGeneratorsCore;

@Mod.EventBusSubscriber(modid = Stardust.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class StardustDataGenerator {
    private StardustDataGenerator(){}
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGeneratorsCore.register(event.getGenerator());
        DataGeneratorsCore.dataGenerator.addProvider(new BlockStateGenerator(DataGeneratorsCore.dataGenerator,
                Stardust.MOD_ID, event.getExistingFileHelper()));
    }
}
