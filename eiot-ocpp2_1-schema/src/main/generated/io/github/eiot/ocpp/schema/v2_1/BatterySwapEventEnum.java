
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Battery in/out
 * 
 * 
 */
public enum BatterySwapEventEnum {

    BATTERY_IN("BatteryIn"),
    BATTERY_OUT("BatteryOut"),
    BATTERY_OUT_TIMEOUT("BatteryOutTimeout");
    private final String value;
    private final static Map<String, BatterySwapEventEnum> CONSTANTS = new HashMap<String, BatterySwapEventEnum>();

    static {
        for (BatterySwapEventEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    BatterySwapEventEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static BatterySwapEventEnum fromValue(String value) {
        BatterySwapEventEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
