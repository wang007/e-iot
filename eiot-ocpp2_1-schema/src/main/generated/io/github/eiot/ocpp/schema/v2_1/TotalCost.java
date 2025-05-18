
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * This contains the cost calculated during a transaction. It is used both for running cost and final cost of the transaction.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currency",
    "typeOfCost",
    "fixed",
    "energy",
    "chargingTime",
    "idleTime",
    "reservationTime",
    "reservationFixed",
    "total",
    "customData"
})
public class TotalCost {

    /**
     * Currency of the costs in ISO 4217 Code.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    @JsonPropertyDescription("Currency of the costs in ISO 4217 Code.\r\n\r\n")
    @Size(max = 3)
    @NotNull
    private String currency;
    /**
     * Type of cost: normal or the minimum or maximum cost.
     * 
     * (Required)
     * 
     */
    @JsonProperty("typeOfCost")
    @JsonPropertyDescription("Type of cost: normal or the minimum or maximum cost.\r\n")
    @NotNull
    private TariffCostEnum typeOfCost;
    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("fixed")
    @JsonPropertyDescription("Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.\r\n")
    @Valid
    private Price fixed;
    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("energy")
    @JsonPropertyDescription("Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.\r\n")
    @Valid
    private Price energy;
    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("chargingTime")
    @JsonPropertyDescription("Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.\r\n")
    @Valid
    private Price chargingTime;
    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("idleTime")
    @JsonPropertyDescription("Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.\r\n")
    @Valid
    private Price idleTime;
    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("reservationTime")
    @JsonPropertyDescription("Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.\r\n")
    @Valid
    private Price reservationTime;
    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("reservationFixed")
    @JsonPropertyDescription("Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.\r\n")
    @Valid
    private Price reservationFixed;
    /**
     * Total cost with and without tax. Contains the total of energy, charging time, idle time, fixed and reservation costs including and/or excluding tax.
     * 
     * (Required)
     * 
     */
    @JsonProperty("total")
    @JsonPropertyDescription("Total cost with and without tax. Contains the total of energy, charging time, idle time, fixed and reservation costs including and/or excluding tax.\r\n")
    @Valid
    @NotNull
    private TotalPrice total;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Currency of the costs in ISO 4217 Code.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    /**
     * Currency of the costs in ISO 4217 Code.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public TotalCost withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Type of cost: normal or the minimum or maximum cost.
     * 
     * (Required)
     * 
     */
    @JsonProperty("typeOfCost")
    public TariffCostEnum getTypeOfCost() {
        return typeOfCost;
    }

    /**
     * Type of cost: normal or the minimum or maximum cost.
     * 
     * (Required)
     * 
     */
    @JsonProperty("typeOfCost")
    public void setTypeOfCost(TariffCostEnum typeOfCost) {
        this.typeOfCost = typeOfCost;
    }

    public TotalCost withTypeOfCost(TariffCostEnum typeOfCost) {
        this.typeOfCost = typeOfCost;
        return this;
    }

    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("fixed")
    public Price getFixed() {
        return fixed;
    }

    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("fixed")
    public void setFixed(Price fixed) {
        this.fixed = fixed;
    }

    public TotalCost withFixed(Price fixed) {
        this.fixed = fixed;
        return this;
    }

    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("energy")
    public Price getEnergy() {
        return energy;
    }

    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("energy")
    public void setEnergy(Price energy) {
        this.energy = energy;
    }

    public TotalCost withEnergy(Price energy) {
        this.energy = energy;
        return this;
    }

    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("chargingTime")
    public Price getChargingTime() {
        return chargingTime;
    }

    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("chargingTime")
    public void setChargingTime(Price chargingTime) {
        this.chargingTime = chargingTime;
    }

    public TotalCost withChargingTime(Price chargingTime) {
        this.chargingTime = chargingTime;
        return this;
    }

    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("idleTime")
    public Price getIdleTime() {
        return idleTime;
    }

    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("idleTime")
    public void setIdleTime(Price idleTime) {
        this.idleTime = idleTime;
    }

    public TotalCost withIdleTime(Price idleTime) {
        this.idleTime = idleTime;
        return this;
    }

    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("reservationTime")
    public Price getReservationTime() {
        return reservationTime;
    }

    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("reservationTime")
    public void setReservationTime(Price reservationTime) {
        this.reservationTime = reservationTime;
    }

