package io.github.eiot.route.handler;

import io.github.eiot.IotConnection;
import io.github.eiot.route.IotRoutingContext;
import io.vertx.core.Handler;

/**
 *
 * created by wang007 on 2025/6/30
 */
public class SetResponseResultHandler implements Handler<IotRoutingContext<Object>> {

    @Override
    public void handle(IotRoutingContext<Object> ctx) {
        IotConnection connection = ctx.connection();
        if (ctx.failed()) {
            if (connection.trySetResponseResult(ctx.frame(), ctx.failure())) {
                return;
            }
        } else {
            if (connection.trySetResponseResult(ctx.frame(), null)) {
                return;
            }
        }
        ctx.next();
    }
}
