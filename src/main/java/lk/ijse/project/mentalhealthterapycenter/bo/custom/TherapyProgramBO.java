package lk.ijse.project.mentalhealthterapycenter.bo.custom;

import lk.ijse.project.mentalhealthterapycenter.bo.SuperBO;
import lk.ijse.project.mentalhealthterapycenter.dto.TherapyProgramDTO;

import java.util.List;

public interface TherapyProgramBO extends SuperBO {
    boolean saveTPrograms(TherapyProgramDTO therapyProgramDTO);
    boolean updateTPrograms(TherapyProgramDTO therapyProgramDTO);
    boolean deleteTProgram(String therapyProgramID);
    List<TherapyProgramDTO> getALLTPrograms() throws Exception;
    String getNextProgramID();
    List<TherapyProgramDTO> getALL () throws Exception;
}
