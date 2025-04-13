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

    protected final Constructor<?> constructor;

    protected final Frame frame;

    protected final List<FrameFieldDefinition> fieldDefinitions;

    public FrameDefinition(Constructor<?> constructor, Frame frame, List<FrameFieldDefinition> fields) {
        this.constructor = constructor;
        this.frame = frame;
        this.fieldDefinitions = fields;
    }

    protected static class FrameFieldDefinition {
        protected Field field;

        protected Codec codec;

        protected FrameFieldLoop frameFieldLoop;

        protected FrameField frameField;

        protected Class<?> listClass;

        protected Codec listClassCodec;

        protected FrameFieldDynamics frameFieldDynamics;
    }
}
