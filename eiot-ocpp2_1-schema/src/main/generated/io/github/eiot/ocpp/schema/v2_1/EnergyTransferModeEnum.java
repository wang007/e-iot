
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EnergyTransferModeEnum {

    AC_SINGLE_PHASE("AC_single_phase"),
    AC_TWO_PHASE("AC_two_phase"),
    AC_THREE_PHASE("AC_three_phase"),
    DC("DC"),
    AC_BPT("AC_BPT"),
    AC_BPT_DER("AC_BPT_DER"),
    AC_DER("AC_DER"),
    DC_BPT("DC_BPT"),
    DC_ACDP("DC_ACDP"),
    DC_ACDP_BPT("DC_ACDP_BPT"),
    WPT("WPT");
    private final String value;
    private final static Map<String, EnergyTransferModeEnum> CONSTANTS = new HashMap<String, EnergyTransferModeEnum>();

    static {
        for (EnergyTransferModeEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    EnergyTransferModeEnum(String value) {
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
    public static EnergyTransferModeEnum fromValue(String value) {
        EnergyTransferModeEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
