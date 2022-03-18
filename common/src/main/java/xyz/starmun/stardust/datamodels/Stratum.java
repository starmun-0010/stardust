package xyz.starmun.stardust.datamodels;

import com.google.common.base.Enums;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import xyz.starmun.stardust.Stardust;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Stratum {

    private String id;
    private String modId;
    private String blockId;
    private boolean isEnabled;
    private String baseTexture;
    private Supplier<Block> block;
    private Supplier<ResourceLocation> resourceLocation;
    private GenerationType generationType;

    public static final Codec<Stratum> CODEC = RecordCodecBuilder.create((instance)->
        instance.group(

                Codec.STRING.fieldOf("modId").forGetter((Stratum stratum)-> stratum.modId),
                Codec.STRING.fieldOf("blockId").forGetter((Stratum stratum)-> stratum.blockId),
                Codec.STRING.fieldOf("baseTexture").forGetter((Stratum stratum)-> stratum.baseTexture),
                Codec.BOOL.fieldOf("isEnabled").orElse(true).forGetter((Stratum stratum)-> stratum.isEnabled),
                Codec.STRING.flatXmap(Stratum::toGenerationType, Stratum::fromGenerationType)
                        .fieldOf("generationType")
                        .orElse(GenerationType.BlockState)
                        .forGetter((Stratum generationType) -> generationType.generationType))
                .apply(instance, (modId,blockId,baseTexture,isEnabled, generationType)->
                        new Stratum(blockId, modId, baseTexture,isEnabled, generationType))
    );

    private static DataResult<GenerationType> toGenerationType(String type) {
        if(type != null && Enums.getIfPresent(GenerationType.class,type).isPresent()){
            return DataResult.success(GenerationType.valueOf(type));
        }
        String error = type + " is not a valid value for strata generation type."
                + System.lineSeparator() + "Valid values are: "
                +  Arrays.stream(GenerationType.values())
                .map(Enum::name).collect(Collectors.joining(", "));
        Stardust.LOGGER.error(error);
        return DataResult.error(error);
    }

    private static DataResult<String> fromGenerationType(GenerationType generationType) {
        if(generationType == null){
            return DataResult.error("");
        }
        return DataResult.success(generationType.name());
    }

    public Stratum(String blockId, String modId, String baseTexture, boolean isEnabled, GenerationType generationType){
        this(blockId,modId,baseTexture);
        this.generationType = generationType;
        this.isEnabled = isEnabled;
    }
    public Stratum(String blockId, String modId, String baseTexture, GenerationType generationType){
        this(blockId,modId,baseTexture);
        this.generationType = generationType;
    }
    public Stratum(String blockId, String modId, String baseTexture){
        this.blockId = blockId;
        this.modId = modId;
        this.id =  modId +"_"+ blockId;
        this.baseTexture = baseTexture;
        this.resourceLocation = ()-> new ResourceLocation(modId, blockId);
        this.block = () -> Registry.BLOCK.containsKey(resourceLocation.get()) ? Registry.BLOCK.get(resourceLocation.get()) : null;
    }

    public GenerationType getGenerationType() {
        return generationType;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public String getId() {
        return id;
    }

    public String getModId() {
        return modId;
    }

    public String getBlockId() {
        return blockId;
    }

    public String getBaseTexture() {
        return baseTexture;
    }

    public Supplier<Block> getBlock() {
        return block;
    }

    public Supplier<ResourceLocation> getResourceLocation() {
        return resourceLocation;
    }

    public enum GenerationType{
        Block,
        BlockState
    }
}
