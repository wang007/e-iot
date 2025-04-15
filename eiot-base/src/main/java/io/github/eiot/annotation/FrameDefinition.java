package io.github.eiot.annotation;

import io.github.eiot.codec.Codec;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

/**
 * frame definition
 *
 * @author yan
 * @since 2025-04-10
 */
public class FrameDefinition {

    /**
     * class annotated by @{@link Frame}
     */
    final Class<?> frameDateClz;

    final Constructor<?> constructor;

    final Frame frame;

    final List<FrameFieldDefinition> fieldDefinitions;

    FrameDefinition(Class<?> frameDateClz, Constructor<?> noArgsConstructor,  Frame frame, List<FrameFieldDefinition> fields) {
        this.frameDateClz = frameDateClz;
        this.constructor = noArgsConstructor;
        this.frame = frame;
        this.fieldDefinitions = fields;
    }

    static class FrameFieldDefinition {
        Field field;

        /**
         * if frameFieldLoop use @Frame data type, need to loop codec
         */
        Codec codec;

        FrameFieldLoop frameFieldLoop;

        FrameField frameField;

        // protected Class<?> listClass;

        // protected Codec listClassCodec;

        FrameFieldDynamics frameFieldDynamics;
    }
}
