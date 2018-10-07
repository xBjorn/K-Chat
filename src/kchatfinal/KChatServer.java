/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kchatfinal;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author bw
 */

//Deze server moet geen functies gebruiken van KChatClient maar het over het internet verkrijgen

public class KChatServer {
    
        public void listener()
        {
        //nagging about possiblity of empty return value so we make it null
        String recv = null;

        try{
            //setup server
            ServerSocket sSocket = new ServerSocket(1024);
            
            //listens for a connection to be made and accepts it
            Socket listenSocket = sSocket.accept();
            
            
            DataInputStream receive = new DataInputStream(listenSocket.getInputStream());

       
            
            //convert accepted socket connection to utf
            recv = receive.readUTF();
            
            
            receive.close();
            listenSocket.close();
            sSocket.close();
            
            
    
        }
        catch(IOException e)
        {
            System.out.println("getMsg: " + e);
        }
        
        
        
    }
}
