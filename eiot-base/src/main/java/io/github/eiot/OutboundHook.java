package io.github.eiot;

import io.vertx.core.Future;

/**
 * {@link OutboundHook} can be used when a {@link Frame} needs to be request or written
 * <p>
 * When a frame needs to be request, it goes through {@link #beforeRequest(RequestFrame)} and then {@link  #beforeWrite(Frame)}.
 * <p>
 * When a frame needs to be written, it only goes through {@link  #beforeWrite(Frame)}
 * <p>
 * created by wang007 on 2025/2/23
 */
public interface OutboundHook {

    /**
     * Called before the frame needs to be sent
     *
     * @param frame The frame that needs to be sent
     * @return a future completed with the request frame
     */
    default Future<RequestFrame<?, Frame<?>>> beforeRequest(RequestFrame<?, Frame<?>> frame) {
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
     *
     * @param hooks
     * @return
     */
    static OutboundHook compose(OutboundHook... hooks) {
        return null;
    }
}
