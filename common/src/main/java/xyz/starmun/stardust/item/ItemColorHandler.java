package xyz.starmun.stardust.item;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;

public class ItemColorHandler implements ItemColor {
    @Override
    public int getColor(ItemStack itemStack, int tintIndex) {
       try {
           return Integer.decode(((StardustItem)itemStack.getItem()).colors[tintIndex]);
       }
       catch (Exception ex){

       }
        return 0xFF00FF;
    }
}
