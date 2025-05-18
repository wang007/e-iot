
package io.github.eiot.ocpp.schema.v1_6;

import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * ReserveNowRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectorId",
    "expiryDate",
    "idTag",
    "parentIdTag",
    "reservationId"
})
public class ReserveNowRequest {

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
    @JsonProperty("expiryDate")
    @NotNull
    private ZonedDateTime expiryDate;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTag")
    @Size(max = 20)
    @NotNull
    private String idTag;
    @JsonProperty("parentIdTag")
    @Size(max = 20)
    private String parentIdTag;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reservationId")
    @NotNull
    private int reservationId;

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

    public ReserveNowRequest withConnectorId(int connectorId) {
        this.connectorId = connectorId;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("expiryDate")
    public ZonedDateTime getExpiryDate() {
        return expiryDate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("expiryDate")
    public void setExpiryDate(ZonedDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public ReserveNowRequest withExpiryDate(ZonedDateTime expiryDate) {
        this.expiryDate = expiryDate;
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

    public ReserveNowRequest withIdTag(String idTag) {
        this.idTag = idTag;
        return this;
    }

    @JsonProperty("parentIdTag")
    public String getParentIdTag() {
        return parentIdTag;
    }

    @JsonProperty("parentIdTag")
    public void setParentIdTag(String parentIdTag) {
        this.parentIdTag = parentIdTag;
    }

    public ReserveNowRequest withParentIdTag(String parentIdTag) {
        this.parentIdTag = parentIdTag;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reservationId")
    public int getReservationId() {
        return reservationId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reservationId")
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public ReserveNowRequest withReservationId(int reservationId) {
        this.reservationId = reservationId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ReserveNowRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("connectorId");
        sb.append('=');
        sb.append(this.connectorId);
        sb.append(',');
        sb.append("expiryDate");
        sb.append('=');
        sb.append(((this.expiryDate == null)?"<null>":this.expiryDate));
        sb.append(',');
        sb.append("idTag");
        sb.append('=');
        sb.append(((this.idTag == null)?"<null>":this.idTag));
        sb.append(',');
        sb.append("parentIdTag");
        sb.append('=');
        sb.append(((this.parentIdTag == null)?"<null>":this.parentIdTag));
        sb.append(',');
        sb.append("reservationId");
        sb.append('=');
        sb.append(this.reservationId);
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
        result = ((result* 31)+((this.expiryDate == null)? 0 :this.expiryDate.hashCode()));
        result = ((result* 31)+((this.parentIdTag == null)? 0 :this.parentIdTag.hashCode()));
        result = ((result* 31)+((this.idTag == null)? 0 :this.idTag.hashCode()));
        result = ((result* 31)+ this.reservationId);
        result = ((result* 31)+ this.connectorId);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReserveNowRequest) == false) {
            return false;
        }
        ReserveNowRequest rhs = ((ReserveNowRequest) other);
        return ((((((this.expiryDate == rhs.expiryDate)||((this.expiryDate!= null)&&this.expiryDate.equals(rhs.expiryDate)))&&((this.parentIdTag == rhs.parentIdTag)||((this.parentIdTag!= null)&&this.parentIdTag.equals(rhs.parentIdTag))))&&((this.idTag == rhs.idTag)||((this.idTag!= null)&&this.idTag.equals(rhs.idTag))))&&(this.reservationId == rhs.reservationId))&&(this.connectorId == rhs.connectorId));
    }

}
