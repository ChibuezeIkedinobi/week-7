package org.week_7_task_demo.utils;

import org.week_7_task_demo.common.SimpleHttpServer;

import java.io.*;
import java.net.Socket;

import static org.week_7_task_demo.common.SimpleHttpServer.HTML_FILE_PATH;
import static org.week_7_task_demo.common.SimpleHttpServer.PORT;
import static org.week_7_task_demo.common.SimpleHttpServer.JSON_FILE_PATHS;

public class HttpHandler implements Runnable {

    private final Socket socket;

    public HttpHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

            String request = input.readLine();

            if (request != null) {
                String[] parts = request.split("\\s+");

                if (parts.length >= 2 && parts[0].equals("GET")) {
                    String path = parts[1];

                    if (path.equals("/") || path.equals("index.html")) {
                        sendNewHtmlResponse(output);
                    } else if (path.equals("/json")) {
                        sendNewJsonResponse(output);
                    } else {
                        sendNewNotFoundResponse(output);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void sendNewHtmlResponse(PrintWriter output) {
        File file = new File(HTML_FILE_PATH);

        if (file.exists()) {
            sendResponse(output, file, "text/html");
        } else {
            sendNewNotFoundResponse(output);
        }
    }

    private void sendNewJsonResponse(PrintWriter output) {
        File file = new File(HTML_FILE_PATH);

        if (file.exists()) {
            sendResponse(output, file, "text/html");
        } else {
            sendNewNotFoundResponse(output);
        }
    }

    private void sendNewNotFoundResponse(PrintWriter output) {
        output.println("HTTP//1.1 404 Not Found");
        output.println("Content-type: text/plain");
        output.println();
        output.println("404 Not Found - The required resource was not found on this Server");
    }

    private void sendResponse(PrintWriter output, File file, String contentType) throws Exception {
        output.println("HTTP/1.1 200 OK");
        output.println("Content- type: "+ contentType);
        output.println();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                output.println(line);
                System.out.println(line);
            }
        }
    }


}