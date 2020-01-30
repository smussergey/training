package ua.training.system_what_where_when_servlet.dao;


import ua.training.system_what_where_when_servlet.dao.impl.DaoFactoryImpl;
import ua.training.system_what_where_when_servlet.dao.impl.GameDaoImpl;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();
    public abstract GameDaoImpl createGameDao();

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    DaoFactory temp = new DaoFactoryImpl();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
