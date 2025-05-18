
package io.github.eiot.ocpp.schema.v2_1;

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
    "idTokenInfo",
    "certificateStatus",
    "allowedEnergyTransfer",
    "tariff",
    "customData"
})
public class AuthorizeResponse {

    /**
     * Contains status information about an identifier.
     * It is advised to not stop charging for a token that expires during charging, as ExpiryDate is only used for caching purposes. If ExpiryDate is not given, the status has no end date.
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTokenInfo")
    @JsonPropertyDescription("Contains status information about an identifier.\r\nIt is advised to not stop charging for a token that expires during charging, as ExpiryDate is only used for caching purposes. If ExpiryDate is not given, the status has no end date.\r\n")
    @Valid
    @NotNull
    private IdTokenInfo idTokenInfo;
    /**
     * Certificate status information. 
     * - if all certificates are valid: return 'Accepted'.
     * - if one of the certificates was revoked, return 'CertificateRevoked'.
     * 
     * 
     */
    @JsonProperty("certificateStatus")
    @JsonPropertyDescription("Certificate status information. \r\n- if all certificates are valid: return 'Accepted'.\r\n- if one of the certificates was revoked, return 'CertificateRevoked'.\r\n")
    private AuthorizeCertificateStatusEnum certificateStatus;
    /**
     * *(2.1)* List of allowed energy transfer modes the EV can choose from. If omitted this defaults to charging only.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("allowedEnergyTransfer")
    @JsonPropertyDescription("*(2.1)* List of allowed energy transfer modes the EV can choose from. If omitted this defaults to charging only.\r\n\r\n\r\n")
    @Size(min = 1)
    @Valid
    private List<EnergyTransferModeEnum> allowedEnergyTransfer = new ArrayList<EnergyTransferModeEnum>();
    /**
     * A tariff is described by fields with prices for:
     * energy,
     * charging time,
     * idle time,
     * fixed fee,
     * reservation time,
     * reservation fixed fee. +
     * Each of these fields may have (optional) conditions that specify when a price is applicable. +
     * The _description_ contains a human-readable explanation of the tariff to be shown to the user. +
     * The other fields are parameters that define the tariff. These are used by the charging station to calculate the price.
     * 
     * 
     */
    @JsonProperty("tariff")
    @JsonPropertyDescription("A tariff is described by fields with prices for:\r\nenergy,\r\ncharging time,\r\nidle time,\r\nfixed fee,\r\nreservation time,\r\nreservation fixed fee. +\r\nEach of these fields may have (optional) conditions that specify when a price is applicable. +\r\nThe _description_ contains a human-readable explanation of the tariff to be shown to the user. +\r\nThe other fields are parameters that define the tariff. These are used by the charging station to calculate the price.\r\n")
    @Valid
    private Tariff tariff;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Contains status information about an identifier.
     * It is advised to not stop charging for a token that expires during charging, as ExpiryDate is only used for caching purposes. If ExpiryDate is not given, the status has no end date.
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTokenInfo")
    public IdTokenInfo getIdTokenInfo() {
        return idTokenInfo;
    }

    /**
     * Contains status information about an identifier.
     * It is advised to not stop charging for a token that expires during charging, as ExpiryDate is only used for caching purposes. If ExpiryDate is not given, the status has no end date.
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTokenInfo")
    public void setIdTokenInfo(IdTokenInfo idTokenInfo) {
        this.idTokenInfo = idTokenInfo;
    }

    public AuthorizeResponse withIdTokenInfo(IdTokenInfo idTokenInfo) {
        this.idTokenInfo = idTokenInfo;
        return this;
    }

    /**
     * Certificate status information. 
     * - if all certificates are valid: return 'Accepted'.
     * - if one of the certificates was revoked, return 'CertificateRevoked'.
     * 
     * 
     */
    @JsonProperty("certificateStatus")
    public AuthorizeCertificateStatusEnum getCertificateStatus() {
        return certificateStatus;
    }

    /**
     * Certificate status information. 
     * - if all certificates are valid: return 'Accepted'.
     * - if one of the certificates was revoked, return 'CertificateRevoked'.
     * 
     * 
     */
    @JsonProperty("certificateStatus")
    public void setCertificateStatus(AuthorizeCertificateStatusEnum certificateStatus) {
        this.certificateStatus = certificateStatus;
    }

