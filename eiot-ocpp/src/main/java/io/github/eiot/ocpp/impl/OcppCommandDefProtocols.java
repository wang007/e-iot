package io.github.eiot.ocpp.impl;

import io.github.eiot.CommandDef;
import io.github.eiot.impl.CommandDefProtocol;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * created by wang007 on 2025/5/18
 */
public class OcppCommandDefProtocols {

    private static final Map<String, CommandDefProtocol> Protocols;

    static {
        Map<String, CommandDefProtocol> map = new HashMap<>();
        ServiceLoader.load(OcppCommandDefProtocolProvider.class)
                .forEach(p -> {
                    CommandDefProtocol commandProtocol = p.get();
                    String protocol = commandProtocol.protocol();
                    map.put(protocol, commandProtocol);
                });
        Protocols = map;
    }

    public static CommandDef<?> match(String protocol, String command) {
        CommandDefProtocol p = Protocols.get(protocol);
        if (p == null) {
            return null;
        }
        return p.match(command);
    }
}
