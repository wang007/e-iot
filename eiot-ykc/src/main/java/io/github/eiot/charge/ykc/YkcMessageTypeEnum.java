package io.github.eiot.charge.ykc;

import io.github.eiot.charge.MessageTypeEnum;

/**
 *
 *
 * created by wang007 on 2025/3/17
 */
public enum YkcMessageTypeEnum implements MessageTypeEnum {


    ;

    public final String messageType;
    public final String alias;
    public final Class<?> dataType;
    public final YkcMessageTypeEnum messageTypeEnum;

    YkcMessageTypeEnum(String messageType, Class<?> dataType, YkcMessageTypeEnum messageTypeEnum) {
        this.messageType = messageType;
        this.alias = this.name();
        this.dataType = dataType;
        this.messageTypeEnum = messageTypeEnum;
    }

    @Override
    public String messageType() {
        return messageType;
    }

    @Override
    public String alias() {
        return alias;
    }

    @Override
    public Class<?> dataType() {
        return dataType;
    }

    @Override
    public MessageTypeEnum responseType() {
        return messageTypeEnum;
    }
}
