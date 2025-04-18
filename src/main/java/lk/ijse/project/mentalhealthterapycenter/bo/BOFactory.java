package lk.ijse.project.mentalhealthterapycenter.bo;

public class BOFactory {
    public static BOFactory boFactory;
    private BOFactory() {}

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public <T extends SuperBO>T getBO(BOType type) {
        return switch (type) {
            case USER -> (T) new UserBOImpl();

        };
    }
}
