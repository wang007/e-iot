
package io.github.eiot.ocpp.schema.v1_6;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;


/**
 * RemoteStopTransactionRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "transactionId"
})
public class RemoteStopTransactionRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    @NotNull
    private int transactionId;

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

    public RemoteStopTransactionRequest withTransactionId(int transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RemoteStopTransactionRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("transactionId");
        sb.append('=');
        sb.append(this.transactionId);
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
        result = ((result* 31)+ this.transactionId);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RemoteStopTransactionRequest) == false) {
            return false;
        }
        RemoteStopTransactionRequest rhs = ((RemoteStopTransactionRequest) other);
        return (this.transactionId == rhs.transactionId);
    }

}
