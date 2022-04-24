package xyz.starmun.stardust.data.generators;

import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import xyz.starmun.stardust.constants.StardustPaths;
import xyz.starmun.stardust.datamodels.Material;
import xyz.starmun.stardust.utils.FilesUtils;
import xyz.starmun.stardust.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class MaterialsConfigGenerator implements DataProvider {

    @Override
    public String getName() {
        return "Default Ores Generator";
    }

    @Override
    public void run(HashCache hashCache) {
        List<Material> materials = new ArrayList<Material>(){{
            add(Material.Builder.instance()
                    .setId("aluminum")
                    .setIsEnabled(false)
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("ore")
                            .setGenerateInWorld(true)
                            .setDropSelf(true)
                            .setRegistrationType(Material.Variant.RegistrationType.BlockItem)
                            .setBottomOffset(3)
                            .setTopOffset(3)
                            .setMaximum(225)
                            .setMaxVeinSize(16)
                            .setMaxPerChunk(64)
                            .setColors(new ArrayList<String>(){{
                                add("0xff0000");
                                add("0x00ff00");
                                add("0x0000FF");
                                add("0xFFffFF");
                            }})
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("apatite")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("ore")
                            .setGenerateInWorld(true)
                            .setDropSelf(true)
                            .setRegistrationType(Material.Variant.RegistrationType.BlockItem)
                            .setBottomOffset(3)
                            .setTopOffset(3)
                            .setMaximum(225)
                            .setMaxVeinSize(16)
                            .setMaxPerChunk(64)
                            .setColors(new ArrayList<String>(){{
                                add("0xff0000");
                                add("0x00ff00");
                                add("0x0000FF");
                                add("0xFFffFF");
                            }})
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("arcane")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("ore")
                            .setGenerateInWorld(true)
                            .setDropSelf(true)
                            .setRegistrationType(Material.Variant.RegistrationType.BlockItem)
                            .setBottomOffset(3)
                            .setTopOffset(3)
                            .setMaximum(225)
                            .setMaxVeinSize(16)
                            .setMaxPerChunk(64)
                            .setColors(new ArrayList<String>(){{
                                add("0xff0000");
                                add("0x00ff00");
                                add("0x0000FF");
                                add("0xFFffFF");
                            }})
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("bitumen")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("brass")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("bronze")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("cast_iron")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("certus_quartz")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("charged_certus_quartz")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("cinnabar")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("cobalt")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("coke")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("constantan")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("copper")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("dimensional")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("electrum")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("enderium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("fluix")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("fluorite")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("invar")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("iridium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
            add(Material.Builder.instance()
                    .setId("iron")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("lead")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("lumium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("nickel")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("osmium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("peridot")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("potassium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("ruby")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("saphire")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("signalum")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("silver")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("steel")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("sulfur")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("tin")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("uranium")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());

            add(Material.Builder.instance()
                    .setId("zinc")
                    .setColors(new ArrayList<String>(){{
                        add("");
                    }})
                    .addVariant(Material.Variant.Builder.instance()
                            .setNameSuffix("gear")
                            .build())
                    .build());
        }};
        materials.forEach(ore -> {
            JsonUtils.serializeToJson(ore, Material.CODEC).ifPresent(jsonElement->
                    FilesUtils.saveJsonFile(StardustPaths.DataGen.DEFAULT_ORE_FILES_GENERATION_PATH
                            + ore.getId(), jsonElement, hashCache));
        });
    }
}
