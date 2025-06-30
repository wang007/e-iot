package io.github.eiot.route.handler;

import io.github.eiot.Frame;
import io.github.eiot.exception.CheckCodeException;
import io.github.eiot.route.IotRoutingContext;
import io.vertx.core.Handler;

/**
 * created by wang007 on 2025/6/30
 */
public class CheckCodeHandler implements Handler<IotRoutingContext<Object>> {

    @Override
    public void handle(IotRoutingContext<Object> ctx) {
        if (ctx.failed()) {
            ctx.next();
            return;
        }
        Frame<Object> frame = ctx.frame();
        if (frame.checkCodeResult()) {
            ctx.next();
            return;
        }
        CheckCodeException exception = new CheckCodeException(frame.terminalNo(), frame, "frame checkout failed, command: " + frame.command());
        ctx.fail(exception);
    }
}
