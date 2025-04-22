package io.github.eiot.client;

import io.github.eiot.IotClientOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.impl.JsonUtil;

import java.util.Base64;

/**
 * Converter and mapper for {@link IotClientOptions}.
 * NOTE: This class has been automatically generated from the {@link IotClientOptions} original class using Vert.x codegen.
 */
public class IotClientOptionsConverter {


  private static final Base64.Decoder BASE64_DECODER = JsonUtil.BASE64_DECODER;
  private static final Base64.Encoder BASE64_ENCODER = JsonUtil.BASE64_ENCODER;

  public static void fromJson(Iterable<java.util.Map.Entry<String, Object>> json, IotClientOptions obj) {
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

   static void toJson(IotClientOptions obj, JsonObject json) {
    toJson(obj, json.getMap());
  }

   static void toJson(IotClientOptions obj, java.util.Map<String, Object> json) {
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
