
package io.github.eiot.ocpp.schema.v1_6;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * MeterValuesRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectorId",
    "transactionId",
    "meterValue"
})
public class MeterValuesRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("connectorId")
    @NotNull
    private int connectorId;
    @JsonProperty("transactionId")
    private int transactionId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("meterValue")
    @Valid
    @NotNull
    private List<MeterValue> meterValue = new ArrayList<MeterValue>();

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

    public MeterValuesRequest withConnectorId(int connectorId) {
        this.connectorId = connectorId;
        return this;
    }

    @JsonProperty("transactionId")
    public int getTransactionId() {
        return transactionId;
    }

    @JsonProperty("transactionId")
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public MeterValuesRequest withTransactionId(int transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("meterValue")
    public List<MeterValue> getMeterValue() {
        return meterValue;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("meterValue")
    public void setMeterValue(List<MeterValue> meterValue) {
        this.meterValue = meterValue;
    }

    public MeterValuesRequest withMeterValue(List<MeterValue> meterValue) {
        this.meterValue = meterValue;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MeterValuesRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("connectorId");
        sb.append('=');
        sb.append(this.connectorId);
        sb.append(',');
        sb.append("transactionId");
        sb.append('=');
        sb.append(this.transactionId);
        sb.append(',');
        sb.append("meterValue");
        sb.append('=');
        sb.append(((this.meterValue == null)?"<null>":this.meterValue));
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
        result = ((result* 31)+((this.meterValue == null)? 0 :this.meterValue.hashCode()));
        result = ((result* 31)+ this.connectorId);
        result = ((result* 31)+ this.transactionId);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MeterValuesRequest) == false) {
            return false;
        }
        MeterValuesRequest rhs = ((MeterValuesRequest) other);
        return ((((this.meterValue == rhs.meterValue)||((this.meterValue!= null)&&this.meterValue.equals(rhs.meterValue)))&&(this.connectorId == rhs.connectorId))&&(this.transactionId == rhs.transactionId));
    }

}
