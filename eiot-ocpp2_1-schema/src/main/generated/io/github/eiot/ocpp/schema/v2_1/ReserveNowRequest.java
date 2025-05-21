
package io.github.eiot.ocpp.schema.v2_1;

import java.time.ZonedDateTime;
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
    "id",
    "expiryDateTime",
    "connectorType",
    "idToken",
    "evseId",
    "groupIdToken",
    "customData"
})
public class ReserveNowRequest {

    /**
     * Id of reservation.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Id of reservation.\r\n")
    @DecimalMin("0")
    @NotNull
    private int id;
    /**
     * Date and time at which the reservation expires.
     * 
     * (Required)
     * 
     */
    @JsonProperty("expiryDateTime")
    @JsonPropertyDescription("Date and time at which the reservation expires.\r\n")
    @NotNull
    private ZonedDateTime expiryDateTime;
    /**
     * This field specifies the connector type. Values defined in Appendix as ConnectorEnumStringType.
     * 
     * 
     */
    @JsonProperty("connectorType")
    @JsonPropertyDescription("This field specifies the connector type. Values defined in Appendix as ConnectorEnumStringType.\r\n")
    @Size(max = 20)
    private String connectorType;
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
     * This contains ID of the evse to be reserved.
     * 
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("This contains ID of the evse to be reserved.\r\n")
    @DecimalMin("0")
    private int evseId;
    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * 
     */
    @JsonProperty("groupIdToken")
    @JsonPropertyDescription("Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.\r\n")
    @Valid
    private IdToken groupIdToken;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Id of reservation.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    /**
     * Id of reservation.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    public ReserveNowRequest withId(int id) {
        this.id = id;
        return this;
    }

    /**
     * Date and time at which the reservation expires.
     * 
     * (Required)
     * 
     */
    @JsonProperty("expiryDateTime")
    public ZonedDateTime getExpiryDateTime() {
        return expiryDateTime;
    }

    /**
     * Date and time at which the reservation expires.
     * 
     * (Required)
     * 
     */
    @JsonProperty("expiryDateTime")
    public void setExpiryDateTime(ZonedDateTime expiryDateTime) {
        this.expiryDateTime = expiryDateTime;
    }

    public ReserveNowRequest withExpiryDateTime(ZonedDateTime expiryDateTime) {
        this.expiryDateTime = expiryDateTime;
        return this;
    }

    /**
     * This field specifies the connector type. Values defined in Appendix as ConnectorEnumStringType.
     * 
     * 
     */
    @JsonProperty("connectorType")
    public String getConnectorType() {
        return connectorType;
    }

    /**
     * This field specifies the connector type. Values defined in Appendix as ConnectorEnumStringType.
     * 
     * 
     */
    @JsonProperty("connectorType")
    public void setConnectorType(String connectorType) {
        this.connectorType = connectorType;
    }

    public ReserveNowRequest withConnectorType(String connectorType) {
        this.connectorType = connectorType;
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

    public ReserveNowRequest withIdToken(IdToken idToken) {
        this.idToken = idToken;
        return this;
    }

    /**
     * This contains ID of the evse to be reserved.
     * 
     * 
     */
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * This contains ID of the evse to be reserved.
     * 
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public ReserveNowRequest withEvseId(int evseId) {
        this.evseId = evseId;
        return this;
    }

    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * 
     */
    @JsonProperty("groupIdToken")
    public IdToken getGroupIdToken() {
        return groupIdToken;
    }

    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * 
     */
    @JsonProperty("groupIdToken")
    public void setGroupIdToken(IdToken groupIdToken) {
        this.groupIdToken = groupIdToken;
    }

    public ReserveNowRequest withGroupIdToken(IdToken groupIdToken) {
        this.groupIdToken = groupIdToken;
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

    public ReserveNowRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ReserveNowRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(this.id);
        sb.append(',');
        sb.append("expiryDateTime");
        sb.append('=');
        sb.append(((this.expiryDateTime == null)?"<null>":this.expiryDateTime));
        sb.append(',');
        sb.append("connectorType");
        sb.append('=');
        sb.append(((this.connectorType == null)?"<null>":this.connectorType));
        sb.append(',');
        sb.append("idToken");
        sb.append('=');
        sb.append(((this.idToken == null)?"<null>":this.idToken));
        sb.append(',');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
        sb.append(',');
        sb.append("groupIdToken");
        sb.append('=');
        sb.append(((this.groupIdToken == null)?"<null>":this.groupIdToken));
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
        result = ((result* 31)+((this.connectorType == null)? 0 :this.connectorType.hashCode()));
        result = ((result* 31)+((this.idToken == null)? 0 :this.idToken.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.id);
        result = ((result* 31)+((this.expiryDateTime == null)? 0 :this.expiryDateTime.hashCode()));
        result = ((result* 31)+((this.groupIdToken == null)? 0 :this.groupIdToken.hashCode()));
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
        return (((((((this.evseId == rhs.evseId)&&((this.connectorType == rhs.connectorType)||((this.connectorType!= null)&&this.connectorType.equals(rhs.connectorType))))&&((this.idToken == rhs.idToken)||((this.idToken!= null)&&this.idToken.equals(rhs.idToken))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.id == rhs.id))&&((this.expiryDateTime == rhs.expiryDateTime)||((this.expiryDateTime!= null)&&this.expiryDateTime.equals(rhs.expiryDateTime))))&&((this.groupIdToken == rhs.groupIdToken)||((this.groupIdToken!= null)&&this.groupIdToken.equals(rhs.groupIdToken))));
    }

}
