/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kchatfinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author bw
 */
public class KChatClient {
    
    //Creating Socket datatype
    Socket MyClient;
    DataOutputStream output;
    DataInputStream input;
    
    public void clientConnection(String serverIp,int serverPort)
    {
        

        //Make connection w/ server
        try 
        {
            MyClient = new Socket(serverIp, serverPort);
        }
        catch (IOException err) 
        {
            System.out.println(err);
        }

        try
        {
            output = new DataOutputStream(MyClient.getOutputStream());
            input = new DataInputStream(MyClient.getInputStream());
        }
        catch (IOException err)
        {
            System.out.println(err);
        }
        
        
        
        
    }
    
   
    
    
    
}

    
    
    
    
    

