package io.github.eiot.charge.ykc;

import io.github.eiot.charge.ChargeConnectionBase;
import io.github.eiot.charge.FrameCodecOptions;
import io.github.eiot.charge.server.ChargeServer;
import io.github.eiot.charge.server.ChargeServerBase;
import io.github.eiot.charge.server.ChargeServerOptions;
import io.netty.channel.ChannelHandlerContext;
import io.vertx.core.Vertx;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.impl.SslChannelProvider;
import io.vertx.core.spi.metrics.TCPMetrics;

import java.nio.ByteOrder;

/**
 * 云快充协议充电 server
 * <p>
 * created by wang007 on 2025/3/17
 */
public class YkcChargeServer extends ChargeServerBase {

    static final FrameCodecOptions FRAME_CODEC_OPTIONS = new FrameCodecOptions()
            .setByteOrder(ByteOrder.LITTLE_ENDIAN)
            .setMaxFrameLength(255)
            .setLengthFieldLength(1)
            .setLengthFieldOffset(1)
            .setLengthAdjustment(2);

    public static final String PROTOCOL = "ykc/1.x";

    public static ChargeServerOptions newOptions(JsonObject options) {
        ChargeServerOptions serverOptions = new ChargeServerOptions(options);
        serverOptions.setFrameCodecOptions(new FrameCodecOptions(FRAME_CODEC_OPTIONS))
                .setProtocol(PROTOCOL);
        return serverOptions;
    }

    public static ChargeServerOptions newOptions() {
        ChargeServerOptions serverOptions = new ChargeServerOptions();
        serverOptions.setFrameCodecOptions(new FrameCodecOptions(FRAME_CODEC_OPTIONS))
                .setProtocol(PROTOCOL);
        return serverOptions;
    }


    public static ChargeServer create(Vertx vertx) {
        return new YkcChargeServer(vertx, newOptions());
    }

    public static ChargeServer create(Vertx vertx, ChargeServerOptions options) {
        return new YkcChargeServer(vertx, options);
    }


    /**
     * create ykc charge server instance
     *
     * @param vertx   the vertx
     * @param options the options
     */
    YkcChargeServer(Vertx vertx, ChargeServerOptions options) {
        super(vertx, options);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected <T extends ChargeConnectionBase> T newChargeConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics, ChargeServerOptions options) {
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
