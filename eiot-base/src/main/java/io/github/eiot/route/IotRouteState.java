package io.github.eiot.route;

import io.github.eiot.Frame;
import io.vertx.core.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yan
 * @since 2025-03-26
 */
public class IotRouteState<T> {

    private final int order;
    private final String messageType;
    private final List<Handler<IotRoutingContext<T>>> contextHandlers;
    private final List<Handler<IotRoutingContext<T>>> failureHandlers;
    private final boolean add;
    private final IotRouteImpl<T> route;
    private final boolean alsoMatchRaw;
    private final boolean onlyMatchRaw;

    public IotRouteState(IotRouteImpl<T> route, int order) {
        this(route, order, null, null, null, false, false, false);
    }

    public IotRouteState(IotRouteImpl<T> route, int order, String messageType) {
        this(route, order, messageType, null, null, false, false, false);
    }

    public IotRouteState(IotRouteImpl<T> route, int order, String messageType, List<Handler<IotRoutingContext<T>>> contextHandlers) {
        this(route, order, messageType, contextHandlers, null, false, false, false);
    }

    public IotRouteState(IotRouteImpl<T> route, int order, String messageType, List<Handler<IotRoutingContext<T>>> contextHandlers, List<Handler<IotRoutingContext<T>>> failureHandlers, boolean add, boolean alsoMatchRaw, boolean onlyMatchRaw) {
        this.route = route;
        this.order = order;
        this.messageType = messageType;
        this.contextHandlers = contextHandlers;
        this.failureHandlers = failureHandlers;
        this.add = add;
        this.alsoMatchRaw = alsoMatchRaw;
        this.onlyMatchRaw = onlyMatchRaw;
    }

    public IotRouteState<T> messageType(String messageType) {
        return new IotRouteState<>(route, order, messageType);
    }

    public IotRouteState<T> addContextHandler(Handler<IotRoutingContext<T>> contextHandler) {
        IotRouteState<T> routeState = new IotRouteState<>(
                route,
                order,
                messageType,
                this.contextHandlers == null ? new ArrayList<>() : new ArrayList<>(this.contextHandlers)
        );
        routeState.contextHandlers.add(contextHandler);
        return routeState;
    }

    public boolean isAdded() {
        return add;
    }

    public IotRouteState<T> setOrder(int order) {
        return new IotRouteState<>(route, order, messageType, contextHandlers, failureHandlers, add, alsoMatchRaw, onlyMatchRaw);
    }

    void handleContext(IotRoutingContextImpl<T> context) {
        contextHandlers
                .get(context.currentRouteNextHandlerIndex() - 1)
                .handle(context);
    }

    boolean match(Frame<?> frame) {
        // messageType = null match all
        if (this.messageType == null) {
            return true;
        }
        if (frame.isRaw() && alsoMatchRaw){
            return true;
        }
        if (!frame.isRaw() && onlyMatchRaw){
            return false;
        }
        return this.messageType.equals(frame.messageType());
    }

    IotRoute<T> chargeRoute() {
        return route;
    }

    boolean hasNextHandler(IotRoutingContextImpl<?> context) {
        return context.currentRouteNextHandlerIndex() < getContextHandlersLength();
    }

    public boolean hasNextFailureHandler(IotRoutingContextImpl<?> context) {
        return context.currentRouteNextFailureHandlerIndex() < getFailureHandlersLength();
    }

    public int getContextHandlersLength() {
        return contextHandlers == null ? 0 : contextHandlers.size();
    }

    public int getFailureHandlersLength() {
        return failureHandlers == null ? 0 : failureHandlers.size();
    }

    public IotRouteState<T> setAdded(boolean add) {
        return new IotRouteState<>(route, order, messageType, contextHandlers, failureHandlers, add, alsoMatchRaw, onlyMatchRaw);
    }

    int getOrder() {
        return order;
    }

    public IotRouteState<T> addFailureHandler(Handler<IotRoutingContext<T>> handler) {
        IotRouteState<T> state = new IotRouteState<>(
                route,
                order,
                messageType,
                contextHandlers,
                this.failureHandlers == null ? new ArrayList<>() : new ArrayList<>(this.failureHandlers),
                add,
                alsoMatchRaw,
                onlyMatchRaw
        );
        state.failureHandlers.add(handler);
        return state;
    }

    public void handleFailure(IotRoutingContextImpl<T> context) {
        failureHandlers
                .get(context.currentRouteNextFailureHandlerIndex() - 1)
                .handle(context);
    }

    public IotRouterImpl getRouter() {
        return route.router();
    }

    public IotRouteState<T> alsoMatchRaw(boolean match){
        return new IotRouteState<>(
                route,
                order,
                messageType,
                contextHandlers,
                failureHandlers,
                add,
                match,
                onlyMatchRaw
        );
    }

    public IotRouteState<T> onlyMatchRaw(boolean match){
        return new IotRouteState<>(
                route,
                order,
                messageType,
                contextHandlers,
                failureHandlers,
                add,
                alsoMatchRaw,
                match
        );
    }

    boolean isAlsoMatchRaw() {
        return alsoMatchRaw;
    }

    boolean isOnlyMatchRaw() {
        return onlyMatchRaw;
    }
}
