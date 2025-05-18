
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
 * A ChargingPeriodType consists of a start time, and a list of possible values that influence this period, for example: amount of energy charged this period, maximum current during this period etc.
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dimensions",
    "tariffId",
    "startPeriod",
    "customData"
})
public class ChargingPeriod {

    @JsonProperty("dimensions")
    @Size(min = 1)
    @Valid
    private List<CostDimension> dimensions = new ArrayList<CostDimension>();
    /**
     * Unique identifier of the Tariff that was used to calculate cost. If not provided, then cost was calculated by some other means.
     * 
     * 
     * 
     */
    @JsonProperty("tariffId")
    @JsonPropertyDescription("Unique identifier of the Tariff that was used to calculate cost. If not provided, then cost was calculated by some other means.\r\n\r\n")
    @Size(max = 60)
    private String tariffId;
    /**
     * Start timestamp of charging period. A period ends when the next period starts. The last period ends when the session ends.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("startPeriod")
    @JsonPropertyDescription("Start timestamp of charging period. A period ends when the next period starts. The last period ends when the session ends.\r\n\r\n")
    @NotNull
    private ZonedDateTime startPeriod;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    @JsonProperty("dimensions")
    public List<CostDimension> getDimensions() {
        return dimensions;
    }

    @JsonProperty("dimensions")
    public void setDimensions(List<CostDimension> dimensions) {
        this.dimensions = dimensions;
    }

    public ChargingPeriod withDimensions(List<CostDimension> dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    /**
     * Unique identifier of the Tariff that was used to calculate cost. If not provided, then cost was calculated by some other means.
     * 
     * 
     * 
     */
    @JsonProperty("tariffId")
    public String getTariffId() {
        return tariffId;
    }

    /**
     * Unique identifier of the Tariff that was used to calculate cost. If not provided, then cost was calculated by some other means.
     * 
     * 
     * 
     */
    @JsonProperty("tariffId")
    public void setTariffId(String tariffId) {
        this.tariffId = tariffId;
    }

    public ChargingPeriod withTariffId(String tariffId) {
        this.tariffId = tariffId;
        return this;
    }

    /**
     * Start timestamp of charging period. A period ends when the next period starts. The last period ends when the session ends.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("startPeriod")
    public ZonedDateTime getStartPeriod() {
        return startPeriod;
    }

    /**
     * Start timestamp of charging period. A period ends when the next period starts. The last period ends when the session ends.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("startPeriod")
    public void setStartPeriod(ZonedDateTime startPeriod) {
        this.startPeriod = startPeriod;
    }

    public ChargingPeriod withStartPeriod(ZonedDateTime startPeriod) {
        this.startPeriod = startPeriod;
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

    public ChargingPeriod withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChargingPeriod.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("dimensions");
        sb.append('=');
        sb.append(((this.dimensions == null)?"<null>":this.dimensions));
        sb.append(',');
        sb.append("tariffId");
        sb.append('=');
        sb.append(((this.tariffId == null)?"<null>":this.tariffId));
        sb.append(',');
        sb.append("startPeriod");
        sb.append('=');
        sb.append(((this.startPeriod == null)?"<null>":this.startPeriod));
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
        result = ((result* 31)+((this.startPeriod == null)? 0 :this.startPeriod.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.tariffId == null)? 0 :this.tariffId.hashCode()));
        result = ((result* 31)+((this.dimensions == null)? 0 :this.dimensions.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChargingPeriod) == false) {
            return false;
        }
        ChargingPeriod rhs = ((ChargingPeriod) other);
        return (((((this.startPeriod == rhs.startPeriod)||((this.startPeriod!= null)&&this.startPeriod.equals(rhs.startPeriod)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.tariffId == rhs.tariffId)||((this.tariffId!= null)&&this.tariffId.equals(rhs.tariffId))))&&((this.dimensions == rhs.dimensions)||((this.dimensions!= null)&&this.dimensions.equals(rhs.dimensions))));
    }

}
