package com.mycompany.k.chat;

import java.net.*;
import java.io.*;

public class KChatClient {

    private Socket socket;

    public KChatClient(InetAddress serverAddress, int serverPort) throws Exception {
        this.socket = new Socket(serverAddress, serverPort);
    }

    public void sent(String msg) throws IOException {

        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        out.println(msg);
        out.flush();

    }

}
