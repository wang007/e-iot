package io.github.eiot.ocpp.schema.v2_0_1;

import io.github.eiot.CommandDef;
import io.github.eiot.RequestCommandDef;
import io.github.eiot.impl.CommandDefProtocol;
import io.github.eiot.ocpp.schema.v2_0_1.*;

// generated
public interface Ocpp2_0_1Command {

    CommandDefProtocol COMMAND_PROTOCOL = new CommandDefProtocol("ocpp2.0.1");

    CommandDef<CustomerInformationResponse> CustomerInformationResponse = COMMAND_PROTOCOL.createAndRegister("CustomerInformationResponse", CustomerInformationResponse.class);
    RequestCommandDef<CustomerInformationRequest, CustomerInformationResponse> CustomerInformationRequest =
            COMMAND_PROTOCOL.createAndRegister("CustomerInformation", CustomerInformationRequest.class, CustomerInformationResponse);

    CommandDef<NotifyEVChargingNeedsResponse> NotifyEVChargingNeedsResponse = COMMAND_PROTOCOL.createAndRegister("NotifyEVChargingNeedsResponse", NotifyEVChargingNeedsResponse.class);
    RequestCommandDef<NotifyEVChargingNeedsRequest, NotifyEVChargingNeedsResponse> NotifyEVChargingNeedsRequest =
            COMMAND_PROTOCOL.createAndRegister("NotifyEVChargingNeeds", NotifyEVChargingNeedsRequest.class, NotifyEVChargingNeedsResponse);

    CommandDef<MeterValuesResponse> MeterValuesResponse = COMMAND_PROTOCOL.createAndRegister("MeterValuesResponse", MeterValuesResponse.class);
    RequestCommandDef<MeterValuesRequest, MeterValuesResponse> MeterValuesRequest =
            COMMAND_PROTOCOL.createAndRegister("MeterValues", MeterValuesRequest.class, MeterValuesResponse);

    CommandDef<InstallCertificateResponse> InstallCertificateResponse = COMMAND_PROTOCOL.createAndRegister("InstallCertificateResponse", InstallCertificateResponse.class);
    RequestCommandDef<InstallCertificateRequest, InstallCertificateResponse> InstallCertificateRequest =
            COMMAND_PROTOCOL.createAndRegister("InstallCertificate", InstallCertificateRequest.class, InstallCertificateResponse);

    CommandDef<ClearedChargingLimitResponse> ClearedChargingLimitResponse = COMMAND_PROTOCOL.createAndRegister("ClearedChargingLimitResponse", ClearedChargingLimitResponse.class);
    RequestCommandDef<ClearedChargingLimitRequest, ClearedChargingLimitResponse> ClearedChargingLimitRequest =
            COMMAND_PROTOCOL.createAndRegister("ClearedChargingLimit", ClearedChargingLimitRequest.class, ClearedChargingLimitResponse);

    CommandDef<SignCertificateResponse> SignCertificateResponse = COMMAND_PROTOCOL.createAndRegister("SignCertificateResponse", SignCertificateResponse.class);
    RequestCommandDef<SignCertificateRequest, SignCertificateResponse> SignCertificateRequest =
            COMMAND_PROTOCOL.createAndRegister("SignCertificate", SignCertificateRequest.class, SignCertificateResponse);

    CommandDef<BootNotificationResponse> BootNotificationResponse = COMMAND_PROTOCOL.createAndRegister("BootNotificationResponse", BootNotificationResponse.class);
    RequestCommandDef<BootNotificationRequest, BootNotificationResponse> BootNotificationRequest =
            COMMAND_PROTOCOL.createAndRegister("BootNotification", BootNotificationRequest.class, BootNotificationResponse);

    CommandDef<DataTransferResponse> DataTransferResponse = COMMAND_PROTOCOL.createAndRegister("DataTransferResponse", DataTransferResponse.class);
    RequestCommandDef<DataTransferRequest, DataTransferResponse> DataTransferRequest =
            COMMAND_PROTOCOL.createAndRegister("DataTransfer", DataTransferRequest.class, DataTransferResponse);

