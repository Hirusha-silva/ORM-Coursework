package lk.ijse.project.mentalhealthterapycenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import lk.ijse.project.mentalhealthterapycenter.bo.BOFactory;
import lk.ijse.project.mentalhealthterapycenter.bo.BOType;
import lk.ijse.project.mentalhealthterapycenter.bo.custom.UserBO;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminLogin implements Initializable {

    @FXML
    private CheckBox adminCheckBox;

    @FXML
    private Button adminLogin;

    @FXML
    private PasswordField adminPasswordTextField;

    @FXML
    private TextField adminUserName;

    @FXML
    private Hyperlink forgetPass;

    @Setter
    private String role;

    UserBO userBO = BOFactory.getInstance().getBO(BOType.USER);

    @FXML
    void adminCheckBoxAction(ActionEvent event) {

    }

    @FXML
    void adminLoginAction(ActionEvent event) {

    }

    @FXML
    void forgetPassAction(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        refreshPage();
        SessionHolder.currentRole = role;
    }
}