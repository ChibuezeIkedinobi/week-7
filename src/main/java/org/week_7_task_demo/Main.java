package org.week_7_task_demo;

import org.week_7_task_demo.service.HttpServerServiceImpl;
import java.io.IOException;

import static org.week_7_task_demo.common.SimpleHttpServer.PORT;

public class Main {
    public static void main(String[] args) throws Exception {

        HttpServerServiceImpl service = new HttpServerServiceImpl();

        service.start(PORT);

    }
}
