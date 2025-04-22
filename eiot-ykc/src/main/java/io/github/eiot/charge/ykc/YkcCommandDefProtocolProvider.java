package io.github.eiot.charge.ykc;

import io.github.eiot.impl.CommandDefProtocol;
import io.github.eiot.impl.CommandDefProtocolProvider;

/**
 * created by wang007 on 2025/5/18
 */
public class YkcCommandDefProtocolProvider implements CommandDefProtocolProvider {

    @Override
    public CommandDefProtocol get() {
        return YkcCommand.COMMAND_PROTOCOL;
    }
}
