package xyz.starmun.stardust.datamodels;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class Stratum {
    public String blockId;
    public String modId;
    public final String id;
    public final Supplier<ResourceLocation> resourceLocation = ()-> new ResourceLocation(modId, blockId);

    public Supplier<Block> block;public static final Codec<Stratum> CODEC = RecordCodecBuilder.create((instance)->
        instance.group(
                Codec.STRING.fieldOf("modId").forGetter((Stratum stratum)-> stratum.modId),
                Codec.STRING.fieldOf("blockId").forGetter((Stratum stratum)-> stratum.blockId))
                .apply(instance, (modId,blockId)->new Stratum(blockId,modId))
        );

    public Stratum(String blockId, String modId){
        this.blockId = blockId;
        this.modId = modId;
        this.id =  modId +"_"+ blockId;
        this.block = () -> Registry.BLOCK.containsKey(resourceLocation.get()) ? Registry.BLOCK.get(resourceLocation.get()) : null;
    }
}
