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
import lk.ijse.project.mentalhealthterapycenter.dto.tm.TherapyProgramTm;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TherapyPrograms implements Initializable {

    @FXML
    private TextField ProgramDetails;

    @FXML
    private TextField ProgramFee;

    @FXML
    private TextField ProgramName;

    @FXML
    private TableView<TherapyProgramTm> Table;

    @FXML
    private Button delete;

    @FXML
    private Label labelLoadID;

    @FXML
    private Button reset;

    @FXML
    private Button save;

    @FXML
    private TableColumn<TherapyProgramTm,Double> tableFee;

    @FXML
    private TableColumn<TherapyProgramTm, String> tableIID;

    @FXML
    private TableColumn<TherapyProgramTm,String> tableName;

    @FXML
    private TableColumn<TherapyProgramTm,String> tableProgramDetails;

    @FXML
    private Button update;

    TherapyProgramBO tProgramBO = BOFactory.getInstance().getBO(BOType.THERAPY_PROGRAMS);

    @FXML
    void deleteBtnAction(ActionEvent event) throws Exception {
        String programID = labelLoadID.getText();
        boolean isDeleted = tProgramBO.deleteTProgram(programID);
        if (isDeleted) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Programs Deleted").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Programs Not Deleted").show();
        }
    }

    @FXML
    void resetBtnAction(ActionEvent event) throws Exception {
        refreshPage();
    }

    @FXML
    void saveBtnAction(ActionEvent event) throws Exception {
        String therapyPID = labelLoadID.getText();
        String therapyProgramName = ProgramName.getText();
        String therapyProgramDetails = ProgramDetails.getText();
        Double therapyProgramFee = Double.parseDouble(ProgramFee.getText());


        TherapyProgramDTO therapyProgramDTO = new TherapyProgramDTO(
                therapyPID,
                therapyProgramName,
                therapyProgramDetails,
                therapyProgramFee
        );
        boolean isSaved = tProgramBO.saveTPrograms(therapyProgramDTO);

        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Therapy Program Saved").show();
            refreshPage();
        }else {
            new Alert(Alert.AlertType.ERROR, "Therapy Program Not Saved").show();
        }
    }

    @FXML
    void tableAction(MouseEvent event) {
        TherapyProgramTm selectedPatient = Table.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {
            labelLoadID.setText(selectedPatient.getTherapyID());
            ProgramName.setText(selectedPatient.getTherapyName());
            ProgramDetails.setText(selectedPatient.getTherapyDescription());
            ProgramFee.setText(String.valueOf(selectedPatient.getTherapyFee()));
        }
    }

    @FXML
    void updateBtnAction(ActionEvent event) throws Exception {
        String therapyPID = labelLoadID.getText();
        String therapyProgramName = ProgramName.getText();
        String therapyProgramDetails = ProgramDetails.getText();
        Double therapyProgramFee = Double.parseDouble(ProgramFee.getText());

        TherapyProgramDTO therapyProgramDTO = new TherapyProgramDTO(
                therapyPID,
                therapyProgramName,
                therapyProgramDetails,
                therapyProgramFee
        );
        boolean isUpdated = tProgramBO.updateTPrograms(therapyProgramDTO);

        if (isUpdated) {
            new Alert(Alert.AlertType.INFORMATION, "Therapy Programs updated successfully").show();
            refreshPage();
        }else {
            new Alert(Alert.AlertType.ERROR, "Therapy Programs updating Failed").show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableIID.setCellValueFactory(new PropertyValueFactory<>("therapyID"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("therapyName"));
        tableProgramDetails.setCellValueFactory(new PropertyValueFactory<>("therapyDescription"));
        tableFee.setCellValueFactory(new PropertyValueFactory<>("therapyFee"));

        try{
            refreshPage();
        }catch(Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to Load the Page", ButtonType.OK).show();
        }
    }

    private void refreshPage() throws Exception {
        loadTable();
        labelLoadID.setText(tProgramBO.getNextProgramID());
        ProgramName.clear();
        ProgramDetails.clear();
        ProgramFee.clear();
    }

    private void loadTable() throws Exception {
        List<TherapyProgramDTO> programDtos =  tProgramBO.getALL();
        ObservableList<TherapyProgramTm> programTMS = FXCollections.observableArrayList();
        for (TherapyProgramDTO programDto : programDtos) {

            TherapyProgramTm programTM = new TherapyProgramTm(
                    programDto.getTherapyID(),
                    programDto.getTherapyName(),
                    programDto.getTherapyDescription(),
                    programDto.getTherapyFee()
            );
            programTMS.add(programTM);
        }
        Table.setItems(programTMS);
    }
}