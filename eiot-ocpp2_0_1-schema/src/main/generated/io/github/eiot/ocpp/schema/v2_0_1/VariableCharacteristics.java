
package io.github.eiot.ocpp.schema.v2_0_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Fixed read-only parameters of a variable.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customData",
    "unit",
    "dataType",
    "minLimit",
    "maxLimit",
    "valuesList",
    "supportsMonitoring"
})
public class VariableCharacteristics {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Unit of the variable. When the transmitted value has a unit, this field SHALL be included.
     * 
     * 
     */
    @JsonProperty("unit")
    @JsonPropertyDescription("Unit of the variable. When the transmitted value has a unit, this field SHALL be included.\r\n")
    @Size(max = 16)
    private String unit;
    /**
     * Data type of this variable.
     * 
     * (Required)
     * 
     */
    @JsonProperty("dataType")
    @JsonPropertyDescription("Data type of this variable.\r\n")
    @NotNull
    private DataEnum dataType;
    /**
     * Minimum possible value of this variable.
     * 
     * 
     */
    @JsonProperty("minLimit")
    @JsonPropertyDescription("Minimum possible value of this variable.\r\n")
    private double minLimit;
    /**
     * Maximum possible value of this variable. When the datatype of this Variable is String, OptionList, SequenceList or MemberList, this field defines the maximum length of the (CSV) string.
     * 
     * 
     */
    @JsonProperty("maxLimit")
    @JsonPropertyDescription("Maximum possible value of this variable. When the datatype of this Variable is String, OptionList, SequenceList or MemberList, this field defines the maximum length of the (CSV) string.\r\n")
    private double maxLimit;
    /**
     * Allowed values when variable is Option/Member/SequenceList. 
     * 
     * * OptionList: The (Actual) Variable value must be a single value from the reported (CSV) enumeration list.
     * 
     * * MemberList: The (Actual) Variable value  may be an (unordered) (sub-)set of the reported (CSV) valid values list.
     * 
     * * SequenceList: The (Actual) Variable value  may be an ordered (priority, etc)  (sub-)set of the reported (CSV) valid values.
     * 
     * This is a comma separated list.
     * 
     * The Configuration Variable &lt;&lt;configkey-configuration-value-size,ConfigurationValueSize&gt;&gt; can be used to limit SetVariableData.attributeValue and VariableCharacteristics.valueList. The max size of these values will always remain equal. 
     * 
     * 
     * 
     */
    @JsonProperty("valuesList")
    @JsonPropertyDescription("Allowed values when variable is Option/Member/SequenceList. \r\n\r\n* OptionList: The (Actual) Variable value must be a single value from the reported (CSV) enumeration list.\r\n\r\n* MemberList: The (Actual) Variable value  may be an (unordered) (sub-)set of the reported (CSV) valid values list.\r\n\r\n* SequenceList: The (Actual) Variable value  may be an ordered (priority, etc)  (sub-)set of the reported (CSV) valid values.\r\n\r\nThis is a comma separated list.\r\n\r\nThe Configuration Variable &lt;&lt;configkey-configuration-value-size,ConfigurationValueSize&gt;&gt; can be used to limit SetVariableData.attributeValue and VariableCharacteristics.valueList. The max size of these values will always remain equal. \r\n\r\n")
    @Size(max = 1000)
    private String valuesList;
    /**
     * Flag indicating if this variable supports monitoring. 
     * 
     * (Required)
     * 
     */
    @JsonProperty("supportsMonitoring")
    @JsonPropertyDescription("Flag indicating if this variable supports monitoring. \r\n")
    @NotNull
    private boolean supportsMonitoring;

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

