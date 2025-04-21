package lk.ijse.project.mentalhealthterapycenter.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Setter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainLayout implements Initializable {

    @FXML
    private Button addMember;

    @FXML
    private VBox adminVbox;

    @FXML
    private Button appointments;

    @FXML
    private AnchorPane loadAnchor;

    @FXML
    private Button patients;

    @FXML
    private Button payments;

    @FXML
    private Button signOutButton;

    @FXML
    private Button therapist;

    @FXML
    private Button therapyPrograms;
    @FXML
    private ImageView image;

    @FXML
    private VBox vbox;

    private String role;

    @Setter
    private String userName;

    @FXML
    void addMemberAction(MouseEvent event) throws IOException {
        loadPage("register.fxml");
    }

    @FXML
    void appointmentsAction(MouseEvent event) {

    }

    @FXML
    void doctorDetailsAction(MouseEvent event) {

    }

    @FXML
    void patientsAction(MouseEvent event) {

    }

    @FXML
    void paymentsAction(MouseEvent event) {

    }

    @FXML
    void signOutButtonAction(MouseEvent event) throws IOException {
        loadPage("/view/login.fxml");
    }

    @FXML
    void therapyProgramAction(MouseEvent event) {

    }

    public void setUserRole(String role) {
        this.role = role;
        configureUI();
    }
    private void configureUI() {
        if ("admin".equals(role)) {
            adminVbox.setVisible(true);
        } else {
            adminVbox.setDisable(true);
        }
    }

    private void loadPage(String fxmlPath) throws IOException {
        Stage currentStage = new Stage();
        currentStage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource(fxmlPath)));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("The Mental Health Therapy Center");
        stage.show();
    }

    private void refreshPage(){
        String s = SessionHolder.userName;
        //navigateTo("/view/appointments.fxml");
    }

    public void navigateTo(String fxmlPath) {
        try {
            loadAnchor.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource(fxmlPath));
            load.prefWidthProperty().bind(loadAnchor.widthProperty());
            load.prefHeightProperty().bind(loadAnchor.heightProperty());
            loadAnchor.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load page!").show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            refreshPage();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}