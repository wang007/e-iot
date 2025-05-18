
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Collection of configuration data needed to make a data-connection over a cellular network.
 * 
 * NOTE: When asking a GSM modem to dial in, it is possible to specify which mobile operator should be used. This can be done with the mobile country code (MCC) in combination with a mobile network code (MNC). Example: If your preferred network is Vodafone Netherlands, the MCC=204 and the MNC=04 which means the key PreferredNetwork = 20404 Some modems allows to specify a preferred network, which means, if this network is not available, a different network is used. If you specify UseOnlyPreferredNetwork and this network is not available, the modem will not dial in.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apn",
    "apnUserName",
    "apnPassword",
    "simPin",
    "preferredNetwork",
    "useOnlyPreferredNetwork",
    "apnAuthentication",
    "customData"
})
public class APN {

    /**
     * The Access Point Name as an URL.
     * 
     * (Required)
     * 
     */
    @JsonProperty("apn")
    @JsonPropertyDescription("The Access Point Name as an URL.\r\n")
    @Size(max = 2000)
    @NotNull
    private String apn;
    /**
     * APN username.
     * 
     * 
     */
    @JsonProperty("apnUserName")
    @JsonPropertyDescription("APN username.\r\n")
    @Size(max = 50)
    private String apnUserName;
    /**
     * *(2.1)* APN Password.
     * 
     * 
     */
    @JsonProperty("apnPassword")
    @JsonPropertyDescription("*(2.1)* APN Password.\r\n")
    @Size(max = 64)
    private String apnPassword;
    /**
     * SIM card pin code.
     * 
     * 
     */
    @JsonProperty("simPin")
    @JsonPropertyDescription("SIM card pin code.\r\n")
    private int simPin;
    /**
     * Preferred network, written as MCC and MNC concatenated. See note.
     * 
     * 
     */
    @JsonProperty("preferredNetwork")
    @JsonPropertyDescription("Preferred network, written as MCC and MNC concatenated. See note.\r\n")
    @Size(max = 6)
    private String preferredNetwork;
    /**
     * Default: false. Use only the preferred Network, do
     * not dial in when not available. See Note.
     * 
     * 
     */
    @JsonProperty("useOnlyPreferredNetwork")
    @JsonPropertyDescription("Default: false. Use only the preferred Network, do\r\nnot dial in when not available. See Note.\r\n")
    private boolean useOnlyPreferredNetwork = false;
    /**
     * Authentication method.
     * 
     * (Required)
     * 
     */
    @JsonProperty("apnAuthentication")
    @JsonPropertyDescription("Authentication method.\r\n")
    @NotNull
    private APNAuthenticationEnum apnAuthentication;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * The Access Point Name as an URL.
     * 
     * (Required)
     * 
     */
    @JsonProperty("apn")
    public String getApn() {
        return apn;
    }

    /**
     * The Access Point Name as an URL.
     * 
     * (Required)
     * 
     */
    @JsonProperty("apn")
    public void setApn(String apn) {
        this.apn = apn;
    }

    public APN withApn(String apn) {
        this.apn = apn;
        return this;
    }

    /**
     * APN username.
     * 
     * 
     */
    @JsonProperty("apnUserName")
    public String getApnUserName() {
        return apnUserName;
    }

    /**
     * APN username.
     * 
     * 
     */
    @JsonProperty("apnUserName")
    public void setApnUserName(String apnUserName) {
        this.apnUserName = apnUserName;
    }

    public APN withApnUserName(String apnUserName) {
        this.apnUserName = apnUserName;
        return this;
    }

    /**
     * *(2.1)* APN Password.
     * 
     * 
     */
    @JsonProperty("apnPassword")
    public String getApnPassword() {
        return apnPassword;
    }

    /**
     * *(2.1)* APN Password.
     * 
     * 
     */
    @JsonProperty("apnPassword")
    public void setApnPassword(String apnPassword) {
        this.apnPassword = apnPassword;
    }

    public APN withApnPassword(String apnPassword) {
        this.apnPassword = apnPassword;
        return this;
    }

    /**
     * SIM card pin code.
     * 
     * 
     */
    @JsonProperty("simPin")
    public int getSimPin() {
        return simPin;
    }

    /**
     * SIM card pin code.
     * 
     * 
     */
    @JsonProperty("simPin")
    public void setSimPin(int simPin) {
        this.simPin = simPin;
    }

    public APN withSimPin(int simPin) {
        this.simPin = simPin;
        return this;
    }

    /**
     * Preferred network, written as MCC and MNC concatenated. See note.
     * 
     * 
     */
    @JsonProperty("preferredNetwork")
    public String getPreferredNetwork() {
        return preferredNetwork;
    }

