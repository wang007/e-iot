
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
    "requestId",
    "evseId",
    "chargingProfile",
    "customData"
})
public class GetChargingProfilesRequest {

    /**
     * Reference identification that is to be used by the Charging Station in the &lt;&lt;reportchargingprofilesrequest, ReportChargingProfilesRequest&gt;&gt; when provided.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("Reference identification that is to be used by the Charging Station in the &lt;&lt;reportchargingprofilesrequest, ReportChargingProfilesRequest&gt;&gt; when provided.\r\n")
    @NotNull
    private int requestId;
    /**
     * For which EVSE installed charging profiles SHALL be reported. If 0, only charging profiles installed on the Charging Station itself (the grid connection) SHALL be reported. If omitted, all installed charging profiles SHALL be reported. +
     * Reported charging profiles SHALL match the criteria in field _chargingProfile_.
     * 
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("For which EVSE installed charging profiles SHALL be reported. If 0, only charging profiles installed on the Charging Station itself (the grid connection) SHALL be reported. If omitted, all installed charging profiles SHALL be reported. +\r\nReported charging profiles SHALL match the criteria in field _chargingProfile_.\r\n")
    @DecimalMin("0")
    private int evseId;
    /**
     * A ChargingProfileCriterionType is a filter for charging profiles to be selected by a GetChargingProfilesRequest.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfile")
    @JsonPropertyDescription("A ChargingProfileCriterionType is a filter for charging profiles to be selected by a GetChargingProfilesRequest.\r\n\r\n")
    @Valid
    @NotNull
    private ChargingProfileCriterion chargingProfile;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Reference identification that is to be used by the Charging Station in the &lt;&lt;reportchargingprofilesrequest, ReportChargingProfilesRequest&gt;&gt; when provided.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public int getRequestId() {
        return requestId;
    }

    /**
     * Reference identification that is to be used by the Charging Station in the &lt;&lt;reportchargingprofilesrequest, ReportChargingProfilesRequest&gt;&gt; when provided.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public GetChargingProfilesRequest withRequestId(int requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * For which EVSE installed charging profiles SHALL be reported. If 0, only charging profiles installed on the Charging Station itself (the grid connection) SHALL be reported. If omitted, all installed charging profiles SHALL be reported. +
     * Reported charging profiles SHALL match the criteria in field _chargingProfile_.
     * 
     * 
     */
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * For which EVSE installed charging profiles SHALL be reported. If 0, only charging profiles installed on the Charging Station itself (the grid connection) SHALL be reported. If omitted, all installed charging profiles SHALL be reported. +
     * Reported charging profiles SHALL match the criteria in field _chargingProfile_.
     * 
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public GetChargingProfilesRequest withEvseId(int evseId) {
        this.evseId = evseId;
        return this;
    }

    /**
     * A ChargingProfileCriterionType is a filter for charging profiles to be selected by a GetChargingProfilesRequest.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfile")
    public ChargingProfileCriterion getChargingProfile() {
        return chargingProfile;
    }

    /**
     * A ChargingProfileCriterionType is a filter for charging profiles to be selected by a GetChargingProfilesRequest.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfile")
    public void setChargingProfile(ChargingProfileCriterion chargingProfile) {
        this.chargingProfile = chargingProfile;
    }

    public GetChargingProfilesRequest withChargingProfile(ChargingProfileCriterion chargingProfile) {
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

    public GetChargingProfilesRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GetChargingProfilesRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("requestId");
        sb.append('=');
        sb.append(this.requestId);
        sb.append(',');
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
        result = ((result* 31)+ this.requestId);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetChargingProfilesRequest) == false) {
            return false;
        }
        GetChargingProfilesRequest rhs = ((GetChargingProfilesRequest) other);
        return ((((this.evseId == rhs.evseId)&&((this.chargingProfile == rhs.chargingProfile)||((this.chargingProfile!= null)&&this.chargingProfile.equals(rhs.chargingProfile))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.requestId == rhs.requestId));
    }

}
