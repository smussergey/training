package ua.training.system_what_where_when.dao;


import ua.training.system_what_where_when.dao.implement.JdbcDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();

    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    DaoFactory temp = new JdbcDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
