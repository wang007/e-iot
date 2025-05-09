package io.github.eiot.route;

import io.vertx.core.Handler;

/**
 * @author yan
 * @since 2025-03-23
 */
class IotRouteImpl<T> implements IotRoute<T> {

    private final IotRouterImpl router;
    private volatile IotRouteState<T> routeState;

    public IotRouteImpl(IotRouterImpl router, int order) {
        this.router = router;
        this.routeState = new IotRouteState<>(this, order);
    }

    public IotRouteImpl(IotRouterImpl router, String command, int order) {
        this.router = router;
        this.routeState = new IotRouteState<>(this, order, command);
    }

    @Override
    public synchronized IotRoute<T> command(String command) {
        if (routeState.isAdded()) {
            throw new IllegalStateException("Can't change command after route is active");
        }
        routeState = routeState.command(command);
        return this;
    }

    @Override
    public synchronized IotRoute<T> handler(Handler<IotRoutingContext<T>> handler) {
        routeState = routeState.addContextHandler(handler);
        checkAdd();
        return this;
    }

    private synchronized void checkAdd() {
        if (!routeState.isAdded()) {
            router.add(this);
            routeState = routeState.setAdded(true);
        }
    }

    @Override
    public IotRoute<T> blockingHandler(Handler<IotRoutingContext<T>> blockingHandler) {
        throw new UnsupportedOperationException("unsupported blocking handler");
    }

    @Override
    public synchronized IotRoute<T> failureHandler(Handler<IotRoutingContext<T>> failureHandler) {
        routeState = routeState.addFailureHandler(failureHandler);
        checkAdd();
        return this;
    }

    @Override
    public synchronized IotRoute<T> order(int order) {
        if (routeState.isAdded()) {
            throw new IllegalStateException("Can't change order after route is active");
        }
        routeState = routeState.setOrder(order);
        return this;
    }

    int order() {
        return routeState.getOrder();
    }

    @Override
    public synchronized IotRoute<T> matchRaw() {
        routeState = routeState.alsoMatchRaw(true);
        return this;
    }

    @Override
    public synchronized IotRoute<T> onlyMatchRaw() {
        routeState = routeState.onlyMatchRaw(true);
        return this;
    }

    IotRouteState<T> routeState() {
        return routeState;
    }

    public IotRouterImpl router() {
        return router;
    }

}
