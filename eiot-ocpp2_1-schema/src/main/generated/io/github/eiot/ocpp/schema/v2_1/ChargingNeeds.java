
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acChargingParameters",
    "derChargingParameters",
    "evEnergyOffer",
    "requestedEnergyTransfer",
    "dcChargingParameters",
    "v2xChargingParameters",
    "availableEnergyTransfer",
    "controlMode",
    "mobilityNeedsMode",
    "departureTime",
    "customData"
})
public class ChargingNeeds {

    /**
     * EV AC charging parameters for ISO 15118-2
     * 
     * 
     * 
     */
    @JsonProperty("acChargingParameters")
    @JsonPropertyDescription("EV AC charging parameters for ISO 15118-2\r\n\r\n")
    @Valid
    private ACChargingParameters acChargingParameters;
    /**
     * *(2.1)* DERChargingParametersType is used in ChargingNeedsType during an ISO 15118-20 session for AC_BPT_DER to report the inverter settings related to DER control that were agreed between EVSE and EV.
     * 
     * Fields starting with "ev" contain values from the EV.
     * Other fields contain a value that is supported by both EV and EVSE.
     * 
     * DERChargingParametersType type is only relevant in case of an ISO 15118-20 AC_BPT_DER/AC_DER charging session.
     * 
     * NOTE: All these fields have values greater or equal to zero (i.e. are non-negative)
     * 
     * 
     * 
     */
    @JsonProperty("derChargingParameters")
    @JsonPropertyDescription("*(2.1)* DERChargingParametersType is used in ChargingNeedsType during an ISO 15118-20 session for AC_BPT_DER to report the inverter settings related to DER control that were agreed between EVSE and EV.\r\n\r\nFields starting with \"ev\" contain values from the EV.\r\nOther fields contain a value that is supported by both EV and EVSE.\r\n\r\nDERChargingParametersType type is only relevant in case of an ISO 15118-20 AC_BPT_DER/AC_DER charging session.\r\n\r\nNOTE: All these fields have values greater or equal to zero (i.e. are non-negative)\r\n\r\n")
    @Valid
    private DERChargingParameters derChargingParameters;
    /**
     * *(2.1)* A schedule of the energy amount over time that EV is willing to discharge. A negative value indicates the willingness to discharge under specific conditions, a positive value indicates that the EV currently is not able to offer energy to discharge. 
     * 
     * 
     */
    @JsonProperty("evEnergyOffer")
    @JsonPropertyDescription("*(2.1)* A schedule of the energy amount over time that EV is willing to discharge. A negative value indicates the willingness to discharge under specific conditions, a positive value indicates that the EV currently is not able to offer energy to discharge. \r\n")
    @Valid
    private EVEnergyOffer evEnergyOffer;
    /**
     * Mode of energy transfer requested by the EV.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestedEnergyTransfer")
    @JsonPropertyDescription("Mode of energy transfer requested by the EV.\r\n")
    @NotNull
    private EnergyTransferModeEnum requestedEnergyTransfer;
    /**
     * EV DC charging parameters for ISO 15118-2
     * 
     * 
     */
    @JsonProperty("dcChargingParameters")
    @JsonPropertyDescription("EV DC charging parameters for ISO 15118-2\r\n")
    @Valid
    private DCChargingParameters dcChargingParameters;
    /**
     * Charging parameters for ISO 15118-20, also supporting V2X charging/discharging.+
     * All values are greater or equal to zero, with the exception of EVMinEnergyRequest, EVMaxEnergyRequest, EVTargetEnergyRequest, EVMinV2XEnergyRequest and EVMaxV2XEnergyRequest.
     * 
     * 
     */
    @JsonProperty("v2xChargingParameters")
    @JsonPropertyDescription("Charging parameters for ISO 15118-20, also supporting V2X charging/discharging.+\r\nAll values are greater or equal to zero, with the exception of EVMinEnergyRequest, EVMaxEnergyRequest, EVTargetEnergyRequest, EVMinV2XEnergyRequest and EVMaxV2XEnergyRequest.\r\n")
    @Valid
    private V2XChargingParameters v2xChargingParameters;
    /**
     * *(2.1)* Modes of energy transfer that are marked as available by EV.
     * 
     * 
     */
    @JsonProperty("availableEnergyTransfer")
    @JsonPropertyDescription("*(2.1)* Modes of energy transfer that are marked as available by EV.\r\n")
    @Size(min = 1)
    @Valid
    private List<EnergyTransferModeEnum> availableEnergyTransfer = new ArrayList<EnergyTransferModeEnum>();
    /**
     * *(2.1)* Indicates whether EV wants to operate in Dynamic or Scheduled mode. When absent, Scheduled mode is assumed for backwards compatibility. +
     * *ISO 15118-20:* +
     * ServiceSelectionReq(SelectedEnergyTransferService)
     * 
     * 
     */
    @JsonProperty("controlMode")
    @JsonPropertyDescription("*(2.1)* Indicates whether EV wants to operate in Dynamic or Scheduled mode. When absent, Scheduled mode is assumed for backwards compatibility. +\r\n*ISO 15118-20:* +\r\nServiceSelectionReq(SelectedEnergyTransferService)\r\n")
    private ControlModeEnum controlMode;
    /**
     * *(2.1)* Value of EVCC indicates that EV determines min/target SOC and departure time. +
     * A value of EVCC_SECC indicates that charging station or CSMS may also update min/target SOC and departure time. +
     * *ISO 15118-20:* +
     * ServiceSelectionReq(SelectedEnergyTransferService)
     * 
     * 
     */
    @JsonProperty("mobilityNeedsMode")
    @JsonPropertyDescription("*(2.1)* Value of EVCC indicates that EV determines min/target SOC and departure time. +\r\nA value of EVCC_SECC indicates that charging station or CSMS may also update min/target SOC and departure time. +\r\n*ISO 15118-20:* +\r\nServiceSelectionReq(SelectedEnergyTransferService)\r\n")
    private MobilityNeedsModeEnum mobilityNeedsMode;
    /**
     * Estimated departure time of the EV. +
     * *ISO 15118-2:* AC/DC_EVChargeParameterType: DepartureTime +
     * *ISO 15118-20:* Dynamic/Scheduled_SEReqControlModeType: DepartureTIme
     * 
     * 
     */
    @JsonProperty("departureTime")
    @JsonPropertyDescription("Estimated departure time of the EV. +\r\n*ISO 15118-2:* AC/DC_EVChargeParameterType: DepartureTime +\r\n*ISO 15118-20:* Dynamic/Scheduled_SEReqControlModeType: DepartureTIme\r\n")
    private OffsetDateTime departureTime;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * EV AC charging parameters for ISO 15118-2
     * 
     * 
     * 
     */
    @JsonProperty("acChargingParameters")
    public ACChargingParameters getAcChargingParameters() {
        return acChargingParameters;
    }

