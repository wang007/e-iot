
package io.github.eiot.ocpp.schema.v2_0_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * Charging_ Schedule_ Period
 * urn:x-oca:ocpp:uid:2:233257
 * Charging schedule period structure defines a time period in a charging schedule.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customData",
    "startPeriod",
    "limit",
    "numberPhases",
    "phaseToUse"
})
public class ChargingSchedulePeriod {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Charging_ Schedule_ Period. Start_ Period. Elapsed_ Time
     * urn:x-oca:ocpp:uid:1:569240
     * Start of the period, in seconds from the start of schedule. The value of StartPeriod also defines the stop time of the previous period.
     * 
     * (Required)
     * 
     */
    @JsonProperty("startPeriod")
    @JsonPropertyDescription("Charging_ Schedule_ Period. Start_ Period. Elapsed_ Time\r\nurn:x-oca:ocpp:uid:1:569240\r\nStart of the period, in seconds from the start of schedule. The value of StartPeriod also defines the stop time of the previous period.\r\n")
    @NotNull
    private int startPeriod;
    /**
     * Charging_ Schedule_ Period. Limit. Measure
     * urn:x-oca:ocpp:uid:1:569241
     * Charging rate limit during the schedule period, in the applicable chargingRateUnit, for example in Amperes (A) or Watts (W). Accepts at most one digit fraction (e.g. 8.1).
     * 
     * (Required)
     * 
     */
    @JsonProperty("limit")
    @JsonPropertyDescription("Charging_ Schedule_ Period. Limit. Measure\r\nurn:x-oca:ocpp:uid:1:569241\r\nCharging rate limit during the schedule period, in the applicable chargingRateUnit, for example in Amperes (A) or Watts (W). Accepts at most one digit fraction (e.g. 8.1).\r\n")
    @NotNull
    private double limit;
    /**
     * Charging_ Schedule_ Period. Number_ Phases. Counter
     * urn:x-oca:ocpp:uid:1:569242
     * The number of phases that can be used for charging. If a number of phases is needed, numberPhases=3 will be assumed unless another number is given.
     * 
     * 
     */
    @JsonProperty("numberPhases")
    @JsonPropertyDescription("Charging_ Schedule_ Period. Number_ Phases. Counter\r\nurn:x-oca:ocpp:uid:1:569242\r\nThe number of phases that can be used for charging. If a number of phases is needed, numberPhases=3 will be assumed unless another number is given.\r\n")
    private int numberPhases;
    /**
     * Values: 1..3, Used if numberPhases=1 and if the EVSE is capable of switching the phase connected to the EV, i.e. ACPhaseSwitchingSupported is defined and true. It’s not allowed unless both conditions above are true. If both conditions are true, and phaseToUse is omitted, the Charging Station / EVSE will make the selection on its own.
     * 
     * 
     * 
     */
    @JsonProperty("phaseToUse")
    @JsonPropertyDescription("Values: 1..3, Used if numberPhases=1 and if the EVSE is capable of switching the phase connected to the EV, i.e. ACPhaseSwitchingSupported is defined and true. It\u2019s not allowed unless both conditions above are true. If both conditions are true, and phaseToUse is omitted, the Charging Station / EVSE will make the selection on its own.\r\n\r\n")
    private int phaseToUse;

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

    public ChargingSchedulePeriod withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    /**
     * Charging_ Schedule_ Period. Start_ Period. Elapsed_ Time
     * urn:x-oca:ocpp:uid:1:569240
     * Start of the period, in seconds from the start of schedule. The value of StartPeriod also defines the stop time of the previous period.
     * 
     * (Required)
     * 
     */
    @JsonProperty("startPeriod")
    public int getStartPeriod() {
        return startPeriod;
    }

    /**
     * Charging_ Schedule_ Period. Start_ Period. Elapsed_ Time
     * urn:x-oca:ocpp:uid:1:569240
     * Start of the period, in seconds from the start of schedule. The value of StartPeriod also defines the stop time of the previous period.
     * 
     * (Required)
     * 
     */
    @JsonProperty("startPeriod")
    public void setStartPeriod(int startPeriod) {
        this.startPeriod = startPeriod;
    }

