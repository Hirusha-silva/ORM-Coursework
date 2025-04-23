package lk.ijse.project.mentalhealthterapycenter.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import lk.ijse.project.mentalhealthterapycenter.bo.BOFactory;
import lk.ijse.project.mentalhealthterapycenter.bo.BOType;
import lk.ijse.project.mentalhealthterapycenter.bo.custom.AppointmentBO;
import lk.ijse.project.mentalhealthterapycenter.dto.PaymentDTO;
import lk.ijse.project.mentalhealthterapycenter.dto.ProgramDetailsDTO;
import lk.ijse.project.mentalhealthterapycenter.dto.SessionDTO;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class Appoinment implements Initializable {

    @FXML
    private Button addAppointmentBTN;

    @FXML
    private Button addDoctors;

    @FXML
    private Button addPrograms;

    @FXML
    private Label date;

    @FXML
    private Label docLoadLabel;

    @FXML
    private Label patientAddress;

    @FXML
    private Label patientDOB;

    @FXML
    private Label patientEMAIL;

    @FXML
    private Label patientGender;

    @FXML
    private Label patientID;

    @FXML
    private Label patientNIC;

    @FXML
    private Label patientName;

    @FXML
    private AnchorPane appointmentPage;

    @FXML
    private Label patientTelNO;

    @FXML
    private TextField payAMOUNT;

    @FXML
    private Label paymentID;

    @FXML
    private ComboBox<String> paymentMethod;

    @FXML
    private Button printBillBTN;

    @FXML
    private ListView<String> programmsListView;

    @FXML
    private Button reset;

    @FXML
    private TextField search;

    @FXML
    private Button searchPatient;

    @FXML
    private DatePicker sessionDate;

    @FXML
    private Label sessionID;

    @FXML
    private TextField sessionNotes;

    @FXML
    private TextField sessionTime;

    @FXML
    private Label time;

    @FXML
    private VBox vbox1;

    @FXML
    private VBox vbox2;

    private String ProgramID;

    private  String DocID;

    private String availability;

    @FXML
    private Button viewAppointmentsBTN;

    private Set<String> programIDs = new HashSet<>();

    public void setDetails(String programID, String programName) {
        ProgramID = programID;
        if (programID != null && programName != null) {
            programmsListView.getItems().add(programID + " - " + programName);
        }
    }
    public void setAddDoctors(String docID, String docName,String availability) {
        DocID = docID;
        if (docID != null && docName != null) {
            docLoadLabel.setText(docID + " - " + docName + " - " + availability);
        }
    }

    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    AppointmentBO appointmentBO = BOFactory.getInstance().getBO(BOType.APPOINTMENT);

    @FXML
    void addAppointmentBTNAction(ActionEvent event) {
        String patientId = patientID.getText();
        String patientNAME = patientName.getText();
        String sessionId = sessionID.getText();
        String sessionTIME =  sessionTime.getText();
        String sessionNOTES = sessionNotes.getText();
        String sessionDATE = sessionDate.getEditor().getText();
        String doctorIDFromLabel = docLoadLabel.getText();
        String docID = null; /*this id is pass through sessionDTO*/

        String[] parts = doctorIDFromLabel.split(" - ");
        if (parts.length > 0) {
            docID = parts[0];  // First part is docID , get id from the full label
        }

        String paymentId = paymentID.getText();
        Double payAmount = Double.valueOf(payAMOUNT.getText());
        String paymentMETHOD = paymentMethod.getSelectionModel().getSelectedItem();
        String paymentDate = LocalDate.now().format(formatter);
        String paymentTime = LocalTime.now().format(timeFormatter);

        programmsListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<String> selectedPrograms = programmsListView.getItems();
        programIDs.clear();

        for (String program : selectedPrograms) {
            if (program.contains(" - ")) {
                String programID = program.split(" - ")[0];
                programIDs.add(programID);
            } else {
                System.out.println("Error: Invalid format for program item! " + program);
            }
        }
        ProgramDetailsDTO programDetailsDTO = new ProgramDetailsDTO(
                patientId,
                new ArrayList<>(programIDs)  /*List required as one patient can choose more than one programs*/

        );

        SessionDTO sessionDTO = new SessionDTO(
                sessionId,
                patientId,
                docID, /*don't need a list here,took from label splitting the first part*/
                sessionTIME,
                sessionNOTES,
                sessionDATE
        );
        PaymentDTO paymentDTO = new PaymentDTO(
                paymentId,
                patientNAME,
                payAmount,
                paymentMETHOD,
                paymentDate,
                paymentTime
        );

        boolean isSaved = appointmentBO.addAppointment(programDetailsDTO,sessionDTO,paymentDTO);
        if (isSaved) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Appointment added", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Failed! Appointment not added", ButtonType.OK).show();
        }
    }

    @FXML
    void addDoctorsAction(MouseEvent event) {

    }

    @FXML
    void addProgramsAction(MouseEvent event) {

    }

    @FXML
    void printBillBTNAction(ActionEvent event) {

    }

    @FXML
    void resetAction(ActionEvent event) {

    }

    @FXML
    void searchPatientAction(MouseEvent event) {

    }

    @FXML
    void viewAppointmentsBTNAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateDateTime();
        try{
            refreshPage();
        }catch(Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to load the Page",ButtonType.CLOSE).show();
        }
    }
    private void updateDateTime() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    String currentTime = LocalTime.now().format(timeFormatter);
                    time.setText(currentTime);
                    String currentDate = LocalDate.now().format(formatter);
                    date.setText(currentDate);
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    private void refreshPage(){
        generateNextAppointmentID();
        generateNextPatientID();
        generateNextPaymentID();
        search.clear();
        paymentMethod.getItems().clear();
        paymentMethod.setItems(FXCollections.observableArrayList("Card Payment", "Cash Payment"));
        sessionTime.clear();
        sessionNotes.clear();
        sessionDate.setValue(null);
        payAMOUNT.clear();
        docLoadLabel.setText("");
        docLoadLabel.setDisable(true);
        programmsListView.refresh();
        programmsListView.getItems().clear();
        vbox1.setVisible(false);
        vbox2.setVisible(false);
    }
    private void generateNextAppointmentID() {
        String nextAptID =appointmentBO.getNextSessionID();
        sessionID.setText(nextAptID);
    }
    private void generateNextPatientID() {
        String nextPatientId = appointmentBO.getNextPatientID();
        patientID.setText(nextPatientId);
    }
    private void generateNextPaymentID() {
        String nextPaymentID = appointmentBO.getNextPaymentID();
        paymentID.setText(nextPaymentID);
    }
    public void navigateTo(String fxmlPath) {
        try {
            appointmentPage.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource(fxmlPath));
            load.getStylesheets().add(getClass().getResource("/css/h.css").toExternalForm());
            load.prefWidthProperty().bind(appointmentPage.widthProperty());
            load.prefHeightProperty().bind(appointmentPage.heightProperty());
            appointmentPage.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load page!").show();
        }
    }
}