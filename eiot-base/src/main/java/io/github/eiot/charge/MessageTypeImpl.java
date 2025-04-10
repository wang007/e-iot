package io.github.eiot.charge;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * created by wang007 on 2025/4/10
 */
class MessageTypeImpl<Req> implements MessageType<Req> {

    /**
     * protocol -> <messageTypeKey, MessageType>
     */
    static final Map<String, Map<String, MessageTypeImpl<?>>> map = new ConcurrentHashMap<>();

    public final String messageType;
    public final String alias;
    public final Class<Req> dataType;
    public final MessageType<?> responseType;


    @SuppressWarnings("unchecked")
    public static <Req> MessageType<Req> match(String protocol, String messageType) {
        Map<String, MessageTypeImpl<?>> typeMap = map.computeIfAbsent(protocol, k -> new ConcurrentHashMap<>());
        return (MessageType<Req>) typeMap.get(messageType);
    }

    public static <Req> MessageType<Req> create(String messageType, Class<Req> dataType, MessageType<?> responseType) {
        return new MessageTypeImpl<>(messageType, dataType, responseType);
    }

    public static <Req> MessageType<Req> createAndSave(String messageType, Class<Req> dataType, MessageType<?> responseType, String protocol) {
        MessageTypeImpl<Req> type = new MessageTypeImpl<>(messageType, dataType, responseType);
        Map<String, MessageTypeImpl<?>> typeMap = map.computeIfAbsent(protocol, k -> new ConcurrentHashMap<>());
        typeMap.put(messageType, type);
        return type;
    }

    public static <Req> MessageType<Req> create(String messageType, Class<Req> dataType, String alias, MessageType<?> responseType) {
        return new MessageTypeImpl<>(messageType, dataType, alias, responseType);
    }

    public static <Req> MessageType<Req> createAndSave(String messageType, Class<Req> dataType, String alias, MessageType<?> responseType, String protocol) {
        MessageTypeImpl<Req> type = new MessageTypeImpl<>(messageType, dataType, alias, responseType);
        Map<String, MessageTypeImpl<?>> typeMap = map.computeIfAbsent(protocol, k -> new ConcurrentHashMap<>());
        typeMap.put(messageType, type);
        return type;
    }

    MessageTypeImpl(String messageType, Class<Req> dataType, MessageType<?> responseType) {
        this(messageType, dataType, dataType.getSimpleName(), responseType);
    }

    MessageTypeImpl(String messageType, Class<Req> dataType, String alias, MessageType<?> responseType) {
        this.messageType = messageType;
        this.alias = alias;
        this.dataType = dataType;
        this.responseType = responseType;
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
    public Class<Req> dataType() {
        return dataType;
    }

    @Override
    public MessageType<?> responseType() {
        return responseType;
    }
}
