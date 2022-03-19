package xyz.starmun.stardust.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import xyz.starmun.stardust.Stardust;

import java.io.Reader;
import java.util.Optional;

import static xyz.starmun.stardust.Stardust.LOGGER;

public class JsonUtils {
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
        JsonUtils.reader = reader;
        try {
            JsonElement json = GSON.fromJson(reader, JsonElement.class);
            Optional<Pair<T, JsonElement>> result = JsonOps
                      .INSTANCE.withDecoder(codec)
                      .apply(json)
                      .mapError(JsonUtils::onError)
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

    private static String onSerializationError(String error) {
        Stardust.LOGGER.error(error);
        return error;
    }

    public static <T> Optional<JsonElement> serializeToJson(T data, Codec<T> codec) {
       return JsonOps.INSTANCE.withEncoder(codec)
                .apply(data)
                .mapError(JsonUtils::onSerializationError)
                .result();
    }
}
