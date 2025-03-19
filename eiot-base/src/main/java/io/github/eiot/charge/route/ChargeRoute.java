package io.github.eiot.charge.route;

import io.github.eiot.charge.MessageTypeEnum;
import io.vertx.core.Handler;

/**
 * A ChargeRoute is a holder for a set of criteria which determine whether a frame request or failure should be routed to a handler.
 * <p>
 * created by wang007 on 2025/3/19
 */
public interface ChargeRoute {

    /**
     * set match by message type
     *
     * @param messageType the message type
     * @return this
     */
    ChargeRoute messageType(String messageType);

    /**
     * {@link #messageType(String)}, but use {@link MessageTypeEnum#messageType()}
     *
     * @param messageTypeEnum the messageType enum
     * @return this
     */
    default ChargeRoute messageTypeEnum(MessageTypeEnum messageTypeEnum) {
        return messageType(messageTypeEnum.messageType());
    }

    /**
     * Append a handler to the route handlers list.
     *
     * @param handler the handler
     * @return this
     */
    ChargeRoute handler(Handler<ChargeRoutingContext> handler);

    /**
     * Append a blockingHandler to the route handlers list.
     *
     * @param blockingHandler the blockingHandler
     * @return this
     */
    ChargeRoute blockingHandler(Handler<ChargeRoutingContext> blockingHandler);

    /**
     * Append a failureHandler to the route handlers list.
     *
     * @param failureHandler the failureHandler
     * @return
     */
    ChargeRoute failureHandler(Handler<ChargeRoutingContext> failureHandler);

    /**
     * @param order
     * @return
     */
    ChargeRoute order(int order);

    /**
     * @return
     */
    default ChargeRoute first() {
        return order(Integer.MIN_VALUE);
    }

    /**
     * Specify this is the last route for the router.
     *
     * @return a reference to this, so the API can be used fluently
     */
    default ChargeRoute last() {
        return order(Integer.MAX_VALUE);
    }

    /**
     * match raw frame and concrete frame
     * <p>
     * default: false. only match Concrete frame
     *
     * @return a reference to this, so the API can be used fluently
     */
    ChargeRoute alsoMatchRaw();

    /**
     * only match raw and not match concrete frame
     * <p>
     * default: false. only match Concrete frame
     *
     * @return a reference to this, so the API can be used fluently
     */
    ChargeRoute onlyMatchRaw();

}
