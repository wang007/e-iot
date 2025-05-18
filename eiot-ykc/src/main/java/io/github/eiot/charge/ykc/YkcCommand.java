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
    CommandDef<YkcBillingModelResponse> YkcBillingModelResponse = createAndSave("57", YkcBillingModelResponse.class, null);
    CommandDef<YkcBillingModelRequest> YkcBillingModelRequest = createAndSave("58", YkcBillingModelRequest.class, YkcBillingModelResponse);

    /**
     * 计费模型验证
     */
    CommandDef<YkcBillingModelVerifyResponse> YkcBillingModelVerifyResponse = createAndSave("06", YkcBillingModelVerifyResponse.class, null);

    CommandDef<io.github.eiot.charge.ykc.data.YkcBillingModelVerifyRequest> YkcBillingModelVerifyRequest = createAndSave("05", YkcBillingModelVerifyRequest.class, YkcBillingModelVerifyResponse);


    /**
     * 充电过程 BMS 需求与充电机输出
     */
    CommandDef<YkcBmsChargingData> YkcBmsChargingData = createAndSave("23", YkcBmsChargingData.class, null);

    /**
     * 充电过程 BMS 信息
     */
    CommandDef<io.github.eiot.charge.ykc.data.YkcBmsChargingStatus> YkcBmsChargingStatus = createAndSave("25", YkcBmsChargingStatus.class, null);

    /**
     * 参数配置
     * bms
     */
    CommandDef<io.github.eiot.charge.ykc.data.YkcBmsParamConfig> YkcBmsParamConfig = createAndSave("17", YkcBmsParamConfig.class, null);

    /**
     * 充电握手
     * bms
     */
    CommandDef<YkcBmsShake> YkcBmsShake = createAndSave("15", YkcBmsShake.class, null);

    /**
     * 交易记录
     */
    CommandDef<YkcChargeEventResponse> YkcChargeEventResponse = createAndSave("40", YkcChargeEventResponse.class, null);

    CommandDef<YkcChargeEventRequest> YkcChargeEventRequest = createAndSave("3b", YkcChargeEventRequest.class, YkcChargeEventResponse);

    /**
     * 过程数据
     */
    CommandDef<YkcChargingData> YkcChargingData = createAndSave("13", YkcChargingData.class, null);

    CommandDef<io.github.eiot.charge.ykc.data.YkcReadChargingDataRequest> YkcReadChargingDataRequest = createAndSave("12", YkcReadChargingDataRequest.class, YkcChargingData);

    /**
     * 心跳
     */
    CommandDef<io.github.eiot.charge.ykc.data.YkcHeartbeatResponse> YkcHeartbeatResponse = createAndSave("04", YkcHeartbeatResponse.class, null);

    CommandDef<YkcHeartbeatRequest> YkcHeartbeatRequest = createAndSave("03", YkcHeartbeatRequest.class, YkcHeartbeatResponse);

    /**
     * 登陆
     */
    CommandDef<YkcLoginResponse> YkcLoginResponse = createAndSave("02", YkcLoginResponse.class, null);

    CommandDef<YkcLoginRequest> YkcLoginRequest = createAndSave("01", YkcLoginRequest.class, YkcLoginResponse);

    /**
     * 远程并充启机命令
     */
    CommandDef<YkcMStartChargeResponse> YkcMStartChargeResponse = createAndSave("a3", YkcMStartChargeResponse.class, null);

    CommandDef<YkcMStartChargeRequest> YkcMStartChargeRequest = createAndSave("a4", YkcMStartChargeRequest.class, YkcMStartChargeResponse);

    /**
     * 计费模型请求
     */
    CommandDef<YkcPileBillingModelResponse> YkcPileBillingModelResponse = createAndSave("0a", YkcPileBillingModelResponse.class, null);

    CommandDef<YkcPileBillingModelRequest> YkcPileBillingModelRequest = createAndSave("09", YkcPileBillingModelRequest.class, YkcBillingModelResponse);

    /**
     * 充电桩主动申请并充充电
     */
    CommandDef<YkcPileMStartChargeResponse> YkcPileMStartChargeResponse = createAndSave("a2", YkcPileMStartChargeResponse.class, null);

    CommandDef<YkcPileMStartChargeRequest> YkcPileMStartChargeRequest = createAndSave("a1", YkcPileMStartChargeRequest.class, YkcPileMStartChargeResponse);

    /**
     * 充电桩主动申请启动充电
     */
    CommandDef<YkcPileStartChargeResponse> YkcPileStartChargeResponse = createAndSave("32", YkcPileStartChargeResponse.class, null);

    CommandDef<YkcPileStartChargeRequest> YkcPileStartChargeRequest = createAndSave("31", YkcPileStartChargeRequest.class, YkcPileStartChargeResponse);

    /**
     * 二维码
     */
    CommandDef<YkcQrCodeResponse> YkcQrCodeResponse = createAndSave("f1", YkcQrCodeResponse.class, null);

    CommandDef<YkcQrCodeRequest> YkcQrCodeRequest = createAndSave("f0", YkcQrCodeRequest.class, YkcQrCodeResponse);


    /**
     * 远程重启
     */
    CommandDef<YkcReStartResponse> YkcReStartResponse = createAndSave("91", YkcReStartResponse.class, null);

    CommandDef<YkcReStartRequest> YkcReStartRequest = createAndSave("92", YkcReStartRequest.class, YkcReStartResponse);

    /**
     * 远程启动充电命令
     */
    CommandDef<YkcStartChargeResponse> YkcStartChargeResponse = createAndSave("33", YkcStartChargeResponse.class, null);

    CommandDef<YkcStartChargeRequest> YkcStartChargeRequest = createAndSave("34", YkcStartChargeRequest.class, YkcStartChargeResponse);

    /**
     * 远程停机命令
     */
    CommandDef<YkcStopChargeResponse> YkcStopChargeResponse = createAndSave("35", YkcStopChargeResponse.class, null);

    CommandDef<YkcStopChargeRequest> YkcStopChargeRequest = createAndSave("36", YkcStopChargeRequest.class, YkcStopChargeResponse);

    /**
     * 对时
     */
    CommandDef<YkcSyncTimeResponse> YkcSyncTimeResponse = createAndSave("55", YkcSyncTimeResponse.class, null);

    CommandDef<YkcSyncTimeRequest> YkcSyncTimeRequest = createAndSave("56", YkcSyncTimeRequest.class, YkcSyncTimeResponse);

    /**
     * 远程更新
     */
    CommandDef<YkcUpgradeResponse> YkcUpgradeResponse = createAndSave("93", YkcUpgradeResponse.class, null);

    CommandDef<YkcUpgradeRequest> YkcUpgradeRequest = createAndSave("94", YkcUpgradeRequest.class, YkcUpgradeResponse);

    static <Req> CommandDef<Req> createAndSave(String command, Class<Req> dataType, CommandDef<?> responseType) {
        return COMMAND_PROTOCOL.createAndRegister(command, dataType, responseType);
    }

    static CommandDef<?> match(String command) {
        return COMMAND_PROTOCOL.match(command);
    }


}
