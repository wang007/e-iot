package io.github.eiot.ocpp.schema.v1_6;

import io.github.eiot.CommandDef;
import io.github.eiot.impl.CommandDefProtocol;

// generated
public interface Ocpp1_6Command {

    CommandDefProtocol COMMAND_PROTOCOL = new CommandDefProtocol("ocpp1.6");

    CommandDef<ClearChargingProfileResponse> ClearChargingProfileResponse = COMMAND_PROTOCOL.createAndRegister("ClearChargingProfileResponse", ClearChargingProfileResponse.class, null);
    CommandDef<ClearChargingProfileRequest> ClearChargingProfileRequest = COMMAND_PROTOCOL.createAndRegister("ClearChargingProfile", ClearChargingProfileRequest.class, ClearChargingProfileResponse);

    CommandDef<ClearCacheResponse> ClearCacheResponse = COMMAND_PROTOCOL.createAndRegister("ClearCacheResponse", ClearCacheResponse.class, null);
    CommandDef<ClearCacheRequest> ClearCacheRequest = COMMAND_PROTOCOL.createAndRegister("ClearCache", ClearCacheRequest.class, ClearCacheResponse);

    CommandDef<ChangeConfigurationResponse> ChangeConfigurationResponse = COMMAND_PROTOCOL.createAndRegister("ChangeConfigurationResponse", ChangeConfigurationResponse.class, null);
    CommandDef<ChangeConfigurationRequest> ChangeConfigurationRequest = COMMAND_PROTOCOL.createAndRegister("ChangeConfiguration", ChangeConfigurationRequest.class, ChangeConfigurationResponse);

    CommandDef<MeterValuesResponse> MeterValuesResponse = COMMAND_PROTOCOL.createAndRegister("MeterValuesResponse", MeterValuesResponse.class, null);
    CommandDef<MeterValuesRequest> MeterValuesRequest = COMMAND_PROTOCOL.createAndRegister("MeterValues", MeterValuesRequest.class, MeterValuesResponse);

    CommandDef<GetLocalListVersionResponse> GetLocalListVersionResponse = COMMAND_PROTOCOL.createAndRegister("GetLocalListVersionResponse", GetLocalListVersionResponse.class, null);
    CommandDef<GetLocalListVersionRequest> GetLocalListVersionRequest = COMMAND_PROTOCOL.createAndRegister("GetLocalListVersion", GetLocalListVersionRequest.class, GetLocalListVersionResponse);

    CommandDef<UnlockConnectorResponse> UnlockConnectorResponse = COMMAND_PROTOCOL.createAndRegister("UnlockConnectorResponse", UnlockConnectorResponse.class, null);
    CommandDef<UnlockConnectorRequest> UnlockConnectorRequest = COMMAND_PROTOCOL.createAndRegister("UnlockConnector", UnlockConnectorRequest.class, UnlockConnectorResponse);

    CommandDef<SetChargingProfileResponse> SetChargingProfileResponse = COMMAND_PROTOCOL.createAndRegister("SetChargingProfileResponse", SetChargingProfileResponse.class, null);
    CommandDef<SetChargingProfileRequest> SetChargingProfileRequest = COMMAND_PROTOCOL.createAndRegister("SetChargingProfile", SetChargingProfileRequest.class, SetChargingProfileResponse);

    CommandDef<ChangeAvailabilityResponse> ChangeAvailabilityResponse = COMMAND_PROTOCOL.createAndRegister("ChangeAvailabilityResponse", ChangeAvailabilityResponse.class, null);
    CommandDef<ChangeAvailabilityRequest> ChangeAvailabilityRequest = COMMAND_PROTOCOL.createAndRegister("ChangeAvailability", ChangeAvailabilityRequest.class, ChangeAvailabilityResponse);

    CommandDef<UpdateFirmwareResponse> UpdateFirmwareResponse = COMMAND_PROTOCOL.createAndRegister("UpdateFirmwareResponse", UpdateFirmwareResponse.class, null);
    CommandDef<UpdateFirmwareRequest> UpdateFirmwareRequest = COMMAND_PROTOCOL.createAndRegister("UpdateFirmware", UpdateFirmwareRequest.class, UpdateFirmwareResponse);

