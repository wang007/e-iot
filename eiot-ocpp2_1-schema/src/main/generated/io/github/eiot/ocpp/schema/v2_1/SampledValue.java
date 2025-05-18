
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * Single sampled value in MeterValues. Each value can be accompanied by optional fields.
 * 
 * To save on mobile data usage, default values of all of the optional fields are such that. The value without any additional fields will be interpreted, as a register reading of active import energy in Wh (Watt-hour) units.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "value",
    "measurand",
    "context",
    "phase",
    "location",
    "signedMeterValue",
    "unitOfMeasure",
    "customData"
})
public class SampledValue {

    /**
     * Indicates the measured value.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    @JsonPropertyDescription("Indicates the measured value.\r\n\r\n")
    @NotNull
    private double value;
    /**
     * Type of measurement. Default = "Energy.Active.Import.Register"
     * 
     * 
     */
    @JsonProperty("measurand")
    @JsonPropertyDescription("Type of measurement. Default = \"Energy.Active.Import.Register\"\r\n")
    private MeasurandEnum measurand = MeasurandEnum.fromValue("Energy.Active.Import.Register");
    /**
     * Type of detail value: start, end or sample. Default = "Sample.Periodic"
     * 
     * 
     */
    @JsonProperty("context")
    @JsonPropertyDescription("Type of detail value: start, end or sample. Default = \"Sample.Periodic\"\r\n")
    private ReadingContextEnum context = ReadingContextEnum.fromValue("Sample.Periodic");
    /**
     * Indicates how the measured value is to be interpreted. For instance between L1 and neutral (L1-N) Please note that not all values of phase are applicable to all Measurands. When phase is absent, the measured value is interpreted as an overall value.
     * 
     * 
     */
    @JsonProperty("phase")
    @JsonPropertyDescription("Indicates how the measured value is to be interpreted. For instance between L1 and neutral (L1-N) Please note that not all values of phase are applicable to all Measurands. When phase is absent, the measured value is interpreted as an overall value.\r\n")
    private PhaseEnum phase;
    /**
     * Indicates where the measured value has been sampled. Default =  "Outlet"
     * 
     * 
     * 
     */
    @JsonProperty("location")
    @JsonPropertyDescription("Indicates where the measured value has been sampled. Default =  \"Outlet\"\r\n\r\n")
    private LocationEnum location = LocationEnum.fromValue("Outlet");
    /**
     * Represent a signed version of the meter value.
     * 
     * 
     */
    @JsonProperty("signedMeterValue")
    @JsonPropertyDescription("Represent a signed version of the meter value.\r\n")
    @Valid
    private SignedMeterValue signedMeterValue;
    /**
     * Represents a UnitOfMeasure with a multiplier
     * 
     * 
     */
    @JsonProperty("unitOfMeasure")
    @JsonPropertyDescription("Represents a UnitOfMeasure with a multiplier\r\n")
    @Valid
    private UnitOfMeasure unitOfMeasure;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Indicates the measured value.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    public double getValue() {
        return value;
    }

    /**
     * Indicates the measured value.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    public void setValue(double value) {
        this.value = value;
    }

    public SampledValue withValue(double value) {
        this.value = value;
        return this;
    }

    /**
     * Type of measurement. Default = "Energy.Active.Import.Register"
     * 
     * 
     */
    @JsonProperty("measurand")
    public MeasurandEnum getMeasurand() {
        return measurand;
    }

    /**
     * Type of measurement. Default = "Energy.Active.Import.Register"
     * 
     * 
     */
    @JsonProperty("measurand")
    public void setMeasurand(MeasurandEnum measurand) {
        this.measurand = measurand;
    }

    public SampledValue withMeasurand(MeasurandEnum measurand) {
        this.measurand = measurand;
        return this;
    }

    /**
     * Type of detail value: start, end or sample. Default = "Sample.Periodic"
     * 
     * 
     */
    @JsonProperty("context")
    public ReadingContextEnum getContext() {
        return context;
    }

    /**
     * Type of detail value: start, end or sample. Default = "Sample.Periodic"
     * 
     * 
     */
    @JsonProperty("context")
    public void setContext(ReadingContextEnum context) {
        this.context = context;
    }

    public SampledValue withContext(ReadingContextEnum context) {
        this.context = context;
        return this;
    }

    /**
     * Indicates how the measured value is to be interpreted. For instance between L1 and neutral (L1-N) Please note that not all values of phase are applicable to all Measurands. When phase is absent, the measured value is interpreted as an overall value.
     * 
     * 
     */
    @JsonProperty("phase")
    public PhaseEnum getPhase() {
        return phase;
    }

