package lk.ijse.project.mentalhealthterapycenter.dao.custom;

import lk.ijse.project.mentalhealthterapycenter.dao.CrudDAO;
import lk.ijse.project.mentalhealthterapycenter.entity.Patient;

import java.util.List;

public interface PatientDAO extends CrudDAO<Patient, String> {
    List<Patient> searchPatientName(String searchByName);
    String search(String patientName);
}
