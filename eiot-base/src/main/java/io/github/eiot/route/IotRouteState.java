package io.github.eiot.route;

import io.github.eiot.Frame;
import io.vertx.core.Handler;


/**
 * @author yan
 * @since 2025-03-26
 */
class IotRouteState<T> {

    private final int order;
    private final String messageType;
    private final Handler<IotRoutingContext<T>> contextHandler;
    private final Handler<IotRoutingContext<T>> failureHandler;
    private final boolean add;
    private final IotRouteImpl<T> route;

    // 0: not match raw  1: only match raw  2. all match
    private final int matchType;

    public IotRouteState(IotRouteImpl<T> route, int order) {
        this(route, order, null, null, null, false, 0);
    }

    public IotRouteState(IotRouteImpl<T> route, int order, String messageType) {
        this(route, order, messageType, null, null, false, 0);
    }

    public IotRouteState(IotRouteImpl<T> route, int order, String messageType, Handler<IotRoutingContext<T>> contextHandler, Handler<IotRoutingContext<T>> failureHandler, boolean add, int matchType) {
        this.route = route;
        this.order = order;
        this.messageType = messageType;
        this.contextHandler = contextHandler;
        this.failureHandler = failureHandler;
        this.add = add;
        this.matchType = matchType;
    }

    public IotRouteState<T> messageType(String messageType) {
        return new IotRouteState<>(route, order, messageType);
    }

    public IotRouteState<T> addContextHandler(Handler<IotRoutingContext<T>> contextHandler) {
        return new IotRouteState<>(
                route,
                order,
                messageType,
                contextHandler,
                failureHandler,
                add,
                matchType
        );
    }

    public boolean isAdded() {
        return add;
    }

    public IotRouteState<T> setOrder(int order) {
        return new IotRouteState<>(route, order, messageType, contextHandler, failureHandler, add, matchType);
    }

    void handleContext(IotRoutingContextImpl<T> context) {
        contextHandler.handle(context);
    }

    boolean match(Frame<?> frame) {
        if (this.messageType == null) {
            return matchType == 0 ? !frame.isRaw() : matchType != 1 || frame.isRaw();
        }
        boolean match = this.messageType.equals(frame.messageType());
        if (!match) {
            return false;
        }
        return matchType == 0 ? !frame.isRaw() : matchType != 1 || frame.isRaw();
    }

    IotRoute<T> chargeRoute() {
        return route;
    }

    public IotRouteState<T> setAdded(boolean add) {
        return new IotRouteState<>(route, order, messageType, contextHandler, failureHandler, add, matchType);
    }

    int getOrder() {
        return order;
    }

    public boolean hasContextHandler() {
        return contextHandler != null;
    }

    public boolean hasFailureHandler() {
        return failureHandler != null;
    }


    public IotRouteState<T> addFailureHandler(Handler<IotRoutingContext<T>> handler) {
        return new IotRouteState<>(
                route,
                order,
                messageType,
                contextHandler,
                handler,
                add,
                matchType
        );
    }

    public void handleFailure(IotRoutingContextImpl<T> context) {
        failureHandler.handle(context);
    }

    public IotRouterImpl getRouter() {
        return route.router();
    }

    public IotRouteState<T> alsoMatchRaw(boolean match) {
        return new IotRouteState<>(
                route,
                order,
                messageType,
                contextHandler,
                failureHandler,
                add,
                2
        );
    }

    public IotRouteState<T> onlyMatchRaw(boolean match) {
        return new IotRouteState<>(
                route,
                order,
                messageType,
                contextHandler,
                failureHandler,
                add,
                1
        );
    }
}
