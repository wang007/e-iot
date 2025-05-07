package io.github.eiot.route;

import io.github.eiot.CommandDef;

/**
 * created by wang007 on 2025/5/7
 */
public interface CommandDefHandler<T> extends CommandHandler<T> {

    /**
     * like {@link #command()}
     *
     * @return the commandDef
     */
    CommandDef<T> commandDef();

    @Override
    default String command() {
        return commandDef().command();
    }
}