    CommandDef<BootNotificationResponse> BootNotificationResponse = COMMAND_PROTOCOL.createAndRegister("BootNotificationResponse", BootNotificationResponse.class, null);
    CommandDef<BootNotificationRequest> BootNotificationRequest = COMMAND_PROTOCOL.createAndRegister("BootNotification", BootNotificationRequest.class, BootNotificationResponse);

    CommandDef<FirmwareStatusNotificationResponse> FirmwareStatusNotificationResponse = COMMAND_PROTOCOL.createAndRegister("FirmwareStatusNotificationResponse", FirmwareStatusNotificationResponse.class, null);
    CommandDef<FirmwareStatusNotificationRequest> FirmwareStatusNotificationRequest = COMMAND_PROTOCOL.createAndRegister("FirmwareStatusNotification", FirmwareStatusNotificationRequest.class, FirmwareStatusNotificationResponse);

    CommandDef<DataTransferResponse> DataTransferResponse = COMMAND_PROTOCOL.createAndRegister("DataTransferResponse", DataTransferResponse.class, null);
    CommandDef<DataTransferRequest> DataTransferRequest = COMMAND_PROTOCOL.createAndRegister("DataTransfer", DataTransferRequest.class, DataTransferResponse);

    CommandDef<DiagnosticsStatusNotificationResponse> DiagnosticsStatusNotificationResponse = COMMAND_PROTOCOL.createAndRegister("DiagnosticsStatusNotificationResponse", DiagnosticsStatusNotificationResponse.class, null);
    CommandDef<DiagnosticsStatusNotificationRequest> DiagnosticsStatusNotificationRequest = COMMAND_PROTOCOL.createAndRegister("DiagnosticsStatusNotification", DiagnosticsStatusNotificationRequest.class, DiagnosticsStatusNotificationResponse);

    CommandDef<RemoteStartTransactionResponse> RemoteStartTransactionResponse = COMMAND_PROTOCOL.createAndRegister("RemoteStartTransactionResponse", RemoteStartTransactionResponse.class, null);
    CommandDef<RemoteStartTransactionRequest> RemoteStartTransactionRequest = COMMAND_PROTOCOL.createAndRegister("RemoteStartTransaction", RemoteStartTransactionRequest.class, RemoteStartTransactionResponse);

    CommandDef<ResetResponse> ResetResponse = COMMAND_PROTOCOL.createAndRegister("ResetResponse", ResetResponse.class, null);
    CommandDef<ResetRequest> ResetRequest = COMMAND_PROTOCOL.createAndRegister("Reset", ResetRequest.class, ResetResponse);

    CommandDef<StartTransactionResponse> StartTransactionResponse = COMMAND_PROTOCOL.createAndRegister("StartTransactionResponse", StartTransactionResponse.class, null);
    CommandDef<StartTransactionRequest> StartTransactionRequest = COMMAND_PROTOCOL.createAndRegister("StartTransaction", StartTransactionRequest.class, StartTransactionResponse);

    CommandDef<ReserveNowResponse> ReserveNowResponse = COMMAND_PROTOCOL.createAndRegister("ReserveNowResponse", ReserveNowResponse.class, null);
    CommandDef<ReserveNowRequest> ReserveNowRequest = COMMAND_PROTOCOL.createAndRegister("ReserveNow", ReserveNowRequest.class, ReserveNowResponse);

    CommandDef<StatusNotificationResponse> StatusNotificationResponse = COMMAND_PROTOCOL.createAndRegister("StatusNotificationResponse", StatusNotificationResponse.class, null);
    CommandDef<StatusNotificationRequest> StatusNotificationRequest = COMMAND_PROTOCOL.createAndRegister("StatusNotification", StatusNotificationRequest.class, StatusNotificationResponse);

