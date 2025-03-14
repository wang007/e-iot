package io.github.eiot.charge;

import io.github.eiot.charge.server.ChargeServer;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.impl.VertxWrapper;
import io.vertx.core.net.impl.ServerID;
import io.vertx.core.net.impl.TCPServerBase;

import java.util.Map;

/**
 * created by wang007 on 2025/3/1
 */
public class ChargeVertxInternal extends VertxWrapper {

    private final VertxInternal vertxInternal;

    public ChargeVertxInternal(VertxInternal vertxInternal) {
        super(vertxInternal);
        this.vertxInternal = vertxInternal;
    }

    @Override
    public Throwable unavailableNativeTransportCause() {
        return vertxInternal.unavailableNativeTransportCause();
    }

    @Override
    public <S extends TCPServerBase> Map<ServerID, S> sharedTCPServers(Class<S> type) {
        if (ChargeServer.class.isAssignableFrom(type)) {
            return vertxInternal.sharedData().getLocalMap("chargeServerBase");
        }
        return super.sharedTCPServers(type);
    }




}
