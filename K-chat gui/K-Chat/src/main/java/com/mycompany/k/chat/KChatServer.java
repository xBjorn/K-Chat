package com.mycompany.k.chat;

import java.net.*;
import java.io.*;

public class KChatServer extends Thread {

	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;

	public void run() {

		try {
			System.out.println("Thread "
					+ Thread.currentThread().getId()
					+ " is running");
			serverSocket = new ServerSocket(6666);
			clientSocket = serverSocket.accept();

			//prepare outbound connection with autoflush
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String greeting = in.readLine();

			if (greeting.equals("hello server")) {
				out.println("hello client");
			} else {
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

	public static void main(String[] args) {

		KChatServer server = new KChatServer();
		server.start();

	}
}
