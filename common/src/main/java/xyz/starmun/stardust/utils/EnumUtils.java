package xyz.starmun.stardust.utils;

import com.google.common.base.Enums;
import xyz.starmun.stardust.Stardust;

import java.util.EnumSet;
import java.util.stream.Collectors;

public class EnumUtils {
    public static  <T extends Enum<T>> T fromStringToEnum(Class<T> enumType, String value) {
        if(value != null && Enums.getIfPresent(enumType,value).isPresent()){
            return Enum.valueOf(enumType,value);
        }
        String error = value + " is not a valid value for "+enumType.getName()
                + System.lineSeparator() + "Valid values are: "
                +  EnumSet.allOf(enumType).stream().map(e->e.toString())
                .collect(Collectors.joining(", "));
        Stardust.LOGGER.error(error);
        return null;
    }

    public static <T extends Enum<T>> String fromEnumToString(T enumValue) {
        if(enumValue == null){
            return "";
        }
        return enumValue.name();
    }
}
