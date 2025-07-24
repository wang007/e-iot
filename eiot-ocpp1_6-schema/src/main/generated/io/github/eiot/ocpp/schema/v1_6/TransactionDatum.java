
package io.github.eiot.ocpp.schema.v1_6;

import java.time.OffsetDateTime;
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
public class TransactionDatum {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    @NotNull
    private OffsetDateTime timestamp;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sampledValue")
    @Valid
    @NotNull
    private List<SampledValue__1> sampledValue = new ArrayList<SampledValue__1>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public TransactionDatum withTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sampledValue")
    public List<SampledValue__1> getSampledValue() {
        return sampledValue;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sampledValue")
    public void setSampledValue(List<SampledValue__1> sampledValue) {
        this.sampledValue = sampledValue;
    }

    public TransactionDatum withSampledValue(List<SampledValue__1> sampledValue) {
        this.sampledValue = sampledValue;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TransactionDatum.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        if ((other instanceof TransactionDatum) == false) {
            return false;
        }
        TransactionDatum rhs = ((TransactionDatum) other);
        return (((this.sampledValue == rhs.sampledValue)||((this.sampledValue!= null)&&this.sampledValue.equals(rhs.sampledValue)))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))));
    }

}
