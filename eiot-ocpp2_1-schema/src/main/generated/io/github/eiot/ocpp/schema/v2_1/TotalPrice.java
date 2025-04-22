
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;


/**
 * Total cost with and without tax. Contains the total of energy, charging time, idle time, fixed and reservation costs including and/or excluding tax.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "exclTax",
    "inclTax",
    "customData"
})
public class TotalPrice {

    /**
     * Price/cost excluding tax. Can be absent if _inclTax_ is present.
     * 
     * 
     */
    @JsonProperty("exclTax")
    @JsonPropertyDescription("Price/cost excluding tax. Can be absent if _inclTax_ is present.\r\n")
    private double exclTax;
    /**
     * Price/cost including tax. Can be absent if _exclTax_ is present.
     * 
     * 
     */
    @JsonProperty("inclTax")
    @JsonPropertyDescription("Price/cost including tax. Can be absent if _exclTax_ is present.\r\n")
    private double inclTax;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Price/cost excluding tax. Can be absent if _inclTax_ is present.
     * 
     * 
     */
    @JsonProperty("exclTax")
    public double getExclTax() {
        return exclTax;
    }

    /**
     * Price/cost excluding tax. Can be absent if _inclTax_ is present.
     * 
     * 
     */
    @JsonProperty("exclTax")
    public void setExclTax(double exclTax) {
        this.exclTax = exclTax;
    }

    public TotalPrice withExclTax(double exclTax) {
        this.exclTax = exclTax;
        return this;
    }

    /**
     * Price/cost including tax. Can be absent if _exclTax_ is present.
     * 
     * 
     */
    @JsonProperty("inclTax")
    public double getInclTax() {
        return inclTax;
    }

    /**
     * Price/cost including tax. Can be absent if _exclTax_ is present.
     * 
     * 
     */
    @JsonProperty("inclTax")
    public void setInclTax(double inclTax) {
        this.inclTax = inclTax;
    }

    public TotalPrice withInclTax(double inclTax) {
        this.inclTax = inclTax;
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

    public TotalPrice withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TotalPrice.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("exclTax");
        sb.append('=');
        sb.append(this.exclTax);
        sb.append(',');
        sb.append("inclTax");
        sb.append('=');
        sb.append(this.inclTax);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.inclTax)^(Double.doubleToLongBits(this.inclTax)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.exclTax)^(Double.doubleToLongBits(this.exclTax)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TotalPrice) == false) {
            return false;
        }
        TotalPrice rhs = ((TotalPrice) other);
        return ((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&(Double.doubleToLongBits(this.inclTax) == Double.doubleToLongBits(rhs.inclTax)))&&(Double.doubleToLongBits(this.exclTax) == Double.doubleToLongBits(rhs.exclTax)));
    }

}
