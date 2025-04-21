package lk.ijse.project.mentalhealthterapycenter.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML
    private ImageView admin;

    @FXML
    private ImageView user;

    @FXML
    private ImageView imageBG;

    @FXML
    void adminAction(MouseEvent event) throws IOException {
        loadPage("/view/admin-login.fxml","ADMIN");
    }

    @FXML
    void userAction(MouseEvent event) throws IOException {
        loadPage("/view/user_login.fxml","USER");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image adminIMage = new Image(getClass().getResourceAsStream("/images/admin.png"));
        admin.setImage(adminIMage);
        Image userImage = new Image(getClass().getResourceAsStream("/images/user.png"));
        user.setImage(userImage);

        Image image = new Image(getClass().getResourceAsStream("/images/pngtree-simple-medical-protection-prevention-and-control-prevention-hospital-bulletin-board-theme-image_1513799 (1).jpg"));
        imageBG.setImage(image);
        imageBG.setId("bgImage");
    }

    private void loadPage(String fxmlPath,String role) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        if (role.equals("ADMIN")) {
            AdminLogin controller = loader.getController();
            controller.setRole(role);
            SessionHolder.currentRole = role;
        } else if (role.equals("USER")) {
            UserLogin controller = loader.getController();
            controller.setRole(role);
            SessionHolder.currentRole = role;
        }
        Stage stage = (Stage) admin.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("The Mental Health Therapy Center");
        stage.show();
    }
}
