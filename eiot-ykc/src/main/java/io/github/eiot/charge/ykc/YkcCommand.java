package io.github.eiot.charge.ykc;

import io.github.eiot.CommandDef;
import io.github.eiot.charge.ykc.data.*;
import io.github.eiot.impl.CommandDefProtocol;
import io.github.eiot.impl.CommandDefProtocols;

/**
 * created by wang007 on 2025/3/17
 */
public interface YkcCommand {

    CommandDefProtocol COMMAND_PROTOCOL = new CommandDefProtocol(YkcServer.PROTOCOL);

    /**
     * 计费模型设置
     */
    CommandDef<YkcBillingModelResponse> BillingModelResponse = createAndSave("57", YkcBillingModelResponse.class, null);
    CommandDef<YkcBillingModelRequest> BillingModelRequest = createAndSave("58", YkcBillingModelRequest.class, BillingModelResponse);

    /**
     * 计费模型验证
     */
    CommandDef<YkcBillingModelVerifyResponse> BillingModelVerifyResponse = createAndSave("06", YkcBillingModelVerifyResponse.class, null);

    CommandDef<io.github.eiot.charge.ykc.data.YkcBillingModelVerifyRequest> BillingModelVerifyRequest = createAndSave("05", YkcBillingModelVerifyRequest.class, BillingModelVerifyResponse);


    /**
     * 充电过程 BMS 需求与充电机输出
     */
    CommandDef<YkcBmsChargingData> BmsChargingData = createAndSave("23", YkcBmsChargingData.class, null);

    /**
     * 充电过程 BMS 信息
     */
    CommandDef<io.github.eiot.charge.ykc.data.YkcBmsChargingStatus> BmsChargingStatus = createAndSave("25", YkcBmsChargingStatus.class, null);

    /**
     * 参数配置
     * bms
     */
    CommandDef<io.github.eiot.charge.ykc.data.YkcBmsParamConfig> BmsParamConfig = createAndSave("17", YkcBmsParamConfig.class, null);

    /**
     * 充电握手
     * bms
     */
    CommandDef<YkcBmsShake> BmsShake = createAndSave("15", YkcBmsShake.class, null);

    /**
     * 交易记录
     */
    CommandDef<YkcChargeEventResponse> ChargeEventResponse = createAndSave("40", YkcChargeEventResponse.class, null);

    CommandDef<YkcChargeEventRequest> ChargeEventRequest = createAndSave("3b", YkcChargeEventRequest.class, ChargeEventResponse);

    /**
     * 过程数据
     */
    CommandDef<YkcChargingData> ChargingData = createAndSave("13", YkcChargingData.class, null);

    CommandDef<io.github.eiot.charge.ykc.data.YkcReadChargingDataRequest> ReadChargingDataRequest = createAndSave("12", YkcReadChargingDataRequest.class, ChargingData);

    /**
     * 心跳
     */
    CommandDef<io.github.eiot.charge.ykc.data.YkcHeartbeatResponse> HeartbeatResponse = createAndSave("04", YkcHeartbeatResponse.class, null);

    CommandDef<YkcHeartbeatRequest> HeartbeatRequest = createAndSave("03", YkcHeartbeatRequest.class, HeartbeatResponse);

    /**
     * 登陆
     */
    CommandDef<YkcLoginResponse> LoginResponse = createAndSave("02", YkcLoginResponse.class, null);

    CommandDef<YkcLoginRequest> LoginRequest = createAndSave("01", YkcLoginRequest.class, LoginResponse);

    /**
     * 远程并充启机命令
     */
    CommandDef<YkcMStartChargeResponse> MStartChargeResponse = createAndSave("a3", YkcMStartChargeResponse.class, null);

    CommandDef<YkcMStartChargeRequest> MStartChargeRequest = createAndSave("a4", YkcMStartChargeRequest.class, MStartChargeResponse);

    /**
     * 计费模型请求
     */
    CommandDef<YkcPileBillingModelResponse> PileBillingModelResponse = createAndSave("0a", YkcPileBillingModelResponse.class, null);

    CommandDef<YkcPileBillingModelRequest> PileBillingModelRequest = createAndSave("09", YkcPileBillingModelRequest.class, BillingModelResponse);

    /**
     * 充电桩主动申请并充充电
     */
    CommandDef<YkcPileMStartChargeResponse> PileMStartChargeResponse = createAndSave("a2", YkcPileMStartChargeResponse.class, null);

    CommandDef<YkcPileMStartChargeRequest> PileMStartChargeRequest = createAndSave("a1", YkcPileMStartChargeRequest.class, PileMStartChargeResponse);

    /**
     * 充电桩主动申请启动充电
     */
    CommandDef<YkcPileStartChargeResponse> PileStartChargeResponse = createAndSave("32", YkcPileStartChargeResponse.class, null);

    CommandDef<YkcPileStartChargeRequest> PileStartChargeRequest = createAndSave("31", YkcPileStartChargeRequest.class, PileStartChargeResponse);

    /**
     * 二维码
     */
    CommandDef<YkcQrCodeResponse> QrCodeResponse = createAndSave("f1", YkcQrCodeResponse.class, null);

    CommandDef<YkcQrCodeRequest> QrCodeRequest = createAndSave("f0", YkcQrCodeRequest.class, QrCodeResponse);


    /**
     * 远程重启
     */
    CommandDef<YkcReStartResponse> ReStartResponse = createAndSave("91", YkcReStartResponse.class, null);

    CommandDef<YkcReStartRequest> ReStartRequest = createAndSave("92", YkcReStartRequest.class, ReStartResponse);

    /**
     * 远程启动充电命令
     */
    CommandDef<YkcStartChargeResponse> StartChargeResponse = createAndSave("33", YkcStartChargeResponse.class, null);

    CommandDef<YkcStartChargeRequest> StartChargeRequest = createAndSave("34", YkcStartChargeRequest.class, StartChargeResponse);

    /**
     * 远程停机命令
     */
    CommandDef<YkcStopChargeResponse> StopChargeResponse = createAndSave("35", YkcStopChargeResponse.class, null);

    CommandDef<YkcStopChargeRequest> StopChargeRequest = createAndSave("36", YkcStopChargeRequest.class, StopChargeResponse);

    /**
     * 对时
     */
    CommandDef<YkcSyncTimeResponse> SyncTimeResponse = createAndSave("55", YkcSyncTimeResponse.class, null);

    CommandDef<YkcSyncTimeRequest> SyncTimeRequest = createAndSave("56", YkcSyncTimeRequest.class, SyncTimeResponse);

    /**
     * 远程更新
     */
    CommandDef<YkcUpgradeResponse> UpgradeResponse = createAndSave("93", YkcUpgradeResponse.class, null);

    CommandDef<YkcUpgradeRequest> UpgradeRequest = createAndSave("94", YkcUpgradeRequest.class, UpgradeResponse);

    static <Req> CommandDef<Req> createAndSave(String command, Class<Req> dataType, CommandDef<?> responseType) {
        return COMMAND_PROTOCOL.createAndRegister(command, dataType, responseType);
    }

    static CommandDef<?> match(String command) {
        return COMMAND_PROTOCOL.match(command);
    }


}
