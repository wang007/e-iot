
package io.github.eiot.ocpp.schema.v2_1;

import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "controlType",
    "gridEventFault",
    "alarmEnded",
    "timestamp",
    "extraInfo",
    "customData"
})
public class NotifyDERAlarmRequest {

    /**
     * Name of DER control, e.g. LFMustTrip
     * 
     * (Required)
     * 
     */
    @JsonProperty("controlType")
    @JsonPropertyDescription("Name of DER control, e.g. LFMustTrip\r\n")
    @NotNull
    private DERControlEnum controlType;
    /**
     * Type of grid event that caused this
     * 
     * 
     * 
     */
    @JsonProperty("gridEventFault")
    @JsonPropertyDescription("Type of grid event that caused this\r\n\r\n")
    private GridEventFaultEnum gridEventFault;
    /**
     * True when error condition has ended.
     * Absent or false when alarm has started.
     * 
     * 
     * 
     */
    @JsonProperty("alarmEnded")
    @JsonPropertyDescription("True when error condition has ended.\r\nAbsent or false when alarm has started.\r\n\r\n")
    private boolean alarmEnded;
    /**
     * Time of start or end of alarm.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("Time of start or end of alarm.\r\n\r\n")
    @NotNull
    private OffsetDateTime timestamp;
    /**
     * Optional info provided by EV.
     * 
     * 
     * 
     */
    @JsonProperty("extraInfo")
    @JsonPropertyDescription("Optional info provided by EV.\r\n\r\n")
    @Size(max = 200)
    private String extraInfo;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Name of DER control, e.g. LFMustTrip
     * 
     * (Required)
     * 
     */
    @JsonProperty("controlType")
    public DERControlEnum getControlType() {
        return controlType;
    }

    /**
     * Name of DER control, e.g. LFMustTrip
     * 
     * (Required)
     * 
     */
    @JsonProperty("controlType")
    public void setControlType(DERControlEnum controlType) {
        this.controlType = controlType;
    }

    public NotifyDERAlarmRequest withControlType(DERControlEnum controlType) {
        this.controlType = controlType;
        return this;
    }

    /**
     * Type of grid event that caused this
     * 
     * 
     * 
     */
    @JsonProperty("gridEventFault")
    public GridEventFaultEnum getGridEventFault() {
        return gridEventFault;
    }

    /**
     * Type of grid event that caused this
     * 
     * 
     * 
     */
    @JsonProperty("gridEventFault")
    public void setGridEventFault(GridEventFaultEnum gridEventFault) {
        this.gridEventFault = gridEventFault;
    }

    public NotifyDERAlarmRequest withGridEventFault(GridEventFaultEnum gridEventFault) {
        this.gridEventFault = gridEventFault;
        return this;
    }

    /**
     * True when error condition has ended.
     * Absent or false when alarm has started.
     * 
     * 
     * 
     */
    @JsonProperty("alarmEnded")
    public boolean isAlarmEnded() {
        return alarmEnded;
    }

    /**
     * True when error condition has ended.
     * Absent or false when alarm has started.
     * 
     * 
     * 
     */
    @JsonProperty("alarmEnded")
    public void setAlarmEnded(boolean alarmEnded) {
        this.alarmEnded = alarmEnded;
    }

    public NotifyDERAlarmRequest withAlarmEnded(boolean alarmEnded) {
        this.alarmEnded = alarmEnded;
        return this;
    }

    /**
     * Time of start or end of alarm.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Time of start or end of alarm.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public NotifyDERAlarmRequest withTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Optional info provided by EV.
     * 
     * 
     * 
     */
    @JsonProperty("extraInfo")
    public String getExtraInfo() {
        return extraInfo;
    }

    /**
     * Optional info provided by EV.
     * 
     * 
     * 
     */
    @JsonProperty("extraInfo")
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public NotifyDERAlarmRequest withExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
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

    public NotifyDERAlarmRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NotifyDERAlarmRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("controlType");
        sb.append('=');
        sb.append(((this.controlType == null)?"<null>":this.controlType));
        sb.append(',');
        sb.append("gridEventFault");
        sb.append('=');
        sb.append(((this.gridEventFault == null)?"<null>":this.gridEventFault));
        sb.append(',');
        sb.append("alarmEnded");
        sb.append('=');
        sb.append(this.alarmEnded);
        sb.append(',');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
        sb.append(',');
        sb.append("extraInfo");
        sb.append('=');
        sb.append(((this.extraInfo == null)?"<null>":this.extraInfo));
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
        result = ((result* 31)+((this.gridEventFault == null)? 0 :this.gridEventFault.hashCode()));
        result = ((result* 31)+(this.alarmEnded? 1 : 0));
        result = ((result* 31)+((this.controlType == null)? 0 :this.controlType.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        result = ((result* 31)+((this.extraInfo == null)? 0 :this.extraInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NotifyDERAlarmRequest) == false) {
            return false;
        }
        NotifyDERAlarmRequest rhs = ((NotifyDERAlarmRequest) other);
        return (((((((this.gridEventFault == rhs.gridEventFault)||((this.gridEventFault!= null)&&this.gridEventFault.equals(rhs.gridEventFault)))&&(this.alarmEnded == rhs.alarmEnded))&&((this.controlType == rhs.controlType)||((this.controlType!= null)&&this.controlType.equals(rhs.controlType))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))))&&((this.extraInfo == rhs.extraInfo)||((this.extraInfo!= null)&&this.extraInfo.equals(rhs.extraInfo))));
    }

}
