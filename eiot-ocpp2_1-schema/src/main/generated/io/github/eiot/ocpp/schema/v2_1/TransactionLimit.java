
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;


/**
 * Cost, energy, time or SoC limit for a transaction.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxCost",
    "maxEnergy",
    "maxTime",
    "maxSoC",
    "customData"
})
public class TransactionLimit {

    /**
     * Maximum allowed cost of transaction in currency of tariff.
     * 
     * 
     */
    @JsonProperty("maxCost")
    @JsonPropertyDescription("Maximum allowed cost of transaction in currency of tariff.\r\n")
    private double maxCost;
    /**
     * Maximum allowed energy in Wh to charge in transaction.
     * 
     * 
     */
    @JsonProperty("maxEnergy")
    @JsonPropertyDescription("Maximum allowed energy in Wh to charge in transaction.\r\n")
    private double maxEnergy;
    /**
     * Maximum duration of transaction in seconds from start to end.
     * 
     * 
     */
    @JsonProperty("maxTime")
    @JsonPropertyDescription("Maximum duration of transaction in seconds from start to end.\r\n")
    private int maxTime;
    /**
     * Maximum State of Charge of EV in percentage.
     * 
     * 
     */
    @JsonProperty("maxSoC")
    @JsonPropertyDescription("Maximum State of Charge of EV in percentage.\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private int maxSoC;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Maximum allowed cost of transaction in currency of tariff.
     * 
     * 
     */
    @JsonProperty("maxCost")
    public double getMaxCost() {
        return maxCost;
    }

    /**
     * Maximum allowed cost of transaction in currency of tariff.
     * 
     * 
     */
    @JsonProperty("maxCost")
    public void setMaxCost(double maxCost) {
        this.maxCost = maxCost;
    }

    public TransactionLimit withMaxCost(double maxCost) {
        this.maxCost = maxCost;
        return this;
    }

    /**
     * Maximum allowed energy in Wh to charge in transaction.
     * 
     * 
     */
    @JsonProperty("maxEnergy")
    public double getMaxEnergy() {
        return maxEnergy;
    }

    /**
     * Maximum allowed energy in Wh to charge in transaction.
     * 
     * 
     */
    @JsonProperty("maxEnergy")
    public void setMaxEnergy(double maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public TransactionLimit withMaxEnergy(double maxEnergy) {
        this.maxEnergy = maxEnergy;
        return this;
    }

    /**
     * Maximum duration of transaction in seconds from start to end.
     * 
     * 
     */
    @JsonProperty("maxTime")
    public int getMaxTime() {
        return maxTime;
    }

    /**
     * Maximum duration of transaction in seconds from start to end.
     * 
     * 
     */
    @JsonProperty("maxTime")
    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    public TransactionLimit withMaxTime(int maxTime) {
        this.maxTime = maxTime;
        return this;
    }

    /**
     * Maximum State of Charge of EV in percentage.
     * 
     * 
     */
    @JsonProperty("maxSoC")
    public int getMaxSoC() {
        return maxSoC;
    }

    /**
     * Maximum State of Charge of EV in percentage.
     * 
     * 
     */
    @JsonProperty("maxSoC")
    public void setMaxSoC(int maxSoC) {
        this.maxSoC = maxSoC;
    }

    public TransactionLimit withMaxSoC(int maxSoC) {
        this.maxSoC = maxSoC;
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

    public TransactionLimit withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TransactionLimit.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("maxCost");
        sb.append('=');
        sb.append(this.maxCost);
        sb.append(',');
        sb.append("maxEnergy");
        sb.append('=');
        sb.append(this.maxEnergy);
        sb.append(',');
        sb.append("maxTime");
        sb.append('=');
        sb.append(this.maxTime);
        sb.append(',');
        sb.append("maxSoC");
        sb.append('=');
        sb.append(this.maxSoC);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxCost)^(Double.doubleToLongBits(this.maxCost)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxEnergy)^(Double.doubleToLongBits(this.maxEnergy)>>> 32))));
        result = ((result* 31)+ this.maxTime);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.maxSoC);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TransactionLimit) == false) {
            return false;
        }
        TransactionLimit rhs = ((TransactionLimit) other);
        return (((((Double.doubleToLongBits(this.maxCost) == Double.doubleToLongBits(rhs.maxCost))&&(Double.doubleToLongBits(this.maxEnergy) == Double.doubleToLongBits(rhs.maxEnergy)))&&(this.maxTime == rhs.maxTime))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.maxSoC == rhs.maxSoC));
    }

}
