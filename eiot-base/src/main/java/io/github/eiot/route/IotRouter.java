package io.github.eiot.route;

import io.github.eiot.Frame;
import io.github.eiot.MessageType;
import io.github.eiot.server.IotServer;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

/**
 * A ChargeRouter receives frame from an {@link IotServer} and routes it to the first matching Route that it contains.
 * A router can contain many routes.
 * <p>
 * ChargeRouter are also used for routing failures.
 * <p>
 * created by wang007 on 2025/3/19
 */
public interface IotRouter extends Handler<Frame<?>> {

    static IotRouter router(Vertx vertx) {
        return new IotRouterImpl(vertx);
    }

    /**
     * Add a route with no matching criteria, i.e. it matches all frame or failures.
     *
     * @return the route
     */
    <Req> IotRoute<Req> route();

    /**
     * Add a route with matches the specified message type and handler
     *
     * @param messageTypeHandler the handler
     * @return the route
     */
    @SuppressWarnings("unchecked")
    default <Req> IotRoute<Req> route(MessageTypeHandler<Req> messageTypeHandler) {
        IotRoute<Req> r = route(messageTypeHandler.messageType());
        return r.handler(messageTypeHandler);
    }

    /**
     * like {@link #route(String)} but use {@link MessageType#messageType()}
     *
     * @param messageType the message type
     * @return the route
     */
    default <Req> IotRoute<Req> route(MessageType<Req> messageType) {
        return route(messageType.messageType());
    }

    /**
     * Add a route with matches the specified message type.
     *
     * @param messageType the message type
     * @return the message type
     */
    <Req> IotRoute<Req> route(String messageType);

    /**
     * Specify an handler to handle an error.
     *
     * @param exceptionHandler the handler
     * @return this
     */
    IotRouter exceptionHandler(Handler<Throwable> exceptionHandler);
}
