package io.github.eiot.charge.annotation;

import io.github.eiot.charge.codec.Codec;
import io.github.eiot.charge.codec.VoidCodec;

/**
 * Declares how to parse fields in frame data
 *
 * created by wang007 on 2025/2/20
 */
public @interface FrameField {

    /**
     * If it is not specified, it is automatically determined by type.
     * if not support, throws {@link IllegalArgumentException}
     *
     * @return type codec
     */
    Class<? extends Codec<?>> type() default VoidCodec.class;

    /**
     * byte order. default follow {@link Frame#byteOrder()}
     *
     * @return byte orders
     */
    ByteOrder byteOrder() default ByteOrder.NULL;

    /**
     *
     * @return frame field data length
     */
    int length() default -1;

}
