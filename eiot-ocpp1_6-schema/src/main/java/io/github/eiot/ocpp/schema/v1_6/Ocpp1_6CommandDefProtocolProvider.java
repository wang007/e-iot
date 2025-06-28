package io.github.eiot.ocpp.schema.v1_6;

import io.github.eiot.impl.CommandDefProtocol;
import io.github.eiot.ocpp.impl.OcppCommandDefProtocolProvider;

import java.util.function.Supplier;

/**
 * created by wang007 on 2025/5/18
 */
public class Ocpp1_6CommandDefProtocolProvider implements OcppCommandDefProtocolProvider {
    @Override
    public CommandDefProtocol get() {
        return Ocpp1_6Command.COMMAND_PROTOCOL;
    }
}
