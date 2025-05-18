
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
    "batteryData",
    "eventType",
    "idToken",
    "requestId",
    "customData"
})
public class BatterySwapRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("batteryData")
    @Size(min = 1)
    @Valid
    @NotNull
    private List<BatteryData> batteryData = new ArrayList<BatteryData>();
    /**
     * Battery in/out
     * 
     * (Required)
     * 
     */
    @JsonProperty("eventType")
    @JsonPropertyDescription("Battery in/out\r\n")
    @NotNull
    private BatterySwapEventEnum eventType;
    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * (Required)
     * 
     */
    @JsonProperty("idToken")
    @JsonPropertyDescription("Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.\r\n")
    @Valid
    @NotNull
    private IdToken idToken;
    /**
     * RequestId to correlate BatteryIn/Out events and optional RequestBatterySwapRequest.
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("RequestId to correlate BatteryIn/Out events and optional RequestBatterySwapRequest.\r\n\r\n\r\n")
    @NotNull
    private int requestId;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("batteryData")
    public List<BatteryData> getBatteryData() {
        return batteryData;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("batteryData")
    public void setBatteryData(List<BatteryData> batteryData) {
        this.batteryData = batteryData;
    }

    public BatterySwapRequest withBatteryData(List<BatteryData> batteryData) {
        this.batteryData = batteryData;
        return this;
    }

    /**
     * Battery in/out
     * 
     * (Required)
     * 
     */
    @JsonProperty("eventType")
    public BatterySwapEventEnum getEventType() {
        return eventType;
    }

    /**
     * Battery in/out
     * 
     * (Required)
     * 
     */
    @JsonProperty("eventType")
    public void setEventType(BatterySwapEventEnum eventType) {
        this.eventType = eventType;
    }

    public BatterySwapRequest withEventType(BatterySwapEventEnum eventType) {
        this.eventType = eventType;
        return this;
    }

    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * (Required)
     * 
     */
    @JsonProperty("idToken")
    public IdToken getIdToken() {
        return idToken;
    }

    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * (Required)
     * 
     */
    @JsonProperty("idToken")
    public void setIdToken(IdToken idToken) {
        this.idToken = idToken;
    }

    public BatterySwapRequest withIdToken(IdToken idToken) {
        this.idToken = idToken;
        return this;
    }

    /**
     * RequestId to correlate BatteryIn/Out events and optional RequestBatterySwapRequest.
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public int getRequestId() {
        return requestId;
    }

    /**
     * RequestId to correlate BatteryIn/Out events and optional RequestBatterySwapRequest.
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public BatterySwapRequest withRequestId(int requestId) {
        this.requestId = requestId;
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

    public BatterySwapRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BatterySwapRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("batteryData");
        sb.append('=');
        sb.append(((this.batteryData == null)?"<null>":this.batteryData));
        sb.append(',');
        sb.append("eventType");
        sb.append('=');
        sb.append(((this.eventType == null)?"<null>":this.eventType));
        sb.append(',');
        sb.append("idToken");
        sb.append('=');
        sb.append(((this.idToken == null)?"<null>":this.idToken));
        sb.append(',');
        sb.append("requestId");
        sb.append('=');
        sb.append(this.requestId);
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
        result = ((result* 31)+((this.idToken == null)? 0 :this.idToken.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.eventType == null)? 0 :this.eventType.hashCode()));
        result = ((result* 31)+((this.batteryData == null)? 0 :this.batteryData.hashCode()));
        result = ((result* 31)+ this.requestId);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BatterySwapRequest) == false) {
            return false;
        }
        BatterySwapRequest rhs = ((BatterySwapRequest) other);
        return ((((((this.idToken == rhs.idToken)||((this.idToken!= null)&&this.idToken.equals(rhs.idToken)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.eventType == rhs.eventType)||((this.eventType!= null)&&this.eventType.equals(rhs.eventType))))&&((this.batteryData == rhs.batteryData)||((this.batteryData!= null)&&this.batteryData.equals(rhs.batteryData))))&&(this.requestId == rhs.requestId));
    }

}
