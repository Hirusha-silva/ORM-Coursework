package lk.ijse.project.mentalhealthterapycenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class AssignDoctor {

    @FXML
    private Label docAvailable;

    @FXML
    private ComboBox<?> docComboBox;

    @FXML
    private Label docIdFromCombo;

    @FXML
    private Label docNameFromCombo;

    @FXML
    private Label docQualificationsFromCombo;

    @FXML
    private Button select;

    @FXML
    void selectBtnAction(ActionEvent event) {

    }

}