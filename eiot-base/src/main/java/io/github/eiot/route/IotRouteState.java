package io.github.eiot.route;

import io.github.eiot.Frame;
import io.vertx.core.Handler;


/**
 * @author yan
 * @since 2025-03-26
 */
class IotRouteState<T> {

    private final int order;
    private final String command;
    private final Handler<IotRoutingContext<T>> contextHandler;
    private final Handler<IotRoutingContext<T>> failureHandler;
    private final boolean add;
    private final IotRouteImpl<T> route;

    // 0: not match raw  1: only match raw  2. all match
    private final int matchType;

    public IotRouteState(IotRouteImpl<T> route, int order) {
        this(route, order, null, null, null, false, 0);
    }

    public IotRouteState(IotRouteImpl<T> route, int order, String command) {
        this(route, order, command, null, null, false, 0);
    }

    public IotRouteState(IotRouteImpl<T> route, int order, String command, Handler<IotRoutingContext<T>> contextHandler, Handler<IotRoutingContext<T>> failureHandler, boolean add, int matchType) {
        this.route = route;
        this.order = order;
        this.command = command;
        this.contextHandler = contextHandler;
        this.failureHandler = failureHandler;
        this.add = add;
        this.matchType = matchType;
    }

    public IotRouteState<T> command(String command) {
        return new IotRouteState<>(route, order, command);
    }

    public IotRouteState<T> addContextHandler(Handler<IotRoutingContext<T>> contextHandler) {
        return new IotRouteState<>(
                route,
                order,
                command,
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
        return new IotRouteState<>(route, order, command, contextHandler, failureHandler, add, matchType);
    }

    void handleContext(IotRoutingContextImpl<T> context) {
        contextHandler.handle(context);
    }

    boolean match(Frame<?> frame) {
        if (this.command == null) {
            return matchType == 0 ? !frame.isRaw() : matchType != 1 || frame.isRaw();
        }
        boolean match = this.command.equals(frame.command());
        if (!match) {
            return false;
        }
        return matchType == 0 ? !frame.isRaw() : matchType != 1 || frame.isRaw();
    }

    IotRoute<T> chargeRoute() {
        return route;
    }

    public IotRouteState<T> setAdded(boolean add) {
        return new IotRouteState<>(route, order, command, contextHandler, failureHandler, add, matchType);
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
                command,
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
                command,
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
                command,
                contextHandler,
                failureHandler,
                add,
                1
        );
    }
}
