package lk.ijse.project.mentalhealthterapycenter.bo.custom;

import lk.ijse.project.mentalhealthterapycenter.bo.SuperBO;
import lk.ijse.project.mentalhealthterapycenter.dto.PaymentDTO;

import java.util.List;

public interface PaymentBO extends SuperBO {
    List<PaymentDTO> getALL() throws Exception;
}