    public ChargingSchedulePeriod withStartPeriod(int startPeriod) {
        this.startPeriod = startPeriod;
        return this;
    }

    /**
     * Charging_ Schedule_ Period. Limit. Measure
     * urn:x-oca:ocpp:uid:1:569241
     * Charging rate limit during the schedule period, in the applicable chargingRateUnit, for example in Amperes (A) or Watts (W). Accepts at most one digit fraction (e.g. 8.1).
     * 
     * (Required)
     * 
     */
    @JsonProperty("limit")
    public double getLimit() {
        return limit;
    }

    /**
     * Charging_ Schedule_ Period. Limit. Measure
     * urn:x-oca:ocpp:uid:1:569241
     * Charging rate limit during the schedule period, in the applicable chargingRateUnit, for example in Amperes (A) or Watts (W). Accepts at most one digit fraction (e.g. 8.1).
     * 
     * (Required)
     * 
     */
    @JsonProperty("limit")
    public void setLimit(double limit) {
        this.limit = limit;
    }

    public ChargingSchedulePeriod withLimit(double limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Charging_ Schedule_ Period. Number_ Phases. Counter
     * urn:x-oca:ocpp:uid:1:569242
     * The number of phases that can be used for charging. If a number of phases is needed, numberPhases=3 will be assumed unless another number is given.
     * 
     * 
     */
    @JsonProperty("numberPhases")
    public int getNumberPhases() {
        return numberPhases;
    }

    /**
     * Charging_ Schedule_ Period. Number_ Phases. Counter
     * urn:x-oca:ocpp:uid:1:569242
     * The number of phases that can be used for charging. If a number of phases is needed, numberPhases=3 will be assumed unless another number is given.
     * 
     * 
     */
    @JsonProperty("numberPhases")
    public void setNumberPhases(int numberPhases) {
        this.numberPhases = numberPhases;
    }

    public ChargingSchedulePeriod withNumberPhases(int numberPhases) {
        this.numberPhases = numberPhases;
        return this;
    }

    /**
     * Values: 1..3, Used if numberPhases=1 and if the EVSE is capable of switching the phase connected to the EV, i.e. ACPhaseSwitchingSupported is defined and true. It’s not allowed unless both conditions above are true. If both conditions are true, and phaseToUse is omitted, the Charging Station / EVSE will make the selection on its own.
     * 
     * 
     * 
     */
    @JsonProperty("phaseToUse")
    public int getPhaseToUse() {
        return phaseToUse;
    }

    /**
     * Values: 1..3, Used if numberPhases=1 and if the EVSE is capable of switching the phase connected to the EV, i.e. ACPhaseSwitchingSupported is defined and true. It’s not allowed unless both conditions above are true. If both conditions are true, and phaseToUse is omitted, the Charging Station / EVSE will make the selection on its own.
     * 
     * 
     * 
     */
    @JsonProperty("phaseToUse")
    public void setPhaseToUse(int phaseToUse) {
        this.phaseToUse = phaseToUse;
    }

    public ChargingSchedulePeriod withPhaseToUse(int phaseToUse) {
        this.phaseToUse = phaseToUse;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChargingSchedulePeriod.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("customData");
        sb.append('=');
        sb.append(((this.customData == null)?"<null>":this.customData));
        sb.append(',');
        sb.append("startPeriod");
        sb.append('=');
        sb.append(this.startPeriod);
        sb.append(',');
        sb.append("limit");
        sb.append('=');
        sb.append(this.limit);
        sb.append(',');
        sb.append("numberPhases");
        sb.append('=');
        sb.append(this.numberPhases);
        sb.append(',');
        sb.append("phaseToUse");
        sb.append('=');
        sb.append(this.phaseToUse);
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
        result = ((result* 31)+ this.startPeriod);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.numberPhases);
        result = ((result* 31)+ this.phaseToUse);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChargingSchedulePeriod) == false) {
            return false;
        }
        ChargingSchedulePeriod rhs = ((ChargingSchedulePeriod) other);
        return (((((Double.doubleToLongBits(this.limit) == Double.doubleToLongBits(rhs.limit))&&(this.startPeriod == rhs.startPeriod))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.numberPhases == rhs.numberPhases))&&(this.phaseToUse == rhs.phaseToUse));
    }

}
