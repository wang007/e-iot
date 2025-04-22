
package io.github.eiot.ocpp.schema.v1_6;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * StatusNotificationRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectorId",
    "errorCode",
    "info",
    "status",
    "timestamp",
    "vendorId",
    "vendorErrorCode"
})
public class StatusNotificationRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("connectorId")
    @NotNull
    private int connectorId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("errorCode")
    @NotNull
    private StatusNotificationRequest.ErrorCode errorCode;
    @JsonProperty("info")
    @Size(max = 50)
    private String info;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @NotNull
    private StatusNotificationRequest.Status status;
    @JsonProperty("timestamp")
    private ZonedDateTime timestamp;
    @JsonProperty("vendorId")
    @Size(max = 255)
    private String vendorId;
    @JsonProperty("vendorErrorCode")
    @Size(max = 50)
    private String vendorErrorCode;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("connectorId")
    public int getConnectorId() {
        return connectorId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("connectorId")
    public void setConnectorId(int connectorId) {
        this.connectorId = connectorId;
    }

    public StatusNotificationRequest withConnectorId(int connectorId) {
        this.connectorId = connectorId;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("errorCode")
    public StatusNotificationRequest.ErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("errorCode")
    public void setErrorCode(StatusNotificationRequest.ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public StatusNotificationRequest withErrorCode(StatusNotificationRequest.ErrorCode errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    @JsonProperty("info")
    public String getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(String info) {
        this.info = info;
    }

    public StatusNotificationRequest withInfo(String info) {
        this.info = info;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public StatusNotificationRequest.Status getStatus() {
        return status;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public void setStatus(StatusNotificationRequest.Status status) {
        this.status = status;
    }

    public StatusNotificationRequest withStatus(StatusNotificationRequest.Status status) {
        this.status = status;
        return this;
    }

    @JsonProperty("timestamp")
    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public StatusNotificationRequest withTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @JsonProperty("vendorId")
    public String getVendorId() {
        return vendorId;
    }

    @JsonProperty("vendorId")
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public StatusNotificationRequest withVendorId(String vendorId) {
        this.vendorId = vendorId;
        return this;
    }

    @JsonProperty("vendorErrorCode")
    public String getVendorErrorCode() {
        return vendorErrorCode;
    }

    @JsonProperty("vendorErrorCode")
    public void setVendorErrorCode(String vendorErrorCode) {
        this.vendorErrorCode = vendorErrorCode;
    }

    public StatusNotificationRequest withVendorErrorCode(String vendorErrorCode) {
        this.vendorErrorCode = vendorErrorCode;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StatusNotificationRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("connectorId");
        sb.append('=');
        sb.append(this.connectorId);
        sb.append(',');
        sb.append("errorCode");
        sb.append('=');
        sb.append(((this.errorCode == null)?"<null>":this.errorCode));
        sb.append(',');
        sb.append("info");
        sb.append('=');
        sb.append(((this.info == null)?"<null>":this.info));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
        sb.append(',');
        sb.append("vendorId");
        sb.append('=');
        sb.append(((this.vendorId == null)?"<null>":this.vendorId));
        sb.append(',');
        sb.append("vendorErrorCode");
        sb.append('=');
        sb.append(((this.vendorErrorCode == null)?"<null>":this.vendorErrorCode));
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
        result = ((result* 31)+ this.connectorId);
        result = ((result* 31)+((this.errorCode == null)? 0 :this.errorCode.hashCode()));
        result = ((result* 31)+((this.vendorId == null)? 0 :this.vendorId.hashCode()));
        result = ((result* 31)+((this.vendorErrorCode == null)? 0 :this.vendorErrorCode.hashCode()));
        result = ((result* 31)+((this.info == null)? 0 :this.info.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StatusNotificationRequest) == false) {
            return false;
        }
        StatusNotificationRequest rhs = ((StatusNotificationRequest) other);
        return (((((((this.connectorId == rhs.connectorId)&&((this.errorCode == rhs.errorCode)||((this.errorCode!= null)&&this.errorCode.equals(rhs.errorCode))))&&((this.vendorId == rhs.vendorId)||((this.vendorId!= null)&&this.vendorId.equals(rhs.vendorId))))&&((this.vendorErrorCode == rhs.vendorErrorCode)||((this.vendorErrorCode!= null)&&this.vendorErrorCode.equals(rhs.vendorErrorCode))))&&((this.info == rhs.info)||((this.info!= null)&&this.info.equals(rhs.info))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))));
    }

    public enum ErrorCode {

        CONNECTOR_LOCK_FAILURE("ConnectorLockFailure"),
        EV_COMMUNICATION_ERROR("EVCommunicationError"),
        GROUND_FAILURE("GroundFailure"),
        HIGH_TEMPERATURE("HighTemperature"),
        INTERNAL_ERROR("InternalError"),
        LOCAL_LIST_CONFLICT("LocalListConflict"),
        NO_ERROR("NoError"),
        OTHER_ERROR("OtherError"),
        OVER_CURRENT_FAILURE("OverCurrentFailure"),
        POWER_METER_FAILURE("PowerMeterFailure"),
        POWER_SWITCH_FAILURE("PowerSwitchFailure"),
        READER_FAILURE("ReaderFailure"),
        RESET_FAILURE("ResetFailure"),
        UNDER_VOLTAGE("UnderVoltage"),
        OVER_VOLTAGE("OverVoltage"),
        WEAK_SIGNAL("WeakSignal");
        private final String value;
        private final static Map<String, StatusNotificationRequest.ErrorCode> CONSTANTS = new HashMap<String, StatusNotificationRequest.ErrorCode>();

        static {
            for (StatusNotificationRequest.ErrorCode c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        ErrorCode(String value) {
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
        public static StatusNotificationRequest.ErrorCode fromValue(String value) {
            StatusNotificationRequest.ErrorCode constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Status {

        AVAILABLE("Available"),
        PREPARING("Preparing"),
        CHARGING("Charging"),
        SUSPENDED_EVSE("SuspendedEVSE"),
        SUSPENDED_EV("SuspendedEV"),
        FINISHING("Finishing"),
        RESERVED("Reserved"),
        UNAVAILABLE("Unavailable"),
        FAULTED("Faulted");
        private final String value;
        private final static Map<String, StatusNotificationRequest.Status> CONSTANTS = new HashMap<String, StatusNotificationRequest.Status>();

        static {
            for (StatusNotificationRequest.Status c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Status(String value) {
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
        public static StatusNotificationRequest.Status fromValue(String value) {
            StatusNotificationRequest.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
