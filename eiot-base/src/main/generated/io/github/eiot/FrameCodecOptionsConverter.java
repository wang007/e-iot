package io.github.eiot;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.impl.JsonUtil;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

/**
 * Converter and mapper for {@link io.github.eiot.FrameCodecOptions}.
 * NOTE: This class has been automatically generated from the {@link io.github.eiot.FrameCodecOptions} original class using Vert.x codegen.
 */
public class FrameCodecOptionsConverter {


  private static final Base64.Decoder BASE64_DECODER = JsonUtil.BASE64_DECODER;
  private static final Base64.Encoder BASE64_ENCODER = JsonUtil.BASE64_ENCODER;

   static void fromJson(Iterable<java.util.Map.Entry<String, Object>> json, FrameCodecOptions obj) {
    for (java.util.Map.Entry<String, Object> member : json) {
      switch (member.getKey()) {
        case "lengthAdjustment":
          if (member.getValue() instanceof Number) {
            obj.setLengthAdjustment(((Number)member.getValue()).intValue());
          }
          break;
        case "lengthFieldLength":
          if (member.getValue() instanceof Number) {
            obj.setLengthFieldLength(((Number)member.getValue()).intValue());
          }
          break;
        case "lengthFieldOffset":
          if (member.getValue() instanceof Number) {
            obj.setLengthFieldOffset(((Number)member.getValue()).intValue());
          }
          break;
        case "maxFrameLength":
          if (member.getValue() instanceof Number) {
            obj.setMaxFrameLength(((Number)member.getValue()).intValue());
          }
          break;
      }
    }
  }

   static void toJson(FrameCodecOptions obj, JsonObject json) {
    toJson(obj, json.getMap());
  }

   static void toJson(FrameCodecOptions obj, java.util.Map<String, Object> json) {
    json.put("lengthAdjustment", obj.getLengthAdjustment());
    json.put("lengthFieldLength", obj.getLengthFieldLength());
    json.put("lengthFieldOffset", obj.getLengthFieldOffset());
    json.put("maxFrameLength", obj.getMaxFrameLength());
  }
}
