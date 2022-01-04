package xyz.starmun.stardust.forge.mixin;

import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Arrays;

@Mixin(net.minecraft.data.Main.class)
public class DataMixin {
    @ModifyVariable(method = "main", at=@At("HEAD"), argsOnly = true)
    private static String[] modifyOutputArg(String[] value){
        if(Arrays.stream(value).filter(element->element.equals("--output")).count() <= 1){
            return value;
        }
        int indexOfOutputArg = ArrayUtils.indexOf(value, "--output");
        return ArrayUtils.remove(ArrayUtils.removeElement(value, indexOfOutputArg),indexOfOutputArg);
    }
}
