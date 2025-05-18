
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Source of status: OCSP, CRL
 * 
 * 
 */
public enum CertificateStatusSourceEnum {

    CRL("CRL"),
    OCSP("OCSP");
    private final String value;
    private final static Map<String, CertificateStatusSourceEnum> CONSTANTS = new HashMap<String, CertificateStatusSourceEnum>();

    static {
        for (CertificateStatusSourceEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    CertificateStatusSourceEnum(String value) {
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
    public static CertificateStatusSourceEnum fromValue(String value) {
        CertificateStatusSourceEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
