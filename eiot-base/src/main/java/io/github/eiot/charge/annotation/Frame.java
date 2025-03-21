package io.github.eiot.charge.annotation;


import io.github.eiot.charge.codec.CodecContext;

import java.lang.annotation.*;

/**
 * How does the declaration parse frame data
 * <p>
 * created by wang007 on 2025/2/20
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Frame {

    /**
     * @return byte orders
     */
    ByteOrder byteOrder() default ByteOrder.LITTLE_ENDIAN;

    /**
     * @return the length of the class annotated by @frame
     */
    int len() default 0;

    /**
     * Whether the parsing process needs to carry context
     *
     * @return true: with context, false: {@link CodecContext#EMPTY}
     */
    boolean withContext() default false;

    /**
     * If there is a {@link FrameFieldLoop} in the class, specify the length of a single loop
     * <p>
     * NOTE: It is not mandatory to declare, and is used in some extremely special situations
     */
    int loopLen() default 0;
}
