package io.github.eiot.annotation;

import io.github.eiot.IotException;
import io.github.eiot.codec.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.vertx.core.json.DecodeException;
import io.vertx.core.json.EncodeException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * created by wang007 on 2025/3/17
 */
public class FrameUtil {

    private static final Map<Class<?>, FrameDefinition> frameDefinitionMap = new ConcurrentHashMap<>();
    private static final Map<Class<?>, Class<? extends Codec<?>>> codecTypeMap;
    /**
     * codec map
     * key: codecName_len_byteOrder_unit_offset_offsetReverse
     * value: codec
     * e.g: {"BCDCodec_2_LITTLE_ENDIAN_100_-1_0": BCDCodec}
     */
    private static final Map<String, Codec<?>> codecMap = new ConcurrentHashMap<>();

    static {
        Map<Class<?>, Class<? extends Codec<?>>> tempMap = new HashMap<>();
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
        codecTypeMap = Collections.unmodifiableMap(tempMap);
    }

    /**
     * new frame data instance. class must be annotation {@link Frame}
     *
     * @return the new instance.
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstance(Class<T> clz) {
        FrameDefinition frameDefinition = getFrameDefinition(clz);
        try {
            return (T) frameDefinition.constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * encode frameData to byteBuf
     *
     * @param clz       the frameData of class
     * @param frameData the data
     */
    public static ByteBuf encode(Class<?> clz, Object frameData) throws Exception {
        FrameDefinition definition = getFrameDefinition(clz);
        if (definition == null) {
            throw new IotException("can not find frameDefinition");
        }
        ByteBuf buffer = Unpooled.buffer();
        encode(buffer, clz, frameData);
        return buffer;
    }

    /**
     * encode frameData to byteBuf
     *
     * @param buffer    target byteBuf
     * @param clz       the frameData of class
     * @param frameData the data
     */
    @SuppressWarnings("all")
    public static void encode(ByteBuf buffer, Class<?> clz, Object frameData) throws Exception {
        FrameDefinition definition = getFrameDefinition(clz);
        if (definition == null) {
            throw new IotException("can not find frameDefinition");
        }
        Map<String, Object> context = new HashMap<>();
        for (FrameDefinition.FrameFieldDefinition fieldDefinition : definition.fieldDefinitions) {
            Field field = fieldDefinition.field;
            try {
                if (fieldDefinition.frameFieldLoop != null) {
                    long loopNum = getLoopNum(fieldDefinition.frameFieldLoop, context);
                    List<?> list = (List<?>) field.get(frameData);
                    if (list.size() != loopNum) {
                        throw new IllegalArgumentException(field.getName() + " list size not equals " + loopNum);
                    }
                    Codec listClassCodec = fieldDefinition.listClassCodec;
                    if (listClassCodec != null){
                        for (int i = 0; i < loopNum; i++) {
                            listClassCodec.encode(buffer, list.get(i));
                        }
                    }else {
                        for (int i = 0; i < loopNum; i++) {
                            encode(buffer, fieldDefinition.listClass, list.get(i));
                        }
                    }
                } else if (fieldDefinition.frameField != null) {
                    Object v = field.get(frameData);
                    fieldDefinition.codec.encode(buffer, v);
                    if (fieldDefinition.frameField.intoContext()) {
                        context.put(field.getName(), v);
                    }
                } else if (fieldDefinition.frameFieldDynamics != null) {
                    FrameFieldDynamics fieldDynamics = fieldDefinition.frameFieldDynamics;
                    ByteBuf v = (ByteBuf) field.get(frameData);
                    if (!fieldDynamics.isLast()) {
                        Number len = (Number) context.get(fieldDynamics.lenByField());
                        if (len.longValue() != v.readableBytes()) {
                            throw new IllegalArgumentException(field.getName() + " len not equals " + len);
                        }
                    }
                    buffer.writeBytes(v);
                }
            } catch (Exception e) {
                throw new EncodeException("frame:" + clz.getName() + "field: " + field.getName() + " encode failed", e);
            }
        }
    }

