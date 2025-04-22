
package io.github.eiot.ocpp.schema.v1_6;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;


/**
 * UnlockConnectorRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectorId"
})
public class UnlockConnectorRequest {

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

    public UnlockConnectorRequest withConnectorId(int connectorId) {
        this.connectorId = connectorId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(UnlockConnectorRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        result = ((result* 31)+ this.connectorId);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UnlockConnectorRequest) == false) {
            return false;
        }
        UnlockConnectorRequest rhs = ((UnlockConnectorRequest) other);
        return (this.connectorId == rhs.connectorId);
    }

}
