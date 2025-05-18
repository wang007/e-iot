
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * This contains the calculated usage of energy, charging time and idle time during a transaction.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "energy",
    "chargingTime",
    "idleTime",
    "reservationTime",
    "customData"
})
public class TotalUsage {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("energy")
    @NotNull
    private double energy;
    /**
     * Total duration of the charging session (including the duration of charging and not charging), in seconds.
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingTime")
    @JsonPropertyDescription("Total duration of the charging session (including the duration of charging and not charging), in seconds.\r\n\r\n\r\n")
    @NotNull
    private int chargingTime;
    /**
     * Total duration of the charging session where the EV was not charging (no energy was transferred between EVSE and EV), in seconds.
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("idleTime")
    @JsonPropertyDescription("Total duration of the charging session where the EV was not charging (no energy was transferred between EVSE and EV), in seconds.\r\n\r\n\r\n")
    @NotNull
    private int idleTime;
    /**
     * Total time of reservation in seconds.
     * 
     * 
     */
    @JsonProperty("reservationTime")
    @JsonPropertyDescription("Total time of reservation in seconds.\r\n")
    private int reservationTime;
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
    @JsonProperty("energy")
    public double getEnergy() {
        return energy;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("energy")
    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public TotalUsage withEnergy(double energy) {
        this.energy = energy;
        return this;
    }

    /**
     * Total duration of the charging session (including the duration of charging and not charging), in seconds.
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingTime")
    public int getChargingTime() {
        return chargingTime;
    }

    /**
     * Total duration of the charging session (including the duration of charging and not charging), in seconds.
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingTime")
    public void setChargingTime(int chargingTime) {
        this.chargingTime = chargingTime;
    }

    public TotalUsage withChargingTime(int chargingTime) {
        this.chargingTime = chargingTime;
        return this;
    }

    /**
     * Total duration of the charging session where the EV was not charging (no energy was transferred between EVSE and EV), in seconds.
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("idleTime")
    public int getIdleTime() {
        return idleTime;
    }

    /**
     * Total duration of the charging session where the EV was not charging (no energy was transferred between EVSE and EV), in seconds.
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("idleTime")
    public void setIdleTime(int idleTime) {
        this.idleTime = idleTime;
    }

    public TotalUsage withIdleTime(int idleTime) {
        this.idleTime = idleTime;
        return this;
    }

    /**
     * Total time of reservation in seconds.
     * 
     * 
     */
    @JsonProperty("reservationTime")
    public int getReservationTime() {
        return reservationTime;
    }

    /**
     * Total time of reservation in seconds.
     * 
     * 
     */
    @JsonProperty("reservationTime")
    public void setReservationTime(int reservationTime) {
        this.reservationTime = reservationTime;
    }

    public TotalUsage withReservationTime(int reservationTime) {
        this.reservationTime = reservationTime;
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

    public TotalUsage withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TotalUsage.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("energy");
        sb.append('=');
        sb.append(this.energy);
        sb.append(',');
        sb.append("chargingTime");
        sb.append('=');
        sb.append(this.chargingTime);
        sb.append(',');
        sb.append("idleTime");
        sb.append('=');
        sb.append(this.idleTime);
        sb.append(',');
        sb.append("reservationTime");
        sb.append('=');
        sb.append(this.reservationTime);
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
        result = ((result* 31)+ this.idleTime);
        result = ((result* 31)+ this.chargingTime);
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.energy)^(Double.doubleToLongBits(this.energy)>>> 32))));
        result = ((result* 31)+ this.reservationTime);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TotalUsage) == false) {
            return false;
        }
        TotalUsage rhs = ((TotalUsage) other);
        return ((((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&(this.idleTime == rhs.idleTime))&&(this.chargingTime == rhs.chargingTime))&&(Double.doubleToLongBits(this.energy) == Double.doubleToLongBits(rhs.energy)))&&(this.reservationTime == rhs.reservationTime));
    }

}
