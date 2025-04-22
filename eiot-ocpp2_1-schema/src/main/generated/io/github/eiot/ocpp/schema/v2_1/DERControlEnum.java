
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Name of control settings to clear. Not used when _controlId_ is provided.
 * 
 * 
 * 
 */
public enum DERControlEnum {

    ENTER_SERVICE("EnterService"),
    FREQ_DROOP("FreqDroop"),
    FREQ_WATT("FreqWatt"),
    FIXED_PF_ABSORB("FixedPFAbsorb"),
    FIXED_PF_INJECT("FixedPFInject"),
    FIXED_VAR("FixedVar"),
    GRADIENTS("Gradients"),
    HF_MUST_TRIP("HFMustTrip"),
    HF_MAY_TRIP("HFMayTrip"),
    HV_MUST_TRIP("HVMustTrip"),
    HV_MOM_CESS("HVMomCess"),
    HV_MAY_TRIP("HVMayTrip"),
    LIMIT_MAX_DISCHARGE("LimitMaxDischarge"),
    LF_MUST_TRIP("LFMustTrip"),
    LV_MUST_TRIP("LVMustTrip"),
    LV_MOM_CESS("LVMomCess"),
    LV_MAY_TRIP("LVMayTrip"),
    POWER_MONITORING_MUST_TRIP("PowerMonitoringMustTrip"),
    VOLT_VAR("VoltVar"),
    VOLT_WATT("VoltWatt"),
    WATT_PF("WattPF"),
    WATT_VAR("WattVar");
    private final String value;
    private final static Map<String, DERControlEnum> CONSTANTS = new HashMap<String, DERControlEnum>();

    static {
        for (DERControlEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    DERControlEnum(String value) {
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
    public static DERControlEnum fromValue(String value) {
        DERControlEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