    /**
     * EV AC charging parameters for ISO 15118-2
     * 
     * 
     * 
     */
    @JsonProperty("acChargingParameters")
    public void setAcChargingParameters(ACChargingParameters acChargingParameters) {
        this.acChargingParameters = acChargingParameters;
    }

    public ChargingNeeds withAcChargingParameters(ACChargingParameters acChargingParameters) {
        this.acChargingParameters = acChargingParameters;
        return this;
    }

    /**
     * *(2.1)* DERChargingParametersType is used in ChargingNeedsType during an ISO 15118-20 session for AC_BPT_DER to report the inverter settings related to DER control that were agreed between EVSE and EV.
     * 
     * Fields starting with "ev" contain values from the EV.
     * Other fields contain a value that is supported by both EV and EVSE.
     * 
     * DERChargingParametersType type is only relevant in case of an ISO 15118-20 AC_BPT_DER/AC_DER charging session.
     * 
     * NOTE: All these fields have values greater or equal to zero (i.e. are non-negative)
     * 
     * 
     * 
     */
    @JsonProperty("derChargingParameters")
    public DERChargingParameters getDerChargingParameters() {
        return derChargingParameters;
    }

    /**
     * *(2.1)* DERChargingParametersType is used in ChargingNeedsType during an ISO 15118-20 session for AC_BPT_DER to report the inverter settings related to DER control that were agreed between EVSE and EV.
     * 
     * Fields starting with "ev" contain values from the EV.
     * Other fields contain a value that is supported by both EV and EVSE.
     * 
     * DERChargingParametersType type is only relevant in case of an ISO 15118-20 AC_BPT_DER/AC_DER charging session.
     * 
     * NOTE: All these fields have values greater or equal to zero (i.e. are non-negative)
     * 
     * 
     * 
     */
    @JsonProperty("derChargingParameters")
    public void setDerChargingParameters(DERChargingParameters derChargingParameters) {
        this.derChargingParameters = derChargingParameters;
    }