    CommandDef<RemoteStopTransactionResponse> RemoteStopTransactionResponse = COMMAND_PROTOCOL.createAndRegister("RemoteStopTransactionResponse", RemoteStopTransactionResponse.class, null);
    CommandDef<RemoteStopTransactionRequest> RemoteStopTransactionRequest = COMMAND_PROTOCOL.createAndRegister("RemoteStopTransaction", RemoteStopTransactionRequest.class, RemoteStopTransactionResponse);

    CommandDef<StopTransactionResponse> StopTransactionResponse = COMMAND_PROTOCOL.createAndRegister("StopTransactionResponse", StopTransactionResponse.class, null);
    CommandDef<StopTransactionRequest> StopTransactionRequest = COMMAND_PROTOCOL.createAndRegister("StopTransaction", StopTransactionRequest.class, StopTransactionResponse);

    CommandDef<GetDiagnosticsResponse> GetDiagnosticsResponse = COMMAND_PROTOCOL.createAndRegister("GetDiagnosticsResponse", GetDiagnosticsResponse.class, null);
    CommandDef<GetDiagnosticsRequest> GetDiagnosticsRequest = COMMAND_PROTOCOL.createAndRegister("GetDiagnostics", GetDiagnosticsRequest.class, GetDiagnosticsResponse);

    CommandDef<AuthorizeResponse> AuthorizeResponse = COMMAND_PROTOCOL.createAndRegister("AuthorizeResponse", AuthorizeResponse.class, null);
    CommandDef<AuthorizeRequest> AuthorizeRequest = COMMAND_PROTOCOL.createAndRegister("Authorize", AuthorizeRequest.class, AuthorizeResponse);

    CommandDef<HeartbeatResponse> HeartbeatResponse = COMMAND_PROTOCOL.createAndRegister("HeartbeatResponse", HeartbeatResponse.class, null);
    CommandDef<HeartbeatRequest> HeartbeatRequest = COMMAND_PROTOCOL.createAndRegister("Heartbeat", HeartbeatRequest.class, HeartbeatResponse);

    CommandDef<GetConfigurationResponse> GetConfigurationResponse = COMMAND_PROTOCOL.createAndRegister("GetConfigurationResponse", GetConfigurationResponse.class, null);
    CommandDef<GetConfigurationRequest> GetConfigurationRequest = COMMAND_PROTOCOL.createAndRegister("GetConfiguration", GetConfigurationRequest.class, GetConfigurationResponse);

    CommandDef<GetCompositeScheduleResponse> GetCompositeScheduleResponse = COMMAND_PROTOCOL.createAndRegister("GetCompositeScheduleResponse", GetCompositeScheduleResponse.class, null);
    CommandDef<GetCompositeScheduleRequest> GetCompositeScheduleRequest = COMMAND_PROTOCOL.createAndRegister("GetCompositeSchedule", GetCompositeScheduleRequest.class, GetCompositeScheduleResponse);

    CommandDef<TriggerMessageResponse> TriggerMessageResponse = COMMAND_PROTOCOL.createAndRegister("TriggerMessageResponse", TriggerMessageResponse.class, null);
    CommandDef<TriggerMessageRequest> TriggerMessageRequest = COMMAND_PROTOCOL.createAndRegister("TriggerMessage", TriggerMessageRequest.class, TriggerMessageResponse);

    CommandDef<CancelReservationResponse> CancelReservationResponse = COMMAND_PROTOCOL.createAndRegister("CancelReservationResponse", CancelReservationResponse.class, null);
    CommandDef<CancelReservationRequest> CancelReservationRequest = COMMAND_PROTOCOL.createAndRegister("CancelReservation", CancelReservationRequest.class, CancelReservationResponse);

    CommandDef<SendLocalListResponse> SendLocalListResponse = COMMAND_PROTOCOL.createAndRegister("SendLocalListResponse", SendLocalListResponse.class, null);
    CommandDef<SendLocalListRequest> SendLocalListRequest = COMMAND_PROTOCOL.createAndRegister("SendLocalList", SendLocalListRequest.class, SendLocalListResponse);

    static CommandDef<?> match(String command) {
        return COMMAND_PROTOCOL.match(command);
    }
}