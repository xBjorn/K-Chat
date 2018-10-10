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
			
			serverSocket = new ServerSocket(6666);                    
			clientSocket = serverSocket.accept();
                        

			//prepare outbound connection with autoflush
			out = new PrintWriter(clientSocket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String greeting = in.readLine();
			System.out.println(greeting);
                        out.println(greeting);

			if (greeting.equals("hello server")) {
				System.out.println("rcvd");
                                out.println("hello client");
			} else {
                                System.out.println("rcvd");
                                out.println("unrecognised greeting");
			}

		} catch (IOException sweetError) {
			out.println("cant read the packet: " + sweetError);
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
