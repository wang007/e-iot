package io.github.eiot.annotation;

import io.github.eiot.exception.DecodeException;
import io.github.eiot.exception.EncodeException;
import io.github.eiot.codec.ByteBufRef;
import io.github.eiot.codec.Codec;
import io.github.eiot.codec.CodecContext;
import io.github.eiot.codec.DefaultCodecContext;
import io.netty.buffer.ByteBuf;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Generated Codec by @{@link Frame}
 * <p>
 * created by wang007 on 2025/4/15
 */
class FrameDefinitionCodec implements Codec<Object> {

    private final FrameDefinition frameDefinition;

    public FrameDefinitionCodec(FrameDefinition frameDefinition) {
        this.frameDefinition = frameDefinition;
    }

    @Override
    public Object decode(ByteBuf byteBuf, CodecContext context) {
        Object instance;
        try {
            instance = frameDefinition.constructor.newInstance();
        } catch (Exception e) {
            throw new DecodeException("class: " + frameDefinition.frameDateClz.getName() + " newInstance failed", e);
        }

        for (FrameDefinition.FrameFieldDefinition ffd : frameDefinition.fieldDefinitions) {
            Field field = ffd.field;
            try {
                if (ffd.frameField != null) {
                    Object v = ffd.codec.decode(byteBuf, context);
                    field.set(instance, v);
                } else if (ffd.frameFieldLoop != null) {
                    int loopNum = getLoopNum(ffd.frameFieldLoop, context);
                    List<Object> list = new ArrayList<>();
                    for (int l = 0; l < loopNum; l++) {
                        Object o = ffd.codec.decode(byteBuf, context);
                        list.add(o);
                    }
                    field.set(instance, list);
                } else {
                    int len = byteBuf.readableBytes();
                    FrameFieldDynamics dynamics = ffd.frameFieldDynamics;
                    if (!dynamics.isLast()) {
                        len = context.get(dynamics.lenByField());
                    }

                    ByteBufRef byteBufRef = ByteBufRef.from(byteBuf.readSlice(len));
                    field.set(instance, byteBufRef);
                }
            } catch (Exception e) {
                throw new DecodeException("class: " + frameDefinition.frameDateClz.getName() + " " + ffd.field.getName() + " codec failed", e);
            }
        }

        return instance;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void encode(ByteBuf byteBuf, Object data, CodecContext context) {
        for (FrameDefinition.FrameFieldDefinition ffd : frameDefinition.fieldDefinitions) {
            try {
                Field field = ffd.field;
                if (ffd.frameField != null) {
                    Object v = field.get(data);
                    ffd.codec.encode(byteBuf, v, context);
                } else if (ffd.frameFieldLoop != null) {
                    int loopNum = getLoopNum(ffd.frameFieldLoop, context);
                    List<?> list = (List<?>) field.get(data);
                    if (list.size() != loopNum) {
                        throw new IllegalArgumentException(field.getName() + " list size not equals " + loopNum);
                    }
                    for (int i = 0; i < loopNum; i++) {
                        ffd.codec.encode(byteBuf, list.get(i), context);
                    }
                } else {
                    FrameFieldDynamics fieldDynamics = ffd.frameFieldDynamics;
                    ByteBuf v = ((ByteBufRef) field.get(data)).byteBuf();
                    // check
                    if (!fieldDynamics.isLast()) {
                        Number len = context.get(fieldDynamics.lenByField());
                        if (len.intValue() != v.readableBytes()) {
                            throw new IllegalArgumentException(field.getName() + " len not equals " + len);
                        }
                    }
                    byteBuf.writeBytes(v);
                }
            } catch (Exception e) {
                throw new EncodeException("class: " + frameDefinition.frameDateClz.getName() + " " + ffd.field.getName() + " encode failed", e);
            }
        }
    }

    private int getLoopNum(FrameFieldLoop frameLoop, CodecContext context) {
        int loopCount = frameLoop.loopCount();
        if (loopCount == -1) {
            Object n = context.get(frameLoop.loopByField());
            if (n == null) {
                throw new IllegalArgumentException("FrameLoop loopRelyField type can not be find");
            }
            if (!(n instanceof Number)) {
                throw new IllegalArgumentException("FrameLoop loopRelyField type must be Number");
            }
            loopCount = ((Number) n).intValue();
        }
        return loopCount;
    }

    @Override
    public int getLength() {
        return -1;
    }

    public FrameDefinition frameDefinition() {
        return this.frameDefinition;
    }

    public CodecContext useContext() {
        boolean withContext = frameDefinition.frame.withContext();
        return withContext ? new DefaultCodecContext() : CodecContext.EMPTY;
    }
}
