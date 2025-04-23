package lk.ijse.project.mentalhealthterapycenter.dao.custom;

import lk.ijse.project.mentalhealthterapycenter.dto.MedicalHistoryDTO;
import lk.ijse.project.mentalhealthterapycenter.dto.PatientsInEveryProgramDTO;
import lk.ijse.project.mentalhealthterapycenter.dto.ViewSessionDTO;
import lk.ijse.project.mentalhealthterapycenter.dao.SuperDAO;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<ViewSessionDTO>getAllAppointments();
    List<MedicalHistoryDTO> getALLMedicalHistory();
    List<PatientsInEveryProgramDTO> getPatientsInEveryProgram();
}
