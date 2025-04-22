
package io.github.eiot.ocpp.schema.v2_1;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "controlId",
    "started",
    "timestamp",
    "supersededIds",
    "customData"
})
public class NotifyDERStartStopRequest {

    /**
     * Id of the started or stopped DER control.
     * Corresponds to the _controlId_ of the SetDERControlRequest.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("controlId")
    @JsonPropertyDescription("Id of the started or stopped DER control.\r\nCorresponds to the _controlId_ of the SetDERControlRequest.\r\n\r\n")
    @Size(max = 36)
    @NotNull
    private String controlId;
    /**
     * True if DER control has started. False if it has ended.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("started")
    @JsonPropertyDescription("True if DER control has started. False if it has ended.\r\n\r\n")
    @NotNull
    private boolean started;
    /**
     * Time of start or end of event.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("Time of start or end of event.\r\n\r\n")
    @NotNull
    private ZonedDateTime timestamp;
    /**
     * List of controlIds that are superseded as a result of this control starting.
     * 
     * 
     * 
     */
    @JsonProperty("supersededIds")
    @JsonPropertyDescription("List of controlIds that are superseded as a result of this control starting.\r\n\r\n")
    @Size(min = 1, max = 24)
    @Valid
    private List<String> supersededIds = new ArrayList<String>();
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Id of the started or stopped DER control.
     * Corresponds to the _controlId_ of the SetDERControlRequest.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("controlId")
    public String getControlId() {
        return controlId;
    }

    /**
     * Id of the started or stopped DER control.
     * Corresponds to the _controlId_ of the SetDERControlRequest.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("controlId")
    public void setControlId(String controlId) {
        this.controlId = controlId;
    }

    public NotifyDERStartStopRequest withControlId(String controlId) {
        this.controlId = controlId;
        return this;
    }

    /**
     * True if DER control has started. False if it has ended.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("started")
    public boolean isStarted() {
        return started;
    }

    /**
     * True if DER control has started. False if it has ended.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("started")
    public void setStarted(boolean started) {
        this.started = started;
    }

    public NotifyDERStartStopRequest withStarted(boolean started) {
        this.started = started;
        return this;
    }

    /**
     * Time of start or end of event.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Time of start or end of event.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public NotifyDERStartStopRequest withTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * List of controlIds that are superseded as a result of this control starting.
     * 
     * 
     * 
     */
    @JsonProperty("supersededIds")
    public List<String> getSupersededIds() {
        return supersededIds;
    }

    /**
     * List of controlIds that are superseded as a result of this control starting.
     * 
     * 
     * 
     */
    @JsonProperty("supersededIds")
    public void setSupersededIds(List<String> supersededIds) {
        this.supersededIds = supersededIds;
    }

    public NotifyDERStartStopRequest withSupersededIds(List<String> supersededIds) {
        this.supersededIds = supersededIds;
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

    public NotifyDERStartStopRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NotifyDERStartStopRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("controlId");
        sb.append('=');
        sb.append(((this.controlId == null)?"<null>":this.controlId));
        sb.append(',');
        sb.append("started");
        sb.append('=');
        sb.append(this.started);
        sb.append(',');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
        sb.append(',');
        sb.append("supersededIds");
        sb.append('=');
        sb.append(((this.supersededIds == null)?"<null>":this.supersededIds));
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
        result = ((result* 31)+(this.started? 1 : 0));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.controlId == null)? 0 :this.controlId.hashCode()));
        result = ((result* 31)+((this.supersededIds == null)? 0 :this.supersededIds.hashCode()));
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NotifyDERStartStopRequest) == false) {
            return false;
        }
        NotifyDERStartStopRequest rhs = ((NotifyDERStartStopRequest) other);
        return (((((this.started == rhs.started)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.controlId == rhs.controlId)||((this.controlId!= null)&&this.controlId.equals(rhs.controlId))))&&((this.supersededIds == rhs.supersededIds)||((this.supersededIds!= null)&&this.supersededIds.equals(rhs.supersededIds))))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))));
    }

}
