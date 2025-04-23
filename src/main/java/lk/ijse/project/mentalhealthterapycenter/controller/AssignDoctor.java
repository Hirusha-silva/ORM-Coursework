package lk.ijse.project.mentalhealthterapycenter.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import lk.ijse.project.mentalhealthterapycenter.bo.BOFactory;
import lk.ijse.project.mentalhealthterapycenter.bo.BOType;
import lk.ijse.project.mentalhealthterapycenter.bo.custom.TherapistBO;
import lk.ijse.project.mentalhealthterapycenter.dto.TherapistDTO;
import lk.ijse.project.mentalhealthterapycenter.entity.Appointments;
import lombok.Setter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AssignDoctor implements Initializable {

    @FXML
    private Label docAvailable;

    @FXML
    private ComboBox<String> docComboBox;

    @FXML
    private Label docIdFromCombo;

    @FXML
    private Label docNameFromCombo;

    @FXML
    private Label docQualificationsFromCombo;

    @FXML
    private Button select;
    @Setter
    private Appoinment appointmentsController;

    TherapistBO therapistBO = BOFactory.getInstance().getBO(BOType.THERAPIST);

    @FXML
    void selectBtnAction(ActionEvent event) {
        if (appointmentsController != null) {
            String ID = docIdFromCombo.getText();
            String Name = docNameFromCombo.getText();
            String Availability = docAvailable.getText();
            appointmentsController.setAddDoctors(ID, Name, Availability);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            refreshPage();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to load", ButtonType.OK).show();
            throw new RuntimeException(e);
        }
    }
    private void refreshPage() throws Exception {
        docIdFromCombo.setText("");
        docNameFromCombo.setText("");
        docQualificationsFromCombo.setText("");
        docAvailable.setText("");
        load();
    }
    private void load (){
        try {
            List<TherapistDTO> doctors = therapistBO.getDocNames();
            if (doctors == null || doctors.isEmpty()) {
                return;
            }
            ObservableList<String> doctorNames = FXCollections.observableArrayList();
            for (TherapistDTO d : doctors) {
                doctorNames.add(d.getDoctorName());
            }
            if (docComboBox.getItems() == null || !docComboBox.getItems().equals(doctorNames)) {
                Platform.runLater(() -> docComboBox.setItems(doctorNames));
            }
            // Add listener to ComboBox to update labels when a doctor is selected
            docComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    // Find the corresponding DoctorDTO for the selected name
                    TherapistDTO selectedDoctor = findDoctorByName(doctors, newValue);

                    // Update the labels with the doctor information
                    docIdFromCombo.setText(selectedDoctor.getDoctorID());
                    docNameFromCombo.setText(selectedDoctor.getDoctorName());
                    docQualificationsFromCombo.setText(selectedDoctor.getDoctorQualifications());
                    docAvailable.setText(selectedDoctor.getDoctorAvailability());
                    docAvailable.setText(selectedDoctor.getDoctorAvailability());

                    String availability = selectedDoctor.getDoctorAvailability().trim();

                    if (availability.equalsIgnoreCase("Available")) {
                        select.setDisable(false);
                    } else if (availability.equalsIgnoreCase("Not Available")) {
                        select.setDisable(true);
                    }
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private TherapistDTO findDoctorByName(List<TherapistDTO> doctors, String name) {
        for (TherapistDTO doctor : doctors) {
            if (doctor.getDoctorName().equals(name)) {
                return doctor;
            }
        }
        return null;
    }
}