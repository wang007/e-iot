package io.github.eiot;

import io.github.eiot.impl.CommandDefImpl;

/**
 * command define
 *
 * created by wang007 on 2025/2/20
 */
public interface CommandDef<Req> {

    static <Req> CommandDef<Req> createAndSave(String command, Class<Req> dataType, CommandDef<?> responseType, String protocol) {
        return CommandDefImpl.createAndSave(command, dataType, responseType, protocol);
    }

    static <Req> CommandDef<Req> match(String protocol, String messageType) {
        return CommandDefImpl.match(protocol, messageType);
    }

    /**
     * @return command
     */
    String command();

    /**
     * For example, 68 stands for login command, and alias stands for login
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
    CommandDef<?> responseType();
}
