package io.github.eiot.ocpp;

import io.github.eiot.IotConnection;
import io.github.eiot.RequestFrame;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.json.annotations.JsonGen;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * created by wang007 on 2025/4/17
 */
@DataObject
@JsonGen(publicConverter = false)
public class OcppServerOptions extends HttpServerOptions {

    /**
     *
     */
    public static final List<OcppVersion> DEFAULT_OCPP_VERSIONS = new ArrayList<>(Arrays.asList(OcppVersion.OCPP2_1, OcppVersion.OCPP2_0_1));

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
     * Set list of ocpp version supported by the server.
     * NOTE: When ocpp1.x and ocpp2.x are included together, the message type matching cannot be distinguished
     */
    private List<OcppVersion> ocppVersions;

    public OcppServerOptions() {
        super();
        init();
    }

    public OcppServerOptions(JsonObject jsonObject) {
        super(jsonObject);
        init();
        OcppServerOptionsConverter.fromJson(jsonObject, this);
    }

    public OcppServerOptions(OcppServerOptions other) {
        super(other);
        this.waitResponseTimeout = other.waitResponseTimeout;
        this.frameConverter = other.frameConverter;
        this.setResponseResult = other.setResponseResult;
        this.ocppVersions = other.ocppVersions;
    }


    private void init() {
        this.waitResponseTimeout = DEFAULT_WAIT_RESPONSE_TIMEOUT;
        this.frameConverter = DEFAULT_FRAME_CONVERTER;
        this.setResponseResult = DEFAULT_SET_RESPONSE_RESULT;
        this.ocppVersions = DEFAULT_OCPP_VERSIONS;
    }

    public int getWaitResponseTimeout() {
        return waitResponseTimeout;
    }

    public OcppServerOptions setWaitResponseTimeout(int waitResponseTimeout) {
        this.waitResponseTimeout = waitResponseTimeout;
        return this;
    }

    public boolean isFrameConverter() {
        return frameConverter;
    }

    public OcppServerOptions setFrameConverter(boolean frameConverter) {
        this.frameConverter = frameConverter;
        return this;
    }

    public boolean isSetResponseResult() {
        return setResponseResult;
    }

    public OcppServerOptions setSetResponseResult(boolean setResponseResult) {
        this.setResponseResult = setResponseResult;
        return this;
    }

    public List<OcppVersion> getOcppVersions() {
        return Collections.unmodifiableList(ocppVersions);
    }

    public OcppServerOptions setOcppVersions(List<OcppVersion> ocppVersions) {
        this.ocppVersions = ocppVersions;
        return this;
    }

    public OcppServerOptions setOcpp1_6J() {
        this.ocppVersions = new ArrayList<>(Collections.singleton(OcppVersion.OCPP1_6J));
        return this;
    }

    public OcppServerOptions setOcpp2() {
        this.ocppVersions = DEFAULT_OCPP_VERSIONS;
        return this;
    }

}
