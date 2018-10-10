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

	String testIp;

	public void addIp() {
		testIp = addFriendField.getText();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO

	}

}
