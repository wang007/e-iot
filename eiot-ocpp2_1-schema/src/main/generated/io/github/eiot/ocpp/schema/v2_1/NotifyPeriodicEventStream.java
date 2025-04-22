
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "id",
    "pending",
    "basetime",
    "customData"
})
public class NotifyPeriodicEventStream {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("data")
    @Size(min = 1)
    @Valid
    @NotNull
    private List<StreamDataElement> data = new ArrayList<StreamDataElement>();
    /**
     * Id of stream.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Id of stream.\r\n")
    @DecimalMin("0")
    @NotNull
    private int id;
    /**
     * Number of data elements still pending to be sent.
     * 
     * (Required)
     * 
     */
    @JsonProperty("pending")
    @JsonPropertyDescription("Number of data elements still pending to be sent.\r\n")
    @DecimalMin("0")
    @NotNull
    private int pending;
    /**
     * Base timestamp to add to time offset of values.
     * 
     * (Required)
     * 
     */
    @JsonProperty("basetime")
    @JsonPropertyDescription("Base timestamp to add to time offset of values.\r\n")
    @NotNull
    private ZonedDateTime basetime;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("data")
    public List<StreamDataElement> getData() {
        return data;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("data")
    public void setData(List<StreamDataElement> data) {
        this.data = data;
    }

    public NotifyPeriodicEventStream withData(List<StreamDataElement> data) {
        this.data = data;
        return this;
    }

    /**
     * Id of stream.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    /**
     * Id of stream.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    public NotifyPeriodicEventStream withId(int id) {
        this.id = id;
        return this;
    }

    /**
     * Number of data elements still pending to be sent.
     * 
     * (Required)
     * 
     */
    @JsonProperty("pending")
    public int getPending() {
        return pending;
    }

    /**
     * Number of data elements still pending to be sent.
     * 
     * (Required)
     * 
     */
    @JsonProperty("pending")
    public void setPending(int pending) {
        this.pending = pending;
    }

    public NotifyPeriodicEventStream withPending(int pending) {
        this.pending = pending;
        return this;
    }

    /**
     * Base timestamp to add to time offset of values.
     * 
     * (Required)
     * 
     */
    @JsonProperty("basetime")
    public ZonedDateTime getBasetime() {
        return basetime;
    }

    /**
     * Base timestamp to add to time offset of values.
     * 
     * (Required)
     * 
     */
    @JsonProperty("basetime")
    public void setBasetime(ZonedDateTime basetime) {
        this.basetime = basetime;
    }

    public NotifyPeriodicEventStream withBasetime(ZonedDateTime basetime) {
        this.basetime = basetime;
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

    public NotifyPeriodicEventStream withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NotifyPeriodicEventStream.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("data");
        sb.append('=');
        sb.append(((this.data == null)?"<null>":this.data));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(this.id);
        sb.append(',');
        sb.append("pending");
        sb.append('=');
        sb.append(this.pending);
        sb.append(',');
        sb.append("basetime");
        sb.append('=');
        sb.append(((this.basetime == null)?"<null>":this.basetime));
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
        result = ((result* 31)+ this.id);
        result = ((result* 31)+((this.data == null)? 0 :this.data.hashCode()));
        result = ((result* 31)+((this.basetime == null)? 0 :this.basetime.hashCode()));
        result = ((result* 31)+ this.pending);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NotifyPeriodicEventStream) == false) {
            return false;
        }
        NotifyPeriodicEventStream rhs = ((NotifyPeriodicEventStream) other);
        return ((((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&(this.id == rhs.id))&&((this.data == rhs.data)||((this.data!= null)&&this.data.equals(rhs.data))))&&((this.basetime == rhs.basetime)||((this.basetime!= null)&&this.basetime.equals(rhs.basetime))))&&(this.pending == rhs.pending));
    }

}
