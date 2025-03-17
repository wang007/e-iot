package io.github.eiot.charge.client;

import io.github.eiot.charge.ChargeConnection;
import io.vertx.core.Future;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.net.NetSocket;
import io.vertx.core.net.SocketAddress;
import io.vertx.core.net.impl.NetClientImpl;

/**
 * created by wang007 on 2025/3/17
 */
public class ChargeClientBase implements ChargeClient {

    protected final ChargeClientOptions options;
    protected final VertxInternal vertxInternal;
    protected final NetClientImpl netClient;

    protected ChargeClientBase(VertxInternal vertxInternal, ChargeClientOptions options) {
        this.vertxInternal = vertxInternal;
        this.options = new ChargeClientOptions(options);
        this.netClient = (NetClientImpl) vertxInternal.createNetClient(options);
    }


    @Override
    public Future<ChargeConnection> connect(int port, String host) {
        return null;
    }

    @Override
    public Future<NetSocket> connect(SocketAddress remoteAddress) {
        return null;
    }

    @Override
    public Future<Void> close() {
        return null;
    }

    @Override
    public String protocol() {
        return null;
    }
}
