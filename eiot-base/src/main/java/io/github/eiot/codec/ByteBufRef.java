package io.github.eiot.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * The original byteBuf is not affected when used
 * <p>
 * created by wang007 on 2025/2/26
 */
public class ByteBufRef {

    public final static ByteBufRef EMPTY = ByteBufRef.from(Unpooled.EMPTY_BUFFER);

    public static ByteBufRef from(ByteBuf byteBuf) {
        return new ByteBufRef(byteBuf);
    }

    private final ByteBuf byteBuf;

    ByteBufRef(ByteBuf byteBuf) {
        this.byteBuf = byteBuf;
    }

    public ByteBuf byteBuf() {
        return byteBuf.slice();
    }
}