    CommandDef<ReportChargingProfilesResponse> ReportChargingProfilesResponse = COMMAND_PROTOCOL.createAndRegister("ReportChargingProfilesResponse", ReportChargingProfilesResponse.class);
    RequestCommandDef<ReportChargingProfilesRequest, ReportChargingProfilesResponse> ReportChargingProfilesRequest =
            COMMAND_PROTOCOL.createAndRegister("ReportChargingProfiles", ReportChargingProfilesRequest.class, ReportChargingProfilesResponse);

    CommandDef<PublishFirmwareStatusNotificationResponse> PublishFirmwareStatusNotificationResponse = COMMAND_PROTOCOL.createAndRegister("PublishFirmwareStatusNotificationResponse", PublishFirmwareStatusNotificationResponse.class);
    RequestCommandDef<PublishFirmwareStatusNotificationRequest, PublishFirmwareStatusNotificationResponse> PublishFirmwareStatusNotificationRequest =
            COMMAND_PROTOCOL.createAndRegister("PublishFirmwareStatusNotification", PublishFirmwareStatusNotificationRequest.class, PublishFirmwareStatusNotificationResponse);

    CommandDef<ResetResponse> ResetResponse = COMMAND_PROTOCOL.createAndRegister("ResetResponse", ResetResponse.class);
    RequestCommandDef<ResetRequest, ResetResponse> ResetRequest =
            COMMAND_PROTOCOL.createAndRegister("Reset", ResetRequest.class, ResetResponse);

    CommandDef<NotifyChargingLimitResponse> NotifyChargingLimitResponse = COMMAND_PROTOCOL.createAndRegister("NotifyChargingLimitResponse", NotifyChargingLimitResponse.class);
    RequestCommandDef<NotifyChargingLimitRequest, NotifyChargingLimitResponse> NotifyChargingLimitRequest =
            COMMAND_PROTOCOL.createAndRegister("NotifyChargingLimit", NotifyChargingLimitRequest.class, NotifyChargingLimitResponse);

    CommandDef<NotifyReportResponse> NotifyReportResponse = COMMAND_PROTOCOL.createAndRegister("NotifyReportResponse", NotifyReportResponse.class);
    RequestCommandDef<NotifyReportRequest, NotifyReportResponse> NotifyReportRequest =
            COMMAND_PROTOCOL.createAndRegister("NotifyReport", NotifyReportRequest.class, NotifyReportResponse);

    CommandDef<ReserveNowResponse> ReserveNowResponse = COMMAND_PROTOCOL.createAndRegister("ReserveNowResponse", ReserveNowResponse.class);
    RequestCommandDef<ReserveNowRequest, ReserveNowResponse> ReserveNowRequest =
            COMMAND_PROTOCOL.createAndRegister("ReserveNow", ReserveNowRequest.class, ReserveNowResponse);

    CommandDef<GetBaseReportResponse> GetBaseReportResponse = COMMAND_PROTOCOL.createAndRegister("GetBaseReportResponse", GetBaseReportResponse.class);
    RequestCommandDef<GetBaseReportRequest, GetBaseReportResponse> GetBaseReportRequest =
            COMMAND_PROTOCOL.createAndRegister("GetBaseReport", GetBaseReportRequest.class, GetBaseReportResponse);

    CommandDef<GetChargingProfilesResponse> GetChargingProfilesResponse = COMMAND_PROTOCOL.createAndRegister("GetChargingProfilesResponse", GetChargingProfilesResponse.class);
    RequestCommandDef<GetChargingProfilesRequest, GetChargingProfilesResponse> GetChargingProfilesRequest =
            COMMAND_PROTOCOL.createAndRegister("GetChargingProfiles", GetChargingProfilesRequest.class, GetChargingProfilesResponse);

    CommandDef<CertificateSignedResponse> CertificateSignedResponse = COMMAND_PROTOCOL.createAndRegister("CertificateSignedResponse", CertificateSignedResponse.class);
    RequestCommandDef<CertificateSignedRequest, CertificateSignedResponse> CertificateSignedRequest =
            COMMAND_PROTOCOL.createAndRegister("CertificateSigned", CertificateSignedRequest.class, CertificateSignedResponse);

    CommandDef<GetMonitoringReportResponse> GetMonitoringReportResponse = COMMAND_PROTOCOL.createAndRegister("GetMonitoringReportResponse", GetMonitoringReportResponse.class);
    RequestCommandDef<GetMonitoringReportRequest, GetMonitoringReportResponse> GetMonitoringReportRequest =
            COMMAND_PROTOCOL.createAndRegister("GetMonitoringReport", GetMonitoringReportRequest.class, GetMonitoringReportResponse);

