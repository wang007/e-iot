package io.github.eiot.charge.route;

import io.github.eiot.charge.Frame;
import io.vertx.core.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yan
 * @since 2025-03-26
 */
public class ChargeRouteState<T> {

    private final int order;
    private final String messageType;
    private final List<Handler<ChargeRoutingContext<T>>> contextHandlers;
    private final List<Handler<ChargeRoutingContext<T>>> failureHandlers;
    private final boolean add;
    private final ChargeRouteImpl<T> route;
    private final boolean alsoMatchRaw;
    private final boolean onlyMatchRaw;

    public ChargeRouteState(ChargeRouteImpl<T> route, int order) {
        this(route, order, null, null, null, false, false, false);
    }

    public ChargeRouteState(ChargeRouteImpl<T> route, int order, String messageType) {
        this(route, order, messageType, null, null, false, false, false);
    }

    public ChargeRouteState(ChargeRouteImpl<T> route, int order, String messageType, List<Handler<ChargeRoutingContext<T>>> contextHandlers) {
        this(route, order, messageType, contextHandlers, null, false, false, false);
    }

    public ChargeRouteState(ChargeRouteImpl<T> route, int order, String messageType, List<Handler<ChargeRoutingContext<T>>> contextHandlers, List<Handler<ChargeRoutingContext<T>>> failureHandlers, boolean add, boolean alsoMatchRaw, boolean onlyMatchRaw) {
        this.route = route;
        this.order = order;
        this.messageType = messageType;
        this.contextHandlers = contextHandlers;
        this.failureHandlers = failureHandlers;
        this.add = add;
        this.alsoMatchRaw = alsoMatchRaw;
        this.onlyMatchRaw = onlyMatchRaw;
    }

    public ChargeRouteState<T> messageType(String messageType) {
        return new ChargeRouteState<>(route, order, messageType);
    }

    public ChargeRouteState<T> addContextHandler(Handler<ChargeRoutingContext<T>> contextHandler) {
        ChargeRouteState<T> routeState = new ChargeRouteState<>(
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

    public ChargeRouteState<T> setOrder(int order) {
        return new ChargeRouteState<>(route, order, messageType, contextHandlers, failureHandlers, add, alsoMatchRaw, onlyMatchRaw);
    }

    void handleContext(ChargeRoutingContextImpl<T> context) {
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

    ChargeRoute<T> chargeRoute() {
        return route;
    }

    boolean hasNextHandler(ChargeRoutingContextImpl<?> context) {
        return context.currentRouteNextHandlerIndex() < getContextHandlersLength();
    }

    public boolean hasNextFailureHandler(ChargeRoutingContextImpl<?> context) {
        return context.currentRouteNextFailureHandlerIndex() < getFailureHandlersLength();
    }

    public int getContextHandlersLength() {
        return contextHandlers == null ? 0 : contextHandlers.size();
    }

    public int getFailureHandlersLength() {
        return failureHandlers == null ? 0 : failureHandlers.size();
    }

    public ChargeRouteState<T> setAdded(boolean add) {
        return new ChargeRouteState<>(route, order, messageType, contextHandlers, failureHandlers, add, alsoMatchRaw, onlyMatchRaw);
    }

    int getOrder() {
        return order;
    }

    public ChargeRouteState<T> addFailureHandler(Handler<ChargeRoutingContext<T>> handler) {
        ChargeRouteState<T> state = new ChargeRouteState<>(
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

    public void handleFailure(ChargeRoutingContextImpl<T> context) {
        failureHandlers
                .get(context.currentRouteNextFailureHandlerIndex() - 1)
                .handle(context);
    }

    public ChargeRouterImpl getRouter() {
        return route.router();
    }

    public ChargeRouteState<T> alsoMatchRaw(boolean match){
        return new ChargeRouteState<>(
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

    public ChargeRouteState<T> onlyMatchRaw(boolean match){
        return new ChargeRouteState<>(
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
