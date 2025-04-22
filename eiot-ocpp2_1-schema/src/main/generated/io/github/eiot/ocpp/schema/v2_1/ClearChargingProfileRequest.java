
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "chargingProfileId",
    "chargingProfileCriteria",
    "customData"
})
public class ClearChargingProfileRequest {

    /**
     * The Id of the charging profile to clear.
     * 
     * 
     */
    @JsonProperty("chargingProfileId")
    @JsonPropertyDescription("The Id of the charging profile to clear.\r\n")
    private int chargingProfileId;
    /**
     * A ClearChargingProfileType is a filter for charging profiles to be cleared by ClearChargingProfileRequest.
     * 
     * 
     * 
     */
    @JsonProperty("chargingProfileCriteria")
    @JsonPropertyDescription("A ClearChargingProfileType is a filter for charging profiles to be cleared by ClearChargingProfileRequest.\r\n\r\n")
    @Valid
    private ClearChargingProfile chargingProfileCriteria;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * The Id of the charging profile to clear.
     * 
     * 
     */
    @JsonProperty("chargingProfileId")
    public int getChargingProfileId() {
        return chargingProfileId;
    }

    /**
     * The Id of the charging profile to clear.
     * 
     * 
     */
    @JsonProperty("chargingProfileId")
    public void setChargingProfileId(int chargingProfileId) {
        this.chargingProfileId = chargingProfileId;
    }

    public ClearChargingProfileRequest withChargingProfileId(int chargingProfileId) {
        this.chargingProfileId = chargingProfileId;
        return this;
    }

    /**
     * A ClearChargingProfileType is a filter for charging profiles to be cleared by ClearChargingProfileRequest.
     * 
     * 
     * 
     */
    @JsonProperty("chargingProfileCriteria")
    public ClearChargingProfile getChargingProfileCriteria() {
        return chargingProfileCriteria;
    }

    /**
     * A ClearChargingProfileType is a filter for charging profiles to be cleared by ClearChargingProfileRequest.
     * 
     * 
     * 
     */
    @JsonProperty("chargingProfileCriteria")
    public void setChargingProfileCriteria(ClearChargingProfile chargingProfileCriteria) {
        this.chargingProfileCriteria = chargingProfileCriteria;
    }

    public ClearChargingProfileRequest withChargingProfileCriteria(ClearChargingProfile chargingProfileCriteria) {
        this.chargingProfileCriteria = chargingProfileCriteria;
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

    public ClearChargingProfileRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ClearChargingProfileRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("chargingProfileId");
        sb.append('=');
        sb.append(this.chargingProfileId);
        sb.append(',');
        sb.append("chargingProfileCriteria");
        sb.append('=');
        sb.append(((this.chargingProfileCriteria == null)?"<null>":this.chargingProfileCriteria));
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
        result = ((result* 31)+((this.chargingProfileCriteria == null)? 0 :this.chargingProfileCriteria.hashCode()));
        result = ((result* 31)+ this.chargingProfileId);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ClearChargingProfileRequest) == false) {
            return false;
        }
        ClearChargingProfileRequest rhs = ((ClearChargingProfileRequest) other);
        return ((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&((this.chargingProfileCriteria == rhs.chargingProfileCriteria)||((this.chargingProfileCriteria!= null)&&this.chargingProfileCriteria.equals(rhs.chargingProfileCriteria))))&&(this.chargingProfileId == rhs.chargingProfileId));
    }

}
