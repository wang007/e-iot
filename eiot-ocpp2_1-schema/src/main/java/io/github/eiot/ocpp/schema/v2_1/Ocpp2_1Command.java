package io.github.eiot.ocpp.schema.v2_1;

import io.github.eiot.CommandDef;
import io.github.eiot.impl.CommandDefProtocol;
import io.github.eiot.ocpp.schema.v2_1.*;

// generated
public interface Ocpp2_1Command {

    CommandDefProtocol COMMAND_PROTOCOL = new CommandDefProtocol("ocpp2.1");

    CommandDef<CustomerInformationResponse> CustomerInformationResponse = COMMAND_PROTOCOL.createAndRegister("CustomerInformationResponse", CustomerInformationResponse.class, null);
    CommandDef<CustomerInformationRequest> CustomerInformationRequest = COMMAND_PROTOCOL.createAndRegister("CustomerInformation", CustomerInformationRequest.class, CustomerInformationResponse);

    CommandDef<GetPeriodicEventStreamResponse> GetPeriodicEventStreamResponse = COMMAND_PROTOCOL.createAndRegister("GetPeriodicEventStreamResponse", GetPeriodicEventStreamResponse.class, null);
    CommandDef<GetPeriodicEventStreamRequest> GetPeriodicEventStreamRequest = COMMAND_PROTOCOL.createAndRegister("GetPeriodicEventStream", GetPeriodicEventStreamRequest.class, GetPeriodicEventStreamResponse);

    CommandDef<NotifyEVChargingNeedsResponse> NotifyEVChargingNeedsResponse = COMMAND_PROTOCOL.createAndRegister("NotifyEVChargingNeedsResponse", NotifyEVChargingNeedsResponse.class, null);
    CommandDef<NotifyEVChargingNeedsRequest> NotifyEVChargingNeedsRequest = COMMAND_PROTOCOL.createAndRegister("NotifyEVChargingNeeds", NotifyEVChargingNeedsRequest.class, NotifyEVChargingNeedsResponse);

    CommandDef<MeterValuesResponse> MeterValuesResponse = COMMAND_PROTOCOL.createAndRegister("MeterValuesResponse", MeterValuesResponse.class, null);
    CommandDef<MeterValuesRequest> MeterValuesRequest = COMMAND_PROTOCOL.createAndRegister("MeterValues", MeterValuesRequest.class, MeterValuesResponse);

    CommandDef<InstallCertificateResponse> InstallCertificateResponse = COMMAND_PROTOCOL.createAndRegister("InstallCertificateResponse", InstallCertificateResponse.class, null);
    CommandDef<InstallCertificateRequest> InstallCertificateRequest = COMMAND_PROTOCOL.createAndRegister("InstallCertificate", InstallCertificateRequest.class, InstallCertificateResponse);

    CommandDef<ClearedChargingLimitResponse> ClearedChargingLimitResponse = COMMAND_PROTOCOL.createAndRegister("ClearedChargingLimitResponse", ClearedChargingLimitResponse.class, null);
    CommandDef<ClearedChargingLimitRequest> ClearedChargingLimitRequest = COMMAND_PROTOCOL.createAndRegister("ClearedChargingLimit", ClearedChargingLimitRequest.class, ClearedChargingLimitResponse);

    CommandDef<SignCertificateResponse> SignCertificateResponse = COMMAND_PROTOCOL.createAndRegister("SignCertificateResponse", SignCertificateResponse.class, null);
    CommandDef<SignCertificateRequest> SignCertificateRequest = COMMAND_PROTOCOL.createAndRegister("SignCertificate", SignCertificateRequest.class, SignCertificateResponse);

    CommandDef<NotifyAllowedEnergyTransferResponse> NotifyAllowedEnergyTransferResponse = COMMAND_PROTOCOL.createAndRegister("NotifyAllowedEnergyTransferResponse", NotifyAllowedEnergyTransferResponse.class, null);
    CommandDef<NotifyAllowedEnergyTransferRequest> NotifyAllowedEnergyTransferRequest = COMMAND_PROTOCOL.createAndRegister("NotifyAllowedEnergyTransfer", NotifyAllowedEnergyTransferRequest.class, NotifyAllowedEnergyTransferResponse);

    CommandDef<SetDefaultTariffResponse> SetDefaultTariffResponse = COMMAND_PROTOCOL.createAndRegister("SetDefaultTariffResponse", SetDefaultTariffResponse.class, null);
    CommandDef<SetDefaultTariffRequest> SetDefaultTariffRequest = COMMAND_PROTOCOL.createAndRegister("SetDefaultTariff", SetDefaultTariffRequest.class, SetDefaultTariffResponse);

    CommandDef<ClosePeriodicEventStreamResponse> ClosePeriodicEventStreamResponse = COMMAND_PROTOCOL.createAndRegister("ClosePeriodicEventStreamResponse", ClosePeriodicEventStreamResponse.class, null);
    CommandDef<ClosePeriodicEventStreamRequest> ClosePeriodicEventStreamRequest = COMMAND_PROTOCOL.createAndRegister("ClosePeriodicEventStream", ClosePeriodicEventStreamRequest.class, ClosePeriodicEventStreamResponse);

