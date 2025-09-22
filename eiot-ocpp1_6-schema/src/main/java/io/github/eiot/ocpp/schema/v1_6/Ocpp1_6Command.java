package io.github.eiot.ocpp.schema.v1_6;

import io.github.eiot.CommandDef;
import io.github.eiot.RequestCommandDef;
import io.github.eiot.impl.CommandDefProtocol;
import io.github.eiot.ocpp.schema.v1_6.*;

// generated
public interface Ocpp1_6Command {

    CommandDefProtocol COMMAND_PROTOCOL = new CommandDefProtocol("ocpp1.6");

    CommandDef<ClearChargingProfileResponse> ClearChargingProfileResponse = COMMAND_PROTOCOL.createAndRegister("ClearChargingProfileResponse", ClearChargingProfileResponse.class);
    RequestCommandDef<ClearChargingProfileRequest, ClearChargingProfileResponse> ClearChargingProfileRequest =
            COMMAND_PROTOCOL.createAndRegister("ClearChargingProfile", ClearChargingProfileRequest.class, ClearChargingProfileResponse);

    CommandDef<ClearCacheResponse> ClearCacheResponse = COMMAND_PROTOCOL.createAndRegister("ClearCacheResponse", ClearCacheResponse.class);
    RequestCommandDef<ClearCacheRequest, ClearCacheResponse> ClearCacheRequest =
            COMMAND_PROTOCOL.createAndRegister("ClearCache", ClearCacheRequest.class, ClearCacheResponse);

    CommandDef<ChangeConfigurationResponse> ChangeConfigurationResponse = COMMAND_PROTOCOL.createAndRegister("ChangeConfigurationResponse", ChangeConfigurationResponse.class);
    RequestCommandDef<ChangeConfigurationRequest, ChangeConfigurationResponse> ChangeConfigurationRequest =
            COMMAND_PROTOCOL.createAndRegister("ChangeConfiguration", ChangeConfigurationRequest.class, ChangeConfigurationResponse);

    CommandDef<MeterValuesResponse> MeterValuesResponse = COMMAND_PROTOCOL.createAndRegister("MeterValuesResponse", MeterValuesResponse.class);
    RequestCommandDef<MeterValuesRequest, MeterValuesResponse> MeterValuesRequest =
            COMMAND_PROTOCOL.createAndRegister("MeterValues", MeterValuesRequest.class, MeterValuesResponse);

    CommandDef<GetLocalListVersionResponse> GetLocalListVersionResponse = COMMAND_PROTOCOL.createAndRegister("GetLocalListVersionResponse", GetLocalListVersionResponse.class);
    RequestCommandDef<GetLocalListVersionRequest, GetLocalListVersionResponse> GetLocalListVersionRequest =
            COMMAND_PROTOCOL.createAndRegister("GetLocalListVersion", GetLocalListVersionRequest.class, GetLocalListVersionResponse);

    CommandDef<UnlockConnectorResponse> UnlockConnectorResponse = COMMAND_PROTOCOL.createAndRegister("UnlockConnectorResponse", UnlockConnectorResponse.class);
    RequestCommandDef<UnlockConnectorRequest, UnlockConnectorResponse> UnlockConnectorRequest =
            COMMAND_PROTOCOL.createAndRegister("UnlockConnector", UnlockConnectorRequest.class, UnlockConnectorResponse);

    CommandDef<SetChargingProfileResponse> SetChargingProfileResponse = COMMAND_PROTOCOL.createAndRegister("SetChargingProfileResponse", SetChargingProfileResponse.class);
    RequestCommandDef<SetChargingProfileRequest, SetChargingProfileResponse> SetChargingProfileRequest =
            COMMAND_PROTOCOL.createAndRegister("SetChargingProfile", SetChargingProfileRequest.class, SetChargingProfileResponse);

    CommandDef<ChangeAvailabilityResponse> ChangeAvailabilityResponse = COMMAND_PROTOCOL.createAndRegister("ChangeAvailabilityResponse", ChangeAvailabilityResponse.class);
    RequestCommandDef<ChangeAvailabilityRequest, ChangeAvailabilityResponse> ChangeAvailabilityRequest =
            COMMAND_PROTOCOL.createAndRegister("ChangeAvailability", ChangeAvailabilityRequest.class, ChangeAvailabilityResponse);

