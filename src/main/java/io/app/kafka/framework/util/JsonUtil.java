package io.app.kafka.framework.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

/**
 * This class is to parse the JSON and form a JSON.
 *
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public final class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public static <T> T fromJson(String inJson, TypeReference<T> inReference) {
        T t = null;
        try {
            t = getObjectMapper().readValue(inJson, new TypeReference<T>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static String toJson(Object object) {
        String s = null;
        try {
            s = getObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }
}
