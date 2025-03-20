package org.example.bluemoon.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.bluemoon.model.entity.User;
import org.example.bluemoon.util.HibernateUtil;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class InformationController implements Initializable {
    @FXML
    private TableView<User> userTable;
    @FXML
    private TableColumn<User, Long> idColumn;
    @FXML
    private TableColumn<User, String> nameColumn;
    @FXML
    private TableColumn<User, String> roleColumn;
    @FXML
    private ImageView home_img;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configure table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

        // Load user data
        loadUserData();
    }

    private void loadUserData() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<User> users = session.createQuery("from User", User.class).list();
            userTable.getItems().setAll(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void home() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/bluemoon/fxml/home.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) home_img.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void logout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/bluemoon/fxml/login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) home_img.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}