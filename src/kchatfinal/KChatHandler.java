/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kchatfinal;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Bjorn
 */

public class KChatHandler extends java.lang.Thread {
    
    //psvm
    public static void main(String[] args) {
        //testing local connectivity  
        //start server listener on 6666 and connect to it with the client connection   
        KChatServer server = new KChatServer();
        server.start(6666);
        
        KChatClient client = new KChatClient();
        client.startConnection("localhost", 6666);
        
        
    }
    
    
    
    
    
    
}
