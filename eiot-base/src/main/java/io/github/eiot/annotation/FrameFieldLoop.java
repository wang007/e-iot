package io.github.eiot.annotation;

import java.lang.annotation.*;

/**
 * use for loop parsing field
 * <p>
 * created by wang007 on 2025/3/17
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface FrameFieldLoop {

    /**
     * loop count. if return -1, use {@link #loopByField()}
     */
    int loopCount() default -1;

    /**
     * loop by field.
     * see {@link FrameField#intoContext()}
     */
    String loopByField() default "";

    /**
     * Declares how to parse single {@link FrameField} in loop
     */
    FrameField frameField();
}
