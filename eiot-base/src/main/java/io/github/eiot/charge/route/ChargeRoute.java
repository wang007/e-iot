package io.github.eiot.charge.route;

import io.github.eiot.charge.Frame;
import io.github.eiot.charge.MessageTypeEnum;
import io.vertx.core.Handler;

/**
 * A ChargeRoute is a holder for a set of criteria which determine whether a frame request or failure should be routed to a handler.
 * <p>
 * created by wang007 on 2025/3/19
 */
public interface ChargeRoute<T extends Frame<?>> {

    /**
     * set match by message type
     *
     * @param messageType the message type
     * @return this
     */
    ChargeRoute<T> messageType(String messageType);

    /**
     * {@link #messageType(String)}, but use {@link MessageTypeEnum#messageType()}
     *
     * @param messageTypeEnum the messageType enum
     * @return this
     */
    default ChargeRoute<T> messageTypeEnum(MessageTypeEnum messageTypeEnum) {
        return messageType(messageTypeEnum.messageType());
    }

    /**
     * Append a handler to the route handlers list.
     *
     * @param handler the handler
     * @return this
     */
    ChargeRoute<T> handler(Handler<ChargeRoutingContext<T>> handler);

    /**
     * Append a blockingHandler to the route handlers list.
     *
     * @param blockingHandler the blockingHandler
     * @return this
     */
    ChargeRoute<T> blockingHandler(Handler<ChargeRoutingContext<T>> blockingHandler);

    /**
     * Append a failureHandler to the route handlers list.
     *
     * @param failureHandler the failureHandler
     * @return
     */
    ChargeRoute<T> failureHandler(Handler<ChargeRoutingContext<T>> failureHandler);

    /**
     * Specify the order for this route. The router tests routes in that order.
     *
     * @param order the order
     * @return this
     */
    ChargeRoute<T> order(int order);

    /**
     * Specify this is the first route for the router.
     *
     * @return this
     */
    default ChargeRoute<T> first() {
        return order(Integer.MIN_VALUE);
    }

    /**
     * Specify this is the last route for the router.
     *
     * @return a reference to this, so the API can be used fluently
     */
    default ChargeRoute<T> last() {
        return order(Integer.MAX_VALUE);
    }

    /**
     * match raw frame and concrete frame
     * <p>
     * default: false. only match Concrete frame
     *
     * @return a reference to this, so the API can be used fluently
     */
    ChargeRoute<T> alsoMatchRaw();

    /**
     * only match raw and not match concrete frame
     * <p>
     * default: false. only match raw frame
     *
     * @return a reference to this, so the API can be used fluently
     */
    ChargeRoute<T> onlyMatchRaw();

}
