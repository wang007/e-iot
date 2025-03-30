package io.github.eiot.charge.route;

import io.github.eiot.charge.Frame;
import io.vertx.core.Handler;

/**
 * @author yan
 * @since 2025-03-23
 */
public class ChargeRouteImpl<T extends Frame<?>> implements ChargeRoute<T> {

    private final ChargeRouterImpl<T> router;
    private volatile ChargeRouteState<T> routeState;

    public ChargeRouteImpl(ChargeRouterImpl<T> router, int order) {
        this.router = router;
        this.routeState = new ChargeRouteState<>(this, order);
    }

    public ChargeRouteImpl(ChargeRouterImpl<T> router, String messageType, int order) {
        this.router = router;
        this.routeState = new ChargeRouteState<>(this, order, messageType);
    }

    @Override
    public synchronized ChargeRoute<T> messageType(String messageType) {
        routeState = routeState.messageType(messageType);
        return this;
    }

    @Override
    public synchronized ChargeRoute<T> handler(Handler<ChargeRoutingContext<T>> handler) {
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
    public ChargeRoute<T> blockingHandler(Handler<ChargeRoutingContext<T>> blockingHandler) {
        throw new UnsupportedOperationException("unsupported blocking handler");
    }

    @Override
    public synchronized ChargeRoute<T> failureHandler(Handler<ChargeRoutingContext<T>> failureHandler) {
        routeState = routeState.addFailureHandler(failureHandler);
        checkAdd();
        return this;
    }

    @Override
    public synchronized ChargeRoute<T> order(int order) {
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
    public synchronized ChargeRoute<T> alsoMatchRaw() {
        routeState = routeState.alsoMatchRaw(true);
        return this;
    }

    @Override
    public synchronized ChargeRoute<T> onlyMatchRaw() {
        routeState = routeState.onlyMatchRaw(true);
        return this;
    }

    ChargeRouteState<T> chargeRouteState() {
        return routeState;
    }

    public ChargeRouterImpl<T> router() {
        return router;
    }

}
