package io.github.eiot;

/**
 * created by wang007 on 2025/2/20
 */
public interface MessageType<Req> {


    static <Req> MessageType<Req> createAndSave(String messageType, Class<Req> dataType, MessageType<?> responseType, String protocol) {
        return MessageTypeImpl.createAndSave(messageType, dataType, responseType, protocol);
    }

    static <Req> MessageType<Req> match(String protocol, String messageType) {
        return MessageTypeImpl.match(protocol, messageType);
    }

    /**
     * @return message type
     */
    String messageType();

    /**
     * For example, 68 stands for login message type, and alias stands for login
     *
     * @return alias
     */
    String alias();

    /**
     * @return data type
     */
    Class<Req> dataType();

    /**
     * @return If no response frame exists, return null.
     */
    MessageType<?> responseType();
}
