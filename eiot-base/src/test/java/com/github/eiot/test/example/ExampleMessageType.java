package com.github.eiot.test.example;

import io.github.eiot.MessageType;

/**
 * created by wang007 on 2025/4/12
 */
public class ExampleMessageType {


    public static MessageType<?> match(String messageType) {
        return MessageType.match("example", messageType);
    }

}
