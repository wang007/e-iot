
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * The NetworkConnectionProfile defines the functional and technical parameters of a communication link.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apn",
    "ocppVersion",
    "ocppInterface",
    "ocppTransport",
    "messageTimeout",
    "ocppCsmsUrl",
    "securityProfile",
    "identity",
    "basicAuthPassword",
    "vpn",
    "customData"
})
public class NetworkConnectionProfile {

    /**
     * Collection of configuration data needed to make a data-connection over a cellular network.
     * 
     * NOTE: When asking a GSM modem to dial in, it is possible to specify which mobile operator should be used. This can be done with the mobile country code (MCC) in combination with a mobile network code (MNC). Example: If your preferred network is Vodafone Netherlands, the MCC=204 and the MNC=04 which means the key PreferredNetwork = 20404 Some modems allows to specify a preferred network, which means, if this network is not available, a different network is used. If you specify UseOnlyPreferredNetwork and this network is not available, the modem will not dial in.
     * 
     * 
     */
    @JsonProperty("apn")
    @JsonPropertyDescription("Collection of configuration data needed to make a data-connection over a cellular network.\r\n\r\nNOTE: When asking a GSM modem to dial in, it is possible to specify which mobile operator should be used. This can be done with the mobile country code (MCC) in combination with a mobile network code (MNC). Example: If your preferred network is Vodafone Netherlands, the MCC=204 and the MNC=04 which means the key PreferredNetwork = 20404 Some modems allows to specify a preferred network, which means, if this network is not available, a different network is used. If you specify UseOnlyPreferredNetwork and this network is not available, the modem will not dial in.\r\n")
    @Valid
    private APN apn;
    /**
     * *(2.1)* This field is ignored, since the OCPP version to use is determined during the websocket handshake. The field is only kept for backwards compatibility with the OCPP 2.0.1 JSON schema.
     * 
     * 
     */
    @JsonProperty("ocppVersion")
    @JsonPropertyDescription("*(2.1)* This field is ignored, since the OCPP version to use is determined during the websocket handshake. The field is only kept for backwards compatibility with the OCPP 2.0.1 JSON schema.\r\n")
    private OCPPVersionEnum ocppVersion;
    /**
     * Applicable Network Interface. Charging Station is allowed to use a different network interface to connect if the given one does not work.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocppInterface")
    @JsonPropertyDescription("Applicable Network Interface. Charging Station is allowed to use a different network interface to connect if the given one does not work.\r\n")
    @NotNull
    private OCPPInterfaceEnum ocppInterface;
    /**
     * Defines the transport protocol (e.g. SOAP or JSON). Note: SOAP is not supported in OCPP 2.x, but is supported by earlier versions of OCPP.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocppTransport")
    @JsonPropertyDescription("Defines the transport protocol (e.g. SOAP or JSON). Note: SOAP is not supported in OCPP 2.x, but is supported by earlier versions of OCPP.\r\n")
    @NotNull
    private OCPPTransportEnum ocppTransport;
    /**
     * Duration in seconds before a message send by the Charging Station via this network connection times-out.
     * The best setting depends on the underlying network and response times of the CSMS.
     * If you are looking for a some guideline: use 30 seconds as a starting point.
     * 
     * (Required)
     * 
     */
    @JsonProperty("messageTimeout")
    @JsonPropertyDescription("Duration in seconds before a message send by the Charging Station via this network connection times-out.\r\nThe best setting depends on the underlying network and response times of the CSMS.\r\nIf you are looking for a some guideline: use 30 seconds as a starting point.\r\n")
    @NotNull
    private int messageTimeout;
    /**
     * URL of the CSMS(s) that this Charging Station communicates with, without the Charging Station identity part. +
     * The SecurityCtrlr.Identity field is appended to _ocppCsmsUrl_ to provide the full websocket URL.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocppCsmsUrl")
    @JsonPropertyDescription("URL of the CSMS(s) that this Charging Station communicates with, without the Charging Station identity part. +\r\nThe SecurityCtrlr.Identity field is appended to _ocppCsmsUrl_ to provide the full websocket URL.\r\n")
    @Size(max = 2000)
    @NotNull
    private String ocppCsmsUrl;
    /**
     * This field specifies the security profile used when connecting to the CSMS with this NetworkConnectionProfile.
     * 
     * (Required)
     * 
     */
    @JsonProperty("securityProfile")
    @JsonPropertyDescription("This field specifies the security profile used when connecting to the CSMS with this NetworkConnectionProfile.\r\n")
    @DecimalMin("0")
    @NotNull
    private int securityProfile;
    /**
     * *(2.1)* Charging Station identity to be used as the basic authentication username.
     * 
     * 
     */
    @JsonProperty("identity")
    @JsonPropertyDescription("*(2.1)* Charging Station identity to be used as the basic authentication username.\r\n")
    @Size(max = 48)
    private String identity;
    /**
     * *(2.1)* BasicAuthPassword to use for security profile 1 or 2.
     * 
     * 
     */
    @JsonProperty("basicAuthPassword")
    @JsonPropertyDescription("*(2.1)* BasicAuthPassword to use for security profile 1 or 2.\r\n")
    @Size(max = 64)
    private String basicAuthPassword;
    /**
     * VPN Configuration settings
     * 
     * 
     */
    @JsonProperty("vpn")
    @JsonPropertyDescription("VPN Configuration settings\r\n")
    @Valid
    private VPN vpn;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Collection of configuration data needed to make a data-connection over a cellular network.
     * 
     * NOTE: When asking a GSM modem to dial in, it is possible to specify which mobile operator should be used. This can be done with the mobile country code (MCC) in combination with a mobile network code (MNC). Example: If your preferred network is Vodafone Netherlands, the MCC=204 and the MNC=04 which means the key PreferredNetwork = 20404 Some modems allows to specify a preferred network, which means, if this network is not available, a different network is used. If you specify UseOnlyPreferredNetwork and this network is not available, the modem will not dial in.
     * 
     * 
     */
    @JsonProperty("apn")
    public APN getApn() {
        return apn;
    }

