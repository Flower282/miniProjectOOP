package org.example.bluemoon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.bluemoon.model.dao.UserDAO;
import org.example.bluemoon.model.entity.User;
import org.example.bluemoon.security.PasswordUtil;
import org.example.bluemoon.util.HibernateUtil;
import org.example.bluemoon.util.SceneUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label text_empty;
    @FXML
    private Label pass_empty;
    @FXML
    private Label login_failed;
    @FXML
    private Label create_account;
    @FXML
    private Button login_button;

    @FXML
    private void initialize() {
        text_empty.setVisible(false);
        pass_empty.setVisible(false);
        login_failed.setVisible(false);
        create_account.setOnMouseClicked(event -> {
            Stage stage = (Stage) create_account.getScene().getWindow();
            SceneUtil.changeScene(stage, "/org/example/bluemoon/fxml/signup.fxml");
        });

        // Đổi con trỏ chuột thành dạng bàn tay khi di chuột vào label
        create_account.setCursor(Cursor.HAND);
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        text_empty.setVisible(username.isEmpty());
        pass_empty.setVisible(password.isEmpty());
        login_failed.setVisible(false);
        // Nếu bất kỳ ô nào trống, dừng luôn (return)
        if (username.isEmpty() || password.isEmpty()) {
            return;
        }

        try {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.checkLogin(username, password);

            if (user != null) {
                Stage stage = (Stage) login_button.getScene().getWindow();
                SceneUtil.changeScene(stage, "/org/example/bluemoon/fxml/home.fxml");
            } else {
                login_failed.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}