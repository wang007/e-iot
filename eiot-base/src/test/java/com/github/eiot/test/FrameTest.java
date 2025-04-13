package com.github.eiot.test;

import io.vertx.core.Future;

/**
 * @author yan
 * @since 2025-04-09
 */
public class FrameTest {

    /**
     * frame body
     */
    interface Body {

    }

    /**
     * @param <T> Response type
     */
    interface Request<T extends Response<?>> extends Body {
        T response();
    }

    /**
     * @param <T> Request type
     */
    interface Response<T extends Request<?>> extends Body {
        T request();
    }

    static class Frame<T extends Body> {
        private final T body;

        public Frame(T body) {
            this.body = body;
        }

        public T body() {
            return body;
        }

        public void write() {

        }
    }

    static class RequestFrame<T extends Request<?>> extends Frame<T> {

        public RequestFrame(T body) {
            super(body);
        }

        @SuppressWarnings("unchecked")
        public <Resp extends Response<T>> ResponseFrame<Resp> responseFrame() {
            return new ResponseFrame<>((Resp) body().response());
        }

        @SuppressWarnings("unchecked")
        public <Resp extends Response<T>> Future<ResponseFrame<Resp>> send() {
            return Future.succeededFuture(new ResponseFrame<>((Resp) body().response()));
        }
    }

    static class ResponseFrame<T extends Response<?>> extends Frame<T> {

        public ResponseFrame(T body) {
            super(body);
        }

    }


    static class LoginReq implements Request<LoginResp> {

        @Override
        public LoginResp response() {
            return new LoginResp();
        }
    }

    static class LoginResp implements Response<LoginReq> {

        @Override
        public LoginReq request() {
            return new LoginReq();
        }
    }

    static class HeartbeatReq implements Request<HeartbeatResp> {

        @Override
        public HeartbeatResp response() {
            return new HeartbeatResp();
        }
    }

    static class HeartbeatResp implements Response<HeartbeatReq> {

        @Override
        public HeartbeatReq request() {
            return new HeartbeatReq();
        }
    }

    public static void main(String[] args) {
        RequestFrame<LoginReq> requestFrame = new RequestFrame<>(new LoginReq());
        requestFrame.write();
        requestFrame.send().flatMap(response -> {
            LoginReq request = response.body().request();
            return Future.succeededFuture(request);
        });

        ResponseFrame<LoginResp> responseFrame = requestFrame.responseFrame();
        responseFrame.write();
    }


}
