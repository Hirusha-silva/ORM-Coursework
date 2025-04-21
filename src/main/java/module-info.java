module lk.ijse.project.mentalhealthterapycenter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;
    requires net.sf.jasperreports.core;
    requires java.mail;
    requires mysql.connector.j;
    requires jakarta.persistence;
    requires java.naming;
    requires org.hibernate.orm.core;
    requires java.desktop;
    requires spring.security.crypto;
    opens lk.ijse.project.mentalhealthterapycenter.config to jakarta.persistence;
    exports lk.ijse.project.mentalhealthterapycenter.dto to org.hibernate.orm.core;

    opens lk.ijse.project.mentalhealthterapycenter.entity to org.hibernate.orm.core;
    exports lk.ijse.project.mentalhealthterapycenter.entity;

    opens lk.ijse.project.mentalhealthterapycenter to javafx.fxml;
    exports lk.ijse.project.mentalhealthterapycenter;
    exports lk.ijse.project.mentalhealthterapycenter.controller;
    opens lk.ijse.project.mentalhealthterapycenter.controller to javafx.fxml;

}