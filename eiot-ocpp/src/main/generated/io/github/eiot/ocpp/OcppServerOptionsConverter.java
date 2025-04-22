package io.github.eiot.ocpp;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.impl.JsonUtil;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

/**
 * Converter and mapper for {@link io.github.eiot.ocpp.OcppServerOptions}.
 * NOTE: This class has been automatically generated from the {@link io.github.eiot.ocpp.OcppServerOptions} original class using Vert.x codegen.
 */
public class OcppServerOptionsConverter {


  private static final Base64.Decoder BASE64_DECODER = JsonUtil.BASE64_DECODER;
  private static final Base64.Encoder BASE64_ENCODER = JsonUtil.BASE64_ENCODER;

   static void fromJson(Iterable<java.util.Map.Entry<String, Object>> json, OcppServerOptions obj) {
    for (java.util.Map.Entry<String, Object> member : json) {
      switch (member.getKey()) {
        case "frameConverter":
          if (member.getValue() instanceof Boolean) {
            obj.setFrameConverter((Boolean)member.getValue());
          }
          break;
        case "ocppVersions":
          if (member.getValue() instanceof JsonArray) {
            java.util.ArrayList<io.github.eiot.ocpp.OcppVersion> list =  new java.util.ArrayList<>();
            ((Iterable<Object>)member.getValue()).forEach( item -> {
              if (item instanceof String)
                list.add(io.github.eiot.ocpp.OcppVersion.valueOf((String)item));
            });
            obj.setOcppVersions(list);
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

   static void toJson(OcppServerOptions obj, JsonObject json) {
    toJson(obj, json.getMap());
  }

   static void toJson(OcppServerOptions obj, java.util.Map<String, Object> json) {
    json.put("frameConverter", obj.isFrameConverter());
    if (obj.getOcppVersions() != null) {
      JsonArray array = new JsonArray();
      obj.getOcppVersions().forEach(item -> array.add(item.name()));
      json.put("ocppVersions", array);
    }
    json.put("setResponseResult", obj.isSetResponseResult());
    json.put("waitResponseTimeout", obj.getWaitResponseTimeout());
  }
}
