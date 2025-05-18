
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;


/**
 * A ClearChargingProfileType is a filter for charging profiles to be cleared by ClearChargingProfileRequest.
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "evseId",
    "chargingProfilePurpose",
    "stackLevel",
    "customData"
})
public class ClearChargingProfile {

    /**
     * Specifies the id of the EVSE for which to clear charging profiles. An evseId of zero (0) specifies the charging profile for the overall Charging Station. Absence of this parameter means the clearing applies to all charging profiles that match the other criteria in the request.
     * 
     * 
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("Specifies the id of the EVSE for which to clear charging profiles. An evseId of zero (0) specifies the charging profile for the overall Charging Station. Absence of this parameter means the clearing applies to all charging profiles that match the other criteria in the request.\r\n\r\n")
    @DecimalMin("0")
    private int evseId;
    /**
     * Specifies to purpose of the charging profiles that will be cleared, if they meet the other criteria in the request.
     * 
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    @JsonPropertyDescription("Specifies to purpose of the charging profiles that will be cleared, if they meet the other criteria in the request.\r\n")
    private ChargingProfilePurposeEnum chargingProfilePurpose;
    /**
     * Specifies the stackLevel for which charging profiles will be cleared, if they meet the other criteria in the request.
     * 
     * 
     */
    @JsonProperty("stackLevel")
    @JsonPropertyDescription("Specifies the stackLevel for which charging profiles will be cleared, if they meet the other criteria in the request.\r\n")
    @DecimalMin("0")
    private int stackLevel;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Specifies the id of the EVSE for which to clear charging profiles. An evseId of zero (0) specifies the charging profile for the overall Charging Station. Absence of this parameter means the clearing applies to all charging profiles that match the other criteria in the request.
     * 
     * 
     * 
     */
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * Specifies the id of the EVSE for which to clear charging profiles. An evseId of zero (0) specifies the charging profile for the overall Charging Station. Absence of this parameter means the clearing applies to all charging profiles that match the other criteria in the request.
     * 
     * 
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public ClearChargingProfile withEvseId(int evseId) {
        this.evseId = evseId;
        return this;
    }

    /**
     * Specifies to purpose of the charging profiles that will be cleared, if they meet the other criteria in the request.
     * 
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    public ChargingProfilePurposeEnum getChargingProfilePurpose() {
        return chargingProfilePurpose;
    }

    /**
     * Specifies to purpose of the charging profiles that will be cleared, if they meet the other criteria in the request.
     * 
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    public void setChargingProfilePurpose(ChargingProfilePurposeEnum chargingProfilePurpose) {
        this.chargingProfilePurpose = chargingProfilePurpose;
    }

    public ClearChargingProfile withChargingProfilePurpose(ChargingProfilePurposeEnum chargingProfilePurpose) {
        this.chargingProfilePurpose = chargingProfilePurpose;
        return this;
    }

    /**
     * Specifies the stackLevel for which charging profiles will be cleared, if they meet the other criteria in the request.
     * 
     * 
     */
    @JsonProperty("stackLevel")
    public int getStackLevel() {
        return stackLevel;
    }

    /**
     * Specifies the stackLevel for which charging profiles will be cleared, if they meet the other criteria in the request.
     * 
     * 
     */
    @JsonProperty("stackLevel")
    public void setStackLevel(int stackLevel) {
        this.stackLevel = stackLevel;
    }

    public ClearChargingProfile withStackLevel(int stackLevel) {
        this.stackLevel = stackLevel;
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

    public ClearChargingProfile withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ClearChargingProfile.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
        sb.append(',');
        sb.append("chargingProfilePurpose");
        sb.append('=');
        sb.append(((this.chargingProfilePurpose == null)?"<null>":this.chargingProfilePurpose));
        sb.append(',');
        sb.append("stackLevel");
        sb.append('=');
        sb.append(this.stackLevel);
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
        result = ((result* 31)+((this.chargingProfilePurpose == null)? 0 :this.chargingProfilePurpose.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.stackLevel);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ClearChargingProfile) == false) {
            return false;
        }
        ClearChargingProfile rhs = ((ClearChargingProfile) other);
        return ((((this.evseId == rhs.evseId)&&((this.chargingProfilePurpose == rhs.chargingProfilePurpose)||((this.chargingProfilePurpose!= null)&&this.chargingProfilePurpose.equals(rhs.chargingProfilePurpose))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.stackLevel == rhs.stackLevel));
    }

}
