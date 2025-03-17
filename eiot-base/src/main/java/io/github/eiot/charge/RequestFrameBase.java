package io.github.eiot.charge;

import io.vertx.core.Future;
import io.vertx.core.Promise;

/**
 *
 *
 * created by wang007 on 2025/3/15
 */
public interface RequestFrameBase<Req, ResFrame extends Frame<?>> extends RequestFrame<Req, ResFrame> {

    Promise<ResFrame> sendPromise();

    MessageTypeEnum messageTypeEnum();

    @Override
    default String responseMessageType() {
        return messageTypeEnum().responseType().messageType();
    }

    @Override
    @SuppressWarnings("unchecked")
    default Future<ResFrame> send() {
        Future<Frame<?>> future = chargeConnection().send((RequestFrame<?, Frame<?>>) this);
        return (Future<ResFrame>) future;
    }

    @Override
    @SuppressWarnings("unchecked")
    default Future<ResFrame> send(int timeout) {
        Future<Frame<?>> future = chargeConnection().send((RequestFrame<?, Frame<?>>) this, timeout);
        return (Future<ResFrame>) future;
    }

    @Override
    default Future<ResFrame> sendResult() {
        return sendPromise().future();
    }

    @Override
    default boolean trySetResponseResult(ResFrame frame, Throwable ex) {
        if (ex != null) {
            return sendPromise().tryFail(ex);
        }
        return sendPromise().tryComplete(frame);
    }

    @Override
    default boolean isRaw() {
        return false;
    }

}