    public ChargingNeeds withDerChargingParameters(DERChargingParameters derChargingParameters) {
        this.derChargingParameters = derChargingParameters;
        return this;
    }

    /**
     * *(2.1)* A schedule of the energy amount over time that EV is willing to discharge. A negative value indicates the willingness to discharge under specific conditions, a positive value indicates that the EV currently is not able to offer energy to discharge. 
     * 
     * 
     */
    @JsonProperty("evEnergyOffer")
    public EVEnergyOffer getEvEnergyOffer() {
        return evEnergyOffer;
    }

    /**
     * *(2.1)* A schedule of the energy amount over time that EV is willing to discharge. A negative value indicates the willingness to discharge under specific conditions, a positive value indicates that the EV currently is not able to offer energy to discharge. 
     * 
     * 
     */
    @JsonProperty("evEnergyOffer")
    public void setEvEnergyOffer(EVEnergyOffer evEnergyOffer) {
        this.evEnergyOffer = evEnergyOffer;
    }

    public ChargingNeeds withEvEnergyOffer(EVEnergyOffer evEnergyOffer) {
        this.evEnergyOffer = evEnergyOffer;
        return this;
    }

    /**
     * Mode of energy transfer requested by the EV.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestedEnergyTransfer")
    public EnergyTransferModeEnum getRequestedEnergyTransfer() {
        return requestedEnergyTransfer;
    }

    /**
     * Mode of energy transfer requested by the EV.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestedEnergyTransfer")
    public void setRequestedEnergyTransfer(EnergyTransferModeEnum requestedEnergyTransfer) {
        this.requestedEnergyTransfer = requestedEnergyTransfer;
    }

    public ChargingNeeds withRequestedEnergyTransfer(EnergyTransferModeEnum requestedEnergyTransfer) {
        this.requestedEnergyTransfer = requestedEnergyTransfer;
        return this;
    }

    /**
     * EV DC charging parameters for ISO 15118-2
     * 
     * 
     */
    @JsonProperty("dcChargingParameters")
    public DCChargingParameters getDcChargingParameters() {
        return dcChargingParameters;
    }

    /**
     * EV DC charging parameters for ISO 15118-2
     * 
     * 
     */
    @JsonProperty("dcChargingParameters")
    public void setDcChargingParameters(DCChargingParameters dcChargingParameters) {
        this.dcChargingParameters = dcChargingParameters;
    }

    public ChargingNeeds withDcChargingParameters(DCChargingParameters dcChargingParameters) {
        this.dcChargingParameters = dcChargingParameters;
        return this;
    }

    /**
     * Charging parameters for ISO 15118-20, also supporting V2X charging/discharging.+
     * All values are greater or equal to zero, with the exception of EVMinEnergyRequest, EVMaxEnergyRequest, EVTargetEnergyRequest, EVMinV2XEnergyRequest and EVMaxV2XEnergyRequest.
     * 
     * 
     */
    @JsonProperty("v2xChargingParameters")
    public V2XChargingParameters getV2xChargingParameters() {
        return v2xChargingParameters;
    }

    /**
     * Charging parameters for ISO 15118-20, also supporting V2X charging/discharging.+
     * All values are greater or equal to zero, with the exception of EVMinEnergyRequest, EVMaxEnergyRequest, EVTargetEnergyRequest, EVMinV2XEnergyRequest and EVMaxV2XEnergyRequest.
     * 
     * 
     */
    @JsonProperty("v2xChargingParameters")
    public void setV2xChargingParameters(V2XChargingParameters v2xChargingParameters) {
        this.v2xChargingParameters = v2xChargingParameters;
    }

    public ChargingNeeds withV2xChargingParameters(V2XChargingParameters v2xChargingParameters) {
        this.v2xChargingParameters = v2xChargingParameters;
        return this;
    }

    /**
     * *(2.1)* Modes of energy transfer that are marked as available by EV.
     * 
     * 
     */
    @JsonProperty("availableEnergyTransfer")
    public List<EnergyTransferModeEnum> getAvailableEnergyTransfer() {
        return availableEnergyTransfer;
    }

