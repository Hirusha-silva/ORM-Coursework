package lk.ijse.project.mentalhealthterapycenter.bo;

import lk.ijse.project.mentalhealthterapycenter.bo.custom.impl.PatientBOImpl;
import lk.ijse.project.mentalhealthterapycenter.bo.custom.impl.UserBOImpl;

public class BOFactory {
    public static BOFactory boFactory;
    private BOFactory() {}

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    @SuppressWarnings("unchecked")
    public <T extends SuperBO>T getBO(BOType type) {
        return switch (type) {
            case USER -> (T) new UserBOImpl();
            case PATIENT -> (T) new PatientBOImpl();

        };
    }
}
