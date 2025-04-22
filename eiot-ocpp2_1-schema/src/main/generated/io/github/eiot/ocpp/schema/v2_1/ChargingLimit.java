
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "chargingLimitSource",
    "isLocalGeneration",
    "isGridCritical",
    "customData"
})
public class ChargingLimit {

    /**
     * Represents the source of the charging limit. Values defined in appendix as ChargingLimitSourceEnumStringType.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingLimitSource")
    @JsonPropertyDescription("Represents the source of the charging limit. Values defined in appendix as ChargingLimitSourceEnumStringType.\r\n")
    @Size(max = 20)
    @NotNull
    private String chargingLimitSource;
    /**
     * *(2.1)* True when the reported limit concerns local generation that is providing extra capacity, instead of a limitation.
     * 
     * 
     */
    @JsonProperty("isLocalGeneration")
    @JsonPropertyDescription("*(2.1)* True when the reported limit concerns local generation that is providing extra capacity, instead of a limitation.\r\n")
    private boolean isLocalGeneration;
    /**
     * Indicates whether the charging limit is critical for the grid.
     * 
     * 
     */
    @JsonProperty("isGridCritical")
    @JsonPropertyDescription("Indicates whether the charging limit is critical for the grid.\r\n")
    private boolean isGridCritical;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Represents the source of the charging limit. Values defined in appendix as ChargingLimitSourceEnumStringType.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingLimitSource")
    public String getChargingLimitSource() {
        return chargingLimitSource;
    }

    /**
     * Represents the source of the charging limit. Values defined in appendix as ChargingLimitSourceEnumStringType.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingLimitSource")
    public void setChargingLimitSource(String chargingLimitSource) {
        this.chargingLimitSource = chargingLimitSource;
    }

    public ChargingLimit withChargingLimitSource(String chargingLimitSource) {
        this.chargingLimitSource = chargingLimitSource;
        return this;
    }

    /**
     * *(2.1)* True when the reported limit concerns local generation that is providing extra capacity, instead of a limitation.
     * 
     * 
     */
    @JsonProperty("isLocalGeneration")
    public boolean isIsLocalGeneration() {
        return isLocalGeneration;
    }

    /**
     * *(2.1)* True when the reported limit concerns local generation that is providing extra capacity, instead of a limitation.
     * 
     * 
     */
    @JsonProperty("isLocalGeneration")
    public void setIsLocalGeneration(boolean isLocalGeneration) {
        this.isLocalGeneration = isLocalGeneration;
    }

    public ChargingLimit withIsLocalGeneration(boolean isLocalGeneration) {
        this.isLocalGeneration = isLocalGeneration;
        return this;
    }

    /**
     * Indicates whether the charging limit is critical for the grid.
     * 
     * 
     */
    @JsonProperty("isGridCritical")
    public boolean isIsGridCritical() {
        return isGridCritical;
    }

    /**
     * Indicates whether the charging limit is critical for the grid.
     * 
     * 
     */
    @JsonProperty("isGridCritical")
    public void setIsGridCritical(boolean isGridCritical) {
        this.isGridCritical = isGridCritical;
    }

    public ChargingLimit withIsGridCritical(boolean isGridCritical) {
        this.isGridCritical = isGridCritical;
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

    public ChargingLimit withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChargingLimit.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("chargingLimitSource");
        sb.append('=');
        sb.append(((this.chargingLimitSource == null)?"<null>":this.chargingLimitSource));
        sb.append(',');
        sb.append("isLocalGeneration");
        sb.append('=');
        sb.append(this.isLocalGeneration);
        sb.append(',');
        sb.append("isGridCritical");
        sb.append('=');
        sb.append(this.isGridCritical);
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
        result = ((result* 31)+(this.isLocalGeneration? 1 : 0));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.chargingLimitSource == null)? 0 :this.chargingLimitSource.hashCode()));
        result = ((result* 31)+(this.isGridCritical? 1 : 0));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChargingLimit) == false) {
            return false;
        }
        ChargingLimit rhs = ((ChargingLimit) other);
        return ((((this.isLocalGeneration == rhs.isLocalGeneration)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.chargingLimitSource == rhs.chargingLimitSource)||((this.chargingLimitSource!= null)&&this.chargingLimitSource.equals(rhs.chargingLimitSource))))&&(this.isGridCritical == rhs.isGridCritical));
    }

}
