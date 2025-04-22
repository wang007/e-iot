
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Type of grid event that caused this
 * 
 * 
 * 
 */
public enum GridEventFaultEnum {

    CURRENT_IMBALANCE("CurrentImbalance"),
    LOCAL_EMERGENCY("LocalEmergency"),
    LOW_INPUT_POWER("LowInputPower"),
    OVER_CURRENT("OverCurrent"),
    OVER_FREQUENCY("OverFrequency"),
    OVER_VOLTAGE("OverVoltage"),
    PHASE_ROTATION("PhaseRotation"),
    REMOTE_EMERGENCY("RemoteEmergency"),
    UNDER_FREQUENCY("UnderFrequency"),
    UNDER_VOLTAGE("UnderVoltage"),
    VOLTAGE_IMBALANCE("VoltageImbalance");
    private final String value;
    private final static Map<String, GridEventFaultEnum> CONSTANTS = new HashMap<String, GridEventFaultEnum>();

    static {
        for (GridEventFaultEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    GridEventFaultEnum(String value) {
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
    public static GridEventFaultEnum fromValue(String value) {
        GridEventFaultEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
