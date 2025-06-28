package io.github.eiot.test.example;

import io.github.eiot.CommandDef;
import io.github.eiot.impl.CommandDefProtocol;
import io.github.eiot.test.example.data.*;

/**
 * created by wang007 on 2025/4/12
 */
public interface ExampleCommand {

    CommandDefProtocol COMMAND_PROTOCOL = new CommandDefProtocol("example");

    CommandDef<ExampleHeartbeatResponse> HeartbeatResponse = COMMAND_PROTOCOL.createAndRegister("01", ExampleHeartbeatResponse.class, null);
    CommandDef<ExampleHeartbeatRequest> HeartbeatRequest = COMMAND_PROTOCOL.createAndRegister("02", ExampleHeartbeatRequest.class, HeartbeatResponse);

    CommandDef<ExampleLoginResponse> LoginResponse = COMMAND_PROTOCOL.createAndRegister("03", ExampleLoginResponse.class, null);
    CommandDef<ExampleLoginRequest> LoginRequest = COMMAND_PROTOCOL.createAndRegister("04", ExampleLoginRequest.class, LoginResponse);

    CommandDef<AllFieldTypeTest> Test = COMMAND_PROTOCOL.createAndRegister("05", AllFieldTypeTest.class, null);
}
