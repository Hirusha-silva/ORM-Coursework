package lk.ijse.project.mentalhealthterapycenter.dao.custom;

import lk.ijse.project.mentalhealthterapycenter.dao.CrudDAO;
import lk.ijse.project.mentalhealthterapycenter.entity.ProgramDetails;
import org.hibernate.Session;

import java.util.List;

public interface ProgramDetailsDAO extends CrudDAO<ProgramDetails, String> {
    List<ProgramDetails> getByPatientAndSession(String patientID, String id , Session session);
}
