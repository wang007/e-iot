package com.github.eiot.test.example;

import io.github.eiot.impl.CommandDefProtocol;
import io.github.eiot.impl.CommandDefProtocolProvider;

/**
 * created by wang007 on 2025/5/25
 */
public class ExampleCommandDefProtocolProvider implements CommandDefProtocolProvider {
    @Override
    public CommandDefProtocol get() {
        return ExampleCommand.COMMAND_PROTOCOL;
    }
}
