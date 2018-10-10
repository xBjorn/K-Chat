/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.k.chat;

//import java.io.InputStreamReader;
//import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author bw
 */
public class KChatClient {
        
    public void sendMessage(String serverIp, int serverPort, String message)
    {
        //zorg dat iets luisterd voordat je probeert te connecten
        
        try {
        Socket cSocket = new Socket(serverIp, serverPort);
        DataOutputStream send = new DataOutputStream(cSocket.getOutputStream());
        //        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //        message = br.readLine();
        

        //write and send
        send.writeUTF(message);
       
        
        }
        catch(IOException e)
        {
            System.out.println("sendMessage: " + e);
        }   
    }
    
    public String getMsg(Socket listenSocket)
    {
        String recv = null;
        while(!Thread.interrupted())
        {
        try{
        DataInputStream receive = new DataInputStream(listenSocket.getInputStream());
        recv = receive.readUTF();
        }
        catch(IOException error)
        {
            System.out.println(error);
        }
        }
        
        return recv;
    }
}

    