    CommandDef<BootNotificationResponse> BootNotificationResponse = COMMAND_PROTOCOL.createAndRegister("BootNotificationResponse", BootNotificationResponse.class, null);
    CommandDef<BootNotificationRequest> BootNotificationRequest = COMMAND_PROTOCOL.createAndRegister("BootNotification", BootNotificationRequest.class, BootNotificationResponse);

    CommandDef<UsePriorityChargingResponse> UsePriorityChargingResponse = COMMAND_PROTOCOL.createAndRegister("UsePriorityChargingResponse", UsePriorityChargingResponse.class, null);
    CommandDef<UsePriorityChargingRequest> UsePriorityChargingRequest = COMMAND_PROTOCOL.createAndRegister("UsePriorityCharging", UsePriorityChargingRequest.class, UsePriorityChargingResponse);

    CommandDef<NotifyDERAlarmResponse> NotifyDERAlarmResponse = COMMAND_PROTOCOL.createAndRegister("NotifyDERAlarmResponse", NotifyDERAlarmResponse.class, null);
    CommandDef<NotifyDERAlarmRequest> NotifyDERAlarmRequest = COMMAND_PROTOCOL.createAndRegister("NotifyDERAlarm", NotifyDERAlarmRequest.class, NotifyDERAlarmResponse);

    CommandDef<DataTransferResponse> DataTransferResponse = COMMAND_PROTOCOL.createAndRegister("DataTransferResponse", DataTransferResponse.class, null);
    CommandDef<DataTransferRequest> DataTransferRequest = COMMAND_PROTOCOL.createAndRegister("DataTransfer", DataTransferRequest.class, DataTransferResponse);

    CommandDef<RequestBatterySwapResponse> RequestBatterySwapResponse = COMMAND_PROTOCOL.createAndRegister("RequestBatterySwapResponse", RequestBatterySwapResponse.class, null);
    CommandDef<RequestBatterySwapRequest> RequestBatterySwapRequest = COMMAND_PROTOCOL.createAndRegister("RequestBatterySwap", RequestBatterySwapRequest.class, RequestBatterySwapResponse);

    CommandDef<ReportChargingProfilesResponse> ReportChargingProfilesResponse = COMMAND_PROTOCOL.createAndRegister("ReportChargingProfilesResponse", ReportChargingProfilesResponse.class, null);
    CommandDef<ReportChargingProfilesRequest> ReportChargingProfilesRequest = COMMAND_PROTOCOL.createAndRegister("ReportChargingProfiles", ReportChargingProfilesRequest.class, ReportChargingProfilesResponse);

    CommandDef<PullDynamicScheduleUpdateResponse> PullDynamicScheduleUpdateResponse = COMMAND_PROTOCOL.createAndRegister("PullDynamicScheduleUpdateResponse", PullDynamicScheduleUpdateResponse.class, null);
    CommandDef<PullDynamicScheduleUpdateRequest> PullDynamicScheduleUpdateRequest = COMMAND_PROTOCOL.createAndRegister("PullDynamicScheduleUpdate", PullDynamicScheduleUpdateRequest.class, PullDynamicScheduleUpdateResponse);

    CommandDef<PublishFirmwareStatusNotificationResponse> PublishFirmwareStatusNotificationResponse = COMMAND_PROTOCOL.createAndRegister("PublishFirmwareStatusNotificationResponse", PublishFirmwareStatusNotificationResponse.class, null);
    CommandDef<PublishFirmwareStatusNotificationRequest> PublishFirmwareStatusNotificationRequest = COMMAND_PROTOCOL.createAndRegister("PublishFirmwareStatusNotification", PublishFirmwareStatusNotificationRequest.class, PublishFirmwareStatusNotificationResponse);

    CommandDef<NotifyWebPaymentStartedResponse> NotifyWebPaymentStartedResponse = COMMAND_PROTOCOL.createAndRegister("NotifyWebPaymentStartedResponse", NotifyWebPaymentStartedResponse.class, null);
    CommandDef<NotifyWebPaymentStartedRequest> NotifyWebPaymentStartedRequest = COMMAND_PROTOCOL.createAndRegister("NotifyWebPaymentStarted", NotifyWebPaymentStartedRequest.class, NotifyWebPaymentStartedResponse);

    CommandDef<NotifySettlementResponse> NotifySettlementResponse = COMMAND_PROTOCOL.createAndRegister("NotifySettlementResponse", NotifySettlementResponse.class, null);
    CommandDef<NotifySettlementRequest> NotifySettlementRequest = COMMAND_PROTOCOL.createAndRegister("NotifySettlement", NotifySettlementRequest.class, NotifySettlementResponse);

    CommandDef<ResetResponse> ResetResponse = COMMAND_PROTOCOL.createAndRegister("ResetResponse", ResetResponse.class, null);
    CommandDef<ResetRequest> ResetRequest = COMMAND_PROTOCOL.createAndRegister("Reset", ResetRequest.class, ResetResponse);

