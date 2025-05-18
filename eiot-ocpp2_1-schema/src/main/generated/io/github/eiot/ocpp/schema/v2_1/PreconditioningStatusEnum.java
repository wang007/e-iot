
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * *(2.1)* The current preconditioning status of the BMS in the EV. Default value is Unknown.
 * 
 * 
 */
public enum PreconditioningStatusEnum {

    UNKNOWN("Unknown"),
    READY("Ready"),
    NOT_READY("NotReady"),
    PRECONDITIONING("Preconditioning");
    private final String value;
    private final static Map<String, PreconditioningStatusEnum> CONSTANTS = new HashMap<String, PreconditioningStatusEnum>();

    static {
        for (PreconditioningStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    PreconditioningStatusEnum(String value) {
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
    public static PreconditioningStatusEnum fromValue(String value) {
        PreconditioningStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
