
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "evseId",
    "tariff",
    "customData"
})
public class SetDefaultTariffRequest {

    /**
     * EVSE that tariff applies to. When _evseId_ = 0, then tarriff applies to all EVSEs.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("EVSE that tariff applies to. When _evseId_ = 0, then tarriff applies to all EVSEs.\r\n\r\n")
    @DecimalMin("0")
    @NotNull
    private int evseId;
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
     * (Required)
     * 
     */
    @JsonProperty("tariff")
    @JsonPropertyDescription("A tariff is described by fields with prices for:\r\nenergy,\r\ncharging time,\r\nidle time,\r\nfixed fee,\r\nreservation time,\r\nreservation fixed fee. +\r\nEach of these fields may have (optional) conditions that specify when a price is applicable. +\r\nThe _description_ contains a human-readable explanation of the tariff to be shown to the user. +\r\nThe other fields are parameters that define the tariff. These are used by the charging station to calculate the price.\r\n")
    @Valid
    @NotNull
    private Tariff tariff;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * EVSE that tariff applies to. When _evseId_ = 0, then tarriff applies to all EVSEs.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * EVSE that tariff applies to. When _evseId_ = 0, then tarriff applies to all EVSEs.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public SetDefaultTariffRequest withEvseId(int evseId) {
        this.evseId = evseId;
        return this;
    }

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
     * (Required)
     * 
     */
    @JsonProperty("tariff")
    public Tariff getTariff() {
        return tariff;
    }

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
     * (Required)
     * 
     */
    @JsonProperty("tariff")
    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public SetDefaultTariffRequest withTariff(Tariff tariff) {
        this.tariff = tariff;
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

    public SetDefaultTariffRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SetDefaultTariffRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
        sb.append(',');
        sb.append("tariff");
        sb.append('=');
        sb.append(((this.tariff == null)?"<null>":this.tariff));
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
        result = ((result* 31)+((this.tariff == null)? 0 :this.tariff.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SetDefaultTariffRequest) == false) {
            return false;
        }
        SetDefaultTariffRequest rhs = ((SetDefaultTariffRequest) other);
        return (((this.evseId == rhs.evseId)&&((this.tariff == rhs.tariff)||((this.tariff!= null)&&this.tariff.equals(rhs.tariff))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))));
    }

}
