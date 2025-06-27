package io.github.eiot.route;

import io.github.eiot.CommandDef;
import io.vertx.core.Handler;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Multi command handler mapping.
 * In order to reduce the base number of router matches.
 *
 * <p>
 * created by wang007 on 2025/6/28
 */
public class IotHandlerMapping implements Handler<IotRoutingContext<Object>> {

    private final Map<String, Handler<?>> handlers = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    @Override
    public void handle(IotRoutingContext<Object> ctx) {
        String command = ctx.command();
        Handler<?> h = handlers.get(command);
        if (h == null) {
            ctx.next();
            return;
        }
        Handler<IotRoutingContext<Object>> handler = (Handler<IotRoutingContext<Object>>) h;
        handler.handle(ctx);
    }

    public <Req> IotHandlerMapping handler(String command, Handler<IotRoutingContext<Req>> handler) {
        Objects.requireNonNull(command, "require command");
        Objects.requireNonNull(handler, "require handler");

        Handler<?> existing = handlers.get(command);
        if (existing != null) {
            throw new IllegalStateException("command: " + command + " handler already exist.");
        }
        handlers.put(command, handler);
        return this;
    }

    public <Req> IotHandlerMapping handler(CommandDef<Req> command, Handler<IotRoutingContext<Req>> handler) {
        return handler(command.command(), handler);
    }

    public <Req> IotHandlerMapping handler(CommandDefHandler<Req> handler) {
        return handler(handler.command(), handler);
    }

    public IotHandlerMapping removeHandler(String command) {
        handlers.remove(command);
        return this;
    }

}
