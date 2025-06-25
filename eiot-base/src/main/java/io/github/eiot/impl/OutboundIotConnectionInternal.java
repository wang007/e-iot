package io.github.eiot.impl;

import io.github.eiot.Frame;
import io.github.eiot.IotConnection;
import io.github.eiot.OutboundHook;
import io.github.eiot.RequestFrame;
import io.vertx.core.*;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.impl.future.PromiseInternal;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * impl request frame and write frame skeleton
 *
 * note: It is not part of the public API and should not be used by
 * developers creating vert.x applications
 *
 * created by wang007 on 2025/5/9
 */
public interface OutboundIotConnectionInternal extends IotConnection {


    Vertx vertx();

    ContextInternal context();

    /**
     * @param requestFrame the requestFrame
     * @param timeout      the timeout
     * @return the ops result of Future
     */
    default Future<RequestFrame<?, Frame<?>>> beforeRequest(RequestFrame<?, Frame<?>> requestFrame, int timeout) {
        return Future.succeededFuture(requestFrame);
    }

    /**
     * request frame and set result by promise
     *
     * @param frame the request frame
     * @param timeoutMs timeout
     * @param promise the promise
     */
    default void request(RequestFrame<?, Frame<?>> frame, int timeoutMs, Promise<Frame<?>> promise) {
        long start = System.nanoTime();
        context().emit(v -> {
            try {
                beforeRequest(frame, timeoutMs)
                        .flatMap(f -> {
                            OutboundHook hook;
                            synchronized (this) {
                                hook = outboundHook();
                            }
                            return hook == null ? Future.succeededFuture(f) : hook.beforeRequest(f);
                        })
                        .flatMap(f -> this.write(f).map(f))
                        .onComplete(ar -> {
                            if (ar.failed()) {
                                promise.fail(ar.cause());
                                frame.trySetResponseResult(null, ar.cause());
                                return;
                            }
                            RequestFrame<?, ?> f = ar.result();
                            int time = (int) (timeoutMs - TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));
                            if (time <= 0) {
                                Throwable e = new TimeoutException("already timeout before wait result frame");
                                promise.fail(e);
                                f.trySetResponseResult(null, ar.cause());
                                return;
                            }
                            Timer timer = vertx().timer(time, TimeUnit.MILLISECONDS);
                            timer.onComplete(ar0 -> {
                                if (ar0.failed()) { // ignore cancel
                                    return;
                                }
                                Throwable e = new TimeoutException("wait result frame timeout");
                                promise.tryFail(e);
                                f.trySetResponseResult(null, e);
                            });

                            f.requestResult().onComplete(ar0 -> {
                                timer.cancel();
                                if (ar.failed()) {
                                    promise.tryFail(ar0.cause());
                                } else {
                                    Frame<?> result = ar0.result();
                                    promise.tryComplete(result);
                                }
                            });
                        });
            } catch (Throwable e) {
                promise.fail(e);
                frame.trySetResponseResult(null, e);
            }
        });
    }

    default Future<Frame<?>> beforeWrite(Frame<?> frame) {
        return Future.succeededFuture(frame);
    }

    default void write(Frame<?> frame, PromiseInternal<Void> promise) {
        context().emit(v -> {
            try {
                beforeWrite(frame)
                        .flatMap(f -> {
                            OutboundHook hook;
                            synchronized (this) {
                                hook = outboundHook();
                            }
                            return hook == null ? Future.succeededFuture(f) : hook.beforeWrite(f);
                        })
                        .onComplete(ar -> {
                            if (ar.failed()) {
                                promise.fail(ar.cause());
                                return;
                            }
                            try {
                                writeOutInternal(ar.result(), promise);
                            } catch (Throwable e) {
                                promise.fail(e);
                            }
                        });
            } catch (Throwable e) {
                promise.fail(e);
            }
        });
    }

    /**
     *
     * @param frame
     * @param promise
     */
    void writeOutInternal(Frame<?> frame, PromiseInternal<Void> promise);

}
