
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum IslandingDetectionEnum {

    NO_ANTI_ISLANDING_SUPPORT("NoAntiIslandingSupport"),
    RO_CO_F("RoCoF"),
    UVP_OVP("UVP_OVP"),
    UFP_OFP("UFP_OFP"),
    VOLTAGE_VECTOR_SHIFT("VoltageVectorShift"),
    ZERO_CROSSING_DETECTION("ZeroCrossingDetection"),
    OTHER_PASSIVE("OtherPassive"),
    IMPEDANCE_MEASUREMENT("ImpedanceMeasurement"),
    IMPEDANCE_AT_FREQUENCY("ImpedanceAtFrequency"),
    SLIP_MODE_FREQUENCY_SHIFT("SlipModeFrequencyShift"),
    SANDIA_FREQUENCY_SHIFT("SandiaFrequencyShift"),
    SANDIA_VOLTAGE_SHIFT("SandiaVoltageShift"),
    FREQUENCY_JUMP("FrequencyJump"),
    RCLQ_FACTOR("RCLQFactor"),
    OTHER_ACTIVE("OtherActive");
    private final String value;
    private final static Map<String, IslandingDetectionEnum> CONSTANTS = new HashMap<String, IslandingDetectionEnum>();

    static {
        for (IslandingDetectionEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    IslandingDetectionEnum(String value) {
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
    public static IslandingDetectionEnum fromValue(String value) {
        IslandingDetectionEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
