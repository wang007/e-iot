package io.github.eiot.charge.ykc;

import io.github.eiot.charge.ChargeConnectionBase;
import io.github.eiot.charge.client.ChargeClient;
import io.github.eiot.charge.client.ChargeClientBase;
import io.github.eiot.charge.client.ChargeClientOptions;
import io.netty.channel.ChannelHandlerContext;
import io.vertx.core.Vertx;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.json.JsonObject;
import io.vertx.core.spi.metrics.TCPMetrics;

/**
 * created by wang007 on 2025/3/18
 */
public class YkcChargeClient extends ChargeClientBase {

    public static ChargeClientOptions newOptions() {
        return new ChargeClientOptions()
                .setFrameCodecOptions(YkcChargeServer.FRAME_CODEC_OPTIONS)
                .setProtocol(YkcChargeServer.PROTOCOL);
    }

    public static ChargeClientOptions newOptions(JsonObject jsonObject) {
        return new ChargeClientOptions(jsonObject);
    }

    public static ChargeClient create(Vertx vertx, ChargeClientOptions options) {
        return new YkcChargeClient((VertxInternal) vertx, options);
    }

    public static ChargeClient create(Vertx vertx) {
        return create(vertx, newOptions());
    }

    YkcChargeClient(VertxInternal vertxInternal, ChargeClientOptions options) {
        super(vertxInternal, options);
    }

    @Override
    protected <T extends ChargeConnectionBase> T newChargeConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics, ChargeClientOptions options) {
        if (options.isSeqNoMatchFirst()) {
            YkcChargeConnection chargeConnection = new YkcChargeConnection(context, chctx, metrics,
                    options.isFrameConverter(), options.isSetResponseResult(), options.getWaitResponseTimeout(), options.getProtocol());
            return (T) chargeConnection;
        }
        YkcMTChargeConnection chargeConnection = new YkcMTChargeConnection(context, chctx, metrics,
                options.isFrameConverter(), options.isSetResponseResult(), options.getWaitResponseTimeout(), options.getProtocol());
        return (T) chargeConnection;
    }
}
