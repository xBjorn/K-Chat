package com.mycompany.k.chat;

import java.net.*;
import java.io.*;

public class KChatClient extends Thread {

	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	private String ip;
	private int port;

	public KChatClient(String ip, int port) {
		ip = this.ip;
		port = this.port;
		
	}

	public void run(String ip, int port) {
		try {
			clientSocket = new Socket(this.ip, this.port);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                      
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

	public String sendMessage(String msg) {

		String resp = "";
                
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                
                String userInput;
         
                try{
                userInput = stdIn.readLine();
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
                }
                catch(IOException e)
                {
                    System.out.println(e);
                }
           
		try {
			resp = in.readLine();
		} catch (IOException sweetError) {
			out.println("cant read server msg" + sweetError);
		}
		return resp;

	}

	public void stopConnection() {
		try {
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException sweetError) {
			out.println("cant close the reader or socket? " + sweetError);

		}

	}

}
