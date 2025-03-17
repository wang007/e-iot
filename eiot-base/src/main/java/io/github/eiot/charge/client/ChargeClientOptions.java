package io.github.eiot.charge.client;

import io.github.eiot.charge.*;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.json.annotations.JsonGen;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.NetClientOptions;

/**
 * created by wang007 on 2025/2/24
 */
@DataObject
@JsonGen(publicConverter = false)
public class ChargeClientOptions extends NetClientOptions {

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
     * If the router does not convert, it can be converted on the router
     */
    private boolean frameConverter;

    /**
     * Whether to execute set response result.
     * set the response frame result by {@link ChargeConnection#send(RequestFrame)} when the response frame come back.
     * <p>
     * If the set response result is not executed, it can be executed on the router.
     * NOTE: If setResponseResult is true, frameConverter must be true
     */
    private boolean setResponseResult;

    /**
     * Normally, seq no is used to match response, but since some devices do not implement seq no well,
     * message type matching is used
     * <p>
     * match by seq no: {@link SeqNoChargeConnection}
     * match by message type: {@link MessageTypeChargeConnection}
     */
    private boolean seqNoMatchFirst;

    /**
     * protocol
     */
    private String protocol;

    public ChargeClientOptions() {
        super();
        init();
    }

    public ChargeClientOptions(ChargeClientOptions others) {
        super(others);
        this.frameCodecOptions = others.frameCodecOptions;
        this.waitResponseTimeout = others.waitResponseTimeout;
        this.frameConverter = others.frameConverter;
        this.setResponseResult = others.setResponseResult;
        this.protocol = others.protocol;
        this.seqNoMatchFirst = others.seqNoMatchFirst;
        setRegisterWriteHandler(false);
    }

    public ChargeClientOptions(JsonObject jsonObject) {
        super(jsonObject);
        init();
        ChargeClientOptionsConverter.fromJson(jsonObject, this);
    }


    private void init() {
        waitResponseTimeout = DEFAULT_WAIT_RESPONSE_TIMEOUT;
        frameConverter = DEFAULT_FRAME_CONVERTER;
        setResponseResult = DEFAULT_SET_RESPONSE_RESULT;
        seqNoMatchFirst = DEFAULT_SEQNO_MATCH_FIRST;
        setRegisterWriteHandler(false);
    }

    public FrameCodecOptions getFrameCodecOptions() {
        return frameCodecOptions;
    }

    public ChargeClientOptions setFrameCodecOptions(FrameCodecOptions frameCodecOptions) {
        this.frameCodecOptions = frameCodecOptions;
        return this;
    }

    public int getWaitResponseTimeout() {
        return waitResponseTimeout;
    }

    public ChargeClientOptions setWaitResponseTimeout(int waitResponseTimeout) {
        this.waitResponseTimeout = waitResponseTimeout;
        return this;
    }

    public boolean isFrameConverter() {
        return frameConverter;
    }

    public ChargeClientOptions setFrameConverter(boolean frameConverter) {
        this.frameConverter = frameConverter;
        return this;
    }

    public boolean isSetResponseResult() {
        return setResponseResult;
    }

    public ChargeClientOptions setSetResponseResult(boolean setResponseResult) {
        this.setResponseResult = setResponseResult;
        return this;
    }

    public boolean isSeqNoMatchFirst() {
        return seqNoMatchFirst;
    }

    public ChargeClientOptions setSeqNoMatchFirst(boolean seqNoMatchFirst) {
        this.seqNoMatchFirst = seqNoMatchFirst;
        return this;
    }

    public String getProtocol() {
        return protocol;
    }

    public ChargeClientOptions setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }
}
