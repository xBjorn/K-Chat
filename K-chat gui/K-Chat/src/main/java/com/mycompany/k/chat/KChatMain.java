/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.k.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Bjorn
 */
public class KChatMain {
    
     public static void main(String[] args){
        
        Socket listenSocket = null;
         
        //setup a listener
        try {
        ServerSocket sSocket = new ServerSocket(1024);
        listenSocket = sSocket.accept();

        }
        catch(IOException sockError)
        {
            System.out.println("socket error: " + sockError);
        }

        
        //CLIENT OBJECT
        KChatClient KChatClient = new KChatClient();
        //PARAMS ARE WHAT IS ENTERED BY THE GUI
        KChatClient.sendMessage("localhost", 1024, "Hello");   
        System.out.println(KChatClient.getMsg(listenSocket));
  
       
        
        
	
    }
    
    
}
