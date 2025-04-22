package lk.ijse.project.mentalhealthterapycenter.bo.custom.impl;

import lk.ijse.project.mentalhealthterapycenter.bo.custom.TherapyProgramBO;
import lk.ijse.project.mentalhealthterapycenter.config.FactoryConfiguration;
import lk.ijse.project.mentalhealthterapycenter.dao.DAOFactory;
import lk.ijse.project.mentalhealthterapycenter.dao.DAOType;
import lk.ijse.project.mentalhealthterapycenter.dao.custom.TherapyProgramDAO;
import lk.ijse.project.mentalhealthterapycenter.dto.TherapyProgramDTO;
import lk.ijse.project.mentalhealthterapycenter.entity.TPrograms;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TherapyProgramBOImpl implements TherapyProgramBO {
    TherapyProgramDAO tProgramDAO = DAOFactory.getInstance().getDAO(DAOType.THERAPY_PROGRAMS);
    @Override
    public boolean saveTPrograms(TherapyProgramDTO therapyProgramDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            TPrograms tPrograms = new TPrograms();
            tPrograms.setProgramID(therapyProgramDTO.getTherapyID());
            tPrograms.setProgramName(therapyProgramDTO.getTherapyName());
            tPrograms.setProgramDescription(therapyProgramDTO.getTherapyDescription());
            tPrograms.setProgramFee(therapyProgramDTO.getTherapyFee());

            boolean isSaved = tProgramDAO.save(tPrograms,session);
            if (isSaved) {
                transaction.commit();
                return true;
            }else {
                transaction.rollback();
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error saving therapy programs", e);
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean updateTPrograms(TherapyProgramDTO therapyProgramDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            TPrograms tPrograms = new TPrograms();
            tPrograms.setProgramID(therapyProgramDTO.getTherapyID());
            tPrograms.setProgramName(therapyProgramDTO.getTherapyName());
            tPrograms.setProgramDescription(therapyProgramDTO.getTherapyDescription());
            tPrograms.setProgramFee(therapyProgramDTO.getTherapyFee());

            boolean isUpdated =  tProgramDAO.update(tPrograms,session);
            if (isUpdated) {
                transaction.commit();
                return true;
            }else{
                transaction.rollback();
                return false;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found Error while saving therapy programs", e);
        } catch (SQLException e) {
            throw new RuntimeException("SQL Error while saving therapy programs");
        }finally {
            session.close();
        }
    }

    @Override
    public boolean deleteTProgram(String therapyProgramID) {
        try {
            return tProgramDAO.deleteByPk(therapyProgramID);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found Error while saving therapy programs", e);
        } catch (SQLException e) {
            throw new RuntimeException("SQL Error while saving therapy programs");
        }
    }

    @Override
    public List<TherapyProgramDTO> getALLTPrograms() throws Exception {
        List<TPrograms> programList = tProgramDAO.getAll();
        List<TherapyProgramDTO> programDtos = new ArrayList<>();
        for (TPrograms tPrograms : programList) {
            programDtos.add(new TherapyProgramDTO(
                    tPrograms.getProgramID(),
                    tPrograms.getProgramName(),
                    tPrograms.getProgramDescription(),
                    tPrograms.getProgramFee()
            ));
        }
        return programDtos;
    }

    @Override
    public String getNextProgramID() {
        Optional<String> lastPkOptional = tProgramDAO.getLastPK();
        if (lastPkOptional.isPresent()) {
            String lastPk = lastPkOptional.get();
            int nextId = Integer.parseInt(lastPk.replace("PR", "")) + 1;  // Extract number and increment
            return String.format("PR%03d", nextId);
        } else {
            return "PR001";  // Default if no records exist
        }
    }

    @Override
    public List<TherapyProgramDTO> getALL() throws Exception {
        List<TPrograms> tPrograms = tProgramDAO.getAll();
        List<TherapyProgramDTO> dtos = new ArrayList<>();

        for (TPrograms programs : tPrograms) {
            TherapyProgramDTO dto = new TherapyProgramDTO(
                    programs.getProgramID(),
                    programs.getProgramName(),
                    programs.getProgramDescription(),
                    programs.getProgramFee()
            );
            dtos.add(dto);
        }
        return dtos;
    }
}
