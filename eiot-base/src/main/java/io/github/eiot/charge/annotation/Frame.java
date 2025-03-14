package io.github.eiot.charge.annotation;


import io.github.eiot.charge.codec.CodecContext;

/**
 * How does the declaration parse frame data
 *
 * created by wang007 on 2025/2/20
 */
public @interface Frame {

    /**
     *
     * @return byte orders
     */
    ByteOrder byteOrder() default ByteOrder.BIG_ENDIAN;

    /**
     *
     * @return
     */
    int length() default 0;

    /**
     * Whether the parsing process needs to carry context
     *
     * @return true: with context, false: {@link CodecContext#EMPTY}
     */
    boolean withContext() default false;

    //
    //int loopLen()
}
