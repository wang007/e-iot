package io.github.eiot.charge.route;

import io.github.eiot.charge.AttributeHolder;
import io.github.eiot.charge.ChargeConnection;
import io.github.eiot.charge.Frame;
import io.vertx.core.Vertx;

/**
 * Represents the context for the handling of a frame.
 *
 * A new instance is created for each frame request that is received in the ChargeRouter.handle(Frame) of the router.
 *
 * The same instance is passed to any matching request or failure handlers during the routing of the request or failure.
 *
 * ChargeRoutingContext is inspired by vertx-web RoutingContext.
 *
 * created by wang007 on 2025/3/19
 */
public interface ChargeRoutingContext extends AttributeHolder {

    String messageType();

    void next();

    void fail(Throwable throwable);

    <T> Frame<T> frame();

    ChargeRoutingContext replaceFrame(Frame<?> frame);

    Throwable failure();

    boolean failed();

    ChargeConnection connection();


    ChargeRoute currentRoute();

    Vertx vertx();

}
