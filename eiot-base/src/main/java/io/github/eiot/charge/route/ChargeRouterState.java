package io.github.eiot.charge.route;

import io.github.eiot.charge.Frame;
import io.vertx.core.Handler;

import java.util.*;

/**
 * @author yan
 * @since 2025-03-26
 */
public class ChargeRouterState {

    private final ChargeRouter router;
    private final TreeSet<ChargeRouteImpl<?>> routes;
    private final int orderSequence;
    private final List<Handler<Throwable>> exceptionHandlers;

    public ChargeRouterState(ChargeRouter router) {
        this(router, null, 0, null);
    }

    public ChargeRouterState(ChargeRouter router, TreeSet<ChargeRouteImpl<?>> routes, int orderSequence, List<Handler<Throwable>> exceptionHandlers) {
        this.router = router;
        this.routes = routes;
        this.orderSequence = orderSequence;
        this.exceptionHandlers = exceptionHandlers;
    }

    public int orderSequence() {
        return this.orderSequence;
    }

    public ChargeRouterState incrementOrderSequence() {
        return new ChargeRouterState(router, routes, orderSequence + 1, exceptionHandlers);
    }

    public ChargeRouterState addExceptionHandler(Handler<Throwable> exceptionHandler) {
        ChargeRouterState state = new ChargeRouterState(
                this.router,
                routes,
                this.orderSequence,
                exceptionHandlers == null ? new ArrayList<>() : new ArrayList<>(this.exceptionHandlers)
        );
        state.exceptionHandlers.add(exceptionHandler);
        return state;
    }

    Set<ChargeRouteImpl<?>> routes() {
        if (routes == null) {
            return Collections.emptySet();
        }
        return routes;
    }

    public ChargeRouterState addRoute(ChargeRouteImpl<?> route) {
        TreeSet<ChargeRouteImpl<?>> routes = new TreeSet<>((o1, o2) -> {
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

        return new ChargeRouterState(this.router, routes, this.orderSequence, exceptionHandlers);
    }

    public List<Handler<Throwable>> exceptionHandlers() {
        return exceptionHandlers;
    }
}
