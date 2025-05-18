
package io.github.eiot.ocpp.schema.v1_6;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "startPeriod",
    "limit",
    "numberPhases"
})
public class ChargingSchedulePeriod__2 {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("startPeriod")
    @NotNull
    private int startPeriod;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("limit")
    @NotNull
    private double limit;
    @JsonProperty("numberPhases")
    private int numberPhases;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("startPeriod")
    public int getStartPeriod() {
        return startPeriod;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("startPeriod")
    public void setStartPeriod(int startPeriod) {
        this.startPeriod = startPeriod;
    }

    public ChargingSchedulePeriod__2 withStartPeriod(int startPeriod) {
        this.startPeriod = startPeriod;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("limit")
    public double getLimit() {
        return limit;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("limit")
    public void setLimit(double limit) {
        this.limit = limit;
    }

    public ChargingSchedulePeriod__2 withLimit(double limit) {
        this.limit = limit;
        return this;
    }

    @JsonProperty("numberPhases")
    public int getNumberPhases() {
        return numberPhases;
    }

    @JsonProperty("numberPhases")
    public void setNumberPhases(int numberPhases) {
        this.numberPhases = numberPhases;
    }

    public ChargingSchedulePeriod__2 withNumberPhases(int numberPhases) {
        this.numberPhases = numberPhases;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChargingSchedulePeriod__2 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        result = ((result* 31)+ this.numberPhases);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChargingSchedulePeriod__2) == false) {
            return false;
        }
        ChargingSchedulePeriod__2 rhs = ((ChargingSchedulePeriod__2) other);
        return (((Double.doubleToLongBits(this.limit) == Double.doubleToLongBits(rhs.limit))&&(this.startPeriod == rhs.startPeriod))&&(this.numberPhases == rhs.numberPhases));
    }

}
