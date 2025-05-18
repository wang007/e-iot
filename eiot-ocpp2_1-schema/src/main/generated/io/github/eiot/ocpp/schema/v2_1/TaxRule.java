
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Part of ISO 15118-20 price schedule.
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "taxRuleID",
    "taxRuleName",
    "taxIncludedInPrice",
    "appliesToEnergyFee",
    "appliesToParkingFee",
    "appliesToOverstayFee",
    "appliesToMinimumMaximumCost",
    "taxRate",
    "customData"
})
public class TaxRule {

    /**
     * Id for the tax rule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("taxRuleID")
    @JsonPropertyDescription("Id for the tax rule.\r\n")
    @DecimalMin("0")
    @NotNull
    private int taxRuleID;
    /**
     * Human readable string to identify the tax rule.
     * 
     * 
     */
    @JsonProperty("taxRuleName")
    @JsonPropertyDescription("Human readable string to identify the tax rule.\r\n")
    @Size(max = 100)
    private String taxRuleName;
    /**
     * Indicates whether the tax is included in any price or not.
     * 
     * 
     */
    @JsonProperty("taxIncludedInPrice")
    @JsonPropertyDescription("Indicates whether the tax is included in any price or not.\r\n")
    private boolean taxIncludedInPrice;
    /**
     * Indicates whether this tax applies to Energy Fees.
     * 
     * (Required)
     * 
     */
    @JsonProperty("appliesToEnergyFee")
    @JsonPropertyDescription("Indicates whether this tax applies to Energy Fees.\r\n")
    @NotNull
    private boolean appliesToEnergyFee;
    /**
     * Indicates whether this tax applies to Parking Fees.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("appliesToParkingFee")
    @JsonPropertyDescription("Indicates whether this tax applies to Parking Fees.\r\n\r\n")
    @NotNull
    private boolean appliesToParkingFee;
    /**
     * Indicates whether this tax applies to Overstay Fees.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("appliesToOverstayFee")
    @JsonPropertyDescription("Indicates whether this tax applies to Overstay Fees.\r\n\r\n")
    @NotNull
    private boolean appliesToOverstayFee;
    /**
     * Indicates whether this tax applies to Minimum/Maximum Cost.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("appliesToMinimumMaximumCost")
    @JsonPropertyDescription("Indicates whether this tax applies to Minimum/Maximum Cost.\r\n\r\n")
    @NotNull
    private boolean appliesToMinimumMaximumCost;
    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("taxRate")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    @NotNull
    private RationalNumber taxRate;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Id for the tax rule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("taxRuleID")
    public int getTaxRuleID() {
        return taxRuleID;
    }

    /**
     * Id for the tax rule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("taxRuleID")
    public void setTaxRuleID(int taxRuleID) {
        this.taxRuleID = taxRuleID;
    }

    public TaxRule withTaxRuleID(int taxRuleID) {
        this.taxRuleID = taxRuleID;
        return this;
    }

    /**
     * Human readable string to identify the tax rule.
     * 
     * 
     */
    @JsonProperty("taxRuleName")
    public String getTaxRuleName() {
        return taxRuleName;
    }

    /**
     * Human readable string to identify the tax rule.
     * 
     * 
     */
    @JsonProperty("taxRuleName")
    public void setTaxRuleName(String taxRuleName) {
        this.taxRuleName = taxRuleName;
    }

    public TaxRule withTaxRuleName(String taxRuleName) {
        this.taxRuleName = taxRuleName;
        return this;
    }

    /**
     * Indicates whether the tax is included in any price or not.
     * 
     * 
     */
    @JsonProperty("taxIncludedInPrice")
    public boolean isTaxIncludedInPrice() {
        return taxIncludedInPrice;
    }

    /**
     * Indicates whether the tax is included in any price or not.
     * 
     * 
     */
    @JsonProperty("taxIncludedInPrice")
    public void setTaxIncludedInPrice(boolean taxIncludedInPrice) {
        this.taxIncludedInPrice = taxIncludedInPrice;
    }

    public TaxRule withTaxIncludedInPrice(boolean taxIncludedInPrice) {
        this.taxIncludedInPrice = taxIncludedInPrice;
        return this;
    }

    /**
     * Indicates whether this tax applies to Energy Fees.
     * 
     * (Required)
     * 
     */
    @JsonProperty("appliesToEnergyFee")
    public boolean isAppliesToEnergyFee() {
        return appliesToEnergyFee;
    }

    /**
     * Indicates whether this tax applies to Energy Fees.
     * 
     * (Required)
     * 
     */
    @JsonProperty("appliesToEnergyFee")
    public void setAppliesToEnergyFee(boolean appliesToEnergyFee) {
        this.appliesToEnergyFee = appliesToEnergyFee;
    }

    public TaxRule withAppliesToEnergyFee(boolean appliesToEnergyFee) {
        this.appliesToEnergyFee = appliesToEnergyFee;
        return this;
    }

