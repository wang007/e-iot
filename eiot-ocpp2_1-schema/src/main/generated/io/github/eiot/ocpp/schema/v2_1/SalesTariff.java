
package io.github.eiot.ocpp.schema.v2_1;

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


/**
 * A SalesTariff provided by a Mobility Operator (EMSP) .
 * NOTE: This dataType is based on dataTypes from &lt;&lt;ref-ISOIEC15118-2,ISO 15118-2&gt;&gt;.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "salesTariffDescription",
    "numEPriceLevels",
    "salesTariffEntry",
    "customData"
})
public class SalesTariff {

    /**
     * SalesTariff identifier used to identify one sales tariff. An SAID remains a unique identifier for one schedule throughout a charging session.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("SalesTariff identifier used to identify one sales tariff. An SAID remains a unique identifier for one schedule throughout a charging session.\r\n")
    @DecimalMin("0")
    @NotNull
    private int id;
    /**
     * A human readable title/short description of the sales tariff e.g. for HMI display purposes.
     * 
     * 
     */
    @JsonProperty("salesTariffDescription")
    @JsonPropertyDescription("A human readable title/short description of the sales tariff e.g. for HMI display purposes.\r\n")
    @Size(max = 32)
    private String salesTariffDescription;
    /**
     * Defines the overall number of distinct price levels used across all provided SalesTariff elements.
     * 
     * 
     */
    @JsonProperty("numEPriceLevels")
    @JsonPropertyDescription("Defines the overall number of distinct price levels used across all provided SalesTariff elements.\r\n")
    @DecimalMin("0")
    private int numEPriceLevels;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("salesTariffEntry")
    @Size(min = 1, max = 1024)
    @Valid
    @NotNull
    private List<SalesTariffEntry> salesTariffEntry = new ArrayList<SalesTariffEntry>();
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * SalesTariff identifier used to identify one sales tariff. An SAID remains a unique identifier for one schedule throughout a charging session.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    /**
     * SalesTariff identifier used to identify one sales tariff. An SAID remains a unique identifier for one schedule throughout a charging session.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    public SalesTariff withId(int id) {
        this.id = id;
        return this;
    }

    /**
     * A human readable title/short description of the sales tariff e.g. for HMI display purposes.
     * 
     * 
     */
    @JsonProperty("salesTariffDescription")
    public String getSalesTariffDescription() {
        return salesTariffDescription;
    }

    /**
     * A human readable title/short description of the sales tariff e.g. for HMI display purposes.
     * 
     * 
     */
    @JsonProperty("salesTariffDescription")
    public void setSalesTariffDescription(String salesTariffDescription) {
        this.salesTariffDescription = salesTariffDescription;
    }

    public SalesTariff withSalesTariffDescription(String salesTariffDescription) {
        this.salesTariffDescription = salesTariffDescription;
        return this;
    }

    /**
     * Defines the overall number of distinct price levels used across all provided SalesTariff elements.
     * 
     * 
     */
    @JsonProperty("numEPriceLevels")
    public int getNumEPriceLevels() {
        return numEPriceLevels;
    }

    /**
     * Defines the overall number of distinct price levels used across all provided SalesTariff elements.
     * 
     * 
     */
    @JsonProperty("numEPriceLevels")
    public void setNumEPriceLevels(int numEPriceLevels) {
        this.numEPriceLevels = numEPriceLevels;
    }

    public SalesTariff withNumEPriceLevels(int numEPriceLevels) {
        this.numEPriceLevels = numEPriceLevels;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("salesTariffEntry")
    public List<SalesTariffEntry> getSalesTariffEntry() {
        return salesTariffEntry;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("salesTariffEntry")
    public void setSalesTariffEntry(List<SalesTariffEntry> salesTariffEntry) {
        this.salesTariffEntry = salesTariffEntry;
    }

    public SalesTariff withSalesTariffEntry(List<SalesTariffEntry> salesTariffEntry) {
        this.salesTariffEntry = salesTariffEntry;
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

    public SalesTariff withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SalesTariff.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(this.id);
        sb.append(',');
        sb.append("salesTariffDescription");
        sb.append('=');
        sb.append(((this.salesTariffDescription == null)?"<null>":this.salesTariffDescription));
        sb.append(',');
        sb.append("numEPriceLevels");
        sb.append('=');
        sb.append(this.numEPriceLevels);
        sb.append(',');
        sb.append("salesTariffEntry");
        sb.append('=');
        sb.append(((this.salesTariffEntry == null)?"<null>":this.salesTariffEntry));
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
        result = ((result* 31)+((this.salesTariffEntry == null)? 0 :this.salesTariffEntry.hashCode()));
        result = ((result* 31)+((this.salesTariffDescription == null)? 0 :this.salesTariffDescription.hashCode()));
        result = ((result* 31)+ this.numEPriceLevels);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SalesTariff) == false) {
            return false;
        }
        SalesTariff rhs = ((SalesTariff) other);
        return ((((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&(this.id == rhs.id))&&((this.salesTariffEntry == rhs.salesTariffEntry)||((this.salesTariffEntry!= null)&&this.salesTariffEntry.equals(rhs.salesTariffEntry))))&&((this.salesTariffDescription == rhs.salesTariffDescription)||((this.salesTariffDescription!= null)&&this.salesTariffDescription.equals(rhs.salesTariffDescription))))&&(this.numEPriceLevels == rhs.numEPriceLevels));
    }

}
