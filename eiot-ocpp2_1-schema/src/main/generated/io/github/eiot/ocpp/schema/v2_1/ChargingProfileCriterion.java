
package io.github.eiot.ocpp.schema.v2_1;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;


/**
 * A ChargingProfileCriterionType is a filter for charging profiles to be selected by a GetChargingProfilesRequest.
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "chargingProfilePurpose",
    "stackLevel",
    "chargingProfileId",
    "chargingLimitSource",
    "customData"
})
public class ChargingProfileCriterion {

    /**
     * Defines the purpose of the schedule transferred by this profile
     * 
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    @JsonPropertyDescription("Defines the purpose of the schedule transferred by this profile\r\n")
    private ChargingProfilePurposeEnum chargingProfilePurpose;
    /**
     * Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0.
     * 
     * 
     */
    @JsonProperty("stackLevel")
    @JsonPropertyDescription("Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0.\r\n")
    @DecimalMin("0")
    private int stackLevel;
    /**
     * List of all the chargingProfileIds requested. Any ChargingProfile that matches one of these profiles will be reported. If omitted, the Charging Station SHALL not filter on chargingProfileId. This field SHALL NOT contain more ids than set in &lt;&lt;configkey-charging-profile-entries,ChargingProfileEntries.maxLimit&gt;&gt;
     * 
     * 
     * 
     */
    @JsonProperty("chargingProfileId")
    @JsonPropertyDescription("List of all the chargingProfileIds requested. Any ChargingProfile that matches one of these profiles will be reported. If omitted, the Charging Station SHALL not filter on chargingProfileId. This field SHALL NOT contain more ids than set in &lt;&lt;configkey-charging-profile-entries,ChargingProfileEntries.maxLimit&gt;&gt;\r\n\r\n")
    @Size(min = 1)
    @Valid
    private List<Integer> chargingProfileId = new ArrayList<Integer>();
    /**
     * For which charging limit sources, charging profiles SHALL be reported. If omitted, the Charging Station SHALL not filter on chargingLimitSource. Values defined in Appendix as ChargingLimitSourceEnumStringType.
     * 
     * 
     */
    @JsonProperty("chargingLimitSource")
    @JsonPropertyDescription("For which charging limit sources, charging profiles SHALL be reported. If omitted, the Charging Station SHALL not filter on chargingLimitSource. Values defined in Appendix as ChargingLimitSourceEnumStringType.\r\n")
    @Size(min = 1, max = 4)
    @Valid
    private List<String> chargingLimitSource = new ArrayList<String>();
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Defines the purpose of the schedule transferred by this profile
     * 
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    public ChargingProfilePurposeEnum getChargingProfilePurpose() {
        return chargingProfilePurpose;
    }

    /**
     * Defines the purpose of the schedule transferred by this profile
     * 
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    public void setChargingProfilePurpose(ChargingProfilePurposeEnum chargingProfilePurpose) {
        this.chargingProfilePurpose = chargingProfilePurpose;
    }

    public ChargingProfileCriterion withChargingProfilePurpose(ChargingProfilePurposeEnum chargingProfilePurpose) {
        this.chargingProfilePurpose = chargingProfilePurpose;
        return this;
    }

    /**
     * Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0.
     * 
     * 
     */
    @JsonProperty("stackLevel")
    public int getStackLevel() {
        return stackLevel;
    }

    /**
     * Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0.
     * 
     * 
     */
    @JsonProperty("stackLevel")
    public void setStackLevel(int stackLevel) {
        this.stackLevel = stackLevel;
    }

    public ChargingProfileCriterion withStackLevel(int stackLevel) {
        this.stackLevel = stackLevel;
        return this;
    }

    /**
     * List of all the chargingProfileIds requested. Any ChargingProfile that matches one of these profiles will be reported. If omitted, the Charging Station SHALL not filter on chargingProfileId. This field SHALL NOT contain more ids than set in &lt;&lt;configkey-charging-profile-entries,ChargingProfileEntries.maxLimit&gt;&gt;
     * 
     * 
     * 
     */
    @JsonProperty("chargingProfileId")
    public List<Integer> getChargingProfileId() {
        return chargingProfileId;
    }

    /**
     * List of all the chargingProfileIds requested. Any ChargingProfile that matches one of these profiles will be reported. If omitted, the Charging Station SHALL not filter on chargingProfileId. This field SHALL NOT contain more ids than set in &lt;&lt;configkey-charging-profile-entries,ChargingProfileEntries.maxLimit&gt;&gt;
     * 
     * 
     * 
     */
    @JsonProperty("chargingProfileId")
    public void setChargingProfileId(List<Integer> chargingProfileId) {
        this.chargingProfileId = chargingProfileId;
    }

    public ChargingProfileCriterion withChargingProfileId(List<Integer> chargingProfileId) {
        this.chargingProfileId = chargingProfileId;
        return this;
    }

    /**
     * For which charging limit sources, charging profiles SHALL be reported. If omitted, the Charging Station SHALL not filter on chargingLimitSource. Values defined in Appendix as ChargingLimitSourceEnumStringType.
     * 
     * 
     */
    @JsonProperty("chargingLimitSource")
    public List<String> getChargingLimitSource() {
        return chargingLimitSource;
    }

    /**
     * For which charging limit sources, charging profiles SHALL be reported. If omitted, the Charging Station SHALL not filter on chargingLimitSource. Values defined in Appendix as ChargingLimitSourceEnumStringType.
     * 
     * 
     */
    @JsonProperty("chargingLimitSource")
    public void setChargingLimitSource(List<String> chargingLimitSource) {
        this.chargingLimitSource = chargingLimitSource;
    }

    public ChargingProfileCriterion withChargingLimitSource(List<String> chargingLimitSource) {
        this.chargingLimitSource = chargingLimitSource;
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

    public ChargingProfileCriterion withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChargingProfileCriterion.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("chargingProfilePurpose");
        sb.append('=');
        sb.append(((this.chargingProfilePurpose == null)?"<null>":this.chargingProfilePurpose));
        sb.append(',');
        sb.append("stackLevel");
        sb.append('=');
        sb.append(this.stackLevel);
        sb.append(',');
        sb.append("chargingProfileId");
        sb.append('=');
        sb.append(((this.chargingProfileId == null)?"<null>":this.chargingProfileId));
        sb.append(',');
        sb.append("chargingLimitSource");
        sb.append('=');
        sb.append(((this.chargingLimitSource == null)?"<null>":this.chargingLimitSource));
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
        result = ((result* 31)+((this.chargingProfilePurpose == null)? 0 :this.chargingProfilePurpose.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.stackLevel);
        result = ((result* 31)+((this.chargingProfileId == null)? 0 :this.chargingProfileId.hashCode()));
        result = ((result* 31)+((this.chargingLimitSource == null)? 0 :this.chargingLimitSource.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChargingProfileCriterion) == false) {
            return false;
        }
        ChargingProfileCriterion rhs = ((ChargingProfileCriterion) other);
        return ((((((this.chargingProfilePurpose == rhs.chargingProfilePurpose)||((this.chargingProfilePurpose!= null)&&this.chargingProfilePurpose.equals(rhs.chargingProfilePurpose)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.stackLevel == rhs.stackLevel))&&((this.chargingProfileId == rhs.chargingProfileId)||((this.chargingProfileId!= null)&&this.chargingProfileId.equals(rhs.chargingProfileId))))&&((this.chargingLimitSource == rhs.chargingLimitSource)||((this.chargingLimitSource!= null)&&this.chargingLimitSource.equals(rhs.chargingLimitSource))));
    }

}
