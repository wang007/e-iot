package io.github.eiot.ocpp.schema.v2_1;

import io.github.eiot.impl.CommandDefProtocol;
import io.github.eiot.ocpp.impl.OcppCommandDefProtocolProvider;

import java.util.function.Supplier;

/**
 * created by wang007 on 2025/5/18
 */
public class Ocpp2_1CommandDefProtocolProvider implements OcppCommandDefProtocolProvider {

    @Override
    public CommandDefProtocol get() {
        return Ocpp2_1Command.COMMAND_PROTOCOL;
    }
}
