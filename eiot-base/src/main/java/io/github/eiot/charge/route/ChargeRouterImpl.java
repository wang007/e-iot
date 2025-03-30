package io.github.eiot.charge.route;

import io.github.eiot.charge.Frame;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

import java.util.Iterator;
import java.util.List;

/**
 * @author yan
 * @since 2025-03-23
 */
public class ChargeRouterImpl<T extends Frame<?>> implements ChargeRouter<T> {

    private final Vertx vertx;
    private volatile ChargeRouterState<T> routerState;

    public ChargeRouterImpl(Vertx vertx) {
        this.vertx = vertx;
        this.routerState = new ChargeRouterState<>(this);
    }

    @Override
    public synchronized ChargeRoute<T> route() {
        routerState = routerState.incrementOrderSequence();
        return new ChargeRouteImpl<>(this, routerState.orderSequence());
    }

    @Override
    public synchronized ChargeRoute<T> route(String messageType) {
        routerState = routerState.incrementOrderSequence();
        return new ChargeRouteImpl<>(this, messageType, routerState.orderSequence());
    }

    @Override
    public synchronized ChargeRouter<T> exceptionHandler(Handler<Throwable> exceptionHandler) {
        routerState = routerState.addExceptionHandler(exceptionHandler);
        return this;
    }

    public List<Handler<Throwable>> exceptionHandlers(){
        return routerState.exceptionHandlers();
    }

    @Override
    public void handle(T frame) {
        ChargeRoutingContextImpl<T> context = new ChargeRoutingContextImpl<T>(vertx, frame, this, routerState.routes());
        context.next();
    }

    synchronized void add(ChargeRouteImpl<T> route) {
        this.routerState = routerState.addRoute(route);
    }

    public Iterator<ChargeRouteImpl<T>> routes() {
        return routerState.routes().iterator();
    }
}
