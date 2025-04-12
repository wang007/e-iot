package io.github.eiot.charge.ykc;

import io.github.eiot.IotConnectionBase;
import io.github.eiot.client.IotClient;
import io.github.eiot.client.IotClientBase;
import io.github.eiot.client.IotClientOptions;
import io.netty.channel.ChannelHandlerContext;
import io.vertx.core.Vertx;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.json.JsonObject;
import io.vertx.core.spi.metrics.TCPMetrics;

/**
 * created by wang007 on 2025/3/18
 */
public class YkcChargeClient extends IotClientBase {

    public static IotClientOptions newOptions() {
        return new IotClientOptions()
                .setFrameCodecOptions(YkcChargeServer.FRAME_CODEC_OPTIONS)
                .setProtocol(YkcChargeServer.PROTOCOL);
    }

    public static IotClientOptions newOptions(JsonObject jsonObject) {
        return new IotClientOptions(jsonObject);
    }

    public static YkcChargeClient create(Vertx vertx, IotClientOptions options) {
        return new YkcChargeClient((VertxInternal) vertx, options);
    }

    public static YkcChargeClient create(Vertx vertx) {
        return create(vertx, newOptions());
    }

    YkcChargeClient(VertxInternal vertxInternal, IotClientOptions options) {
        super(vertxInternal, options);
    }

    @Override
    protected IotConnectionBase newIotConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics, IotClientOptions options) {
        if (options.isSeqNoMatchFirst()) {
            return new YkcChargeConnection(context, chctx, metrics,
                    options.isFrameConverter(), options.isSetResponseResult(), options.getWaitResponseTimeout(), options.getProtocol());
        }
        return new YkcMTChargeConnection(context, chctx, metrics,
                options.isFrameConverter(), options.isSetResponseResult(), options.getWaitResponseTimeout(), options.getProtocol());
    }
}
