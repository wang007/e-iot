package io.github.eiot.ocpp.schema.v1_6;

import io.github.eiot.ocpp.MessageTypeId;
import io.github.eiot.ocpp.OcppFrame;
import io.github.eiot.ocpp.OcppFrameConverter;
import io.github.eiot.ocpp.RawOcppFrame;
import io.vertx.core.json.JsonObject;
import org.junit.Assert;
import org.junit.Test;

/**
 * created by wang007 on 2025/7/1
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
        String bootNotificationJson = "[2,\n" +
                " \"19223201\",\n" +
                " \"BootNotification\",\n" +
                " {\"chargePointVendor\": \"VendorX\", \"chargePointModel\": \"SingleSocketCharger\"}\n" +
                "]";
        OcppFrame<BootNotificationRequest> bootNotificationRequestFrame = convertFrame(bootNotificationJson);
        BootNotificationRequest bootNotificationRequest = bootNotificationRequestFrame.data();
        Assert.assertEquals(bootNotificationRequestFrame.messageTypeId(), MessageTypeId.CALL);
        Assert.assertEquals(bootNotificationRequestFrame.messageId(), "19223201");
        Assert.assertEquals(bootNotificationRequestFrame.command(), "BootNotification");
        Assert.assertEquals(bootNotificationRequest.getChargePointVendor(), "VendorX");

        String bootNotificationResponseJson = "[3,\n" +
                " \"19223201\",\n" +
                " {\"status\":\"Accepted\", \"currentTime\":\"2013-02-01T20:53:32.486Z\", \"heartbeatInterval\":300}\n" +
                "]";
        RawOcppFrame bootNotificationResponseFrame = convertRaw(bootNotificationResponseJson);
        Assert.assertEquals(bootNotificationResponseFrame.messageTypeId(), MessageTypeId.CALLRESULT);
        Assert.assertEquals(bootNotificationResponseFrame.messageId(), "19223201");
        Assert.assertNull(bootNotificationResponseFrame.command());

        JsonObject data = bootNotificationResponseFrame.data();
        Assert.assertEquals(data.getInteger("heartbeatInterval").intValue(), 300);
        Assert.assertEquals(data.getString("status"), "Accepted");
    }

}
