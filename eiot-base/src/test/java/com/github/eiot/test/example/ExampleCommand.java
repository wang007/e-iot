package com.github.eiot.test.example;

import io.github.eiot.CommandDef;

/**
 * created by wang007 on 2025/4/12
 */
public class ExampleCommand {


    public static CommandDef<?> match(String command) {
        return CommandDef.match("example", command);
    }

}
