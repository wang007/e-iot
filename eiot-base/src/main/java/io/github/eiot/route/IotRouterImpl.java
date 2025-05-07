package io.github.eiot.route;

import io.github.eiot.Frame;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

import java.util.Iterator;
import java.util.List;

/**
 * @author yan
 * @since 2025-03-23
 */
class IotRouterImpl implements IotRouter {

    private final Vertx vertx;
    private volatile IotRouterState routerState;

    public IotRouterImpl(Vertx vertx) {
        this.vertx = vertx;
        this.routerState = new IotRouterState(this);
    }

    @Override
    public synchronized <T> IotRoute<T> route() {
        routerState = routerState.incrementOrderSequence();
        return new IotRouteImpl<>(this, routerState.orderSequence());
    }

    @Override
    public synchronized <T> IotRoute<T> route(String command) {
        routerState = routerState.incrementOrderSequence();
        return new IotRouteImpl<>(this, command, routerState.orderSequence());
    }

    @Override
    public synchronized IotRouter exceptionHandler(Handler<Throwable> exceptionHandler) {
        routerState = routerState.exceptionHandler(exceptionHandler);
        return this;
    }

    public Handler<Throwable> exceptionHandler(){
        return routerState.exceptionHandler();
    }

    @Override
    public void handle(Frame<?> frame) {
        IotRoutingContextImpl<?> context = new IotRoutingContextImpl<>(vertx, frame, this, routerState.routes());
        context.next();
    }

    synchronized void add(IotRouteImpl<?> route) {
        this.routerState = routerState.addRoute(route);
    }

    public Iterator<IotRouteImpl<?>> routes() {
        return routerState.routes().iterator();
    }
}
