package xyz.starmun.stardust.data.generators;

import net.minecraft.data.DataGenerator;

public class DataGeneratorsCore {
    public  static DataGenerator dataGenerator = null;
    public static void register(DataGenerator dataGenerator){
        DataGeneratorsCore.dataGenerator = dataGenerator;
        DataGeneratorsCore.dataGenerator.addProvider(new StrataConfigGenerator());
        DataGeneratorsCore.dataGenerator.addProvider(new OresConfigGenerator());
        DataGeneratorsCore.dataGenerator.addProvider(new ItemsConfigGenerator());
    }
}
