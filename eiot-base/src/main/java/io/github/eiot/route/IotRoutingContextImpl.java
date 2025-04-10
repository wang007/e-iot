package io.github.eiot.route;

import io.github.eiot.IotConnection;
import io.github.eiot.Frame;
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
class IotRoutingContextImpl<T> implements IotRoutingContext<T> {

    protected static final Logger LOG = LoggerFactory.getLogger(IotRoutingContextImpl.class);

    private final Vertx vertx;
    private Frame<?> frame;
    private final IotRouterImpl router;
    private final AtomicInteger currentRouteNextHandlerIndex;
    private final AtomicInteger currentRouteNextFailureHandlerIndex;
    private final Map<String, Object> attributes;
    private IotRouteState<?> currentRoute;
    private volatile Iterator<IotRouteImpl<?>> routes;
    private volatile Throwable failure;

    public IotRoutingContextImpl(Vertx vertx, Frame<?> frame, IotRouterImpl router, Set<IotRouteImpl<?>> routes) {
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

    @SuppressWarnings("unchecked")
    private boolean iterateNext() {
        boolean failed = failed();
        if (currentRoute != null) {
            try {
                IotRouteState<T> routeState = (IotRouteState<T>) this.currentRoute;
                if (!failed && routeState.hasNextHandler(this)) {
                    currentRouteNextHandlerIndex.incrementAndGet();
                    routeState.handleContext(this);
                    return true;
                } else if (failed && routeState.hasNextFailureHandler(this)) {
                    currentRouteNextHandlerIndex.incrementAndGet();
                    routeState.handleFailure(this);
                    return true;
                }
            } catch (Throwable t) {
                handleInHandlerRuntimeFailure(currentRoute.getRouter(), failed, t);
                return true;
            }
        }

        while (routes.hasNext()) {
            IotRouteState<T> routeState = (IotRouteState<T>) routes.next().chargeRouteState();
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

    private void handleInHandlerRuntimeFailure(IotRouterImpl router, boolean failed, Throwable t) {
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

    @SuppressWarnings("unchecked")
    @Override
    public Frame<T> frame() {
        return (Frame<T>) frame;
    }

    @Override
    public synchronized IotRoutingContext<T> replaceFrame(Frame<?> frame) {
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
    public IotConnection connection() {
        return frame.iotConnection();
    }

    @SuppressWarnings("unchecked")
    @Override
    public IotRoute<T> currentRoute() {
        return (IotRoute<T>) currentRoute.chargeRoute();
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
