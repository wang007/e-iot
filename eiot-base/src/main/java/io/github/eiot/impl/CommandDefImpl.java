package io.github.eiot.impl;

import io.github.eiot.CommandDef;
import io.github.eiot.RequestCommandDef;


/**
 * created by wang007 on 2025/4/10
 */
public class CommandDefImpl<Req, Resp> implements RequestCommandDef<Req, Resp> {

    public final String command;
    public final String alias;
    public final Class<Req> dataType;
    public final CommandDef<Resp> responseType;

    CommandDefImpl(String command, Class<Req> dataType, CommandDef<Resp> responseType) {
        this(command, dataType, null, responseType);
    }

    CommandDefImpl(String command, Class<Req> dataType, String alias, CommandDef<Resp> responseType) {
        this.command = command;
        this.alias = alias == null ? dataType.getSimpleName() : alias;
        this.dataType = dataType;
        this.responseType = responseType;
    }

    @Override
    public String command() {
        return command;
    }

    @Override
    public String alias() {
        return alias;
    }

    @Override
    public Class<Req> dataType() {
        return dataType;
    }

    @Override
    public CommandDef<Resp> responseType() {
        return responseType;
    }
}