    CommandDef<NotifyChargingLimitResponse> NotifyChargingLimitResponse = COMMAND_PROTOCOL.createAndRegister("NotifyChargingLimitResponse", NotifyChargingLimitResponse.class, null);
    CommandDef<NotifyChargingLimitRequest> NotifyChargingLimitRequest = COMMAND_PROTOCOL.createAndRegister("NotifyChargingLimit", NotifyChargingLimitRequest.class, NotifyChargingLimitResponse);

    CommandDef<NotifyReportResponse> NotifyReportResponse = COMMAND_PROTOCOL.createAndRegister("NotifyReportResponse", NotifyReportResponse.class, null);
    CommandDef<NotifyReportRequest> NotifyReportRequest = COMMAND_PROTOCOL.createAndRegister("NotifyReport", NotifyReportRequest.class, NotifyReportResponse);

    CommandDef<ReserveNowResponse> ReserveNowResponse = COMMAND_PROTOCOL.createAndRegister("ReserveNowResponse", ReserveNowResponse.class, null);
    CommandDef<ReserveNowRequest> ReserveNowRequest = COMMAND_PROTOCOL.createAndRegister("ReserveNow", ReserveNowRequest.class, ReserveNowResponse);

    CommandDef<GetBaseReportResponse> GetBaseReportResponse = COMMAND_PROTOCOL.createAndRegister("GetBaseReportResponse", GetBaseReportResponse.class, null);
    CommandDef<GetBaseReportRequest> GetBaseReportRequest = COMMAND_PROTOCOL.createAndRegister("GetBaseReport", GetBaseReportRequest.class, GetBaseReportResponse);

    CommandDef<BatterySwapResponse> BatterySwapResponse = COMMAND_PROTOCOL.createAndRegister("BatterySwapResponse", BatterySwapResponse.class, null);
    CommandDef<BatterySwapRequest> BatterySwapRequest = COMMAND_PROTOCOL.createAndRegister("BatterySwap", BatterySwapRequest.class, BatterySwapResponse);

    CommandDef<NotifyDERStartStopResponse> NotifyDERStartStopResponse = COMMAND_PROTOCOL.createAndRegister("NotifyDERStartStopResponse", NotifyDERStartStopResponse.class, null);
    CommandDef<NotifyDERStartStopRequest> NotifyDERStartStopRequest = COMMAND_PROTOCOL.createAndRegister("NotifyDERStartStop", NotifyDERStartStopRequest.class, NotifyDERStartStopResponse);

    CommandDef<GetChargingProfilesResponse> GetChargingProfilesResponse = COMMAND_PROTOCOL.createAndRegister("GetChargingProfilesResponse", GetChargingProfilesResponse.class, null);
    CommandDef<GetChargingProfilesRequest> GetChargingProfilesRequest = COMMAND_PROTOCOL.createAndRegister("GetChargingProfiles", GetChargingProfilesRequest.class, GetChargingProfilesResponse);

    CommandDef<CertificateSignedResponse> CertificateSignedResponse = COMMAND_PROTOCOL.createAndRegister("CertificateSignedResponse", CertificateSignedResponse.class, null);
    CommandDef<CertificateSignedRequest> CertificateSignedRequest = COMMAND_PROTOCOL.createAndRegister("CertificateSigned", CertificateSignedRequest.class, CertificateSignedResponse);

    CommandDef<GetMonitoringReportResponse> GetMonitoringReportResponse = COMMAND_PROTOCOL.createAndRegister("GetMonitoringReportResponse", GetMonitoringReportResponse.class, null);
    CommandDef<GetMonitoringReportRequest> GetMonitoringReportRequest = COMMAND_PROTOCOL.createAndRegister("GetMonitoringReport", GetMonitoringReportRequest.class, GetMonitoringReportResponse);

    CommandDef<NotifyEVChargingScheduleResponse> NotifyEVChargingScheduleResponse = COMMAND_PROTOCOL.createAndRegister("NotifyEVChargingScheduleResponse", NotifyEVChargingScheduleResponse.class, null);
    CommandDef<NotifyEVChargingScheduleRequest> NotifyEVChargingScheduleRequest = COMMAND_PROTOCOL.createAndRegister("NotifyEVChargingSchedule", NotifyEVChargingScheduleRequest.class, NotifyEVChargingScheduleResponse);

    CommandDef<ClearVariableMonitoringResponse> ClearVariableMonitoringResponse = COMMAND_PROTOCOL.createAndRegister("ClearVariableMonitoringResponse", ClearVariableMonitoringResponse.class, null);
    CommandDef<ClearVariableMonitoringRequest> ClearVariableMonitoringRequest = COMMAND_PROTOCOL.createAndRegister("ClearVariableMonitoring", ClearVariableMonitoringRequest.class, ClearVariableMonitoringResponse);

