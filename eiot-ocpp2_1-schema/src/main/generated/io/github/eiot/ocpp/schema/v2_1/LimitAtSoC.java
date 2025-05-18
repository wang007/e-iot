
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "soc",
    "limit",
    "customData"
})
public class LimitAtSoC {

    /**
     * The SoC value beyond which the charging rate limit should be applied.
     * 
     * (Required)
     * 
     */
    @JsonProperty("soc")
    @JsonPropertyDescription("The SoC value beyond which the charging rate limit should be applied.\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    @NotNull
    private int soc;
    /**
     * Charging rate limit beyond the SoC value.
     * The unit is defined by _chargingSchedule.chargingRateUnit_.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("limit")
    @JsonPropertyDescription("Charging rate limit beyond the SoC value.\r\nThe unit is defined by _chargingSchedule.chargingRateUnit_.\r\n\r\n")
    @NotNull
    private double limit;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * The SoC value beyond which the charging rate limit should be applied.
     * 
     * (Required)
     * 
     */
    @JsonProperty("soc")
    public int getSoc() {
        return soc;
    }

    /**
     * The SoC value beyond which the charging rate limit should be applied.
     * 
     * (Required)
     * 
     */
    @JsonProperty("soc")
    public void setSoc(int soc) {
        this.soc = soc;
    }

    public LimitAtSoC withSoc(int soc) {
        this.soc = soc;
        return this;
    }

    /**
     * Charging rate limit beyond the SoC value.
     * The unit is defined by _chargingSchedule.chargingRateUnit_.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("limit")
    public double getLimit() {
        return limit;
    }

    /**
     * Charging rate limit beyond the SoC value.
     * The unit is defined by _chargingSchedule.chargingRateUnit_.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("limit")
    public void setLimit(double limit) {
        this.limit = limit;
    }

    public LimitAtSoC withLimit(double limit) {
        this.limit = limit;
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

    public LimitAtSoC withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LimitAtSoC.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("soc");
        sb.append('=');
        sb.append(this.soc);
        sb.append(',');
        sb.append("limit");
        sb.append('=');
        sb.append(this.limit);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.limit)^(Double.doubleToLongBits(this.limit)>>> 32))));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.soc);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LimitAtSoC) == false) {
            return false;
        }
        LimitAtSoC rhs = ((LimitAtSoC) other);
        return (((Double.doubleToLongBits(this.limit) == Double.doubleToLongBits(rhs.limit))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.soc == rhs.soc));
    }

}
