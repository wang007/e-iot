# e-iot

简单，高性能，基于 vert.x 实现多种充电协议。

Simple, high performance, based on vertx to implement a variety of charging protocols

### 实现的协议

* 云快充协议1.x  (eiot-ykc) doing
* ocpp1.6j  (eiot-ocpp1) doing
* ocpp 2.0.1 (eiot-ocpp2) doing


### 使用实例
以云快充协议为例
```java
package io.github.eiot.charge.ykc;

import io.github.eiot.Frame;
import io.github.eiot.route.IotRouter;
import io.github.eiot.route.IotRoutingContext;
import io.github.eiot.route.MessageTypeHandler;
import io.github.eiot.server.IotServer;
import io.github.eiot.charge.ykc.data.YkcHeartbeatRequest;
import io.github.eiot.charge.ykc.data.YkcHeartbeatResponse;
import io.github.eiot.charge.ykc.data.YkcLoginRequest;
import io.github.eiot.charge.ykc.data.YkcLoginResponse;
import io.vertx.core.Vertx;

/**
 * created by wang007 on 2025/3/21
 */
public class Main {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        
        IotServer chargeServer = YkcChargeServer.create(vertx);
        IotRouter router = IotRouter.router(vertx);
        router.route(YkcMessageType.YkcHeartbeatRequest)
                .handler(ctx -> {
                    Frame<YkcHeartbeatRequest> frame = ctx.frame();
                    System.out.println("heartbeat. gunNo: " + frame.data().getGunNo());

                    Frame<YkcHeartbeatResponse> responseFrame = frame.<YkcHeartbeatResponse>asRequest().responseFrame();

                    YkcHeartbeatResponse response = responseFrame.newDate();
                    response.setGunNo(frame.data().getGunNo());
                    response.setResult(1);
                    responseFrame.data(response).write();
                });
        router.route(new YkcLoginHandler());

        chargeServer.frameHandler(router).listen()
                .onComplete(ar -> {
                    if (ar.succeeded()) {
                        System.out.println(ar.result().protocol() + " server listening on: " + ar.result().actualPort());
                    } else {
                        System.out.println(ar.result().protocol() + " server start failed");
                        ar.cause().printStackTrace();;
                    }
                });
    }

    static class YkcLoginHandler implements MessageTypeHandler<YkcLoginRequest> {

        @Override
        public String messageType() {
            return YkcMessageType.YkcLoginRequest.messageType();
        }

        @Override
        public void handle(IotRoutingContext<YkcLoginRequest> ctx) {
            Frame<YkcLoginRequest> frame = ctx.frame();
            YkcLoginRequest data = frame.data();
            String terminalNo = frame.terminalNo();
            System.out.println("terminalNo: " + terminalNo + "login.");

            Frame<YkcLoginResponse> responseFrame = frame.<YkcLoginResponse>asRequest().responseFrame();
            YkcLoginResponse loginResponse = responseFrame.newDate();
            loginResponse.setResult(1);
            loginResponse.setTerminalNo(data.getTerminalNo());
            responseFrame.data(loginResponse);
        }

    }
}
```

### 代理服务实例
以云快充为例，根据 terminalNo 选取不同的后端服务路由
```java
package io.github.eiot.charge.ykc;

import io.github.eiot.Frame;
import io.github.eiot.charge.ykc.data.YkcLoginRequest;
import io.github.eiot.server.IotServer;
import io.vertx.core.Vertx;

/**
 * created by wang007 on 2025/4/11
 */
public class Main2 {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        YkcChargeClient chargeClient = YkcChargeClient.create(vertx);

        IotServer chargeServer = YkcChargeServer.create(vertx);
        chargeServer.connectionHandler(conn -> {
            conn.frameHandler(frame -> {
                // pause first
                conn.pause();

                // first frame must be login frame
                if (!frame.messageType().equals(YkcMessageType.YkcLoginRequest.messageType())) {
                    // drop it!
                    return;
                }
                Frame<YkcLoginRequest> loginFrame = (Frame<YkcLoginRequest>) frame;

                // rout to upstream by terminalNo
                String terminalNo = loginFrame.data().getTerminalNo().toString();

                int choose = terminalNo.hashCode() % 2;
                String server = "localhost";
                int port = choose == 0? 8888 : 8899;

                chargeClient.connect(port, server)
                        .onFailure(ex -> {
                            System.out.println("route to upstream failed. terminalNo: " + terminalNo);
                            ex.printStackTrace();
                            conn.close();
                        })
                        .onSuccess(clientConn -> {
                            // reset handler
                            conn.frameHandler(null);

                            conn.pipeTo(clientConn);
                            clientConn.pipeTo(conn);
                        });
            });
        });
        chargeServer.listen(8081)
                .onComplete(ar -> {
                    if (ar.succeeded()) {
                        System.out.println(ar.result().protocol() + " proxy server listening on: " + ar.result().actualPort());
                    } else {
                        System.out.println(ar.result().protocol() + " proxy server start failed");
                        ar.cause().printStackTrace();;
                    }
                });
    }
}


```
