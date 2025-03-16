package io.github.eiot.charge.annotation;

import io.github.eiot.charge.codec.Codec;
import io.github.eiot.charge.codec.CodecContext;
import io.github.eiot.charge.codec.NumberUnit;
import io.github.eiot.charge.codec.VoidCodec;

import java.lang.annotation.*;

/**
 * Declares how to parse fields in frame data
 * <p>
 * created by wang007 on 2025/2/20
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
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
     * @return frame field data length
     */
    int length() default -1;

    /**
     * put current value to {@link CodecContext}, use field name as key
     */
    boolean intoContext() default false;

    /**
     * specify the {@link NumberUnit#unit}
     *
     * @return the unit
     */
    int unit() default 1;

    /**
     * specify the {@link NumberUnit#offset}
     */
    int offset() default 0;

    /**
     * specify the {@link NumberUnit#offsetReverse}
     */
    boolean offsetReverse() default false;

}
