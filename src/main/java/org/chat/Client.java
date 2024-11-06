package org.chat;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8000);

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message1 = "";
        String message2 = "";

        while (!message1.equalsIgnoreCase("stop")) {
            message1 = br.readLine();
            outputStream.writeUTF(message1);

            if (message1.equalsIgnoreCase("stop")) {
                System.out.println("Disconnecting from the server...");
                break;
            }

            message2 = input.readUTF();
            System.out.println("Server says  : " + message2);
        }
        input.close();
        socket.close();
        outputStream.close();

    }
}
