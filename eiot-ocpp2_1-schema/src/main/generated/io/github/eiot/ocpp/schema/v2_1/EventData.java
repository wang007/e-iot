
package io.github.eiot.ocpp.schema.v2_1;

import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Class to report an event notification for a component-variable.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "eventId",
    "timestamp",
    "trigger",
    "cause",
    "actualValue",
    "techCode",
    "techInfo",
    "cleared",
    "transactionId",
    "component",
    "variableMonitoringId",
    "eventNotificationType",
    "variable",
    "severity",
    "customData"
})
public class EventData {

    /**
     * Identifies the event. This field can be referred to as a cause by other events.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("eventId")
    @JsonPropertyDescription("Identifies the event. This field can be referred to as a cause by other events.\r\n\r\n")
    @DecimalMin("0")
    @NotNull
    private int eventId;
    /**
     * Timestamp of the moment the report was generated.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("Timestamp of the moment the report was generated.\r\n")
    @NotNull
    private OffsetDateTime timestamp;
    /**
     * Type of trigger for this event, e.g. exceeding a threshold value.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("trigger")
    @JsonPropertyDescription("Type of trigger for this event, e.g. exceeding a threshold value.\r\n\r\n")
    @NotNull
    private EventTriggerEnum trigger;
    /**
     * Refers to the Id of an event that is considered to be the cause for this event.
     * 
     * 
     * 
     */
    @JsonProperty("cause")
    @JsonPropertyDescription("Refers to the Id of an event that is considered to be the cause for this event.\r\n\r\n")
    @DecimalMin("0")
    private int cause;
    /**
     * Actual value (_attributeType_ Actual) of the variable.
     * 
     * The Configuration Variable &lt;&lt;configkey-reporting-value-size,ReportingValueSize&gt;&gt; can be used to limit GetVariableResult.attributeValue, VariableAttribute.value and EventData.actualValue. The max size of these values will always remain equal. 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("actualValue")
    @JsonPropertyDescription("Actual value (_attributeType_ Actual) of the variable.\r\n\r\nThe Configuration Variable &lt;&lt;configkey-reporting-value-size,ReportingValueSize&gt;&gt; can be used to limit GetVariableResult.attributeValue, VariableAttribute.value and EventData.actualValue. The max size of these values will always remain equal. \r\n\r\n")
    @Size(max = 2500)
    @NotNull
    private String actualValue;
    /**
     * Technical (error) code as reported by component.
     * 
     * 
     */
    @JsonProperty("techCode")
    @JsonPropertyDescription("Technical (error) code as reported by component.\r\n")
    @Size(max = 50)
    private String techCode;
    /**
     * Technical detail information as reported by component.
     * 
     * 
     */
    @JsonProperty("techInfo")
    @JsonPropertyDescription("Technical detail information as reported by component.\r\n")
    @Size(max = 500)
    private String techInfo;
    /**
     * _Cleared_ is set to true to report the clearing of a monitored situation, i.e. a 'return to normal'. 
     * 
     * 
     * 
     */
    @JsonProperty("cleared")
    @JsonPropertyDescription("_Cleared_ is set to true to report the clearing of a monitored situation, i.e. a 'return to normal'. \r\n\r\n")
    private boolean cleared;
    /**
     * If an event notification is linked to a specific transaction, this field can be used to specify its transactionId.
     * 
     * 
     */
    @JsonProperty("transactionId")
    @JsonPropertyDescription("If an event notification is linked to a specific transaction, this field can be used to specify its transactionId.\r\n")
    @Size(max = 36)
    private String transactionId;
    /**
     * A physical or logical component
     * 
     * (Required)
     * 
     */
    @JsonProperty("component")
    @JsonPropertyDescription("A physical or logical component\r\n")
    @Valid
    @NotNull
    private Component component;
    /**
     * Identifies the VariableMonitoring which triggered the event.
     * 
     * 
     */
    @JsonProperty("variableMonitoringId")
    @JsonPropertyDescription("Identifies the VariableMonitoring which triggered the event.\r\n")
    @DecimalMin("0")
    private int variableMonitoringId;
    /**
     * Specifies the event notification type of the message.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("eventNotificationType")
    @JsonPropertyDescription("Specifies the event notification type of the message.\r\n\r\n")
    @NotNull
    private EventNotificationEnum eventNotificationType;
    /**
     * Reference key to a component-variable.
     * 
     * (Required)
     * 
     */
    @JsonProperty("variable")
    @JsonPropertyDescription("Reference key to a component-variable.\r\n")
    @Valid
    @NotNull
    private Variable variable;
    /**
     * *(2.1)* Severity associated with the monitor in _variableMonitoringId_ or with the hardwired notification.
     * 
     * 
     */
    @JsonProperty("severity")
    @JsonPropertyDescription("*(2.1)* Severity associated with the monitor in _variableMonitoringId_ or with the hardwired notification.\r\n")
    @DecimalMin("0")
    private int severity;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Identifies the event. This field can be referred to as a cause by other events.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("eventId")
    public int getEventId() {
        return eventId;
    }

