package lk.ijse.project.mentalhealthterapycenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.project.mentalhealthterapycenter.bo.BOFactory;
import lk.ijse.project.mentalhealthterapycenter.bo.BOType;
import lk.ijse.project.mentalhealthterapycenter.bo.custom.UserBO;
import lombok.Setter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserLogin implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Hyperlink forgetPass;

    @FXML
    private Button login;

    @FXML
    private TextField passwordTextField;

    @FXML
    private PasswordField passwordPWField;

    @FXML
    private CheckBox showPasswordcheckBox;

    @FXML
    private TextField userName;

    @Setter
    private String role;

    @FXML
    private ImageView image;

    UserBO userBO = BOFactory.getInstance().getBO(BOType.USER);
    @FXML
    void forgetPassAction(MouseEvent event) throws IOException {
        loadNewPage("/view/forgetPassword.fxml","user");
        SessionHolder.currentRole = role;
    }

    @FXML
    void loginAction(ActionEvent event) throws IOException {
        String username = userName.getText();
        String password = passwordPWField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter your username and password", ButtonType.OK).show();
            return;
        }

        String role1 = SessionHolder.currentRole;
        boolean userFromDB = userBO.findUser(username);
        String passFromDB = userBO.findPassWord(username,role1);

        if (userFromDB && PasswordUtil.matches(password, passFromDB)) {
            SessionHolder.userName = username;
            navigateToMainPage("/view/main-layout.fxml", "user", username,event);
        } else {
            new Alert(Alert.AlertType.ERROR, "Login Failed..", ButtonType.OK).show();
        }
    }

    private  void  loadNewPage(String fxmlPath,String role) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        FogetPassword fg = loader.getController();
        fg.setRole(role);
        SessionHolder.currentRole = role;
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Change Password -  Mental Health Therapy Center");
        stage.show();
    }

    @FXML
    void showPasswordcheckBox(ActionEvent event) {
        if (showPasswordcheckBox.isSelected()) {
            passwordPWField.setVisible(false);
            passwordTextField.setVisible(true);
            passwordTextField.setText(passwordPWField.getText());
        }else {
            passwordPWField.setVisible(true);
            passwordTextField.setVisible(false);
            passwordPWField.setText(passwordTextField.getText());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refreshPage();
        SessionHolder.currentRole = role;
    }
    private void navigateToMainPage(String fxmlPath,String role,String userName,ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Scene scene = new Scene(loader.load());
        MainLayout controller = loader.getController();
        controller.setUserRole(role);
        controller.setUserName(userName);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("The Serenity Mental Health Therapy Center");
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        stage.show();
    }
    private void refreshPage(){
        passwordPWField.setVisible(true);
        passwordTextField.setVisible(false);
    }
}