    /**
     * Collection of configuration data needed to make a data-connection over a cellular network.
     * 
     * NOTE: When asking a GSM modem to dial in, it is possible to specify which mobile operator should be used. This can be done with the mobile country code (MCC) in combination with a mobile network code (MNC). Example: If your preferred network is Vodafone Netherlands, the MCC=204 and the MNC=04 which means the key PreferredNetwork = 20404 Some modems allows to specify a preferred network, which means, if this network is not available, a different network is used. If you specify UseOnlyPreferredNetwork and this network is not available, the modem will not dial in.
     * 
     * 
     */
    @JsonProperty("apn")
    public void setApn(APN apn) {
        this.apn = apn;
    }

    public NetworkConnectionProfile withApn(APN apn) {
        this.apn = apn;
        return this;
    }

    /**
     * *(2.1)* This field is ignored, since the OCPP version to use is determined during the websocket handshake. The field is only kept for backwards compatibility with the OCPP 2.0.1 JSON schema.
     * 
     * 
     */
    @JsonProperty("ocppVersion")
    public OCPPVersionEnum getOcppVersion() {
        return ocppVersion;
    }

    /**
     * *(2.1)* This field is ignored, since the OCPP version to use is determined during the websocket handshake. The field is only kept for backwards compatibility with the OCPP 2.0.1 JSON schema.
     * 
     * 
     */
    @JsonProperty("ocppVersion")
    public void setOcppVersion(OCPPVersionEnum ocppVersion) {
        this.ocppVersion = ocppVersion;
    }

    public NetworkConnectionProfile withOcppVersion(OCPPVersionEnum ocppVersion) {
        this.ocppVersion = ocppVersion;
        return this;
    }

