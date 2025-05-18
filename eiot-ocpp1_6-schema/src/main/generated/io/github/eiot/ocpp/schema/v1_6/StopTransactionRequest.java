
package io.github.eiot.ocpp.schema.v1_6;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * StopTransactionRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idTag",
    "meterStop",
    "timestamp",
    "transactionId",
    "reason",
    "transactionData"
})
public class StopTransactionRequest {

    @JsonProperty("idTag")
    @Size(max = 20)
    private String idTag;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("meterStop")
    @NotNull
    private int meterStop;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    @NotNull
    private ZonedDateTime timestamp;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    @NotNull
    private int transactionId;
    @JsonProperty("reason")
    private StopTransactionRequest.Reason reason;
    @JsonProperty("transactionData")
    @Valid
    private List<TransactionDatum> transactionData = new ArrayList<TransactionDatum>();

    @JsonProperty("idTag")
    public String getIdTag() {
        return idTag;
    }

    @JsonProperty("idTag")
    public void setIdTag(String idTag) {
        this.idTag = idTag;
    }

    public StopTransactionRequest withIdTag(String idTag) {
        this.idTag = idTag;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("meterStop")
    public int getMeterStop() {
        return meterStop;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("meterStop")
    public void setMeterStop(int meterStop) {
        this.meterStop = meterStop;
    }

    public StopTransactionRequest withMeterStop(int meterStop) {
        this.meterStop = meterStop;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public StopTransactionRequest withTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    public int getTransactionId() {
        return transactionId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public StopTransactionRequest withTransactionId(int transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    @JsonProperty("reason")
    public StopTransactionRequest.Reason getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(StopTransactionRequest.Reason reason) {
        this.reason = reason;
    }

    public StopTransactionRequest withReason(StopTransactionRequest.Reason reason) {
        this.reason = reason;
        return this;
    }

    @JsonProperty("transactionData")
    public List<TransactionDatum> getTransactionData() {
        return transactionData;
    }

    @JsonProperty("transactionData")
    public void setTransactionData(List<TransactionDatum> transactionData) {
        this.transactionData = transactionData;
    }

    public StopTransactionRequest withTransactionData(List<TransactionDatum> transactionData) {
        this.transactionData = transactionData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StopTransactionRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("idTag");
        sb.append('=');
        sb.append(((this.idTag == null)?"<null>":this.idTag));
        sb.append(',');
        sb.append("meterStop");
        sb.append('=');
        sb.append(this.meterStop);
        sb.append(',');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
        sb.append(',');
        sb.append("transactionId");
        sb.append('=');
        sb.append(this.transactionId);
        sb.append(',');
        sb.append("reason");
        sb.append('=');
        sb.append(((this.reason == null)?"<null>":this.reason));
        sb.append(',');
        sb.append("transactionData");
        sb.append('=');
        sb.append(((this.transactionData == null)?"<null>":this.transactionData));
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
        result = ((result* 31)+((this.reason == null)? 0 :this.reason.hashCode()));
        result = ((result* 31)+((this.transactionData == null)? 0 :this.transactionData.hashCode()));
        result = ((result* 31)+((this.idTag == null)? 0 :this.idTag.hashCode()));
        result = ((result* 31)+ this.transactionId);
        result = ((result* 31)+ this.meterStop);
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StopTransactionRequest) == false) {
            return false;
        }
        StopTransactionRequest rhs = ((StopTransactionRequest) other);
        return (((((((this.reason == rhs.reason)||((this.reason!= null)&&this.reason.equals(rhs.reason)))&&((this.transactionData == rhs.transactionData)||((this.transactionData!= null)&&this.transactionData.equals(rhs.transactionData))))&&((this.idTag == rhs.idTag)||((this.idTag!= null)&&this.idTag.equals(rhs.idTag))))&&(this.transactionId == rhs.transactionId))&&(this.meterStop == rhs.meterStop))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))));
    }

    public enum Reason {

        EMERGENCY_STOP("EmergencyStop"),
        EV_DISCONNECTED("EVDisconnected"),
        HARD_RESET("HardReset"),
        LOCAL("Local"),
        OTHER("Other"),
        POWER_LOSS("PowerLoss"),
        REBOOT("Reboot"),
        REMOTE("Remote"),
        SOFT_RESET("SoftReset"),
        UNLOCK_COMMAND("UnlockCommand"),
        DE_AUTHORIZED("DeAuthorized");
        private final String value;
        private final static Map<String, StopTransactionRequest.Reason> CONSTANTS = new HashMap<String, StopTransactionRequest.Reason>();

        static {
            for (StopTransactionRequest.Reason c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Reason(String value) {
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
        public static StopTransactionRequest.Reason fromValue(String value) {
            StopTransactionRequest.Reason constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
