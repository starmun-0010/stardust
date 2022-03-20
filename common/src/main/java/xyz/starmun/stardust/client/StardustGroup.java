package xyz.starmun.stardust.client;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class StardustGroup extends CreativeModeTab {
    public StardustGroup(int id, String string) {
        super(id, string);
    }

    @Override
    public ItemStack makeIcon() {
        return null;
    }
}
