package io.github.eiot.charge.annotation;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * created by wang007 on 2025/3/17
 */
public class FrameUtil {


    /**
     * new frame data instance. class must be annotation {@link Frame}
     *
     * @return the new instance.
     */
    public static <T> T newInstance(Class<T> clz) {
        // TODO new frame data Instance
        return null;
    }

    /**
     * encode frameData to byteBuf
     *
     * @param clz the frameData of class
     * @param frameData the data
     */
    public static ByteBuf encode(Class<?> clz, Object frameData) {
        // TODO encode
        return Unpooled.buffer();
    }

    /**
     * decode frameData from byteBuf
     *
     * @param clz the frameData of class
     * @param frameData  the data
     * @param byteBuf decode from byteBuf
     */
    public static void decode(Class<?> clz, Object frameData, ByteBuf byteBuf) {
        // TODO decode
    }

}
