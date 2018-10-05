/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kchatfinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author bw
 */

//Deze server moet geen functies gebruiken van KChatClient maar het over het internet verkrijgen

public class KChatServer {
    
    
    ServerSocket ServerSocket;
    
    //final duznt change fam
    private final int serverPort = 1024;
    
    private void makeServer()
    {
     
        //Open server-socket
        try {
            ServerSocket = new ServerSocket(serverPort);
        }
        catch (IOException err)
        {
            System.out.println(err);
        }
        
        //Accept connection
        Socket clientSocket = null;
        
        try 
        {
           clientSocket = ServerSocket.accept();
        }
        catch (IOException err)
        {
            System.out.println(err);
        }
        
        DataInputStream input;
        DataOutputStream output;
        
        try 
        {
            input = new DataInputStream(clientSocket.getInputStream());
        }
        catch (IOException err)
        {
            System.out.println(err);
        }
        
        
        try 
        {
            output = new DataOutputStream(clientSocket.getOutputStream());
        }
        catch (IOException err)
        {
            System.out.println(err);
        }

    }
    
}