    CommandDef<SetNetworkProfileResponse> SetNetworkProfileResponse = COMMAND_PROTOCOL.createAndRegister("SetNetworkProfileResponse", SetNetworkProfileResponse.class, null);
    CommandDef<SetNetworkProfileRequest> SetNetworkProfileRequest = COMMAND_PROTOCOL.createAndRegister("SetNetworkProfile", SetNetworkProfileRequest.class, SetNetworkProfileResponse);

    CommandDef<GetInstalledCertificateIdsResponse> GetInstalledCertificateIdsResponse = COMMAND_PROTOCOL.createAndRegister("GetInstalledCertificateIdsResponse", GetInstalledCertificateIdsResponse.class, null);
    CommandDef<GetInstalledCertificateIdsRequest> GetInstalledCertificateIdsRequest = COMMAND_PROTOCOL.createAndRegister("GetInstalledCertificateIds", GetInstalledCertificateIdsRequest.class, GetInstalledCertificateIdsResponse);

    CommandDef<RequestStopTransactionResponse> RequestStopTransactionResponse = COMMAND_PROTOCOL.createAndRegister("RequestStopTransactionResponse", RequestStopTransactionResponse.class, null);
    CommandDef<RequestStopTransactionRequest> RequestStopTransactionRequest = COMMAND_PROTOCOL.createAndRegister("RequestStopTransaction", RequestStopTransactionRequest.class, RequestStopTransactionResponse);

    CommandDef<PublishFirmwareResponse> PublishFirmwareResponse = COMMAND_PROTOCOL.createAndRegister("PublishFirmwareResponse", PublishFirmwareResponse.class, null);
    CommandDef<PublishFirmwareRequest> PublishFirmwareRequest = COMMAND_PROTOCOL.createAndRegister("PublishFirmware", PublishFirmwareRequest.class, PublishFirmwareResponse);

    CommandDef<AdjustPeriodicEventStreamResponse> AdjustPeriodicEventStreamResponse = COMMAND_PROTOCOL.createAndRegister("AdjustPeriodicEventStreamResponse", AdjustPeriodicEventStreamResponse.class, null);
    CommandDef<AdjustPeriodicEventStreamRequest> AdjustPeriodicEventStreamRequest = COMMAND_PROTOCOL.createAndRegister("AdjustPeriodicEventStream", AdjustPeriodicEventStreamRequest.class, AdjustPeriodicEventStreamResponse);

    CommandDef<NotifyEventResponse> NotifyEventResponse = COMMAND_PROTOCOL.createAndRegister("NotifyEventResponse", NotifyEventResponse.class, null);
    CommandDef<NotifyEventRequest> NotifyEventRequest = COMMAND_PROTOCOL.createAndRegister("NotifyEvent", NotifyEventRequest.class, NotifyEventResponse);

    CommandDef<UpdateDynamicScheduleResponse> UpdateDynamicScheduleResponse = COMMAND_PROTOCOL.createAndRegister("UpdateDynamicScheduleResponse", UpdateDynamicScheduleResponse.class, null);
    CommandDef<UpdateDynamicScheduleRequest> UpdateDynamicScheduleRequest = COMMAND_PROTOCOL.createAndRegister("UpdateDynamicSchedule", UpdateDynamicScheduleRequest.class, UpdateDynamicScheduleResponse);

    CommandDef<ReservationStatusUpdateResponse> ReservationStatusUpdateResponse = COMMAND_PROTOCOL.createAndRegister("ReservationStatusUpdateResponse", ReservationStatusUpdateResponse.class, null);
    CommandDef<ReservationStatusUpdateRequest> ReservationStatusUpdateRequest = COMMAND_PROTOCOL.createAndRegister("ReservationStatusUpdate", ReservationStatusUpdateRequest.class, ReservationStatusUpdateResponse);

    CommandDef<OpenPeriodicEventStreamResponse> OpenPeriodicEventStreamResponse = COMMAND_PROTOCOL.createAndRegister("OpenPeriodicEventStreamResponse", OpenPeriodicEventStreamResponse.class, null);
    CommandDef<OpenPeriodicEventStreamRequest> OpenPeriodicEventStreamRequest = COMMAND_PROTOCOL.createAndRegister("OpenPeriodicEventStream", OpenPeriodicEventStreamRequest.class, OpenPeriodicEventStreamResponse);

    CommandDef<AuthorizeResponse> AuthorizeResponse = COMMAND_PROTOCOL.createAndRegister("AuthorizeResponse", AuthorizeResponse.class, null);
    CommandDef<AuthorizeRequest> AuthorizeRequest = COMMAND_PROTOCOL.createAndRegister("Authorize", AuthorizeRequest.class, AuthorizeResponse);

    CommandDef<GetVariablesResponse> GetVariablesResponse = COMMAND_PROTOCOL.createAndRegister("GetVariablesResponse", GetVariablesResponse.class, null);
    CommandDef<GetVariablesRequest> GetVariablesRequest = COMMAND_PROTOCOL.createAndRegister("GetVariables", GetVariablesRequest.class, GetVariablesResponse);

