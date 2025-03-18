package org.example.loginui2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
    public class Main extends javafx.application.Application {
        private static Stage primaryStage;
        @Override
        public void start(Stage stage) throws IOException {
            primaryStage = stage;
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Quản lý dữ liệu dân cư");
            stage.setScene(scene);
            stage.show();
        }

        public static void changeScene(String fxml) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch();
        }
    }

