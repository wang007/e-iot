package io.github.eiot.ocpp;

import io.github.eiot.Frame;
import io.github.eiot.ocpp.schema.BootNotificationRequest;
import io.github.eiot.ocpp.schema.BootNotificationResponse;
import io.github.eiot.ocpp.schema.BootReasonEnum;
import io.github.eiot.ocpp.schema.RegistrationStatusEnum;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import org.junit.Assert;
import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * created by wang007 on 2025/6/29
 */
public class OcppFrameTest {


    public static RawOcppFrame convertRaw(String json) {
        return RawOcppFrame.new4Receiver(new FakeOcppConnection(OcppVersion.OCPP2_1), json);
    }

    @SuppressWarnings("unchecked")
    public static <T> OcppFrame<T> convertFrame(String json) {
        RawOcppFrame frame = convertRaw(json);
        return (OcppFrame<T>) OcppFrameConverter.INSTANCE.apply(frame);
    }

    @Test
    public void testRawFrame() {
        String callJson = "[2,\n" +
                " \"19223201\",\n" +
                " \"BootNotification\",\n" +
                " {\"chargePointVendor\": \"VendorX\", \"chargePointModel\": \"SingleSocketCharger\"}\n" +
                "]";
        RawOcppFrame callFrame = convertRaw(callJson);
        Assert.assertEquals(callFrame.messageTypeId(), MessageTypeId.CALL);
        Assert.assertEquals(callFrame.command(), "BootNotification");
        Assert.assertEquals(callFrame.messageId(), "19223201");
        Assert.assertEquals(callFrame.data().getString("chargePointVendor"), "VendorX");
        Assert.assertFalse(callFrame.failed());
        Assert.assertTrue(callFrame.isRaw());
        Assert.assertNull(callFrame.errorCode());
        Assert.assertNull(callFrame.errorDescription());
        Assert.assertNull(callFrame.errorDetails());
        System.out.println(callFrame.toRawString());

        String callResultJson = "[3,\n" +
                " \"19223201\",\n" +
                " {\"status\":\"Accepted\", \"currentTime\":\"2013-02-01T20:53:32.486Z\", \"heartbeatInterval\":300}\n" +
                "]";
        RawOcppFrame callResultFrame = convertRaw(callResultJson);
        Assert.assertSame(callResultFrame.messageTypeId(), MessageTypeId.CALLRESULT);
        Assert.assertEquals(callResultFrame.messageId(), "19223201");
        Assert.assertNull(callResultFrame.command());
        Assert.assertEquals(callResultFrame.data().getString("status"), "Accepted");
        Assert.assertEquals(callResultFrame.data().getInteger("heartbeatInterval").intValue(), 300);

        String errorJson = "[4,\n" +
                " \"162376037\",\n" +
                " \"NotSupported\",\n" +
                " \"SetDisplayMessageRequest not supported\",\n" +
                " {}\n" +
                "]";
        RawOcppFrame errorFrame = convertRaw(errorJson);
        Assert.assertSame(errorFrame.messageTypeId(), MessageTypeId.CALLERROR);
        Assert.assertEquals(errorFrame.messageId(), "162376037");
        Assert.assertEquals(errorFrame.errorCode(), OcppError.NotSupported);
        Assert.assertEquals(errorFrame.errorDescription(), "SetDisplayMessageRequest not supported");
        Assert.assertEquals(errorFrame.errorDetails().size(), 0);


        String sendJson = "[6,\n" +
                " \"19223201\",\n" +
                " \"NotifyPeriodicEventStream\",\n" +
                " {\n" +
                " \"id\": 123,\n" +
                " \"pending\": 0,\n" +
                " \"data\": [ {\"t\": \"2024-08-27T12:30:40Z\", \"v\": \"230.4\"}, {\"t\": \"2024-08-27T12:30:45Z\", \"v\": \"230.2\"} ]\n" +
                " }\n" +
                "]";
        RawOcppFrame sendFrame = convertRaw(sendJson);
        Assert.assertSame(sendFrame.messageTypeId(), MessageTypeId.SEND);
        Assert.assertEquals(sendFrame.messageId(), "19223201");
        Assert.assertEquals(sendFrame.command(), "NotifyPeriodicEventStream");
        Assert.assertEquals(sendFrame.data().getInteger("id").intValue(), 123);
        Assert.assertEquals(sendFrame.data().getInteger("pending").intValue(), 0);
        Assert.assertEquals(sendFrame.data().getJsonArray("data").size(), 2);
    }

    @Test
    public void testRawFrame4sender() {
        RawOcppFrame ocppFrame = RawOcppFrame.new4Sender(new FakeOcppConnection(), "BootNotification", null);
        String data = "{\"chargePointVendor\": \"VendorX\", \"chargePointModel\": \"SingleSocketCharger\"}";
        ocppFrame.data(new JsonObject(data));
        Assert.assertEquals(ocppFrame.command(), "BootNotification");
        Assert.assertEquals(ocppFrame.messageTypeId(), MessageTypeId.CALL);


        RawOcppFrame responseFrame = RawOcppFrame.new4Sender(new FakeOcppConnection(), null, ocppFrame);
        Assert.assertNull(responseFrame.command());
        Assert.assertEquals(responseFrame.messageId(), ocppFrame.messageId());
        Assert.assertEquals(responseFrame.messageTypeId(), MessageTypeId.CALLRESULT);

        OcppFrame<Void> errorFrame = ocppFrame.newErrorFrame(OcppError.GenericError, "test");
        Assert.assertEquals(errorFrame.messageId(), ocppFrame.messageId());
        Assert.assertEquals(errorFrame.messageTypeId(), MessageTypeId.CALLERROR);

        OcppFrame<Void> resultErrorFrame = ocppFrame.newResulErrorFrame(OcppError.GenericError, "test");
        Assert.assertEquals(resultErrorFrame.messageId(), ocppFrame.messageId());
        Assert.assertEquals(resultErrorFrame.messageTypeId(), MessageTypeId.CALLRESULTERROR);
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
        System.out.println(ocppFrame);

        Assert.assertEquals(ocppFrame.data().getReason(), BootReasonEnum.POWER_UP);
        Assert.assertEquals(ocppFrame.data().getChargingStation().getModel(), "SingleSocketCharger");

        OcppFrame<BootNotificationResponse> responseOcppFrame = ocppFrame.asRequest(Ocpp2_1Command.BootNotificationRequest).responseFrame();
        BootNotificationResponse bootNotificationResponse = responseOcppFrame.newData();
        bootNotificationResponse.setCurrentTime(ZonedDateTime.now());
        bootNotificationResponse.setStatus(RegistrationStatusEnum.ACCEPTED);
        bootNotificationResponse.setInterval(300);
        responseOcppFrame.data(bootNotificationResponse);
        System.out.println(responseOcppFrame);

        Assert.assertEquals(responseOcppFrame.messageId(), ocppFrame.messageId());
        Assert.assertNull(responseOcppFrame.command());


        OcppFrame<Void> errorFrame = ocppFrame.newErrorFrame(OcppError.GenericError, "test", new JsonObject().put("user", "wang007"));
        Assert.assertEquals(errorFrame.messageId(), ocppFrame.messageId());
        System.out.println(errorFrame);
    }

}
