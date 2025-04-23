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

public class ViewAppointment {

    @FXML
    private ComboBox<?> ComboDocId;

    @FXML
    private TableView<?> Table;

    @FXML
    private Button cancelBTN;

    @FXML
    private ComboBox<?> comboPaymentMethod;

    @FXML
    private Label labelPatientName;

    @FXML
    private Label labelPaymentID;

    @FXML
    private Label labelSessionID;

    @FXML
    private Button rescheduleBTN;

    @FXML
    private Button resetBTN;

    @FXML
    private TableColumn<?, ?> tableDocID;

    @FXML
    private TableColumn<?, ?> tablePatientName;

    @FXML
    private TableColumn<?, ?> tablePaymentAmount;

    @FXML
    private TableColumn<?, ?> tablePaymentID;

    @FXML
    private TableColumn<?, ?> tablePaymentMethod;

    @FXML
    private TableColumn<?, ?> tableProgramID;

    @FXML
    private TableColumn<?, ?> tableSessionDate;

    @FXML
    private TableColumn<?, ?> tableSessionID;

    @FXML
    private TableColumn<?, ?> tableSessionNotes;

    @FXML
    private TableColumn<?, ?> tableSessionStatus;

    @FXML
    private TableColumn<?, ?> tableSessionTime;

    @FXML
    private TextField textSessionDate;

    @FXML
    private TextField textSessionTime;

    @FXML
    private TextField txtPaymentAmount;

    @FXML
    private TextField txtSessionNotes;

    @FXML
    void cancelBTNAction(ActionEvent event) {

    }

    @FXML
    void rescheduleBTNAction(ActionEvent event) {

    }

    @FXML
    void resetBTNAction(ActionEvent event) {

    }

    @FXML
    void tableAction(MouseEvent event) {

    }

}