package xyz.starmun.stardust.item;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;

public class ItemColorHandler implements ItemColor {
    @Override
    public int getColor(ItemStack itemStack, int tintIndex) {
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
