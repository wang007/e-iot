package io.github.eiot;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * created by wang007 on 2025/4/10
 */
class CommandDefImpl<Req> implements CommandDef<Req> {

    /**
     * protocol -> <command, commandDef>
     */
    static final Map<String, Map<String, CommandDefImpl<?>>> map = new ConcurrentHashMap<>();

    public final String command;
    public final String alias;
    public final Class<Req> dataType;
    public final CommandDef<?> responseType;


    @SuppressWarnings("unchecked")
    public static <Req> CommandDef<Req> match(String protocol, String command) {
        Map<String, CommandDefImpl<?>> typeMap = map.computeIfAbsent(protocol, k -> new ConcurrentHashMap<>());
        return (CommandDef<Req>) typeMap.get(command);
    }

    public static <Req> CommandDef<Req> create(String command, Class<Req> dataType, CommandDef<?> responseType) {
        return new CommandDefImpl<>(command, dataType, responseType);
    }

    public static <Req> CommandDef<Req> createAndSave(String command, Class<Req> dataType, CommandDef<?> responseType, String protocol) {
        CommandDefImpl<Req> type = new CommandDefImpl<>(command, dataType, responseType);
        Map<String, CommandDefImpl<?>> typeMap = map.computeIfAbsent(protocol, k -> new ConcurrentHashMap<>());
        typeMap.put(command, type);
        return type;
    }

    public static <Req> CommandDef<Req> create(String command, Class<Req> dataType, String alias, CommandDef<?> responseType) {
        return new CommandDefImpl<>(command, dataType, alias, responseType);
    }

    public static <Req> CommandDef<Req> createAndSave(String command, Class<Req> dataType, String alias, CommandDef<?> responseType, String protocol) {
        CommandDefImpl<Req> type = new CommandDefImpl<>(command, dataType, alias, responseType);
        Map<String, CommandDefImpl<?>> typeMap = map.computeIfAbsent(protocol, k -> new ConcurrentHashMap<>());
        typeMap.put(command, type);
        return type;
    }

    CommandDefImpl(String command, Class<Req> dataType, CommandDef<?> responseType) {
        this(command, dataType, dataType.getSimpleName(), responseType);
    }

    CommandDefImpl(String command, Class<Req> dataType, String alias, CommandDef<?> responseType) {
        this.command = command;
        this.alias = alias;
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
    public CommandDef<?> responseType() {
        return responseType;
    }
}
