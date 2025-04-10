package io.github.eiot.charge.ykc;

import io.github.eiot.charge.MessageType;
import io.github.eiot.charge.ykc.data.*;

import java.util.HashMap;
import java.util.Map;

/**
 * created by wang007 on 2025/3/17
 */
public interface YkcMessageType {

    /**
     * 计费模型设置
     */
    MessageType<YkcBillingModelResponse> YkcBillingModelResponse = createAndSave("57", YkcBillingModelResponse.class, null);
    MessageType<YkcBillingModelRequest> YkcBillingModelRequest = createAndSave("58", YkcBillingModelRequest.class, YkcBillingModelResponse);

    /**
     * 计费模型验证
     */
    MessageType<YkcBillingModelVerifyResponse> YkcBillingModelVerifyResponse = createAndSave("06", YkcBillingModelVerifyResponse.class, null);

    MessageType<YkcBillingModelVerifyRequest> YkcBillingModelVerifyRequest = createAndSave("05", YkcBillingModelVerifyRequest.class, YkcBillingModelVerifyResponse);


    /**
     * 充电过程 BMS 需求与充电机输出
     */
    MessageType<YkcBmsChargingData> YkcBmsChargingData = createAndSave("23", YkcBmsChargingData.class, null);

    /**
     * 充电过程 BMS 信息
     */
    MessageType<YkcBmsChargingStatus> YkcBmsChargingStatus = createAndSave("25", YkcBmsChargingStatus.class, null);

    /**
     * 参数配置
     * bms
     */
    MessageType<YkcBmsParamConfig> YkcBmsParamConfig = createAndSave("17", YkcBmsParamConfig.class, null);

    /**
     * 充电握手
     * bms
     */
    MessageType<YkcBmsShake> YkcBmsShake = createAndSave("15", YkcBmsShake.class, null);

    /**
     * 交易记录
     */
    MessageType<YkcChargeEventResponse> YkcChargeEventResponse = createAndSave("40", YkcChargeEventResponse.class, null);

    MessageType<YkcChargeEventRequest> YkcChargeEventRequest = createAndSave("3b", YkcChargeEventRequest.class, YkcChargeEventResponse);

    /**
     * 过程数据
     */
    MessageType<YkcChargingData> YkcChargingData = createAndSave("13", YkcChargingData.class, null);

    MessageType<YkcReadChargingDataRequest> YkcReadChargingDataRequest = createAndSave("12", YkcReadChargingDataRequest.class, YkcChargingData);

    /**
     * 心跳
     */
    MessageType<YkcHeartbeatResponse> YkcHeartbeatResponse = createAndSave("04", YkcHeartbeatResponse.class, null);

    MessageType<YkcHeartbeatRequest> YkcHeartbeatRequest = createAndSave("03", YkcHeartbeatRequest.class, YkcHeartbeatResponse);

    /**
     * 登陆
     */
    MessageType<YkcLoginResponse> YkcLoginResponse = createAndSave("02", YkcLoginResponse.class, null);

    MessageType<YkcLoginRequest> YkcLoginRequest = createAndSave("01", YkcLoginRequest.class, YkcLoginResponse);

    /**
     * 远程并充启机命令
     */
    MessageType<YkcMStartChargeResponse> YkcMStartChargeResponse = createAndSave("a3", YkcMStartChargeResponse.class, null);

    MessageType<YkcMStartChargeRequest> YkcMStartChargeRequest = createAndSave("a4", YkcMStartChargeRequest.class, YkcMStartChargeResponse);

    /**
     * 计费模型请求
     */
    MessageType<YkcPileBillingModelResponse> YkcPileBillingModelResponse = createAndSave("0a", YkcPileBillingModelResponse.class, null);

    MessageType<YkcPileBillingModelRequest> YkcPileBillingModelRequest = createAndSave("09", YkcPileBillingModelRequest.class, YkcBillingModelResponse);

    /**
     * 充电桩主动申请并充充电
     */
    MessageType<YkcPileMStartChargeResponse> YkcPileMStartChargeResponse = createAndSave("a2", YkcPileMStartChargeResponse.class, null);

    MessageType<YkcPileMStartChargeRequest> YkcPileMStartChargeRequest = createAndSave("a1", YkcPileMStartChargeRequest.class, YkcPileMStartChargeResponse);

    /**
     * 充电桩主动申请启动充电
     */
    MessageType<YkcPileStartChargeResponse> YkcPileStartChargeResponse = createAndSave("32", YkcPileStartChargeResponse.class, null);

    MessageType<YkcPileStartChargeRequest> YkcPileStartChargeRequest = createAndSave("31", YkcPileStartChargeRequest.class, YkcPileStartChargeResponse);

    /**
     * 二维码
     */
    MessageType<YkcQrCodeResponse> YkcQrCodeResponse = createAndSave("f1", YkcQrCodeResponse.class, null);

    MessageType<YkcQrCodeRequest> YkcQrCodeRequest = createAndSave("f0", YkcQrCodeRequest.class, YkcQrCodeResponse);


    /**
     * 远程重启
     */
    MessageType<YkcReStartResponse> YkcReStartResponse = createAndSave("91", YkcReStartResponse.class, null);

    MessageType<YkcReStartRequest> YkcReStartRequest = createAndSave("92", YkcReStartRequest.class, YkcReStartResponse);

    /**
     * 远程启动充电命令
     */
    MessageType<YkcStartChargeResponse> YkcStartChargeResponse = createAndSave("33", YkcStartChargeResponse.class, null);

    MessageType<YkcStartChargeRequest> YkcStartChargeRequest = createAndSave("34", YkcStartChargeRequest.class, YkcStartChargeResponse);

    /**
     * 远程停机命令
     */
    MessageType<YkcStopChargeResponse> YkcStopChargeResponse = createAndSave("35", YkcStopChargeResponse.class, null);

    MessageType<YkcStopChargeRequest> YkcStopChargeRequest = createAndSave("36", YkcStopChargeRequest.class, YkcStopChargeResponse);

    /**
     * 对时
     */
    MessageType<YkcSyncTimeResponse> YkcSyncTimeResponse = createAndSave("55", YkcSyncTimeResponse.class, null);

    MessageType<YkcSyncTimeRequest> YkcSyncTimeRequest = createAndSave("56", YkcSyncTimeRequest.class, YkcSyncTimeResponse);

    /**
     * 远程更新
     */
    MessageType<YkcUpgradeResponse> YkcUpgradeResponse = createAndSave("93", YkcUpgradeResponse.class, null);

    MessageType<YkcUpgradeRequest> YkcUpgradeRequest = createAndSave("94", YkcUpgradeRequest.class, YkcUpgradeResponse);


    static <Req> MessageType<Req> createAndSave(String messageType, Class<Req> dataType, MessageType<?> responseType) {
        return MessageType.createAndSave(messageType, dataType, responseType, YkcChargeServer.PROTOCOL);
    }


    static <Req> MessageType<Req> match(String messageType) {
        return MessageType.match(YkcChargeServer.PROTOCOL, messageType);
    }


}
