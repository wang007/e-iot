package io.github.eiot.charge.ykc;

import io.github.eiot.IotConnectionBase;
import io.github.eiot.FrameCodecOptions;
import io.github.eiot.server.IotServer;
import io.github.eiot.server.IotServerBase;
import io.github.eiot.server.IotServerOptions;
import io.netty.channel.ChannelHandlerContext;
import io.vertx.core.Vertx;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.json.JsonObject;
import io.vertx.core.spi.metrics.TCPMetrics;

import java.nio.ByteOrder;

/**
 * 云快充协议充电 server
 * <p>
 * created by wang007 on 2025/3/17
 */
public class YkcChargeServer extends IotServerBase {

    static final FrameCodecOptions FRAME_CODEC_OPTIONS = new FrameCodecOptions()
            .setByteOrder(ByteOrder.LITTLE_ENDIAN)
            .setMaxFrameLength(255)
            .setLengthFieldLength(1)
            .setLengthFieldOffset(1)
            .setLengthAdjustment(2);

    public static final String PROTOCOL = "ykc/1.x";

    public static IotServerOptions newOptions(JsonObject options) {
        IotServerOptions serverOptions = new IotServerOptions(options);
        serverOptions.setFrameCodecOptions(new FrameCodecOptions(FRAME_CODEC_OPTIONS))
                .setProtocol(PROTOCOL);
        return serverOptions;
    }

    public static IotServerOptions newOptions() {
        IotServerOptions serverOptions = new IotServerOptions();
        serverOptions.setFrameCodecOptions(new FrameCodecOptions(FRAME_CODEC_OPTIONS))
                .setProtocol(PROTOCOL);
        return serverOptions;
    }


    public static YkcChargeServer create(Vertx vertx) {
        return new YkcChargeServer(vertx, newOptions());
    }

    public static YkcChargeServer create(Vertx vertx, IotServerOptions options) {
        return new YkcChargeServer(vertx, options);
    }


    /**
     * create ykc charge server instance
     *
     * @param vertx   the vertx
     * @param options the options
     */
    YkcChargeServer(Vertx vertx, IotServerOptions options) {
        super(vertx, options);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected <T extends IotConnectionBase> T newIotConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics, IotServerOptions options) {
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
