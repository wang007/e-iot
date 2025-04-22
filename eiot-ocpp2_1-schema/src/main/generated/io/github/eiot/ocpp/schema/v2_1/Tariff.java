
package io.github.eiot.ocpp.schema.v2_1;

import java.time.ZonedDateTime;
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
 * A tariff is described by fields with prices for:
 * energy,
 * charging time,
 * idle time,
 * fixed fee,
 * reservation time,
 * reservation fixed fee. +
 * Each of these fields may have (optional) conditions that specify when a price is applicable. +
 * The _description_ contains a human-readable explanation of the tariff to be shown to the user. +
 * The other fields are parameters that define the tariff. These are used by the charging station to calculate the price.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tariffId",
    "description",
    "currency",
    "energy",
    "validFrom",
    "chargingTime",
    "idleTime",
    "fixedFee",
    "reservationTime",
    "reservationFixed",
    "minCost",
    "maxCost",
    "customData"
})
public class Tariff {

    /**
     * Unique id of tariff
     * 
     * (Required)
     * 
     */
    @JsonProperty("tariffId")
    @JsonPropertyDescription("Unique id of tariff\r\n")
    @Size(max = 60)
    @NotNull
    private String tariffId;
    @JsonProperty("description")
    @Size(min = 1, max = 10)
    @Valid
    private List<MessageContent> description = new ArrayList<MessageContent>();
    /**
     * Currency code according to ISO 4217
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    @JsonPropertyDescription("Currency code according to ISO 4217\r\n")
    @Size(max = 3)
    @NotNull
    private String currency;
    /**
     * Price elements and tax for energy
     * 
     * 
     */
    @JsonProperty("energy")
    @JsonPropertyDescription("Price elements and tax for energy\r\n")
    @Valid
    private TariffEnergy energy;
    /**
     * Time when this tariff becomes active. When absent, it is immediately active.
     * 
     * 
     */
    @JsonProperty("validFrom")
    @JsonPropertyDescription("Time when this tariff becomes active. When absent, it is immediately active.\r\n")
    private ZonedDateTime validFrom;
    /**
     * Price elements and tax for time
     * 
     * 
     * 
     */
    @JsonProperty("chargingTime")
    @JsonPropertyDescription("Price elements and tax for time\r\n\r\n")
    @Valid
    private TariffTime chargingTime;
    /**
     * Price elements and tax for time
     * 
     * 
     * 
     */
    @JsonProperty("idleTime")
    @JsonPropertyDescription("Price elements and tax for time\r\n\r\n")
    @Valid
    private TariffTime idleTime;
    @JsonProperty("fixedFee")
    @Valid
    private TariffFixed fixedFee;
    /**
     * Price elements and tax for time
     * 
     * 
     * 
     */
    @JsonProperty("reservationTime")
    @JsonPropertyDescription("Price elements and tax for time\r\n\r\n")
    @Valid
    private TariffTime reservationTime;
    @JsonProperty("reservationFixed")
    @Valid
    private TariffFixed reservationFixed;
    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("minCost")
    @JsonPropertyDescription("Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.\r\n")
    @Valid
    private Price minCost;
    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("maxCost")
    @JsonPropertyDescription("Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.\r\n")
    @Valid
    private Price maxCost;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Unique id of tariff
     * 
     * (Required)
     * 
     */
    @JsonProperty("tariffId")
    public String getTariffId() {
        return tariffId;
    }

    /**
     * Unique id of tariff
     * 
     * (Required)
     * 
     */
    @JsonProperty("tariffId")
    public void setTariffId(String tariffId) {
        this.tariffId = tariffId;
    }

    public Tariff withTariffId(String tariffId) {
        this.tariffId = tariffId;
        return this;
    }

    @JsonProperty("description")
    public List<MessageContent> getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(List<MessageContent> description) {
        this.description = description;
    }

    public Tariff withDescription(List<MessageContent> description) {
        this.description = description;
        return this;
    }

