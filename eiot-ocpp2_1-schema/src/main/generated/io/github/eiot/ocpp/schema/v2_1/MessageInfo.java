
package io.github.eiot.ocpp.schema.v2_1;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Contains message details, for a message to be displayed on a Charging Station.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "display",
    "id",
    "priority",
    "state",
    "startDateTime",
    "endDateTime",
    "transactionId",
    "message",
    "messageExtra",
    "customData"
})
public class MessageInfo {

    /**
     * A physical or logical component
     * 
     * 
     */
    @JsonProperty("display")
    @JsonPropertyDescription("A physical or logical component\r\n")
    @Valid
    private Component display;
    /**
     * Unique id within an exchange context. It is defined within the OCPP context as a positive Integer value (greater or equal to zero).
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Unique id within an exchange context. It is defined within the OCPP context as a positive Integer value (greater or equal to zero).\r\n")
    @DecimalMin("0")
    @NotNull
    private int id;
    /**
     * With what priority should this message be shown
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    @JsonPropertyDescription("With what priority should this message be shown\r\n")
    @NotNull
    private MessagePriorityEnum priority;
    /**
     * During what state should this message be shown. When omitted this message should be shown in any state of the Charging Station.
     * 
     * 
     */
    @JsonProperty("state")
    @JsonPropertyDescription("During what state should this message be shown. When omitted this message should be shown in any state of the Charging Station.\r\n")
    private MessageStateEnum state;
    /**
     * From what date-time should this message be shown. If omitted: directly.
     * 
     * 
     */
    @JsonProperty("startDateTime")
    @JsonPropertyDescription("From what date-time should this message be shown. If omitted: directly.\r\n")
    private ZonedDateTime startDateTime;
    /**
     * Until what date-time should this message be shown, after this date/time this message SHALL be removed.
     * 
     * 
     */
    @JsonProperty("endDateTime")
    @JsonPropertyDescription("Until what date-time should this message be shown, after this date/time this message SHALL be removed.\r\n")
    private ZonedDateTime endDateTime;
    /**
     * During which transaction shall this message be shown.
     * Message SHALL be removed by the Charging Station after transaction has
     * ended.
     * 
     * 
     */
    @JsonProperty("transactionId")
    @JsonPropertyDescription("During which transaction shall this message be shown.\r\nMessage SHALL be removed by the Charging Station after transaction has\r\nended.\r\n")
    @Size(max = 36)
    private String transactionId;
    /**
     * Contains message details, for a message to be displayed on a Charging Station.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("Contains message details, for a message to be displayed on a Charging Station.\r\n\r\n")
    @Valid
    @NotNull
    private MessageContent message;
    @JsonProperty("messageExtra")
    @Size(min = 1, max = 4)
    @Valid
    private List<MessageContent> messageExtra = new ArrayList<MessageContent>();
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * A physical or logical component
     * 
     * 
     */
    @JsonProperty("display")
    public Component getDisplay() {
        return display;
    }

    /**
     * A physical or logical component
     * 
     * 
     */
    @JsonProperty("display")
    public void setDisplay(Component display) {
        this.display = display;
    }

    public MessageInfo withDisplay(Component display) {
        this.display = display;
        return this;
    }

    /**
     * Unique id within an exchange context. It is defined within the OCPP context as a positive Integer value (greater or equal to zero).
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    /**
     * Unique id within an exchange context. It is defined within the OCPP context as a positive Integer value (greater or equal to zero).
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    public MessageInfo withId(int id) {
        this.id = id;
        return this;
    }

    /**
     * With what priority should this message be shown
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    public MessagePriorityEnum getPriority() {
        return priority;
    }

    /**
     * With what priority should this message be shown
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    public void setPriority(MessagePriorityEnum priority) {
        this.priority = priority;
    }

    public MessageInfo withPriority(MessagePriorityEnum priority) {
        this.priority = priority;
        return this;
    }

    /**
     * During what state should this message be shown. When omitted this message should be shown in any state of the Charging Station.
     * 
     * 
     */
    @JsonProperty("state")
    public MessageStateEnum getState() {
        return state;
    }

    /**
     * During what state should this message be shown. When omitted this message should be shown in any state of the Charging Station.
     * 
     * 
     */
    @JsonProperty("state")
    public void setState(MessageStateEnum state) {
        this.state = state;
    }

    public MessageInfo withState(MessageStateEnum state) {
        this.state = state;
        return this;
    }

    /**
     * From what date-time should this message be shown. If omitted: directly.
     * 
     * 
     */
    @JsonProperty("startDateTime")
    public ZonedDateTime getStartDateTime() {
        return startDateTime;
    }

