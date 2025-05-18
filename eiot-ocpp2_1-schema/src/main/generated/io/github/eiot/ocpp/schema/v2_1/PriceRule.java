
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;


/**
 * Part of ISO 15118-20 price schedule.
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "parkingFeePeriod",
    "carbonDioxideEmission",
    "renewableGenerationPercentage",
    "energyFee",
    "parkingFee",
    "powerRangeStart",
    "customData"
})
public class PriceRule {

    /**
     * The duration of the parking fee period (in seconds).
     * When the time enters into a ParkingFeePeriod, the ParkingFee will apply to the session. .
     * 
     * 
     */
    @JsonProperty("parkingFeePeriod")
    @JsonPropertyDescription("The duration of the parking fee period (in seconds).\r\nWhen the time enters into a ParkingFeePeriod, the ParkingFee will apply to the session. .\r\n")
    private int parkingFeePeriod;
    /**
     * Number of grams of CO2 per kWh.
     * 
     * 
     */
    @JsonProperty("carbonDioxideEmission")
    @JsonPropertyDescription("Number of grams of CO2 per kWh.\r\n")
    @DecimalMin("0")
    private int carbonDioxideEmission;
    /**
     * Percentage of the power that is created by renewable resources.
     * 
     * 
     */
    @JsonProperty("renewableGenerationPercentage")
    @JsonPropertyDescription("Percentage of the power that is created by renewable resources.\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private int renewableGenerationPercentage;
    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("energyFee")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    @NotNull
    private RationalNumber energyFee;
    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("parkingFee")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    private RationalNumber parkingFee;
    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("powerRangeStart")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    @NotNull
    private RationalNumber powerRangeStart;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * The duration of the parking fee period (in seconds).
     * When the time enters into a ParkingFeePeriod, the ParkingFee will apply to the session. .
     * 
     * 
     */
    @JsonProperty("parkingFeePeriod")
    public int getParkingFeePeriod() {
        return parkingFeePeriod;
    }

    /**
     * The duration of the parking fee period (in seconds).
     * When the time enters into a ParkingFeePeriod, the ParkingFee will apply to the session. .
     * 
     * 
     */
    @JsonProperty("parkingFeePeriod")
    public void setParkingFeePeriod(int parkingFeePeriod) {
        this.parkingFeePeriod = parkingFeePeriod;
    }

    public PriceRule withParkingFeePeriod(int parkingFeePeriod) {
        this.parkingFeePeriod = parkingFeePeriod;
        return this;
    }

    /**
     * Number of grams of CO2 per kWh.
     * 
     * 
     */
    @JsonProperty("carbonDioxideEmission")
    public int getCarbonDioxideEmission() {
        return carbonDioxideEmission;
    }

    /**
     * Number of grams of CO2 per kWh.
     * 
     * 
     */
    @JsonProperty("carbonDioxideEmission")
    public void setCarbonDioxideEmission(int carbonDioxideEmission) {
        this.carbonDioxideEmission = carbonDioxideEmission;
    }

    public PriceRule withCarbonDioxideEmission(int carbonDioxideEmission) {
        this.carbonDioxideEmission = carbonDioxideEmission;
        return this;
    }

    /**
     * Percentage of the power that is created by renewable resources.
     * 
     * 
     */
    @JsonProperty("renewableGenerationPercentage")
    public int getRenewableGenerationPercentage() {
        return renewableGenerationPercentage;
    }

    /**
     * Percentage of the power that is created by renewable resources.
     * 
     * 
     */
    @JsonProperty("renewableGenerationPercentage")
    public void setRenewableGenerationPercentage(int renewableGenerationPercentage) {
        this.renewableGenerationPercentage = renewableGenerationPercentage;
    }

    public PriceRule withRenewableGenerationPercentage(int renewableGenerationPercentage) {
        this.renewableGenerationPercentage = renewableGenerationPercentage;
        return this;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("energyFee")
    public RationalNumber getEnergyFee() {
        return energyFee;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("energyFee")
    public void setEnergyFee(RationalNumber energyFee) {
        this.energyFee = energyFee;
    }

    public PriceRule withEnergyFee(RationalNumber energyFee) {
        this.energyFee = energyFee;
        return this;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("parkingFee")
    public RationalNumber getParkingFee() {
        return parkingFee;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("parkingFee")
    public void setParkingFee(RationalNumber parkingFee) {
        this.parkingFee = parkingFee;
    }

    public PriceRule withParkingFee(RationalNumber parkingFee) {
        this.parkingFee = parkingFee;
        return this;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("powerRangeStart")
    public RationalNumber getPowerRangeStart() {
        return powerRangeStart;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("powerRangeStart")
    public void setPowerRangeStart(RationalNumber powerRangeStart) {
        this.powerRangeStart = powerRangeStart;
    }

    public PriceRule withPowerRangeStart(RationalNumber powerRangeStart) {
        this.powerRangeStart = powerRangeStart;
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

    public PriceRule withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PriceRule.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("parkingFeePeriod");
        sb.append('=');
        sb.append(this.parkingFeePeriod);
        sb.append(',');
        sb.append("carbonDioxideEmission");
        sb.append('=');
        sb.append(this.carbonDioxideEmission);
        sb.append(',');
        sb.append("renewableGenerationPercentage");
        sb.append('=');
        sb.append(this.renewableGenerationPercentage);
        sb.append(',');
        sb.append("energyFee");
        sb.append('=');
        sb.append(((this.energyFee == null)?"<null>":this.energyFee));
        sb.append(',');
        sb.append("parkingFee");
        sb.append('=');
        sb.append(((this.parkingFee == null)?"<null>":this.parkingFee));
        sb.append(',');
        sb.append("powerRangeStart");
        sb.append('=');
        sb.append(((this.powerRangeStart == null)?"<null>":this.powerRangeStart));
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
        result = ((result* 31)+ this.renewableGenerationPercentage);
        result = ((result* 31)+((this.parkingFee == null)? 0 :this.parkingFee.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.parkingFeePeriod);
        result = ((result* 31)+((this.energyFee == null)? 0 :this.energyFee.hashCode()));
        result = ((result* 31)+((this.powerRangeStart == null)? 0 :this.powerRangeStart.hashCode()));
        result = ((result* 31)+ this.carbonDioxideEmission);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PriceRule) == false) {
            return false;
        }
        PriceRule rhs = ((PriceRule) other);
        return (((((((this.renewableGenerationPercentage == rhs.renewableGenerationPercentage)&&((this.parkingFee == rhs.parkingFee)||((this.parkingFee!= null)&&this.parkingFee.equals(rhs.parkingFee))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.parkingFeePeriod == rhs.parkingFeePeriod))&&((this.energyFee == rhs.energyFee)||((this.energyFee!= null)&&this.energyFee.equals(rhs.energyFee))))&&((this.powerRangeStart == rhs.powerRangeStart)||((this.powerRangeStart!= null)&&this.powerRangeStart.equals(rhs.powerRangeStart))))&&(this.carbonDioxideEmission == rhs.carbonDioxideEmission));
    }

}
