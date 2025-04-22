package io.github.eiot.ocpp.schema.v2_0_1;

import io.github.eiot.impl.CommandDefProtocol;
import io.github.eiot.impl.CommandDefProtocolProvider;

/**
 * created by wang007 on 2025/5/18
 */
public class Ocpp2_0_1CommandDefProtocolProvider implements CommandDefProtocolProvider {

    @Override
    public CommandDefProtocol get() {
        return Ocpp2_0_1Command.COMMAND_PROTOCOL;
    }
}
