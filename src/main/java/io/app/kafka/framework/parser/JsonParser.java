package io.app.kafka.framework.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import io.app.kafka.framework.util.JsonUtil;

import java.util.Map;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public class JsonParser<T> {

    private JsonUtil jsonUtil;

    /**
     * this is a method which parses json.
     * @param inJson
     * @param <T>
     * @return
     */

    public static<T> T parseJson(String inJson) {
        Map<String, Object> jsonObject = JsonUtil.fromJson(inJson, new TypeReference<Map<String, Object>>() {});
        return (T) jsonObject;
    }

}
