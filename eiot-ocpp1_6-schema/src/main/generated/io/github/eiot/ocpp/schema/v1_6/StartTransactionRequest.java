
package io.github.eiot.ocpp.schema.v1_6;

import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * StartTransactionRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectorId",
    "idTag",
    "meterStart",
    "reservationId",
    "timestamp"
})
public class StartTransactionRequest {

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
    @JsonProperty("idTag")
    @Size(max = 20)
    @NotNull
    private String idTag;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("meterStart")
    @NotNull
    private int meterStart;
    @JsonProperty("reservationId")
    private int reservationId;
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

    public StartTransactionRequest withConnectorId(int connectorId) {
        this.connectorId = connectorId;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTag")
    public String getIdTag() {
        return idTag;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTag")
    public void setIdTag(String idTag) {
        this.idTag = idTag;
    }

    public StartTransactionRequest withIdTag(String idTag) {
        this.idTag = idTag;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("meterStart")
    public int getMeterStart() {
        return meterStart;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("meterStart")
    public void setMeterStart(int meterStart) {
        this.meterStart = meterStart;
    }

    public StartTransactionRequest withMeterStart(int meterStart) {
        this.meterStart = meterStart;
        return this;
    }

    @JsonProperty("reservationId")
    public int getReservationId() {
        return reservationId;
    }

    @JsonProperty("reservationId")
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public StartTransactionRequest withReservationId(int reservationId) {
        this.reservationId = reservationId;
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

    public StartTransactionRequest withTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StartTransactionRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("connectorId");
        sb.append('=');
        sb.append(this.connectorId);
        sb.append(',');
        sb.append("idTag");
        sb.append('=');
        sb.append(((this.idTag == null)?"<null>":this.idTag));
        sb.append(',');
        sb.append("meterStart");
        sb.append('=');
        sb.append(this.meterStart);
        sb.append(',');
        sb.append("reservationId");
        sb.append('=');
        sb.append(this.reservationId);
        sb.append(',');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
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
        result = ((result* 31)+((this.idTag == null)? 0 :this.idTag.hashCode()));
        result = ((result* 31)+ this.meterStart);
        result = ((result* 31)+ this.reservationId);
        result = ((result* 31)+ this.connectorId);
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StartTransactionRequest) == false) {
            return false;
        }
        StartTransactionRequest rhs = ((StartTransactionRequest) other);
        return ((((((this.idTag == rhs.idTag)||((this.idTag!= null)&&this.idTag.equals(rhs.idTag)))&&(this.meterStart == rhs.meterStart))&&(this.reservationId == rhs.reservationId))&&(this.connectorId == rhs.connectorId))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))));
    }

}
