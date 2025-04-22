
package io.github.eiot.ocpp.schema.v1_6;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "duration",
    "startSchedule",
    "chargingRateUnit",
    "chargingSchedulePeriod",
    "minChargingRate"
})
public class ChargingSchedule__1 {

    @JsonProperty("duration")
    private int duration;
    @JsonProperty("startSchedule")
    private ZonedDateTime startSchedule;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingRateUnit")
    @NotNull
    private ChargingSchedule__1 .ChargingRateUnit chargingRateUnit;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedulePeriod")
    @Valid
    @NotNull
    private List<ChargingSchedulePeriod__1> chargingSchedulePeriod = new ArrayList<ChargingSchedulePeriod__1>();
    @JsonProperty("minChargingRate")
    private double minChargingRate;

    @JsonProperty("duration")
    public int getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ChargingSchedule__1 withDuration(int duration) {
        this.duration = duration;
        return this;
    }

    @JsonProperty("startSchedule")
    public ZonedDateTime getStartSchedule() {
        return startSchedule;
    }

    @JsonProperty("startSchedule")
    public void setStartSchedule(ZonedDateTime startSchedule) {
        this.startSchedule = startSchedule;
    }

    public ChargingSchedule__1 withStartSchedule(ZonedDateTime startSchedule) {
        this.startSchedule = startSchedule;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingRateUnit")
    public ChargingSchedule__1 .ChargingRateUnit getChargingRateUnit() {
        return chargingRateUnit;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingRateUnit")
    public void setChargingRateUnit(ChargingSchedule__1 .ChargingRateUnit chargingRateUnit) {
        this.chargingRateUnit = chargingRateUnit;
    }

    public ChargingSchedule__1 withChargingRateUnit(ChargingSchedule__1 .ChargingRateUnit chargingRateUnit) {
        this.chargingRateUnit = chargingRateUnit;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedulePeriod")
    public List<ChargingSchedulePeriod__1> getChargingSchedulePeriod() {
        return chargingSchedulePeriod;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedulePeriod")
    public void setChargingSchedulePeriod(List<ChargingSchedulePeriod__1> chargingSchedulePeriod) {
        this.chargingSchedulePeriod = chargingSchedulePeriod;
    }

    public ChargingSchedule__1 withChargingSchedulePeriod(List<ChargingSchedulePeriod__1> chargingSchedulePeriod) {
        this.chargingSchedulePeriod = chargingSchedulePeriod;
        return this;
    }

    @JsonProperty("minChargingRate")
    public double getMinChargingRate() {
        return minChargingRate;
    }

    @JsonProperty("minChargingRate")
    public void setMinChargingRate(double minChargingRate) {
        this.minChargingRate = minChargingRate;
    }

    public ChargingSchedule__1 withMinChargingRate(double minChargingRate) {
        this.minChargingRate = minChargingRate;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChargingSchedule__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("duration");
        sb.append('=');
        sb.append(this.duration);
        sb.append(',');
        sb.append("startSchedule");
        sb.append('=');
        sb.append(((this.startSchedule == null)?"<null>":this.startSchedule));
        sb.append(',');
        sb.append("chargingRateUnit");
        sb.append('=');
        sb.append(((this.chargingRateUnit == null)?"<null>":this.chargingRateUnit));
        sb.append(',');
        sb.append("chargingSchedulePeriod");
        sb.append('=');
        sb.append(((this.chargingSchedulePeriod == null)?"<null>":this.chargingSchedulePeriod));
        sb.append(',');
        sb.append("minChargingRate");
        sb.append('=');
        sb.append(this.minChargingRate);
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
        result = ((result* 31)+ this.duration);
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minChargingRate)^(Double.doubleToLongBits(this.minChargingRate)>>> 32))));
        result = ((result* 31)+((this.startSchedule == null)? 0 :this.startSchedule.hashCode()));
        result = ((result* 31)+((this.chargingSchedulePeriod == null)? 0 :this.chargingSchedulePeriod.hashCode()));
        result = ((result* 31)+((this.chargingRateUnit == null)? 0 :this.chargingRateUnit.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChargingSchedule__1) == false) {
            return false;
        }
        ChargingSchedule__1 rhs = ((ChargingSchedule__1) other);
        return (((((this.duration == rhs.duration)&&(Double.doubleToLongBits(this.minChargingRate) == Double.doubleToLongBits(rhs.minChargingRate)))&&((this.startSchedule == rhs.startSchedule)||((this.startSchedule!= null)&&this.startSchedule.equals(rhs.startSchedule))))&&((this.chargingSchedulePeriod == rhs.chargingSchedulePeriod)||((this.chargingSchedulePeriod!= null)&&this.chargingSchedulePeriod.equals(rhs.chargingSchedulePeriod))))&&((this.chargingRateUnit == rhs.chargingRateUnit)||((this.chargingRateUnit!= null)&&this.chargingRateUnit.equals(rhs.chargingRateUnit))));
    }

    public enum ChargingRateUnit {

        A("A"),
        W("W");
        private final String value;
        private final static Map<String, ChargingSchedule__1 .ChargingRateUnit> CONSTANTS = new HashMap<String, ChargingSchedule__1 .ChargingRateUnit>();

        static {
            for (ChargingSchedule__1 .ChargingRateUnit c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        ChargingRateUnit(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static ChargingSchedule__1 .ChargingRateUnit fromValue(String value) {
            ChargingSchedule__1 .ChargingRateUnit constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
