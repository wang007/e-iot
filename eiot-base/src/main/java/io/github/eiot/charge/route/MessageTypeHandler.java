package io.github.eiot.charge.route;

import io.vertx.core.Handler;

/**
 * Equivalent to {@link ChargeRouter#route(String)} and {@link ChargeRoute#handler(Handler)}
 * <p>
 * created by wang007 on 2025/3/20
 */
public interface MessageTypeHandler extends Handler<ChargeRoutingContext> {

    /**
     * @return provide message type to match.
     */
    String messageType();
}
