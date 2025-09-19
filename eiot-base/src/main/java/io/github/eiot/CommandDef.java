package io.github.eiot;



/**
 * command definition
 * <p>
 * created by wang007 on 2025/2/20
 */
public interface CommandDef<Req> {

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
}
