
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "interval",
    "values",
    "customData"
})
public class PeriodicEventStreamParams {

    /**
     * Time in seconds after which stream data is sent.
     * 
     * 
     */
    @JsonProperty("interval")
    @JsonPropertyDescription("Time in seconds after which stream data is sent.\r\n")
    @DecimalMin("0")
    private int interval;
    /**
     * Number of items to be sent together in stream.
     * 
     * 
     */
    @JsonProperty("values")
    @JsonPropertyDescription("Number of items to be sent together in stream.\r\n")
    @DecimalMin("0")
    private int values;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Time in seconds after which stream data is sent.
     * 
     * 
     */
    @JsonProperty("interval")
    public int getInterval() {
        return interval;
    }

    /**
     * Time in seconds after which stream data is sent.
     * 
     * 
     */
    @JsonProperty("interval")
    public void setInterval(int interval) {
        this.interval = interval;
    }

    public PeriodicEventStreamParams withInterval(int interval) {
        this.interval = interval;
        return this;
    }

    /**
     * Number of items to be sent together in stream.
     * 
     * 
     */
    @JsonProperty("values")
    public int getValues() {
        return values;
    }

    /**
     * Number of items to be sent together in stream.
     * 
     * 
     */
    @JsonProperty("values")
    public void setValues(int values) {
        this.values = values;
    }

    public PeriodicEventStreamParams withValues(int values) {
        this.values = values;
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

    public PeriodicEventStreamParams withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PeriodicEventStreamParams.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("interval");
        sb.append('=');
        sb.append(this.interval);
        sb.append(',');
        sb.append("values");
        sb.append('=');
        sb.append(this.values);
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
        result = ((result* 31)+ this.interval);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.values);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PeriodicEventStreamParams) == false) {
            return false;
        }
        PeriodicEventStreamParams rhs = ((PeriodicEventStreamParams) other);
        return (((this.interval == rhs.interval)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.values == rhs.values));
    }

}
