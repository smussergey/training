package ua.training.system_what_where_when.dao.implement;

import ua.training.system_what_where_when.dao.DaoFactory;
import ua.training.system_what_where_when.dao.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDaoFactory extends DaoFactory {
    @Override
    public UserDao createUserDao(){
        return new JdbcUserDao(getConnection());
    }


    private Connection getConnection() {
        try {
            String dbDriver = "com.mysql.cj.jdbc.Driver";
            String dbURL = "jdbc:mysql:// localhost:3306/";
            String dbName = "what_where_when_db";
            String dbUsername = "root";
            String dbPassword = "12345";

            Class.forName(dbDriver);
            Connection con = DriverManager.getConnection(dbURL + dbName,
                    dbUsername,
                    dbPassword);
            return con;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
