package io.github.eiot.charge.ykc;

import io.github.eiot.Frame;
import io.github.eiot.RequestFrame;
import io.github.eiot.codec.Hex;

/**
 * 云快充协议
 * <p>
 * created by wang007 on 2025/2/26
 */
public interface YkcFrame<T> extends Frame<T> {

    /**
     * @return 起始标志 68H  1byte
     */
    Hex start();

    /**
     * @return 数据长度 1byte
     */
    @Override
    int rawDataSize();

    /**
     * @return 序列号域 2byte
     */
    int sequenceNo();

    /**
     * 更新序列号
     *
     * @param seqNo 序列号域
     */
    YkcFrame<T> sequenceNo(int seqNo);

    /**
     * 不支持加密，这种加密没有意义，通过 SSL/TLS 层来保证通讯安全
     *
     * @return 0x00:不加密，0x01:3DES  1byte
     */
    int cryptType();

    /**
     * @return 帧类型标志 1byte
     */
    Hex rawMessageType();

    /**
     * @return 消息体 N byte
     */
    @Override
    T data();

    /**
     * @return 校验和 2byte
     */
    int checkCode();

    /**
     * 更新校验和
     *
     * @param checkCode 校验和
     */
    YkcFrame<T> checkCode(int checkCode);

    @Override
    <Resp> RequestFrame<T, YkcFrame<Resp>> asRequest();
}
