
package ua.training.model.dao.implement;

import ua.training.model.dao.CarDao;
import ua.training.model.dao.DriverDao;
import ua.training.model.entity.Car;
import ua.training.model.entity.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCDriverDao implements DriverDao {
    private Connection connection;

    public JDBCDriverDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Driver entity) {

    }

    @Override
    public Driver findById(int id) {
        try (PreparedStatement ps = connection.prepareStatement
                ("SELECT * FROM driver WHERE iddriver = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Driver result = extractFromResultSet(rs);
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    static Driver extractFromResultSet(ResultSet rs)
            throws SQLException {
        Driver result = new Driver();
        result.setIddriver(rs.getInt("iddriver"));
        result.setName(rs.getString("driver.name"));
        result.setTelephone(rs.getString("telephone"));
        return result;
    }

    @Override
    public List<Driver> findAll() {
        List<Driver> resultList = new ArrayList<>();
        Map<Integer, Driver> drivers = new HashMap<>();
        Map<Integer, Car> cars = new HashMap<>();
        try (Statement ps = connection.createStatement()) {
            ResultSet rs = ps.executeQuery(
                    "select * from driver left join car_driver on " +
                            "driver.iddriver = car_driver.driver_iddriver left join " +
                            "car on car_driver.car_idcar = " +
                            "car.idcar");
            while (rs.next()) {
                Driver driver = extractFromResultSet(rs);
                Car car =
                        JDBCCarDao.extractFromResultSet(rs);
                car = makeUniqueCar(cars, car);
                driver = makeUniqueDriver(drivers, driver);
                car.getDrivers().add(driver);
                driver.getCars().add(car);
                System.out.println(car);

                resultList.add(driver);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    private Car makeUniqueCar(Map<Integer, Car> cars, Car car) {
        cars.putIfAbsent(car.getIdCar(), car);
        return cars.get(car.getIdCar());
    }

    private Driver makeUniqueDriver(
            Map<Integer, Driver> drivers, Driver driver) {
        drivers.putIfAbsent(driver.getIddriver(),
                driver);
        return drivers.get(driver.getIddriver());
    }

    @Override
    public void update(Driver entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws Exception {

    }
}

