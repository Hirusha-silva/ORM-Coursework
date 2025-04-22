package lk.ijse.project.mentalhealthterapycenter.bo.custom;

import lk.ijse.project.mentalhealthterapycenter.bo.SuperBO;
import lk.ijse.project.mentalhealthterapycenter.dto.TherapistDTO;

import java.sql.SQLException;
import java.util.List;

public interface TherapistBO extends SuperBO {
    List<TherapistDTO> getALLDoctors() throws Exception;
    boolean saveTherapist(TherapistDTO doctorDTO);
    boolean updateTherapist(TherapistDTO doctorDTO);
    boolean deleteTherapist(String DoctorID) throws SQLException, ClassNotFoundException;
    String getNextTherapyID();
    List<TherapistDTO>getDocNames() throws Exception;
}
