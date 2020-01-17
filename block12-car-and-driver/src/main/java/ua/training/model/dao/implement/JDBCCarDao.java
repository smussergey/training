package ua.training.model.dao.implement;

import ua.training.model.dao.CarDao;
import ua.training.model.entity.Car;
import ua.training.model.entity.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCCarDao implements CarDao {
    private Connection connection;

    public JDBCCarDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Car entity) {

    }

    @Override
    public Car findById(int id) {
        try (PreparedStatement ps = connection.prepareStatement
                ("SELECT * FROM car WHERE idcar = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Car result = extractFromResultSet(rs);
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    static Car extractFromResultSet(ResultSet rs)
            throws SQLException {
        Car result = new Car();

        result.setIdCar(rs.getInt("idcar") );
        result.setName( rs.getString("car.name") );
        result.setNumber( rs.getString("nomer"));


        return result;
    }

    @Override
    public List<Car> findAll() {
        List<Car> resultList = new ArrayList<>();
        Map<Integer,Driver> drivers = new HashMap<>();
        Map<Integer,Car> cars = new HashMap<>();
        try (Statement ps = connection.createStatement()){
            ResultSet rs = ps.executeQuery(
                    "select * from car left join car_driver on " +
                            "car.idcar = car_driver.car_idcar left join " +
                            "driver on car_driver.driver_driver_id = " +
                            "driver.driver_id");
            while ( rs.next() ){
                Car car = extractFromResultSet(rs);
                Driver driver =
                        JDBCDriverDao.extractFromResultSet(rs);
                car = makeUniqueCar( cars, car);
                driver = makeUniqueDriver(drivers,driver);
                car.getDrivers().add(driver);
                driver.getCars().add(car);
                System.out.println(driver);

                resultList.add(car);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    private Car makeUniqueCar(Map<Integer, Car> cars,  Car car) {
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
    public void update(Car entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws Exception {

    }
}
