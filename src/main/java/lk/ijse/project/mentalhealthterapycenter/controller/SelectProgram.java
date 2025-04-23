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
import lk.ijse.project.mentalhealthterapycenter.bo.custom.TherapyProgramBO;
import lk.ijse.project.mentalhealthterapycenter.dto.TherapyProgramDTO;
import lk.ijse.project.mentalhealthterapycenter.dto.tm.ProgramTm;
import lk.ijse.project.mentalhealthterapycenter.dto.tm.TherapyProgramTm;
import lombok.Setter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SelectProgram implements Initializable {

    @FXML
    private TableView<ProgramTm> Table;

    @FXML
    private Label idLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Button select;

    @FXML
    private TableColumn<TherapyProgramTm, Double> tableFee;

    @FXML
    private TableColumn<TherapyProgramTm, String> tableIID;

    @FXML
    private TableColumn<TherapyProgramTm, String> tableName;

    @FXML
    private TableColumn<TherapyProgramTm, String> tableProgramDetails;

    @Setter
    private Appoinment appointmentsController;

    TherapyProgramBO tProgramBO = BOFactory.getInstance().getBO(BOType.THERAPY_PROGRAMS);

    @FXML
    void selectBtnAction(ActionEvent event) {
        String ID = idLabel.getText();
        String Name = nameLabel.getText();
        if (appointmentsController != null) {
            appointmentsController.setDetails(ID, Name);
        }
    }

    @FXML
    void tableAction(MouseEvent event) {
        ProgramTm selectedPatient = Table.getSelectionModel().getSelectedItem();

        if (selectedPatient != null) {
            idLabel.setText(selectedPatient.getTherapyID());
            nameLabel.setText(selectedPatient.getTherapyName());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tableIID.setCellValueFactory(new PropertyValueFactory<>("therapyID"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("therapyName"));
        tableProgramDetails.setCellValueFactory(new PropertyValueFactory<>("therapyDescription"));
        tableFee.setCellValueFactory(new PropertyValueFactory<>("therapyFee"));

        try {
            loadTable();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to Load Page", ButtonType.OK).show();
        }
    }
    private void loadTable() throws Exception {
        List<TherapyProgramDTO> therapyProgramDTOS =  tProgramBO.getALLTPrograms();
        ObservableList<ProgramTm> tProgramTMS = FXCollections.observableArrayList();
        for (TherapyProgramDTO programDto : therapyProgramDTOS) {
            ProgramTm programTM = new ProgramTm(
                    programDto.getTherapyID(),
                    programDto.getTherapyName(),
                    programDto.getTherapyDescription(),
                    programDto.getTherapyFee()
            );
            tProgramTMS.add(programTM);
        }
        Table.setItems(tProgramTMS);
    }
}