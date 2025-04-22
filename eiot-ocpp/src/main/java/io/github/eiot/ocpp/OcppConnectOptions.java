package io.github.eiot.ocpp;

import io.vertx.core.http.WebSocketConnectOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * created by wang007 on 2025/5/12
 */
public class OcppConnectOptions extends WebSocketConnectOptions {

    /**
     * Set list of ocpp version supported by the server.
     * NOTE: When ocpp1.x and ocpp2.x are included together, the message type matching cannot be distinguished
     */
    private List<OcppVersion> ocppVersions;

    /**
     * terminalNo
     */
    private String terminalNo;

    public List<OcppVersion> getOcppVersions() {
        return Collections.unmodifiableList(ocppVersions);
    }

    public OcppConnectOptions setOcppVersions(List<OcppVersion> ocppVersions) {
        this.ocppVersions = ocppVersions;
        return this;
    }

    public OcppConnectOptions setOcpp1_6J() {
        this.ocppVersions = new ArrayList<>(Collections.singleton(OcppVersion.OCPP1_6J));
        return this;
    }

    public OcppConnectOptions setOcpp2() {
        this.ocppVersions = OcppClientOptions.DEFAULT_OCPP_VERSIONS;
        return this;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public OcppConnectOptions setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
        return this;
    }
}
