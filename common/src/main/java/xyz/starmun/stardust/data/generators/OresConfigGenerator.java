package xyz.starmun.stardust.data.generators;

import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import xyz.starmun.stardust.constants.StardustPaths;
import xyz.starmun.stardust.datamodels.Ore;
import xyz.starmun.stardust.utils.FilesUtils;
import xyz.starmun.stardust.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class OresConfigGenerator implements DataProvider {

    @Override
    public String getName() {
        return "Default Ores Generator";
    }

    @Override
    public void run(HashCache hashCache) {
        List<Ore> ores = new ArrayList<Ore>(){{
            add(Ore.Builder.instance()
                    .setId("aluminum")
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("ore")
                            .setGenerateInWorld(true)
                            .setDropSelf(true)
                            .setRegistrationType(Ore.Item.RegistrationType.BlockItem)
                            .setBottomOffset(3)
                            .setTopOffset(3)
                            .setMaximum(225)
                            .setMaxVeinSize(16)
                            .setMaxPerChunk(64)
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("apatite")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("arcane")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("bitumen")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("brass")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("bronze")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("cast_iron")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("certus_quartz")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("charged_certus_quartz")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("cinnabar")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("cobalt")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("coke")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("constantan")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("copper")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("dimensional")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("electrum")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("enderium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("fluix")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("fluorite")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("invar")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("iridium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.Builder.instance()
                    .setId("iron")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("lead")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("lumium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("nickel")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("osmium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("peridot")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("potassium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("ruby")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("saphire")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("signalum")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("silver")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("steel")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("sulfur")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("tin")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("uranium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.Builder.instance()
                    .setId("zinc")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
        }};
        ores.forEach(ore -> {
            JsonUtils.serializeToJson(ore, Ore.CODEC).ifPresent(jsonElement->
                    FilesUtils.saveJsonFile(StardustPaths.DataGen.DEFAULT_ORE_FILES_GENERATION_PATH
                            + ore.getId(), jsonElement, hashCache));
        });
    }
}
