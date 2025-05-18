
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
    "t",
    "v",
    "customData"
})
public class StreamDataElement {

    /**
     * Offset relative to _basetime_ of this message. _basetime_ + _t_ is timestamp of recorded value.
     * 
     * (Required)
     * 
     */
    @JsonProperty("t")
    @JsonPropertyDescription("Offset relative to _basetime_ of this message. _basetime_ + _t_ is timestamp of recorded value.\r\n")
    @NotNull
    private double t;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("v")
    @Size(max = 2500)
    @NotNull
    private String v;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Offset relative to _basetime_ of this message. _basetime_ + _t_ is timestamp of recorded value.
     * 
     * (Required)
     * 
     */
    @JsonProperty("t")
    public double getT() {
        return t;
    }

    /**
     * Offset relative to _basetime_ of this message. _basetime_ + _t_ is timestamp of recorded value.
     * 
     * (Required)
     * 
     */
    @JsonProperty("t")
    public void setT(double t) {
        this.t = t;
    }

    public StreamDataElement withT(double t) {
        this.t = t;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("v")
    public String getV() {
        return v;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("v")
    public void setV(String v) {
        this.v = v;
    }

    public StreamDataElement withV(String v) {
        this.v = v;
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

    public StreamDataElement withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StreamDataElement.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("t");
        sb.append('=');
        sb.append(this.t);
        sb.append(',');
        sb.append("v");
        sb.append('=');
        sb.append(((this.v == null)?"<null>":this.v));
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.t)^(Double.doubleToLongBits(this.t)>>> 32))));
        result = ((result* 31)+((this.v == null)? 0 :this.v.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StreamDataElement) == false) {
            return false;
        }
        StreamDataElement rhs = ((StreamDataElement) other);
        return ((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&(Double.doubleToLongBits(this.t) == Double.doubleToLongBits(rhs.t)))&&((this.v == rhs.v)||((this.v!= null)&&this.v.equals(rhs.v))));
    }

}
