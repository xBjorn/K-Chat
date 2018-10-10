package com.mycompany.k.chat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StartscreenController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField usernameField;

    @FXML
    private void logIn(ActionEvent event) throws UnknownHostException, FileNotFoundException, IOException {

        // Returns the instance of InetAddress containing 
        // local host name and address 
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("System IP Address : "
                + (localhost.getHostAddress()).trim());

        // Find public IP address 
        String systemipaddress = "";
        try {
            URL url_name = new URL("http://bot.whatismyipaddress.com");

            BufferedReader sc
                    = new BufferedReader(new InputStreamReader(url_name.openStream()));

            // reads system IPAddress 
            systemipaddress = sc.readLine().trim();
        } catch (IOException e) {
            systemipaddress = "Cannot Execute Properly";
        }
        String publicIp = systemipaddress;
        System.out.println(publicIp);
        String username = usernameField.getText();
        File file = new File("account.txt");
        PrintWriter writer;
        writer = new PrintWriter(file);
        writer.write(publicIp + "," + username);
        writer.close();
        System.out.println("Logging in: " + publicIp + " as " + username);

        //Changes scene
        Parent chatscreenParent = FXMLLoader.load(getClass().getResource("/fxml/Chatscreen.fxml"));
        Scene chatScene = new Scene(chatscreenParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(chatScene);
        window.show();

    }

    /*  public void changeScreen(ActionEvent event) throws IOException {
        Parent chatscreenParent = FXMLLoader.load(getClass().getResource("/fxml/Chatscreen.fxml"));
        Scene chatScene = new Scene(chatscreenParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(chatScene);
        window.show();
    }*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file = new File("account.txt");
        PrintWriter writer;
        if (file.exists()) {
            System.out.println("logging in");

        }

    }
}
