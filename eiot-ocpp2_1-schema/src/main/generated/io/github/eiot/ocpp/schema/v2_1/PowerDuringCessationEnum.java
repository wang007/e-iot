
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Parameter is only sent, if the EV has to feed-in power or reactive power during fault-ride through (FRT) as defined by HVMomCess curve and LVMomCess curve.
 * 
 * 
 * 
 * 
 */
public enum PowerDuringCessationEnum {

    ACTIVE("Active"),
    REACTIVE("Reactive");
    private final String value;
    private final static Map<String, PowerDuringCessationEnum> CONSTANTS = new HashMap<String, PowerDuringCessationEnum>();

    static {
        for (PowerDuringCessationEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    PowerDuringCessationEnum(String value) {
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
    public static PowerDuringCessationEnum fromValue(String value) {
        PowerDuringCessationEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