    /**
     * Preferred network, written as MCC and MNC concatenated. See note.
     * 
     * 
     */
    @JsonProperty("preferredNetwork")
    public void setPreferredNetwork(String preferredNetwork) {
        this.preferredNetwork = preferredNetwork;
    }

    public APN withPreferredNetwork(String preferredNetwork) {
        this.preferredNetwork = preferredNetwork;
        return this;
    }

    /**
     * Default: false. Use only the preferred Network, do
     * not dial in when not available. See Note.
     * 
     * 
     */
    @JsonProperty("useOnlyPreferredNetwork")
    public boolean isUseOnlyPreferredNetwork() {
        return useOnlyPreferredNetwork;
    }

    /**
     * Default: false. Use only the preferred Network, do
     * not dial in when not available. See Note.
     * 
     * 
     */
    @JsonProperty("useOnlyPreferredNetwork")
    public void setUseOnlyPreferredNetwork(boolean useOnlyPreferredNetwork) {
        this.useOnlyPreferredNetwork = useOnlyPreferredNetwork;
    }

    public APN withUseOnlyPreferredNetwork(boolean useOnlyPreferredNetwork) {
        this.useOnlyPreferredNetwork = useOnlyPreferredNetwork;
        return this;
    }

    /**
     * Authentication method.
     * 
     * (Required)
     * 
     */
    @JsonProperty("apnAuthentication")
    public APNAuthenticationEnum getApnAuthentication() {
        return apnAuthentication;
    }

    /**
     * Authentication method.
     * 
     * (Required)
     * 
     */
    @JsonProperty("apnAuthentication")
    public void setApnAuthentication(APNAuthenticationEnum apnAuthentication) {
        this.apnAuthentication = apnAuthentication;
    }

    public APN withApnAuthentication(APNAuthenticationEnum apnAuthentication) {
        this.apnAuthentication = apnAuthentication;
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

    public APN withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(APN.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("apn");
        sb.append('=');
        sb.append(((this.apn == null)?"<null>":this.apn));
        sb.append(',');
        sb.append("apnUserName");
        sb.append('=');
        sb.append(((this.apnUserName == null)?"<null>":this.apnUserName));
        sb.append(',');
        sb.append("apnPassword");
        sb.append('=');
        sb.append(((this.apnPassword == null)?"<null>":this.apnPassword));
        sb.append(',');
        sb.append("simPin");
        sb.append('=');
        sb.append(this.simPin);
        sb.append(',');
        sb.append("preferredNetwork");
        sb.append('=');
        sb.append(((this.preferredNetwork == null)?"<null>":this.preferredNetwork));
        sb.append(',');
        sb.append("useOnlyPreferredNetwork");
        sb.append('=');
        sb.append(this.useOnlyPreferredNetwork);
        sb.append(',');
        sb.append("apnAuthentication");
        sb.append('=');
        sb.append(((this.apnAuthentication == null)?"<null>":this.apnAuthentication));
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
        result = ((result* 31)+((this.preferredNetwork == null)? 0 :this.preferredNetwork.hashCode()));
        result = ((result* 31)+((this.apnUserName == null)? 0 :this.apnUserName.hashCode()));
        result = ((result* 31)+((this.apnAuthentication == null)? 0 :this.apnAuthentication.hashCode()));
        result = ((result* 31)+(this.useOnlyPreferredNetwork? 1 : 0));
        result = ((result* 31)+ this.simPin);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.apn == null)? 0 :this.apn.hashCode()));
        result = ((result* 31)+((this.apnPassword == null)? 0 :this.apnPassword.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof APN) == false) {
            return false;
        }
        APN rhs = ((APN) other);
        return (((((((((this.preferredNetwork == rhs.preferredNetwork)||((this.preferredNetwork!= null)&&this.preferredNetwork.equals(rhs.preferredNetwork)))&&((this.apnUserName == rhs.apnUserName)||((this.apnUserName!= null)&&this.apnUserName.equals(rhs.apnUserName))))&&((this.apnAuthentication == rhs.apnAuthentication)||((this.apnAuthentication!= null)&&this.apnAuthentication.equals(rhs.apnAuthentication))))&&(this.useOnlyPreferredNetwork == rhs.useOnlyPreferredNetwork))&&(this.simPin == rhs.simPin))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.apn == rhs.apn)||((this.apn!= null)&&this.apn.equals(rhs.apn))))&&((this.apnPassword == rhs.apnPassword)||((this.apnPassword!= null)&&this.apnPassword.equals(rhs.apnPassword))));
    }

}
