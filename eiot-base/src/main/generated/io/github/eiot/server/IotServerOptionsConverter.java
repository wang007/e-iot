package io.github.eiot.server;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.impl.JsonUtil;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

/**
 * Converter and mapper for {@link io.github.eiot.server.IotServerOptions}.
 * NOTE: This class has been automatically generated from the {@link io.github.eiot.server.IotServerOptions} original class using Vert.x codegen.
 */
public class IotServerOptionsConverter {


  private static final Base64.Decoder BASE64_DECODER = JsonUtil.BASE64_DECODER;
  private static final Base64.Encoder BASE64_ENCODER = JsonUtil.BASE64_ENCODER;

   static void fromJson(Iterable<java.util.Map.Entry<String, Object>> json, IotServerOptions obj) {
    for (java.util.Map.Entry<String, Object> member : json) {
      switch (member.getKey()) {
        case "frameCodecOptions":
          if (member.getValue() instanceof JsonObject) {
            obj.setFrameCodecOptions(new io.github.eiot.FrameCodecOptions((io.vertx.core.json.JsonObject)member.getValue()));
          }
          break;
        case "frameConverter":
          if (member.getValue() instanceof Boolean) {
            obj.setFrameConverter((Boolean)member.getValue());
          }
          break;
        case "protocol":
          if (member.getValue() instanceof String) {
            obj.setProtocol((String)member.getValue());
          }
          break;
        case "seqNoMatchFirst":
          if (member.getValue() instanceof Boolean) {
            obj.setSeqNoMatchFirst((Boolean)member.getValue());
          }
          break;
        case "setResponseResult":
          if (member.getValue() instanceof Boolean) {
            obj.setSetResponseResult((Boolean)member.getValue());
          }
          break;
        case "waitResponseTimeout":
          if (member.getValue() instanceof Number) {
            obj.setWaitResponseTimeout(((Number)member.getValue()).intValue());
          }
          break;
      }
    }
  }

   static void toJson(IotServerOptions obj, JsonObject json) {
    toJson(obj, json.getMap());
  }

   static void toJson(IotServerOptions obj, java.util.Map<String, Object> json) {
    if (obj.getFrameCodecOptions() != null) {
      json.put("frameCodecOptions", obj.getFrameCodecOptions().toJson());
    }
    json.put("frameConverter", obj.isFrameConverter());
    if (obj.getProtocol() != null) {
      json.put("protocol", obj.getProtocol());
    }
    json.put("seqNoMatchFirst", obj.isSeqNoMatchFirst());
    json.put("setResponseResult", obj.isSetResponseResult());
    json.put("waitResponseTimeout", obj.getWaitResponseTimeout());
  }
}