    CommandDef<UpdateFirmwareResponse> UpdateFirmwareResponse = COMMAND_PROTOCOL.createAndRegister("UpdateFirmwareResponse", UpdateFirmwareResponse.class);
    RequestCommandDef<UpdateFirmwareRequest, UpdateFirmwareResponse> UpdateFirmwareRequest =
            COMMAND_PROTOCOL.createAndRegister("UpdateFirmware", UpdateFirmwareRequest.class, UpdateFirmwareResponse);

    CommandDef<BootNotificationResponse> BootNotificationResponse = COMMAND_PROTOCOL.createAndRegister("BootNotificationResponse", BootNotificationResponse.class);
    RequestCommandDef<BootNotificationRequest, BootNotificationResponse> BootNotificationRequest =
            COMMAND_PROTOCOL.createAndRegister("BootNotification", BootNotificationRequest.class, BootNotificationResponse);

    CommandDef<FirmwareStatusNotificationResponse> FirmwareStatusNotificationResponse = COMMAND_PROTOCOL.createAndRegister("FirmwareStatusNotificationResponse", FirmwareStatusNotificationResponse.class);
    RequestCommandDef<FirmwareStatusNotificationRequest, FirmwareStatusNotificationResponse> FirmwareStatusNotificationRequest =
            COMMAND_PROTOCOL.createAndRegister("FirmwareStatusNotification", FirmwareStatusNotificationRequest.class, FirmwareStatusNotificationResponse);

    CommandDef<DataTransferResponse> DataTransferResponse = COMMAND_PROTOCOL.createAndRegister("DataTransferResponse", DataTransferResponse.class);
    RequestCommandDef<DataTransferRequest, DataTransferResponse> DataTransferRequest =
            COMMAND_PROTOCOL.createAndRegister("DataTransfer", DataTransferRequest.class, DataTransferResponse);

    CommandDef<DiagnosticsStatusNotificationResponse> DiagnosticsStatusNotificationResponse = COMMAND_PROTOCOL.createAndRegister("DiagnosticsStatusNotificationResponse", DiagnosticsStatusNotificationResponse.class);
    RequestCommandDef<DiagnosticsStatusNotificationRequest, DiagnosticsStatusNotificationResponse> DiagnosticsStatusNotificationRequest =
            COMMAND_PROTOCOL.createAndRegister("DiagnosticsStatusNotification", DiagnosticsStatusNotificationRequest.class, DiagnosticsStatusNotificationResponse);

    CommandDef<RemoteStartTransactionResponse> RemoteStartTransactionResponse = COMMAND_PROTOCOL.createAndRegister("RemoteStartTransactionResponse", RemoteStartTransactionResponse.class);
    RequestCommandDef<RemoteStartTransactionRequest, RemoteStartTransactionResponse> RemoteStartTransactionRequest =
            COMMAND_PROTOCOL.createAndRegister("RemoteStartTransaction", RemoteStartTransactionRequest.class, RemoteStartTransactionResponse);

    CommandDef<ResetResponse> ResetResponse = COMMAND_PROTOCOL.createAndRegister("ResetResponse", ResetResponse.class);
    RequestCommandDef<ResetRequest, ResetResponse> ResetRequest =
            COMMAND_PROTOCOL.createAndRegister("Reset", ResetRequest.class, ResetResponse);

    CommandDef<StartTransactionResponse> StartTransactionResponse = COMMAND_PROTOCOL.createAndRegister("StartTransactionResponse", StartTransactionResponse.class);
    RequestCommandDef<StartTransactionRequest, StartTransactionResponse> StartTransactionRequest =
            COMMAND_PROTOCOL.createAndRegister("StartTransaction", StartTransactionRequest.class, StartTransactionResponse);

    CommandDef<ReserveNowResponse> ReserveNowResponse = COMMAND_PROTOCOL.createAndRegister("ReserveNowResponse", ReserveNowResponse.class);
    RequestCommandDef<ReserveNowRequest, ReserveNowResponse> ReserveNowRequest =
            COMMAND_PROTOCOL.createAndRegister("ReserveNow", ReserveNowRequest.class, ReserveNowResponse);

    CommandDef<StatusNotificationResponse> StatusNotificationResponse = COMMAND_PROTOCOL.createAndRegister("StatusNotificationResponse", StatusNotificationResponse.class);
    RequestCommandDef<StatusNotificationRequest, StatusNotificationResponse> StatusNotificationRequest =
            COMMAND_PROTOCOL.createAndRegister("StatusNotification", StatusNotificationRequest.class, StatusNotificationResponse);