    /**
     * *(2.1)* Modes of energy transfer that are marked as available by EV.
     * 
     * 
     */
    @JsonProperty("availableEnergyTransfer")
    public void setAvailableEnergyTransfer(List<EnergyTransferModeEnum> availableEnergyTransfer) {
        this.availableEnergyTransfer = availableEnergyTransfer;
    }

    public ChargingNeeds withAvailableEnergyTransfer(List<EnergyTransferModeEnum> availableEnergyTransfer) {
        this.availableEnergyTransfer = availableEnergyTransfer;
        return this;
    }

    /**
     * *(2.1)* Indicates whether EV wants to operate in Dynamic or Scheduled mode. When absent, Scheduled mode is assumed for backwards compatibility. +
     * *ISO 15118-20:* +
     * ServiceSelectionReq(SelectedEnergyTransferService)
     * 
     * 
     */
    @JsonProperty("controlMode")
    public ControlModeEnum getControlMode() {
        return controlMode;
    }

    /**
     * *(2.1)* Indicates whether EV wants to operate in Dynamic or Scheduled mode. When absent, Scheduled mode is assumed for backwards compatibility. +
     * *ISO 15118-20:* +
     * ServiceSelectionReq(SelectedEnergyTransferService)
     * 
     * 
     */
    @JsonProperty("controlMode")
    public void setControlMode(ControlModeEnum controlMode) {
        this.controlMode = controlMode;
    }

    public ChargingNeeds withControlMode(ControlModeEnum controlMode) {
        this.controlMode = controlMode;
        return this;
    }

    /**
     * *(2.1)* Value of EVCC indicates that EV determines min/target SOC and departure time. +
     * A value of EVCC_SECC indicates that charging station or CSMS may also update min/target SOC and departure time. +
     * *ISO 15118-20:* +
     * ServiceSelectionReq(SelectedEnergyTransferService)
     * 
     * 
     */
    @JsonProperty("mobilityNeedsMode")
    public MobilityNeedsModeEnum getMobilityNeedsMode() {
        return mobilityNeedsMode;
    }

    /**
     * *(2.1)* Value of EVCC indicates that EV determines min/target SOC and departure time. +
     * A value of EVCC_SECC indicates that charging station or CSMS may also update min/target SOC and departure time. +
     * *ISO 15118-20:* +
     * ServiceSelectionReq(SelectedEnergyTransferService)
     * 
     * 
     */
    @JsonProperty("mobilityNeedsMode")
    public void setMobilityNeedsMode(MobilityNeedsModeEnum mobilityNeedsMode) {
        this.mobilityNeedsMode = mobilityNeedsMode;
    }

    public ChargingNeeds withMobilityNeedsMode(MobilityNeedsModeEnum mobilityNeedsMode) {
        this.mobilityNeedsMode = mobilityNeedsMode;
        return this;
    }

    /**
     * Estimated departure time of the EV. +
     * *ISO 15118-2:* AC/DC_EVChargeParameterType: DepartureTime +
     * *ISO 15118-20:* Dynamic/Scheduled_SEReqControlModeType: DepartureTIme
     * 
     * 
     */
    @JsonProperty("departureTime")
    public OffsetDateTime getDepartureTime() {
        return departureTime;
    }

