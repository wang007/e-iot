
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
    "evse",
    "requestedMessage",
    "customTrigger",
    "customData"
})
public class TriggerMessageRequest {

    /**
     * Electric Vehicle Supply Equipment
     * 
     * 
     */
    @JsonProperty("evse")
    @JsonPropertyDescription("Electric Vehicle Supply Equipment\r\n")
    @Valid
    private EVSE evse;
    /**
     * Type of message to be triggered.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestedMessage")
    @JsonPropertyDescription("Type of message to be triggered.\r\n")
    @NotNull
    private MessageTriggerEnum requestedMessage;
    /**
     * *(2.1)* When _requestedMessage_ = `CustomTrigger` this will trigger sending the corresponding message in field _customTrigger_, if supported by Charging Station.
     * 
     * 
     * 
     */
    @JsonProperty("customTrigger")
    @JsonPropertyDescription("*(2.1)* When _requestedMessage_ = `CustomTrigger` this will trigger sending the corresponding message in field _customTrigger_, if supported by Charging Station.\r\n\r\n")
    @Size(max = 50)
    private String customTrigger;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Electric Vehicle Supply Equipment
     * 
     * 
     */
    @JsonProperty("evse")
    public EVSE getEvse() {
        return evse;
    }

    /**
     * Electric Vehicle Supply Equipment
     * 
     * 
     */
    @JsonProperty("evse")
    public void setEvse(EVSE evse) {
        this.evse = evse;
    }

    public TriggerMessageRequest withEvse(EVSE evse) {
        this.evse = evse;
        return this;
    }

    /**
     * Type of message to be triggered.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestedMessage")
    public MessageTriggerEnum getRequestedMessage() {
        return requestedMessage;
    }

    /**
     * Type of message to be triggered.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestedMessage")
    public void setRequestedMessage(MessageTriggerEnum requestedMessage) {
        this.requestedMessage = requestedMessage;
    }

    public TriggerMessageRequest withRequestedMessage(MessageTriggerEnum requestedMessage) {
        this.requestedMessage = requestedMessage;
        return this;
    }

    /**
     * *(2.1)* When _requestedMessage_ = `CustomTrigger` this will trigger sending the corresponding message in field _customTrigger_, if supported by Charging Station.
     * 
     * 
     * 
     */
    @JsonProperty("customTrigger")
    public String getCustomTrigger() {
        return customTrigger;
    }

    /**
     * *(2.1)* When _requestedMessage_ = `CustomTrigger` this will trigger sending the corresponding message in field _customTrigger_, if supported by Charging Station.
     * 
     * 
     * 
     */
    @JsonProperty("customTrigger")
    public void setCustomTrigger(String customTrigger) {
        this.customTrigger = customTrigger;
    }

    public TriggerMessageRequest withCustomTrigger(String customTrigger) {
        this.customTrigger = customTrigger;
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

    public TriggerMessageRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TriggerMessageRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("evse");
        sb.append('=');
        sb.append(((this.evse == null)?"<null>":this.evse));
        sb.append(',');
        sb.append("requestedMessage");
        sb.append('=');
        sb.append(((this.requestedMessage == null)?"<null>":this.requestedMessage));
        sb.append(',');
        sb.append("customTrigger");
        sb.append('=');
        sb.append(((this.customTrigger == null)?"<null>":this.customTrigger));
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
        result = ((result* 31)+((this.customTrigger == null)? 0 :this.customTrigger.hashCode()));
        result = ((result* 31)+((this.requestedMessage == null)? 0 :this.requestedMessage.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.evse == null)? 0 :this.evse.hashCode()));
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
        return (((((this.customTrigger == rhs.customTrigger)||((this.customTrigger!= null)&&this.customTrigger.equals(rhs.customTrigger)))&&((this.requestedMessage == rhs.requestedMessage)||((this.requestedMessage!= null)&&this.requestedMessage.equals(rhs.requestedMessage))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.evse == rhs.evse)||((this.evse!= null)&&this.evse.equals(rhs.evse))));
    }

}
