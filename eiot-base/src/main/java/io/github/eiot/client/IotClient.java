package io.github.eiot.client;

import io.github.eiot.IotConnection;
import io.vertx.core.Future;
import io.vertx.core.net.SocketAddress;

/**
 * A charge client.
 * <p>
 * created by wang007 on 2025/2/24
 */
public interface IotClient {

    /**
     * Open a connection to a server at the specific port and host.
     * <p>
     * {@code host} can be a valid host name or IP address. The connection is done asynchronously and on success
     *
     * @param port the port
     * @param host the host
     * @return returns a Future of the asynchronous result
     */
    Future<IotConnection> connect(int port, String host);

    /**
     * Open a connection to a server at the specific remoteAddress.
     * {@code host} can be a valid host name or IP address. The connection is done asynchronously and on success
     *
     * @param remoteAddress the remote address
     * @return returns a Future of the asynchronous result
     */
    Future<IotConnection> connect(SocketAddress remoteAddress);

    /**
     * Close the client and all created ChargeConnection
     *
     * @return returns a Future of the asynchronous result
     */
    Future<Void> close();

    /**
     * @return Implementation of the charging protocol
     */
    String protocol();
}
