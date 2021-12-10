package xyz.starmun.stardust.blocks.colorhandlers;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BlockColorHandler implements BlockColor {
    @Override
    public int getColor(BlockState blockState, @Nullable BlockAndTintGetter blockAndTintGetter, @Nullable BlockPos blockPos, int tintIndex) {
       switch (tintIndex){
           case 0:
               return 0xe2c0aa;
           case 1:
               return 0xd8af93;
           case 2:
               return 0xbc9980;
           case 3:
               return 0xaf8e77;
       }
        return 0xECD8CB;
    }
}
