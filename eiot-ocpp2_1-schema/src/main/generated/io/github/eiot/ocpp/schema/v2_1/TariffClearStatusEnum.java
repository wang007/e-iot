
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TariffClearStatusEnum {

    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    NO_TARIFF("NoTariff");
    private final String value;
    private final static Map<String, TariffClearStatusEnum> CONSTANTS = new HashMap<String, TariffClearStatusEnum>();

    static {
        for (TariffClearStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    TariffClearStatusEnum(String value) {
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
    public static TariffClearStatusEnum fromValue(String value) {
        TariffClearStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
