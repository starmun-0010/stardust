package xyz.starmun.stardust.data.generators;

import com.mojang.serialization.JsonOps;
import net.minecraft.data.HashCache;
import xyz.starmun.stardust.Stardust;
import xyz.starmun.stardust.constants.StardustPaths;
import xyz.starmun.stardust.datamodels.Ore;
import xyz.starmun.stardust.utils.FilesUtil;

import java.util.ArrayList;
import java.util.List;

public class OreConfigGenerator extends DataProviderBase {

    @Override
    public void run(HashCache hashCache) {
        List<Ore> ores = new ArrayList<Ore>(){{
            add(Ore.builder
                    .setId("aluminum")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("apatite")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("arcane")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("bitumen")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("brass")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("bronze")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("cast_iron")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("certus_quartz")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("charged_certus_quartz")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("cinnabar")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("cobalt")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("coke")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("constantan")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("copper")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("dimensional")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("electrum")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("enderium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("fluix")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("fluorite")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("invar")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("iridium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());
            add(Ore.builder
                    .setId("iron")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("lead")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("lumium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("nickel")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("osmium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("peridot")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("potassium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("ruby")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("saphire")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("signalum")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("silver")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("steel")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("sulfur")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("tin")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("uranium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

            add(Ore.builder
                    .setId("zinc")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addItem(Ore.Item.getBuilder()
                            .setNameSuffix("gear")
                            .setColors(new ArrayList<String>(){{
                                add("");
                            }})
                            .build())
                    .build());

        }};
        ores.forEach(ore -> {
            JsonOps.INSTANCE.withEncoder(Ore.CODEC)
                    .apply(ore)
                    .mapError(OreConfigGenerator::onError)
                    .result()
                    .ifPresent(jsonElement->
                            FilesUtil.saveJsonFile(StardustPaths.DataGen.DEFAULT_ORE_FILES_GENERATION_PATH + ore.getId(), jsonElement, hashCache));
        });
    }

    private static String onError(String error) {
        Stardust.LOGGER.error(error);
        return error;
    }

    @Override
    public String getName() {
        return "Default Ores";
    }
}
