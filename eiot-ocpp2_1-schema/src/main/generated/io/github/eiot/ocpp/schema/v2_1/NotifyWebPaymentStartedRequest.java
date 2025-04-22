
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "evseId",
    "timeout",
    "customData"
})
public class NotifyWebPaymentStartedRequest {

    /**
     * EVSE id for which transaction is requested.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("EVSE id for which transaction is requested.\r\n\r\n")
    @DecimalMin("0")
    @NotNull
    private int evseId;
    /**
     * Timeout value in seconds after which no result of web payment process (e.g. QR code scanning) is to be expected anymore.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeout")
    @JsonPropertyDescription("Timeout value in seconds after which no result of web payment process (e.g. QR code scanning) is to be expected anymore.\r\n")
    @NotNull
    private int timeout;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * EVSE id for which transaction is requested.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * EVSE id for which transaction is requested.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public NotifyWebPaymentStartedRequest withEvseId(int evseId) {
        this.evseId = evseId;
        return this;
    }

    /**
     * Timeout value in seconds after which no result of web payment process (e.g. QR code scanning) is to be expected anymore.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeout")
    public int getTimeout() {
        return timeout;
    }

    /**
     * Timeout value in seconds after which no result of web payment process (e.g. QR code scanning) is to be expected anymore.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeout")
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public NotifyWebPaymentStartedRequest withTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    public CustomData getCustomData() {
        return customData;
    }

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    public void setCustomData(CustomData customData) {
        this.customData = customData;
    }

    public NotifyWebPaymentStartedRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NotifyWebPaymentStartedRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
        sb.append(',');
        sb.append("timeout");
        sb.append('=');
        sb.append(this.timeout);
        sb.append(',');
        sb.append("customData");
        sb.append('=');
        sb.append(((this.customData == null)?"<null>":this.customData));
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
        result = ((result* 31)+ this.evseId);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NotifyWebPaymentStartedRequest) == false) {
            return false;
        }
        NotifyWebPaymentStartedRequest rhs = ((NotifyWebPaymentStartedRequest) other);
        return (((this.evseId == rhs.evseId)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.timeout == rhs.timeout));
    }

}
