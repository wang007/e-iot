
package io.github.eiot.ocpp.schema.v1_6;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "value",
    "context",
    "format",
    "measurand",
    "phase",
    "location",
    "unit"
})
public class SampledValue {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    @NotNull
    private String value;
    @JsonProperty("context")
    private SampledValue.Context context;
    @JsonProperty("format")
    private SampledValue.Format format;
    @JsonProperty("measurand")
    private SampledValue.Measurand measurand;
    @JsonProperty("phase")
    private SampledValue.Phase phase;
    @JsonProperty("location")
    private SampledValue.Location location;
    @JsonProperty("unit")
    private SampledValue.Unit unit;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    public SampledValue withValue(String value) {
        this.value = value;
        return this;
    }

    @JsonProperty("context")
    public SampledValue.Context getContext() {
        return context;
    }

    @JsonProperty("context")
    public void setContext(SampledValue.Context context) {
        this.context = context;
    }

    public SampledValue withContext(SampledValue.Context context) {
        this.context = context;
        return this;
    }

    @JsonProperty("format")
    public SampledValue.Format getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(SampledValue.Format format) {
        this.format = format;
    }

    public SampledValue withFormat(SampledValue.Format format) {
        this.format = format;
        return this;
    }

    @JsonProperty("measurand")
    public SampledValue.Measurand getMeasurand() {
        return measurand;
    }

    @JsonProperty("measurand")
    public void setMeasurand(SampledValue.Measurand measurand) {
        this.measurand = measurand;
    }

    public SampledValue withMeasurand(SampledValue.Measurand measurand) {
        this.measurand = measurand;
        return this;
    }

    @JsonProperty("phase")
    public SampledValue.Phase getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(SampledValue.Phase phase) {
        this.phase = phase;
    }

    public SampledValue withPhase(SampledValue.Phase phase) {
        this.phase = phase;
        return this;
    }

    @JsonProperty("location")
    public SampledValue.Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(SampledValue.Location location) {
        this.location = location;
    }

    public SampledValue withLocation(SampledValue.Location location) {
        this.location = location;
        return this;
    }

    @JsonProperty("unit")
    public SampledValue.Unit getUnit() {
        return unit;
    }

    @JsonProperty("unit")
    public void setUnit(SampledValue.Unit unit) {
        this.unit = unit;
    }

