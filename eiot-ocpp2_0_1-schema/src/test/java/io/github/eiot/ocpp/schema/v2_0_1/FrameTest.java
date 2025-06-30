package io.github.eiot.ocpp.schema.v2_0_1;

import io.github.eiot.ocpp.*;
import io.vertx.core.json.JsonObject;
import org.junit.Assert;
import org.junit.Test;

/**
 * created by wang007 on 2025/7/10
 */
public class FrameTest {

    public static RawOcppFrame convertRaw(String json) {
        return RawOcppFrame.new4Receiver(new FakeOcppConnection(), json);
    }

    @SuppressWarnings("unchecked")
    public static <T> OcppFrame<T> convertFrame(String json) {
        RawOcppFrame rawOcppFrame = convertRaw(json);
        return (OcppFrame<T>) OcppFrameConverter.INSTANCE.apply(rawOcppFrame);
    }

    @Test
    public void testFrame() {
        String callJson = "[2,\n" +
                " \"19223201\",\n" +
                " \"BootNotification\",\n" +
                " {\n" +
                " \"reason\": \"PowerUp\",\n" +
                " \"chargingStation\": {\n" +
                " \"model\": \"SingleSocketCharger\",\n" +
                " \"vendorName\": \"VendorX\"\n" +
                " }\n" +
                " }\n" +
                "]";
        OcppFrame<BootNotificationRequest> ocppFrame = convertFrame(callJson);
        BootNotificationRequest bootNotificationRequest = ocppFrame.data();
        Assert.assertEquals(ocppFrame.messageTypeId(), MessageTypeId.CALL);
        Assert.assertEquals(ocppFrame.messageId(), "19223201");
        Assert.assertEquals(ocppFrame.command(), "BootNotification");
        Assert.assertEquals(bootNotificationRequest.getChargingStation().getVendorName(), "VendorX");


        String callResultJson = "[3,\n" +
                " \"19223201\",\n" +
                " {\n" +
                " \"currentTime\": \"2013-02-01T20:53:32.486Z\",\n" +
                " \"interval\": 300,\n" +
                " \"status\": \"Accepted\"\n" +
                " }\n" +
                "]";
        RawOcppFrame bootNotificationResponseFrame = convertRaw(callResultJson);
        Assert.assertEquals(bootNotificationResponseFrame.messageTypeId(), MessageTypeId.CALLRESULT);
        Assert.assertEquals(bootNotificationResponseFrame.messageId(), "19223201");
        Assert.assertNull(bootNotificationResponseFrame.command());
        JsonObject data = bootNotificationResponseFrame.data();
        Assert.assertEquals(data.getInteger("interval").intValue(), 300);
        Assert.assertEquals(data.getString("status"), "Accepted");


        String callErrorJson = "[4,\n" +
                " \"162376037\",\n" +
                " \"NotSupported\",\n" +
                " \"SetDisplayMessageRequest not implemented\",\n" +
                " {}\n" +
                "]";
        OcppFrame<Void> errorFrame = convertFrame(callErrorJson);
        Assert.assertEquals(errorFrame.messageTypeId(), MessageTypeId.CALLERROR);
        Assert.assertEquals(errorFrame.messageId(), "162376037");
        Assert.assertTrue(errorFrame.failed());
        Assert.assertEquals(errorFrame.errorCode(), OcppError.NotSupported);
        Assert.assertEquals(errorFrame.errorDescription(), "SetDisplayMessageRequest not implemented");
        Assert.assertEquals(errorFrame.errorDetails().size(), 0);
    }

}
