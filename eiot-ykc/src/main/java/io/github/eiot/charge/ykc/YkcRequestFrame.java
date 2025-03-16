package io.github.eiot.charge.ykc;

import io.github.eiot.charge.RequestFrameBase;
import io.github.eiot.charge.ChargeConnection;
import io.github.eiot.charge.MessageTypeEnum;
import io.vertx.core.Promise;

/**
 * created by wang007 on 2025/3/16
 */
public class YkcRequestFrame<Req, Resp> extends DefaultYkcFrame<Req> implements RequestFrameBase<Req, YkcFrame<Resp>> {

    private final Promise<YkcFrame<Resp>> promise = Promise.promise();

    public YkcRequestFrame(ChargeConnection connection, MessageTypeEnum messageTypeEnum) {
        super(connection, messageTypeEnum);
    }

    public YkcRequestFrame(RawYkcFrame frame, MessageTypeEnum messageTypeEnum) {
        super(frame, messageTypeEnum);
    }

    @Override
    public Promise<YkcFrame<Resp>> sendPromise() {
        return promise;
    }

    @Override
    public YkcFrame<Resp> responseFrame() {
        YkcFrame<Resp> respYkcFrame = RequestFrameBase.super.responseFrame();
        respYkcFrame.sequenceNo(sequenceNo());
        return respYkcFrame;
    }
}
