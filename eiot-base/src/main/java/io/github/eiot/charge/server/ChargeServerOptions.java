package io.github.eiot.charge.server;

import io.github.eiot.charge.ChargeConnection;
import io.github.eiot.charge.FrameCodecOptions;
import io.github.eiot.charge.RequestFrame;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.json.annotations.JsonGen;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.NetServerOptions;

/**
 * Options for configuring a {@link ChargeServer}.
 * <p>
 * created by wang007 on 2025/2/23
 */
@DataObject
@JsonGen(publicConverter = false)
public class ChargeServerOptions extends NetServerOptions {

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
     * protocol
     */
    private String protocol;

    public ChargeServerOptions() {
        super();
        init();
    }

    public ChargeServerOptions(ChargeServerOptions others) {
        super(others);
        this.frameCodecOptions = others.frameCodecOptions;
        this.waitResponseTimeout = others.waitResponseTimeout;
        this.frameConverter = others.frameConverter;
        this.setResponseResult = others.setResponseResult;
        this.protocol = others.protocol;
    }

    public ChargeServerOptions(JsonObject jsonObject) {
        super(jsonObject);
        init();
        ChargeServerOptionsConverter.fromJson(jsonObject, this);
    }


    private void init() {
        waitResponseTimeout = DEFAULT_WAIT_RESPONSE_TIMEOUT;
        frameConverter = DEFAULT_FRAME_CONVERTER;
        setResponseResult = DEFAULT_SET_RESPONSE_RESULT;
    }

    public FrameCodecOptions getFrameCodecOptions() {
        return frameCodecOptions;
    }

    public ChargeServerOptions setFrameCodecOptions(FrameCodecOptions frameCodecOptions) {
        this.frameCodecOptions = frameCodecOptions;
        return this;
    }

    public int getWaitResponseTimeout() {
        return waitResponseTimeout;
    }

    public ChargeServerOptions setWaitResponseTimeout(int waitResponseTimeout) {
        this.waitResponseTimeout = waitResponseTimeout;
        return this;
    }

    public boolean isFrameConverter() {
        return frameConverter;
    }

    public ChargeServerOptions setFrameConverter(boolean frameConverter) {
        this.frameConverter = frameConverter;
        return this;
    }

    public boolean isSetResponseResult() {
        return setResponseResult;
    }

    public ChargeServerOptions setSetResponseResult(boolean setResponseResult) {
        this.setResponseResult = setResponseResult;
        return this;
    }

    public String getProtocol() {
        return protocol;
    }

    public ChargeServerOptions setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }
}
