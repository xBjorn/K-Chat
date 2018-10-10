/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kchatfinal;


/**
 *
 * @author Bjorn
 */

public class KChatHandler extends java.lang.Thread {
    
    //psvm
    public static void main(String[] args) {
        
        
        //testing local connectivity  
        //start server listener on 6666 and connect to it with the client connection   
        KChatClient client = new KChatClient();
        KChatServer server = new KChatServer();
        //on program load start the server to listen for messages?
        server.start(6666);
        //receive input from the textfield in the gui
        client.sendMessage(KChat-gui.txtTxtbox.Text.ToString());
        //start outgoing connection when pressed on button send
        client.startConnection(txtIp, txtPort); //als ie opgeslagen is in txt als contact ofzo
        
        
    }
    
    
    
    
    
    
}
