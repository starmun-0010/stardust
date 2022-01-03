package xyz.starmun.stardust.datamodels;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class Stratum {
    public static final Codec<Stratum> CODEC = RecordCodecBuilder.create((instance)->
        instance.group(
                Codec.STRING.fieldOf("modId").forGetter((Stratum stratum)-> stratum.modId),
                Codec.STRING.fieldOf("blockId").forGetter((Stratum stratum)-> stratum.blockId))
                .apply(instance, (modId,blockId)->new Stratum(blockId,modId))
        );
    public static final ImmutableList<Stratum> STRATA = ImmutableList.<Stratum>builder()
            .add(new Stratum("stone","minecraft"))
            .add(new Stratum("gravel","minecraft"))
            .add(new Stratum("andesite","minecraft"))
            .add(new Stratum("diorite","minecraft"))
            .add(new Stratum("granite","minecraft"))
            .add(new Stratum("sandstone","minecraft"))
            .add(new Stratum("sand","minecraft"))
            .build();

    public String blockId;
    public String modId;
    public final String id;
    public final Supplier<ResourceLocation> resourceLocation = ()-> new ResourceLocation(modId, blockId);
    public Supplier<Block> block;
    public Stratum(String blockId, String modId){
        this.blockId = blockId;
        this.modId = modId;
        this.id =  modId +"_"+ blockId;
        this.block = () -> Registry.BLOCK.containsKey(resourceLocation.get()) ? Registry.BLOCK.get(resourceLocation.get()) : null;
    }
}
