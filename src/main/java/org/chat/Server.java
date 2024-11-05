package org.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{

        ServerSocket server = new ServerSocket(8000);

        System.out.println("Server waiting for client...");

        //Accepting client connection
        Socket clientSocket = server.accept();
        System.out.println("Client connected");

        DataInputStream input = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message1 = "";
        String message2 = "";

        while (!message1.equalsIgnoreCase("stop")) {
            message1 = input.readUTF();
            System.out.println("Client says : " + message1);

            message2 = br.readLine();
            outputStream.writeUTF(message2);
        }
        input.close();
        server.close();
        clientSocket.close();
    }
}