    /**
     * Indicates how the measured value is to be interpreted. For instance between L1 and neutral (L1-N) Please note that not all values of phase are applicable to all Measurands. When phase is absent, the measured value is interpreted as an overall value.
     * 
     * 
     */
    @JsonProperty("phase")
    public void setPhase(PhaseEnum phase) {
        this.phase = phase;
    }

    public SampledValue withPhase(PhaseEnum phase) {
        this.phase = phase;
        return this;
    }

    /**
     * Indicates where the measured value has been sampled. Default =  "Outlet"
     * 
     * 
     * 
     */
    @JsonProperty("location")
    public LocationEnum getLocation() {
        return location;
    }

    /**
     * Indicates where the measured value has been sampled. Default =  "Outlet"
     * 
     * 
     * 
     */
    @JsonProperty("location")
    public void setLocation(LocationEnum location) {
        this.location = location;
    }

    public SampledValue withLocation(LocationEnum location) {
        this.location = location;
        return this;
    }

    /**
     * Represent a signed version of the meter value.
     * 
     * 
     */
    @JsonProperty("signedMeterValue")
    public SignedMeterValue getSignedMeterValue() {
        return signedMeterValue;
    }

    /**
     * Represent a signed version of the meter value.
     * 
     * 
     */
    @JsonProperty("signedMeterValue")
    public void setSignedMeterValue(SignedMeterValue signedMeterValue) {
        this.signedMeterValue = signedMeterValue;
    }

    public SampledValue withSignedMeterValue(SignedMeterValue signedMeterValue) {
        this.signedMeterValue = signedMeterValue;
        return this;
    }

    /**
     * Represents a UnitOfMeasure with a multiplier
     * 
     * 
     */
    @JsonProperty("unitOfMeasure")
    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Represents a UnitOfMeasure with a multiplier
     * 
     * 
     */
    @JsonProperty("unitOfMeasure")
    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public SampledValue withUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
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

    public SampledValue withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SampledValue.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("value");
        sb.append('=');
        sb.append(this.value);
        sb.append(',');
        sb.append("measurand");
        sb.append('=');
        sb.append(((this.measurand == null)?"<null>":this.measurand));
        sb.append(',');
        sb.append("context");
        sb.append('=');
        sb.append(((this.context == null)?"<null>":this.context));
        sb.append(',');
        sb.append("phase");
        sb.append('=');
        sb.append(((this.phase == null)?"<null>":this.phase));
        sb.append(',');
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null)?"<null>":this.location));
        sb.append(',');
        sb.append("signedMeterValue");
        sb.append('=');
        sb.append(((this.signedMeterValue == null)?"<null>":this.signedMeterValue));
        sb.append(',');
        sb.append("unitOfMeasure");
        sb.append('=');
        sb.append(((this.unitOfMeasure == null)?"<null>":this.unitOfMeasure));
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
        result = ((result* 31)+((this.phase == null)? 0 :this.phase.hashCode()));
        result = ((result* 31)+((this.signedMeterValue == null)? 0 :this.signedMeterValue.hashCode()));
        result = ((result* 31)+((this.unitOfMeasure == null)? 0 :this.unitOfMeasure.hashCode()));
        result = ((result* 31)+((this.context == null)? 0 :this.context.hashCode()));
        result = ((result* 31)+((this.measurand == null)? 0 :this.measurand.hashCode()));
        result = ((result* 31)+((this.location == null)? 0 :this.location.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.value)^(Double.doubleToLongBits(this.value)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SampledValue) == false) {
            return false;
        }
        SampledValue rhs = ((SampledValue) other);
        return (((((((((this.phase == rhs.phase)||((this.phase!= null)&&this.phase.equals(rhs.phase)))&&((this.signedMeterValue == rhs.signedMeterValue)||((this.signedMeterValue!= null)&&this.signedMeterValue.equals(rhs.signedMeterValue))))&&((this.unitOfMeasure == rhs.unitOfMeasure)||((this.unitOfMeasure!= null)&&this.unitOfMeasure.equals(rhs.unitOfMeasure))))&&((this.context == rhs.context)||((this.context!= null)&&this.context.equals(rhs.context))))&&((this.measurand == rhs.measurand)||((this.measurand!= null)&&this.measurand.equals(rhs.measurand))))&&((this.location == rhs.location)||((this.location!= null)&&this.location.equals(rhs.location))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(Double.doubleToLongBits(this.value) == Double.doubleToLongBits(rhs.value)));
    }

}
