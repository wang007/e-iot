package io.github.eiot;


import io.github.eiot.impl.CommandDefProtocols;

/**
 * command definition
 * <p>
 * created by wang007 on 2025/2/20
 */
public interface CommandDef<Req> {

    static CommandDef<?> match(String protocol, String command) {
        return CommandDefProtocols.match(protocol, command);
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
