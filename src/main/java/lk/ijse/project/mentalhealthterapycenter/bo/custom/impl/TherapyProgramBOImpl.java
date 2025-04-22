package lk.ijse.project.mentalhealthterapycenter.bo.custom.impl;

import lk.ijse.project.mentalhealthterapycenter.bo.custom.TherapyProgramBO;
import lk.ijse.project.mentalhealthterapycenter.dto.TherapyProgramDTO;

import java.util.List;

public class TherapyProgramBOImpl implements TherapyProgramBO {
    @Override
    public boolean saveTPrograms(TherapyProgramDTO therapyProgramDTO) {
        return false;
    }

    @Override
    public boolean updateTPrograms(TherapyProgramDTO therapyProgramDTO) {
        return false;
    }

    @Override
    public boolean deleteTProgram(String therapyProgramID) {
        return false;
    }

    @Override
    public List<TherapyProgramDTO> getALLTPrograms() throws Exception {
        return List.of();
    }

    @Override
    public String getNextProgramID() {
        return "";
    }

    @Override
    public List<TherapyProgramDTO> getALL() throws Exception {
        return List.of();
    }
}
