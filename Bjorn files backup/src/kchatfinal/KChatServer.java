package kchatfinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Bjorn
 */
public class KChatServer {


    public void run() {
        try {
            //Make server socket
            int serverPort = 6666;
            ServerSocket serverSocket = new ServerSocket(serverPort);
            serverSocket.setSoTimeout(10000);
            
            while(true){
                System.out.println("Waiting for client in port.." + serverSocket.getLocalPort());
                Socket server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                
                //client writer
                PrintWriter toClient =
                        new PrintWriter(server.getOutputStream(),true);
                
                //read from client
                BufferedReader fromClient = 
                        new BufferedReader(
                                        new InputStreamReader(server.getInputStream()));
                
                
                //read line from the received msg
                String line = fromClient.readLine();
                System.out.println("Server received: " + line);
                
                //write back to the client with PrintWriter
                toClient.println("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
            
            }
        }
        catch(UnknownHostException ex){
            ex.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        KChatServer srv = new KChatServer();
        
        //run object as a thread
        srv.run(); 
    }
    
}