    CommandDef<NotifyEVChargingScheduleResponse> NotifyEVChargingScheduleResponse = COMMAND_PROTOCOL.createAndRegister("NotifyEVChargingScheduleResponse", NotifyEVChargingScheduleResponse.class);
    RequestCommandDef<NotifyEVChargingScheduleRequest, NotifyEVChargingScheduleResponse> NotifyEVChargingScheduleRequest =
            COMMAND_PROTOCOL.createAndRegister("NotifyEVChargingSchedule", NotifyEVChargingScheduleRequest.class, NotifyEVChargingScheduleResponse);

    CommandDef<ClearVariableMonitoringResponse> ClearVariableMonitoringResponse = COMMAND_PROTOCOL.createAndRegister("ClearVariableMonitoringResponse", ClearVariableMonitoringResponse.class);
    RequestCommandDef<ClearVariableMonitoringRequest, ClearVariableMonitoringResponse> ClearVariableMonitoringRequest =
            COMMAND_PROTOCOL.createAndRegister("ClearVariableMonitoring", ClearVariableMonitoringRequest.class, ClearVariableMonitoringResponse);

    CommandDef<SetNetworkProfileResponse> SetNetworkProfileResponse = COMMAND_PROTOCOL.createAndRegister("SetNetworkProfileResponse", SetNetworkProfileResponse.class);
    RequestCommandDef<SetNetworkProfileRequest, SetNetworkProfileResponse> SetNetworkProfileRequest =
            COMMAND_PROTOCOL.createAndRegister("SetNetworkProfile", SetNetworkProfileRequest.class, SetNetworkProfileResponse);

    CommandDef<GetInstalledCertificateIdsResponse> GetInstalledCertificateIdsResponse = COMMAND_PROTOCOL.createAndRegister("GetInstalledCertificateIdsResponse", GetInstalledCertificateIdsResponse.class);
    RequestCommandDef<GetInstalledCertificateIdsRequest, GetInstalledCertificateIdsResponse> GetInstalledCertificateIdsRequest =
            COMMAND_PROTOCOL.createAndRegister("GetInstalledCertificateIds", GetInstalledCertificateIdsRequest.class, GetInstalledCertificateIdsResponse);

    CommandDef<RequestStopTransactionResponse> RequestStopTransactionResponse = COMMAND_PROTOCOL.createAndRegister("RequestStopTransactionResponse", RequestStopTransactionResponse.class);
    RequestCommandDef<RequestStopTransactionRequest, RequestStopTransactionResponse> RequestStopTransactionRequest =
            COMMAND_PROTOCOL.createAndRegister("RequestStopTransaction", RequestStopTransactionRequest.class, RequestStopTransactionResponse);

    CommandDef<PublishFirmwareResponse> PublishFirmwareResponse = COMMAND_PROTOCOL.createAndRegister("PublishFirmwareResponse", PublishFirmwareResponse.class);
    RequestCommandDef<PublishFirmwareRequest, PublishFirmwareResponse> PublishFirmwareRequest =
            COMMAND_PROTOCOL.createAndRegister("PublishFirmware", PublishFirmwareRequest.class, PublishFirmwareResponse);

    CommandDef<NotifyEventResponse> NotifyEventResponse = COMMAND_PROTOCOL.createAndRegister("NotifyEventResponse", NotifyEventResponse.class);
    RequestCommandDef<NotifyEventRequest, NotifyEventResponse> NotifyEventRequest =
            COMMAND_PROTOCOL.createAndRegister("NotifyEvent", NotifyEventRequest.class, NotifyEventResponse);

    CommandDef<ReservationStatusUpdateResponse> ReservationStatusUpdateResponse = COMMAND_PROTOCOL.createAndRegister("ReservationStatusUpdateResponse", ReservationStatusUpdateResponse.class);
    RequestCommandDef<ReservationStatusUpdateRequest, ReservationStatusUpdateResponse> ReservationStatusUpdateRequest =
            COMMAND_PROTOCOL.createAndRegister("ReservationStatusUpdate", ReservationStatusUpdateRequest.class, ReservationStatusUpdateResponse);

