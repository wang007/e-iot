package io.github.eiot.charge.ykc;

import io.github.eiot.charge.MessageTypeEnum;
import io.github.eiot.charge.ykc.data.*;

import java.util.HashMap;
import java.util.Map;

/**
 * created by wang007 on 2025/3/17
 */
public enum YkcMessageTypeEnum implements MessageTypeEnum {

    /**
     * 计费模型设置
     */
    YkcBillingModelResponse("57", YkcBillingModelResponse.class, null),
    YkcBillingModelRequest("58", YkcBillingModelRequest.class, YkcBillingModelResponse),

    /**
     * 计费模型验证
     */
    YkcBillingModelVerifyResponse("06", YkcBillingModelVerifyResponse.class, null),
    YkcBillingModelVerifyRequest("05", YkcBillingModelVerifyRequest.class, YkcBillingModelVerifyResponse),


    /**
     * 充电过程 BMS 需求与充电机输出
     */
    YkcBmsChargingData("23", YkcBmsChargingData.class, null),

    /**
     * 充电过程 BMS 信息
     */
    YkcBmsChargingStatus("25", YkcBmsChargingStatus.class, null),

    /**
     * 参数配置
     * bms
     */
    YkcBmsParamConfig("17", YkcBmsParamConfig.class, null),

    /**
     * 充电握手
     * bms
     */
    YkcBmsShake("15", YkcBmsShake.class, null),

    /**
     * 交易记录
     */
    YkcChargeEventResponse("40", YkcChargeEventResponse.class, null),
    YkcChargeEventRequest("3b", YkcChargeEventRequest.class, YkcChargeEventResponse),

    /**
     * 过程数据
     */
    YkcChargingData("13", YkcChargingData.class, null),
    YkcReadChargingDataRequest("12", YkcReadChargingDataRequest.class, YkcChargingData),

    /**
     * 心跳
     */
    YkcHeartbeatResponse("04", YkcHeartbeatResponse.class, null),
    YkcHeartbeatRequest("03", YkcHeartbeatRequest.class, YkcHeartbeatResponse),

    /**
     * 登陆
     */
    YkcLoginResponse("02", YkcLoginResponse.class, null),
    YkcLoginRequest("01", YkcLoginRequest.class, YkcLoginResponse),

    /**
     * 远程并充启机命令
     */
    YkcMStartChargeResponse("a3", YkcMStartChargeResponse.class, null),
    YkcMStartChargeRequest("a4", YkcMStartChargeRequest.class, YkcMStartChargeResponse),

    /**
     * 计费模型请求
     */
    YkcPileBillingModelResponse("0a", YkcPileBillingModelResponse.class, null),
    YkcPileBillingModelRequest("", YkcPileBillingModelRequest.class, YkcBillingModelResponse),

    /**
     * 充电桩主动申请并充充电
     */
    YkcPileMStartChargeResponse("a2", YkcPileMStartChargeResponse.class, null),
    YkcPileMStartChargeRequest("a1", YkcPileMStartChargeRequest.class, YkcPileMStartChargeResponse),

    /**
     * 充电桩主动申请启动充电
     */
    YkcPileStartChargeResponse("32", YkcPileStartChargeResponse.class, null),
    YkcPileStartChargeRequest("31", YkcPileStartChargeRequest.class, YkcPileStartChargeResponse),

    /**
     * 二维码
     */
    YkcQrCodeResponse("f1", YkcQrCodeResponse.class, null),
    YkcQrCodeRequest("f0", YkcQrCodeRequest.class, YkcQrCodeResponse),


    /**
     * 远程重启
     */
    YkcReStartResponse("91", YkcReStartResponse.class, null),
    YkcReStartRequest("92", YkcReStartRequest.class, YkcReStartResponse),

    /**
     * 远程启动充电命令
     */
    YkcStartChargeResponse("33", YkcStartChargeResponse.class, null),
    YkcStartChargeRequest("34", YkcStartChargeRequest.class, YkcStartChargeResponse),

    /**
     * 远程停机命令
     */
    YkcStopChargeResponse("35", YkcStopChargeResponse.class, null),
    YkcStopChargeRequest("36", YkcStopChargeRequest.class, YkcStopChargeResponse),

    /**
     * 对时
     */
    YkcSyncTimeResponse("55", YkcSyncTimeResponse.class, null),
    YkcSyncTimeRequest("56", YkcSyncTimeRequest.class, YkcSyncTimeResponse),

    /**
     * 远程更新
     */
    YkcUpgradeResponse("93", YkcUpgradeResponse.class, null),
    YkcUpgradeRequest("94", YkcUpgradeRequest.class, YkcUpgradeResponse),

    ;

    public final String messageType;
    public final String alias;
    public final Class<?> dataType;
    public final YkcMessageTypeEnum messageTypeEnum;

    YkcMessageTypeEnum(String messageType, Class<?> dataType, YkcMessageTypeEnum messageTypeEnum) {
        this.messageType = messageType;
        this.alias = this.name();
        this.dataType = dataType;
        this.messageTypeEnum = messageTypeEnum;
    }

    private static final Map<String, YkcMessageTypeEnum> map;

    static {
        Map<String, YkcMessageTypeEnum> map0 = new HashMap<>();
        for (YkcMessageTypeEnum value : YkcMessageTypeEnum.values()) {
            map0.put(value.messageType, value);
        }
        map = map0;
    }

    public static YkcMessageTypeEnum match(String messageType) {
        return map.get(messageType);
    }

    @Override
    public String messageType() {
        return messageType;
    }

    @Override
    public String alias() {
        return alias;
    }

    @Override
    public Class<?> dataType() {
        return dataType;
    }

    @Override
    public MessageTypeEnum responseType() {
        return messageTypeEnum;
    }
}
