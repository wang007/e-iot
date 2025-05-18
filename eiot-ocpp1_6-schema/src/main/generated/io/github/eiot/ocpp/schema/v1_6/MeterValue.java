
package io.github.eiot.ocpp.schema.v1_6;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "timestamp",
    "sampledValue"
})
public class MeterValue {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    @NotNull
    private ZonedDateTime timestamp;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sampledValue")
    @Valid
    @NotNull
    private List<SampledValue> sampledValue = new ArrayList<SampledValue>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public MeterValue withTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sampledValue")
    public List<SampledValue> getSampledValue() {
        return sampledValue;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sampledValue")
    public void setSampledValue(List<SampledValue> sampledValue) {
        this.sampledValue = sampledValue;
    }

    public MeterValue withSampledValue(List<SampledValue> sampledValue) {
        this.sampledValue = sampledValue;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MeterValue.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
        sb.append(',');
        sb.append("sampledValue");
        sb.append('=');
        sb.append(((this.sampledValue == null)?"<null>":this.sampledValue));
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
        result = ((result* 31)+((this.sampledValue == null)? 0 :this.sampledValue.hashCode()));
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MeterValue) == false) {
            return false;
        }
        MeterValue rhs = ((MeterValue) other);
        return (((this.sampledValue == rhs.sampledValue)||((this.sampledValue!= null)&&this.sampledValue.equals(rhs.sampledValue)))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))));
    }

}