    /**
     * Identifies the event. This field can be referred to as a cause by other events.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("eventId")
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public EventData withEventId(int eventId) {
        this.eventId = eventId;
        return this;
    }

    /**
     * Timestamp of the moment the report was generated.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Timestamp of the moment the report was generated.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public EventData withTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Type of trigger for this event, e.g. exceeding a threshold value.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("trigger")
    public EventTriggerEnum getTrigger() {
        return trigger;
    }

    /**
     * Type of trigger for this event, e.g. exceeding a threshold value.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("trigger")
    public void setTrigger(EventTriggerEnum trigger) {
        this.trigger = trigger;
    }

    public EventData withTrigger(EventTriggerEnum trigger) {
        this.trigger = trigger;
        return this;
    }

    /**
     * Refers to the Id of an event that is considered to be the cause for this event.
     * 
     * 
     * 
     */
    @JsonProperty("cause")
    public int getCause() {
        return cause;
    }

    /**
     * Refers to the Id of an event that is considered to be the cause for this event.
     * 
     * 
     * 
     */
    @JsonProperty("cause")
    public void setCause(int cause) {
        this.cause = cause;
    }

    public EventData withCause(int cause) {
        this.cause = cause;
        return this;
    }

    /**
     * Actual value (_attributeType_ Actual) of the variable.
     * 
     * The Configuration Variable &lt;&lt;configkey-reporting-value-size,ReportingValueSize&gt;&gt; can be used to limit GetVariableResult.attributeValue, VariableAttribute.value and EventData.actualValue. The max size of these values will always remain equal. 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("actualValue")
    public String getActualValue() {
        return actualValue;
    }

    /**
     * Actual value (_attributeType_ Actual) of the variable.
     * 
     * The Configuration Variable &lt;&lt;configkey-reporting-value-size,ReportingValueSize&gt;&gt; can be used to limit GetVariableResult.attributeValue, VariableAttribute.value and EventData.actualValue. The max size of these values will always remain equal. 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("actualValue")
    public void setActualValue(String actualValue) {
        this.actualValue = actualValue;
    }

    public EventData withActualValue(String actualValue) {
        this.actualValue = actualValue;
        return this;
    }

    /**
     * Technical (error) code as reported by component.
     * 
     * 
     */
    @JsonProperty("techCode")
    public String getTechCode() {
        return techCode;
    }

    /**
     * Technical (error) code as reported by component.
     * 
     * 
     */
    @JsonProperty("techCode")
    public void setTechCode(String techCode) {
        this.techCode = techCode;
    }

    public EventData withTechCode(String techCode) {
        this.techCode = techCode;
        return this;
    }

    /**
     * Technical detail information as reported by component.
     * 
     * 
     */
    @JsonProperty("techInfo")
    public String getTechInfo() {
        return techInfo;
    }

