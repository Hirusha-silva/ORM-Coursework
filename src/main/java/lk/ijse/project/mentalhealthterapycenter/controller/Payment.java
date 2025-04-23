package lk.ijse.project.mentalhealthterapycenter.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Payment {

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> tablePayAmount;

    @FXML
    private TableColumn<?, ?> tablePayDate;

    @FXML
    private TableColumn<?, ?> tablePayID;

    @FXML
    private TableColumn<?, ?> tablePayMethod;

    @FXML
    private TableColumn<?, ?> tablePayTime;

    @FXML
    private TableColumn<?, ?> tablePayerName;

}