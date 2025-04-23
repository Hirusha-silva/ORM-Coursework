package lk.ijse.project.mentalhealthterapycenter.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.project.mentalhealthterapycenter.bo.BOFactory;
import lk.ijse.project.mentalhealthterapycenter.bo.BOType;
import lk.ijse.project.mentalhealthterapycenter.bo.custom.PatientBO;
import lk.ijse.project.mentalhealthterapycenter.dto.PatientsInEveryProgramDTO;
import lk.ijse.project.mentalhealthterapycenter.dto.tm.PatientInEveryProgramTm;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PatientsAllPrograms implements Initializable {

    @FXML
    private TableView<PatientInEveryProgramTm> Table;

    @FXML
    private TableColumn<String,PatientInEveryProgramTm> tableAddress;

    @FXML
    private TableColumn<String,PatientInEveryProgramTm> tableContact;

    @FXML
    private TableColumn<String, PatientInEveryProgramTm> tableID;

    @FXML
    private TableColumn<String,PatientInEveryProgramTm> tableName;

    PatientBO patientBO = BOFactory.getInstance().getBO(BOType.PATIENT);
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableID.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        tableAddress.setCellValueFactory(new PropertyValueFactory<>("patientAddress"));
        tableContact.setCellValueFactory(new PropertyValueFactory<>("patientContact"));

        try {
            loadTable();
        } catch (RuntimeException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
            throw new RuntimeException(e);
        }
    }
    private void loadTable() throws RuntimeException {
        List<PatientsInEveryProgramDTO> patientsInEveryProgramDTOS = patientBO.getPatientsInEveryProgram();

        ObservableList<PatientInEveryProgramTm> patientsInEveryProgramTMS = FXCollections.observableArrayList();

        for (PatientsInEveryProgramDTO patients : patientsInEveryProgramDTOS) {
            PatientInEveryProgramTm patientsInEveryProgramTM = new PatientInEveryProgramTm(
                    patients.getPatientId(),
                    patients.getPatientName(),
                    patients.getPatientAddress(),
                    patients.getPatientContact()
            );
            patientsInEveryProgramTMS.add(patientsInEveryProgramTM);
        }

        Table.setItems(patientsInEveryProgramTMS);
    }
}