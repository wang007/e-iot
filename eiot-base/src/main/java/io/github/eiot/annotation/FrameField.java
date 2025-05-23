package io.github.eiot.annotation;

import io.github.eiot.codec.*;

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
    int len() default -1;


    /**
     * @return if len = -1, lenByFields != null, try to get by CodecContext use lenByField as key
     */
    String lenByField() default "";

    /**
     * put current value to {@link CodecContext}, use field name as key
     */
    boolean intoContext() default false;

    /**
     * specify the {@link OffsetNumberUnit#unit} and {@link OffsetBCDNumber#unit}
     *
     * @return the unit
     */
    int unit() default 1;

    /**
     * specify the {@link OffsetNumberUnit#unit} and {@link OffsetBCDNumber#unit}
     */
    int offset() default 0;

    /**
     * specify the {@link OffsetNumberUnit#unit} and {@link OffsetBCDNumber#unit}
     */
    boolean offsetReverse() default false;

}
