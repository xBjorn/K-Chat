package com.mycompany.k.chat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
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

    String testIp;

    public void addIp() {
        testIp = addFriendField.getText();
    }

    public void sendMessage() {
        KChatClient kchat = new KChatClient(testIp,6666,chatField.getText());
        kchat.start();
        chatField.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //start server if login ok
        KChatServer servertje = new KChatServer();
        servertje.start();
        

    }

}
