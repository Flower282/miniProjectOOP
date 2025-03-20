package org.example.bluemoon.controller;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.bluemoon.model.dao.UserDAO;
import org.example.bluemoon.model.entity.Role;
import org.example.bluemoon.model.entity.User;
import org.example.bluemoon.security.PasswordUtil;
import org.example.bluemoon.util.SceneUtil;

public class SignUpController {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField confirmPasswordField;

    @FXML
    private Button signup_button;
    @FXML
    private Label returnLoginLabel;
    @FXML
    private void initialize() {

        returnLoginLabel.setCursor(Cursor.HAND);

    }


    @FXML
    private void returnLogin() {
        Stage stage = (Stage) signup_button.getScene().getWindow();
        SceneUtil.changeScene(stage, "/org/example/bluemoon/fxml/login.fxml");
    }
}