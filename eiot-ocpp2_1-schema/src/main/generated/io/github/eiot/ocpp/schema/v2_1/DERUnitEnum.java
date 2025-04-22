
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Unit of the Y-axis of DER curve
 * 
 * 
 */
public enum DERUnitEnum {

    NOT_APPLICABLE("Not_Applicable"),
    PCT_MAX_W("PctMaxW"),
    PCT_MAX_VAR("PctMaxVar"),
    PCT_W_AVAIL("PctWAvail"),
    PCT_VAR_AVAIL("PctVarAvail"),
    PCT_EFFECTIVE_V("PctEffectiveV");
    private final String value;
    private final static Map<String, DERUnitEnum> CONSTANTS = new HashMap<String, DERUnitEnum>();

    static {
        for (DERUnitEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    DERUnitEnum(String value) {
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
    public static DERUnitEnum fromValue(String value) {
        DERUnitEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
