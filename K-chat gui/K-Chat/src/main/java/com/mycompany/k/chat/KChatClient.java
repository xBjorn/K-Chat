package com.mycompany.k.chat;

import java.net.*;
import java.io.*;

public class KChatClient extends Thread {

	private Socket clientSocket;
        private PrintWriter out;
	private String ip;
	private int port;

	public KChatClient(String ip, int port) {
		ip = this.ip;
		port = this.port;
		
	}

	public void run(String ip, int port) {
		try {
			clientSocket = new Socket(this.ip, this.port);
			
                      
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

	public void sendMessage(String msg) {

         
                try{
                out = new PrintWriter(msg);
            
                }
                catch(IOException e)
                {
                    System.out.println(e);
                }
           
		

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