    CommandDef<Get15118EVCertificateResponse> Get15118EVCertificateResponse = COMMAND_PROTOCOL.createAndRegister("Get15118EVCertificateResponse", Get15118EVCertificateResponse.class, null);
    CommandDef<Get15118EVCertificateRequest> Get15118EVCertificateRequest = COMMAND_PROTOCOL.createAndRegister("Get15118EVCertificate", Get15118EVCertificateRequest.class, Get15118EVCertificateResponse);

    CommandDef<NotifyCustomerInformationResponse> NotifyCustomerInformationResponse = COMMAND_PROTOCOL.createAndRegister("NotifyCustomerInformationResponse", NotifyCustomerInformationResponse.class, null);
    CommandDef<NotifyCustomerInformationRequest> NotifyCustomerInformationRequest = COMMAND_PROTOCOL.createAndRegister("NotifyCustomerInformation", NotifyCustomerInformationRequest.class, NotifyCustomerInformationResponse);

    CommandDef<DeleteCertificateResponse> DeleteCertificateResponse = COMMAND_PROTOCOL.createAndRegister("DeleteCertificateResponse", DeleteCertificateResponse.class, null);
    CommandDef<DeleteCertificateRequest> DeleteCertificateRequest = COMMAND_PROTOCOL.createAndRegister("DeleteCertificate", DeleteCertificateRequest.class, DeleteCertificateResponse);

    CommandDef<CostUpdatedResponse> CostUpdatedResponse = COMMAND_PROTOCOL.createAndRegister("CostUpdatedResponse", CostUpdatedResponse.class, null);
    CommandDef<CostUpdatedRequest> CostUpdatedRequest = COMMAND_PROTOCOL.createAndRegister("CostUpdated", CostUpdatedRequest.class, CostUpdatedResponse);

    CommandDef<HeartbeatResponse> HeartbeatResponse = COMMAND_PROTOCOL.createAndRegister("HeartbeatResponse", HeartbeatResponse.class, null);
    CommandDef<HeartbeatRequest> HeartbeatRequest = COMMAND_PROTOCOL.createAndRegister("Heartbeat", HeartbeatRequest.class, HeartbeatResponse);

    CommandDef<GetCertificateChainStatusResponse> GetCertificateChainStatusResponse = COMMAND_PROTOCOL.createAndRegister("GetCertificateChainStatusResponse", GetCertificateChainStatusResponse.class, null);
    CommandDef<GetCertificateChainStatusRequest> GetCertificateChainStatusRequest = COMMAND_PROTOCOL.createAndRegister("GetCertificateChainStatus", GetCertificateChainStatusRequest.class, GetCertificateChainStatusResponse);

    CommandDef<VatNumberValidationResponse> VatNumberValidationResponse = COMMAND_PROTOCOL.createAndRegister("VatNumberValidationResponse", VatNumberValidationResponse.class, null);
    CommandDef<VatNumberValidationRequest> VatNumberValidationRequest = COMMAND_PROTOCOL.createAndRegister("VatNumberValidation", VatNumberValidationRequest.class, VatNumberValidationResponse);

    CommandDef<NotifyDisplayMessagesResponse> NotifyDisplayMessagesResponse = COMMAND_PROTOCOL.createAndRegister("NotifyDisplayMessagesResponse", NotifyDisplayMessagesResponse.class, null);
    CommandDef<NotifyDisplayMessagesRequest> NotifyDisplayMessagesRequest = COMMAND_PROTOCOL.createAndRegister("NotifyDisplayMessages", NotifyDisplayMessagesRequest.class, NotifyDisplayMessagesResponse);

    CommandDef<TriggerMessageResponse> TriggerMessageResponse = COMMAND_PROTOCOL.createAndRegister("TriggerMessageResponse", TriggerMessageResponse.class, null);
    CommandDef<TriggerMessageRequest> TriggerMessageRequest = COMMAND_PROTOCOL.createAndRegister("TriggerMessage", TriggerMessageRequest.class, TriggerMessageResponse);

    CommandDef<SetMonitoringBaseResponse> SetMonitoringBaseResponse = COMMAND_PROTOCOL.createAndRegister("SetMonitoringBaseResponse", SetMonitoringBaseResponse.class, null);
    CommandDef<SetMonitoringBaseRequest> SetMonitoringBaseRequest = COMMAND_PROTOCOL.createAndRegister("SetMonitoringBase", SetMonitoringBaseRequest.class, SetMonitoringBaseResponse);

    CommandDef<ChangeTransactionTariffResponse> ChangeTransactionTariffResponse = COMMAND_PROTOCOL.createAndRegister("ChangeTransactionTariffResponse", ChangeTransactionTariffResponse.class, null);
    CommandDef<ChangeTransactionTariffRequest> ChangeTransactionTariffRequest = COMMAND_PROTOCOL.createAndRegister("ChangeTransactionTariff", ChangeTransactionTariffRequest.class, ChangeTransactionTariffResponse);

    CommandDef<ClearDERControlResponse> ClearDERControlResponse = COMMAND_PROTOCOL.createAndRegister("ClearDERControlResponse", ClearDERControlResponse.class, null);
    CommandDef<ClearDERControlRequest> ClearDERControlRequest = COMMAND_PROTOCOL.createAndRegister("ClearDERControl", ClearDERControlRequest.class, ClearDERControlResponse);