    CommandDef<AuthorizeResponse> AuthorizeResponse = COMMAND_PROTOCOL.createAndRegister("AuthorizeResponse", AuthorizeResponse.class);
    RequestCommandDef<AuthorizeRequest, AuthorizeResponse> AuthorizeRequest =
            COMMAND_PROTOCOL.createAndRegister("Authorize", AuthorizeRequest.class, AuthorizeResponse);

    CommandDef<GetVariablesResponse> GetVariablesResponse = COMMAND_PROTOCOL.createAndRegister("GetVariablesResponse", GetVariablesResponse.class);
    RequestCommandDef<GetVariablesRequest, GetVariablesResponse> GetVariablesRequest =
            COMMAND_PROTOCOL.createAndRegister("GetVariables", GetVariablesRequest.class, GetVariablesResponse);

    CommandDef<Get15118EVCertificateResponse> Get15118EVCertificateResponse = COMMAND_PROTOCOL.createAndRegister("Get15118EVCertificateResponse", Get15118EVCertificateResponse.class);
    RequestCommandDef<Get15118EVCertificateRequest, Get15118EVCertificateResponse> Get15118EVCertificateRequest =
            COMMAND_PROTOCOL.createAndRegister("Get15118EVCertificate", Get15118EVCertificateRequest.class, Get15118EVCertificateResponse);

    CommandDef<NotifyCustomerInformationResponse> NotifyCustomerInformationResponse = COMMAND_PROTOCOL.createAndRegister("NotifyCustomerInformationResponse", NotifyCustomerInformationResponse.class);
    RequestCommandDef<NotifyCustomerInformationRequest, NotifyCustomerInformationResponse> NotifyCustomerInformationRequest =
            COMMAND_PROTOCOL.createAndRegister("NotifyCustomerInformation", NotifyCustomerInformationRequest.class, NotifyCustomerInformationResponse);

    CommandDef<DeleteCertificateResponse> DeleteCertificateResponse = COMMAND_PROTOCOL.createAndRegister("DeleteCertificateResponse", DeleteCertificateResponse.class);
    RequestCommandDef<DeleteCertificateRequest, DeleteCertificateResponse> DeleteCertificateRequest =
            COMMAND_PROTOCOL.createAndRegister("DeleteCertificate", DeleteCertificateRequest.class, DeleteCertificateResponse);

    CommandDef<CostUpdatedResponse> CostUpdatedResponse = COMMAND_PROTOCOL.createAndRegister("CostUpdatedResponse", CostUpdatedResponse.class);
    RequestCommandDef<CostUpdatedRequest, CostUpdatedResponse> CostUpdatedRequest =
            COMMAND_PROTOCOL.createAndRegister("CostUpdated", CostUpdatedRequest.class, CostUpdatedResponse);

    CommandDef<HeartbeatResponse> HeartbeatResponse = COMMAND_PROTOCOL.createAndRegister("HeartbeatResponse", HeartbeatResponse.class);
    RequestCommandDef<HeartbeatRequest, HeartbeatResponse> HeartbeatRequest =
            COMMAND_PROTOCOL.createAndRegister("Heartbeat", HeartbeatRequest.class, HeartbeatResponse);

    CommandDef<NotifyDisplayMessagesResponse> NotifyDisplayMessagesResponse = COMMAND_PROTOCOL.createAndRegister("NotifyDisplayMessagesResponse", NotifyDisplayMessagesResponse.class);
    RequestCommandDef<NotifyDisplayMessagesRequest, NotifyDisplayMessagesResponse> NotifyDisplayMessagesRequest =
            COMMAND_PROTOCOL.createAndRegister("NotifyDisplayMessages", NotifyDisplayMessagesRequest.class, NotifyDisplayMessagesResponse);

    CommandDef<TriggerMessageResponse> TriggerMessageResponse = COMMAND_PROTOCOL.createAndRegister("TriggerMessageResponse", TriggerMessageResponse.class);
    RequestCommandDef<TriggerMessageRequest, TriggerMessageResponse> TriggerMessageRequest =
            COMMAND_PROTOCOL.createAndRegister("TriggerMessage", TriggerMessageRequest.class, TriggerMessageResponse);

