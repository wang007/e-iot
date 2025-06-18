package io.github.eiot.annotation;

import io.github.eiot.exception.IotException;
import io.github.eiot.codec.*;
import io.netty.buffer.ByteBuf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * created by wang007 on 2025/4/15
 */
class BaseTypeCodecCache {

    static final Map<Class<?>, Class<? extends Codec<?>>> baseTypeCodecs;

    static {
        Map<Class<?>, Class<? extends Codec<?>>> tempMap = new HashMap<>();
        tempMap.put(Ascii.class, AsciiCodec.class);
        tempMap.put(BCD.class, BCDCodec.class);
        tempMap.put(BCDNumber.class, BCDNumberCodec.class);
        tempMap.put(BCDTime.class, BCDTimeCodec.class);
        tempMap.put(Integer.class, BIN4Codec.class);
        tempMap.put(Integer.TYPE, BIN4Codec.class);
        tempMap.put(Long.class, BIN8Codec.class);
        tempMap.put(Long.TYPE, BIN8Codec.class);
        tempMap.put(ByteBufRef.class, ByteBufRefCodec.class);
        tempMap.put(ByteBuf.class, ByteBufCodec.class);
        tempMap.put(byte[].class, BytesCodec.class);
        tempMap.put(CP56time2a.class, CP56time2aCodec.class);
        tempMap.put(Hex.class, HexCodec.class);
        tempMap.put(NumberUnit.class, NumberUnitCodec.class);
        tempMap.put(OffsetBCDNumber.class, OffsetBCDNumberCodec.class);
        tempMap.put(OffsetNumberUnit.class, OffsetNumberUnitCodec.class);
        baseTypeCodecs = tempMap;
    }

    private final Map<CodecKey, Codec<?>> baseCodecMap = new ConcurrentHashMap<>();


    public Codec<?> generateBaseCodec(Class<?> clz, Field field, ByteOrder defaultOrder, FrameField frameField) {
        Class<? extends Codec<?>> codecType = (frameField.type() != VoidCodec.class ? frameField.type() : baseTypeCodecs.get(clz));
        if (codecType == null || codecType == VoidCodec.class) {
            throw new IllegalArgumentException(clz.getName() + " can not find any codec");
        }
        ByteOrder order = frameField.byteOrder();
        order = order == ByteOrder.NULL ? defaultOrder : frameField.byteOrder();
        if (order == ByteOrder.NULL) {
            throw new IllegalArgumentException("ByteOrder.NULL not allow");
        }
        java.nio.ByteOrder byteOrder = (order == ByteOrder.BIG_ENDIAN ? java.nio.ByteOrder.BIG_ENDIAN : java.nio.ByteOrder.LITTLE_ENDIAN);
        CodecKey codecKey = new CodecKey(clz, byteOrder, frameField, field);

        Function<CodecKey, Codec<?>> f = k -> {
            try {
                String lengthKey = frameField.lenByField();
                if (lengthKey.isEmpty()) {
                    lengthKey = null;
                }
                if (codecType == BCDNumberCodec.class) {
                    Constructor<? extends Codec<?>> constructor = codecType.getConstructor(int.class, java.nio.ByteOrder.class, String.class, int.class);
                    return constructor.newInstance(frameField.len(), byteOrder, frameField.lenByField(), frameField.unit());

                } else if (codecType == OffsetBCDNumberCodec.class) {
                    Constructor<? extends Codec<?>> constructor = codecType.getConstructor(int.class, java.nio.ByteOrder.class, String.class, int.class, int.class, boolean.class);
                    return constructor.newInstance(frameField.len(), byteOrder, frameField.lenByField(), frameField.unit(), frameField.offset(), frameField.offsetReverse());

                } else if (codecType == NumberUnitCodec.class) {
                    Constructor<? extends Codec<?>> constructor = codecType.getConstructor(int.class, java.nio.ByteOrder.class, int.class);
                    return constructor.newInstance(frameField.len(), byteOrder, frameField.unit());

                } else if (codecType == OffsetNumberUnitCodec.class) {
                    Constructor<? extends Codec<?>> constructor = codecType.getConstructor(int.class, java.nio.ByteOrder.class, int.class, int.class, boolean.class);
                    return constructor.newInstance(frameField.len(), byteOrder, frameField.unit(), frameField.offset(), frameField.offsetReverse());

                } else if (codecType == BCDTimeCodec.class || codecType == CP56time2aCodec.class) {
                    Constructor<? extends Codec<?>> constructor = codecType.getConstructor(java.nio.ByteOrder.class);
                    return constructor.newInstance(byteOrder);

                } else {
                    if (lengthKey == null && frameField.intoContext()) {
                        lengthKey = field.getName();
                    }
                    Constructor<? extends Codec<?>> constructor = codecType.getConstructor(int.class, java.nio.ByteOrder.class, String.class);
                    return constructor.newInstance(frameField.len(), byteOrder, lengthKey);
                }
            } catch (Exception e) {
                throw new IotException("class: " + k.clz.getName() + "new Codec instance failed", e);
            }
        };
        return baseCodecMap.computeIfAbsent(codecKey, f);
    }


    private static class CodecKey {
        final Class<?> clz;
        final java.nio.ByteOrder byteOrder;
        final int len;
        final int unit;
        final int offset;
        final boolean offsetReverse;
        final String lenByField;

        CodecKey(Class<?> clz, java.nio.ByteOrder byteOrder, FrameField frameField, Field field) {
            this.clz = clz;
            this.byteOrder = byteOrder;
            this.len = frameField.len();
            this.unit = frameField.unit();
            this.offset = frameField.offset();
            this.offsetReverse = frameField.offsetReverse();
            String lenByField = frameField.lenByField();
            if (frameField.intoContext() && lenByField.isEmpty()) {
                lenByField = field.getName();
            }
            this.lenByField = lenByField;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CodecKey)) return false;
            CodecKey codecKey = (CodecKey) o;
            return len == codecKey.len && unit == codecKey.unit && offset == codecKey.offset && offsetReverse == codecKey.offsetReverse && Objects.equals(clz, codecKey.clz) && Objects.equals(byteOrder, codecKey.byteOrder) && Objects.equals(lenByField, codecKey.lenByField);
        }

        @Override
        public int hashCode() {
            return Objects.hash(clz, byteOrder, len, unit, offset, offsetReverse, lenByField);
        }
    }

}
