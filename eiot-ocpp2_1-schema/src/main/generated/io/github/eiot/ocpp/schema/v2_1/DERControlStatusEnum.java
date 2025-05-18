
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Result of operation.
 * 
 * 
 * 
 */
public enum DERControlStatusEnum {

    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    NOT_SUPPORTED("NotSupported"),
    NOT_FOUND("NotFound");
    private final String value;
    private final static Map<String, DERControlStatusEnum> CONSTANTS = new HashMap<String, DERControlStatusEnum>();

    static {
        for (DERControlStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    DERControlStatusEnum(String value) {
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
    public static DERControlStatusEnum fromValue(String value) {
        DERControlStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
