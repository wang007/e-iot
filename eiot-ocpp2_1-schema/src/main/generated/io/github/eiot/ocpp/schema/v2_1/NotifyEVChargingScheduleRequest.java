
package io.github.eiot.ocpp.schema.v2_1;

import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "timeBase",
    "chargingSchedule",
    "evseId",
    "selectedChargingScheduleId",
    "powerToleranceAcceptance",
    "customData"
})
public class NotifyEVChargingScheduleRequest {

    /**
     * Periods contained in the charging profile are relative to this point in time.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeBase")
    @JsonPropertyDescription("Periods contained in the charging profile are relative to this point in time.\r\n")
    @NotNull
    private OffsetDateTime timeBase;
    /**
     * Charging schedule structure defines a list of charging periods, as used in: NotifyEVChargingScheduleRequest and ChargingProfileType. When used in a NotifyEVChargingScheduleRequest only _duration_ and _chargingSchedulePeriod_ are relevant and _chargingRateUnit_ must be 'W'. +
     * An ISO 15118-20 session may provide either an _absolutePriceSchedule_ or a _priceLevelSchedule_. An ISO 15118-2 session can only provide a_salesTariff_ element. The field _digestValue_ is used when price schedule or sales tariff are signed.
     * 
     * image::images/ChargingSchedule-Simple.png[]
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedule")
    @JsonPropertyDescription("Charging schedule structure defines a list of charging periods, as used in: NotifyEVChargingScheduleRequest and ChargingProfileType. When used in a NotifyEVChargingScheduleRequest only _duration_ and _chargingSchedulePeriod_ are relevant and _chargingRateUnit_ must be 'W'. +\r\nAn ISO 15118-20 session may provide either an _absolutePriceSchedule_ or a _priceLevelSchedule_. An ISO 15118-2 session can only provide a_salesTariff_ element. The field _digestValue_ is used when price schedule or sales tariff are signed.\r\n\r\nimage::images/ChargingSchedule-Simple.png[]\r\n\r\n\r\n")
    @Valid
    @NotNull
    private ChargingSchedule chargingSchedule;
    /**
     * The charging schedule contained in this notification applies to an EVSE. EvseId must be &gt; 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("The charging schedule contained in this notification applies to an EVSE. EvseId must be &gt; 0.\r\n")
    @DecimalMin("1")
    @NotNull
    private int evseId;
    /**
     * *(2.1)* Id  of the _chargingSchedule_ that EV selected from the provided ChargingProfile.
     * 
     * 
     */
    @JsonProperty("selectedChargingScheduleId")
    @JsonPropertyDescription("*(2.1)* Id  of the _chargingSchedule_ that EV selected from the provided ChargingProfile.\r\n")
    @DecimalMin("0")
    private int selectedChargingScheduleId;
    /**
     * *(2.1)* True when power tolerance is accepted by EV.
     * This value is taken from EVPowerProfile.PowerToleranceAcceptance in the ISO 15118-20 PowerDeliverReq message..
     * 
     * 
     */
    @JsonProperty("powerToleranceAcceptance")
    @JsonPropertyDescription("*(2.1)* True when power tolerance is accepted by EV.\r\nThis value is taken from EVPowerProfile.PowerToleranceAcceptance in the ISO 15118-20 PowerDeliverReq message..\r\n")
    private boolean powerToleranceAcceptance;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Periods contained in the charging profile are relative to this point in time.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeBase")
    public OffsetDateTime getTimeBase() {
        return timeBase;
    }

