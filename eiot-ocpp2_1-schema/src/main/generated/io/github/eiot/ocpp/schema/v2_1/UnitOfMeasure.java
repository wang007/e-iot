
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;


/**
 * Represents a UnitOfMeasure with a multiplier
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "unit",
    "multiplier",
    "customData"
})
public class UnitOfMeasure {

    /**
     * Unit of the value. Default = "Wh" if the (default) measurand is an "Energy" type.
     * This field SHALL use a value from the list Standardized Units of Measurements in Part 2 Appendices. 
     * If an applicable unit is available in that list, otherwise a "custom" unit might be used.
     * 
     * 
     */
    @JsonProperty("unit")
    @JsonPropertyDescription("Unit of the value. Default = \"Wh\" if the (default) measurand is an \"Energy\" type.\r\nThis field SHALL use a value from the list Standardized Units of Measurements in Part 2 Appendices. \r\nIf an applicable unit is available in that list, otherwise a \"custom\" unit might be used.\r\n")
    @Size(max = 20)
    private String unit = "Wh";
    /**
     * Multiplier, this value represents the exponent to base 10. I.e. multiplier 3 means 10 raised to the 3rd power. Default is 0. +
     * The _multiplier_ only multiplies the value of the measurand. It does not specify a conversion between units, for example, kW and W.
     * 
     * 
     */
    @JsonProperty("multiplier")
    @JsonPropertyDescription("Multiplier, this value represents the exponent to base 10. I.e. multiplier 3 means 10 raised to the 3rd power. Default is 0. +\r\nThe _multiplier_ only multiplies the value of the measurand. It does not specify a conversion between units, for example, kW and W.\r\n")
    private int multiplier = 0;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Unit of the value. Default = "Wh" if the (default) measurand is an "Energy" type.
     * This field SHALL use a value from the list Standardized Units of Measurements in Part 2 Appendices. 
     * If an applicable unit is available in that list, otherwise a "custom" unit might be used.
     * 
     * 
     */
    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }

    /**
     * Unit of the value. Default = "Wh" if the (default) measurand is an "Energy" type.
     * This field SHALL use a value from the list Standardized Units of Measurements in Part 2 Appendices. 
     * If an applicable unit is available in that list, otherwise a "custom" unit might be used.
     * 
     * 
     */
    @JsonProperty("unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public UnitOfMeasure withUnit(String unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Multiplier, this value represents the exponent to base 10. I.e. multiplier 3 means 10 raised to the 3rd power. Default is 0. +
     * The _multiplier_ only multiplies the value of the measurand. It does not specify a conversion between units, for example, kW and W.
     * 
     * 
     */
    @JsonProperty("multiplier")
    public int getMultiplier() {
        return multiplier;
    }

    /**
     * Multiplier, this value represents the exponent to base 10. I.e. multiplier 3 means 10 raised to the 3rd power. Default is 0. +
     * The _multiplier_ only multiplies the value of the measurand. It does not specify a conversion between units, for example, kW and W.
     * 
     * 
     */
    @JsonProperty("multiplier")
    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public UnitOfMeasure withMultiplier(int multiplier) {
        this.multiplier = multiplier;
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

    public UnitOfMeasure withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(UnitOfMeasure.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("unit");
        sb.append('=');
        sb.append(((this.unit == null)?"<null>":this.unit));
        sb.append(',');
        sb.append("multiplier");
        sb.append('=');
        sb.append(this.multiplier);
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
        result = ((result* 31)+((this.unit == null)? 0 :this.unit.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.multiplier);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UnitOfMeasure) == false) {
            return false;
        }
        UnitOfMeasure rhs = ((UnitOfMeasure) other);
        return ((((this.unit == rhs.unit)||((this.unit!= null)&&this.unit.equals(rhs.unit)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.multiplier == rhs.multiplier));
    }

}
