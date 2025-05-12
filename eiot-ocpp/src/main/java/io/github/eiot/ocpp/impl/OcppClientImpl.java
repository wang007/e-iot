package io.github.eiot.ocpp.impl;

import io.github.eiot.ocpp.*;
import io.github.eiot.utils.StringUtil;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.WebSocketClient;
import io.vertx.core.impl.VertxInternal;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * created by wang007 on 2025/5/12
 */
public class OcppClientImpl implements OcppClient {

    private final VertxInternal vertx;
    private final WebSocketClient webSocketClient;
    private final OcppClientOptions options;

    public OcppClientImpl(Vertx vertx, OcppClientOptions options) {
        this(vertx, vertx.createWebSocketClient(options), options);
    }

    // for wrap
    public OcppClientImpl(Vertx vertx, WebSocketClient webSocketClient, OcppClientOptions options) {
        this.vertx  = (VertxInternal) vertx;
        this.webSocketClient = webSocketClient;
        this.options = options;
    }


    @Override
    public Future<OcppConnection> connect(OcppConnectOptions options) {
        List<OcppVersion> ocppVersions = options.getOcppVersions();
        if (ocppVersions == null || ocppVersions.isEmpty()) {
            ocppVersions = this.options.getOcppVersions();
        }
        if (ocppVersions == null || ocppVersions.isEmpty()) {
            return Future.failedFuture("required ocpp version");
        }
        if (StringUtil.isEmpty(options.getTerminalNo())) {
            return Future.failedFuture("required terminalNo");
        }
        List<String> subProtocols = ocppVersions.stream().map(v -> v.versionName).collect(Collectors.toList());
        options.setSubProtocols(subProtocols);
        webSocketClient.connect(options)
                .map(ws -> {
                    String terminalNo = options.getTerminalNo();
                    String protocol = ws.subProtocol();
                    OcppVersion ocppVersion = OcppVersion.match(protocol);
                    if (ocppVersion == null) {
                        ws.close((short) 1002); // 1002: protocol error
                        return new IllegalStateException("terminalNo: " + terminalNo + "not match ocpp version by subProtocol: " + protocol);
                    }
                    OcppConnectionImpl connection = new OcppConnectionImpl(vertx, ws, options.getTerminalNo());
                    connection.setFrameConverter(this.options.isFrameConverter());
                    connection.setSetResponseResult(this.options.isSetResponseResult());
                    connection.setWaitResponseTimeout(this.options.getWaitResponseTimeout());
                    connection.setOcppVersion(ocppVersion);
                    connection.configCompleted();

                    return connection;
                });


        return null;
    }

    @Override
    public Future<Void> close() {
        return null;
    }
}