    /**
     * Technical detail information as reported by component.
     * 
     * 
     */
    @JsonProperty("techInfo")
    public void setTechInfo(String techInfo) {
        this.techInfo = techInfo;
    }

    public EventData withTechInfo(String techInfo) {
        this.techInfo = techInfo;
        return this;
    }

    /**
     * _Cleared_ is set to true to report the clearing of a monitored situation, i.e. a 'return to normal'. 
     * 
     * 
     * 
     */
    @JsonProperty("cleared")
    public boolean isCleared() {
        return cleared;
    }

    /**
     * _Cleared_ is set to true to report the clearing of a monitored situation, i.e. a 'return to normal'. 
     * 
     * 
     * 
     */
    @JsonProperty("cleared")
    public void setCleared(boolean cleared) {
        this.cleared = cleared;
    }

    public EventData withCleared(boolean cleared) {
        this.cleared = cleared;
        return this;
    }

    /**
     * If an event notification is linked to a specific transaction, this field can be used to specify its transactionId.
     * 
     * 
     */
    @JsonProperty("transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * If an event notification is linked to a specific transaction, this field can be used to specify its transactionId.
     * 
     * 
     */
    @JsonProperty("transactionId")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public EventData withTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * A physical or logical component
     * 
     * (Required)
     * 
     */
    @JsonProperty("component")
    public Component getComponent() {
        return component;
    }

    /**
     * A physical or logical component
     * 
     * (Required)
     * 
     */
    @JsonProperty("component")
    public void setComponent(Component component) {
        this.component = component;
    }

    public EventData withComponent(Component component) {
        this.component = component;
        return this;
    }

    /**
     * Identifies the VariableMonitoring which triggered the event.
     * 
     * 
     */
    @JsonProperty("variableMonitoringId")
    public int getVariableMonitoringId() {
        return variableMonitoringId;
    }

    /**
     * Identifies the VariableMonitoring which triggered the event.
     * 
     * 
     */
    @JsonProperty("variableMonitoringId")
    public void setVariableMonitoringId(int variableMonitoringId) {
        this.variableMonitoringId = variableMonitoringId;
    }

    public EventData withVariableMonitoringId(int variableMonitoringId) {
        this.variableMonitoringId = variableMonitoringId;
        return this;
    }

    /**
     * Specifies the event notification type of the message.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("eventNotificationType")
    public EventNotificationEnum getEventNotificationType() {
        return eventNotificationType;
    }

    /**
     * Specifies the event notification type of the message.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("eventNotificationType")
    public void setEventNotificationType(EventNotificationEnum eventNotificationType) {
        this.eventNotificationType = eventNotificationType;
    }

    public EventData withEventNotificationType(EventNotificationEnum eventNotificationType) {
        this.eventNotificationType = eventNotificationType;
        return this;
    }

    /**
     * Reference key to a component-variable.
     * 
     * (Required)
     * 
     */
    @JsonProperty("variable")
    public Variable getVariable() {
        return variable;
    }

    /**
     * Reference key to a component-variable.
     * 
     * (Required)
     * 
     */
    @JsonProperty("variable")
    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public EventData withVariable(Variable variable) {
        this.variable = variable;
        return this;
    }

    /**
     * *(2.1)* Severity associated with the monitor in _variableMonitoringId_ or with the hardwired notification.
     * 
     * 
     */
    @JsonProperty("severity")
    public int getSeverity() {
        return severity;
    }

    /**
     * *(2.1)* Severity associated with the monitor in _variableMonitoringId_ or with the hardwired notification.
     * 
     * 
     */
    @JsonProperty("severity")
    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public EventData withSeverity(int severity) {
        this.severity = severity;
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

    public EventData withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EventData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("eventId");
        sb.append('=');
        sb.append(this.eventId);
        sb.append(',');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
        sb.append(',');
        sb.append("trigger");
        sb.append('=');
        sb.append(((this.trigger == null)?"<null>":this.trigger));
        sb.append(',');
        sb.append("cause");
        sb.append('=');
        sb.append(this.cause);
        sb.append(',');
        sb.append("actualValue");
        sb.append('=');
        sb.append(((this.actualValue == null)?"<null>":this.actualValue));
        sb.append(',');
        sb.append("techCode");
        sb.append('=');
        sb.append(((this.techCode == null)?"<null>":this.techCode));
        sb.append(',');
        sb.append("techInfo");
        sb.append('=');
        sb.append(((this.techInfo == null)?"<null>":this.techInfo));
        sb.append(',');
        sb.append("cleared");
        sb.append('=');
        sb.append(this.cleared);
        sb.append(',');
        sb.append("transactionId");
        sb.append('=');
        sb.append(((this.transactionId == null)?"<null>":this.transactionId));
        sb.append(',');
        sb.append("component");
        sb.append('=');
        sb.append(((this.component == null)?"<null>":this.component));
        sb.append(',');
        sb.append("variableMonitoringId");
        sb.append('=');
        sb.append(this.variableMonitoringId);
        sb.append(',');
        sb.append("eventNotificationType");
        sb.append('=');
        sb.append(((this.eventNotificationType == null)?"<null>":this.eventNotificationType));
        sb.append(',');
        sb.append("variable");
        sb.append('=');
        sb.append(((this.variable == null)?"<null>":this.variable));
        sb.append(',');
        sb.append("severity");
        sb.append('=');
        sb.append(this.severity);
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
        result = ((result* 31)+ this.severity);
        result = ((result* 31)+ this.eventId);
        result = ((result* 31)+((this.techCode == null)? 0 :this.techCode.hashCode()));
        result = ((result* 31)+((this.actualValue == null)? 0 :this.actualValue.hashCode()));
        result = ((result* 31)+ this.cause);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.trigger == null)? 0 :this.trigger.hashCode()));
        result = ((result* 31)+((this.techInfo == null)? 0 :this.techInfo.hashCode()));
        result = ((result* 31)+((this.transactionId == null)? 0 :this.transactionId.hashCode()));
        result = ((result* 31)+((this.component == null)? 0 :this.component.hashCode()));
        result = ((result* 31)+ this.variableMonitoringId);
        result = ((result* 31)+((this.variable == null)? 0 :this.variable.hashCode()));
        result = ((result* 31)+((this.eventNotificationType == null)? 0 :this.eventNotificationType.hashCode()));
        result = ((result* 31)+(this.cleared? 1 : 0));
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EventData) == false) {
            return false;
        }
        EventData rhs = ((EventData) other);
        return (((((((((((((((this.severity == rhs.severity)&&(this.eventId == rhs.eventId))&&((this.techCode == rhs.techCode)||((this.techCode!= null)&&this.techCode.equals(rhs.techCode))))&&((this.actualValue == rhs.actualValue)||((this.actualValue!= null)&&this.actualValue.equals(rhs.actualValue))))&&(this.cause == rhs.cause))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.trigger == rhs.trigger)||((this.trigger!= null)&&this.trigger.equals(rhs.trigger))))&&((this.techInfo == rhs.techInfo)||((this.techInfo!= null)&&this.techInfo.equals(rhs.techInfo))))&&((this.transactionId == rhs.transactionId)||((this.transactionId!= null)&&this.transactionId.equals(rhs.transactionId))))&&((this.component == rhs.component)||((this.component!= null)&&this.component.equals(rhs.component))))&&(this.variableMonitoringId == rhs.variableMonitoringId))&&((this.variable == rhs.variable)||((this.variable!= null)&&this.variable.equals(rhs.variable))))&&((this.eventNotificationType == rhs.eventNotificationType)||((this.eventNotificationType!= null)&&this.eventNotificationType.equals(rhs.eventNotificationType))))&&(this.cleared == rhs.cleared))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))));
    }

}
