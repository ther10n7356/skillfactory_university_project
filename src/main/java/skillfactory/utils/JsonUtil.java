package skillfactory.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import skillfactory.models.Student;
import skillfactory.models.University;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    private static final Gson gson = new Gson();

    private JsonUtil() {}

    public static String getJsonFromObject(Object object) {
        return gson.toJson(object);
    }

    public static String getJsonFromList(List<?> objects) {
        return gson.toJson(objects);
    }

    public static <T> T getObjectFromJson(String json, Class<T> object) {
        return gson.fromJson(json, object);
    }
}
