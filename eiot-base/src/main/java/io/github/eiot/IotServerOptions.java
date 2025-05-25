package io.github.eiot;

import io.github.eiot.impl.MatchCommandIotConnection;
import io.github.eiot.impl.SeqNoIotConnection;
import io.github.eiot.IotServerOptionsConverter;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.json.annotations.JsonGen;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.NetServerOptions;

/**
 * Options for configuring a {@link IotServer}.
 * <p>
 * created by wang007 on 2025/2/23
 */
@DataObject
@JsonGen(publicConverter = false)
public class IotServerOptions extends NetServerOptions {

    /**
     * The default wait response frame times out. unit: millis
     */
    public static final int DEFAULT_WAIT_RESPONSE_TIMEOUT = 10_000;

    /**
     * default frame converter
     */
    public static final boolean DEFAULT_FRAME_CONVERTER = true;

    /**
     * default set response result
     */
    public static final boolean DEFAULT_SET_RESPONSE_RESULT = true;

    /**
     * default set seqNoMatchFirst
     */
    public static final boolean DEFAULT_SEQNO_MATCH_FIRST = true;

    /**
     * frame code options
     */
    private FrameCodecOptions frameCodecOptions;

    /**
     * The default wait response frame times out. unit: millis
     */
    private int waitResponseTimeout;

    /**
     * Whether to perform the frame conversion.
     * If the frame does not convert, it can be converted on the router
     */
    private boolean frameConverter;

    /**
     * Whether to execute set response result.
     * set the response frame result by {@link IotConnection#request(RequestFrame)} when the response frame come back.
     * <p>
     * If the set response result is not executed, it can be executed on the router.
     * NOTE: If setResponseResult is true, frameConverter must be true
     */
    private boolean setResponseResult;

    /**
     * Normally, seq no is used to match response, but since some devices do not implement seq no well,
     * command matching is used
     *
     * match by seq no: {@link SeqNoIotConnection}
     * match by command: {@link MatchCommandIotConnection}
     */
    private boolean seqNoMatchFirst;


    /**
     * protocol
     */
    private String protocol;

    public IotServerOptions() {
        super();
        init();
    }

    public IotServerOptions(IotServerOptions others) {
        super(others);
        this.frameCodecOptions = others.frameCodecOptions;
        this.waitResponseTimeout = others.waitResponseTimeout;
        this.frameConverter = others.frameConverter;
        this.setResponseResult = others.setResponseResult;
        this.protocol = others.protocol;
        this.seqNoMatchFirst = others.seqNoMatchFirst;
    }

    public IotServerOptions(JsonObject jsonObject) {
        super(jsonObject);
        init();
        IotServerOptionsConverter.fromJson(jsonObject, this);
    }


    private void init() {
        waitResponseTimeout = DEFAULT_WAIT_RESPONSE_TIMEOUT;
        frameConverter = DEFAULT_FRAME_CONVERTER;
        setResponseResult = DEFAULT_SET_RESPONSE_RESULT;
        seqNoMatchFirst = DEFAULT_SEQNO_MATCH_FIRST;
    }

    public FrameCodecOptions getFrameCodecOptions() {
        return frameCodecOptions;
    }

    public IotServerOptions setFrameCodecOptions(FrameCodecOptions frameCodecOptions) {
        this.frameCodecOptions = frameCodecOptions;
        return this;
    }

    public int getWaitResponseTimeout() {
        return waitResponseTimeout;
    }

    public IotServerOptions setWaitResponseTimeout(int waitResponseTimeout) {
        this.waitResponseTimeout = waitResponseTimeout;
        return this;
    }

    public boolean isFrameConverter() {
        return frameConverter;
    }

    public IotServerOptions setFrameConverter(boolean frameConverter) {
        this.frameConverter = frameConverter;
        return this;
    }

    public boolean isSetResponseResult() {
        return setResponseResult;
    }

    public IotServerOptions setSetResponseResult(boolean setResponseResult) {
        this.setResponseResult = setResponseResult;
        return this;
    }

    public boolean isSeqNoMatchFirst() {
        return seqNoMatchFirst;
    }

    public IotServerOptions setSeqNoMatchFirst(boolean seqNoMatchFirst) {
        this.seqNoMatchFirst = seqNoMatchFirst;
        return this;
    }

    public String getProtocol() {
        return protocol;
    }

    public IotServerOptions setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }
}