    /**
     * Estimated departure time of the EV. +
     * *ISO 15118-2:* AC/DC_EVChargeParameterType: DepartureTime +
     * *ISO 15118-20:* Dynamic/Scheduled_SEReqControlModeType: DepartureTIme
     * 
     * 
     */
    @JsonProperty("departureTime")
    public void setDepartureTime(OffsetDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public ChargingNeeds withDepartureTime(OffsetDateTime departureTime) {
        this.departureTime = departureTime;
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

    public ChargingNeeds withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChargingNeeds.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("acChargingParameters");
        sb.append('=');
        sb.append(((this.acChargingParameters == null)?"<null>":this.acChargingParameters));
        sb.append(',');
        sb.append("derChargingParameters");
        sb.append('=');
        sb.append(((this.derChargingParameters == null)?"<null>":this.derChargingParameters));
        sb.append(',');
        sb.append("evEnergyOffer");
        sb.append('=');
        sb.append(((this.evEnergyOffer == null)?"<null>":this.evEnergyOffer));
        sb.append(',');
        sb.append("requestedEnergyTransfer");
        sb.append('=');
        sb.append(((this.requestedEnergyTransfer == null)?"<null>":this.requestedEnergyTransfer));
        sb.append(',');
        sb.append("dcChargingParameters");
        sb.append('=');
        sb.append(((this.dcChargingParameters == null)?"<null>":this.dcChargingParameters));
        sb.append(',');
        sb.append("v2xChargingParameters");
        sb.append('=');
        sb.append(((this.v2xChargingParameters == null)?"<null>":this.v2xChargingParameters));
        sb.append(',');
        sb.append("availableEnergyTransfer");
        sb.append('=');
        sb.append(((this.availableEnergyTransfer == null)?"<null>":this.availableEnergyTransfer));
        sb.append(',');
        sb.append("controlMode");
        sb.append('=');
        sb.append(((this.controlMode == null)?"<null>":this.controlMode));
        sb.append(',');
        sb.append("mobilityNeedsMode");
        sb.append('=');
        sb.append(((this.mobilityNeedsMode == null)?"<null>":this.mobilityNeedsMode));
        sb.append(',');
        sb.append("departureTime");
        sb.append('=');
        sb.append(((this.departureTime == null)?"<null>":this.departureTime));
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
        result = ((result* 31)+((this.acChargingParameters == null)? 0 :this.acChargingParameters.hashCode()));
        result = ((result* 31)+((this.controlMode == null)? 0 :this.controlMode.hashCode()));
        result = ((result* 31)+((this.departureTime == null)? 0 :this.departureTime.hashCode()));
        result = ((result* 31)+((this.evEnergyOffer == null)? 0 :this.evEnergyOffer.hashCode()));
        result = ((result* 31)+((this.mobilityNeedsMode == null)? 0 :this.mobilityNeedsMode.hashCode()));
        result = ((result* 31)+((this.availableEnergyTransfer == null)? 0 :this.availableEnergyTransfer.hashCode()));
        result = ((result* 31)+((this.v2xChargingParameters == null)? 0 :this.v2xChargingParameters.hashCode()));
        result = ((result* 31)+((this.dcChargingParameters == null)? 0 :this.dcChargingParameters.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.requestedEnergyTransfer == null)? 0 :this.requestedEnergyTransfer.hashCode()));
        result = ((result* 31)+((this.derChargingParameters == null)? 0 :this.derChargingParameters.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChargingNeeds) == false) {
            return false;
        }
        ChargingNeeds rhs = ((ChargingNeeds) other);
        return ((((((((((((this.acChargingParameters == rhs.acChargingParameters)||((this.acChargingParameters!= null)&&this.acChargingParameters.equals(rhs.acChargingParameters)))&&((this.controlMode == rhs.controlMode)||((this.controlMode!= null)&&this.controlMode.equals(rhs.controlMode))))&&((this.departureTime == rhs.departureTime)||((this.departureTime!= null)&&this.departureTime.equals(rhs.departureTime))))&&((this.evEnergyOffer == rhs.evEnergyOffer)||((this.evEnergyOffer!= null)&&this.evEnergyOffer.equals(rhs.evEnergyOffer))))&&((this.mobilityNeedsMode == rhs.mobilityNeedsMode)||((this.mobilityNeedsMode!= null)&&this.mobilityNeedsMode.equals(rhs.mobilityNeedsMode))))&&((this.availableEnergyTransfer == rhs.availableEnergyTransfer)||((this.availableEnergyTransfer!= null)&&this.availableEnergyTransfer.equals(rhs.availableEnergyTransfer))))&&((this.v2xChargingParameters == rhs.v2xChargingParameters)||((this.v2xChargingParameters!= null)&&this.v2xChargingParameters.equals(rhs.v2xChargingParameters))))&&((this.dcChargingParameters == rhs.dcChargingParameters)||((this.dcChargingParameters!= null)&&this.dcChargingParameters.equals(rhs.dcChargingParameters))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.requestedEnergyTransfer == rhs.requestedEnergyTransfer)||((this.requestedEnergyTransfer!= null)&&this.requestedEnergyTransfer.equals(rhs.requestedEnergyTransfer))))&&((this.derChargingParameters == rhs.derChargingParameters)||((this.derChargingParameters!= null)&&this.derChargingParameters.equals(rhs.derChargingParameters))));
    }

}