    public VariableCharacteristics withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    /**
     * Unit of the variable. When the transmitted value has a unit, this field SHALL be included.
     * 
     * 
     */
    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }

    /**
     * Unit of the variable. When the transmitted value has a unit, this field SHALL be included.
     * 
     * 
     */
    @JsonProperty("unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public VariableCharacteristics withUnit(String unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Data type of this variable.
     * 
     * (Required)
     * 
     */
    @JsonProperty("dataType")
    public DataEnum getDataType() {
        return dataType;
    }

    /**
     * Data type of this variable.
     * 
     * (Required)
     * 
     */
    @JsonProperty("dataType")
    public void setDataType(DataEnum dataType) {
        this.dataType = dataType;
    }

    public VariableCharacteristics withDataType(DataEnum dataType) {
        this.dataType = dataType;
        return this;
    }

    /**
     * Minimum possible value of this variable.
     * 
     * 
     */
    @JsonProperty("minLimit")
    public double getMinLimit() {
        return minLimit;
    }

    /**
     * Minimum possible value of this variable.
     * 
     * 
     */
    @JsonProperty("minLimit")
    public void setMinLimit(double minLimit) {
        this.minLimit = minLimit;
    }

    public VariableCharacteristics withMinLimit(double minLimit) {
        this.minLimit = minLimit;
        return this;
    }

    /**
     * Maximum possible value of this variable. When the datatype of this Variable is String, OptionList, SequenceList or MemberList, this field defines the maximum length of the (CSV) string.
     * 
     * 
     */
    @JsonProperty("maxLimit")
    public double getMaxLimit() {
        return maxLimit;
    }

    /**
     * Maximum possible value of this variable. When the datatype of this Variable is String, OptionList, SequenceList or MemberList, this field defines the maximum length of the (CSV) string.
     * 
     * 
     */
    @JsonProperty("maxLimit")
    public void setMaxLimit(double maxLimit) {
        this.maxLimit = maxLimit;
    }

    public VariableCharacteristics withMaxLimit(double maxLimit) {
        this.maxLimit = maxLimit;
        return this;
    }

    /**
     * Allowed values when variable is Option/Member/SequenceList. 
     * 
     * * OptionList: The (Actual) Variable value must be a single value from the reported (CSV) enumeration list.
     * 
     * * MemberList: The (Actual) Variable value  may be an (unordered) (sub-)set of the reported (CSV) valid values list.
     * 
     * * SequenceList: The (Actual) Variable value  may be an ordered (priority, etc)  (sub-)set of the reported (CSV) valid values.
     * 
     * This is a comma separated list.
     * 
     * The Configuration Variable &lt;&lt;configkey-configuration-value-size,ConfigurationValueSize&gt;&gt; can be used to limit SetVariableData.attributeValue and VariableCharacteristics.valueList. The max size of these values will always remain equal. 
     * 
     * 
     * 
     */
    @JsonProperty("valuesList")
    public String getValuesList() {
        return valuesList;
    }

    /**
     * Allowed values when variable is Option/Member/SequenceList. 
     * 
     * * OptionList: The (Actual) Variable value must be a single value from the reported (CSV) enumeration list.
     * 
     * * MemberList: The (Actual) Variable value  may be an (unordered) (sub-)set of the reported (CSV) valid values list.
     * 
     * * SequenceList: The (Actual) Variable value  may be an ordered (priority, etc)  (sub-)set of the reported (CSV) valid values.
     * 
     * This is a comma separated list.
     * 
     * The Configuration Variable &lt;&lt;configkey-configuration-value-size,ConfigurationValueSize&gt;&gt; can be used to limit SetVariableData.attributeValue and VariableCharacteristics.valueList. The max size of these values will always remain equal. 
     * 
     * 
     * 
     */
    @JsonProperty("valuesList")
    public void setValuesList(String valuesList) {
        this.valuesList = valuesList;
    }

    public VariableCharacteristics withValuesList(String valuesList) {
        this.valuesList = valuesList;
        return this;
    }

    /**
     * Flag indicating if this variable supports monitoring. 
     * 
     * (Required)
     * 
     */
    @JsonProperty("supportsMonitoring")
    public boolean isSupportsMonitoring() {
        return supportsMonitoring;
    }

    /**
     * Flag indicating if this variable supports monitoring. 
     * 
     * (Required)
     * 
     */
    @JsonProperty("supportsMonitoring")
    public void setSupportsMonitoring(boolean supportsMonitoring) {
        this.supportsMonitoring = supportsMonitoring;
    }

    public VariableCharacteristics withSupportsMonitoring(boolean supportsMonitoring) {
        this.supportsMonitoring = supportsMonitoring;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VariableCharacteristics.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("customData");
        sb.append('=');
        sb.append(((this.customData == null)?"<null>":this.customData));
        sb.append(',');
        sb.append("unit");
        sb.append('=');
        sb.append(((this.unit == null)?"<null>":this.unit));
        sb.append(',');
        sb.append("dataType");
        sb.append('=');
        sb.append(((this.dataType == null)?"<null>":this.dataType));
        sb.append(',');
        sb.append("minLimit");
        sb.append('=');
        sb.append(this.minLimit);
        sb.append(',');
        sb.append("maxLimit");
        sb.append('=');
        sb.append(this.maxLimit);
        sb.append(',');
        sb.append("valuesList");
        sb.append('=');
        sb.append(((this.valuesList == null)?"<null>":this.valuesList));
        sb.append(',');
        sb.append("supportsMonitoring");
        sb.append('=');
        sb.append(this.supportsMonitoring);
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
        result = ((result* 31)+((this.unit == null)? 0 :this.unit.hashCode()));
        result = ((result* 31)+((this.valuesList == null)? 0 :this.valuesList.hashCode()));
        result = ((result* 31)+(this.supportsMonitoring? 1 : 0));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxLimit)^(Double.doubleToLongBits(this.maxLimit)>>> 32))));
        result = ((result* 31)+((this.dataType == null)? 0 :this.dataType.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minLimit)^(Double.doubleToLongBits(this.minLimit)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VariableCharacteristics) == false) {
            return false;
        }
        VariableCharacteristics rhs = ((VariableCharacteristics) other);
        return ((((((((this.unit == rhs.unit)||((this.unit!= null)&&this.unit.equals(rhs.unit)))&&((this.valuesList == rhs.valuesList)||((this.valuesList!= null)&&this.valuesList.equals(rhs.valuesList))))&&(this.supportsMonitoring == rhs.supportsMonitoring))&&(Double.doubleToLongBits(this.maxLimit) == Double.doubleToLongBits(rhs.maxLimit)))&&((this.dataType == rhs.dataType)||((this.dataType!= null)&&this.dataType.equals(rhs.dataType))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(Double.doubleToLongBits(this.minLimit) == Double.doubleToLongBits(rhs.minLimit)));
    }

}
