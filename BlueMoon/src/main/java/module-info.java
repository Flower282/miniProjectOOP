module org.example.bluemoon {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires org.hibernate.orm.core;
    requires org.postgresql.jdbc;
    requires java.naming;
    requires jakarta.xml.bind;
    requires jakarta.persistence;
    requires org.slf4j;
    requires de.mkammerer.argon2.nolibs;

    // Mở package entity cho Hibernate
    opens org.example.bluemoon.model.entity to org.hibernate.orm.core;
    exports org.example.bluemoon.controller;
    exports org.example.bluemoon;
    opens org.example.bluemoon.controller to javafx.fxml;
}