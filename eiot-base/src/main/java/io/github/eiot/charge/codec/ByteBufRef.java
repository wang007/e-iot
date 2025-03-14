package io.github.eiot.charge.codec;

import io.netty.buffer.ByteBuf;

/**
 * The original byteBuf is not affected when used
 * <p>
 * created by wang007 on 2025/2/26
 */
public class ByteBufRef {

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
