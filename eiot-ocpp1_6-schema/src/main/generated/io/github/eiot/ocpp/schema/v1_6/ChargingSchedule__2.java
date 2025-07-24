
package io.github.eiot.ocpp.schema.v1_6;

import java.time.OffsetDateTime;
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
public class ChargingSchedule__2 {

    @JsonProperty("duration")
    private int duration;
    @JsonProperty("startSchedule")
    private OffsetDateTime startSchedule;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingRateUnit")
    @NotNull
    private ChargingSchedule__2 .ChargingRateUnit chargingRateUnit;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedulePeriod")
    @Valid
    @NotNull
    private List<ChargingSchedulePeriod__2> chargingSchedulePeriod = new ArrayList<ChargingSchedulePeriod__2>();
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

    public ChargingSchedule__2 withDuration(int duration) {
        this.duration = duration;
        return this;
    }

    @JsonProperty("startSchedule")
    public OffsetDateTime getStartSchedule() {
        return startSchedule;
    }

    @JsonProperty("startSchedule")
    public void setStartSchedule(OffsetDateTime startSchedule) {
        this.startSchedule = startSchedule;
    }

    public ChargingSchedule__2 withStartSchedule(OffsetDateTime startSchedule) {
        this.startSchedule = startSchedule;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingRateUnit")
    public ChargingSchedule__2 .ChargingRateUnit getChargingRateUnit() {
        return chargingRateUnit;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingRateUnit")
    public void setChargingRateUnit(ChargingSchedule__2 .ChargingRateUnit chargingRateUnit) {
        this.chargingRateUnit = chargingRateUnit;
    }

    public ChargingSchedule__2 withChargingRateUnit(ChargingSchedule__2 .ChargingRateUnit chargingRateUnit) {
        this.chargingRateUnit = chargingRateUnit;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedulePeriod")
    public List<ChargingSchedulePeriod__2> getChargingSchedulePeriod() {
        return chargingSchedulePeriod;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedulePeriod")
    public void setChargingSchedulePeriod(List<ChargingSchedulePeriod__2> chargingSchedulePeriod) {
        this.chargingSchedulePeriod = chargingSchedulePeriod;
    }

    public ChargingSchedule__2 withChargingSchedulePeriod(List<ChargingSchedulePeriod__2> chargingSchedulePeriod) {
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

    public ChargingSchedule__2 withMinChargingRate(double minChargingRate) {
        this.minChargingRate = minChargingRate;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChargingSchedule__2 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        if ((other instanceof ChargingSchedule__2) == false) {
            return false;
        }
        ChargingSchedule__2 rhs = ((ChargingSchedule__2) other);
        return (((((this.duration == rhs.duration)&&(Double.doubleToLongBits(this.minChargingRate) == Double.doubleToLongBits(rhs.minChargingRate)))&&((this.startSchedule == rhs.startSchedule)||((this.startSchedule!= null)&&this.startSchedule.equals(rhs.startSchedule))))&&((this.chargingSchedulePeriod == rhs.chargingSchedulePeriod)||((this.chargingSchedulePeriod!= null)&&this.chargingSchedulePeriod.equals(rhs.chargingSchedulePeriod))))&&((this.chargingRateUnit == rhs.chargingRateUnit)||((this.chargingRateUnit!= null)&&this.chargingRateUnit.equals(rhs.chargingRateUnit))));
    }

    public enum ChargingRateUnit {

        A("A"),
        W("W");
        private final String value;
        private final static Map<String, ChargingSchedule__2 .ChargingRateUnit> CONSTANTS = new HashMap<String, ChargingSchedule__2 .ChargingRateUnit>();

        static {
            for (ChargingSchedule__2 .ChargingRateUnit c: values()) {
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
        public static ChargingSchedule__2 .ChargingRateUnit fromValue(String value) {
            ChargingSchedule__2 .ChargingRateUnit constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
