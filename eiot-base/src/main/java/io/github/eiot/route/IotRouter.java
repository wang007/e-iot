package io.github.eiot.route;

import io.github.eiot.Frame;
import io.github.eiot.CommandDef;
import io.github.eiot.IotServer;
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
     * Add a route with matches the specified command and handler
     *
     * @param commandHandler the handler
     * @return the route
     */
    default <Req> IotRoute<Req> route(CommandHandler<Req> commandHandler) {
        IotRoute<Req> r = route(commandHandler.command());
        return r.handler(commandHandler);
    }

    /**
     * like {@link #route(String)} but use {@link CommandDef#command()}
     *
     * @param commandDef the commandDef
     * @return the route
     */
    default <Req> IotRoute<Req> route(CommandDef<Req> commandDef) {
        return route(commandDef.command());
    }

    /**
     * Add a route with matches the specified command.
     *
     * @param command the command
     * @return this
     */
    <Req> IotRoute<Req> route(String command);

    /**
     * Specify an handler to handle an error.
     *
     * @param exceptionHandler the handler
     * @return this
     */
    IotRouter exceptionHandler(Handler<Throwable> exceptionHandler);
}
