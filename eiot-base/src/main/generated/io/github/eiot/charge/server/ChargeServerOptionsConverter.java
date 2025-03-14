package io.github.eiot.charge.server;

import io.github.eiot.charge.FrameCodecOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.impl.JsonUtil;

import java.util.Base64;

/**
 * Converter and mapper for {@link ChargeServerOptions}.
 * NOTE: This class has been automatically generated from the {@link ChargeServerOptions} original class using Vert.x codegen.
 */
public class ChargeServerOptionsConverter {


  private static final Base64.Decoder BASE64_DECODER = JsonUtil.BASE64_DECODER;
  private static final Base64.Encoder BASE64_ENCODER = JsonUtil.BASE64_ENCODER;

   static void fromJson(Iterable<java.util.Map.Entry<String, Object>> json, ChargeServerOptions obj) {
    for (java.util.Map.Entry<String, Object> member : json) {
      switch (member.getKey()) {
        case "frameCodecOptions":
          if (member.getValue() instanceof JsonObject) {
            obj.setFrameCodecOptions(new FrameCodecOptions((io.vertx.core.json.JsonObject)member.getValue()));
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

   static void toJson(ChargeServerOptions obj, JsonObject json) {
    toJson(obj, json.getMap());
  }

   static void toJson(ChargeServerOptions obj, java.util.Map<String, Object> json) {
    if (obj.getFrameCodecOptions() != null) {
      json.put("frameCodecOptions", obj.getFrameCodecOptions().toJson());
    }
    json.put("frameConverter", obj.isFrameConverter());
    if (obj.getProtocol() != null) {
      json.put("protocol", obj.getProtocol());
    }
    json.put("setResponseResult", obj.isSetResponseResult());
    json.put("waitResponseTimeout", obj.getWaitResponseTimeout());
  }
}