    CommandDef<GetLogResponse> GetLogResponse = COMMAND_PROTOCOL.createAndRegister("GetLogResponse", GetLogResponse.class, null);
    CommandDef<GetLogRequest> GetLogRequest = COMMAND_PROTOCOL.createAndRegister("GetLog", GetLogRequest.class, GetLogResponse);

    CommandDef<ClearChargingProfileResponse> ClearChargingProfileResponse = COMMAND_PROTOCOL.createAndRegister("ClearChargingProfileResponse", ClearChargingProfileResponse.class, null);
    CommandDef<ClearChargingProfileRequest> ClearChargingProfileRequest = COMMAND_PROTOCOL.createAndRegister("ClearChargingProfile", ClearChargingProfileRequest.class, ClearChargingProfileResponse);

    CommandDef<ClearCacheResponse> ClearCacheResponse = COMMAND_PROTOCOL.createAndRegister("ClearCacheResponse", ClearCacheResponse.class, null);
    CommandDef<ClearCacheRequest> ClearCacheRequest = COMMAND_PROTOCOL.createAndRegister("ClearCache", ClearCacheRequest.class, ClearCacheResponse);

    CommandDef<GetDisplayMessagesResponse> GetDisplayMessagesResponse = COMMAND_PROTOCOL.createAndRegister("GetDisplayMessagesResponse", GetDisplayMessagesResponse.class, null);
    CommandDef<GetDisplayMessagesRequest> GetDisplayMessagesRequest = COMMAND_PROTOCOL.createAndRegister("GetDisplayMessages", GetDisplayMessagesRequest.class, GetDisplayMessagesResponse);

    CommandDef<GetLocalListVersionResponse> GetLocalListVersionResponse = COMMAND_PROTOCOL.createAndRegister("GetLocalListVersionResponse", GetLocalListVersionResponse.class, null);
    CommandDef<GetLocalListVersionRequest> GetLocalListVersionRequest = COMMAND_PROTOCOL.createAndRegister("GetLocalListVersion", GetLocalListVersionRequest.class, GetLocalListVersionResponse);

    CommandDef<UnlockConnectorResponse> UnlockConnectorResponse = COMMAND_PROTOCOL.createAndRegister("UnlockConnectorResponse", UnlockConnectorResponse.class, null);
    CommandDef<UnlockConnectorRequest> UnlockConnectorRequest = COMMAND_PROTOCOL.createAndRegister("UnlockConnector", UnlockConnectorRequest.class, UnlockConnectorResponse);

    CommandDef<SetVariableMonitoringResponse> SetVariableMonitoringResponse = COMMAND_PROTOCOL.createAndRegister("SetVariableMonitoringResponse", SetVariableMonitoringResponse.class, null);
    CommandDef<SetVariableMonitoringRequest> SetVariableMonitoringRequest = COMMAND_PROTOCOL.createAndRegister("SetVariableMonitoring", SetVariableMonitoringRequest.class, SetVariableMonitoringResponse);

    CommandDef<SetChargingProfileResponse> SetChargingProfileResponse = COMMAND_PROTOCOL.createAndRegister("SetChargingProfileResponse", SetChargingProfileResponse.class, null);
    CommandDef<SetChargingProfileRequest> SetChargingProfileRequest = COMMAND_PROTOCOL.createAndRegister("SetChargingProfile", SetChargingProfileRequest.class, SetChargingProfileResponse);

    CommandDef<ChangeAvailabilityResponse> ChangeAvailabilityResponse = COMMAND_PROTOCOL.createAndRegister("ChangeAvailabilityResponse", ChangeAvailabilityResponse.class, null);
    CommandDef<ChangeAvailabilityRequest> ChangeAvailabilityRequest = COMMAND_PROTOCOL.createAndRegister("ChangeAvailability", ChangeAvailabilityRequest.class, ChangeAvailabilityResponse);

    CommandDef<SetDisplayMessageResponse> SetDisplayMessageResponse = COMMAND_PROTOCOL.createAndRegister("SetDisplayMessageResponse", SetDisplayMessageResponse.class, null);
    CommandDef<SetDisplayMessageRequest> SetDisplayMessageRequest = COMMAND_PROTOCOL.createAndRegister("SetDisplayMessage", SetDisplayMessageRequest.class, SetDisplayMessageResponse);

    CommandDef<UpdateFirmwareResponse> UpdateFirmwareResponse = COMMAND_PROTOCOL.createAndRegister("UpdateFirmwareResponse", UpdateFirmwareResponse.class, null);
    CommandDef<UpdateFirmwareRequest> UpdateFirmwareRequest = COMMAND_PROTOCOL.createAndRegister("UpdateFirmware", UpdateFirmwareRequest.class, UpdateFirmwareResponse);

    CommandDef<ClearTariffsResponse> ClearTariffsResponse = COMMAND_PROTOCOL.createAndRegister("ClearTariffsResponse", ClearTariffsResponse.class, null);
    CommandDef<ClearTariffsRequest> ClearTariffsRequest = COMMAND_PROTOCOL.createAndRegister("ClearTariffs", ClearTariffsRequest.class, ClearTariffsResponse);

