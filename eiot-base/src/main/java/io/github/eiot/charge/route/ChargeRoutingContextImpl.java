package io.github.eiot.charge.route;

import io.github.eiot.charge.ChargeConnection;
import io.github.eiot.charge.Frame;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yan
 * @since 2025-03-23
 */
public class ChargeRoutingContextImpl<T extends Frame<?>> implements ChargeRoutingContext<T> {

    protected static final Logger LOG = LoggerFactory.getLogger(ChargeRoutingContextImpl.class);

    private final Vertx vertx;
    private T frame;
    private final ChargeRouterImpl<T> router;
    private final AtomicInteger currentRouteNextHandlerIndex;
    private final AtomicInteger currentRouteNextFailureHandlerIndex;
    private final Map<String, Object> attributes;
    private ChargeRouteState<T> currentRoute;
    private volatile Iterator<ChargeRouteImpl<T>> routes;
    private volatile Throwable failure;

    public ChargeRoutingContextImpl(Vertx vertx, T frame, ChargeRouterImpl<T> router, Set<ChargeRouteImpl<T>> routes) {
        this.vertx = vertx;
        this.frame = frame;
        this.router = router;
        this.currentRouteNextHandlerIndex = new AtomicInteger(0);
        this.currentRouteNextFailureHandlerIndex = new AtomicInteger(0);
        this.attributes = new HashMap<>();
        this.routes = routes.iterator();
    }

    @Override
    public Map<String, Object> attributes() {
        return this.attributes;
    }

    @Override
    public String messageType() {
        return frame.messageType();
    }

    @Override
    public void next() {
        if (!iterateNext()) {
            LOG.error("no route can be find!");
        }
    }

    private boolean iterateNext() {
        boolean failed = failed();
        if (currentRoute != null) {
            try {
                if (!failed && currentRoute.hasNextHandler(this)) {
                    currentRouteNextHandlerIndex.incrementAndGet();
                    currentRoute.handleContext(this);
                    return true;
                } else if (failed && currentRoute.hasNextFailureHandler(this)) {
                    currentRouteNextHandlerIndex.incrementAndGet();
                    currentRoute.handleFailure(this);
                    return true;
                }
            } catch (Throwable t) {
                handleInHandlerRuntimeFailure(currentRoute.getRouter(), failed, t);
                return true;
            }
        }

        while (routes.hasNext()) {
            ChargeRouteState<T> routeState = routes.next().chargeRouteState();
            currentRouteNextHandlerIndex.set(0);
            currentRouteNextFailureHandlerIndex.set(0);
            try {
                if (!routeState.match(frame)) {
                    continue;
                }
            } catch (Throwable t) {
                handleInHandlerRuntimeFailure(currentRoute.getRouter(), failed, t);
                return true;
            }
            try {
                currentRoute = routeState;
                if (failed && currentRoute.hasNextFailureHandler(this)) {
                    currentRouteNextFailureHandlerIndex.incrementAndGet();
                    routeState.handleFailure(this);
                } else if (currentRoute.hasNextHandler(this)) {
                    currentRouteNextHandlerIndex.incrementAndGet();
                    routeState.handleContext(this);
                } else {
                    continue;
                }
            } catch (Throwable t) {
                handleInHandlerRuntimeFailure(routeState.getRouter(), failed, t);
            }
            return true;
        }
        return false;
    }

    private void handleInHandlerRuntimeFailure(ChargeRouterImpl<T> router, boolean failed, Throwable t) {
        if (!failed) {
            fail(t);
        } else {
            // invoke router error handler
            List<Handler<Throwable>> exceptionHandlers = router.exceptionHandlers();
            if (exceptionHandlers == null) {
                LOG.error("Unhandled exception in chargeRouter", failure);
            } else {
                exceptionHandlers.forEach(handler -> {
                    handler.handle(t);
                });
            }
        }
    }

    @Override
    public void fail(Throwable throwable) {
        this.failure = throwable == null ? new NullPointerException() : throwable;
        this.routes = router.routes();
        currentRoute = null;
        next();
    }

    @Override
    public T frame() {
        return frame;
    }

    @Override
    public synchronized ChargeRoutingContext<T> replaceFrame(T frame) {
        this.frame = frame;
        return this;
    }

    @Override
    public Throwable failure() {
        return failure;
    }

    @Override
    public boolean failed() {
        return failure != null;
    }

    @Override
    public ChargeConnection connection() {
        return frame.chargeConnection();
    }

    @Override
    public ChargeRoute<T> currentRoute() {
        return currentRoute.chargeRoute();
    }

    int currentRouteNextHandlerIndex() {
        return currentRouteNextHandlerIndex.get();
    }

    int currentRouteNextFailureHandlerIndex() {
        return currentRouteNextFailureHandlerIndex.get();
    }

    @Override
    public Vertx vertx() {
        return vertx;
    }
}
