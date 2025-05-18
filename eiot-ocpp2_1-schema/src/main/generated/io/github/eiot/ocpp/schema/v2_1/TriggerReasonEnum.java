
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Reason the Charging Station sends this message to the CSMS
 * 
 * 
 */
public enum TriggerReasonEnum {

    ABNORMAL_CONDITION("AbnormalCondition"),
    AUTHORIZED("Authorized"),
    CABLE_PLUGGED_IN("CablePluggedIn"),
    CHARGING_RATE_CHANGED("ChargingRateChanged"),
    CHARGING_STATE_CHANGED("ChargingStateChanged"),
    COST_LIMIT_REACHED("CostLimitReached"),
    DEAUTHORIZED("Deauthorized"),
    ENERGY_LIMIT_REACHED("EnergyLimitReached"),
    EV_COMMUNICATION_LOST("EVCommunicationLost"),
    EV_CONNECT_TIMEOUT("EVConnectTimeout"),
    EV_DEPARTED("EVDeparted"),
    EV_DETECTED("EVDetected"),
    LIMIT_SET("LimitSet"),
    METER_VALUE_CLOCK("MeterValueClock"),
    METER_VALUE_PERIODIC("MeterValuePeriodic"),
    OPERATION_MODE_CHANGED("OperationModeChanged"),
    REMOTE_START("RemoteStart"),
    REMOTE_STOP("RemoteStop"),
    RESET_COMMAND("ResetCommand"),
    RUNNING_COST("RunningCost"),
    SIGNED_DATA_RECEIVED("SignedDataReceived"),
    SO_C_LIMIT_REACHED("SoCLimitReached"),
    STOP_AUTHORIZED("StopAuthorized"),
    TARIFF_CHANGED("TariffChanged"),
    TARIFF_NOT_ACCEPTED("TariffNotAccepted"),
    TIME_LIMIT_REACHED("TimeLimitReached"),
    TRIGGER("Trigger"),
    TX_RESUMED("TxResumed"),
    UNLOCK_COMMAND("UnlockCommand");
    private final String value;
    private final static Map<String, TriggerReasonEnum> CONSTANTS = new HashMap<String, TriggerReasonEnum>();

    static {
        for (TriggerReasonEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    TriggerReasonEnum(String value) {
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
    public static TriggerReasonEnum fromValue(String value) {
        TriggerReasonEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
