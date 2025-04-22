
package io.github.eiot.ocpp.schema.v2_0_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customData",
    "ongoingIndicator",
    "messagesInQueue"
})
public class GetTransactionStatusResponse {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Whether the transaction is still ongoing.
     * 
     * 
     */
    @JsonProperty("ongoingIndicator")
    @JsonPropertyDescription("Whether the transaction is still ongoing.\r\n")
    private boolean ongoingIndicator;
    /**
     * Whether there are still message to be delivered.
     * 
     * (Required)
     * 
     */
    @JsonProperty("messagesInQueue")
    @JsonPropertyDescription("Whether there are still message to be delivered.\r\n")
    @NotNull
    private boolean messagesInQueue;

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

    public GetTransactionStatusResponse withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    /**
     * Whether the transaction is still ongoing.
     * 
     * 
     */
    @JsonProperty("ongoingIndicator")
    public boolean isOngoingIndicator() {
        return ongoingIndicator;
    }

    /**
     * Whether the transaction is still ongoing.
     * 
     * 
     */
    @JsonProperty("ongoingIndicator")
    public void setOngoingIndicator(boolean ongoingIndicator) {
        this.ongoingIndicator = ongoingIndicator;
    }

    public GetTransactionStatusResponse withOngoingIndicator(boolean ongoingIndicator) {
        this.ongoingIndicator = ongoingIndicator;
        return this;
    }

    /**
     * Whether there are still message to be delivered.
     * 
     * (Required)
     * 
     */
    @JsonProperty("messagesInQueue")
    public boolean isMessagesInQueue() {
        return messagesInQueue;
    }

    /**
     * Whether there are still message to be delivered.
     * 
     * (Required)
     * 
     */
    @JsonProperty("messagesInQueue")
    public void setMessagesInQueue(boolean messagesInQueue) {
        this.messagesInQueue = messagesInQueue;
    }

    public GetTransactionStatusResponse withMessagesInQueue(boolean messagesInQueue) {
        this.messagesInQueue = messagesInQueue;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GetTransactionStatusResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("customData");
        sb.append('=');
        sb.append(((this.customData == null)?"<null>":this.customData));
        sb.append(',');
        sb.append("ongoingIndicator");
        sb.append('=');
        sb.append(this.ongoingIndicator);
        sb.append(',');
        sb.append("messagesInQueue");
        sb.append('=');
        sb.append(this.messagesInQueue);
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
        result = ((result* 31)+(this.messagesInQueue? 1 : 0));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+(this.ongoingIndicator? 1 : 0));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetTransactionStatusResponse) == false) {
            return false;
        }
        GetTransactionStatusResponse rhs = ((GetTransactionStatusResponse) other);
        return (((this.messagesInQueue == rhs.messagesInQueue)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.ongoingIndicator == rhs.ongoingIndicator));
    }

}
