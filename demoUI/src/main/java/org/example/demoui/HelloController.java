package org.example.demoui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void LoginButton() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}