    public AuthorizeResponse withCertificateStatus(AuthorizeCertificateStatusEnum certificateStatus) {
        this.certificateStatus = certificateStatus;
        return this;
    }

    /**
     * *(2.1)* List of allowed energy transfer modes the EV can choose from. If omitted this defaults to charging only.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("allowedEnergyTransfer")
    public List<EnergyTransferModeEnum> getAllowedEnergyTransfer() {
        return allowedEnergyTransfer;
    }

    /**
     * *(2.1)* List of allowed energy transfer modes the EV can choose from. If omitted this defaults to charging only.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("allowedEnergyTransfer")
    public void setAllowedEnergyTransfer(List<EnergyTransferModeEnum> allowedEnergyTransfer) {
        this.allowedEnergyTransfer = allowedEnergyTransfer;
    }

    public AuthorizeResponse withAllowedEnergyTransfer(List<EnergyTransferModeEnum> allowedEnergyTransfer) {
        this.allowedEnergyTransfer = allowedEnergyTransfer;
        return this;
    }

    /**
     * A tariff is described by fields with prices for:
     * energy,
     * charging time,
     * idle time,
     * fixed fee,
     * reservation time,
     * reservation fixed fee. +
     * Each of these fields may have (optional) conditions that specify when a price is applicable. +
     * The _description_ contains a human-readable explanation of the tariff to be shown to the user. +
     * The other fields are parameters that define the tariff. These are used by the charging station to calculate the price.
     * 
     * 
     */
    @JsonProperty("tariff")
    public Tariff getTariff() {
        return tariff;
    }

    /**
     * A tariff is described by fields with prices for:
     * energy,
     * charging time,
     * idle time,
     * fixed fee,
     * reservation time,
     * reservation fixed fee. +
     * Each of these fields may have (optional) conditions that specify when a price is applicable. +
     * The _description_ contains a human-readable explanation of the tariff to be shown to the user. +
     * The other fields are parameters that define the tariff. These are used by the charging station to calculate the price.
     * 
     * 
     */
    @JsonProperty("tariff")
    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public AuthorizeResponse withTariff(Tariff tariff) {
        this.tariff = tariff;
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

    public AuthorizeResponse withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AuthorizeResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("idTokenInfo");
        sb.append('=');
        sb.append(((this.idTokenInfo == null)?"<null>":this.idTokenInfo));
        sb.append(',');
        sb.append("certificateStatus");
        sb.append('=');
        sb.append(((this.certificateStatus == null)?"<null>":this.certificateStatus));
        sb.append(',');
        sb.append("allowedEnergyTransfer");
        sb.append('=');
        sb.append(((this.allowedEnergyTransfer == null)?"<null>":this.allowedEnergyTransfer));
        sb.append(',');
        sb.append("tariff");
        sb.append('=');
        sb.append(((this.tariff == null)?"<null>":this.tariff));
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
        result = ((result* 31)+((this.tariff == null)? 0 :this.tariff.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.certificateStatus == null)? 0 :this.certificateStatus.hashCode()));
        result = ((result* 31)+((this.allowedEnergyTransfer == null)? 0 :this.allowedEnergyTransfer.hashCode()));
        result = ((result* 31)+((this.idTokenInfo == null)? 0 :this.idTokenInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AuthorizeResponse) == false) {
            return false;
        }
        AuthorizeResponse rhs = ((AuthorizeResponse) other);
        return ((((((this.tariff == rhs.tariff)||((this.tariff!= null)&&this.tariff.equals(rhs.tariff)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.certificateStatus == rhs.certificateStatus)||((this.certificateStatus!= null)&&this.certificateStatus.equals(rhs.certificateStatus))))&&((this.allowedEnergyTransfer == rhs.allowedEnergyTransfer)||((this.allowedEnergyTransfer!= null)&&this.allowedEnergyTransfer.equals(rhs.allowedEnergyTransfer))))&&((this.idTokenInfo == rhs.idTokenInfo)||((this.idTokenInfo!= null)&&this.idTokenInfo.equals(rhs.idTokenInfo))));
    }

}
