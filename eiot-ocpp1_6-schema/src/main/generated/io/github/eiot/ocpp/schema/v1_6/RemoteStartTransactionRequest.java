
package io.github.eiot.ocpp.schema.v1_6;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * RemoteStartTransactionRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectorId",
    "idTag",
    "chargingProfile"
})
public class RemoteStartTransactionRequest {

    @JsonProperty("connectorId")
    private int connectorId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTag")
    @Size(max = 20)
    @NotNull
    private String idTag;
    @JsonProperty("chargingProfile")
    @Valid
    private ChargingProfile chargingProfile;

    @JsonProperty("connectorId")
    public int getConnectorId() {
        return connectorId;
    }

    @JsonProperty("connectorId")
    public void setConnectorId(int connectorId) {
        this.connectorId = connectorId;
    }

    public RemoteStartTransactionRequest withConnectorId(int connectorId) {
        this.connectorId = connectorId;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTag")
    public String getIdTag() {
        return idTag;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTag")
    public void setIdTag(String idTag) {
        this.idTag = idTag;
    }

    public RemoteStartTransactionRequest withIdTag(String idTag) {
        this.idTag = idTag;
        return this;
    }

    @JsonProperty("chargingProfile")
    public ChargingProfile getChargingProfile() {
        return chargingProfile;
    }

    @JsonProperty("chargingProfile")
    public void setChargingProfile(ChargingProfile chargingProfile) {
        this.chargingProfile = chargingProfile;
    }

    public RemoteStartTransactionRequest withChargingProfile(ChargingProfile chargingProfile) {
        this.chargingProfile = chargingProfile;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RemoteStartTransactionRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("connectorId");
        sb.append('=');
        sb.append(this.connectorId);
        sb.append(',');
        sb.append("idTag");
        sb.append('=');
        sb.append(((this.idTag == null)?"<null>":this.idTag));
        sb.append(',');
        sb.append("chargingProfile");
        sb.append('=');
        sb.append(((this.chargingProfile == null)?"<null>":this.chargingProfile));
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
        result = ((result* 31)+((this.chargingProfile == null)? 0 :this.chargingProfile.hashCode()));
        result = ((result* 31)+((this.idTag == null)? 0 :this.idTag.hashCode()));
        result = ((result* 31)+ this.connectorId);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RemoteStartTransactionRequest) == false) {
            return false;
        }
        RemoteStartTransactionRequest rhs = ((RemoteStartTransactionRequest) other);
        return ((((this.chargingProfile == rhs.chargingProfile)||((this.chargingProfile!= null)&&this.chargingProfile.equals(rhs.chargingProfile)))&&((this.idTag == rhs.idTag)||((this.idTag!= null)&&this.idTag.equals(rhs.idTag))))&&(this.connectorId == rhs.connectorId));
    }

}
