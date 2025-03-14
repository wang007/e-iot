package io.github.eiot.charge;

/**
 *
 *
 * created by wang007 on 2025/2/20
 */
public interface MessageTypeEnum {

    /**
     *
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
     *
     * @return
     */
    Class<?> dataType();

    /**
     * @return If no response frame exists, return null.
     */
    MessageTypeEnum responseType();

}
