package com.github.eiot.test.example;

import io.github.eiot.IotConnectionBase;
import io.github.eiot.client.IotClientBase;
import io.github.eiot.client.IotClientOptions;
import io.netty.channel.ChannelHandlerContext;
import io.vertx.core.Vertx;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.json.JsonObject;
import io.vertx.core.spi.metrics.TCPMetrics;

/**
 * created by wang007 on 2025/4/12
 */
public class ExampleIotClient extends IotClientBase {

    public static IotClientOptions newOptions() {
        return new IotClientOptions()
                .setFrameCodecOptions(ExampleIotServer.FRAME_CODEC_OPTIONS)
                .setProtocol(ExampleIotServer.PROTOCOL);
    }

    public static IotClientOptions newOptions(JsonObject jsonObject) {
        return new IotClientOptions(jsonObject);
    }

    public static ExampleIotClient create(Vertx vertx, IotClientOptions options) {
        return new ExampleIotClient((VertxInternal) vertx, options);
    }

    public static ExampleIotClient create(Vertx vertx) {
        return create(vertx, newOptions());
    }

    protected ExampleIotClient(VertxInternal vertxInternal, IotClientOptions options) {
        super(vertxInternal, options);
    }

    @Override
    protected IotConnectionBase newIotConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics, IotClientOptions options) {
        if (options.isSeqNoMatchFirst()) {
            return new ExampleIotConnection(context, chctx, metrics,
                    options.isFrameConverter(), options.isSetResponseResult(),
                    options.getWaitResponseTimeout(), protocol());
        }
        return new ExampleCommandIotConnection(context, chctx, metrics,
                options.isFrameConverter(), options.isSetResponseResult(),
                options.getWaitResponseTimeout(), protocol());
    }
}
