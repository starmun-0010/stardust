package xyz.starmun.stardust.data.generators;

import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import xyz.starmun.stardust.constants.StardustPaths;
import xyz.starmun.stardust.datamodels.Ore;
import xyz.starmun.stardust.utils.FilesUtils;
import xyz.starmun.stardust.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class OreConfigGenerator implements DataProvider {

    @Override
    public String getName() {
        return "Default Ores Generator";
    }

    @Override
    public void run(HashCache hashCache) {
        List<Ore> ores = new ArrayList<Ore>(){{
            add(Ore.instance()
                    .setId("aluminum")
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("ore")
                            .setRegistrationType(Ore.Item.RegistrationType.BlockItem)
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("apatite")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("arcane")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("bitumen")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("brass")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("bronze")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("cast_iron")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("certus_quartz")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("charged_certus_quartz")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("cinnabar")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("cobalt")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("coke")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("constantan")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("copper")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("dimensional")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("electrum")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("enderium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("fluix")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("fluorite")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("invar")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("iridium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Ore.instance()
                    .setId("iron")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("lead")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("lumium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("nickel")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("osmium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("peridot")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("potassium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("ruby")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("saphire")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("signalum")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("silver")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("steel")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("sulfur")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("tin")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("uranium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Ore.instance()
                    .setId("zinc")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
        }};
        ores.forEach(ore -> {
            JsonUtils.serializeToJson(ore, Ore.CODEC)
                    .ifPresent(jsonElement->
                    FilesUtils.saveJsonFile(StardustPaths.DataGen.DEFAULT_ORE_FILES_GENERATION_PATH
                            + ore.getId(), jsonElement, hashCache));
        });
    }
}
