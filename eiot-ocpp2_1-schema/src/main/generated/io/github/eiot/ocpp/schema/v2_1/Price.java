
package io.github.eiot.ocpp.schema.v2_1;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;


/**
 * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "exclTax",
    "inclTax",
    "taxRates",
    "customData"
})
public class Price {

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
    @JsonProperty("taxRates")
    @Size(min = 1, max = 5)
    @Valid
    private List<TaxRate> taxRates = new ArrayList<TaxRate>();
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

    public Price withExclTax(double exclTax) {
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

    public Price withInclTax(double inclTax) {
        this.inclTax = inclTax;
        return this;
    }

    @JsonProperty("taxRates")
    public List<TaxRate> getTaxRates() {
        return taxRates;
    }

    @JsonProperty("taxRates")
    public void setTaxRates(List<TaxRate> taxRates) {
        this.taxRates = taxRates;
    }

    public Price withTaxRates(List<TaxRate> taxRates) {
        this.taxRates = taxRates;
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

    public Price withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Price.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("exclTax");
        sb.append('=');
        sb.append(this.exclTax);
        sb.append(',');
        sb.append("inclTax");
        sb.append('=');
        sb.append(this.inclTax);
        sb.append(',');
        sb.append("taxRates");
        sb.append('=');
        sb.append(((this.taxRates == null)?"<null>":this.taxRates));
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
        result = ((result* 31)+((this.taxRates == null)? 0 :this.taxRates.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.inclTax)^(Double.doubleToLongBits(this.inclTax)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.exclTax)^(Double.doubleToLongBits(this.exclTax)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Price) == false) {
            return false;
        }
        Price rhs = ((Price) other);
        return (((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&((this.taxRates == rhs.taxRates)||((this.taxRates!= null)&&this.taxRates.equals(rhs.taxRates))))&&(Double.doubleToLongBits(this.inclTax) == Double.doubleToLongBits(rhs.inclTax)))&&(Double.doubleToLongBits(this.exclTax) == Double.doubleToLongBits(rhs.exclTax)));
    }

}