    CommandDef<ClearDisplayMessageResponse> ClearDisplayMessageResponse = COMMAND_PROTOCOL.createAndRegister("ClearDisplayMessageResponse", ClearDisplayMessageResponse.class, null);
    CommandDef<ClearDisplayMessageRequest> ClearDisplayMessageRequest = COMMAND_PROTOCOL.createAndRegister("ClearDisplayMessage", ClearDisplayMessageRequest.class, ClearDisplayMessageResponse);

    CommandDef<TransactionEventResponse> TransactionEventResponse = COMMAND_PROTOCOL.createAndRegister("TransactionEventResponse", TransactionEventResponse.class, null);
    CommandDef<TransactionEventRequest> TransactionEventRequest = COMMAND_PROTOCOL.createAndRegister("TransactionEvent", TransactionEventRequest.class, TransactionEventResponse);

    CommandDef<FirmwareStatusNotificationResponse> FirmwareStatusNotificationResponse = COMMAND_PROTOCOL.createAndRegister("FirmwareStatusNotificationResponse", FirmwareStatusNotificationResponse.class, null);
    CommandDef<FirmwareStatusNotificationRequest> FirmwareStatusNotificationRequest = COMMAND_PROTOCOL.createAndRegister("FirmwareStatusNotification", FirmwareStatusNotificationRequest.class, FirmwareStatusNotificationResponse);

    CommandDef<GetTransactionStatusResponse> GetTransactionStatusResponse = COMMAND_PROTOCOL.createAndRegister("GetTransactionStatusResponse", GetTransactionStatusResponse.class, null);
    CommandDef<GetTransactionStatusRequest> GetTransactionStatusRequest = COMMAND_PROTOCOL.createAndRegister("GetTransactionStatus", GetTransactionStatusRequest.class, GetTransactionStatusResponse);

    CommandDef<GetTariffsResponse> GetTariffsResponse = COMMAND_PROTOCOL.createAndRegister("GetTariffsResponse", GetTariffsResponse.class, null);
    CommandDef<GetTariffsRequest> GetTariffsRequest = COMMAND_PROTOCOL.createAndRegister("GetTariffs", GetTariffsRequest.class, GetTariffsResponse);

    CommandDef<RequestStartTransactionResponse> RequestStartTransactionResponse = COMMAND_PROTOCOL.createAndRegister("RequestStartTransactionResponse", RequestStartTransactionResponse.class, null);
    CommandDef<RequestStartTransactionRequest> RequestStartTransactionRequest = COMMAND_PROTOCOL.createAndRegister("RequestStartTransaction", RequestStartTransactionRequest.class, RequestStartTransactionResponse);

    CommandDef<LogStatusNotificationResponse> LogStatusNotificationResponse = COMMAND_PROTOCOL.createAndRegister("LogStatusNotificationResponse", LogStatusNotificationResponse.class, null);
    CommandDef<LogStatusNotificationRequest> LogStatusNotificationRequest = COMMAND_PROTOCOL.createAndRegister("LogStatusNotification", LogStatusNotificationRequest.class, LogStatusNotificationResponse);

    CommandDef<SetDERControlResponse> SetDERControlResponse = COMMAND_PROTOCOL.createAndRegister("SetDERControlResponse", SetDERControlResponse.class, null);
    CommandDef<SetDERControlRequest> SetDERControlRequest = COMMAND_PROTOCOL.createAndRegister("SetDERControl", SetDERControlRequest.class, SetDERControlResponse);

    CommandDef<GetReportResponse> GetReportResponse = COMMAND_PROTOCOL.createAndRegister("GetReportResponse", GetReportResponse.class, null);
    CommandDef<GetReportRequest> GetReportRequest = COMMAND_PROTOCOL.createAndRegister("GetReport", GetReportRequest.class, GetReportResponse);

    CommandDef<ReportDERControlResponse> ReportDERControlResponse = COMMAND_PROTOCOL.createAndRegister("ReportDERControlResponse", ReportDERControlResponse.class, null);
    CommandDef<ReportDERControlRequest> ReportDERControlRequest = COMMAND_PROTOCOL.createAndRegister("ReportDERControl", ReportDERControlRequest.class, ReportDERControlResponse);

    CommandDef<SetMonitoringLevelResponse> SetMonitoringLevelResponse = COMMAND_PROTOCOL.createAndRegister("SetMonitoringLevelResponse", SetMonitoringLevelResponse.class, null);
    CommandDef<SetMonitoringLevelRequest> SetMonitoringLevelRequest = COMMAND_PROTOCOL.createAndRegister("SetMonitoringLevel", SetMonitoringLevelRequest.class, SetMonitoringLevelResponse);

