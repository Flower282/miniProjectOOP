package org.example.loginui2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.loginui2.Main;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label failedLoginText;

    @FXML
    public void initialize() {
        failedLoginText.setVisible(false);
    }
    @FXML
    private TextField textField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    public void loginButtonAction(ActionEvent event) throws IOException {
        handleLogin();
    }
    public void handleLogin() throws IOException {

        String username = textField.getText();
        String password = passwordField.getText();
        if(username.equals("admin") && password.equals("123456")){
            System.out.println("Login success");
            Main.changeScene("application-view.fxml");
        }
        failedLoginText.setVisible(true);
    }
}