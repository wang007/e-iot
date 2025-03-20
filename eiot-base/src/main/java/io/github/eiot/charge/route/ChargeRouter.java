package io.github.eiot.charge.route;

import io.github.eiot.charge.Frame;
import io.github.eiot.charge.MessageTypeEnum;
import io.github.eiot.charge.server.ChargeServer;
import io.vertx.core.Handler;

/**
 * A ChargeRouter receives frame from an {@link ChargeServer} and routes it to the first matching Route that it contains.
 * A router can contain many routes.
 * <p>
 * ChargeRouter are also used for routing failures.
 * <p>
 * created by wang007 on 2025/3/19
 */
public interface ChargeRouter extends Handler<Frame<?>> {

    /**
     * Add a route with no matching criteria, i.e. it matches all frame or failures.
     *
     * @return the route
     */
    ChargeRoute route();

    /**
     * Add a route with matches the specified message type and handler
     *
     * @param messageTypeHandler the handler
     * @return the route
     */
    default ChargeRoute route(MessageTypeHandler messageTypeHandler) {
        return route(messageTypeHandler.messageType()).handler(messageTypeHandler);
    }

    /**
     * like {@link #route(String)} but use {@link MessageTypeEnum#messageType()}
     *
     * @param messageType the message type
     * @return the route
     */
    default ChargeRoute route(MessageTypeEnum messageType) {
        return route(messageType.messageType());
    }

    /**
     * Add a route with matches the specified message type.
     *
     * @param messageType the message type
     * @return the message type
     */
    ChargeRoute route(String messageType);

    /**
     * Specify an handler to handle an error.
     *
     * @param exceptionHandler the handler
     * @return this
     */
    ChargeRouter exceptionHandler(Handler<Throwable> exceptionHandler);
}
