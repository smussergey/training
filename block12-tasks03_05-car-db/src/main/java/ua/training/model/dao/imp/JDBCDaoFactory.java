package ua.training.model.dao.imp;

import ua.training.model.dao.CarDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.ManufacturerDao;
import ua.training.model.dao.ShopDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    @Override
    public CarDao createCarDao() {
        return new JDBCCarDao(getConnection());
    }
    @Override
    public ManufacturerDao createManufacturerDao() {
        return new JDBCManufacturerDao(getConnection());
    }
    @Override
    public ShopDao createShopDao() {
        return new JDBCShopDao(getConnection());
    }

    private Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mycar_db",
                    "root" ,
                    "12345" );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
