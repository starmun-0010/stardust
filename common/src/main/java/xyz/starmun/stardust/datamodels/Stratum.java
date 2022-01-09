package xyz.starmun.stardust.datamodels;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class Stratum {

    public final String id;
    public final String modId;
    public final String blockId;
    public final String baseTexture;
    public final Supplier<Block> block;
    public final Supplier<ResourceLocation> resourceLocation;

    private static DataResult<String> ee(String o) {
        return DataResult.success(o);
    }

    public static final Codec<Stratum> CODEC = RecordCodecBuilder.create((instance)->
        instance.group(

                Codec.STRING.fieldOf("modId").forGetter((Stratum stratum)-> stratum.modId),
                Codec.STRING.fieldOf("blockId").forGetter((Stratum stratum)-> stratum.blockId),
                Codec.STRING.fieldOf("baseTexture").forGetter((Stratum stratum)-> stratum.baseTexture))
                .apply(instance, (modId,blockId,baseTexture)-> new Stratum(blockId, modId, baseTexture))

    );

    public Stratum(String blockId, String modId, String baseTexture){
        this.blockId = blockId;
        this.modId = modId;
        this.id =  modId +"_"+ blockId;
        this.baseTexture = baseTexture;
        this.resourceLocation = ()-> new ResourceLocation(modId, blockId);
        this.block = () -> Registry.BLOCK.containsKey(resourceLocation.get()) ? Registry.BLOCK.get(resourceLocation.get()) : null;
    }
}
