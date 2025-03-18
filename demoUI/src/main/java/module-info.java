module org.example.demoui {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.demoui to javafx.fxml;
    exports org.example.demoui;
}