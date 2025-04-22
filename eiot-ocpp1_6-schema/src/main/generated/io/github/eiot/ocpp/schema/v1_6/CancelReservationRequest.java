
package io.github.eiot.ocpp.schema.v1_6;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;


/**
 * CancelReservationRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "reservationId"
})
public class CancelReservationRequest {

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

    public CancelReservationRequest withReservationId(int reservationId) {
        this.reservationId = reservationId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CancelReservationRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        result = ((result* 31)+ this.reservationId);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CancelReservationRequest) == false) {
            return false;
        }
        CancelReservationRequest rhs = ((CancelReservationRequest) other);
        return (this.reservationId == rhs.reservationId);
    }

}
