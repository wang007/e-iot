package io.github.eiot.ocpp.impl;

import io.github.eiot.Frame;
import io.github.eiot.IotConnection;
import io.github.eiot.OutboundHook;
import io.github.eiot.RequestFrame;
import io.github.eiot.exception.ConvertIotException;
import io.github.eiot.impl.OutboundIotConnectionInternal;
import io.github.eiot.ocpp.*;
import io.github.eiot.utils.StringUtil;
import io.vertx.codegen.annotations.Nullable;
import io.vertx.core.*;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.WebSocketBase;
import io.vertx.core.http.WebSocketFrameType;
import io.vertx.core.http.impl.ws.WebSocketFrameImpl;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.impl.future.PromiseInternal;
import io.vertx.core.net.SocketAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

/**
 * created by wang007 on 2025/4/19
 */
public class OcppConnectionImpl implements OcppConnection, OutboundIotConnectionInternal {

    private static final Logger logger = LoggerFactory.getLogger(OcppConnectionImpl.class);

    private final Promise<Void> closedPromise = Promise.promise();
    private final Map<String, Object> attributes = new ConcurrentHashMap<>();
    private final AtomicLong messageIdGenerator;

    final VertxInternal vertx;
    final WebSocketBase webSocket;
    final String terminalNo;
    final ContextInternal context;

    private int waitResponseTimeout;
    private boolean frameConverter;
    private boolean setResponseResult;
    private OcppVersion ocppVersion;

    private Handler<Throwable> exceptionHandler;
    private Handler<Frame<?>> frameHandler;
    private Handler<Buffer> bufferHandler;

    private OutboundHook outboundHook;

    private final Map<String, RequestFrame<?, Frame<?>>> waitingResults = new ConcurrentHashMap<>(8, 1.0f);


    public OcppConnectionImpl(VertxInternal vertx, WebSocketBase webSocket, String terminalNo) {
        this.vertx = vertx;
        this.webSocket = webSocket;
        this.terminalNo = terminalNo;
        this.context = vertx.getOrCreateContext().unwrap();
        webSocket.closeHandler(v -> {
            // close hook.
            closedPromise.complete(null);
        });
        messageIdGenerator = new AtomicLong(ThreadLocalRandom.current().nextLong(50));
    }

