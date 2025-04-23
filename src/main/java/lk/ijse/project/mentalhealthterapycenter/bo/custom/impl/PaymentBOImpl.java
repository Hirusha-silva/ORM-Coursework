package lk.ijse.project.mentalhealthterapycenter.bo.custom.impl;

import lk.ijse.project.mentalhealthterapycenter.bo.custom.PaymentBO;
import lk.ijse.project.mentalhealthterapycenter.dao.DAOFactory;
import lk.ijse.project.mentalhealthterapycenter.dao.DAOType;
import lk.ijse.project.mentalhealthterapycenter.dao.custom.PaymentDAO;
import lk.ijse.project.mentalhealthterapycenter.dto.PaymentDTO;
import lk.ijse.project.mentalhealthterapycenter.entity.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO paymentDAO = DAOFactory.getInstance().getDAO(DAOType.PAYMENT);
    @Override
    public List<PaymentDTO> getALL() throws Exception {
        List<Payment> payments = paymentDAO.getAll();
        List<PaymentDTO> paymentDTOS = new ArrayList<>();
        for (Payment payment : payments) {
            paymentDTOS.add(new PaymentDTO(
                    payment.getPaymentID(),
                    payment.getPatientName(),
                    payment.getPaymentAmount(),
                    payment.getPaymentMethod(),
                    payment.getPaymentDate(),
                    payment.getPaymentTime()
            ));
        }
        return paymentDTOS;
    }
}
