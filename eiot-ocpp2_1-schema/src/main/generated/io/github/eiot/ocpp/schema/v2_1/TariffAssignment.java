
package io.github.eiot.ocpp.schema.v2_1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Shows assignment of tariffs to EVSE or IdToken.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tariffId",
    "tariffKind",
    "validFrom",
    "evseIds",
    "idTokens",
    "customData"
})
public class TariffAssignment {

    /**
     * Tariff id.
     * 
     * (Required)
     * 
     */
    @JsonProperty("tariffId")
    @JsonPropertyDescription("Tariff id.\r\n")
    @Size(max = 60)
    @NotNull
    private String tariffId;
    /**
     * Kind of tariff (driver/default)
     * 
     * (Required)
     * 
     */
    @JsonProperty("tariffKind")
    @JsonPropertyDescription("Kind of tariff (driver/default)\r\n")
    @NotNull
    private TariffKindEnum tariffKind;
    /**
     * Date/time when this tariff become active.
     * 
     * 
     */
    @JsonProperty("validFrom")
    @JsonPropertyDescription("Date/time when this tariff become active.\r\n")
    private OffsetDateTime validFrom;
    @JsonProperty("evseIds")
    @Size(min = 1)
    @Valid
    private List<Integer> evseIds = new ArrayList<Integer>();
    /**
     * IdTokens related to tariff
     * 
     * 
     */
    @JsonProperty("idTokens")
    @JsonPropertyDescription("IdTokens related to tariff\r\n")
    @Size(min = 1)
    @Valid
    private List<String> idTokens = new ArrayList<String>();
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Tariff id.
     * 
     * (Required)
     * 
     */
    @JsonProperty("tariffId")
    public String getTariffId() {
        return tariffId;
    }

    /**
     * Tariff id.
     * 
     * (Required)
     * 
     */
    @JsonProperty("tariffId")
    public void setTariffId(String tariffId) {
        this.tariffId = tariffId;
    }

    public TariffAssignment withTariffId(String tariffId) {
        this.tariffId = tariffId;
        return this;
    }

    /**
     * Kind of tariff (driver/default)
     * 
     * (Required)
     * 
     */
    @JsonProperty("tariffKind")
    public TariffKindEnum getTariffKind() {
        return tariffKind;
    }

    /**
     * Kind of tariff (driver/default)
     * 
     * (Required)
     * 
     */
    @JsonProperty("tariffKind")
    public void setTariffKind(TariffKindEnum tariffKind) {
        this.tariffKind = tariffKind;
    }

    public TariffAssignment withTariffKind(TariffKindEnum tariffKind) {
        this.tariffKind = tariffKind;
        return this;
    }

    /**
     * Date/time when this tariff become active.
     * 
     * 
     */
    @JsonProperty("validFrom")
    public OffsetDateTime getValidFrom() {
        return validFrom;
    }

    /**
     * Date/time when this tariff become active.
     * 
     * 
     */
    @JsonProperty("validFrom")
    public void setValidFrom(OffsetDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public TariffAssignment withValidFrom(OffsetDateTime validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    @JsonProperty("evseIds")
    public List<Integer> getEvseIds() {
        return evseIds;
    }

    @JsonProperty("evseIds")
    public void setEvseIds(List<Integer> evseIds) {
        this.evseIds = evseIds;
    }

    public TariffAssignment withEvseIds(List<Integer> evseIds) {
        this.evseIds = evseIds;
        return this;
    }

    /**
     * IdTokens related to tariff
     * 
     * 
     */
    @JsonProperty("idTokens")
    public List<String> getIdTokens() {
        return idTokens;
    }

    /**
     * IdTokens related to tariff
     * 
     * 
     */
    @JsonProperty("idTokens")
    public void setIdTokens(List<String> idTokens) {
        this.idTokens = idTokens;
    }

    public TariffAssignment withIdTokens(List<String> idTokens) {
        this.idTokens = idTokens;
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

    public TariffAssignment withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TariffAssignment.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("tariffId");
        sb.append('=');
        sb.append(((this.tariffId == null)?"<null>":this.tariffId));
        sb.append(',');
        sb.append("tariffKind");
        sb.append('=');
        sb.append(((this.tariffKind == null)?"<null>":this.tariffKind));
        sb.append(',');
        sb.append("validFrom");
        sb.append('=');
        sb.append(((this.validFrom == null)?"<null>":this.validFrom));
        sb.append(',');
        sb.append("evseIds");
        sb.append('=');
        sb.append(((this.evseIds == null)?"<null>":this.evseIds));
        sb.append(',');
        sb.append("idTokens");
        sb.append('=');
        sb.append(((this.idTokens == null)?"<null>":this.idTokens));
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
        result = ((result* 31)+((this.tariffKind == null)? 0 :this.tariffKind.hashCode()));
        result = ((result* 31)+((this.evseIds == null)? 0 :this.evseIds.hashCode()));
        result = ((result* 31)+((this.idTokens == null)? 0 :this.idTokens.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.tariffId == null)? 0 :this.tariffId.hashCode()));
        result = ((result* 31)+((this.validFrom == null)? 0 :this.validFrom.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TariffAssignment) == false) {
            return false;
        }
        TariffAssignment rhs = ((TariffAssignment) other);
        return (((((((this.tariffKind == rhs.tariffKind)||((this.tariffKind!= null)&&this.tariffKind.equals(rhs.tariffKind)))&&((this.evseIds == rhs.evseIds)||((this.evseIds!= null)&&this.evseIds.equals(rhs.evseIds))))&&((this.idTokens == rhs.idTokens)||((this.idTokens!= null)&&this.idTokens.equals(rhs.idTokens))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.tariffId == rhs.tariffId)||((this.tariffId!= null)&&this.tariffId.equals(rhs.tariffId))))&&((this.validFrom == rhs.validFrom)||((this.validFrom!= null)&&this.validFrom.equals(rhs.validFrom))));
    }

}