    CommandDef<SetMonitoringBaseResponse> SetMonitoringBaseResponse = COMMAND_PROTOCOL.createAndRegister("SetMonitoringBaseResponse", SetMonitoringBaseResponse.class);
    RequestCommandDef<SetMonitoringBaseRequest, SetMonitoringBaseResponse> SetMonitoringBaseRequest =
            COMMAND_PROTOCOL.createAndRegister("SetMonitoringBase", SetMonitoringBaseRequest.class, SetMonitoringBaseResponse);

    CommandDef<GetLogResponse> GetLogResponse = COMMAND_PROTOCOL.createAndRegister("GetLogResponse", GetLogResponse.class);
    RequestCommandDef<GetLogRequest, GetLogResponse> GetLogRequest =
            COMMAND_PROTOCOL.createAndRegister("GetLog", GetLogRequest.class, GetLogResponse);

    CommandDef<ClearChargingProfileResponse> ClearChargingProfileResponse = COMMAND_PROTOCOL.createAndRegister("ClearChargingProfileResponse", ClearChargingProfileResponse.class);
    RequestCommandDef<ClearChargingProfileRequest, ClearChargingProfileResponse> ClearChargingProfileRequest =
            COMMAND_PROTOCOL.createAndRegister("ClearChargingProfile", ClearChargingProfileRequest.class, ClearChargingProfileResponse);

    CommandDef<ClearCacheResponse> ClearCacheResponse = COMMAND_PROTOCOL.createAndRegister("ClearCacheResponse", ClearCacheResponse.class);
    RequestCommandDef<ClearCacheRequest, ClearCacheResponse> ClearCacheRequest =
            COMMAND_PROTOCOL.createAndRegister("ClearCache", ClearCacheRequest.class, ClearCacheResponse);

    CommandDef<GetDisplayMessagesResponse> GetDisplayMessagesResponse = COMMAND_PROTOCOL.createAndRegister("GetDisplayMessagesResponse", GetDisplayMessagesResponse.class);
    RequestCommandDef<GetDisplayMessagesRequest, GetDisplayMessagesResponse> GetDisplayMessagesRequest =
            COMMAND_PROTOCOL.createAndRegister("GetDisplayMessages", GetDisplayMessagesRequest.class, GetDisplayMessagesResponse);

    CommandDef<GetLocalListVersionResponse> GetLocalListVersionResponse = COMMAND_PROTOCOL.createAndRegister("GetLocalListVersionResponse", GetLocalListVersionResponse.class);
    RequestCommandDef<GetLocalListVersionRequest, GetLocalListVersionResponse> GetLocalListVersionRequest =
            COMMAND_PROTOCOL.createAndRegister("GetLocalListVersion", GetLocalListVersionRequest.class, GetLocalListVersionResponse);

    CommandDef<UnlockConnectorResponse> UnlockConnectorResponse = COMMAND_PROTOCOL.createAndRegister("UnlockConnectorResponse", UnlockConnectorResponse.class);
    RequestCommandDef<UnlockConnectorRequest, UnlockConnectorResponse> UnlockConnectorRequest =
            COMMAND_PROTOCOL.createAndRegister("UnlockConnector", UnlockConnectorRequest.class, UnlockConnectorResponse);

    CommandDef<SetVariableMonitoringResponse> SetVariableMonitoringResponse = COMMAND_PROTOCOL.createAndRegister("SetVariableMonitoringResponse", SetVariableMonitoringResponse.class);
    RequestCommandDef<SetVariableMonitoringRequest, SetVariableMonitoringResponse> SetVariableMonitoringRequest =
            COMMAND_PROTOCOL.createAndRegister("SetVariableMonitoring", SetVariableMonitoringRequest.class, SetVariableMonitoringResponse);

    CommandDef<SetChargingProfileResponse> SetChargingProfileResponse = COMMAND_PROTOCOL.createAndRegister("SetChargingProfileResponse", SetChargingProfileResponse.class);
    RequestCommandDef<SetChargingProfileRequest, SetChargingProfileResponse> SetChargingProfileRequest =
            COMMAND_PROTOCOL.createAndRegister("SetChargingProfile", SetChargingProfileRequest.class, SetChargingProfileResponse);

