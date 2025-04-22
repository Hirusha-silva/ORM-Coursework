package lk.ijse.project.mentalhealthterapycenter.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.project.mentalhealthterapycenter.bo.BOFactory;
import lk.ijse.project.mentalhealthterapycenter.bo.BOType;
import lk.ijse.project.mentalhealthterapycenter.bo.custom.PatientBO;
import lk.ijse.project.mentalhealthterapycenter.dto.PatientDTO;
import lk.ijse.project.mentalhealthterapycenter.dto.tm.PatientTm;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class Patients implements Initializable {

    @FXML
    private TextField PDateOfBirth;

    @FXML
    private TextField PName;

    @FXML
    private TextField PatientAddress;

    @FXML
    private TextField PatientContactNO;

    @FXML
    private TextField PatientEmail;

    @FXML
    private ComboBox<String> PatientGender;

    @FXML
    private TextField PatientNic;

    @FXML
    private Button delete;

    @FXML
    private Label loadPatientID;

    @FXML
    private Button save;

    @FXML
    private TableView<PatientTm> table;

    @FXML
    private TableColumn<PatientTm,String> tablePAddress;

    @FXML
    private TableColumn<PatientTm,String> tablePContact;

    @FXML
    private TableColumn<PatientTm,String> tablePDob;

    @FXML
    private TableColumn<PatientTm,String> tablePEmail;

    @FXML
    private TableColumn<PatientTm,String> tablePGender;

    @FXML
    private TableColumn<PatientTm,String> tablePId;

    @FXML
    private TableColumn<PatientTm,String> tablePName;

    @FXML
    private TableColumn<PatientTm,String> tablePNic;

    @FXML
    private Button update;

    @FXML
    private Button viewMedicalHistoryBTN;

    PatientBO patientBO = BOFactory.getInstance().getBO(BOType.PATIENT);

    @FXML
    void deleteAction(ActionEvent event) throws Exception {
        String patientID = loadPatientID.getText();

        if (patientID.isEmpty()) {
            new Alert(Alert.AlertType.CONFIRMATION, " Please select data from table",ButtonType.CLOSE).show();
            return;
        }
        boolean isDeleted = patientBO.deletePatient(patientID);
        if (isDeleted) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Deleted Successfully",ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Deletion Failed",ButtonType.OK).show();
        }
    }

    @FXML
    void saveAction(ActionEvent event) throws Exception {
        String patientID = loadPatientID.getText();
        String patientName = PName.getText();
        String patientBirthDate = PDateOfBirth.getText();
        String patientNIC = PatientNic.getText();
        String patientGender = PatientGender.getValue();
        String patientAddress = PatientAddress.getText();
        String patientPhone = PatientContactNO.getText();
        String patientEmail = PatientEmail.getText();

        if (patientID.isEmpty() || patientName.trim().isEmpty() || patientBirthDate.isEmpty() || patientNIC.isEmpty() || patientGender.trim().isEmpty() || patientAddress.trim().isEmpty()) {
            new Alert(Alert.AlertType.INFORMATION, "Please select data from table",ButtonType.CLOSE).show();
            return;
        }

        PatientDTO patientDTO = new PatientDTO(
                patientID,
                patientName,
                patientBirthDate,
                patientNIC,
                patientGender,
                patientAddress,
                patientPhone,
                patientEmail
        );

        boolean isUpdated = patientBO.savePatient(patientDTO);
        if (isUpdated) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, " Save successfully", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.ERROR, " Save Failed",ButtonType.OK).show();
        }
    }

    @FXML
    void tableAction(MouseEvent event) {
        PatientTm selectedPatient = table.getSelectionModel().getSelectedItem();

        if (selectedPatient != null) {
            loadPatientID.setText(selectedPatient.getPatientID());
            PName.setText(selectedPatient.getPatientName());
            PDateOfBirth.setText(selectedPatient.getPatientBirthDate());
            PatientNic.setText(selectedPatient.getPatientNIC());
            PatientGender.setValue(selectedPatient.getPatientGender());
            PatientAddress.setText(selectedPatient.getPatientAddress());
            PatientContactNO.setText(selectedPatient.getPatientPhone());
            PatientEmail.setText(selectedPatient.getPatientEmail());

        }
    }

    @FXML
    void updateAction(ActionEvent event) throws Exception {
        String patientID = loadPatientID.getText();
        String patientName = PName.getText();
        String patientBirthDate = PDateOfBirth.getText();
        String patientNIC = PatientNic.getText();
        String patientGender = PatientGender.getValue();
        String patientAddress = PatientAddress.getText();
        String patientPhone = PatientContactNO.getText();
        String patientEmail = PatientEmail.getText();

        if (patientID.isEmpty() || patientName.trim().isEmpty() || patientBirthDate.isEmpty() || patientNIC.isEmpty() || patientGender.trim().isEmpty() || patientAddress.trim().isEmpty()) {
            new Alert(Alert.AlertType.INFORMATION, "Please select data from table",ButtonType.CLOSE).show();
            return;
        }

        PatientDTO patientDTO = new PatientDTO(
                patientID,
                patientName,
                patientBirthDate,
                patientNIC,
                patientGender,
                patientAddress,
                patientPhone,
                patientEmail
        );

        boolean isUpdated = patientBO.updatePatient(patientDTO);
        if (isUpdated) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "PatientDAOImpl updated successfully", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.ERROR, "PatientDAOImpl updated Failed",ButtonType.OK).show();
        }
    }

    @FXML
    void viewMedicalHistoryBTNAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tablePId.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        tablePName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        tablePDob.setCellValueFactory(new PropertyValueFactory<>("patientBirthDate"));
        tablePNic.setCellValueFactory(new PropertyValueFactory<>("patientNIC"));
        tablePGender.setCellValueFactory(new PropertyValueFactory<>("patientGender"));
        tablePAddress.setCellValueFactory(new PropertyValueFactory<>("patientAddress"));
        tablePContact.setCellValueFactory(new PropertyValueFactory<>("patientPhone"));
        tablePEmail.setCellValueFactory(new PropertyValueFactory<>("patientEmail"));
        try {
            refreshPage();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, " Failed ").show();
            throw new RuntimeException(e);
        }
    }

    private void refreshPage() throws Exception {
        loadTableData();
        loadPatientID.setText(patientBO.getNextPatientID());
        PName.clear();
        PDateOfBirth.clear();
        PatientNic.clear();
        PatientGender.setItems(FXCollections.observableArrayList("Male", "Female"));
        PatientAddress.clear();
        PatientContactNO.clear();
        PatientEmail.clear();
    }
    private void loadTableData() throws Exception {

        List<PatientDTO> patientDTOS = patientBO.getALL();
        ObservableList<PatientTm> patientTMS = FXCollections.observableArrayList();

        for (PatientDTO patientDTO : patientDTOS) {
            PatientTm patientTM = new PatientTm(
                    patientDTO.getPatientID(),
                    patientDTO.getPatientName(),
                    patientDTO.getPatientBirthDate(),
                    patientDTO.getPatientNIC(),
                    patientDTO.getPatientGender(),
                    patientDTO.getPatientAddress(),
                    patientDTO.getPatientPhone(),
                    patientDTO.getPatientEmail()

            );
            patientTMS.add(patientTM);
        }

        table.setItems(patientTMS);
    }
}
