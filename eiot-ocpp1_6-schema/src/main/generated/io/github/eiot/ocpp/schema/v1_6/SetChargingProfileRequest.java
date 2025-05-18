
package io.github.eiot.ocpp.schema.v1_6;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * SetChargingProfileRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectorId",
    "csChargingProfiles"
})
public class SetChargingProfileRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("connectorId")
    @NotNull
    private int connectorId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("csChargingProfiles")
    @Valid
    @NotNull
    private CsChargingProfiles csChargingProfiles;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("connectorId")
    public int getConnectorId() {
        return connectorId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("connectorId")
    public void setConnectorId(int connectorId) {
        this.connectorId = connectorId;
    }

    public SetChargingProfileRequest withConnectorId(int connectorId) {
        this.connectorId = connectorId;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("csChargingProfiles")
    public CsChargingProfiles getCsChargingProfiles() {
        return csChargingProfiles;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("csChargingProfiles")
    public void setCsChargingProfiles(CsChargingProfiles csChargingProfiles) {
        this.csChargingProfiles = csChargingProfiles;
    }

    public SetChargingProfileRequest withCsChargingProfiles(CsChargingProfiles csChargingProfiles) {
        this.csChargingProfiles = csChargingProfiles;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SetChargingProfileRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("connectorId");
        sb.append('=');
        sb.append(this.connectorId);
        sb.append(',');
        sb.append("csChargingProfiles");
        sb.append('=');
        sb.append(((this.csChargingProfiles == null)?"<null>":this.csChargingProfiles));
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
        result = ((result* 31)+((this.csChargingProfiles == null)? 0 :this.csChargingProfiles.hashCode()));
        result = ((result* 31)+ this.connectorId);
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
        return (((this.csChargingProfiles == rhs.csChargingProfiles)||((this.csChargingProfiles!= null)&&this.csChargingProfiles.equals(rhs.csChargingProfiles)))&&(this.connectorId == rhs.connectorId));
    }

}