    void configCompleted() {
        // aggregate TEXT websocket frame and CONTINUATION websocket frame
        webSocket.textMessageHandler(json -> {
            Handler<Frame<?>> frameHandler;
            Handler<Buffer> bufferHandler;
            Handler<Throwable> exceptionHandler;

            boolean frameConvert;
            boolean setResponseResult;

            synchronized (this) {
                frameHandler = this.frameHandler;
                bufferHandler = this.bufferHandler;
                exceptionHandler = this.exceptionHandler;
                frameConvert = this.frameConverter;
                setResponseResult = this.setResponseResult;
            }
            if (frameHandler != null) {
                context.dispatch(json, v -> {
                    Frame<?> frame;
                    try {
                        frame = RawOcppFrame.new4Receiver(this, v);
                    } catch (Throwable e) {
                        Throwable ex;
                        if (e instanceof ConvertIotException) {
                            ex = e;
                        } else {
                            ex = new ConvertIotException(terminalNo, null, "ocpp convert raw frame failed", e);
                        }
                        if (exceptionHandler != null) {
                            exceptionHandler.handle(ex);
                        }
                        return;
                    }

                    // maybe later version not support.
                    if (frame == null) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("terminalNo: {} convert failed, maybe later version and not support messageTypeId, data: {}", terminalNo, v);
                        } else {
                            logger.warn("terminalNo: {} convert failed, maybe later version and not support messageTypeId.", terminalNo);
                        }
                        return;
                    }

                    OcppFrame<?> ocppFrame = (OcppFrame<?>) frame;
                    if (ocppFrame.messageTypeId() == MessageTypeId.CALLRESULT) {
                        RequestFrame<?, Frame<?>> requestFrame = waitingResults.get(ocppFrame.messageId());
                        if (requestFrame != null) {
                            ocppFrame.put(OcppRequestFrame.REQUEST_FRAME_COMMAND_KEY, requestFrame.command());
                        }
                    }

                    if (frameConvert) {
                        try {
                            frame = OcppFrameConverter.INSTANCE.apply(frame);
                        } catch (Throwable e) {
                            Throwable ex;
                            if (e instanceof ConvertIotException) {
                                ex = e;
                            } else {
                                ex = new ConvertIotException(terminalNo, frame, "ocpp convert concrete frame failed", e);
                            }
                            if (trySetResponseResult(frame, ex)) {
                                return;
                            }
                            if (exceptionHandler != null) {
                                exceptionHandler.handle(ex);
                            }
                            return;
                        }
                    }

                    if (setResponseResult && trySetResponseResult(frame, null)) {
                        return;
                    }
                    frameHandler.handle(frame);
                });
            }

            if (bufferHandler != null) {
                context.dispatch(json, v -> bufferHandler.handle(Buffer.buffer(v)));
            }
        });
    }

    public String nextMessageId() {
        long messageId = messageIdGenerator.getAndIncrement();
        return Long.toString(messageId);
    }

    public void setWaitResponseTimeout(int waitResponseTimeout) {
        this.waitResponseTimeout = waitResponseTimeout;
    }

    public void setFrameConverter(boolean frameConverter) {
        this.frameConverter = frameConverter;
    }

    public void setSetResponseResult(boolean setResponseResult) {
        this.setResponseResult = setResponseResult;
    }

    public void setOcppVersion(OcppVersion ocppVersion) {
        this.ocppVersion = ocppVersion;
    }

    public WebSocketBase getWebSocket() {
        return webSocket;
    }

    @Override
    public Map<String, Object> attributes() {
        return attributes;
    }

    @Override
    public SocketAddress remoteAddress() {
        return webSocket.remoteAddress();
    }

    @Override
    public SocketAddress remoteAddress(boolean real) {
        return webSocket.remoteAddress();
    }

    @Override
    public SocketAddress localAddress() {
        return websocket().localAddress();
    }

    @Override
    public SocketAddress localAddress(boolean real) {
        return websocket().localAddress();
    }

    @Override
    public Vertx vertx() {
        return vertx;
    }

    @Override
    public ContextInternal context() {
        return context;
    }

    @Override
    public boolean trySetResponseResult(Frame<?> frame, Throwable ex) {
        OcppFrame<?> ocppFrame = (OcppFrame<?>) frame;
        MessageTypeId messageTypeId = ocppFrame.messageTypeId();
        if (messageTypeId == null) {
            return false;
        }
        if (messageTypeId != MessageTypeId.CALLRESULT && messageTypeId != MessageTypeId.CALLERROR) {
            return false;
        }
        String messageId = ocppFrame.messageId();
        if (StringUtil.isEmpty(messageId)) {
            return false;
        }
        RequestFrame<?, Frame<?>> waiting = waitingResults.remove(messageId);
        if (waiting == null) {
            return false;
        }
        // raw frame not set result
        if (ex == null && frame.isRaw()) {
            ex = new ConvertIotException(frame.terminalNo(), frame);
            frame = null;
        }
        return waiting.trySetResponseResult(frame, ex);
    }

    @Override
    public Future<RequestFrame<?, Frame<?>>> beforeRequest(RequestFrame<?, Frame<?>> requestFrame, int timeout) {
        OcppFrame<?> ocppFrame = (OcppFrame<?>) requestFrame;
        String messageId = ocppFrame.messageId();
        if (StringUtil.isEmpty(messageId)) {
            return Future.failedFuture("request frame not exist message id");
        }
        waitingResults.put(messageId, requestFrame);
        requestFrame
                .requestResult()
                .onComplete(ar -> waitingResults.remove(messageId)); // eg: no response, remove it!
        return Future.succeededFuture(requestFrame);
    }

    @Override
    public Future<Frame<?>> request(RequestFrame<?, Frame<?>> frame, int timeoutMs) {
        if (timeoutMs <= 0) {
            timeoutMs = this.waitResponseTimeout;
        }
        // use caller context.
        PromiseInternal<Frame<?>> promise = this.vertx.promise();
        request(frame, timeoutMs, promise);
        return promise.future();
    }

    @Override
    public Future<Void> write(Frame<?> frame) {
        // use caller context.
        PromiseInternal<Void> promise = this.vertx.promise();
        write(frame, promise);
        return promise.future();
    }

    @Override
    public void writeOutInternal(Frame<?> frame, PromiseInternal<Void> promise) {
        String json = frame.toRawString();
        Future<Void> future = webSocket.writeTextMessage(json);
        future.onComplete(promise);
    }

    @Override
    public Future<Void> close() {
        return webSocket.close();
    }

    @Override
    public Future<Void> closeFuture() {
        return closedPromise.future();
    }

    // WriteStream start

    @Override
    public Future<Void> write(Buffer data) {
        // Reduce the overhead of replication
        WebSocketFrameImpl frame = new WebSocketFrameImpl(WebSocketFrameType.TEXT, data.getByteBuf(), true);
        return webSocket.writeFrame(frame);
    }

    @Override
    public void write(Buffer data, Handler<AsyncResult<Void>> handler) {
        Future<Void> future = write(data);
        future.onComplete(handler);
    }

    @Override
    public void end(Handler<AsyncResult<Void>> handler) {
        webSocket.end(handler);
    }

    @Override
    public OcppConnection setWriteQueueMaxSize(int maxSize) {
        webSocket.setWriteQueueMaxSize(maxSize);
        return this;
    }

    @Override
    public boolean writeQueueFull() {
        return webSocket.writeQueueFull();
    }

    @Override
    public OcppConnection drainHandler(@Nullable Handler<Void> handler) {
        webSocket.drainHandler(handler);
        return this;
    }

    // WriteStream end


    // ReadStream start

    @Override
    public synchronized OcppConnection handler(@Nullable Handler<Buffer> handler) {
        this.bufferHandler = handler;
        return this;
    }

    @Override
    public OcppConnection pause() {
        webSocket.pause();
        return this;
    }

    @Override
    public OcppConnection resume() {
        webSocket.resume();
        return this;
    }

    @Override
    public OcppConnection fetch(long amount) {
        webSocket.fetch(amount);
        return this;
    }

    @Override
    public OcppConnection endHandler(@Nullable Handler<Void> endHandler) {
        webSocket.endHandler(endHandler);
        return this;
    }

    // ReadStream end

    @Override
    public synchronized IotConnection exceptionHandler(Handler<Throwable> handler) {
        this.exceptionHandler = handler;
        this.webSocket.exceptionHandler(handler);
        return this;
    }

    @Override
    public synchronized OcppConnection frameHandler(Handler<Frame<?>> handler) {
        this.frameHandler = handler;
        return this;
    }

    @Override
    public synchronized IotConnection outboundHook(OutboundHook hook) {
        this.outboundHook = hook;
        return this;
    }

    @Override
    public synchronized OutboundHook outboundHook() {
        return this.outboundHook;
    }

    @Override
    public boolean isClosed() {
        return webSocket.isClosed();
    }

    @Override
    public String protocol() {
        return webSocket.subProtocol();
    }

    @Override
    public String terminalNo() {
        return terminalNo;
    }

    @Override
    public OcppVersion ocppVersion() {
        return ocppVersion;
    }


    public WebSocketBase websocket() {
        return webSocket;
    }

}
