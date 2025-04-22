package lk.ijse.project.mentalhealthterapycenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class TherapyPrograms {

    @FXML
    private TextField ProgramDetails;

    @FXML
    private TextField ProgramFee;

    @FXML
    private TextField ProgramName;

    @FXML
    private TableView<?> Table;

    @FXML
    private Button delete;

    @FXML
    private Label labelLoadID;

    @FXML
    private Button reset;

    @FXML
    private Button save;

    @FXML
    private TableColumn<?, ?> tableFee;

    @FXML
    private TableColumn<?, ?> tableIID;

    @FXML
    private TableColumn<?, ?> tableName;

    @FXML
    private TableColumn<?, ?> tableProgramDetails;

    @FXML
    private Button update;

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
    void tableAction(MouseEvent event) {

    }

    @FXML
    void updateBtnAction(ActionEvent event) {

    }

}