    public SampledValue withUnit(SampledValue.Unit unit) {
        this.unit = unit;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SampledValue.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("value");
        sb.append('=');
        sb.append(((this.value == null)?"<null>":this.value));
        sb.append(',');
        sb.append("context");
        sb.append('=');
        sb.append(((this.context == null)?"<null>":this.context));
        sb.append(',');
        sb.append("format");
        sb.append('=');
        sb.append(((this.format == null)?"<null>":this.format));
        sb.append(',');
        sb.append("measurand");
        sb.append('=');
        sb.append(((this.measurand == null)?"<null>":this.measurand));
        sb.append(',');
        sb.append("phase");
        sb.append('=');
        sb.append(((this.phase == null)?"<null>":this.phase));
        sb.append(',');
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null)?"<null>":this.location));
        sb.append(',');
        sb.append("unit");
        sb.append('=');
        sb.append(((this.unit == null)?"<null>":this.unit));
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
        result = ((result* 31)+((this.phase == null)? 0 :this.phase.hashCode()));
        result = ((result* 31)+((this.unit == null)? 0 :this.unit.hashCode()));
        result = ((result* 31)+((this.context == null)? 0 :this.context.hashCode()));
        result = ((result* 31)+((this.format == null)? 0 :this.format.hashCode()));
        result = ((result* 31)+((this.measurand == null)? 0 :this.measurand.hashCode()));
        result = ((result* 31)+((this.location == null)? 0 :this.location.hashCode()));
        result = ((result* 31)+((this.value == null)? 0 :this.value.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SampledValue) == false) {
            return false;
        }
        SampledValue rhs = ((SampledValue) other);
        return ((((((((this.phase == rhs.phase)||((this.phase!= null)&&this.phase.equals(rhs.phase)))&&((this.unit == rhs.unit)||((this.unit!= null)&&this.unit.equals(rhs.unit))))&&((this.context == rhs.context)||((this.context!= null)&&this.context.equals(rhs.context))))&&((this.format == rhs.format)||((this.format!= null)&&this.format.equals(rhs.format))))&&((this.measurand == rhs.measurand)||((this.measurand!= null)&&this.measurand.equals(rhs.measurand))))&&((this.location == rhs.location)||((this.location!= null)&&this.location.equals(rhs.location))))&&((this.value == rhs.value)||((this.value!= null)&&this.value.equals(rhs.value))));
    }

    public enum Context {

        INTERRUPTION_BEGIN("Interruption.Begin"),
        INTERRUPTION_END("Interruption.End"),
        SAMPLE_CLOCK("Sample.Clock"),
        SAMPLE_PERIODIC("Sample.Periodic"),
        TRANSACTION_BEGIN("Transaction.Begin"),
        TRANSACTION_END("Transaction.End"),
        TRIGGER("Trigger"),
        OTHER("Other");
        private final String value;
        private final static Map<String, SampledValue.Context> CONSTANTS = new HashMap<String, SampledValue.Context>();

        static {
            for (SampledValue.Context c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Context(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static SampledValue.Context fromValue(String value) {
            SampledValue.Context constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Format {

        RAW("Raw"),
        SIGNED_DATA("SignedData");
        private final String value;
        private final static Map<String, SampledValue.Format> CONSTANTS = new HashMap<String, SampledValue.Format>();

        static {
            for (SampledValue.Format c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Format(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static SampledValue.Format fromValue(String value) {
            SampledValue.Format constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Location {

        CABLE("Cable"),
        EV("EV"),
        INLET("Inlet"),
        OUTLET("Outlet"),
        BODY("Body");
        private final String value;
        private final static Map<String, SampledValue.Location> CONSTANTS = new HashMap<String, SampledValue.Location>();

        static {
            for (SampledValue.Location c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Location(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static SampledValue.Location fromValue(String value) {
            SampledValue.Location constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Measurand {

        ENERGY_ACTIVE_EXPORT_REGISTER("Energy.Active.Export.Register"),
        ENERGY_ACTIVE_IMPORT_REGISTER("Energy.Active.Import.Register"),
        ENERGY_REACTIVE_EXPORT_REGISTER("Energy.Reactive.Export.Register"),
        ENERGY_REACTIVE_IMPORT_REGISTER("Energy.Reactive.Import.Register"),
        ENERGY_ACTIVE_EXPORT_INTERVAL("Energy.Active.Export.Interval"),
        ENERGY_ACTIVE_IMPORT_INTERVAL("Energy.Active.Import.Interval"),
        ENERGY_REACTIVE_EXPORT_INTERVAL("Energy.Reactive.Export.Interval"),
        ENERGY_REACTIVE_IMPORT_INTERVAL("Energy.Reactive.Import.Interval"),
        POWER_ACTIVE_EXPORT("Power.Active.Export"),
        POWER_ACTIVE_IMPORT("Power.Active.Import"),
        POWER_OFFERED("Power.Offered"),
        POWER_REACTIVE_EXPORT("Power.Reactive.Export"),
        POWER_REACTIVE_IMPORT("Power.Reactive.Import"),
        POWER_FACTOR("Power.Factor"),
        CURRENT_IMPORT("Current.Import"),
        CURRENT_EXPORT("Current.Export"),
        CURRENT_OFFERED("Current.Offered"),
        VOLTAGE("Voltage"),
        FREQUENCY("Frequency"),
        TEMPERATURE("Temperature"),
        SO_C("SoC"),
        RPM("RPM");
        private final String value;
        private final static Map<String, SampledValue.Measurand> CONSTANTS = new HashMap<String, SampledValue.Measurand>();

        static {
            for (SampledValue.Measurand c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Measurand(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static SampledValue.Measurand fromValue(String value) {
            SampledValue.Measurand constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Phase {

        L_1("L1"),
        L_2("L2"),
        L_3("L3"),
        N("N"),
        L_1_N("L1-N"),
        L_2_N("L2-N"),
        L_3_N("L3-N"),
        L_1_L_2("L1-L2"),
        L_2_L_3("L2-L3"),
        L_3_L_1("L3-L1");
        private final String value;
        private final static Map<String, SampledValue.Phase> CONSTANTS = new HashMap<String, SampledValue.Phase>();

        static {
            for (SampledValue.Phase c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Phase(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static SampledValue.Phase fromValue(String value) {
            SampledValue.Phase constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Unit {

        WH("Wh"),
        K_WH("kWh"),
        VARH("varh"),
        KVARH("kvarh"),
        W("W"),
        K_W("kW"),
        VA("VA"),
        K_VA("kVA"),
        VAR("var"),
        KVAR("kvar"),
        A("A"),
        V("V"),
        K("K"),
        CELCIUS("Celcius"),
        CELSIUS("Celsius"),
        FAHRENHEIT("Fahrenheit"),
        PERCENT("Percent");
        private final String value;
        private final static Map<String, SampledValue.Unit> CONSTANTS = new HashMap<String, SampledValue.Unit>();

        static {
            for (SampledValue.Unit c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Unit(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static SampledValue.Unit fromValue(String value) {
            SampledValue.Unit constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
