package io.github.eiot.charge.ykc;

import io.github.eiot.impl.IotConnectionBase;
import io.github.eiot.impl.IotClientBase;
import io.github.eiot.IotClientOptions;
import io.netty.channel.ChannelHandlerContext;
import io.vertx.core.Vertx;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.json.JsonObject;
import io.vertx.core.spi.metrics.TCPMetrics;

/**
 * created by wang007 on 2025/3/18
 */
public class YkcClient extends IotClientBase {

    public static IotClientOptions newOptions() {
        return new IotClientOptions()
                .setFrameCodecOptions(YkcServer.FRAME_CODEC_OPTIONS)
                .setProtocol(YkcServer.PROTOCOL);
    }

    public static IotClientOptions newOptions(JsonObject jsonObject) {
        return new IotClientOptions(jsonObject);
    }

    public static YkcClient create(Vertx vertx, IotClientOptions options) {
        return new YkcClient((VertxInternal) vertx, options);
    }

    public static YkcClient create(Vertx vertx) {
        return create(vertx, newOptions());
    }

    YkcClient(VertxInternal vertxInternal, IotClientOptions options) {
        super(vertxInternal, options);
    }

    @Override
    protected IotConnectionBase newIotConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics, IotClientOptions options) {
        if (options.isSeqNoMatchFirst()) {
            return new YkcConnection(context, chctx, metrics,
                    options.isFrameConverter(), options.isSetResponseResult(), options.getWaitResponseTimeout(), options.getProtocol());
        }
        return new YkcCommandConnection(context, chctx, metrics,
                options.isFrameConverter(), options.isSetResponseResult(), options.getWaitResponseTimeout(), options.getProtocol());
    }
}
