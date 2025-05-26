package com.github.eiot.test;

import com.github.eiot.test.example.ExampleIotServer;
import io.vertx.core.Vertx;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * created by wang007 on 2025/5/26
 */
public class IotServerTest {

    private static Vertx vertx;

    @BeforeClass
    public static void initVertx() {
        vertx = Vertx.vertx();
    }


    @Test
    public void connectionHandler() {
        ExampleIotServer iotServer = ExampleIotServer.create(vertx);
        iotServer.connectionHandler(connection -> {

        });

    }


}
