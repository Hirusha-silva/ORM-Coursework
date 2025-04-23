package lk.ijse.project.mentalhealthterapycenter.dao.custom.impl;

import lk.ijse.project.mentalhealthterapycenter.dao.custom.ProgramDetailsDAO;
import lk.ijse.project.mentalhealthterapycenter.entity.ProgramDetails;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProgramDetailsDAOImpl implements ProgramDetailsDAO {
    @Override
    public List<ProgramDetails> getByPatientAndSession(String patientID, String id, Session session) {
        return List.of();
    }

    @Override
    public boolean save(ProgramDetails programDetails, Session session) throws SQLException {
        return false;
    }

    @Override
    public boolean update(ProgramDetails programDetails, Session session) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<ProgramDetails> getAll() throws Exception {
        return List.of();
    }

    @Override
    public boolean deleteByPk(String pk) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Optional<ProgramDetails> findByPK(String pk, Session session) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }
}
