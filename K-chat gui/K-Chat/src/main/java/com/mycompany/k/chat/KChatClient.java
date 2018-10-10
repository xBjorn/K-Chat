package com.mycompany.k.chat;

import java.net.*;
import java.io.*;

public class KChatClient extends Thread {

	private Socket clientSocket;
        private PrintWriter out;
	private String ip;
	private int port;
        private String msg;

	public KChatClient(String ip, int port, String msg) {
		this.ip = ip;
		this.port = port;
                this.msg = msg;
		
	}

	public void run(String ip, int port, String msg) {
		try {
			clientSocket = new Socket(this.ip, this.port);
			System.out.println("connecting with: " + getIp());
                        out = new PrintWriter(clientSocket.getOutputStream(), true);
                        out.println(msg);
                      
		} catch (IOException sweetError) {
			System.out.println("failed to create clientsocket?: " + sweetError);
		}
	}

	public String getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}


	public void stopConnection() {
		try {
			out.close();
			clientSocket.close();
		} catch (IOException sweetError) {
			out.println("cant close the reader or socket? " + sweetError);

		}

	}

}
