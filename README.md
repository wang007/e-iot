# e-iot

简单，高性能，基于 vert.x 实现多种充电协议。

Simple, high performance, based on vertx to implement a variety of charging protocols

### 实现的协议

* 云快充协议(包括 云快充1.5, 云快充 1.6)  (eiot-ykc) doing
* ocpp(包括 ocpp1.6J, ocpp2.0.1, ocpp2.1) (eiot-ocpp) doing

### 怎么使用
1. [云快充 使用实例](./eiot-example/src/main/java/io/github/eiot/example/ykc/YkcChargeServerExample.java)
2. [云快充 代理服务实例](./eiot-example/src/main/java/io/github/eiot/example/ykc/YkcReverseServerExample.java)
3. [ocpp 使用实例](./eiot-example/src/main/java/io/github/eiot/example/ocpp/OcppServerExample.java)
4. [ocpp 多协议共用服务使用实例](./eiot-example/src/main/java/io/github/eiot/example/ocpp/MultiOcppServerExample.java)

### 支持
1. 由于协议定义涉及版权问题，如需私有 iot 协议开发，请联系我
<div>
	<img src="./wechat.png" alt="Editor" width="400">
</div>