    public TotalCost withReservationTime(Price reservationTime) {
        this.reservationTime = reservationTime;
        return this;
    }

    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("reservationFixed")
    public Price getReservationFixed() {
        return reservationFixed;
    }

    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("reservationFixed")
    public void setReservationFixed(Price reservationFixed) {
        this.reservationFixed = reservationFixed;
    }

    public TotalCost withReservationFixed(Price reservationFixed) {
        this.reservationFixed = reservationFixed;
        return this;
    }

    /**
     * Total cost with and without tax. Contains the total of energy, charging time, idle time, fixed and reservation costs including and/or excluding tax.
     * 
     * (Required)
     * 
     */
    @JsonProperty("total")
    public TotalPrice getTotal() {
        return total;
    }

    /**
     * Total cost with and without tax. Contains the total of energy, charging time, idle time, fixed and reservation costs including and/or excluding tax.
     * 
     * (Required)
     * 
     */
    @JsonProperty("total")
    public void setTotal(TotalPrice total) {
        this.total = total;
    }

    public TotalCost withTotal(TotalPrice total) {
        this.total = total;
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

    public TotalCost withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TotalCost.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("currency");
        sb.append('=');
        sb.append(((this.currency == null)?"<null>":this.currency));
        sb.append(',');
        sb.append("typeOfCost");
        sb.append('=');
        sb.append(((this.typeOfCost == null)?"<null>":this.typeOfCost));
        sb.append(',');
        sb.append("fixed");
        sb.append('=');
        sb.append(((this.fixed == null)?"<null>":this.fixed));
        sb.append(',');
        sb.append("energy");
        sb.append('=');
        sb.append(((this.energy == null)?"<null>":this.energy));
        sb.append(',');
        sb.append("chargingTime");
        sb.append('=');
        sb.append(((this.chargingTime == null)?"<null>":this.chargingTime));
        sb.append(',');
        sb.append("idleTime");
        sb.append('=');
        sb.append(((this.idleTime == null)?"<null>":this.idleTime));
        sb.append(',');
        sb.append("reservationTime");
        sb.append('=');
        sb.append(((this.reservationTime == null)?"<null>":this.reservationTime));
        sb.append(',');
        sb.append("reservationFixed");
        sb.append('=');
        sb.append(((this.reservationFixed == null)?"<null>":this.reservationFixed));
        sb.append(',');
        sb.append("total");
        sb.append('=');
        sb.append(((this.total == null)?"<null>":this.total));
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
        result = ((result* 31)+((this.total == null)? 0 :this.total.hashCode()));
        result = ((result* 31)+((this.chargingTime == null)? 0 :this.chargingTime.hashCode()));
        result = ((result* 31)+((this.reservationTime == null)? 0 :this.reservationTime.hashCode()));
        result = ((result* 31)+((this.currency == null)? 0 :this.currency.hashCode()));
        result = ((result* 31)+((this.fixed == null)? 0 :this.fixed.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.typeOfCost == null)? 0 :this.typeOfCost.hashCode()));
        result = ((result* 31)+((this.idleTime == null)? 0 :this.idleTime.hashCode()));
        result = ((result* 31)+((this.reservationFixed == null)? 0 :this.reservationFixed.hashCode()));
        result = ((result* 31)+((this.energy == null)? 0 :this.energy.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TotalCost) == false) {
            return false;
        }
        TotalCost rhs = ((TotalCost) other);
        return (((((((((((this.total == rhs.total)||((this.total!= null)&&this.total.equals(rhs.total)))&&((this.chargingTime == rhs.chargingTime)||((this.chargingTime!= null)&&this.chargingTime.equals(rhs.chargingTime))))&&((this.reservationTime == rhs.reservationTime)||((this.reservationTime!= null)&&this.reservationTime.equals(rhs.reservationTime))))&&((this.currency == rhs.currency)||((this.currency!= null)&&this.currency.equals(rhs.currency))))&&((this.fixed == rhs.fixed)||((this.fixed!= null)&&this.fixed.equals(rhs.fixed))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.typeOfCost == rhs.typeOfCost)||((this.typeOfCost!= null)&&this.typeOfCost.equals(rhs.typeOfCost))))&&((this.idleTime == rhs.idleTime)||((this.idleTime!= null)&&this.idleTime.equals(rhs.idleTime))))&&((this.reservationFixed == rhs.reservationFixed)||((this.reservationFixed!= null)&&this.reservationFixed.equals(rhs.reservationFixed))))&&((this.energy == rhs.energy)||((this.energy!= null)&&this.energy.equals(rhs.energy))));
    }

}