    /**
     * Applicable Network Interface. Charging Station is allowed to use a different network interface to connect if the given one does not work.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocppInterface")
    public OCPPInterfaceEnum getOcppInterface() {
        return ocppInterface;
    }

    /**
     * Applicable Network Interface. Charging Station is allowed to use a different network interface to connect if the given one does not work.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocppInterface")
    public void setOcppInterface(OCPPInterfaceEnum ocppInterface) {
        this.ocppInterface = ocppInterface;
    }

    public NetworkConnectionProfile withOcppInterface(OCPPInterfaceEnum ocppInterface) {
        this.ocppInterface = ocppInterface;
        return this;
    }

    /**
     * Defines the transport protocol (e.g. SOAP or JSON). Note: SOAP is not supported in OCPP 2.x, but is supported by earlier versions of OCPP.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocppTransport")
    public OCPPTransportEnum getOcppTransport() {
        return ocppTransport;
    }

    /**
     * Defines the transport protocol (e.g. SOAP or JSON). Note: SOAP is not supported in OCPP 2.x, but is supported by earlier versions of OCPP.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocppTransport")
    public void setOcppTransport(OCPPTransportEnum ocppTransport) {
        this.ocppTransport = ocppTransport;
    }

    public NetworkConnectionProfile withOcppTransport(OCPPTransportEnum ocppTransport) {
        this.ocppTransport = ocppTransport;
        return this;
    }

    /**
     * Duration in seconds before a message send by the Charging Station via this network connection times-out.
     * The best setting depends on the underlying network and response times of the CSMS.
     * If you are looking for a some guideline: use 30 seconds as a starting point.
     * 
     * (Required)
     * 
     */
    @JsonProperty("messageTimeout")
    public int getMessageTimeout() {
        return messageTimeout;
    }

    /**
     * Duration in seconds before a message send by the Charging Station via this network connection times-out.
     * The best setting depends on the underlying network and response times of the CSMS.
     * If you are looking for a some guideline: use 30 seconds as a starting point.
     * 
     * (Required)
     * 
     */
    @JsonProperty("messageTimeout")
    public void setMessageTimeout(int messageTimeout) {
        this.messageTimeout = messageTimeout;
    }

    public NetworkConnectionProfile withMessageTimeout(int messageTimeout) {
        this.messageTimeout = messageTimeout;
        return this;
    }

    /**
     * URL of the CSMS(s) that this Charging Station communicates with, without the Charging Station identity part. +
     * The SecurityCtrlr.Identity field is appended to _ocppCsmsUrl_ to provide the full websocket URL.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocppCsmsUrl")
    public String getOcppCsmsUrl() {
        return ocppCsmsUrl;
    }

    /**
     * URL of the CSMS(s) that this Charging Station communicates with, without the Charging Station identity part. +
     * The SecurityCtrlr.Identity field is appended to _ocppCsmsUrl_ to provide the full websocket URL.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocppCsmsUrl")
    public void setOcppCsmsUrl(String ocppCsmsUrl) {
        this.ocppCsmsUrl = ocppCsmsUrl;
    }

    public NetworkConnectionProfile withOcppCsmsUrl(String ocppCsmsUrl) {
        this.ocppCsmsUrl = ocppCsmsUrl;
        return this;
    }

    /**
     * This field specifies the security profile used when connecting to the CSMS with this NetworkConnectionProfile.
     * 
     * (Required)
     * 
     */
    @JsonProperty("securityProfile")
    public int getSecurityProfile() {
        return securityProfile;
    }

    /**
     * This field specifies the security profile used when connecting to the CSMS with this NetworkConnectionProfile.
     * 
     * (Required)
     * 
     */
    @JsonProperty("securityProfile")
    public void setSecurityProfile(int securityProfile) {
        this.securityProfile = securityProfile;
    }

    public NetworkConnectionProfile withSecurityProfile(int securityProfile) {
        this.securityProfile = securityProfile;
        return this;
    }

    /**
     * *(2.1)* Charging Station identity to be used as the basic authentication username.
     * 
     * 
     */
    @JsonProperty("identity")
    public String getIdentity() {
        return identity;
    }

    /**
     * *(2.1)* Charging Station identity to be used as the basic authentication username.
     * 
     * 
     */
    @JsonProperty("identity")
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public NetworkConnectionProfile withIdentity(String identity) {
        this.identity = identity;
        return this;
    }

    /**
     * *(2.1)* BasicAuthPassword to use for security profile 1 or 2.
     * 
     * 
     */
    @JsonProperty("basicAuthPassword")
    public String getBasicAuthPassword() {
        return basicAuthPassword;
    }

    /**
     * *(2.1)* BasicAuthPassword to use for security profile 1 or 2.
     * 
     * 
     */
    @JsonProperty("basicAuthPassword")
    public void setBasicAuthPassword(String basicAuthPassword) {
        this.basicAuthPassword = basicAuthPassword;
    }

    public NetworkConnectionProfile withBasicAuthPassword(String basicAuthPassword) {
        this.basicAuthPassword = basicAuthPassword;
        return this;
    }

    /**
     * VPN Configuration settings
     * 
     * 
     */
    @JsonProperty("vpn")
    public VPN getVpn() {
        return vpn;
    }

