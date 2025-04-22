package lk.ijse.project.mentalhealthterapycenter.dao;
import lk.ijse.project.mentalhealthterapycenter.dao.custom.impl.*;
public class DAOFactory {
    public static DAOFactory daoFactory;
    private DAOFactory() {}

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public <T extends SuperDAO>T getDAO(DAOType daoType) {
        return switch (daoType) {
            case USER ->(T) new UserDAOImpl();
            case PATIENT -> (T) new PatientDAOImpl();
            case THERAPIST -> (T) new TherapistDAOImpl();
            case THERAPY_PROGRAMS -> (T) new TherapyProgramDAOImpl();
            default -> null;
        };
    }
}