    /**
     * From what date-time should this message be shown. If omitted: directly.
     * 
     * 
     */
    @JsonProperty("startDateTime")
    public void setStartDateTime(ZonedDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public MessageInfo withStartDateTime(ZonedDateTime startDateTime) {
        this.startDateTime = startDateTime;
        return this;
    }

    /**
     * Until what date-time should this message be shown, after this date/time this message SHALL be removed.
     * 
     * 
     */
    @JsonProperty("endDateTime")
    public ZonedDateTime getEndDateTime() {
        return endDateTime;
    }

    /**
     * Until what date-time should this message be shown, after this date/time this message SHALL be removed.
     * 
     * 
     */
    @JsonProperty("endDateTime")
    public void setEndDateTime(ZonedDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public MessageInfo withEndDateTime(ZonedDateTime endDateTime) {
        this.endDateTime = endDateTime;
        return this;
    }

    /**
     * During which transaction shall this message be shown.
     * Message SHALL be removed by the Charging Station after transaction has
     * ended.
     * 
     * 
     */
    @JsonProperty("transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * During which transaction shall this message be shown.
     * Message SHALL be removed by the Charging Station after transaction has
     * ended.
     * 
     * 
     */
    @JsonProperty("transactionId")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public MessageInfo withTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * Contains message details, for a message to be displayed on a Charging Station.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    public MessageContent getMessage() {
        return message;
    }

    /**
     * Contains message details, for a message to be displayed on a Charging Station.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    public void setMessage(MessageContent message) {
        this.message = message;
    }

    public MessageInfo withMessage(MessageContent message) {
        this.message = message;
        return this;
    }

    @JsonProperty("messageExtra")
    public List<MessageContent> getMessageExtra() {
        return messageExtra;
    }

    @JsonProperty("messageExtra")
    public void setMessageExtra(List<MessageContent> messageExtra) {
        this.messageExtra = messageExtra;
    }

    public MessageInfo withMessageExtra(List<MessageContent> messageExtra) {
        this.messageExtra = messageExtra;
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

    public MessageInfo withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MessageInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("display");
        sb.append('=');
        sb.append(((this.display == null)?"<null>":this.display));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(this.id);
        sb.append(',');
        sb.append("priority");
        sb.append('=');
        sb.append(((this.priority == null)?"<null>":this.priority));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null)?"<null>":this.state));
        sb.append(',');
        sb.append("startDateTime");
        sb.append('=');
        sb.append(((this.startDateTime == null)?"<null>":this.startDateTime));
        sb.append(',');
        sb.append("endDateTime");
        sb.append('=');
        sb.append(((this.endDateTime == null)?"<null>":this.endDateTime));
        sb.append(',');
        sb.append("transactionId");
        sb.append('=');
        sb.append(((this.transactionId == null)?"<null>":this.transactionId));
        sb.append(',');
        sb.append("message");
        sb.append('=');
        sb.append(((this.message == null)?"<null>":this.message));
        sb.append(',');
        sb.append("messageExtra");
        sb.append('=');
        sb.append(((this.messageExtra == null)?"<null>":this.messageExtra));
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
        result = ((result* 31)+((this.messageExtra == null)? 0 :this.messageExtra.hashCode()));
        result = ((result* 31)+((this.startDateTime == null)? 0 :this.startDateTime.hashCode()));
        result = ((result* 31)+((this.display == null)? 0 :this.display.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.id);
        result = ((result* 31)+((this.state == null)? 0 :this.state.hashCode()));
        result = ((result* 31)+((this.priority == null)? 0 :this.priority.hashCode()));
        result = ((result* 31)+((this.endDateTime == null)? 0 :this.endDateTime.hashCode()));
        result = ((result* 31)+((this.message == null)? 0 :this.message.hashCode()));
        result = ((result* 31)+((this.transactionId == null)? 0 :this.transactionId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MessageInfo) == false) {
            return false;
        }
        MessageInfo rhs = ((MessageInfo) other);
        return (((((((((((this.messageExtra == rhs.messageExtra)||((this.messageExtra!= null)&&this.messageExtra.equals(rhs.messageExtra)))&&((this.startDateTime == rhs.startDateTime)||((this.startDateTime!= null)&&this.startDateTime.equals(rhs.startDateTime))))&&((this.display == rhs.display)||((this.display!= null)&&this.display.equals(rhs.display))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.id == rhs.id))&&((this.state == rhs.state)||((this.state!= null)&&this.state.equals(rhs.state))))&&((this.priority == rhs.priority)||((this.priority!= null)&&this.priority.equals(rhs.priority))))&&((this.endDateTime == rhs.endDateTime)||((this.endDateTime!= null)&&this.endDateTime.equals(rhs.endDateTime))))&&((this.message == rhs.message)||((this.message!= null)&&this.message.equals(rhs.message))))&&((this.transactionId == rhs.transactionId)||((this.transactionId!= null)&&this.transactionId.equals(rhs.transactionId))));
    }

}
