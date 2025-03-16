package io.github.eiot.charge;

import io.vertx.core.Future;

/**
 * {@link SendWriteHook} can be used when a {@link Frame} needs to be sent or written
 *
 * When a frame needs to be sent, it goes through {@link #beforeSend(RequestFrame)} and then {@link  #beforeWrite(Frame)}.
 *
 * When a frame needs to be written, it only goes through {@link  #beforeWrite(Frame)}
 *
 * created by wang007 on 2025/2/23
 */
public interface SendWriteHook {

    /**
     * Called before the frame needs to be sent
     *
     * @param frame The frame that needs to be sent
     * @return a future completed with the request frame
     */
    default Future<RequestFrame<?, Frame<?>>> beforeSend(RequestFrame<?, Frame<?>> frame) {
        return Future.succeededFuture(frame);
    }

    /**
     * Called before the frame needs to be written
     *
     * @param frame The frame that needs to be written
     * @return a future completed with the request frame
     */
    default Future<Frame<?>> beforeWrite(Frame<?> frame) {
        return Future.succeededFuture(frame);
    }

    /**
     * TODO compose
     * @param hooks
     * @return
     */
    static SendWriteHook compose(SendWriteHook... hooks) {
        return null;
    }
}
