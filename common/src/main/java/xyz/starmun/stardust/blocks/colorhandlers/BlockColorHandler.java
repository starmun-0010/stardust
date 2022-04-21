package xyz.starmun.stardust.blocks.colorhandlers;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import xyz.starmun.stardust.blocks.StateBasedOreBlock;
import xyz.starmun.stardust.item.StardustItem;

public class BlockColorHandler implements BlockColor {
    @Override
    public int getColor(BlockState blockState, @Nullable BlockAndTintGetter blockAndTintGetter, @Nullable BlockPos blockPos, int tintIndex) {
        try {
            return Integer.decode(((StateBasedOreBlock)blockState.getBlock()).colors[tintIndex]);
        }
        catch (Exception ex){

        }
        return 0xFF00FF;
    }
}
