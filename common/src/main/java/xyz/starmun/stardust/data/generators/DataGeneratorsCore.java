package xyz.starmun.stardust.data.generators;

import net.minecraft.data.DataGenerator;

public class DataGeneratorsCore {

    public static void register(DataGenerator dataGenerator){
        DataProviderBase.dataGenerator = dataGenerator;
        DataProviderBase.dataGenerator.addProvider(new StrataConfigGenerator());
        DataProviderBase.dataGenerator.addProvider(new OreConfigGenerator());
    }
}
