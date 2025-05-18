
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
 * CostDetailsType contains the cost as calculated by Charging Station based on provided TariffType.
 * 
 * NOTE: Reservation is not shown as a _chargingPeriod_, because it took place outside of the transaction.
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "chargingPeriods",
    "totalCost",
    "totalUsage",
    "failureToCalculate",
    "failureReason",
    "customData"
})
public class CostDetails {

    @JsonProperty("chargingPeriods")
    @Size(min = 1)
    @Valid
    private List<ChargingPeriod> chargingPeriods = new ArrayList<ChargingPeriod>();
    /**
     * This contains the cost calculated during a transaction. It is used both for running cost and final cost of the transaction.
     * 
     * (Required)
     * 
     */
    @JsonProperty("totalCost")
    @JsonPropertyDescription("This contains the cost calculated during a transaction. It is used both for running cost and final cost of the transaction.\r\n")
    @Valid
    @NotNull
    private TotalCost totalCost;
    /**
     * This contains the calculated usage of energy, charging time and idle time during a transaction.
     * 
     * (Required)
     * 
     */
    @JsonProperty("totalUsage")
    @JsonPropertyDescription("This contains the calculated usage of energy, charging time and idle time during a transaction.\r\n")
    @Valid
    @NotNull
    private TotalUsage totalUsage;
    /**
     * If set to true, then Charging Station has failed to calculate the cost.
     * 
     * 
     * 
     */
    @JsonProperty("failureToCalculate")
    @JsonPropertyDescription("If set to true, then Charging Station has failed to calculate the cost.\r\n\r\n")
    private boolean failureToCalculate;
    /**
     * Optional human-readable reason text in case of failure to calculate.
     * 
     * 
     * 
     */
    @JsonProperty("failureReason")
    @JsonPropertyDescription("Optional human-readable reason text in case of failure to calculate.\r\n\r\n")
    @Size(max = 500)
    private String failureReason;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    @JsonProperty("chargingPeriods")
    public List<ChargingPeriod> getChargingPeriods() {
        return chargingPeriods;
    }

    @JsonProperty("chargingPeriods")
    public void setChargingPeriods(List<ChargingPeriod> chargingPeriods) {
        this.chargingPeriods = chargingPeriods;
    }

    public CostDetails withChargingPeriods(List<ChargingPeriod> chargingPeriods) {
        this.chargingPeriods = chargingPeriods;
        return this;
    }

    /**
     * This contains the cost calculated during a transaction. It is used both for running cost and final cost of the transaction.
     * 
     * (Required)
     * 
     */
    @JsonProperty("totalCost")
    public TotalCost getTotalCost() {
        return totalCost;
    }

    /**
     * This contains the cost calculated during a transaction. It is used both for running cost and final cost of the transaction.
     * 
     * (Required)
     * 
     */
    @JsonProperty("totalCost")
    public void setTotalCost(TotalCost totalCost) {
        this.totalCost = totalCost;
    }

    public CostDetails withTotalCost(TotalCost totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    /**
     * This contains the calculated usage of energy, charging time and idle time during a transaction.
     * 
     * (Required)
     * 
     */
    @JsonProperty("totalUsage")
    public TotalUsage getTotalUsage() {
        return totalUsage;
    }

    /**
     * This contains the calculated usage of energy, charging time and idle time during a transaction.
     * 
     * (Required)
     * 
     */
    @JsonProperty("totalUsage")
    public void setTotalUsage(TotalUsage totalUsage) {
        this.totalUsage = totalUsage;
    }

    public CostDetails withTotalUsage(TotalUsage totalUsage) {
        this.totalUsage = totalUsage;
        return this;
    }

    /**
     * If set to true, then Charging Station has failed to calculate the cost.
     * 
     * 
     * 
     */
    @JsonProperty("failureToCalculate")
    public boolean isFailureToCalculate() {
        return failureToCalculate;
    }

    /**
     * If set to true, then Charging Station has failed to calculate the cost.
     * 
     * 
     * 
     */
    @JsonProperty("failureToCalculate")
    public void setFailureToCalculate(boolean failureToCalculate) {
        this.failureToCalculate = failureToCalculate;
    }

    public CostDetails withFailureToCalculate(boolean failureToCalculate) {
        this.failureToCalculate = failureToCalculate;
        return this;
    }

    /**
     * Optional human-readable reason text in case of failure to calculate.
     * 
     * 
     * 
     */
    @JsonProperty("failureReason")
    public String getFailureReason() {
        return failureReason;
    }

    /**
     * Optional human-readable reason text in case of failure to calculate.
     * 
     * 
     * 
     */
    @JsonProperty("failureReason")
    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public CostDetails withFailureReason(String failureReason) {
        this.failureReason = failureReason;
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

    public CostDetails withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CostDetails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("chargingPeriods");
        sb.append('=');
        sb.append(((this.chargingPeriods == null)?"<null>":this.chargingPeriods));
        sb.append(',');
        sb.append("totalCost");
        sb.append('=');
        sb.append(((this.totalCost == null)?"<null>":this.totalCost));
        sb.append(',');
        sb.append("totalUsage");
        sb.append('=');
        sb.append(((this.totalUsage == null)?"<null>":this.totalUsage));
        sb.append(',');
        sb.append("failureToCalculate");
        sb.append('=');
        sb.append(this.failureToCalculate);
        sb.append(',');
        sb.append("failureReason");
        sb.append('=');
        sb.append(((this.failureReason == null)?"<null>":this.failureReason));
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
        result = ((result* 31)+(this.failureToCalculate? 1 : 0));
        result = ((result* 31)+((this.failureReason == null)? 0 :this.failureReason.hashCode()));
        result = ((result* 31)+((this.totalUsage == null)? 0 :this.totalUsage.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.chargingPeriods == null)? 0 :this.chargingPeriods.hashCode()));
        result = ((result* 31)+((this.totalCost == null)? 0 :this.totalCost.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CostDetails) == false) {
            return false;
        }
        CostDetails rhs = ((CostDetails) other);
        return ((((((this.failureToCalculate == rhs.failureToCalculate)&&((this.failureReason == rhs.failureReason)||((this.failureReason!= null)&&this.failureReason.equals(rhs.failureReason))))&&((this.totalUsage == rhs.totalUsage)||((this.totalUsage!= null)&&this.totalUsage.equals(rhs.totalUsage))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.chargingPeriods == rhs.chargingPeriods)||((this.chargingPeriods!= null)&&this.chargingPeriods.equals(rhs.chargingPeriods))))&&((this.totalCost == rhs.totalCost)||((this.totalCost!= null)&&this.totalCost.equals(rhs.totalCost))));
    }

}