    /**
     * VPN Configuration settings
     * 
     * 
     */
    @JsonProperty("vpn")
    public void setVpn(VPN vpn) {
        this.vpn = vpn;
    }

    public NetworkConnectionProfile withVpn(VPN vpn) {
        this.vpn = vpn;
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

    public NetworkConnectionProfile withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NetworkConnectionProfile.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("apn");
        sb.append('=');
        sb.append(((this.apn == null)?"<null>":this.apn));
        sb.append(',');
        sb.append("ocppVersion");
        sb.append('=');
        sb.append(((this.ocppVersion == null)?"<null>":this.ocppVersion));
        sb.append(',');
        sb.append("ocppInterface");
        sb.append('=');
        sb.append(((this.ocppInterface == null)?"<null>":this.ocppInterface));
        sb.append(',');
        sb.append("ocppTransport");
        sb.append('=');
        sb.append(((this.ocppTransport == null)?"<null>":this.ocppTransport));
        sb.append(',');
        sb.append("messageTimeout");
        sb.append('=');
        sb.append(this.messageTimeout);
        sb.append(',');
        sb.append("ocppCsmsUrl");
        sb.append('=');
        sb.append(((this.ocppCsmsUrl == null)?"<null>":this.ocppCsmsUrl));
        sb.append(',');
        sb.append("securityProfile");
        sb.append('=');
        sb.append(this.securityProfile);
        sb.append(',');
        sb.append("identity");
        sb.append('=');
        sb.append(((this.identity == null)?"<null>":this.identity));
        sb.append(',');
        sb.append("basicAuthPassword");
        sb.append('=');
        sb.append(((this.basicAuthPassword == null)?"<null>":this.basicAuthPassword));
        sb.append(',');
        sb.append("vpn");
        sb.append('=');
        sb.append(((this.vpn == null)?"<null>":this.vpn));
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
        result = ((result* 31)+((this.ocppTransport == null)? 0 :this.ocppTransport.hashCode()));
        result = ((result* 31)+ this.securityProfile);
        result = ((result* 31)+((this.vpn == null)? 0 :this.vpn.hashCode()));
        result = ((result* 31)+((this.ocppVersion == null)? 0 :this.ocppVersion.hashCode()));
        result = ((result* 31)+((this.identity == null)? 0 :this.identity.hashCode()));
        result = ((result* 31)+((this.basicAuthPassword == null)? 0 :this.basicAuthPassword.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.ocppCsmsUrl == null)? 0 :this.ocppCsmsUrl.hashCode()));
        result = ((result* 31)+((this.apn == null)? 0 :this.apn.hashCode()));
        result = ((result* 31)+((this.ocppInterface == null)? 0 :this.ocppInterface.hashCode()));
        result = ((result* 31)+ this.messageTimeout);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NetworkConnectionProfile) == false) {
            return false;
        }
        NetworkConnectionProfile rhs = ((NetworkConnectionProfile) other);
        return ((((((((((((this.ocppTransport == rhs.ocppTransport)||((this.ocppTransport!= null)&&this.ocppTransport.equals(rhs.ocppTransport)))&&(this.securityProfile == rhs.securityProfile))&&((this.vpn == rhs.vpn)||((this.vpn!= null)&&this.vpn.equals(rhs.vpn))))&&((this.ocppVersion == rhs.ocppVersion)||((this.ocppVersion!= null)&&this.ocppVersion.equals(rhs.ocppVersion))))&&((this.identity == rhs.identity)||((this.identity!= null)&&this.identity.equals(rhs.identity))))&&((this.basicAuthPassword == rhs.basicAuthPassword)||((this.basicAuthPassword!= null)&&this.basicAuthPassword.equals(rhs.basicAuthPassword))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.ocppCsmsUrl == rhs.ocppCsmsUrl)||((this.ocppCsmsUrl!= null)&&this.ocppCsmsUrl.equals(rhs.ocppCsmsUrl))))&&((this.apn == rhs.apn)||((this.apn!= null)&&this.apn.equals(rhs.apn))))&&((this.ocppInterface == rhs.ocppInterface)||((this.ocppInterface!= null)&&this.ocppInterface.equals(rhs.ocppInterface))))&&(this.messageTimeout == rhs.messageTimeout));
    }

}