    /**
     * Indicates whether this tax applies to Parking Fees.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("appliesToParkingFee")
    public boolean isAppliesToParkingFee() {
        return appliesToParkingFee;
    }

    /**
     * Indicates whether this tax applies to Parking Fees.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("appliesToParkingFee")
    public void setAppliesToParkingFee(boolean appliesToParkingFee) {
        this.appliesToParkingFee = appliesToParkingFee;
    }

    public TaxRule withAppliesToParkingFee(boolean appliesToParkingFee) {
        this.appliesToParkingFee = appliesToParkingFee;
        return this;
    }

    /**
     * Indicates whether this tax applies to Overstay Fees.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("appliesToOverstayFee")
    public boolean isAppliesToOverstayFee() {
        return appliesToOverstayFee;
    }

    /**
     * Indicates whether this tax applies to Overstay Fees.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("appliesToOverstayFee")
    public void setAppliesToOverstayFee(boolean appliesToOverstayFee) {
        this.appliesToOverstayFee = appliesToOverstayFee;
    }

    public TaxRule withAppliesToOverstayFee(boolean appliesToOverstayFee) {
        this.appliesToOverstayFee = appliesToOverstayFee;
        return this;
    }

    /**
     * Indicates whether this tax applies to Minimum/Maximum Cost.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("appliesToMinimumMaximumCost")
    public boolean isAppliesToMinimumMaximumCost() {
        return appliesToMinimumMaximumCost;
    }

    /**
     * Indicates whether this tax applies to Minimum/Maximum Cost.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("appliesToMinimumMaximumCost")
    public void setAppliesToMinimumMaximumCost(boolean appliesToMinimumMaximumCost) {
        this.appliesToMinimumMaximumCost = appliesToMinimumMaximumCost;
    }

    public TaxRule withAppliesToMinimumMaximumCost(boolean appliesToMinimumMaximumCost) {
        this.appliesToMinimumMaximumCost = appliesToMinimumMaximumCost;
        return this;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("taxRate")
    public RationalNumber getTaxRate() {
        return taxRate;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("taxRate")
    public void setTaxRate(RationalNumber taxRate) {
        this.taxRate = taxRate;
    }

    public TaxRule withTaxRate(RationalNumber taxRate) {
        this.taxRate = taxRate;
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

    public TaxRule withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TaxRule.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("taxRuleID");
        sb.append('=');
        sb.append(this.taxRuleID);
        sb.append(',');
        sb.append("taxRuleName");
        sb.append('=');
        sb.append(((this.taxRuleName == null)?"<null>":this.taxRuleName));
        sb.append(',');
        sb.append("taxIncludedInPrice");
        sb.append('=');
        sb.append(this.taxIncludedInPrice);
        sb.append(',');
        sb.append("appliesToEnergyFee");
        sb.append('=');
        sb.append(this.appliesToEnergyFee);
        sb.append(',');
        sb.append("appliesToParkingFee");
        sb.append('=');
        sb.append(this.appliesToParkingFee);
        sb.append(',');
        sb.append("appliesToOverstayFee");
        sb.append('=');
        sb.append(this.appliesToOverstayFee);
        sb.append(',');
        sb.append("appliesToMinimumMaximumCost");
        sb.append('=');
        sb.append(this.appliesToMinimumMaximumCost);
        sb.append(',');
        sb.append("taxRate");
        sb.append('=');
        sb.append(((this.taxRate == null)?"<null>":this.taxRate));
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
        result = ((result* 31)+(this.appliesToEnergyFee? 1 : 0));
        result = ((result* 31)+((this.taxRate == null)? 0 :this.taxRate.hashCode()));
        result = ((result* 31)+ this.taxRuleID);
        result = ((result* 31)+((this.taxRuleName == null)? 0 :this.taxRuleName.hashCode()));
        result = ((result* 31)+(this.appliesToOverstayFee? 1 : 0));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+(this.taxIncludedInPrice? 1 : 0));
        result = ((result* 31)+(this.appliesToParkingFee? 1 : 0));
        result = ((result* 31)+(this.appliesToMinimumMaximumCost? 1 : 0));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TaxRule) == false) {
            return false;
        }
        TaxRule rhs = ((TaxRule) other);
        return (((((((((this.appliesToEnergyFee == rhs.appliesToEnergyFee)&&((this.taxRate == rhs.taxRate)||((this.taxRate!= null)&&this.taxRate.equals(rhs.taxRate))))&&(this.taxRuleID == rhs.taxRuleID))&&((this.taxRuleName == rhs.taxRuleName)||((this.taxRuleName!= null)&&this.taxRuleName.equals(rhs.taxRuleName))))&&(this.appliesToOverstayFee == rhs.appliesToOverstayFee))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.taxIncludedInPrice == rhs.taxIncludedInPrice))&&(this.appliesToParkingFee == rhs.appliesToParkingFee))&&(this.appliesToMinimumMaximumCost == rhs.appliesToMinimumMaximumCost));
    }

}
