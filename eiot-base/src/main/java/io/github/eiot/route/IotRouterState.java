package io.github.eiot.route;

import io.vertx.core.Handler;

import java.util.*;

/**
 * @author yan
 * @since 2025-03-26
 */
public class IotRouterState {

    private final IotRouter router;
    private final TreeSet<IotRouteImpl<?>> routes;
    private final int orderSequence;
    private final List<Handler<Throwable>> exceptionHandlers;

    public IotRouterState(IotRouter router) {
        this(router, null, 0, null);
    }

    public IotRouterState(IotRouter router, TreeSet<IotRouteImpl<?>> routes, int orderSequence, List<Handler<Throwable>> exceptionHandlers) {
        this.router = router;
        this.routes = routes;
        this.orderSequence = orderSequence;
        this.exceptionHandlers = exceptionHandlers;
    }

    public int orderSequence() {
        return this.orderSequence;
    }

    public IotRouterState incrementOrderSequence() {
        return new IotRouterState(router, routes, orderSequence + 1, exceptionHandlers);
    }

    public IotRouterState addExceptionHandler(Handler<Throwable> exceptionHandler) {
        IotRouterState state = new IotRouterState(
                this.router,
                routes,
                this.orderSequence,
                exceptionHandlers == null ? new ArrayList<>() : new ArrayList<>(this.exceptionHandlers)
        );
        state.exceptionHandlers.add(exceptionHandler);
        return state;
    }

    Set<IotRouteImpl<?>> routes() {
        if (routes == null) {
            return Collections.emptySet();
        }
        return routes;
    }

    public IotRouterState addRoute(IotRouteImpl<?> route) {
        TreeSet<IotRouteImpl<?>> routes = new TreeSet<>((o1, o2) -> {
            final int compare = Integer.compare(o1.order(), o2.order());
            if (compare == 0) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return 1;
            }
            return compare;
        });
        if (this.routes != null) {
            routes.addAll(this.routes);
        }
        routes.add(route);

        return new IotRouterState(this.router, routes, this.orderSequence, exceptionHandlers);
    }

    public List<Handler<Throwable>> exceptionHandlers() {
        return exceptionHandlers;
    }
}
