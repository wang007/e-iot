package io.github.eiot.charge.codec;


import io.netty.buffer.ByteBuf;


/**
 * encode and decode from byteBuf
 * <p>
 * created by wang007 on 2025/2/25
 */
public interface Codec<T> {

    /**
     * Some data is read from byteBuf and parsed to type T
     *
     * @param byteBuf input byteBuf
     * @param context the codec context
     * @return the T instance
     */
    T decode(ByteBuf byteBuf, CodecContext context);

    /**
     * like {@link #decode(ByteBuf, CodecContext)} but use {@link CodecContext#EMPTY}
     *
     * @param byteBuf input byteBuf
     * @return the T instance
     */
    default T decode(ByteBuf byteBuf) {
        return decode(byteBuf, CodecContext.EMPTY);
    }

    /**
     * encode T and write it into byteBuf
     *
     * @param byteBuf output byteBuf
     * @param data    the need to encode
     * @param context the codec context
     */
    void encode(ByteBuf byteBuf, T data, CodecContext context);

    /**
     * like {@link #decode(ByteBuf, CodecContext)} but use {@link CodecContext#EMPTY}
     *
     * @param byteBuf output byteBuf
     * @param data    the need to encode
     */
    default void encode(ByteBuf byteBuf, T data) {
        encode(byteBuf, data, CodecContext.EMPTY);
    }

    /**
     * Specifies the byte buf length that the codec needs to codec
     *
     * @return return -1 if not sure
     */
    int getLength();
}
