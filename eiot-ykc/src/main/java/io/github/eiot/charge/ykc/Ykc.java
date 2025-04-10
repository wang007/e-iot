/*
package io.github.eiot.charge.ykc;

import io.github.eiot.charge.ChargeConnection;
import io.github.eiot.charge.MessageTypeEnum;
import io.github.eiot.charge.ykc.data.*;

*/
/**
 * 云快充 frame 列表
 * <p>
 * created by wang007 on 2025/3/21
 *//*

public interface Ykc {

    class YkcBillingModelRequestFrame extends YkcRequestFrame<YkcBillingModelRequest, YkcBillingModelResponse> {
        public YkcBillingModelRequestFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcBillingModelRequest);
        }

        public YkcBillingModelRequestFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcBillingModelRequest);
        }
    }

    class YkcBillingModelResponseFrame extends DefaultYkcFrame<YkcBillingModelResponse> {
        public YkcBillingModelResponseFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcBillingModelResponse);
        }

        public YkcBillingModelResponseFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcBillingModelResponse);
        }
    }

    class YkcBillingModelVerifyRequestFrame extends YkcRequestFrame<YkcBillingModelVerifyRequest, YkcBillingModelVerifyResponse> {
        public YkcBillingModelVerifyRequestFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcBillingModelVerifyRequest);
        }

        public YkcBillingModelVerifyRequestFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcBillingModelVerifyRequest);
        }
    }

    class YkcBillingModelVerifyResponseFrame extends DefaultYkcFrame<YkcBillingModelVerifyResponse> {
        public YkcBillingModelVerifyResponseFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcBillingModelVerifyResponse);
        }

        public YkcBillingModelVerifyResponseFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcBillingModelVerifyResponse);
        }
    }

    class YkcBmsChargingDataFrame extends DefaultYkcFrame<YkcBmsChargingData> {
        public YkcBmsChargingDataFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcBmsChargingData);
        }

        public YkcBmsChargingDataFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcBmsChargingData);
        }
    }

    class YkcBmsChargingStatusFrame extends DefaultYkcFrame<YkcBmsChargingStatus> {

        public YkcBmsChargingStatusFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcBmsChargingStatus);
        }

        public YkcBmsChargingStatusFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcBmsChargingStatus);
        }
    }

    class YkcBmsParamConfig extends DefaultYkcFrame<YkcBmsParamConfig> {

        public YkcBmsParamConfig(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcBmsParamConfig);
        }

        public YkcBmsParamConfig(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcBmsParamConfig);
        }
    }

    class YkcBmsShakeFrame extends DefaultYkcFrame<YkcBmsShake> {

        public YkcBmsShakeFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcBmsShake);
        }

        public YkcBmsShakeFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcBmsShake);
        }
    }

    class YkcChargeEventRequestFrame extends YkcRequestFrame<YkcChargeEventRequest, YkcChargeEventResponse> {
        public YkcChargeEventRequestFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcChargeEventRequest);
        }

        public YkcChargeEventRequestFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcChargeEventRequest);
        }
    }

    class YkcChargeEventResponseFrame extends DefaultYkcFrame<YkcChargeEventResponse> {

        public YkcChargeEventResponseFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcChargeEventResponse);
        }

        public YkcChargeEventResponseFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcChargeEventResponse);
        }
    }

    class YkcChargingDataFrame extends DefaultYkcFrame<YkcChargingData> {

        public YkcChargingDataFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcChargingData);
        }

        public YkcChargingDataFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcChargingData);
        }
    }

    class YkcHeartbeatRequestFrame extends YkcRequestFrame<YkcHeartbeatRequest, YkcHeartbeatResponse> {

        public YkcHeartbeatRequestFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcHeartbeatRequest);
        }

        public YkcHeartbeatRequestFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcHeartbeatRequest);
        }
    }

    class YkcHeartbeatResponseFrame extends DefaultYkcFrame<YkcHeartbeatResponse> {

        public YkcHeartbeatResponseFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcHeartbeatResponse);
        }

        public YkcHeartbeatResponseFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcHeartbeatResponse);
        }
    }


    class YkcLoginRequestFrame extends YkcRequestFrame<YkcLoginRequest, YkcLoginResponse> {
        public YkcLoginRequestFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcLoginRequest);
        }

        public YkcLoginRequestFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcLoginRequest);
        }
    }

    class YkcLoginResponseFrame extends DefaultYkcFrame<YkcLoginResponse> {

        public YkcLoginResponseFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcLoginResponse);
        }

        public YkcLoginResponseFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcLoginResponse);
        }
    }

    class YkcMStartChargeRequestFrame extends YkcRequestFrame<YkcMStartChargeRequest, YkcMStartChargeResponse> {

        public YkcMStartChargeRequestFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcMStartChargeRequest);
        }

        public YkcMStartChargeRequestFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcMStartChargeRequest);
        }
    }

    class YkcMStartChargeResponseFrame extends DefaultYkcFrame<YkcMStartChargeResponse> {

        public YkcMStartChargeResponseFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcMStartChargeResponse);
        }

        public YkcMStartChargeResponseFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcMStartChargeResponse);
        }
    }

    class YkcPileBillingModelRequestFrame extends YkcRequestFrame<YkcPileBillingModelRequest, YkcPileBillingModelResponse> {

        public YkcPileBillingModelRequestFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcPileBillingModelRequest);
        }

        public YkcPileBillingModelRequestFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcPileBillingModelRequest);
        }
    }

    class YkcPileBillingModelResponseFrame extends DefaultYkcFrame<YkcPileBillingModelResponse> {

        public YkcPileBillingModelResponseFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcPileBillingModelResponse);
        }

        public YkcPileBillingModelResponseFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcPileBillingModelResponse);
        }
    }

    class YkcPileMStartChargeRequestFrame extends YkcRequestFrame<YkcPileMStartChargeRequest, YkcPileMStartChargeResponse> {


        public YkcPileMStartChargeRequestFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcPileMStartChargeRequest);
        }

        public YkcPileMStartChargeRequestFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcPileMStartChargeRequest);
        }
    }

    class YkcPileMStartChargeResponseFrame extends DefaultYkcFrame<YkcPileMStartChargeResponse> {

        public YkcPileMStartChargeResponseFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcPileMStartChargeResponse);
        }

        public YkcPileMStartChargeResponseFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcPileMStartChargeResponse);
        }
    }

    class YkcPileStartChargeRequestFrame extends YkcRequestFrame<YkcPileStartChargeRequest, YkcPileStartChargeResponse> {

        public YkcPileStartChargeRequestFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcPileStartChargeRequest);
        }

        public YkcPileStartChargeRequestFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcPileStartChargeRequest);
        }
    }

    class YkcPileStartChargeResponseFrame extends DefaultYkcFrame<YkcPileStartChargeResponse> {

        public YkcPileStartChargeResponseFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcPileStartChargeResponse);
        }

        public YkcPileStartChargeResponseFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcPileStartChargeResponse);
        }
    }

    class YkcQrCodeRequestFrame extends YkcRequestFrame<YkcQrCodeRequest, YkcQrCodeResponse> {

        public YkcQrCodeRequestFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcQrCodeRequest);
        }

        public YkcQrCodeRequestFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcQrCodeRequest);
        }
    }

    class YkcQrCodeResponseFrame extends DefaultYkcFrame<YkcQrCodeResponse> {

        public YkcQrCodeResponseFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcQrCodeResponse);
        }

        public YkcQrCodeResponseFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcQrCodeResponse);
        }
    }

    class YkcReadChargingDataRequestFrame extends YkcRequestFrame<YkcReadChargingDataRequest, YkcChargingData> {
        public YkcReadChargingDataRequestFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcReadChargingDataRequest);
        }

        public YkcReadChargingDataRequestFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcReadChargingDataRequest);
        }
    }

    class YkcReStartRequestFrame extends YkcRequestFrame<YkcReStartRequest, YkcReStartResponse> {

        public YkcReStartRequestFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcReStartRequest);
        }

        public YkcReStartRequestFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcReStartRequest);
        }
    }

    class YkcReStartResponseFrame extends DefaultYkcFrame<YkcReStartResponse> {

        public YkcReStartResponseFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcReStartResponse);
        }

        public YkcReStartResponseFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcReStartResponse);
        }
    }

    class YkcStartChargeRequestFrame extends YkcRequestFrame<YkcStartChargeRequest, YkcStartChargeResponse> {

        public YkcStartChargeRequestFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcStartChargeRequest);
        }

        public YkcStartChargeRequestFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcStartChargeRequest);
        }
    }

    class YkcStartChargeResponseFrame extends DefaultYkcFrame<YkcStartChargeResponse> {

        public YkcStartChargeResponseFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcStartChargeResponse);
        }

        public YkcStartChargeResponseFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcStartChargeResponse);
        }
    }

    class YkcStopChargeRequestFrame extends YkcRequestFrame<YkcStopChargeRequest, YkcStopChargeResponse> {

        public YkcStopChargeRequestFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcStopChargeRequest);
        }

        public YkcStopChargeRequestFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcStopChargeRequest);
        }
    }

    class YkcStopChargeResponseFrame extends DefaultYkcFrame<YkcStopChargeResponse> {

        public YkcStopChargeResponseFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcStopChargeResponse);
        }

        public YkcStopChargeResponseFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcStopChargeResponse);
        }
    }

    class YkcSyncTimeRequestFrame extends YkcRequestFrame<YkcSyncTimeRequest, YkcSyncTimeResponse> {
        public YkcSyncTimeRequestFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcSyncTimeRequest);
        }

        public YkcSyncTimeRequestFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcSyncTimeRequest);
        }
    }

    class YkcSyncTimeResponseFrame extends DefaultYkcFrame<YkcSyncTimeResponse> {

        public YkcSyncTimeResponseFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcSyncTimeResponse);
        }

        public YkcSyncTimeResponseFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcSyncTimeResponse);
        }
    }

    class YkcUpgradeRequestFrame extends YkcRequestFrame<YkcUpgradeRequest, YkcUpgradeResponse> {

        public YkcUpgradeRequestFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcUpgradeRequest);
        }

        public YkcUpgradeRequestFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcUpgradeRequest);
        }
    }

    class YkcUpgradeResponseFrame extends DefaultYkcFrame<YkcUpgradeResponse> {

        public YkcUpgradeResponseFrame(ChargeConnection connection) {
            super(connection, YkcMessageTypeEnum.YkcUpgradeResponse);
        }

        public YkcUpgradeResponseFrame(RawYkcFrame frame) {
            super(frame, YkcMessageTypeEnum.YkcUpgradeResponse);
        }
    }

}
*/
