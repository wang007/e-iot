package io.github.eiot.route;

import io.github.eiot.CommandDef;
import io.vertx.core.Handler;

/**
 * A ChargeRoute is a holder for a set of criteria which determine whether a frame request or failure should be routed to a handler.
 * <p>
 * created by wang007 on 2025/3/19
 */
public interface IotRoute<Req> {

    /**
     * set match by command
     *
     * @param command the command
     * @return this
     */
    IotRoute<Req> command(String command);

    /**
     * {@link #command(String)}, but use {@link CommandDef#command()}
     *
     * @param commandDef the command
     * @return this
     */
    default IotRoute<Req> command(CommandDef<Req> commandDef) {
        return command(commandDef.command());
    }

    /**
     * set a handler to the route handlers list.
     *
     * @param handler the handler
     * @return this
     */
    IotRoute<Req> handler(Handler<IotRoutingContext<Req>> handler);

    /**
     * set a blockingHandler to the route handlers list.
     *
     * @param blockingHandler the blockingHandler
     * @return this
     */
    IotRoute<Req> blockingHandler(Handler<IotRoutingContext<Req>> blockingHandler);

    /**
     * set a failureHandler to the route handlers list.
     *
     * @param failureHandler the failureHandler
     * @return
     */
    IotRoute<Req> failureHandler(Handler<IotRoutingContext<Req>> failureHandler);

    /**
     * Specify the order for this route. The router tests routes in that order.
     *
     * @param order the order
     * @return this
     */
    IotRoute<Req> order(int order);

    /**
     * Specify this is the first route for the router.
     *
     * @return this
     */
    default IotRoute<Req> first() {
        return order(Integer.MIN_VALUE);
    }

    /**
     * Specify this is the last route for the router.
     *
     * @return a reference to this, so the API can be used fluently
     */
    default IotRoute<Req> last() {
        return order(Integer.MAX_VALUE);
    }

    /**
     * match raw frame and concrete frame
     * <p>
     * default: false. only match Concrete frame
     *
     * @return a reference to this, so the API can be used fluently
     */
    IotRoute<Req> matchRaw();

    /**
     * only match raw and not match concrete frame
     * <p>
     * default: false. only match raw frame
     *
     * @return a reference to this, so the API can be used fluently
     */
    IotRoute<Req> onlyMatchRaw();



}
