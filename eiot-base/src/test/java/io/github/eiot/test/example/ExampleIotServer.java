package io.github.eiot.test.example;

import io.github.eiot.FrameCodecOptions;
import io.github.eiot.impl.IotConnectionBase;
import io.github.eiot.impl.IotServerBase;
import io.github.eiot.IotServerOptions;
import io.netty.channel.ChannelHandlerContext;
import io.vertx.core.Vertx;
import io.vertx.core.internal.ContextInternal;
import io.vertx.core.json.JsonObject;
import io.vertx.core.spi.metrics.TCPMetrics;

import java.nio.ByteOrder;

/**
 * created by wang007 on 2025/4/12
 */
public class ExampleIotServer extends IotServerBase {

    static final FrameCodecOptions FRAME_CODEC_OPTIONS = new FrameCodecOptions()
            .setByteOrder(ByteOrder.LITTLE_ENDIAN)
            .setMaxFrameLength(255)
            .setLengthFieldLength(2)
            .setLengthFieldOffset(11);

    public static final String PROTOCOL = "example";

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

    public static ExampleIotServer create(Vertx vertx) {
        return new ExampleIotServer(vertx, newOptions());
    }

    public static ExampleIotServer create(Vertx vertx, IotServerOptions options) {
        return new ExampleIotServer(vertx, options);
    }

    /**
     * @param vertx   the vertx
     * @param options the options
     */
    protected ExampleIotServer(Vertx vertx, IotServerOptions options) {
        super(vertx, options);
    }

    @Override
    protected IotConnectionBase newIotConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics, IotServerOptions options) {
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
