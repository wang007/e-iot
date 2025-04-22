
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Status of the operation
 * 
 * 
 */
public enum TariffChangeStatusEnum {

    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    TOO_MANY_ELEMENTS("TooManyElements"),
    CONDITION_NOT_SUPPORTED("ConditionNotSupported"),
    TX_NOT_FOUND("TxNotFound"),
    NO_CURRENCY_CHANGE("NoCurrencyChange");
    private final String value;
    private final static Map<String, TariffChangeStatusEnum> CONSTANTS = new HashMap<String, TariffChangeStatusEnum>();

    static {
        for (TariffChangeStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    TariffChangeStatusEnum(String value) {
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
    public static TariffChangeStatusEnum fromValue(String value) {
        TariffChangeStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