    CommandDef<ChangeAvailabilityResponse> ChangeAvailabilityResponse = COMMAND_PROTOCOL.createAndRegister("ChangeAvailabilityResponse", ChangeAvailabilityResponse.class);
    RequestCommandDef<ChangeAvailabilityRequest, ChangeAvailabilityResponse> ChangeAvailabilityRequest =
            COMMAND_PROTOCOL.createAndRegister("ChangeAvailability", ChangeAvailabilityRequest.class, ChangeAvailabilityResponse);

    CommandDef<SetDisplayMessageResponse> SetDisplayMessageResponse = COMMAND_PROTOCOL.createAndRegister("SetDisplayMessageResponse", SetDisplayMessageResponse.class);
    RequestCommandDef<SetDisplayMessageRequest, SetDisplayMessageResponse> SetDisplayMessageRequest =
            COMMAND_PROTOCOL.createAndRegister("SetDisplayMessage", SetDisplayMessageRequest.class, SetDisplayMessageResponse);

    CommandDef<UpdateFirmwareResponse> UpdateFirmwareResponse = COMMAND_PROTOCOL.createAndRegister("UpdateFirmwareResponse", UpdateFirmwareResponse.class);
    RequestCommandDef<UpdateFirmwareRequest, UpdateFirmwareResponse> UpdateFirmwareRequest =
            COMMAND_PROTOCOL.createAndRegister("UpdateFirmware", UpdateFirmwareRequest.class, UpdateFirmwareResponse);

    CommandDef<ClearDisplayMessageResponse> ClearDisplayMessageResponse = COMMAND_PROTOCOL.createAndRegister("ClearDisplayMessageResponse", ClearDisplayMessageResponse.class);
    RequestCommandDef<ClearDisplayMessageRequest, ClearDisplayMessageResponse> ClearDisplayMessageRequest =
            COMMAND_PROTOCOL.createAndRegister("ClearDisplayMessage", ClearDisplayMessageRequest.class, ClearDisplayMessageResponse);

    CommandDef<TransactionEventResponse> TransactionEventResponse = COMMAND_PROTOCOL.createAndRegister("TransactionEventResponse", TransactionEventResponse.class);
    RequestCommandDef<TransactionEventRequest, TransactionEventResponse> TransactionEventRequest =
            COMMAND_PROTOCOL.createAndRegister("TransactionEvent", TransactionEventRequest.class, TransactionEventResponse);

    CommandDef<FirmwareStatusNotificationResponse> FirmwareStatusNotificationResponse = COMMAND_PROTOCOL.createAndRegister("FirmwareStatusNotificationResponse", FirmwareStatusNotificationResponse.class);
    RequestCommandDef<FirmwareStatusNotificationRequest, FirmwareStatusNotificationResponse> FirmwareStatusNotificationRequest =
            COMMAND_PROTOCOL.createAndRegister("FirmwareStatusNotification", FirmwareStatusNotificationRequest.class, FirmwareStatusNotificationResponse);

    CommandDef<GetTransactionStatusResponse> GetTransactionStatusResponse = COMMAND_PROTOCOL.createAndRegister("GetTransactionStatusResponse", GetTransactionStatusResponse.class);
    RequestCommandDef<GetTransactionStatusRequest, GetTransactionStatusResponse> GetTransactionStatusRequest =
            COMMAND_PROTOCOL.createAndRegister("GetTransactionStatus", GetTransactionStatusRequest.class, GetTransactionStatusResponse);

    CommandDef<RequestStartTransactionResponse> RequestStartTransactionResponse = COMMAND_PROTOCOL.createAndRegister("RequestStartTransactionResponse", RequestStartTransactionResponse.class);
    RequestCommandDef<RequestStartTransactionRequest, RequestStartTransactionResponse> RequestStartTransactionRequest =
            COMMAND_PROTOCOL.createAndRegister("RequestStartTransaction", RequestStartTransactionRequest.class, RequestStartTransactionResponse);

    CommandDef<LogStatusNotificationResponse> LogStatusNotificationResponse = COMMAND_PROTOCOL.createAndRegister("LogStatusNotificationResponse", LogStatusNotificationResponse.class);
    RequestCommandDef<LogStatusNotificationRequest, LogStatusNotificationResponse> LogStatusNotificationRequest =
            COMMAND_PROTOCOL.createAndRegister("LogStatusNotification", LogStatusNotificationRequest.class, LogStatusNotificationResponse);

