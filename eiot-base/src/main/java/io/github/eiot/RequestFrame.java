package io.github.eiot;


import io.vertx.core.Future;

import java.util.concurrent.TimeoutException;

/**
 * The {@link Frame} is divided into two types: one is written to ignore the result,
 * and the other is written to expect the corresponding response frame result.
 * <p>
 * The request frame must have a response type, if not, it is not a request frame.
 * eg: LoginRequest -> LoginResponse.
 *
 * <p>
 * When the {@link Frame} does not require attention to the result, use {@link #write()}
 * <p>
 * When sending a frame and expecting a corresponding response frame, use {@link #send()}
 * <p>
 * If there is a response frame, then the frame is a request frame
 * <p>
 * created by wang007 on 2025/2/20
 */
public interface RequestFrame<Req, ResFrame extends Frame<?>> extends Frame<Req> {

    /**
     * The message type of the response frame.
     * eg: LoginRequestFrame message type -> loginResponseFrame message type
     *
     * @return The message type of the response frame
     */
    String responseMessageType();

    /**
     * Create the corresponding response frame instance
     *
     * @return new response frame
     */
    ResFrame responseFrame();

    /**
     * Send the current frame and wait for the response frame.
     * <p>
     * Note: The current method requires the underlying setResult support.
     * <p>
     * Future.failed({@link TimeoutException}) if no response frame comes back within the specified time,
     *
     * @return a future completed with the response frame
     */
    Future<ResFrame> send();

    /**
     * {@link #send()} but timeout can be declared
     *
     * @param timeout timeout
     * @return a future completed with the response frame
     */
    Future<ResFrame> send(int timeout);

    /**
     * Gets the future after calling {@link #send()}
     *
     * @return a future completed with the response frame
     */
    Future<ResFrame> sendResult();

    /**
     * set the response frame result by {@link #send()} when the response frame come back.
     * <p>
     * NOTE: don't called it, is internal method.
     *
     * @param frame the response frame
     * @param ex    failed result
     * @return set result
     */
    boolean trySetResponseResult(ResFrame frame, Throwable ex);

    @Override
    RequestFrame<Req, ResFrame> data(Req req);
}