    /**
     * Currency code according to ISO 4217
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    /**
     * Currency code according to ISO 4217
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Tariff withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Price elements and tax for energy
     * 
     * 
     */
    @JsonProperty("energy")
    public TariffEnergy getEnergy() {
        return energy;
    }

    /**
     * Price elements and tax for energy
     * 
     * 
     */
    @JsonProperty("energy")
    public void setEnergy(TariffEnergy energy) {
        this.energy = energy;
    }

    public Tariff withEnergy(TariffEnergy energy) {
        this.energy = energy;
        return this;
    }

    /**
     * Time when this tariff becomes active. When absent, it is immediately active.
     * 
     * 
     */
    @JsonProperty("validFrom")
    public ZonedDateTime getValidFrom() {
        return validFrom;
    }

    /**
     * Time when this tariff becomes active. When absent, it is immediately active.
     * 
     * 
     */
    @JsonProperty("validFrom")
    public void setValidFrom(ZonedDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public Tariff withValidFrom(ZonedDateTime validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    /**
     * Price elements and tax for time
     * 
     * 
     * 
     */
    @JsonProperty("chargingTime")
    public TariffTime getChargingTime() {
        return chargingTime;
    }

    /**
     * Price elements and tax for time
     * 
     * 
     * 
     */
    @JsonProperty("chargingTime")
    public void setChargingTime(TariffTime chargingTime) {
        this.chargingTime = chargingTime;
    }

    public Tariff withChargingTime(TariffTime chargingTime) {
        this.chargingTime = chargingTime;
        return this;
    }

    /**
     * Price elements and tax for time
     * 
     * 
     * 
     */
    @JsonProperty("idleTime")
    public TariffTime getIdleTime() {
        return idleTime;
    }

    /**
     * Price elements and tax for time
     * 
     * 
     * 
     */
    @JsonProperty("idleTime")
    public void setIdleTime(TariffTime idleTime) {
        this.idleTime = idleTime;
    }

    public Tariff withIdleTime(TariffTime idleTime) {
        this.idleTime = idleTime;
        return this;
    }

    @JsonProperty("fixedFee")
    public TariffFixed getFixedFee() {
        return fixedFee;
    }

    @JsonProperty("fixedFee")
    public void setFixedFee(TariffFixed fixedFee) {
        this.fixedFee = fixedFee;
    }

    public Tariff withFixedFee(TariffFixed fixedFee) {
        this.fixedFee = fixedFee;
        return this;
    }

    /**
     * Price elements and tax for time
     * 
     * 
     * 
     */
    @JsonProperty("reservationTime")
    public TariffTime getReservationTime() {
        return reservationTime;
    }

    /**
     * Price elements and tax for time
     * 
     * 
     * 
     */
    @JsonProperty("reservationTime")
    public void setReservationTime(TariffTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public Tariff withReservationTime(TariffTime reservationTime) {
        this.reservationTime = reservationTime;
        return this;
    }

    @JsonProperty("reservationFixed")
    public TariffFixed getReservationFixed() {
        return reservationFixed;
    }

    @JsonProperty("reservationFixed")
    public void setReservationFixed(TariffFixed reservationFixed) {
        this.reservationFixed = reservationFixed;
    }

    public Tariff withReservationFixed(TariffFixed reservationFixed) {
        this.reservationFixed = reservationFixed;
        return this;
    }

    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("minCost")
    public Price getMinCost() {
        return minCost;
    }

    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("minCost")
    public void setMinCost(Price minCost) {
        this.minCost = minCost;
    }

    public Tariff withMinCost(Price minCost) {
        this.minCost = minCost;
        return this;
    }

    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("maxCost")
    public Price getMaxCost() {
        return maxCost;
    }

    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("maxCost")
    public void setMaxCost(Price maxCost) {
        this.maxCost = maxCost;
    }

    public Tariff withMaxCost(Price maxCost) {
        this.maxCost = maxCost;
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

    public Tariff withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Tariff.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("tariffId");
        sb.append('=');
        sb.append(((this.tariffId == null)?"<null>":this.tariffId));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("currency");
        sb.append('=');
        sb.append(((this.currency == null)?"<null>":this.currency));
        sb.append(',');
        sb.append("energy");
        sb.append('=');
        sb.append(((this.energy == null)?"<null>":this.energy));
        sb.append(',');
        sb.append("validFrom");
        sb.append('=');
        sb.append(((this.validFrom == null)?"<null>":this.validFrom));
        sb.append(',');
        sb.append("chargingTime");
        sb.append('=');
        sb.append(((this.chargingTime == null)?"<null>":this.chargingTime));
        sb.append(',');
        sb.append("idleTime");
        sb.append('=');
        sb.append(((this.idleTime == null)?"<null>":this.idleTime));
        sb.append(',');
        sb.append("fixedFee");
        sb.append('=');
        sb.append(((this.fixedFee == null)?"<null>":this.fixedFee));
        sb.append(',');
        sb.append("reservationTime");
        sb.append('=');
        sb.append(((this.reservationTime == null)?"<null>":this.reservationTime));
        sb.append(',');
        sb.append("reservationFixed");
        sb.append('=');
        sb.append(((this.reservationFixed == null)?"<null>":this.reservationFixed));
        sb.append(',');
        sb.append("minCost");
        sb.append('=');
        sb.append(((this.minCost == null)?"<null>":this.minCost));
        sb.append(',');
        sb.append("maxCost");
        sb.append('=');
        sb.append(((this.maxCost == null)?"<null>":this.maxCost));
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
        result = ((result* 31)+((this.chargingTime == null)? 0 :this.chargingTime.hashCode()));
        result = ((result* 31)+((this.reservationTime == null)? 0 :this.reservationTime.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.validFrom == null)? 0 :this.validFrom.hashCode()));
        result = ((result* 31)+((this.idleTime == null)? 0 :this.idleTime.hashCode()));
        result = ((result* 31)+((this.reservationFixed == null)? 0 :this.reservationFixed.hashCode()));
        result = ((result* 31)+((this.maxCost == null)? 0 :this.maxCost.hashCode()));
        result = ((result* 31)+((this.currency == null)? 0 :this.currency.hashCode()));
        result = ((result* 31)+((this.tariffId == null)? 0 :this.tariffId.hashCode()));
        result = ((result* 31)+((this.fixedFee == null)? 0 :this.fixedFee.hashCode()));
        result = ((result* 31)+((this.minCost == null)? 0 :this.minCost.hashCode()));
        result = ((result* 31)+((this.energy == null)? 0 :this.energy.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Tariff) == false) {
            return false;
        }
        Tariff rhs = ((Tariff) other);
        return ((((((((((((((this.chargingTime == rhs.chargingTime)||((this.chargingTime!= null)&&this.chargingTime.equals(rhs.chargingTime)))&&((this.reservationTime == rhs.reservationTime)||((this.reservationTime!= null)&&this.reservationTime.equals(rhs.reservationTime))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.validFrom == rhs.validFrom)||((this.validFrom!= null)&&this.validFrom.equals(rhs.validFrom))))&&((this.idleTime == rhs.idleTime)||((this.idleTime!= null)&&this.idleTime.equals(rhs.idleTime))))&&((this.reservationFixed == rhs.reservationFixed)||((this.reservationFixed!= null)&&this.reservationFixed.equals(rhs.reservationFixed))))&&((this.maxCost == rhs.maxCost)||((this.maxCost!= null)&&this.maxCost.equals(rhs.maxCost))))&&((this.currency == rhs.currency)||((this.currency!= null)&&this.currency.equals(rhs.currency))))&&((this.tariffId == rhs.tariffId)||((this.tariffId!= null)&&this.tariffId.equals(rhs.tariffId))))&&((this.fixedFee == rhs.fixedFee)||((this.fixedFee!= null)&&this.fixedFee.equals(rhs.fixedFee))))&&((this.minCost == rhs.minCost)||((this.minCost!= null)&&this.minCost.equals(rhs.minCost))))&&((this.energy == rhs.energy)||((this.energy!= null)&&this.energy.equals(rhs.energy))));
    }

}
