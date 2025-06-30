package io.github.eiot.route;

import io.vertx.core.Handler;

import java.util.Objects;

/**
 * created by wang007 on 2025/7/10
 */
class BlockingHandlerDecorator<T> implements Handler<IotRoutingContext<T>> {

    private final boolean ordered;
    private final Handler<IotRoutingContext<T>> decoratedHandler;

    BlockingHandlerDecorator(Handler<IotRoutingContext<T>> handler, boolean ordered) {
        Objects.requireNonNull(handler);
        this.decoratedHandler = handler;
        this.ordered = ordered;
    }

    @Override
    public void handle(IotRoutingContext<T> ctx) {
        ctx.vertx()
                .executeBlocking(() -> {
                    decoratedHandler.handle(ctx);
                    return null;
                }, ordered)
                .onFailure(ctx::fail);
    }
}
