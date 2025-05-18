
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Type of cost dimension: energy, power, time, etc.
 * 
 * 
 * 
 */
public enum CostDimensionEnum {

    ENERGY("Energy"),
    MAX_CURRENT("MaxCurrent"),
    MIN_CURRENT("MinCurrent"),
    MAX_POWER("MaxPower"),
    MIN_POWER("MinPower"),
    IDLE_T_IME("IdleTIme"),
    CHARGING_TIME("ChargingTime");
    private final String value;
    private final static Map<String, CostDimensionEnum> CONSTANTS = new HashMap<String, CostDimensionEnum>();

    static {
        for (CostDimensionEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    CostDimensionEnum(String value) {
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
    public static CostDimensionEnum fromValue(String value) {
        CostDimensionEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
