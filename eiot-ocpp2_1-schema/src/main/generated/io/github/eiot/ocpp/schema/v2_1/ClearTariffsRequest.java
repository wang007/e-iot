
package io.github.eiot.ocpp.schema.v2_1;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tariffIds",
    "evseId",
    "customData"
})
public class ClearTariffsRequest {

    /**
     * List of tariff Ids to clear. When absent clears all tariffs at _evseId_.
     * 
     * 
     * 
     */
    @JsonProperty("tariffIds")
    @JsonPropertyDescription("List of tariff Ids to clear. When absent clears all tariffs at _evseId_.\r\n\r\n")
    @Size(min = 1)
    @Valid
    private List<String> tariffIds = new ArrayList<String>();
    /**
     * When present only clear tariffs matching _tariffIds_ at EVSE _evseId_.
     * 
     * 
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("When present only clear tariffs matching _tariffIds_ at EVSE _evseId_.\r\n\r\n")
    @DecimalMin("0")
    private int evseId;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * List of tariff Ids to clear. When absent clears all tariffs at _evseId_.
     * 
     * 
     * 
     */
    @JsonProperty("tariffIds")
    public List<String> getTariffIds() {
        return tariffIds;
    }

    /**
     * List of tariff Ids to clear. When absent clears all tariffs at _evseId_.
     * 
     * 
     * 
     */
    @JsonProperty("tariffIds")
    public void setTariffIds(List<String> tariffIds) {
        this.tariffIds = tariffIds;
    }

    public ClearTariffsRequest withTariffIds(List<String> tariffIds) {
        this.tariffIds = tariffIds;
        return this;
    }

    /**
     * When present only clear tariffs matching _tariffIds_ at EVSE _evseId_.
     * 
     * 
     * 
     */
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * When present only clear tariffs matching _tariffIds_ at EVSE _evseId_.
     * 
     * 
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public ClearTariffsRequest withEvseId(int evseId) {
        this.evseId = evseId;
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

    public ClearTariffsRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ClearTariffsRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("tariffIds");
        sb.append('=');
        sb.append(((this.tariffIds == null)?"<null>":this.tariffIds));
        sb.append(',');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
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
        result = ((result* 31)+((this.tariffIds == null)? 0 :this.tariffIds.hashCode()));
        result = ((result* 31)+ this.evseId);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ClearTariffsRequest) == false) {
            return false;
        }
        ClearTariffsRequest rhs = ((ClearTariffsRequest) other);
        return ((((this.tariffIds == rhs.tariffIds)||((this.tariffIds!= null)&&this.tariffIds.equals(rhs.tariffIds)))&&(this.evseId == rhs.evseId))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))));
    }

}
