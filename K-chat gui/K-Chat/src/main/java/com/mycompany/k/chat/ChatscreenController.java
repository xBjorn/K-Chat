package com.mycompany.k.chat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author yukming
 */
public class ChatscreenController implements Initializable {

    @FXML
    private TextField addFriendField;
    @FXML
    private TextField chatField;

    public String testIp;
    InetAddress a;

    public void addIp() {
        testIp = addFriendField.getText();
    }

    public void sendMessage() throws UnknownHostException, Exception {
        String msg = chatField.getText();
        a = InetAddress.getByName(testIp);
        KChatClient client = new KChatClient(a, 12001);
        client.sent(msg);
        chatField.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //start server if login ok
        KChatServer servertje = new KChatServer();
        servertje.start();

    }

}
