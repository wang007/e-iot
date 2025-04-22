
package io.github.eiot.ocpp.schema.v1_6;

import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;


/**
 * HeartbeatResponse
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currentTime"
})
public class HeartbeatResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("currentTime")
    @NotNull
    private ZonedDateTime currentTime;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("currentTime")
    public ZonedDateTime getCurrentTime() {
        return currentTime;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("currentTime")
    public void setCurrentTime(ZonedDateTime currentTime) {
        this.currentTime = currentTime;
    }

    public HeartbeatResponse withCurrentTime(ZonedDateTime currentTime) {
        this.currentTime = currentTime;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(HeartbeatResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("currentTime");
        sb.append('=');
        sb.append(((this.currentTime == null)?"<null>":this.currentTime));
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
        result = ((result* 31)+((this.currentTime == null)? 0 :this.currentTime.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HeartbeatResponse) == false) {
            return false;
        }
        HeartbeatResponse rhs = ((HeartbeatResponse) other);
        return ((this.currentTime == rhs.currentTime)||((this.currentTime!= null)&&this.currentTime.equals(rhs.currentTime)));
    }

}
