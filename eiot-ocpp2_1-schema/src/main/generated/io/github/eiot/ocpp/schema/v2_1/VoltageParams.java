
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hv10MinMeanValue",
    "hv10MinMeanTripDelay",
    "powerDuringCessation",
    "customData"
})
public class VoltageParams {

    /**
     * EN 50549-1 chapter 4.9.3.4
     *     Voltage threshold for the 10 min time window mean value monitoring.
     *     The 10 min mean is recalculated up to every 3 s. 
     *     If the present voltage is above this threshold for more than the time defined by _hv10MinMeanValue_, the EV must trip.
     *     This value is mandatory if _hv10MinMeanTripDelay_ is set.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hv10MinMeanValue")
    @JsonPropertyDescription("EN 50549-1 chapter 4.9.3.4\r\n    Voltage threshold for the 10 min time window mean value monitoring.\r\n    The 10 min mean is recalculated up to every 3 s. \r\n    If the present voltage is above this threshold for more than the time defined by _hv10MinMeanValue_, the EV must trip.\r\n    This value is mandatory if _hv10MinMeanTripDelay_ is set.\r\n\r\n\r\n")
    private double hv10MinMeanValue;
    /**
     * Time for which the voltage is allowed to stay above the 10 min mean value. 
     *     After this time, the EV must trip.
     *     This value is mandatory if OverVoltageMeanValue10min is set.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hv10MinMeanTripDelay")
    @JsonPropertyDescription("Time for which the voltage is allowed to stay above the 10 min mean value. \r\n    After this time, the EV must trip.\r\n    This value is mandatory if OverVoltageMeanValue10min is set.\r\n\r\n\r\n")
    private double hv10MinMeanTripDelay;
    /**
     * Parameter is only sent, if the EV has to feed-in power or reactive power during fault-ride through (FRT) as defined by HVMomCess curve and LVMomCess curve.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("powerDuringCessation")
    @JsonPropertyDescription("Parameter is only sent, if the EV has to feed-in power or reactive power during fault-ride through (FRT) as defined by HVMomCess curve and LVMomCess curve.\r\n\r\n\r\n")
    private PowerDuringCessationEnum powerDuringCessation;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * EN 50549-1 chapter 4.9.3.4
     *     Voltage threshold for the 10 min time window mean value monitoring.
     *     The 10 min mean is recalculated up to every 3 s. 
     *     If the present voltage is above this threshold for more than the time defined by _hv10MinMeanValue_, the EV must trip.
     *     This value is mandatory if _hv10MinMeanTripDelay_ is set.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hv10MinMeanValue")
    public double getHv10MinMeanValue() {
        return hv10MinMeanValue;
    }

    /**
     * EN 50549-1 chapter 4.9.3.4
     *     Voltage threshold for the 10 min time window mean value monitoring.
     *     The 10 min mean is recalculated up to every 3 s. 
     *     If the present voltage is above this threshold for more than the time defined by _hv10MinMeanValue_, the EV must trip.
     *     This value is mandatory if _hv10MinMeanTripDelay_ is set.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hv10MinMeanValue")
    public void setHv10MinMeanValue(double hv10MinMeanValue) {
        this.hv10MinMeanValue = hv10MinMeanValue;
    }

    public VoltageParams withHv10MinMeanValue(double hv10MinMeanValue) {
        this.hv10MinMeanValue = hv10MinMeanValue;
        return this;
    }

    /**
     * Time for which the voltage is allowed to stay above the 10 min mean value. 
     *     After this time, the EV must trip.
     *     This value is mandatory if OverVoltageMeanValue10min is set.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hv10MinMeanTripDelay")
    public double getHv10MinMeanTripDelay() {
        return hv10MinMeanTripDelay;
    }

    /**
     * Time for which the voltage is allowed to stay above the 10 min mean value. 
     *     After this time, the EV must trip.
     *     This value is mandatory if OverVoltageMeanValue10min is set.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hv10MinMeanTripDelay")
    public void setHv10MinMeanTripDelay(double hv10MinMeanTripDelay) {
        this.hv10MinMeanTripDelay = hv10MinMeanTripDelay;
    }

    public VoltageParams withHv10MinMeanTripDelay(double hv10MinMeanTripDelay) {
        this.hv10MinMeanTripDelay = hv10MinMeanTripDelay;
        return this;
    }

    /**
     * Parameter is only sent, if the EV has to feed-in power or reactive power during fault-ride through (FRT) as defined by HVMomCess curve and LVMomCess curve.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("powerDuringCessation")
    public PowerDuringCessationEnum getPowerDuringCessation() {
        return powerDuringCessation;
    }

    /**
     * Parameter is only sent, if the EV has to feed-in power or reactive power during fault-ride through (FRT) as defined by HVMomCess curve and LVMomCess curve.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("powerDuringCessation")
    public void setPowerDuringCessation(PowerDuringCessationEnum powerDuringCessation) {
        this.powerDuringCessation = powerDuringCessation;
    }

    public VoltageParams withPowerDuringCessation(PowerDuringCessationEnum powerDuringCessation) {
        this.powerDuringCessation = powerDuringCessation;
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

    public VoltageParams withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VoltageParams.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("hv10MinMeanValue");
        sb.append('=');
        sb.append(this.hv10MinMeanValue);
        sb.append(',');
        sb.append("hv10MinMeanTripDelay");
        sb.append('=');
        sb.append(this.hv10MinMeanTripDelay);
        sb.append(',');
        sb.append("powerDuringCessation");
        sb.append('=');
        sb.append(((this.powerDuringCessation == null)?"<null>":this.powerDuringCessation));
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.hv10MinMeanValue)^(Double.doubleToLongBits(this.hv10MinMeanValue)>>> 32))));
        result = ((result* 31)+((this.powerDuringCessation == null)? 0 :this.powerDuringCessation.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.hv10MinMeanTripDelay)^(Double.doubleToLongBits(this.hv10MinMeanTripDelay)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VoltageParams) == false) {
            return false;
        }
        VoltageParams rhs = ((VoltageParams) other);
        return (((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&(Double.doubleToLongBits(this.hv10MinMeanValue) == Double.doubleToLongBits(rhs.hv10MinMeanValue)))&&((this.powerDuringCessation == rhs.powerDuringCessation)||((this.powerDuringCessation!= null)&&this.powerDuringCessation.equals(rhs.powerDuringCessation))))&&(Double.doubleToLongBits(this.hv10MinMeanTripDelay) == Double.doubleToLongBits(rhs.hv10MinMeanTripDelay)));
    }

}
