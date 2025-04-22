package io.github.eiot.route;

import io.vertx.core.Handler;

/**
 * Equivalent to {@link IotRouter#route(String)} and {@link IotRoute#handler(Handler)}
 * <p>
 * created by wang007 on 2025/3/20
 */
public interface CommandHandler<T> extends Handler<IotRoutingContext<T>> {

    /**
     * @return provide command to match.
     */
    String command();

    @Override
    void handle(IotRoutingContext<T> ctx);
}
