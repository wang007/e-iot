
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * Volume consumed of cost dimension.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "volume",
    "customData"
})
public class CostDimension {

    /**
     * Type of cost dimension: energy, power, time, etc.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Type of cost dimension: energy, power, time, etc.\r\n\r\n")
    @NotNull
    private CostDimensionEnum type;
    /**
     * Volume of the dimension consumed, measured according to the dimension type.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("volume")
    @JsonPropertyDescription("Volume of the dimension consumed, measured according to the dimension type.\r\n\r\n")
    @NotNull
    private double volume;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Type of cost dimension: energy, power, time, etc.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public CostDimensionEnum getType() {
        return type;
    }

    /**
     * Type of cost dimension: energy, power, time, etc.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(CostDimensionEnum type) {
        this.type = type;
    }

    public CostDimension withType(CostDimensionEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Volume of the dimension consumed, measured according to the dimension type.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("volume")
    public double getVolume() {
        return volume;
    }

    /**
     * Volume of the dimension consumed, measured according to the dimension type.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("volume")
    public void setVolume(double volume) {
        this.volume = volume;
    }

    public CostDimension withVolume(double volume) {
        this.volume = volume;
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

    public CostDimension withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CostDimension.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("volume");
        sb.append('=');
        sb.append(this.volume);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.volume)^(Double.doubleToLongBits(this.volume)>>> 32))));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CostDimension) == false) {
            return false;
        }
        CostDimension rhs = ((CostDimension) other);
        return (((Double.doubleToLongBits(this.volume) == Double.doubleToLongBits(rhs.volume))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))));
    }

}
