package com.mycompany.k.chat;

import java.net.*;
import java.io.*;

public class KChatServer extends Thread {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    @Override
    public void run() {
        try {
            //Make server socket
            int serverPort = 12001;
            ServerSocket serverSocket = new ServerSocket(serverPort);
          //  serverSocket.setSoTimeout(10000);

            while (true) {
                System.out.println("Waiting for client in port.." + serverSocket.getLocalPort());
                Socket server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());

                //client writer
                PrintWriter toClient
                        = new PrintWriter(server.getOutputStream(), true);

                //read from client
                BufferedReader fromClient
                        = new BufferedReader(
                                new InputStreamReader(server.getInputStream()));

                //read line from the received msg
                String line = fromClient.readLine();
                System.out.println("Server received: " + line);

                //write back to the client with PrintWriter
                toClient.println("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");

            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException sweetError) {
            out.println(sweetError);
        }
    }
}
