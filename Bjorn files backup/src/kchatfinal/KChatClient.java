package kchatfinal;

import java.net.*;
import java.io.*;

public class KChatClient extends Thread {
        
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    
    public void startConnection(String ip, int port) {
        try{
        clientSocket = new Socket(ip,port);
        out = new PrintWriter(clientSocket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }
        catch(IOException sweetError )
        {
            System.out.println("failed to create clientsocket?: " + sweetError);
        }
    }
    
    public String sendMessage(String msg)
    {
        
        
        String resp = "";
        out.println(msg);
        try{
            resp = in.readLine();
        }
        catch(IOException sweetError)
        {
            out.println("cant read server msg" +sweetError);
        }
        return resp;
        
    }
    
    public void stopConnection() {
        try{
            in.close();
            out.close();
            clientSocket.close();
        }
        catch(IOException sweetError)
        {
            out.println("cant close the reader or socket? " + sweetError);
            
        }
            
    }
    
    
    
    
        
     
    
    
}

    