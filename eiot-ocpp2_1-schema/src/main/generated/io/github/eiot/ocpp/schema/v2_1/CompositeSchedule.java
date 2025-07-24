
package io.github.eiot.ocpp.schema.v2_1;

import java.time.OffsetDateTime;
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "evseId",
    "duration",
    "scheduleStart",
    "chargingRateUnit",
    "chargingSchedulePeriod",
    "customData"
})
public class CompositeSchedule {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @DecimalMin("0")
    @NotNull
    private int evseId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    @NotNull
    private int duration;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("scheduleStart")
    @NotNull
    private OffsetDateTime scheduleStart;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingRateUnit")
    @NotNull
    private ChargingRateUnitEnum chargingRateUnit;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedulePeriod")
    @Size(min = 1)
    @Valid
    @NotNull
    private List<ChargingSchedulePeriod> chargingSchedulePeriod = new ArrayList<ChargingSchedulePeriod>();
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
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public CompositeSchedule withEvseId(int evseId) {
        this.evseId = evseId;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    public int getDuration() {
        return duration;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public CompositeSchedule withDuration(int duration) {
        this.duration = duration;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("scheduleStart")
    public OffsetDateTime getScheduleStart() {
        return scheduleStart;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("scheduleStart")
    public void setScheduleStart(OffsetDateTime scheduleStart) {
        this.scheduleStart = scheduleStart;
    }

    public CompositeSchedule withScheduleStart(OffsetDateTime scheduleStart) {
        this.scheduleStart = scheduleStart;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingRateUnit")
    public ChargingRateUnitEnum getChargingRateUnit() {
        return chargingRateUnit;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingRateUnit")
    public void setChargingRateUnit(ChargingRateUnitEnum chargingRateUnit) {
        this.chargingRateUnit = chargingRateUnit;
    }

    public CompositeSchedule withChargingRateUnit(ChargingRateUnitEnum chargingRateUnit) {
        this.chargingRateUnit = chargingRateUnit;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedulePeriod")
    public List<ChargingSchedulePeriod> getChargingSchedulePeriod() {
        return chargingSchedulePeriod;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedulePeriod")
    public void setChargingSchedulePeriod(List<ChargingSchedulePeriod> chargingSchedulePeriod) {
        this.chargingSchedulePeriod = chargingSchedulePeriod;
    }

    public CompositeSchedule withChargingSchedulePeriod(List<ChargingSchedulePeriod> chargingSchedulePeriod) {
        this.chargingSchedulePeriod = chargingSchedulePeriod;
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

    public CompositeSchedule withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CompositeSchedule.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
        sb.append(',');
        sb.append("duration");
        sb.append('=');
        sb.append(this.duration);
        sb.append(',');
        sb.append("scheduleStart");
        sb.append('=');
        sb.append(((this.scheduleStart == null)?"<null>":this.scheduleStart));
        sb.append(',');
        sb.append("chargingRateUnit");
        sb.append('=');
        sb.append(((this.chargingRateUnit == null)?"<null>":this.chargingRateUnit));
        sb.append(',');
        sb.append("chargingSchedulePeriod");
        sb.append('=');
        sb.append(((this.chargingSchedulePeriod == null)?"<null>":this.chargingSchedulePeriod));
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
        result = ((result* 31)+ this.evseId);
        result = ((result* 31)+ this.duration);
        result = ((result* 31)+((this.scheduleStart == null)? 0 :this.scheduleStart.hashCode()));
        result = ((result* 31)+((this.chargingSchedulePeriod == null)? 0 :this.chargingSchedulePeriod.hashCode()));
        result = ((result* 31)+((this.chargingRateUnit == null)? 0 :this.chargingRateUnit.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CompositeSchedule) == false) {
            return false;
        }
        CompositeSchedule rhs = ((CompositeSchedule) other);
        return ((((((this.evseId == rhs.evseId)&&(this.duration == rhs.duration))&&((this.scheduleStart == rhs.scheduleStart)||((this.scheduleStart!= null)&&this.scheduleStart.equals(rhs.scheduleStart))))&&((this.chargingSchedulePeriod == rhs.chargingSchedulePeriod)||((this.chargingSchedulePeriod!= null)&&this.chargingSchedulePeriod.equals(rhs.chargingSchedulePeriod))))&&((this.chargingRateUnit == rhs.chargingRateUnit)||((this.chargingRateUnit!= null)&&this.chargingRateUnit.equals(rhs.chargingRateUnit))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))));
    }

}
