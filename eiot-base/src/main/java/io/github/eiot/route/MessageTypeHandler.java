package io.github.eiot.route;

import io.vertx.core.Handler;

/**
 * Equivalent to {@link IotRouter#route(String)} and {@link IotRoute#handler(Handler)}
 * <p>
 * created by wang007 on 2025/3/20
 */
public interface MessageTypeHandler<T> extends Handler<IotRoutingContext<T>> {

    /**
     * @return provide message type to match.
     */
    String messageType();

    @Override
    void handle(IotRoutingContext<T> ctx);
}
