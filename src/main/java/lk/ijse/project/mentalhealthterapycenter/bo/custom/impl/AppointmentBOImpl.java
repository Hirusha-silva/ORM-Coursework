package lk.ijse.project.mentalhealthterapycenter.bo.custom.impl;

import lk.ijse.project.mentalhealthterapycenter.bo.custom.AppointmentBO;
import lk.ijse.project.mentalhealthterapycenter.dto.*;

import java.util.List;
import java.util.Optional;

public class AppointmentBOImpl implements AppointmentBO {
    @Override
    public boolean addAppointment(ProgramDetailsDTO programDetailsDTO, SessionDTO sessionDTO, PaymentDTO paymentDTO) {
        return false;
    }

    @Override
    public boolean updateAppointments(ProgramDetailsDTO programDetailsDTO, SessionDTO sessionDTO, PaymentDTO paymentDTO) {
        return false;
    }

    @Override
    public String getNextPatientID() {
        return "";
    }

    @Override
    public String getNextSessionID() {
        return "";
    }

    @Override
    public String getNextPaymentID() {
        return "";
    }

    @Override
    public List<PatientDTO> searchPatientBYName(String searchBYName) {
        return List.of();
    }

    @Override
    public List<ViewSessionDTO> getAllAppointments() {
        return List.of();
    }

    @Override
    public List<String> loadDoctorIds() throws Exception {
        return List.of();
    }

    @Override
    public String searchPatientID(String patientName) {
        return "";
    }

    @Override
    public boolean cancelAppointment(String id) {
        return false;
    }

    @Override
    public Optional<String> getLastAptID() {
        return Optional.empty();
    }
}
