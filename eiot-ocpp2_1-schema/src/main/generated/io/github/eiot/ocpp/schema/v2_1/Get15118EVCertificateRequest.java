
package io.github.eiot.ocpp.schema.v2_1;

import java.util.ArrayList;
import java.util.List;
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
    "iso15118SchemaVersion",
    "action",
    "exiRequest",
    "maximumContractCertificateChains",
    "prioritizedEMAIDs",
    "customData"
})
public class Get15118EVCertificateRequest {

    /**
     * Schema version currently used for the 15118 session between EV and Charging Station. Needed for parsing of the EXI stream by the CSMS.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("iso15118SchemaVersion")
    @JsonPropertyDescription("Schema version currently used for the 15118 session between EV and Charging Station. Needed for parsing of the EXI stream by the CSMS.\r\n\r\n")
    @Size(max = 50)
    @NotNull
    private String iso15118SchemaVersion;
    /**
     * Defines whether certificate needs to be installed or updated.
     * 
     * (Required)
     * 
     */
    @JsonProperty("action")
    @JsonPropertyDescription("Defines whether certificate needs to be installed or updated.\r\n")
    @NotNull
    private CertificateActionEnum action;
    /**
     * *(2.1)* Raw CertificateInstallationReq request from EV, Base64 encoded. +
     * Extended to support ISO 15118-20 certificates. The minimum supported length is 11000. If a longer _exiRequest_ is supported, then the supported length must be communicated in variable OCPPCommCtrlr.FieldLength[ "Get15118EVCertificateRequest.exiRequest" ].
     * 
     * (Required)
     * 
     */
    @JsonProperty("exiRequest")
    @JsonPropertyDescription("*(2.1)* Raw CertificateInstallationReq request from EV, Base64 encoded. +\r\nExtended to support ISO 15118-20 certificates. The minimum supported length is 11000. If a longer _exiRequest_ is supported, then the supported length must be communicated in variable OCPPCommCtrlr.FieldLength[ \"Get15118EVCertificateRequest.exiRequest\" ].\r\n")
    @Size(max = 11000)
    @NotNull
    private String exiRequest;
    /**
     * *(2.1)* Absent during ISO 15118-2 session. Required during ISO 15118-20 session. +
     * Maximum number of contracts that EV wants to install.
     * 
     * 
     */
    @JsonProperty("maximumContractCertificateChains")
    @JsonPropertyDescription("*(2.1)* Absent during ISO 15118-2 session. Required during ISO 15118-20 session. +\r\nMaximum number of contracts that EV wants to install.\r\n")
    @DecimalMin("0")
    private int maximumContractCertificateChains;
    /**
     * *(2.1)*  Absent during ISO 15118-2 session. Optional during ISO 15118-20 session. List of EMAIDs for which contract certificates must be requested first, in case there are more certificates than allowed by _maximumContractCertificateChains_.
     * 
     * 
     */
    @JsonProperty("prioritizedEMAIDs")
    @JsonPropertyDescription("*(2.1)*  Absent during ISO 15118-2 session. Optional during ISO 15118-20 session. List of EMAIDs for which contract certificates must be requested first, in case there are more certificates than allowed by _maximumContractCertificateChains_.\r\n")
    @Size(min = 1, max = 8)
    @Valid
    private List<String> prioritizedEMAIDs = new ArrayList<String>();
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Schema version currently used for the 15118 session between EV and Charging Station. Needed for parsing of the EXI stream by the CSMS.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("iso15118SchemaVersion")
    public String getIso15118SchemaVersion() {
        return iso15118SchemaVersion;
    }

    /**
     * Schema version currently used for the 15118 session between EV and Charging Station. Needed for parsing of the EXI stream by the CSMS.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("iso15118SchemaVersion")
    public void setIso15118SchemaVersion(String iso15118SchemaVersion) {
        this.iso15118SchemaVersion = iso15118SchemaVersion;
    }

    public Get15118EVCertificateRequest withIso15118SchemaVersion(String iso15118SchemaVersion) {
        this.iso15118SchemaVersion = iso15118SchemaVersion;
        return this;
    }

    /**
     * Defines whether certificate needs to be installed or updated.
     * 
     * (Required)
     * 
     */
    @JsonProperty("action")
    public CertificateActionEnum getAction() {
        return action;
    }

    /**
     * Defines whether certificate needs to be installed or updated.
     * 
     * (Required)
     * 
     */
    @JsonProperty("action")
    public void setAction(CertificateActionEnum action) {
        this.action = action;
    }

    public Get15118EVCertificateRequest withAction(CertificateActionEnum action) {
        this.action = action;
        return this;
    }

    /**
     * *(2.1)* Raw CertificateInstallationReq request from EV, Base64 encoded. +
     * Extended to support ISO 15118-20 certificates. The minimum supported length is 11000. If a longer _exiRequest_ is supported, then the supported length must be communicated in variable OCPPCommCtrlr.FieldLength[ "Get15118EVCertificateRequest.exiRequest" ].
     * 
     * (Required)
     * 
     */
    @JsonProperty("exiRequest")
    public String getExiRequest() {
        return exiRequest;
    }