    /**
     * decode frameData from byteBuf
     *
     * @param clz       the frameData of class
     * @param frameData the data
     * @param byteBuf   decode from byteBuf
     */
    public static void decode(Class<?> clz, Object frameData, ByteBuf byteBuf) {
        FrameDefinition definition = getFrameDefinition(clz);
        Map<String, Object> context = new HashMap<>();
        for (FrameDefinition.FrameFieldDefinition fieldDefinition : definition.fieldDefinitions) {
            Field field = fieldDefinition.field;
            try {
                if (fieldDefinition.frameFieldLoop != null) {
                    long loopNum = getLoopNum(fieldDefinition.frameFieldLoop, context);
                    Class<?> c = fieldDefinition.listClass;
                    List<Object> list = new ArrayList<>();
                    Codec<?> listClassCodec = fieldDefinition.listClassCodec;
                    if (listClassCodec != null) {
                        for (int l = 0; l < loopNum; l++) {
                            Object o = listClassCodec.decode(byteBuf);
                            list.add(o);
                        }
                    } else {
                        for (int l = 0; l < loopNum; l++) {
                            Object o = c.getDeclaredConstructor().newInstance();
                            decode(c, o, byteBuf);
                            list.add(o);
                        }
                    }
                    field.set(frameData, list);
                } else if (fieldDefinition.frameField != null) {
                    Object v = fieldDefinition.codec.decode(byteBuf);
                    field.set(frameData, v);
                    if (fieldDefinition.frameField.intoContext()) {
                        context.put(field.getName(), v);
                    }
                } else if (fieldDefinition.frameFieldDynamics != null) {
                    int len = byteBuf.readableBytes();
                    FrameFieldDynamics dynamics = fieldDefinition.frameFieldDynamics;
                    if (!dynamics.isLast()) {
                        len = ((Number) context.get(dynamics.lenByField())).intValue();
                    }
                    byte[] bytes = new byte[(int) len];
                    byteBuf.readBytes(bytes);
                    field.set(frameData, Unpooled.wrappedBuffer(bytes));
                }
            } catch (Exception e) {
                throw new DecodeException("frame:" + clz.getName() + "field: " + field.getName() + " encode failed", e);
            }

        }
    }

    private static long getLoopNum(FrameFieldLoop frameLoop, Map<String, Object> context) {
        long loopCount = frameLoop.loopCount();
        if (loopCount == -1) {
            Object n = context.get(frameLoop.loopByField());
            if (n == null) {
                throw new IllegalArgumentException("FrameLoop loopRelyField type can not be find");
            }
            if (!(n instanceof Number)) {
                throw new IllegalArgumentException("FrameLoop loopRelyField type must be Number");
            }
            loopCount = (Long) n;
        }
        return loopCount;
    }

    private static FrameDefinition getFrameDefinition(Class<?> clz) {
        return frameDefinitionMap.computeIfAbsent(clz, c -> {
            try {
                Frame frame = c.getDeclaredAnnotation(Frame.class);
                if (frame == null) {
                    throw new IllegalArgumentException(c.getName() + " miss @interface Frame");
                }

                List<Class<?>> allClass = new ArrayList<>(2);
                allClass.add(c);

                // search super frame
                Class<?> superclass = c.getSuperclass();
                while (superclass != null) {
                    Frame annotation = superclass.getDeclaredAnnotation(Frame.class);
                    if (annotation != null) {
                        allClass.add(superclass);
                        superclass = superclass.getSuperclass();
                        continue;
                    }
                    break;
                }
                // reverse list, super class priority
                if (allClass.size() > 1) {
                    Collections.reverse(allClass);
                }
                List<Field> fields = new ArrayList<>();
                for (Class<?> item : allClass) {
                    Field[] fs = item.getDeclaredFields();
                    Collections.addAll(fields, fs);
                }

                List<FrameDefinition.FrameFieldDefinition> list = new ArrayList<>();
                for (Field field : fields) {
                    field.setAccessible(true);
                    FrameDefinition.FrameFieldDefinition frameFieldDefinition = new FrameDefinition.FrameFieldDefinition();
                    frameFieldDefinition.field = field;
                    frameFieldDefinition.frameField = field.getAnnotation(FrameField.class);
                    frameFieldDefinition.frameFieldLoop = field.getAnnotation(FrameFieldLoop.class);
                    frameFieldDefinition.frameFieldDynamics = field.getAnnotation(FrameFieldDynamics.class);
                    if (frameFieldDefinition.frameFieldLoop != null) {
                        FrameFieldLoop fieldLoop = frameFieldDefinition.frameFieldLoop;
                        if (field.getType() != List.class) {
                            throw new IllegalArgumentException("@FrameFieldLoop decorate Field must be List");
                        }
                        ParameterizedType pt = (ParameterizedType) field.getGenericType();
                        Type[] types = pt.getActualTypeArguments();
                        Type type = types[0];
                        Class<?> listClass = Class.forName(type.getTypeName());
                        // if list class type have @Frame, use Frame, else use @FrameLoop.@FrameField
                        if (listClass.getDeclaredAnnotation(Frame.class) != null) {
                            frameFieldDefinition.listClass = listClass;
                        } else {
                            if (fieldLoop.frameField() != null) {
                                FrameField frameField = fieldLoop.frameField();
                                ByteOrder order = frameField.byteOrder();
                                if (order == ByteOrder.NULL) {
                                    order = frame.byteOrder();
                                }
                                getCodecByClass(listClass, order, frameField);
                                frameFieldDefinition.listClassCodec = getCodecByClass(listClass, order, frameField);
                                frameFieldDefinition.listClass = listClass;
                            } else {
                                throw new IllegalArgumentException("@FrameFieldLoop Field List class codec can not find");
                            }
                        }
                    } else if (frameFieldDefinition.frameFieldDynamics != null) {
                        if (field.getType() != ByteBuf.class) {
                            throw new IllegalArgumentException("@FrameFieldDynamics decorate Field must be ByteBuf");
                        }
                        FrameFieldDynamics dynamicsField = frameFieldDefinition.frameFieldDynamics;
                        if (!dynamicsField.isLast() && dynamicsField.lenByField().equals("")) {
                            throw new IllegalArgumentException("@FrameFieldDynamics lenByField can not be empty");
                        }
                    } else if (frameFieldDefinition.frameField != null) {
                        if (field.getType() != Codec.class) {
                            throw new IllegalArgumentException("@FrameField decorate Field must be Codec<?>");
                        }
                        frameFieldDefinition.codec = getCodecByFrameField(frame.byteOrder(), frameFieldDefinition);
                    }
                    list.add(frameFieldDefinition);
                }

                return new FrameDefinition(c.getDeclaredConstructor(), frame, list);
            } catch (Exception e) {
                throw new IotException(e);
            }
        });
    }

