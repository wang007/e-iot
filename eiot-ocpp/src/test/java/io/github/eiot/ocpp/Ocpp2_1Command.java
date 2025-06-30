package io.github.eiot.ocpp;

import io.github.eiot.CommandDef;
import io.github.eiot.impl.CommandDefProtocol;
import io.github.eiot.ocpp.schema.BootNotificationRequest;
import io.github.eiot.ocpp.schema.BootNotificationResponse;

// generated
public interface Ocpp2_1Command {

    CommandDefProtocol COMMAND_PROTOCOL = new CommandDefProtocol("ocpp2.1");

    CommandDef<BootNotificationResponse> BootNotificationResponse = COMMAND_PROTOCOL.createAndRegister("BootNotificationResponse", io.github.eiot.ocpp.schema.BootNotificationResponse.class, null);
    CommandDef<BootNotificationRequest> BootNotificationRequest = COMMAND_PROTOCOL.createAndRegister("BootNotification", io.github.eiot.ocpp.schema.BootNotificationRequest.class, BootNotificationResponse);

    static CommandDef<?> match(String command) {
        return COMMAND_PROTOCOL.match(command);
    }
}