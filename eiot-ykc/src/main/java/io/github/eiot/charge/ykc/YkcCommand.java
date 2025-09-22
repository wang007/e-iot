package io.github.eiot.charge.ykc;

import io.github.eiot.CommandDef;
import io.github.eiot.RequestCommandDef;
import io.github.eiot.charge.ykc.data.*;
import io.github.eiot.impl.CommandDefProtocol;

/**
 * created by wang007 on 2025/3/17
 */
public interface YkcCommand {

    CommandDefProtocol COMMAND_PROTOCOL = new CommandDefProtocol(YkcServer.PROTOCOL);

    /**
     * 计费模型设置
     */
    CommandDef<YkcBillingModelResponse> BillingModelResponse = createAndSave("57", YkcBillingModelResponse.class);
    RequestCommandDef<YkcBillingModelRequest, YkcBillingModelResponse> BillingModelRequest = createAndSave("58", YkcBillingModelRequest.class, BillingModelResponse);

    /**
     * 计费模型验证
     */
    CommandDef<YkcBillingModelVerifyResponse> BillingModelVerifyResponse = createAndSave("06", YkcBillingModelVerifyResponse.class);

    RequestCommandDef<YkcBillingModelVerifyRequest, YkcBillingModelVerifyResponse> BillingModelVerifyRequest = createAndSave("05", YkcBillingModelVerifyRequest.class, BillingModelVerifyResponse);


    /**
     * 充电过程 BMS 需求与充电机输出
     */
    CommandDef<YkcBmsChargingData> BmsChargingData = createAndSave("23", YkcBmsChargingData.class);

    /**
     * 充电过程 BMS 信息
     */
    CommandDef<io.github.eiot.charge.ykc.data.YkcBmsChargingStatus> BmsChargingStatus = createAndSave("25", YkcBmsChargingStatus.class);

    /**
     * 参数配置
     * bms
     */
    CommandDef<io.github.eiot.charge.ykc.data.YkcBmsParamConfig> BmsParamConfig = createAndSave("17", YkcBmsParamConfig.class);

    /**
     * 充电握手
     * bms
     */
    CommandDef<YkcBmsShake> BmsShake = createAndSave("15", YkcBmsShake.class);

    /**
     * 交易记录
     */
    CommandDef<YkcChargeEventResponse> ChargeEventResponse = createAndSave("40", YkcChargeEventResponse.class);

    RequestCommandDef<YkcChargeEventRequest, YkcChargeEventResponse> ChargeEventRequest = createAndSave("3b", YkcChargeEventRequest.class, ChargeEventResponse);

    /**
     * 过程数据
     */
    CommandDef<YkcChargingData> ChargingData = createAndSave("13", YkcChargingData.class);

    RequestCommandDef<YkcReadChargingDataRequest, YkcChargingData> ReadChargingDataRequest = createAndSave("12", YkcReadChargingDataRequest.class, ChargingData);

    /**
     * 心跳
     */
    CommandDef<YkcHeartbeatResponse> HeartbeatResponse = createAndSave("04", YkcHeartbeatResponse.class);

    RequestCommandDef<YkcHeartbeatRequest, YkcHeartbeatResponse> HeartbeatRequest = createAndSave("03", YkcHeartbeatRequest.class, HeartbeatResponse);

    /**
     * 登陆
     */
    CommandDef<YkcLoginResponse> LoginResponse = createAndSave("02", YkcLoginResponse.class);

    RequestCommandDef<YkcLoginRequest, YkcLoginResponse> LoginRequest = createAndSave("01", YkcLoginRequest.class, LoginResponse);

    /**
     * 远程并充启机命令
     */
    CommandDef<YkcMStartChargeResponse> MStartChargeResponse = createAndSave("a3", YkcMStartChargeResponse.class);

    RequestCommandDef<YkcMStartChargeRequest, YkcMStartChargeResponse> MStartChargeRequest = createAndSave("a4", YkcMStartChargeRequest.class, MStartChargeResponse);

