package io.github.eiot.charge.route;

import io.github.eiot.charge.AttributeHolder;
import io.github.eiot.charge.ChargeConnection;
import io.github.eiot.charge.Frame;
import io.vertx.core.Vertx;

/**
 * Represents the context for the handling of a frame.
 * <p>
 * A new instance is created for each frame request that is received in the ChargeRouter.handle(Frame) of the router.
 * <p>
 * The same instance is passed to any matching request or failure handlers during the routing of the request or failure.
 * <p>
 * ChargeRoutingContext is inspired by vertx-web RoutingContext.
 * <p>
 * created by wang007 on 2025/3/19
 */
public interface ChargeRoutingContext<T extends Frame<?>> extends AttributeHolder {

    /**
     * @return the  message type of current frame
     */
    String messageType();

    /**
     * route to next ChargeRoute or Handler
     */
    void next();

    /**
     * set current ChargeRoutingContext failed and route to next ChargeRoute or failureHandler
     *
     * @param throwable the error
     */
    void fail(Throwable throwable);

    /**
     * request frame
     *
     * @return the frame
     */
    T frame();

    /**
     * replace current frame
     *
     * @param frame new frame
     * @return this
     */
    ChargeRoutingContext<T> replaceFrame(T frame);

    /**
     * @return
     */
    Throwable failure();

    /**
     * @return return true if current context marked failed.
     */
    boolean failed();

    /**
     * @return the connection
     */
    ChargeConnection connection();


    /**
     * @return the current route this context is being routed through.
     */
    ChargeRoute currentRoute();

    /**
     * @return vertx
     */
    Vertx vertx();

}
