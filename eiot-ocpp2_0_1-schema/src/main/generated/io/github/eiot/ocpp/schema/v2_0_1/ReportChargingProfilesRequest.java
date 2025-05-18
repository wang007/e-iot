
package io.github.eiot.ocpp.schema.v2_0_1;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customData",
    "requestId",
    "chargingLimitSource",
    "chargingProfile",
    "tbc",
    "evseId"
})
public class ReportChargingProfilesRequest {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Id used to match the &lt;&lt;getchargingprofilesrequest, GetChargingProfilesRequest&gt;&gt; message with the resulting ReportChargingProfilesRequest messages. When the CSMS provided a requestId in the &lt;&lt;getchargingprofilesrequest, GetChargingProfilesRequest&gt;&gt;, this field SHALL contain the same value.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("Id used to match the &lt;&lt;getchargingprofilesrequest, GetChargingProfilesRequest&gt;&gt; message with the resulting ReportChargingProfilesRequest messages. When the CSMS provided a requestId in the &lt;&lt;getchargingprofilesrequest, GetChargingProfilesRequest&gt;&gt;, this field SHALL contain the same value.\r\n")
    @NotNull
    private int requestId;
    /**
     * Source that has installed this charging profile.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingLimitSource")
    @JsonPropertyDescription("Source that has installed this charging profile.\r\n")
    @NotNull
    private ChargingLimitSourceEnum chargingLimitSource;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfile")
    @Size(min = 1)
    @Valid
    @NotNull
    private List<ChargingProfile> chargingProfile = new ArrayList<ChargingProfile>();
    /**
     * To Be Continued. Default value when omitted: false. false indicates that there are no further messages as part of this report.
     * 
     * 
     */
    @JsonProperty("tbc")
    @JsonPropertyDescription("To Be Continued. Default value when omitted: false. false indicates that there are no further messages as part of this report.\r\n")
    private boolean tbc = false;
    /**
     * The evse to which the charging profile applies. If evseId = 0, the message contains an overall limit for the Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("The evse to which the charging profile applies. If evseId = 0, the message contains an overall limit for the Charging Station.\r\n")
    @NotNull
    private int evseId;

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

    public ReportChargingProfilesRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    /**
     * Id used to match the &lt;&lt;getchargingprofilesrequest, GetChargingProfilesRequest&gt;&gt; message with the resulting ReportChargingProfilesRequest messages. When the CSMS provided a requestId in the &lt;&lt;getchargingprofilesrequest, GetChargingProfilesRequest&gt;&gt;, this field SHALL contain the same value.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public int getRequestId() {
        return requestId;
    }

    /**
     * Id used to match the &lt;&lt;getchargingprofilesrequest, GetChargingProfilesRequest&gt;&gt; message with the resulting ReportChargingProfilesRequest messages. When the CSMS provided a requestId in the &lt;&lt;getchargingprofilesrequest, GetChargingProfilesRequest&gt;&gt;, this field SHALL contain the same value.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public ReportChargingProfilesRequest withRequestId(int requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * Source that has installed this charging profile.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingLimitSource")
    public ChargingLimitSourceEnum getChargingLimitSource() {
        return chargingLimitSource;
    }

    /**
     * Source that has installed this charging profile.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingLimitSource")
    public void setChargingLimitSource(ChargingLimitSourceEnum chargingLimitSource) {
        this.chargingLimitSource = chargingLimitSource;
    }

    public ReportChargingProfilesRequest withChargingLimitSource(ChargingLimitSourceEnum chargingLimitSource) {
        this.chargingLimitSource = chargingLimitSource;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfile")
    public List<ChargingProfile> getChargingProfile() {
        return chargingProfile;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfile")
    public void setChargingProfile(List<ChargingProfile> chargingProfile) {
        this.chargingProfile = chargingProfile;
    }

    public ReportChargingProfilesRequest withChargingProfile(List<ChargingProfile> chargingProfile) {
        this.chargingProfile = chargingProfile;
        return this;
    }

    /**
     * To Be Continued. Default value when omitted: false. false indicates that there are no further messages as part of this report.
     * 
     * 
     */
    @JsonProperty("tbc")
    public boolean isTbc() {
        return tbc;
    }

    /**
     * To Be Continued. Default value when omitted: false. false indicates that there are no further messages as part of this report.
     * 
     * 
     */
    @JsonProperty("tbc")
    public void setTbc(boolean tbc) {
        this.tbc = tbc;
    }

    public ReportChargingProfilesRequest withTbc(boolean tbc) {
        this.tbc = tbc;
        return this;
    }

    /**
     * The evse to which the charging profile applies. If evseId = 0, the message contains an overall limit for the Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * The evse to which the charging profile applies. If evseId = 0, the message contains an overall limit for the Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public ReportChargingProfilesRequest withEvseId(int evseId) {
        this.evseId = evseId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ReportChargingProfilesRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("customData");
        sb.append('=');
        sb.append(((this.customData == null)?"<null>":this.customData));
        sb.append(',');
        sb.append("requestId");
        sb.append('=');
        sb.append(this.requestId);
        sb.append(',');
        sb.append("chargingLimitSource");
        sb.append('=');
        sb.append(((this.chargingLimitSource == null)?"<null>":this.chargingLimitSource));
        sb.append(',');
        sb.append("chargingProfile");
        sb.append('=');
        sb.append(((this.chargingProfile == null)?"<null>":this.chargingProfile));
        sb.append(',');
        sb.append("tbc");
        sb.append('=');
        sb.append(this.tbc);
        sb.append(',');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
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
        result = ((result* 31)+(this.tbc? 1 : 0));
        result = ((result* 31)+ this.requestId);
        result = ((result* 31)+((this.chargingProfile == null)? 0 :this.chargingProfile.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.chargingLimitSource == null)? 0 :this.chargingLimitSource.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReportChargingProfilesRequest) == false) {
            return false;
        }
        ReportChargingProfilesRequest rhs = ((ReportChargingProfilesRequest) other);
        return ((((((this.evseId == rhs.evseId)&&(this.tbc == rhs.tbc))&&(this.requestId == rhs.requestId))&&((this.chargingProfile == rhs.chargingProfile)||((this.chargingProfile!= null)&&this.chargingProfile.equals(rhs.chargingProfile))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.chargingLimitSource == rhs.chargingLimitSource)||((this.chargingLimitSource!= null)&&this.chargingLimitSource.equals(rhs.chargingLimitSource))));
    }

}
