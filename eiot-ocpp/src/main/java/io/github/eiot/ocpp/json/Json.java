package io.github.eiot.ocpp.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.vertx.core.json.jackson.VertxModule;

/**
 *
 *
 * created by wang007 on 2025/4/27
 */
public class Json {

    public static final ObjectMapper OM = new ObjectMapper()
            .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
            .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .registerModule(new JavaTimeModule())
            .registerModule(new VertxModule());

    public static final ObjectMapper OM_IGNORE_NULL = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
            .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .registerModule(new JavaTimeModule())
            .registerModule(new VertxModule());

    public static final ObjectMapper PRETTY_OM = new ObjectMapper()
            .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
            .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(SerializationFeature.INDENT_OUTPUT, true)
            .registerModule(new JavaTimeModule())
            .registerModule(new VertxModule());


    public static <T> T fromJson(String json, Class<T> type) {
        if (json == null) {
            return null;
        }
        try {
            return OM.readValue(json, type);
        } catch (Exception e) {
            throw new DecodeException("Failed to decode: " + e.getMessage(), e);
        }
    }


    public static <T> T fromJson(String json, TypeReference<T> type) {
        if (json == null) {
            return null;
        }
        try {
            return OM.readValue(json, type);
        } catch (Exception e) {
            throw new DecodeException("Failed to decode: " + e.getMessage(), e);
        }
    }

    public static <T> T fromJson(String json, JavaType type) {
        if (json == null) {
            return null;
        }
        try {
            return OM.readValue(json, type);
        } catch (Exception e) {
            throw new DecodeException("Failed to decode: " + e.getMessage(), e);
        }
    }


    public static String toJson(Object obj) {
        try {
            return OM.writeValueAsString(obj);
        } catch (Exception var2) {
            throw new EncodeException(var2.getMessage(), var2);
        }
    }

    public static String toJsonIgnoreNull(Object obj) {
        try {
            return OM_IGNORE_NULL.writeValueAsString(obj);
        } catch (Exception var2) {
            throw new EncodeException(var2.getMessage(), var2);
        }
    }

    public static String toPrettyJson(Object obj) {
        try {
            return PRETTY_OM.writeValueAsString(obj);
        } catch (Exception var2) {
            throw new EncodeException(var2.getMessage(), var2);
        }
    }

}
