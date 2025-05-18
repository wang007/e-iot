package io.github.eiot.impl;

import io.github.eiot.CommandDef;

import java.util.HashMap;
import java.util.Map;

/**
 * command def protocol
 * <p>
 * created by wang007 on 2025/5/17
 */
public class CommandDefProtocol {

    private final String protocol;
    public final Map<String, CommandDef<?>> map;

    public CommandDefProtocol(String protocol) {
        this.protocol = protocol;
        this.map = new HashMap<>();
    }

    public CommandDefProtocol(String protocol, Map<String, CommandDef<?>> map) {
        this.protocol = protocol;
        this.map = map;
    }

    public String protocol() {
        return protocol;
    }

    public void register(CommandDef<?> commandDef) {
        this.map.put(commandDef.command(), commandDef);
    }

    public CommandDef<?> match(String command) {
        return this.map.get(command);
    }

    public <Req> CommandDef<Req> createAndRegister(String command, Class<Req> dataType, CommandDef<?> responseType) {
        return createAndRegister(command, dataType, null, responseType);
    }

    public <Req> CommandDef<Req> createAndRegister(String command, Class<Req> dataType, String alias, CommandDef<?> responseType) {
        CommandDef<Req> c = new CommandDefImpl<>(command, dataType, alias, responseType);
        register(c);
        return c;
    }

}
