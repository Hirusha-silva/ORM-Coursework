package lk.ijse.project.mentalhealthterapycenter.dao.custom.impl;

import lk.ijse.project.mentalhealthterapycenter.dao.custom.TherapyProgramDAO;
import lk.ijse.project.mentalhealthterapycenter.entity.TPrograms;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TherapyProgramDAOImpl implements TherapyProgramDAO {
    @Override
    public boolean save(TPrograms tPrograms, Session session) throws SQLException {
        return false;
    }

    @Override
    public boolean update(TPrograms tPrograms, Session session) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<TPrograms> getAll() throws Exception {
        return List.of();
    }

    @Override
    public boolean deleteByPk(String pk) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Optional<TPrograms> findByPK(String pk, Session session) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }
}
