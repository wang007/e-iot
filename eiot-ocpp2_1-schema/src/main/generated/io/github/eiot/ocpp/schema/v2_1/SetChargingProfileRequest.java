
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
    "chargingProfile",
    "customData"
})
public class SetChargingProfileRequest {

    /**
     * For TxDefaultProfile an evseId=0 applies the profile to each individual evse. For ChargingStationMaxProfile and ChargingStationExternalConstraints an evseId=0 contains an overal limit for the whole Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("For TxDefaultProfile an evseId=0 applies the profile to each individual evse. For ChargingStationMaxProfile and ChargingStationExternalConstraints an evseId=0 contains an overal limit for the whole Charging Station.\r\n")
    @DecimalMin("0")
    @NotNull
    private int evseId;
    /**
     * A ChargingProfile consists of 1 to 3 ChargingSchedules with a list of ChargingSchedulePeriods, describing the amount of power or current that can be delivered per time interval.
     * 
     * image::images/ChargingProfile-Simple.png[]
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfile")
    @JsonPropertyDescription("A ChargingProfile consists of 1 to 3 ChargingSchedules with a list of ChargingSchedulePeriods, describing the amount of power or current that can be delivered per time interval.\r\n\r\nimage::images/ChargingProfile-Simple.png[]\r\n\r\n")
    @Valid
    @NotNull
    private ChargingProfile chargingProfile;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * For TxDefaultProfile an evseId=0 applies the profile to each individual evse. For ChargingStationMaxProfile and ChargingStationExternalConstraints an evseId=0 contains an overal limit for the whole Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * For TxDefaultProfile an evseId=0 applies the profile to each individual evse. For ChargingStationMaxProfile and ChargingStationExternalConstraints an evseId=0 contains an overal limit for the whole Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public SetChargingProfileRequest withEvseId(int evseId) {
        this.evseId = evseId;
        return this;
    }

    /**
     * A ChargingProfile consists of 1 to 3 ChargingSchedules with a list of ChargingSchedulePeriods, describing the amount of power or current that can be delivered per time interval.
     * 
     * image::images/ChargingProfile-Simple.png[]
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfile")
    public ChargingProfile getChargingProfile() {
        return chargingProfile;
    }

    /**
     * A ChargingProfile consists of 1 to 3 ChargingSchedules with a list of ChargingSchedulePeriods, describing the amount of power or current that can be delivered per time interval.
     * 
     * image::images/ChargingProfile-Simple.png[]
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfile")
    public void setChargingProfile(ChargingProfile chargingProfile) {
        this.chargingProfile = chargingProfile;
    }

    public SetChargingProfileRequest withChargingProfile(ChargingProfile chargingProfile) {
        this.chargingProfile = chargingProfile;
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

    public SetChargingProfileRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SetChargingProfileRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
        sb.append(',');
        sb.append("chargingProfile");
        sb.append('=');
        sb.append(((this.chargingProfile == null)?"<null>":this.chargingProfile));
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
        result = ((result* 31)+((this.chargingProfile == null)? 0 :this.chargingProfile.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SetChargingProfileRequest) == false) {
            return false;
        }
        SetChargingProfileRequest rhs = ((SetChargingProfileRequest) other);
        return (((this.evseId == rhs.evseId)&&((this.chargingProfile == rhs.chargingProfile)||((this.chargingProfile!= null)&&this.chargingProfile.equals(rhs.chargingProfile))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))));
    }

}
