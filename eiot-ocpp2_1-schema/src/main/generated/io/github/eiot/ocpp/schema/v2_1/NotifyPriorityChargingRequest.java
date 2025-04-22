
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "transactionId",
    "activated",
    "customData"
})
public class NotifyPriorityChargingRequest {

    /**
     * The transaction for which priority charging is requested.
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    @JsonPropertyDescription("The transaction for which priority charging is requested.\r\n")
    @Size(max = 36)
    @NotNull
    private String transactionId;
    /**
     * True if priority charging was activated. False if it has stopped using the priority charging profile.
     * 
     * (Required)
     * 
     */
    @JsonProperty("activated")
    @JsonPropertyDescription("True if priority charging was activated. False if it has stopped using the priority charging profile.\r\n")
    @NotNull
    private boolean activated;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * The transaction for which priority charging is requested.
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * The transaction for which priority charging is requested.
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public NotifyPriorityChargingRequest withTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * True if priority charging was activated. False if it has stopped using the priority charging profile.
     * 
     * (Required)
     * 
     */
    @JsonProperty("activated")
    public boolean isActivated() {
        return activated;
    }

    /**
     * True if priority charging was activated. False if it has stopped using the priority charging profile.
     * 
     * (Required)
     * 
     */
    @JsonProperty("activated")
    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public NotifyPriorityChargingRequest withActivated(boolean activated) {
        this.activated = activated;
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

    public NotifyPriorityChargingRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NotifyPriorityChargingRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("transactionId");
        sb.append('=');
        sb.append(((this.transactionId == null)?"<null>":this.transactionId));
        sb.append(',');
        sb.append("activated");
        sb.append('=');
        sb.append(this.activated);
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
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.transactionId == null)? 0 :this.transactionId.hashCode()));
        result = ((result* 31)+(this.activated? 1 : 0));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NotifyPriorityChargingRequest) == false) {
            return false;
        }
        NotifyPriorityChargingRequest rhs = ((NotifyPriorityChargingRequest) other);
        return ((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&((this.transactionId == rhs.transactionId)||((this.transactionId!= null)&&this.transactionId.equals(rhs.transactionId))))&&(this.activated == rhs.activated));
    }

}
