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
    private Boolean isEnabled;
    private String baseTexture;
    private Supplier<Block> block;
    private Supplier<ResourceLocation> resourceLocation;
    private GenerationType generationType;
    public static final Builder builder = new Builder();
    public static final Codec<Stratum> CODEC = RecordCodecBuilder.create((instance)->
        instance.group(
                Codec.STRING.optionalFieldOf("modId").forGetter((Stratum stratum)-> Optional.ofNullable(stratum.modId)),
                Codec.STRING.fieldOf("blockId").forGetter((Stratum stratum)-> stratum.blockId),
                Codec.STRING.optionalFieldOf("baseTexture").forGetter((Stratum stratum)-> Optional.ofNullable(stratum.baseTexture)),
                Codec.BOOL.optionalFieldOf("isEnabled").forGetter((Stratum stratum)-> Optional.ofNullable(stratum.isEnabled)),
                Codec.STRING.flatXmap(Stratum::toGenerationType, Stratum::fromGenerationType)
                        .optionalFieldOf("generationType")
                        .forGetter((Stratum generationType) -> Optional.ofNullable(generationType.generationType)))
                .apply(instance, (modId,blockId,baseTexture,isEnabled, generationType)->
                        new Stratum(blockId, modId.orElse("minecraft"), baseTexture.orElse(modId.orElse("minecraft") + ":block/" + blockId), isEnabled.orElse(true), generationType.orElse(GenerationType.BlockState)))
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

    private Stratum(String blockId, String modId, String baseTexture, Boolean isEnabled, GenerationType generationType){
        this.blockId = blockId;
        this.modId = modId;
        this.id =  modId +"_"+ blockId;
        this.baseTexture = baseTexture;
        this.resourceLocation = ()-> new ResourceLocation(modId, blockId);
        this.block = () -> Registry.BLOCK.containsKey(resourceLocation.get()) ? Registry.BLOCK.get(resourceLocation.get()) : null;
        this.generationType = generationType;
        this.isEnabled = isEnabled;
    }

    public GenerationType getGenerationType() {
        return generationType;
    }

    public Boolean isEnabled() {
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
    public static class Builder{

        private String modId;
        private String blockId;
        private Boolean isEnabled;
        private String baseTexture;
        private GenerationType generationType;

        public Builder setModId(String modId) {
            this.modId = modId;
            return this;
        }

        public Builder setBlockId(String blockId) {
            this.blockId = blockId;
            return this;
        }

        public Builder setEnabled(Boolean enabled) {
            isEnabled = enabled;
            return this;
        }

        public Builder setBaseTexture(String baseTexture) {
            this.baseTexture = baseTexture;
            return this;
        }

        public Builder setGenerationType(GenerationType generationType) {
            this.generationType = generationType;
            return this;
        }
        public Stratum build(){
            return new Stratum(this.blockId,this.modId,this.baseTexture,this.isEnabled,this.generationType);
        }
    }
}
