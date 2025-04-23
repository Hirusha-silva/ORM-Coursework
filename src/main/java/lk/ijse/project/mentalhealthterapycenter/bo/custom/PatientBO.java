package lk.ijse.project.mentalhealthterapycenter.bo.custom;

import lk.ijse.project.mentalhealthterapycenter.bo.SuperBO;
import lk.ijse.project.mentalhealthterapycenter.dto.PatientDTO;
import lk.ijse.project.mentalhealthterapycenter.dto.PatientsInEveryProgramDTO;

import java.sql.SQLException;
import java.util.List;

public interface PatientBO extends SuperBO {
    boolean updatePatient(PatientDTO patientDTO) throws SQLException, ClassNotFoundException;
    boolean savePatient(PatientDTO patientDTO) throws SQLException, ClassNotFoundException;
    List<PatientDTO> getALL() throws Exception;
    boolean deletePatient(String patientID) throws SQLException, ClassNotFoundException;
    String getNextPatientID();
//    List<MedicalHistoryDTO> getPatientHistory() throws SQLException, ClassNotFoundException;
    List<PatientsInEveryProgramDTO> getPatientsInEveryProgram();
}
