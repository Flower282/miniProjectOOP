module org.example.loginui2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.loginui2 to javafx.fxml;
    exports org.example.loginui2;
    exports org.example.loginui2.controller;
    opens org.example.loginui2.controller to javafx.fxml;
}