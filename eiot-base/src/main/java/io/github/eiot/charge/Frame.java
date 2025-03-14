package io.github.eiot.charge;

import io.netty.buffer.ByteBuf;
import io.vertx.core.Future;

/**
 * {@link Frame} represents a data structure in the interaction process,
 * and a frame is a complete data. A frame usually contains frame type, data length, data, checksum, and so on.
 * <p>
 * A {@link Frame} can be {@link #write()} and then received by the peer end.
 * <p>
 * {@link #isRaw()} used for the date field has not been further parsed and
 * If true, it indicates whether the date field is byte[]
 * If false, it indicates that the date field is parsed into a specific type
 * <p>
 * created by wang007 on 2025/2/20
 */
public interface Frame<T> extends AttributeHolder {

    /**
     * @return message type
     */
    String messageType();

    /**
     * @return return null if {@link #messageType()} not match {@link MessageTypeEnum}
     */
    //MessageTypeEnum messageTypeEnum();

    /**
     * terminalNo corresponds to a unique number for each connection
     *
     * @return terminalNo
     */
    String terminalNo();

    /**
     * @return frame body
     */
    T data();

    Frame<T> data(T t);

    /**
     * @return frame bytes size
     */
    int rawDataSize();

    /**
     * @return side
     */
    Side side();

    /**
     * Usually frames have checksum fields. When a frame is received, the checksum is calculated again to determine
     * whether it is equal
     *
     * @return check code result
     */
    boolean checkCodeResult();

    /**
     * @return a future completed with the write operation result
     */
    Future<Void> write();

    /**
     * @return the {@link ChargeConnection} associated with this frame
     */
    ChargeConnection chargeConnection();

    /**
     * Converts the current frame to byte buf
     *
     * @return byteBuf
     */
    ByteBuf toByteBuf();

    /**
     * Create an instance of the data type corresponding to this frame
     *
     * @return data
     */
    T newDate();

    /**
     * used for the date field has not been further parsed
     *
     * @return true has not parsed
     */
    boolean isRaw();
}
