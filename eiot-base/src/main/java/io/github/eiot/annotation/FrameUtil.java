package io.github.eiot.annotation;

import io.github.eiot.exception.IotException;
import io.github.eiot.codec.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * created by wang007 on 2025/3/17
 */
public class FrameUtil {

    static final BaseTypeCodecCache BASE_TYPE_CODEC_CACHE = new BaseTypeCodecCache();

    private static final Map<Class<?>, FrameDefinitionCodec> FRAME_DEFINITION_CODECS = new ConcurrentHashMap<>();

    /**
     * new frame data instance. class must be annotation {@link Frame}
     *
     * @return the new instance.
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstance(Class<T> clz) {
        FrameDefinitionCodec fdCodec = parseFrameDefinitionAndCache(clz);
        if (fdCodec == null) {
            throw new IotException("class: " + clz.getName() + " newInstance failed, not found FrameDefinitionCodec");
        }
        try {
            return (T) fdCodec.frameDefinition().constructor.newInstance();
        } catch (Exception e) {
            throw new IotException("class: " + clz.getName() + " newInstance failed", e);
        }
    }

    /**
     * encode frameData to byteBuf
     *
     * @param clz       the frameData of class
     * @param frameData the data
     */
    public static ByteBuf encode(Class<?> clz, Object frameData) {
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
    public static void encode(ByteBuf buffer, Class<?> clz, Object frameData) {
        FrameDefinitionCodec fdCodec = parseFrameDefinitionAndCache(clz);
        if (fdCodec == null) {
            throw new IotException("class: " + clz.getName() + " can not find frameDefinition codec");
        }
        CodecContext context = fdCodec.useContext();
        fdCodec.encode(buffer, frameData, context);
    }

    /**
     * decode frameData from byteBuf
     *
     * @param clz     the frameData of class
     * @param byteBuf decode from byteBuf
     */
    @SuppressWarnings("unchecked")
    public static <T> T decode(Class<?> clz, ByteBuf byteBuf) {
        FrameDefinitionCodec fdCodec = parseFrameDefinitionAndCache(clz);
        if (fdCodec == null) {
            throw new IotException("class: " + clz.getName() + " can not find frameDefinition codec");
        }
        CodecContext context = fdCodec.useContext();
        return (T) fdCodec.decode(byteBuf, context);
    }


    /**
     * @param clz class annotated by
     * @return
     */
    private static FrameDefinitionCodec parseFrameDefinitionAndCache(Class<?> clz) {
        Function<Class<?>, FrameDefinitionCodec> f = c -> {
            {
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

                    ByteOrder frameByteOrder = frame.byteOrder();
                    if (frameByteOrder == ByteOrder.NULL) {
                        throw new IllegalArgumentException("class: " + c.getName() + " @Frame byteOrder not allow ByteOrder.NULL");
                    }
                    boolean useContext = frame.withContext();
                    List<FrameDefinition.FrameFieldDefinition> list = new ArrayList<>();
                    for (Field field : fields) {
                        field.setAccessible(true);
                        FrameDefinition.FrameFieldDefinition ffd = new FrameDefinition.FrameFieldDefinition();
                        ffd.field = field;
                        ffd.frameField = field.getAnnotation(FrameField.class);
                        ffd.frameFieldLoop = field.getAnnotation(FrameFieldLoop.class);
                        ffd.frameFieldDynamics = field.getAnnotation(FrameFieldDynamics.class);

                        // no frame field, only java field
                        if (ffd.frameField == null && ffd.frameFieldLoop == null && ffd.frameFieldDynamics == null) {
                            continue;
                        }

                        if (ffd.frameFieldLoop != null) {
                            FrameFieldLoop fieldLoop = ffd.frameFieldLoop;
                            if (field.getType() != List.class) {
                                throw new IllegalArgumentException("@FrameFieldLoop decorate Field must be List");
                            }
                            ParameterizedType pt = (ParameterizedType) field.getGenericType();
                            Type[] types = pt.getActualTypeArguments();
                            Type type = types[0];
                            Class<?> innerType = Class.forName(type.getTypeName());
                            // if list class type have @Frame, use Frame, else use @FrameLoop.@FrameField
                            if (innerType.getDeclaredAnnotation(Frame.class) != null) {
                                //FrameDefinition definition = parseFrameDefinitionAndCache(innerType);
                                FrameDefinitionCodec codec = parseFrameDefinitionAndCache(innerType);
                                ffd.codec = new ListCodec<>(fieldLoop.loopCount(), java.nio.ByteOrder.LITTLE_ENDIAN, fieldLoop.loopByField(), codec);
                            } else {
                                if (fieldLoop.frameField() != null) {
                                    FrameField frameField = fieldLoop.frameField();
                                    Codec<?> codec = BASE_TYPE_CODEC_CACHE.generateBaseCodec(innerType, field, frameByteOrder, frameField);
                                    ffd.codec = new ListCodec<>(fieldLoop.loopCount(), java.nio.ByteOrder.LITTLE_ENDIAN, fieldLoop.loopByField(), codec);
                                } else {
                                    throw new IllegalArgumentException("@FrameFieldLoop Field List class codec can not find");
                                }
                            }
                        } else if (ffd.frameFieldDynamics != null) {
                            if (field.getType() != ByteBufRef.class) {
                                throw new IllegalArgumentException("@FrameFieldDynamics decorate Field must be ByteBufRef");
                            }
                            FrameFieldDynamics dynamicsField = ffd.frameFieldDynamics;
                            if (!dynamicsField.isLast() && dynamicsField.lenByField().equals("")) {
                                throw new IllegalArgumentException("@FrameFieldDynamics lenByField can not be empty");
                            }
                        } else {
                            Class<?> type = field.getType();
                            if (ffd.frameField.intoContext() && !useContext) {
                                throw new IllegalStateException("@FrameField intoContext() must be @Frame withContext() return true. current false.");
                            }
                            ffd.codec = BASE_TYPE_CODEC_CACHE.generateBaseCodec(type, field, frameByteOrder, ffd.frameField);
                        }
                        list.add(ffd);
                    }
                    FrameDefinition fd = new FrameDefinition(c, c.getDeclaredConstructor(), frame, list);
                    return new FrameDefinitionCodec(fd);
                } catch (Exception e) {
                    throw new IotException(e);
                }
            }
        };

        return FRAME_DEFINITION_CODECS.computeIfAbsent(clz, f);
    }

}
