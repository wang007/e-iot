package io.github.eiot.route;

import io.github.eiot.IotConnection;
import io.github.eiot.Frame;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author yan
 * @since 2025-03-23
 */
class IotRoutingContextImpl<T> implements IotRoutingContext<T> {

    protected static final Logger LOG = LoggerFactory.getLogger(IotRoutingContextImpl.class);

    private final Vertx vertx;
    private Frame<?> frame;
    private final IotRouterImpl router;
    private IotRouteState<?> currentRoute;
    private Iterator<IotRouteImpl<?>> routes;
    private Throwable failure;

    public IotRoutingContextImpl(Vertx vertx, Frame<?> frame, IotRouterImpl router, Set<IotRouteImpl<?>> routes) {
        this.vertx = vertx;
        this.frame = frame;
        this.router = router;
        this.routes = routes.iterator();
    }

    @Override
    public Map<String, Object> attributes() {
        return frame.attributes();
    }

    @Override
    public String command() {
        return frame.command();
    }

    @Override
    public void next() {
        if (!iterateNext()) {
            handleNotMatch();
        }
    }

    private void handleNotMatch() {
        if (failed()) {
            Handler<Throwable> exceptionHandler = router.exceptionHandler();
            if (exceptionHandler != null) {
                try {
                    exceptionHandler.handle(failure);
                } catch (Throwable e) {
                    LOG.error("terminalNo: {} error handle failed", frame.terminalNo(), e);
                }
            } else {
                LOG.warn("terminalNo: {} fail() to next not found handler.", frame.terminalNo(), failure);
            }
            return;
        }
        if (LOG.isDebugEnabled()) {
            LOG.warn("terminalNo: {} next() not found handler.", frame.terminalNo());
        }
    }


    @SuppressWarnings("unchecked")
    private boolean iterateNext() {
        boolean failed = failed();
        while (routes.hasNext()) {
            IotRouteState<T> routeState = (IotRouteState<T>) routes.next().routeState();
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
                if (!failed && routeState.hasContextHandler()) {
                    routeState.handleContext(this);
                } else if (failed && routeState.hasFailureHandler()) {
                    routeState.handleFailure(this);
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
            Handler<Throwable> exceptionHandler = router.exceptionHandler();
            if (exceptionHandler == null) {
                LOG.error("terminalNo: {} Unhandled exception in IotRouter.", frame.terminalNo(), t);
                return;
            }
            try {
                exceptionHandler.handle(t);
            } catch (Throwable e) {
                LOG.error("terminalNo: {} error handle failed.", frame.terminalNo(), e);
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

    @Override
    public IotRoute<?> currentRoute() {
        return currentRoute.chargeRoute();
    }

    @Override
    public Vertx vertx() {
        return vertx;
    }
}