    /**
     * 计费模型请求
     */
    CommandDef<YkcPileBillingModelResponse> PileBillingModelResponse = createAndSave("0a", YkcPileBillingModelResponse.class, null);

    RequestCommandDef<YkcPileBillingModelRequest, YkcPileBillingModelResponse> PileBillingModelRequest = createAndSave("09", YkcPileBillingModelRequest.class, PileBillingModelResponse);

    /**
     * 充电桩主动申请并充充电
     */
    CommandDef<YkcPileMStartChargeResponse> PileMStartChargeResponse = createAndSave("a2", YkcPileMStartChargeResponse.class);

    RequestCommandDef<YkcPileMStartChargeRequest, YkcPileMStartChargeResponse> PileMStartChargeRequest = createAndSave("a1", YkcPileMStartChargeRequest.class, PileMStartChargeResponse);

    /**
     * 充电桩主动申请启动充电
     */
    CommandDef<YkcPileStartChargeResponse> PileStartChargeResponse = createAndSave("32", YkcPileStartChargeResponse.class);

    RequestCommandDef<YkcPileStartChargeRequest, YkcPileStartChargeResponse> PileStartChargeRequest = createAndSave("31", YkcPileStartChargeRequest.class, PileStartChargeResponse);

    /**
     * 二维码
     */
    CommandDef<YkcQrCodeResponse> QrCodeResponse = createAndSave("f1", YkcQrCodeResponse.class);

    RequestCommandDef<YkcQrCodeRequest, YkcQrCodeResponse> QrCodeRequest = createAndSave("f0", YkcQrCodeRequest.class, QrCodeResponse);

    /**
     * 远程重启
     */
    CommandDef<YkcReStartResponse> ReStartResponse = createAndSave("91", YkcReStartResponse.class);

    RequestCommandDef<YkcReStartRequest, YkcReStartResponse> ReStartRequest = createAndSave("92", YkcReStartRequest.class, ReStartResponse);

    /**
     * 远程启动充电命令
     */
    CommandDef<YkcStartChargeResponse> StartChargeResponse = createAndSave("33", YkcStartChargeResponse.class);

    RequestCommandDef<YkcStartChargeRequest, YkcStartChargeResponse> StartChargeRequest = createAndSave("34", YkcStartChargeRequest.class, StartChargeResponse);

    /**
     * 远程停机命令
     */
    CommandDef<YkcStopChargeResponse> StopChargeResponse = createAndSave("35", YkcStopChargeResponse.class, null);

    RequestCommandDef<YkcStopChargeRequest, YkcStopChargeResponse> StopChargeRequest = createAndSave("36", YkcStopChargeRequest.class, StopChargeResponse);

    /**
     * 对时
     */
    CommandDef<YkcSyncTimeResponse> SyncTimeResponse = createAndSave("55", YkcSyncTimeResponse.class);

    RequestCommandDef<YkcSyncTimeRequest, YkcSyncTimeResponse> SyncTimeRequest = createAndSave("56", YkcSyncTimeRequest.class, SyncTimeResponse);

    /**
     * 远程更新
     */
    CommandDef<YkcUpgradeResponse> UpgradeResponse = createAndSave("93", YkcUpgradeResponse.class);

    RequestCommandDef<YkcUpgradeRequest, YkcUpgradeResponse> UpgradeRequest = createAndSave("94", YkcUpgradeRequest.class, UpgradeResponse);

    static <Req> CommandDef<Req> createAndSave(String command, Class<Req> dataType) {
        return COMMAND_PROTOCOL.createAndRegister(command, dataType);
    }

    static <Req, Resp> RequestCommandDef<Req, Resp> createAndSave(String command, Class<Req> dataType, CommandDef<Resp> responseCommand) {
        return COMMAND_PROTOCOL.createAndRegister(command, dataType, responseCommand);
    }

    static CommandDef<?> match(String command) {
        return COMMAND_PROTOCOL.match(command);
    }

}
