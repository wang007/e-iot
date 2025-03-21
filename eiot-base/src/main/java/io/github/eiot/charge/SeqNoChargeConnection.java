package io.github.eiot.charge;

import io.netty.channel.ChannelHandlerContext;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Timer;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.spi.metrics.TCPMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * A charge connection implementation matches the response frame corresponding to the request frame based on seq no
 * <p>
 * created by wang007 on 2025/3/9
 */
public abstract class SeqNoChargeConnection extends ChargeConnectionBase {

    protected static final Logger logger = LoggerFactory.getLogger(SeqNoChargeConnection.class);

    private Queue<Promise<Integer>> pendingRequests;

    private final Queue<Integer> seqNoQueue;

    protected final Map<Integer, RequestFrame<?, Frame<?>>> waitingResults = new HashMap<>(8, 1.0f);

    protected SeqNoChargeConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics,
                                    boolean frameConverter, boolean setResponseResult,
                                    int waitResponseTimeout, String protocol) {
        super(context, chctx, metrics, frameConverter, setResponseResult, waitResponseTimeout, protocol);
        this.seqNoQueue = initSeqNoQueue();
    }

    private static final List<Integer> DEFAULT_SEQ_NOS = new ArrayList<>(16);

    static {
        for (int i = 0; i < 16; i++) {
            DEFAULT_SEQ_NOS.add(i + 2);
        }
    }

    protected Queue<Integer> initSeqNoQueue() {
        return new ArrayDeque<>(DEFAULT_SEQ_NOS);
    }


    @Override
    protected Future<RequestFrame<?, Frame<?>>> beforeSend(RequestFrame<?, Frame<?>> requestFrame, int timeout) {
        synchronized (this) {
            BooleanRef success = new BooleanRef();
            Future<RequestFrame<?, Frame<?>>> frameFuture;
            if (seqNoQueue.isEmpty()) {
                String terminalNo = requestFrame.terminalNo();
                logger.warn("terminalNo: " + terminalNo + " not seqNo use, waiting");

                Promise<Integer> promise = context.promise();
                Queue<Promise<Integer>> pendingRequests = getPendingRequests();
                pendingRequests.add(promise);

                Timer timer = vertx.timer(timeout, TimeUnit.MILLISECONDS);
                timer.onComplete(ar -> {
                    Promise<Integer> peek = pendingRequests.peek();
                    if (peek == promise) {
                        // drop
                        pendingRequests.poll();
                    }
                    promise.fail(new TimeoutException("wait seqNo timeout"));
                });

                frameFuture = promise.future()
                        .flatMap(seqNo -> {
                            if (seqNo <= 0) {
                                return Future.failedFuture("seqNo must be >= 0");
                            }
                            success.value = true;

                            timer.cancel();
                            updateSeqNo(requestFrame, seqNo);
                            return Future.succeededFuture(requestFrame);
                        });
            } else {
                int seqNo = seqNoQueue.poll();
                updateSeqNo(requestFrame, seqNo);
                frameFuture = Future.succeededFuture(requestFrame);
                success.value = true;
            }

            // return seq no
            requestFrame.sendResult()
                    .onComplete(ar -> {
                        synchronized (this) {
                            if (!success.value) {
                                return;
                            }
                            int seqNo = getSeqNo(requestFrame);

                            // may be not remove waiting result if failed. eg: timeout.
                            if (ar.failed()) {
                                waitingResults.remove(seqNo);
                            }

                            if (!hasPendingRequests()) {
                                seqNoQueue.offer(seqNo);
                                return;
                            }
                            Queue<Promise<Integer>> pendingRequests = getPendingRequests();
                            for (; ; ) {
                                Promise<Integer> pending = pendingRequests.poll();
                                if (pending == null) {
                                    return;
                                }
                                if (pending.future().isComplete()) {
                                    continue;
                                }
                                pending.tryComplete(seqNo);
                            }
                        }
                    });

            return frameFuture
                    .onSuccess(f -> {
                        // save to waiting result.
                        int seqNo = getSeqNo(f);
                        synchronized (this) {
                            RequestFrame<?, Frame<?>> old = waitingResults.put(seqNo, f);
                            if (old != null) {
                                waitingResults.put(seqNo, old);
                                throw new IllegalStateException("the same seqNo for waiting result");
                            }
                        }
                    });
        }
    }

    private Queue<Promise<Integer>> getPendingRequests() {
        if (this.pendingRequests == null) {
            this.pendingRequests = new ArrayDeque<>(4);
        }
        return this.pendingRequests;
    }

    private boolean hasPendingRequests() {
        return this.pendingRequests != null && !getPendingRequests().isEmpty();
    }


    @SuppressWarnings("unchecked")
    @Override
    public boolean trySetResponseResult(Frame<?> frame, Throwable ex) {
        int seqNo = getSeqNo(frame);
        if (seqNo <= 1) {
            return false;
        }

        synchronized (this) {
            RequestFrame<?, Frame<?>> waitFrame = waitingResults.get(seqNo);
            if (waitFrame == null) {
                return false;
            }
            if (!waitFrame.responseMessageType().equals(frame.messageType())) {
                if (logger.isDebugEnabled()) {
                    logger.debug("terminalNo: " + frame.terminalNo() + "try set response result failed, message type not match. seqNo: " + seqNo);
                }
                return false;
            }

            // raw frame not set result
            if (ex == null && frame.isRaw()) {
                ex = new ConvertChargeException(frame.terminalNo(), frame);
                frame = null;
            }

            waitingResults.remove(seqNo);
            return waitFrame.trySetResponseResult(frame, ex);
        }
    }

    /**
     * update request frame seqNo field
     *
     * @param requestFrame the request frame
     * @param seqNo        seqNo
     */
    protected abstract void updateSeqNo(RequestFrame<?, Frame<?>> requestFrame, int seqNo);

    /**
     * get seqNo from frame
     *
     * @param frame the frame
     * @return seqNo
     */
    protected abstract int getSeqNo(Frame<?> frame);


    private static class BooleanRef {
        private boolean value;
    }

}
