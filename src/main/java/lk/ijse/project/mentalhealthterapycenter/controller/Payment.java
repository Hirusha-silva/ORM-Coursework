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
import lk.ijse.project.mentalhealthterapycenter.bo.custom.PaymentBO;
import lk.ijse.project.mentalhealthterapycenter.dto.PaymentDTO;
import lk.ijse.project.mentalhealthterapycenter.dto.tm.PaymentTm;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Payment implements Initializable {

    @FXML
    private TableView<PaymentTm> table;

    @FXML
    private TableColumn<PaymentTm, Double> tablePayAmount;

    @FXML
    private TableColumn<PaymentTm, String> tablePayDate;

    @FXML
    private TableColumn<PaymentTm, String> tablePayID;

    @FXML
    private TableColumn<PaymentTm, String> tablePayMethod;

    @FXML
    private TableColumn<PaymentTm,String> tablePayTime;

    @FXML
    private TableColumn<PaymentTm, String> tablePayerName;

    PaymentBO paymentBO = BOFactory.getInstance().getBO(BOType.PAYMENT);

    private  void  loadTable() throws Exception {
        List<PaymentDTO> paymentDTOS =  paymentBO.getALL();
        ObservableList<PaymentTm> paymentTMS = FXCollections.observableArrayList();

        for (PaymentDTO paymentDTO : paymentDTOS) {
            PaymentTm paymentTM = new PaymentTm(
                    paymentDTO.getPaymentID(),
                    paymentDTO.getPatientName(),
                    paymentDTO.getPaymentAmount(),
                    paymentDTO.getPaymentMethod(),
                    paymentDTO.getPaymentDate(),
                    paymentDTO.getPaymentTime()
            );
            paymentTMS.add(paymentTM);
        }
        table.setItems(paymentTMS);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tablePayID.setCellValueFactory(new PropertyValueFactory<>("paymentID"));
        tablePayerName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        tablePayAmount.setCellValueFactory(new PropertyValueFactory<>("paymentAmount"));
        tablePayMethod.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        tablePayDate.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        tablePayTime.setCellValueFactory(new PropertyValueFactory<>("paymentTime"));

        try{
            loadTable();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error Failed to load Page", ButtonType.OK).show();
        }
    }
}