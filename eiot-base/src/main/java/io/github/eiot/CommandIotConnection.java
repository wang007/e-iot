package io.github.eiot;

import io.github.eiot.exception.ConvertIotException;
import io.netty.channel.ChannelHandlerContext;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.spi.metrics.TCPMetrics;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * A charge connection implementation matches the response frame corresponding to the request frame based on command
 * <p>
 * Because some devices do not really implement seq no rules,
 * use {@link CommandIotConnection} instead of {@link SeqNoIotConnection}
 * <p>
 * created by wang007 on 2025/3/13
 */
public abstract class CommandIotConnection extends IotConnectionBase {

    private final Map<String, PendingRequestFrames> waitResults = new HashMap<>();

    protected CommandIotConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics, boolean frameConverter, boolean setResponseResult, int waitResponseTimeout, String protocol) {
        super(context, chctx, metrics, frameConverter, setResponseResult, waitResponseTimeout, protocol);
    }

    @Override
    protected Future<RequestFrame<?, Frame<?>>> beforeRequest(RequestFrame<?, Frame<?>> requestFrame, int timeout) {
        String responseType = requestFrame.responseCommand();
        synchronized (this) {
            Future<RequestFrame<?, Frame<?>>> future;
            PendingRequestFrames requestFrames = waitResults.get(responseType);
            if (requestFrames == null) {
                requestFrames = new PendingRequestFrames(requestFrame);
                waitResults.put(responseType, requestFrames);
                future = Future.succeededFuture(requestFrame);
            } else {
                Promise<RequestFrame<?, Frame<?>>> promise = context.promise();
                requestFrames.addPending(promise, requestFrame);
                future = promise.future();
            }
            requestFrame.requestResult()
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


    @Override
    public boolean trySetResponseResult(Frame<?> frame, Throwable ex) {
        synchronized (this) {
            String command = frame.command();
            PendingRequestFrames requestFrames = waitResults.get(command);
            if (requestFrames == null) {
                return false;
            }

            // raw frame not set result
            if (ex == null && frame.isRaw()) {
                ex = new ConvertIotException(frame.terminalNo(), frame);
                frame = null;
            }

            RequestFrame<?, Frame<?>> current = requestFrames.current;
            return current.trySetResponseResult(frame, ex);
        }
    }


    // not thread safe
    private static class PendingRequestFrames {

        private RequestFrame<?, Frame<?>> current;

        private Queue<PendingRequestFrame> pendingRequests;

        PendingRequestFrames(RequestFrame<?, Frame<?>> requestFrame) {
            this.current = requestFrame;
        }

        public boolean hasPending() {
            return pendingRequests != null && !pendingRequests.isEmpty();
        }

        public void addPending(Promise<RequestFrame<?, Frame<?>>> promise, RequestFrame<?, Frame<?>> requestFrame) {
            getPendingRequests().add(new PendingRequestFrame(promise, requestFrame));
        }

        private Queue<PendingRequestFrame> getPendingRequests() {
            if (pendingRequests == null) {
                pendingRequests = new ArrayDeque<>(4);
            }
            return pendingRequests;
        }

        /**
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
        public final Promise<RequestFrame<?, Frame<?>>> promise;
        public final RequestFrame<?, Frame<?>> requestFrame;

        public PendingRequestFrame(Promise<RequestFrame<?, Frame<?>>> promise, RequestFrame<?, Frame<?>> requestFrame) {
            this.promise = promise;
            this.requestFrame = requestFrame;
        }
    }


}
