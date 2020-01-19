package ua.training.model.dao.implement;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import ua.training.model.dao.CarDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.DriverDao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    @Override
    public CarDao createCarDao() {
        return new JDBCCarDao(getConnection());
    }

    @Override
    public DriverDao createDriverDao() {
        return new JDBCDriverDao(getConnection());
    }

    private Connection getConnection(){
        try {
//            Class.forName(com.mysql.jdbc.Driver);
//            return DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/mydriverdb",
//                    "root" ,
//                    "12345" );
            // Initialize all the information regarding
            // Database Connection
            String dbDriver = "com.mysql.cj.jdbc.Driver";
            String dbURL = "jdbc:mysql:// localhost:3306/";
            // Database name to access
            String dbName = "mydriverdb";
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
