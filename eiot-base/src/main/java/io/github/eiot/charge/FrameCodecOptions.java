package io.github.eiot.charge;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.json.annotations.JsonGen;
import io.vertx.core.json.JsonObject;

import java.nio.ByteOrder;

/**
 * It is used to cut a frame from a tcp stream.
 *
 * @see LengthFieldBasedFrameDecoder
 * <p>
 * created by wang007 on 2025/2/24
 */
@DataObject
@JsonGen(publicConverter = false)
public class FrameCodecOptions {

    /**
     * the maximum length of the frame.  If the length of the frame is
     * greater than this value, {@link TooLongFrameException} will be thrown.
     */
    private int maxFrameLength;

    /**
     * the {@link ByteOrder} of the length field
     */
    private ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;

    /**
     * the offset of the length field
     */
    private int lengthFieldOffset;

    /**
     * the length of the length field
     */
    private int lengthFieldLength;

    /**
     * the compensation value to add to the value of the length field
     */
    private int lengthAdjustment;

    public FrameCodecOptions() {

    }

    public FrameCodecOptions(JsonObject jsonObject) {
        FrameCodecOptionsConverter.fromJson(jsonObject, this);
    }

    public FrameCodecOptions(FrameCodecOptions options) {
        this.maxFrameLength = options.maxFrameLength;
        this.byteOrder = options.byteOrder;
        this.lengthFieldOffset = options.lengthFieldOffset;
        this.lengthFieldLength = options.lengthFieldLength;
        this.lengthAdjustment = options.lengthAdjustment;
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        FrameCodecOptionsConverter.toJson(this, json);
        return json;
    }

    public int getMaxFrameLength() {
        return maxFrameLength;
    }

    public FrameCodecOptions setMaxFrameLength(int maxFrameLength) {
        this.maxFrameLength = maxFrameLength;
        return this;
    }

    public ByteOrder getByteOrder() {
        return byteOrder;
    }

    public FrameCodecOptions setByteOrder(ByteOrder byteOrder) {
        this.byteOrder = byteOrder;
        return this;
    }

    public int getLengthFieldOffset() {
        return lengthFieldOffset;
    }

    public FrameCodecOptions setLengthFieldOffset(int lengthFieldOffset) {
        this.lengthFieldOffset = lengthFieldOffset;
        return this;
    }

    public int getLengthFieldLength() {
        return lengthFieldLength;
    }

    public FrameCodecOptions setLengthFieldLength(int lengthFieldLength) {
        this.lengthFieldLength = lengthFieldLength;
        return this;
    }

    public int getLengthAdjustment() {
        return lengthAdjustment;
    }

    public FrameCodecOptions setLengthAdjustment(int lengthAdjustment) {
        this.lengthAdjustment = lengthAdjustment;
        return this;
    }
}
