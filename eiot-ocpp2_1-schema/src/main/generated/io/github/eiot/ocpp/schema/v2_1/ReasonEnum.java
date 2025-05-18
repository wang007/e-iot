
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * The _stoppedReason_ is the reason/event that initiated the process of stopping the transaction. It will normally be the user stopping authorization via card (Local or MasterPass) or app (Remote), but it can also be CSMS revoking authorization (DeAuthorized), or disconnecting the EV when TxStopPoint = EVConnected (EVDisconnected). Most other reasons are related to technical faults or energy limitations. +
 * MAY only be omitted when _stoppedReason_ is "Local"
 * 
 * 
 * 
 * 
 */
public enum ReasonEnum {

    DE_AUTHORIZED("DeAuthorized"),
    EMERGENCY_STOP("EmergencyStop"),
    ENERGY_LIMIT_REACHED("EnergyLimitReached"),
    EV_DISCONNECTED("EVDisconnected"),
    GROUND_FAULT("GroundFault"),
    IMMEDIATE_RESET("ImmediateReset"),
    MASTER_PASS("MasterPass"),
    LOCAL("Local"),
    LOCAL_OUT_OF_CREDIT("LocalOutOfCredit"),
    OTHER("Other"),
    OVERCURRENT_FAULT("OvercurrentFault"),
    POWER_LOSS("PowerLoss"),
    POWER_QUALITY("PowerQuality"),
    REBOOT("Reboot"),
    REMOTE("Remote"),
    SOC_LIMIT_REACHED("SOCLimitReached"),
    STOPPED_BY_EV("StoppedByEV"),
    TIME_LIMIT_REACHED("TimeLimitReached"),
    TIMEOUT("Timeout"),
    REQ_ENERGY_TRANSFER_REJECTED("ReqEnergyTransferRejected");
    private final String value;
    private final static Map<String, ReasonEnum> CONSTANTS = new HashMap<String, ReasonEnum>();

    static {
        for (ReasonEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ReasonEnum(String value) {
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
    public static ReasonEnum fromValue(String value) {
        ReasonEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
