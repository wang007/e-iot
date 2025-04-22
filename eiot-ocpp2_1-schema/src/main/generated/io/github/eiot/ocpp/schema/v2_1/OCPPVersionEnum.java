
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * *(2.1)* This field is ignored, since the OCPP version to use is determined during the websocket handshake. The field is only kept for backwards compatibility with the OCPP 2.0.1 JSON schema.
 * 
 * 
 */
public enum OCPPVersionEnum {

    OCPP_12("OCPP12"),
    OCPP_15("OCPP15"),
    OCPP_16("OCPP16"),
    OCPP_20("OCPP20"),
    OCPP_201("OCPP201"),
    OCPP_21("OCPP21");
    private final String value;
    private final static Map<String, OCPPVersionEnum> CONSTANTS = new HashMap<String, OCPPVersionEnum>();

    static {
        for (OCPPVersionEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    OCPPVersionEnum(String value) {
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
    public static OCPPVersionEnum fromValue(String value) {
        OCPPVersionEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