    /**
     * *(2.1)* Raw CertificateInstallationReq request from EV, Base64 encoded. +
     * Extended to support ISO 15118-20 certificates. The minimum supported length is 11000. If a longer _exiRequest_ is supported, then the supported length must be communicated in variable OCPPCommCtrlr.FieldLength[ "Get15118EVCertificateRequest.exiRequest" ].
     * 
     * (Required)
     * 
     */
    @JsonProperty("exiRequest")
    public void setExiRequest(String exiRequest) {
        this.exiRequest = exiRequest;
    }

    public Get15118EVCertificateRequest withExiRequest(String exiRequest) {
        this.exiRequest = exiRequest;
        return this;
    }

    /**
     * *(2.1)* Absent during ISO 15118-2 session. Required during ISO 15118-20 session. +
     * Maximum number of contracts that EV wants to install.
     * 
     * 
     */
    @JsonProperty("maximumContractCertificateChains")
    public int getMaximumContractCertificateChains() {
        return maximumContractCertificateChains;
    }

    /**
     * *(2.1)* Absent during ISO 15118-2 session. Required during ISO 15118-20 session. +
     * Maximum number of contracts that EV wants to install.
     * 
     * 
     */
    @JsonProperty("maximumContractCertificateChains")
    public void setMaximumContractCertificateChains(int maximumContractCertificateChains) {
        this.maximumContractCertificateChains = maximumContractCertificateChains;
    }

    public Get15118EVCertificateRequest withMaximumContractCertificateChains(int maximumContractCertificateChains) {
        this.maximumContractCertificateChains = maximumContractCertificateChains;
        return this;
    }

    /**
     * *(2.1)*  Absent during ISO 15118-2 session. Optional during ISO 15118-20 session. List of EMAIDs for which contract certificates must be requested first, in case there are more certificates than allowed by _maximumContractCertificateChains_.
     * 
     * 
     */
    @JsonProperty("prioritizedEMAIDs")
    public List<String> getPrioritizedEMAIDs() {
        return prioritizedEMAIDs;
    }

    /**
     * *(2.1)*  Absent during ISO 15118-2 session. Optional during ISO 15118-20 session. List of EMAIDs for which contract certificates must be requested first, in case there are more certificates than allowed by _maximumContractCertificateChains_.
     * 
     * 
     */
    @JsonProperty("prioritizedEMAIDs")
    public void setPrioritizedEMAIDs(List<String> prioritizedEMAIDs) {
        this.prioritizedEMAIDs = prioritizedEMAIDs;
    }

    public Get15118EVCertificateRequest withPrioritizedEMAIDs(List<String> prioritizedEMAIDs) {
        this.prioritizedEMAIDs = prioritizedEMAIDs;
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

    public Get15118EVCertificateRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Get15118EVCertificateRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("iso15118SchemaVersion");
        sb.append('=');
        sb.append(((this.iso15118SchemaVersion == null)?"<null>":this.iso15118SchemaVersion));
        sb.append(',');
        sb.append("action");
        sb.append('=');
        sb.append(((this.action == null)?"<null>":this.action));
        sb.append(',');
        sb.append("exiRequest");
        sb.append('=');
        sb.append(((this.exiRequest == null)?"<null>":this.exiRequest));
        sb.append(',');
        sb.append("maximumContractCertificateChains");
        sb.append('=');
        sb.append(this.maximumContractCertificateChains);
        sb.append(',');
        sb.append("prioritizedEMAIDs");
        sb.append('=');
        sb.append(((this.prioritizedEMAIDs == null)?"<null>":this.prioritizedEMAIDs));
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
        result = ((result* 31)+((this.iso15118SchemaVersion == null)? 0 :this.iso15118SchemaVersion.hashCode()));
        result = ((result* 31)+((this.prioritizedEMAIDs == null)? 0 :this.prioritizedEMAIDs.hashCode()));
        result = ((result* 31)+((this.action == null)? 0 :this.action.hashCode()));
        result = ((result* 31)+((this.exiRequest == null)? 0 :this.exiRequest.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.maximumContractCertificateChains);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Get15118EVCertificateRequest) == false) {
            return false;
        }
        Get15118EVCertificateRequest rhs = ((Get15118EVCertificateRequest) other);
        return (((((((this.iso15118SchemaVersion == rhs.iso15118SchemaVersion)||((this.iso15118SchemaVersion!= null)&&this.iso15118SchemaVersion.equals(rhs.iso15118SchemaVersion)))&&((this.prioritizedEMAIDs == rhs.prioritizedEMAIDs)||((this.prioritizedEMAIDs!= null)&&this.prioritizedEMAIDs.equals(rhs.prioritizedEMAIDs))))&&((this.action == rhs.action)||((this.action!= null)&&this.action.equals(rhs.action))))&&((this.exiRequest == rhs.exiRequest)||((this.exiRequest!= null)&&this.exiRequest.equals(rhs.exiRequest))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.maximumContractCertificateChains == rhs.maximumContractCertificateChains));
    }

}
