package xyz.starmun.stardust.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.Reader;

import static xyz.starmun.stardust.Stardust.LOGGER;

public class JsonUtil {
    public static <T> T parseJson(Reader reader, String fileName, Class<T> type) {
        Gson gson = new Gson();
        try {
           return gson.fromJson(reader,type);
        } catch (JsonSyntaxException e) {
            LOGGER.error(String.format("Error occurred parsing file: %s, invalid syntax.", fileName));
        }
        return null;
    }
}
