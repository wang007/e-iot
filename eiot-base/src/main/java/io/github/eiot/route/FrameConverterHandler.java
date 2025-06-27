package io.github.eiot.route;

import io.github.eiot.Frame;
import io.github.eiot.FrameConverter;
import io.vertx.core.Handler;

/**
 * created by wang007 on 2025/6/27
 */
public class FrameConverterHandler implements Handler<IotRoutingContext<Object>> {

    private final FrameConverter frameConverter;

    public FrameConverterHandler(FrameConverter frameConverter) {
        this.frameConverter = frameConverter;
    }

    @Override
    public void handle(IotRoutingContext<Object> ctx) {
        Frame<Object> frame = ctx.frame();
        Frame<?> frame1 = frameConverter.apply(frame);
        IotRoutingContextImpl<?> ctx1 = (IotRoutingContextImpl<?>) ctx;
        ctx1.replaceFrame(frame1);
        ctx1.next();
    }
}
