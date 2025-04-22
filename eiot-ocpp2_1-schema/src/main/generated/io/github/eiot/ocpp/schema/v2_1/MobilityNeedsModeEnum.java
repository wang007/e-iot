
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * *(2.1)* Value of EVCC indicates that EV determines min/target SOC and departure time. +
 * A value of EVCC_SECC indicates that charging station or CSMS may also update min/target SOC and departure time. +
 * *ISO 15118-20:* +
 * ServiceSelectionReq(SelectedEnergyTransferService)
 * 
 * 
 */
public enum MobilityNeedsModeEnum {

    EVCC("EVCC"),
    EVCC_SECC("EVCC_SECC");
    private final String value;
    private final static Map<String, MobilityNeedsModeEnum> CONSTANTS = new HashMap<String, MobilityNeedsModeEnum>();

    static {
        for (MobilityNeedsModeEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    MobilityNeedsModeEnum(String value) {
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
    public static MobilityNeedsModeEnum fromValue(String value) {
        MobilityNeedsModeEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