    /**
     * Periods contained in the charging profile are relative to this point in time.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeBase")
    public void setTimeBase(OffsetDateTime timeBase) {
        this.timeBase = timeBase;
    }

    public NotifyEVChargingScheduleRequest withTimeBase(OffsetDateTime timeBase) {
        this.timeBase = timeBase;
        return this;
    }

    /**
     * Charging schedule structure defines a list of charging periods, as used in: NotifyEVChargingScheduleRequest and ChargingProfileType. When used in a NotifyEVChargingScheduleRequest only _duration_ and _chargingSchedulePeriod_ are relevant and _chargingRateUnit_ must be 'W'. +
     * An ISO 15118-20 session may provide either an _absolutePriceSchedule_ or a _priceLevelSchedule_. An ISO 15118-2 session can only provide a_salesTariff_ element. The field _digestValue_ is used when price schedule or sales tariff are signed.
     * 
     * image::images/ChargingSchedule-Simple.png[]
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedule")
    public ChargingSchedule getChargingSchedule() {
        return chargingSchedule;
    }

    /**
     * Charging schedule structure defines a list of charging periods, as used in: NotifyEVChargingScheduleRequest and ChargingProfileType. When used in a NotifyEVChargingScheduleRequest only _duration_ and _chargingSchedulePeriod_ are relevant and _chargingRateUnit_ must be 'W'. +
     * An ISO 15118-20 session may provide either an _absolutePriceSchedule_ or a _priceLevelSchedule_. An ISO 15118-2 session can only provide a_salesTariff_ element. The field _digestValue_ is used when price schedule or sales tariff are signed.
     * 
     * image::images/ChargingSchedule-Simple.png[]
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedule")
    public void setChargingSchedule(ChargingSchedule chargingSchedule) {
        this.chargingSchedule = chargingSchedule;
    }

    public NotifyEVChargingScheduleRequest withChargingSchedule(ChargingSchedule chargingSchedule) {
        this.chargingSchedule = chargingSchedule;
        return this;
    }

    /**
     * The charging schedule contained in this notification applies to an EVSE. EvseId must be &gt; 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * The charging schedule contained in this notification applies to an EVSE. EvseId must be &gt; 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public NotifyEVChargingScheduleRequest withEvseId(int evseId) {
        this.evseId = evseId;
        return this;
    }

    /**
     * *(2.1)* Id  of the _chargingSchedule_ that EV selected from the provided ChargingProfile.
     * 
     * 
     */
    @JsonProperty("selectedChargingScheduleId")
    public int getSelectedChargingScheduleId() {
        return selectedChargingScheduleId;
    }

    /**
     * *(2.1)* Id  of the _chargingSchedule_ that EV selected from the provided ChargingProfile.
     * 
     * 
     */
    @JsonProperty("selectedChargingScheduleId")
    public void setSelectedChargingScheduleId(int selectedChargingScheduleId) {
        this.selectedChargingScheduleId = selectedChargingScheduleId;
    }

    public NotifyEVChargingScheduleRequest withSelectedChargingScheduleId(int selectedChargingScheduleId) {
        this.selectedChargingScheduleId = selectedChargingScheduleId;
        return this;
    }

    /**
     * *(2.1)* True when power tolerance is accepted by EV.
     * This value is taken from EVPowerProfile.PowerToleranceAcceptance in the ISO 15118-20 PowerDeliverReq message..
     * 
     * 
     */
    @JsonProperty("powerToleranceAcceptance")
    public boolean isPowerToleranceAcceptance() {
        return powerToleranceAcceptance;
    }

    /**
     * *(2.1)* True when power tolerance is accepted by EV.
     * This value is taken from EVPowerProfile.PowerToleranceAcceptance in the ISO 15118-20 PowerDeliverReq message..
     * 
     * 
     */
    @JsonProperty("powerToleranceAcceptance")
    public void setPowerToleranceAcceptance(boolean powerToleranceAcceptance) {
        this.powerToleranceAcceptance = powerToleranceAcceptance;
    }

    public NotifyEVChargingScheduleRequest withPowerToleranceAcceptance(boolean powerToleranceAcceptance) {
        this.powerToleranceAcceptance = powerToleranceAcceptance;
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

    public NotifyEVChargingScheduleRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NotifyEVChargingScheduleRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("timeBase");
        sb.append('=');
        sb.append(((this.timeBase == null)?"<null>":this.timeBase));
        sb.append(',');
        sb.append("chargingSchedule");
        sb.append('=');
        sb.append(((this.chargingSchedule == null)?"<null>":this.chargingSchedule));
        sb.append(',');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
        sb.append(',');
        sb.append("selectedChargingScheduleId");
        sb.append('=');
        sb.append(this.selectedChargingScheduleId);
        sb.append(',');
        sb.append("powerToleranceAcceptance");
        sb.append('=');
        sb.append(this.powerToleranceAcceptance);
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
        result = ((result* 31)+((this.chargingSchedule == null)? 0 :this.chargingSchedule.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.timeBase == null)? 0 :this.timeBase.hashCode()));
        result = ((result* 31)+ this.selectedChargingScheduleId);
        result = ((result* 31)+(this.powerToleranceAcceptance? 1 : 0));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NotifyEVChargingScheduleRequest) == false) {
            return false;
        }
        NotifyEVChargingScheduleRequest rhs = ((NotifyEVChargingScheduleRequest) other);
        return ((((((this.evseId == rhs.evseId)&&((this.chargingSchedule == rhs.chargingSchedule)||((this.chargingSchedule!= null)&&this.chargingSchedule.equals(rhs.chargingSchedule))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.timeBase == rhs.timeBase)||((this.timeBase!= null)&&this.timeBase.equals(rhs.timeBase))))&&(this.selectedChargingScheduleId == rhs.selectedChargingScheduleId))&&(this.powerToleranceAcceptance == rhs.powerToleranceAcceptance));
    }

}
