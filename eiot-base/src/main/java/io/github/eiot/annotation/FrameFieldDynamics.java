package io.github.eiot.annotation;

import java.lang.annotation.*;

/**
 * dynamics field annotation
 * the field class must be byteBufRef
 *
 * @author yan
 * @since 2025-04-10
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface FrameFieldDynamics {

    /**
     * length reply on field
     */
    String lenByField() default "";

    /**
     * if the field is last
     * if is last, the rest byteBuf will fill the field
     */
    boolean isLast() default false;
}
