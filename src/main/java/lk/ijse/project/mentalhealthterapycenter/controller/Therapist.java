package lk.ijse.project.mentalhealthterapycenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Therapist {

    @FXML
    private Button delete;

    @FXML
    private ComboBox<?> docAvailableCombo;

    @FXML
    private TextField docContact;

    @FXML
    private Label docIDlabel;

    @FXML
    private TextField docMail;

    @FXML
    private TextField docName;

    @FXML
    private ComboBox<?> docQualificationsCombo;

    @FXML
    private Button reset;

    @FXML
    private Button save;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> tableAvailable;

    @FXML
    private TableColumn<?, ?> tableContact;

    @FXML
    private TableColumn<?, ?> tableId;

    @FXML
    private TableColumn<?, ?> tableMail;

    @FXML
    private TableColumn<?, ?> tableName;

    @FXML
    private TableColumn<?, ?> tableQualifications;

    @FXML
    private Button update;

    @FXML
    private Button viewActivities;

    @FXML
    void TableAction(MouseEvent event) {

    }

    @FXML
    void deleteBtnAction(ActionEvent event) {

    }

    @FXML
    void resetBtnAction(ActionEvent event) {

    }

    @FXML
    void saveBtnAction(ActionEvent event) {

    }

    @FXML
    void updateBtnAction(ActionEvent event) {

    }

    @FXML
    void viewActivitiesBtnAction(ActionEvent event) {

    }

}
