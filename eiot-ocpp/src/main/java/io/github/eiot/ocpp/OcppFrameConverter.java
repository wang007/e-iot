package io.github.eiot.ocpp;

import io.github.eiot.CommandDef;
import io.github.eiot.Frame;
import io.github.eiot.FrameConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * created by wang007 on 2025/5/10
 */
public class OcppFrameConverter extends FrameConverter {

    private static final Logger logger = LoggerFactory.getLogger(OcppFrameConverter.class);

    public static final OcppFrameConverter INSTANCE = new OcppFrameConverter(false);

    public static final OcppFrameConverter COMPATIBLE_OCPP2_0_1_INSTANCE = new OcppFrameConverter(true);

    private final boolean compatibleOcpp2_0_1;

    public OcppFrameConverter(boolean compatibleOcpp2_0_1) {
        this.compatibleOcpp2_0_1 = compatibleOcpp2_0_1;
    }

    @Override
    public Frame<?> apply(Frame<?> frame) {
        if (!frame.isRaw()) {
            return frame;
        }

        RawOcppFrame ocppFrame = (RawOcppFrame) frame;
        MessageTypeId messageTypeId = ocppFrame.messageTypeId();
        if (messageTypeId == null) {
            return ocppFrame;
        }
        switch (messageTypeId) {
            case SEND:
            case CALL:
                return super.apply(ocppFrame);
            case CALLERROR:
            case CALLRESULTERROR:
                return new ErrorOcppFrame(ocppFrame);
            case CALLRESULT:
                // before put
                String requestCommand = ocppFrame.get(OcppRequestFrame.REQUEST_FRAME_COMMAND_KEY);
                // maybe request command but use write method
                if (requestCommand == null) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("terminalNo: {} ocpp CALLRESULT not has request command, message id: {}",
                                ocppFrame.terminalNo(), ocppFrame.messageId());
                    }
                    return ocppFrame;
                }
                // call result not has command, use request command + "Response", see OcppCommand
                String command = requestCommand + "Response";
                String protocol = ocppFrame.iotConnection().protocol();
                CommandDef<?> commandDef = CommandDef.match(protocol, command);

                // compatibleOcpp2_0_1
                if (compatibleOcpp2_0_1 && protocol.equals(OcppVersion.OCPP2_0_1.versionName)) {
                    CommandDef<?> compatible = CommandDef.match(OcppVersion.OCPP2_1.versionName, command);
                    if (compatible != null) {
                        return new DefaultOcppFrame<>(ocppFrame, compatible);
                    }
                }

                if (commandDef == null) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("terminalNo: {} ocpp command: {} not found commandDef.", frame.terminalNo(), command);
                    }
                    return frame;
                }
                return new DefaultOcppFrame<>(ocppFrame, commandDef);
        }

        return ocppFrame;
    }

    @Override
    protected Frame<?> convert(Frame<?> frame, CommandDef<?> commandDef) {
        return new DefaultOcppFrame<>((RawOcppFrame) frame, commandDef);
    }
}
