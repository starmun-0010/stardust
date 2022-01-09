package xyz.starmun.stardust.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;

import java.io.Reader;
import java.util.Optional;

import static xyz.starmun.stardust.Stardust.LOGGER;

public class JsonUtil {
    public static final Gson GSON = new Gson();
    public static Reader reader;
    public static <T> T parseJson(Reader reader, String fileName, Class<T> type) {
        try {
           return GSON.fromJson(reader,type);
        } catch (JsonSyntaxException e) {
            LOGGER.error(String.format("Error occurred parsing file: %s, %s.", fileName,e.getMessage()));
            e.printStackTrace();
        }
        return null;
    }
    public static <T> T parseJson(Reader reader, Codec<T> codec){
        JsonUtil.reader = reader;
        try {
            JsonElement json = GSON.fromJson(reader, JsonElement.class);
            Optional<Pair<T, JsonElement>> result = JsonOps
                      .INSTANCE.withDecoder(codec)
                      .apply(json)
                      .mapError(JsonUtil::onError)
                      .result();
             if(result.isPresent()){
                 return result.get().getFirst();
             }
        } catch (Exception e) {
            LOGGER.error(String.format("Error occurred parsing file: %s.",e.getMessage()));
            e.printStackTrace();
        }
        return null;
    }

    private static String onError(String error) {
        LOGGER.error(String.format("Error occurred parsing file: %s %s",System.lineSeparator(),error.replace(";", System.lineSeparator())));
        return error;
    }
}
