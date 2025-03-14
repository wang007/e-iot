package io.github.eiot.charge;

import io.netty.channel.ChannelHandlerContext;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.net.impl.SslChannelProvider;
import io.vertx.core.spi.metrics.TCPMetrics;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * A charge connection implementation matches the response frame corresponding to the request frame based on message type
 * <p>
 * Because some devices do not really implement seq no rules,
 * use {@link MessageTypeChargeConnection} instead of {@link SeqNoChargeConnection}
 * <p>
 * created by wang007 on 2025/3/13
 */
public abstract class MessageTypeChargeConnection extends ChargeConnectionBase {

    private final Map<String, PendingRequestFrames> waitResults = new HashMap<>();

    protected MessageTypeChargeConnection(ContextInternal context, ChannelHandlerContext chctx, SslChannelProvider sslChannelProvider, TCPMetrics<?> metrics, boolean frameConverter, boolean setResponseResult, int waitResponseTimeout, String protocol) {
        super(context, chctx, sslChannelProvider, metrics, frameConverter, setResponseResult, waitResponseTimeout, protocol);
    }

    @Override
    protected Future<RequestFrame<?, ?>> beforeSend(RequestFrame<?, ?> requestFrame, int timeout) {
        String responseType = requestFrame.responseMessageType();
        synchronized (this) {
            Future<RequestFrame<?, ?>> future;
            PendingRequestFrames requestFrames = waitResults.get(responseType);
            if (requestFrames == null) {
                requestFrames = new PendingRequestFrames(requestFrame);
                waitResults.put(responseType, requestFrames);
                future = Future.succeededFuture(requestFrame);
            } else {
                Promise<RequestFrame<?, ?>> promise = context.promise();
                requestFrames.addPending(promise, requestFrame);
                future = promise.future();
            }
            requestFrame.sendResult()
                    .onComplete(ar -> {
                        synchronized (this) {
                            PendingRequestFrames pending = waitResults.get(responseType);
                            if (pending == null) {
                                return;
                            }
                            if (pending.next()) {
                                waitResults.remove(responseType);
                            }
                        }
                    });

            return future;
        }

    }


    @SuppressWarnings("unchecked")
    @Override
    public boolean trySetResponseResult(Frame<?> frame, Throwable ex) {
        synchronized (this) {
            String messageType = frame.messageType();
            PendingRequestFrames requestFrames = waitResults.get(messageType);
            if (requestFrames == null) {
                return false;
            }

            // raw frame not set result
            if (ex == null && frame.isRaw()) {
                ex = new ConvertChargeException(frame.terminalNo(), frame);
                frame = null;
            }

            RequestFrame<?, Object> current = (RequestFrame<?, Object>) requestFrames.current;
            Frame<Object> f = (Frame<Object>) frame;
            return current.trySetResponseResult(f, ex);
        }
    }


    // not thread safe
    private static class PendingRequestFrames {

        private RequestFrame<?, ?> current;

        private Queue<PendingRequestFrame> pendingRequests;

        PendingRequestFrames(RequestFrame<?, ?> requestFrame) {
            this.current = requestFrame;
        }

        public boolean hasPending() {
            return pendingRequests != null && !pendingRequests.isEmpty();
        }

        public void addPending(Promise<RequestFrame<?, ?>> promise, RequestFrame<?, ?> requestFrame) {
            getPendingRequests().add(new PendingRequestFrame(promise, requestFrame));
        }

        private Queue<PendingRequestFrame> getPendingRequests() {
            if (pendingRequests == null) {
                pendingRequests = new ArrayDeque<>(4);
            }
            return pendingRequests;
        }

        /**
         *
         * @return empty to remove
         */
        private boolean next() {
            if (!hasPending()) {
                return true;
            }
            PendingRequestFrame pending = getPendingRequests().poll();
            if (pending == null) {
                return true;
            }
            current = pending.requestFrame;
            pending.promise.complete(pending.requestFrame);
            return false;
        }
    }

    private static class PendingRequestFrame {
        public final Promise<RequestFrame<?, ?>> promise;
        public final RequestFrame<?, ?> requestFrame;

        public PendingRequestFrame(Promise<RequestFrame<?, ?>> promise, RequestFrame<?, ?> requestFrame) {
            this.promise = promise;
            this.requestFrame = requestFrame;
        }
    }


}