    CommandDef<RemoteStopTransactionResponse> RemoteStopTransactionResponse = COMMAND_PROTOCOL.createAndRegister("RemoteStopTransactionResponse", RemoteStopTransactionResponse.class);
    RequestCommandDef<RemoteStopTransactionRequest, RemoteStopTransactionResponse> RemoteStopTransactionRequest =
            COMMAND_PROTOCOL.createAndRegister("RemoteStopTransaction", RemoteStopTransactionRequest.class, RemoteStopTransactionResponse);

    CommandDef<StopTransactionResponse> StopTransactionResponse = COMMAND_PROTOCOL.createAndRegister("StopTransactionResponse", StopTransactionResponse.class);
    RequestCommandDef<StopTransactionRequest, StopTransactionResponse> StopTransactionRequest =
            COMMAND_PROTOCOL.createAndRegister("StopTransaction", StopTransactionRequest.class, StopTransactionResponse);

    CommandDef<GetDiagnosticsResponse> GetDiagnosticsResponse = COMMAND_PROTOCOL.createAndRegister("GetDiagnosticsResponse", GetDiagnosticsResponse.class);
    RequestCommandDef<GetDiagnosticsRequest, GetDiagnosticsResponse> GetDiagnosticsRequest =
            COMMAND_PROTOCOL.createAndRegister("GetDiagnostics", GetDiagnosticsRequest.class, GetDiagnosticsResponse);

    CommandDef<AuthorizeResponse> AuthorizeResponse = COMMAND_PROTOCOL.createAndRegister("AuthorizeResponse", AuthorizeResponse.class);
    RequestCommandDef<AuthorizeRequest, AuthorizeResponse> AuthorizeRequest =
            COMMAND_PROTOCOL.createAndRegister("Authorize", AuthorizeRequest.class, AuthorizeResponse);

    CommandDef<HeartbeatResponse> HeartbeatResponse = COMMAND_PROTOCOL.createAndRegister("HeartbeatResponse", HeartbeatResponse.class);
    RequestCommandDef<HeartbeatRequest, HeartbeatResponse> HeartbeatRequest =
            COMMAND_PROTOCOL.createAndRegister("Heartbeat", HeartbeatRequest.class, HeartbeatResponse);

    CommandDef<GetConfigurationResponse> GetConfigurationResponse = COMMAND_PROTOCOL.createAndRegister("GetConfigurationResponse", GetConfigurationResponse.class);
    RequestCommandDef<GetConfigurationRequest, GetConfigurationResponse> GetConfigurationRequest =
            COMMAND_PROTOCOL.createAndRegister("GetConfiguration", GetConfigurationRequest.class, GetConfigurationResponse);

    CommandDef<GetCompositeScheduleResponse> GetCompositeScheduleResponse = COMMAND_PROTOCOL.createAndRegister("GetCompositeScheduleResponse", GetCompositeScheduleResponse.class);
    RequestCommandDef<GetCompositeScheduleRequest, GetCompositeScheduleResponse> GetCompositeScheduleRequest =
            COMMAND_PROTOCOL.createAndRegister("GetCompositeSchedule", GetCompositeScheduleRequest.class, GetCompositeScheduleResponse);

    CommandDef<TriggerMessageResponse> TriggerMessageResponse = COMMAND_PROTOCOL.createAndRegister("TriggerMessageResponse", TriggerMessageResponse.class);
    RequestCommandDef<TriggerMessageRequest, TriggerMessageResponse> TriggerMessageRequest =
            COMMAND_PROTOCOL.createAndRegister("TriggerMessage", TriggerMessageRequest.class, TriggerMessageResponse);

    CommandDef<CancelReservationResponse> CancelReservationResponse = COMMAND_PROTOCOL.createAndRegister("CancelReservationResponse", CancelReservationResponse.class);
    RequestCommandDef<CancelReservationRequest, CancelReservationResponse> CancelReservationRequest =
            COMMAND_PROTOCOL.createAndRegister("CancelReservation", CancelReservationRequest.class, CancelReservationResponse);

    CommandDef<SendLocalListResponse> SendLocalListResponse = COMMAND_PROTOCOL.createAndRegister("SendLocalListResponse", SendLocalListResponse.class);
    RequestCommandDef<SendLocalListRequest, SendLocalListResponse> SendLocalListRequest =
            COMMAND_PROTOCOL.createAndRegister("SendLocalList", SendLocalListRequest.class, SendLocalListResponse);

    static CommandDef<?> match(String command) {
        return COMMAND_PROTOCOL.match(command);
    }
}