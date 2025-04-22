
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "chargingLimitSource",
    "evseId",
    "customData"
})
public class ClearedChargingLimitRequest {

    /**
     * Source of the charging limit. Allowed values defined in Appendix as ChargingLimitSourceEnumStringType.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingLimitSource")
    @JsonPropertyDescription("Source of the charging limit. Allowed values defined in Appendix as ChargingLimitSourceEnumStringType.\r\n")
    @Size(max = 20)
    @NotNull
    private String chargingLimitSource;
    /**
     * EVSE Identifier.
     * 
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("EVSE Identifier.\r\n")
    @DecimalMin("0")
    private int evseId;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Source of the charging limit. Allowed values defined in Appendix as ChargingLimitSourceEnumStringType.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingLimitSource")
    public String getChargingLimitSource() {
        return chargingLimitSource;
    }

    /**
     * Source of the charging limit. Allowed values defined in Appendix as ChargingLimitSourceEnumStringType.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingLimitSource")
    public void setChargingLimitSource(String chargingLimitSource) {
        this.chargingLimitSource = chargingLimitSource;
    }

    public ClearedChargingLimitRequest withChargingLimitSource(String chargingLimitSource) {
        this.chargingLimitSource = chargingLimitSource;
        return this;
    }

    /**
     * EVSE Identifier.
     * 
     * 
     */
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * EVSE Identifier.
     * 
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public ClearedChargingLimitRequest withEvseId(int evseId) {
        this.evseId = evseId;
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

    public ClearedChargingLimitRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ClearedChargingLimitRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("chargingLimitSource");
        sb.append('=');
        sb.append(((this.chargingLimitSource == null)?"<null>":this.chargingLimitSource));
        sb.append(',');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
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
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.chargingLimitSource == null)? 0 :this.chargingLimitSource.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ClearedChargingLimitRequest) == false) {
            return false;
        }
        ClearedChargingLimitRequest rhs = ((ClearedChargingLimitRequest) other);
        return (((this.evseId == rhs.evseId)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.chargingLimitSource == rhs.chargingLimitSource)||((this.chargingLimitSource!= null)&&this.chargingLimitSource.equals(rhs.chargingLimitSource))));
    }

}
