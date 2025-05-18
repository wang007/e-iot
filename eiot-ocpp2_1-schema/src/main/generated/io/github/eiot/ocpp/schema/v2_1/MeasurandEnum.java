
package io.github.eiot.ocpp.schema.v2_1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Type of measurement. Default = "Energy.Active.Import.Register"
 * 
 * 
 */
public enum MeasurandEnum {

    CURRENT_EXPORT("Current.Export"),
    CURRENT_EXPORT_OFFERED("Current.Export.Offered"),
    CURRENT_EXPORT_MINIMUM("Current.Export.Minimum"),
    CURRENT_IMPORT("Current.Import"),
    CURRENT_IMPORT_OFFERED("Current.Import.Offered"),
    CURRENT_IMPORT_MINIMUM("Current.Import.Minimum"),
    CURRENT_OFFERED("Current.Offered"),
    DISPLAY_PRESENT_SOC("Display.PresentSOC"),
    DISPLAY_MINIMUM_SOC("Display.MinimumSOC"),
    DISPLAY_TARGET_SOC("Display.TargetSOC"),
    DISPLAY_MAXIMUM_SOC("Display.MaximumSOC"),
    DISPLAY_REMAINING_TIME_TO_MINIMUM_SOC("Display.RemainingTimeToMinimumSOC"),
    DISPLAY_REMAINING_TIME_TO_TARGET_SOC("Display.RemainingTimeToTargetSOC"),
    DISPLAY_REMAINING_TIME_TO_MAXIMUM_SOC("Display.RemainingTimeToMaximumSOC"),
    DISPLAY_CHARGING_COMPLETE("Display.ChargingComplete"),
    DISPLAY_BATTERY_ENERGY_CAPACITY("Display.BatteryEnergyCapacity"),
    DISPLAY_INLET_HOT("Display.InletHot"),
    ENERGY_ACTIVE_EXPORT_INTERVAL("Energy.Active.Export.Interval"),
    ENERGY_ACTIVE_EXPORT_REGISTER("Energy.Active.Export.Register"),
    ENERGY_ACTIVE_IMPORT_INTERVAL("Energy.Active.Import.Interval"),
    ENERGY_ACTIVE_IMPORT_REGISTER("Energy.Active.Import.Register"),
    ENERGY_ACTIVE_IMPORT_CABLE_LOSS("Energy.Active.Import.CableLoss"),
    ENERGY_ACTIVE_IMPORT_LOCAL_GENERATION_REGISTER("Energy.Active.Import.LocalGeneration.Register"),
    ENERGY_ACTIVE_NET("Energy.Active.Net"),
    ENERGY_ACTIVE_SETPOINT_INTERVAL("Energy.Active.Setpoint.Interval"),
    ENERGY_APPARENT_EXPORT("Energy.Apparent.Export"),
    ENERGY_APPARENT_IMPORT("Energy.Apparent.Import"),
    ENERGY_APPARENT_NET("Energy.Apparent.Net"),
    ENERGY_REACTIVE_EXPORT_INTERVAL("Energy.Reactive.Export.Interval"),
    ENERGY_REACTIVE_EXPORT_REGISTER("Energy.Reactive.Export.Register"),
    ENERGY_REACTIVE_IMPORT_INTERVAL("Energy.Reactive.Import.Interval"),
    ENERGY_REACTIVE_IMPORT_REGISTER("Energy.Reactive.Import.Register"),
    ENERGY_REACTIVE_NET("Energy.Reactive.Net"),
    ENERGY_REQUEST_TARGET("EnergyRequest.Target"),
    ENERGY_REQUEST_MINIMUM("EnergyRequest.Minimum"),
    ENERGY_REQUEST_MAXIMUM("EnergyRequest.Maximum"),
    ENERGY_REQUEST_MINIMUM_V_2_X("EnergyRequest.Minimum.V2X"),
    ENERGY_REQUEST_MAXIMUM_V_2_X("EnergyRequest.Maximum.V2X"),
    ENERGY_REQUEST_BULK("EnergyRequest.Bulk"),
    FREQUENCY("Frequency"),
    POWER_ACTIVE_EXPORT("Power.Active.Export"),
    POWER_ACTIVE_IMPORT("Power.Active.Import"),
    POWER_ACTIVE_SETPOINT("Power.Active.Setpoint"),
    POWER_ACTIVE_RESIDUAL("Power.Active.Residual"),
    POWER_EXPORT_MINIMUM("Power.Export.Minimum"),
    POWER_EXPORT_OFFERED("Power.Export.Offered"),
    POWER_FACTOR("Power.Factor"),
    POWER_IMPORT_OFFERED("Power.Import.Offered"),
    POWER_IMPORT_MINIMUM("Power.Import.Minimum"),
    POWER_OFFERED("Power.Offered"),
    POWER_REACTIVE_EXPORT("Power.Reactive.Export"),
    POWER_REACTIVE_IMPORT("Power.Reactive.Import"),
    SO_C("SoC"),
    VOLTAGE("Voltage"),
    VOLTAGE_MINIMUM("Voltage.Minimum"),
    VOLTAGE_MAXIMUM("Voltage.Maximum");
    private final String value;
    private final static Map<String, MeasurandEnum> CONSTANTS = new HashMap<String, MeasurandEnum>();

    static {
        for (MeasurandEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    MeasurandEnum(String value) {
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
    public static MeasurandEnum fromValue(String value) {
        MeasurandEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