    private static Codec<?> getCodecByFrameField(ByteOrder superOrder, FrameDefinition.FrameFieldDefinition fieldDefinition) {
        FrameField frameField = fieldDefinition.frameField;
        Field field = fieldDefinition.field;
        ByteOrder order = (frameField.byteOrder() == ByteOrder.NULL ? superOrder : frameField.byteOrder());
        if (order == ByteOrder.NULL) {
            throw new IllegalArgumentException("invalid byteOrder; ByteOrder can not be NULL");
        }
        Class<? extends Codec<?>> codecType = (frameField.type() != VoidCodec.class ? frameField.type() : codecTypeMap.get(field.getType()));
        if (codecType == null || codecType == VoidCodec.class) {
            throw new IllegalArgumentException(field.getName() + " can not find any codec");
        }
        return getCodecByClass(codecType, order, frameField);
    }

    private static Codec<?> getCodecByClass(Class<?> clz, ByteOrder order, FrameField frameField) {
        Class<? extends Codec<?>> codecType = (frameField.type() != VoidCodec.class ? frameField.type() : codecTypeMap.get(clz));
        if (codecType == null || codecType == VoidCodec.class) {
            throw new IllegalArgumentException(clz.getName() + " can not find any codec");
        }
        java.nio.ByteOrder byteOrder = (order == ByteOrder.BIG_ENDIAN ? java.nio.ByteOrder.BIG_ENDIAN : java.nio.ByteOrder.LITTLE_ENDIAN);
        String codecKey = codecKey(clz.getName(), byteOrder, frameField);
        return codecMap.computeIfAbsent(codecKey, k -> {
            try {
                if (codecType == BCDNumberCodec.class || codecType == NumberUnitCodec.class) {
                    Constructor<? extends Codec<?>> constructor = codecType.getConstructor(Integer.class, java.nio.ByteOrder.class, Integer.class, Integer.class, Boolean.class);
                    return constructor.newInstance(frameField.len(), byteOrder, frameField.unit(), frameField.offset(), frameField.offsetReverse());
                } else if (codecType == BCDTimeCodec.class || codecType == CP56time2aCodec.class) {
                    Constructor<? extends Codec<?>> constructor = codecType.getConstructor(java.nio.ByteOrder.class);
                    return constructor.newInstance(byteOrder);
                } else {
                    Constructor<? extends Codec<?>> constructor = codecType.getConstructor(Integer.class, java.nio.ByteOrder.class);
                    return constructor.newInstance(frameField.len(), byteOrder);
                }
            } catch (Exception e) {
                throw new IotException(e);
            }
        });
    }

    private static String codecKey(String codecTypeName, java.nio.ByteOrder byteOrder, FrameField frameField) {
        return codecTypeName + "_" +
                frameField.len() + "_" +
                byteOrder + "_" +
                frameField.unit() + "_" +
                frameField.offset() + "_" +
                (frameField.offsetReverse() ? 1 : 0);
    }

}
