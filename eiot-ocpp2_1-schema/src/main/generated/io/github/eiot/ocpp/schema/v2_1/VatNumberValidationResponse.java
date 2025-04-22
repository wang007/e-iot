
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
    "company",
    "statusInfo",
    "vatNumber",
    "evseId",
    "status",
    "customData"
})
public class VatNumberValidationResponse {

    /**
     * *(2.1)* A generic address format.
     * 
     * 
     */
    @JsonProperty("company")
    @JsonPropertyDescription("*(2.1)* A generic address format.\r\n")
    @Valid
    private Address company;
    /**
     * Element providing more information about the status.
     * 
     * 
     */
    @JsonProperty("statusInfo")
    @JsonPropertyDescription("Element providing more information about the status.\r\n")
    @Valid
    private StatusInfo statusInfo;
    /**
     * VAT number that was requested.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("vatNumber")
    @JsonPropertyDescription("VAT number that was requested.\r\n\r\n")
    @Size(max = 20)
    @NotNull
    private String vatNumber;
    /**
     * EVSE id for which check was requested. 
     * 
     * 
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("EVSE id for which check was requested. \r\n\r\n")
    @DecimalMin("0")
    private int evseId;
    /**
     * Result of operation.
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("Result of operation.\r\n")
    @NotNull
    private GenericStatusEnum status;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * *(2.1)* A generic address format.
     * 
     * 
     */
    @JsonProperty("company")
    public Address getCompany() {
        return company;
    }

    /**
     * *(2.1)* A generic address format.
     * 
     * 
     */
    @JsonProperty("company")
    public void setCompany(Address company) {
        this.company = company;
    }

    public VatNumberValidationResponse withCompany(Address company) {
        this.company = company;
        return this;
    }

    /**
     * Element providing more information about the status.
     * 
     * 
     */
    @JsonProperty("statusInfo")
    public StatusInfo getStatusInfo() {
        return statusInfo;
    }

    /**
     * Element providing more information about the status.
     * 
     * 
     */
    @JsonProperty("statusInfo")
    public void setStatusInfo(StatusInfo statusInfo) {
        this.statusInfo = statusInfo;
    }

    public VatNumberValidationResponse withStatusInfo(StatusInfo statusInfo) {
        this.statusInfo = statusInfo;
        return this;
    }

    /**
     * VAT number that was requested.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("vatNumber")
    public String getVatNumber() {
        return vatNumber;
    }

    /**
     * VAT number that was requested.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("vatNumber")
    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public VatNumberValidationResponse withVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
        return this;
    }

    /**
     * EVSE id for which check was requested. 
     * 
     * 
     * 
     */
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * EVSE id for which check was requested. 
     * 
     * 
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public VatNumberValidationResponse withEvseId(int evseId) {
        this.evseId = evseId;
        return this;
    }

    /**
     * Result of operation.
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public GenericStatusEnum getStatus() {
        return status;
    }

    /**
     * Result of operation.
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public void setStatus(GenericStatusEnum status) {
        this.status = status;
    }

    public VatNumberValidationResponse withStatus(GenericStatusEnum status) {
        this.status = status;
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

    public VatNumberValidationResponse withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VatNumberValidationResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("company");
        sb.append('=');
        sb.append(((this.company == null)?"<null>":this.company));
        sb.append(',');
        sb.append("statusInfo");
        sb.append('=');
        sb.append(((this.statusInfo == null)?"<null>":this.statusInfo));
        sb.append(',');
        sb.append("vatNumber");
        sb.append('=');
        sb.append(((this.vatNumber == null)?"<null>":this.vatNumber));
        sb.append(',');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
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
        result = ((result* 31)+((this.statusInfo == null)? 0 :this.statusInfo.hashCode()));
        result = ((result* 31)+((this.company == null)? 0 :this.company.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.vatNumber == null)? 0 :this.vatNumber.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VatNumberValidationResponse) == false) {
            return false;
        }
        VatNumberValidationResponse rhs = ((VatNumberValidationResponse) other);
        return ((((((this.evseId == rhs.evseId)&&((this.statusInfo == rhs.statusInfo)||((this.statusInfo!= null)&&this.statusInfo.equals(rhs.statusInfo))))&&((this.company == rhs.company)||((this.company!= null)&&this.company.equals(rhs.company))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.vatNumber == rhs.vatNumber)||((this.vatNumber!= null)&&this.vatNumber.equals(rhs.vatNumber))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
