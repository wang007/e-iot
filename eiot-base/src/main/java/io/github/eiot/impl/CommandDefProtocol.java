package io.github.eiot.impl;

import io.github.eiot.CommandDef;
import io.github.eiot.RequestCommandDef;

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

    public <Req> CommandDef<Req> createAndRegister(String command, Class<Req> dataType) {
        return createAndRegister(command, dataType, dataType.getName());
    }

    public <Req> CommandDef<Req> createAndRegister(String command, Class<Req> dataType, String alias) {
        CommandDef<Req> c = new CommandDefImpl<>(command, dataType, alias, null);
        register(c);
        return c;
    }

    public <Req, Resp> RequestCommandDef<Req, Resp> createAndRegister(String command, Class<Req> dataType, CommandDef<Resp> response) {
        return createAndRegister(command, dataType, dataType.getName(), response);
    }

    public <Req, Resp> RequestCommandDef<Req, Resp> createAndRegister(String command, Class<Req> dataType, String alias,
                                                                      CommandDef<Resp> response) {
        CommandDefImpl<Req, Resp> c = new CommandDefImpl<>(command, dataType, alias, response);
        register(c);
        return c;
    }

}