    CommandDef<SecurityEventNotificationResponse> SecurityEventNotificationResponse = COMMAND_PROTOCOL.createAndRegister("SecurityEventNotificationResponse", SecurityEventNotificationResponse.class, null);
    CommandDef<SecurityEventNotificationRequest> SecurityEventNotificationRequest = COMMAND_PROTOCOL.createAndRegister("SecurityEventNotification", SecurityEventNotificationRequest.class, SecurityEventNotificationResponse);

    CommandDef<NotifyMonitoringReportResponse> NotifyMonitoringReportResponse = COMMAND_PROTOCOL.createAndRegister("NotifyMonitoringReportResponse", NotifyMonitoringReportResponse.class, null);
    CommandDef<NotifyMonitoringReportRequest> NotifyMonitoringReportRequest = COMMAND_PROTOCOL.createAndRegister("NotifyMonitoringReport", NotifyMonitoringReportRequest.class, NotifyMonitoringReportResponse);

    CommandDef<StatusNotificationResponse> StatusNotificationResponse = COMMAND_PROTOCOL.createAndRegister("StatusNotificationResponse", StatusNotificationResponse.class, null);
    CommandDef<StatusNotificationRequest> StatusNotificationRequest = COMMAND_PROTOCOL.createAndRegister("StatusNotification", StatusNotificationRequest.class, StatusNotificationResponse);

    CommandDef<GetDERControlResponse> GetDERControlResponse = COMMAND_PROTOCOL.createAndRegister("GetDERControlResponse", GetDERControlResponse.class, null);
    CommandDef<GetDERControlRequest> GetDERControlRequest = COMMAND_PROTOCOL.createAndRegister("GetDERControl", GetDERControlRequest.class, GetDERControlResponse);

    CommandDef<GetCertificateStatusResponse> GetCertificateStatusResponse = COMMAND_PROTOCOL.createAndRegister("GetCertificateStatusResponse", GetCertificateStatusResponse.class, null);
    CommandDef<GetCertificateStatusRequest> GetCertificateStatusRequest = COMMAND_PROTOCOL.createAndRegister("GetCertificateStatus", GetCertificateStatusRequest.class, GetCertificateStatusResponse);

    CommandDef<UnpublishFirmwareResponse> UnpublishFirmwareResponse = COMMAND_PROTOCOL.createAndRegister("UnpublishFirmwareResponse", UnpublishFirmwareResponse.class, null);
    CommandDef<UnpublishFirmwareRequest> UnpublishFirmwareRequest = COMMAND_PROTOCOL.createAndRegister("UnpublishFirmware", UnpublishFirmwareRequest.class, UnpublishFirmwareResponse);

    CommandDef<SetVariablesResponse> SetVariablesResponse = COMMAND_PROTOCOL.createAndRegister("SetVariablesResponse", SetVariablesResponse.class, null);
    CommandDef<SetVariablesRequest> SetVariablesRequest = COMMAND_PROTOCOL.createAndRegister("SetVariables", SetVariablesRequest.class, SetVariablesResponse);

    CommandDef<GetCompositeScheduleResponse> GetCompositeScheduleResponse = COMMAND_PROTOCOL.createAndRegister("GetCompositeScheduleResponse", GetCompositeScheduleResponse.class, null);
    CommandDef<GetCompositeScheduleRequest> GetCompositeScheduleRequest = COMMAND_PROTOCOL.createAndRegister("GetCompositeSchedule", GetCompositeScheduleRequest.class, GetCompositeScheduleResponse);

    CommandDef<AFRRSignalResponse> AFRRSignalResponse = COMMAND_PROTOCOL.createAndRegister("AFRRSignalResponse", AFRRSignalResponse.class, null);
    CommandDef<AFRRSignalRequest> AFRRSignalRequest = COMMAND_PROTOCOL.createAndRegister("AFRRSignal", AFRRSignalRequest.class, AFRRSignalResponse);

    CommandDef<CancelReservationResponse> CancelReservationResponse = COMMAND_PROTOCOL.createAndRegister("CancelReservationResponse", CancelReservationResponse.class, null);
    CommandDef<CancelReservationRequest> CancelReservationRequest = COMMAND_PROTOCOL.createAndRegister("CancelReservation", CancelReservationRequest.class, CancelReservationResponse);

    CommandDef<NotifyPriorityChargingResponse> NotifyPriorityChargingResponse = COMMAND_PROTOCOL.createAndRegister("NotifyPriorityChargingResponse", NotifyPriorityChargingResponse.class, null);
    CommandDef<NotifyPriorityChargingRequest> NotifyPriorityChargingRequest = COMMAND_PROTOCOL.createAndRegister("NotifyPriorityCharging", NotifyPriorityChargingRequest.class, NotifyPriorityChargingResponse);

    CommandDef<SendLocalListResponse> SendLocalListResponse = COMMAND_PROTOCOL.createAndRegister("SendLocalListResponse", SendLocalListResponse.class, null);
    CommandDef<SendLocalListRequest> SendLocalListRequest = COMMAND_PROTOCOL.createAndRegister("SendLocalList", SendLocalListRequest.class, SendLocalListResponse);

    static CommandDef<?> match(String command) {
        return COMMAND_PROTOCOL.match(command);
    }
}