    CommandDef<GetReportResponse> GetReportResponse = COMMAND_PROTOCOL.createAndRegister("GetReportResponse", GetReportResponse.class);
    RequestCommandDef<GetReportRequest, GetReportResponse> GetReportRequest =
            COMMAND_PROTOCOL.createAndRegister("GetReport", GetReportRequest.class, GetReportResponse);

    CommandDef<SetMonitoringLevelResponse> SetMonitoringLevelResponse = COMMAND_PROTOCOL.createAndRegister("SetMonitoringLevelResponse", SetMonitoringLevelResponse.class);
    RequestCommandDef<SetMonitoringLevelRequest, SetMonitoringLevelResponse> SetMonitoringLevelRequest =
            COMMAND_PROTOCOL.createAndRegister("SetMonitoringLevel", SetMonitoringLevelRequest.class, SetMonitoringLevelResponse);

    CommandDef<SecurityEventNotificationResponse> SecurityEventNotificationResponse = COMMAND_PROTOCOL.createAndRegister("SecurityEventNotificationResponse", SecurityEventNotificationResponse.class);
    RequestCommandDef<SecurityEventNotificationRequest, SecurityEventNotificationResponse> SecurityEventNotificationRequest =
            COMMAND_PROTOCOL.createAndRegister("SecurityEventNotification", SecurityEventNotificationRequest.class, SecurityEventNotificationResponse);

    CommandDef<NotifyMonitoringReportResponse> NotifyMonitoringReportResponse = COMMAND_PROTOCOL.createAndRegister("NotifyMonitoringReportResponse", NotifyMonitoringReportResponse.class);
    RequestCommandDef<NotifyMonitoringReportRequest, NotifyMonitoringReportResponse> NotifyMonitoringReportRequest =
            COMMAND_PROTOCOL.createAndRegister("NotifyMonitoringReport", NotifyMonitoringReportRequest.class, NotifyMonitoringReportResponse);

    CommandDef<StatusNotificationResponse> StatusNotificationResponse = COMMAND_PROTOCOL.createAndRegister("StatusNotificationResponse", StatusNotificationResponse.class);
    RequestCommandDef<StatusNotificationRequest, StatusNotificationResponse> StatusNotificationRequest =
            COMMAND_PROTOCOL.createAndRegister("StatusNotification", StatusNotificationRequest.class, StatusNotificationResponse);

    CommandDef<GetCertificateStatusResponse> GetCertificateStatusResponse = COMMAND_PROTOCOL.createAndRegister("GetCertificateStatusResponse", GetCertificateStatusResponse.class);
    RequestCommandDef<GetCertificateStatusRequest, GetCertificateStatusResponse> GetCertificateStatusRequest =
            COMMAND_PROTOCOL.createAndRegister("GetCertificateStatus", GetCertificateStatusRequest.class, GetCertificateStatusResponse);

    CommandDef<UnpublishFirmwareResponse> UnpublishFirmwareResponse = COMMAND_PROTOCOL.createAndRegister("UnpublishFirmwareResponse", UnpublishFirmwareResponse.class);
    RequestCommandDef<UnpublishFirmwareRequest, UnpublishFirmwareResponse> UnpublishFirmwareRequest =
            COMMAND_PROTOCOL.createAndRegister("UnpublishFirmware", UnpublishFirmwareRequest.class, UnpublishFirmwareResponse);

    CommandDef<SetVariablesResponse> SetVariablesResponse = COMMAND_PROTOCOL.createAndRegister("SetVariablesResponse", SetVariablesResponse.class);
    RequestCommandDef<SetVariablesRequest, SetVariablesResponse> SetVariablesRequest =
            COMMAND_PROTOCOL.createAndRegister("SetVariables", SetVariablesRequest.class, SetVariablesResponse);

    CommandDef<GetCompositeScheduleResponse> GetCompositeScheduleResponse = COMMAND_PROTOCOL.createAndRegister("GetCompositeScheduleResponse", GetCompositeScheduleResponse.class);
    RequestCommandDef<GetCompositeScheduleRequest, GetCompositeScheduleResponse> GetCompositeScheduleRequest =
            COMMAND_PROTOCOL.createAndRegister("GetCompositeSchedule", GetCompositeScheduleRequest.class, GetCompositeScheduleResponse);

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