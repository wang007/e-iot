
package io.github.eiot.ocpp.schema.v1_6;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;


/**
 * TriggerMessageRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "requestedMessage",
    "connectorId"
})
public class TriggerMessageRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestedMessage")
    @NotNull
    private TriggerMessageRequest.RequestedMessage requestedMessage;
    @JsonProperty("connectorId")
    private int connectorId;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestedMessage")
    public TriggerMessageRequest.RequestedMessage getRequestedMessage() {
        return requestedMessage;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestedMessage")
    public void setRequestedMessage(TriggerMessageRequest.RequestedMessage requestedMessage) {
        this.requestedMessage = requestedMessage;
    }

    public TriggerMessageRequest withRequestedMessage(TriggerMessageRequest.RequestedMessage requestedMessage) {
        this.requestedMessage = requestedMessage;
        return this;
    }

    @JsonProperty("connectorId")
    public int getConnectorId() {
        return connectorId;
    }

    @JsonProperty("connectorId")
    public void setConnectorId(int connectorId) {
        this.connectorId = connectorId;
    }

    public TriggerMessageRequest withConnectorId(int connectorId) {
        this.connectorId = connectorId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TriggerMessageRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("requestedMessage");
        sb.append('=');
        sb.append(((this.requestedMessage == null)?"<null>":this.requestedMessage));
        sb.append(',');
        sb.append("connectorId");
        sb.append('=');
        sb.append(this.connectorId);
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.requestedMessage == null)? 0 :this.requestedMessage.hashCode()));
        result = ((result* 31)+ this.connectorId);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TriggerMessageRequest) == false) {
            return false;
        }
        TriggerMessageRequest rhs = ((TriggerMessageRequest) other);
        return (((this.requestedMessage == rhs.requestedMessage)||((this.requestedMessage!= null)&&this.requestedMessage.equals(rhs.requestedMessage)))&&(this.connectorId == rhs.connectorId));
    }

    public enum RequestedMessage {

        BOOT_NOTIFICATION("BootNotification"),
        DIAGNOSTICS_STATUS_NOTIFICATION("DiagnosticsStatusNotification"),
        FIRMWARE_STATUS_NOTIFICATION("FirmwareStatusNotification"),
        HEARTBEAT("Heartbeat"),
        METER_VALUES("MeterValues"),
        STATUS_NOTIFICATION("StatusNotification");
        private final String value;
        private final static Map<String, TriggerMessageRequest.RequestedMessage> CONSTANTS = new HashMap<String, TriggerMessageRequest.RequestedMessage>();

        static {
            for (TriggerMessageRequest.RequestedMessage c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        RequestedMessage(String value) {
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
        public static TriggerMessageRequest.RequestedMessage fromValue(String value) {
            TriggerMessageRequest.RequestedMessage constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
