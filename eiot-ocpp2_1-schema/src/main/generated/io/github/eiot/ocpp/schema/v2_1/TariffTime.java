
package io.github.eiot.ocpp.schema.v2_1;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Price elements and tax for time
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "prices",
    "taxRates",
    "customData"
})
public class TariffTime {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("prices")
    @Size(min = 1)
    @Valid
    @NotNull
    private List<TariffTimePrice> prices = new ArrayList<TariffTimePrice>();
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
     * 
     * (Required)
     * 
     */
    @JsonProperty("prices")
    public List<TariffTimePrice> getPrices() {
        return prices;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("prices")
    public void setPrices(List<TariffTimePrice> prices) {
        this.prices = prices;
    }

    public TariffTime withPrices(List<TariffTimePrice> prices) {
        this.prices = prices;
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

    public TariffTime withTaxRates(List<TaxRate> taxRates) {
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

    public TariffTime withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TariffTime.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("prices");
        sb.append('=');
        sb.append(((this.prices == null)?"<null>":this.prices));
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
        result = ((result* 31)+((this.prices == null)? 0 :this.prices.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TariffTime) == false) {
            return false;
        }
        TariffTime rhs = ((TariffTime) other);
        return ((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&((this.taxRates == rhs.taxRates)||((this.taxRates!= null)&&this.taxRates.equals(rhs.taxRates))))&&((this.prices == rhs.prices)||((this.prices!= null)&&this.prices.equals(rhs.prices))));
    }

}
