
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * The status of the settlement attempt.
 * 
 * 
 * 
 */
public enum PaymentStatusEnum {

    SETTLED("Settled"),
    CANCELED("Canceled"),
    REJECTED("Rejected"),
    FAILED("Failed");
    private final String value;
    private final static Map<String, PaymentStatusEnum> CONSTANTS = new HashMap<String, PaymentStatusEnum>();

    static {
        for (PaymentStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    PaymentStatusEnum(String value) {
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
    public static PaymentStatusEnum fromValue(String value) {
        PaymentStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
