
package ua.training.system_what_where_when.dao.implement;

import ua.training.system_what_where_when.dao.UserDao;
import ua.training.system_what_where_when.entity.Role;
import ua.training.system_what_where_when.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcUserDao implements UserDao {
    private Connection connection;

    public JdbcUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public User findById(int id) {
        try (PreparedStatement ps = connection.prepareStatement
                ("SELECT * FROM user WHERE user_id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User result = extractFromResultSet(rs);
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (PreparedStatement ps = connection.prepareStatement
                ("SELECT * FROM user WHERE email = ?")) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User result = extractFromResultSet(rs);
                return Optional.of(result); // TODO check this
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return findByEmail(userName);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    static User extractFromResultSet(ResultSet rs)
            throws SQLException {
        User result = new User();
        result.setId(rs.getInt("user_id"));
        result.setNameUa(rs.getString("name_ua"));
        result.setNameEn(rs.getString("name_en"));
        result.setEmail(rs.getString("email"));
        result.setPassword(rs.getString("password"));
        result.setRole(Role.valueOf(rs.getString("role")));

        return result;
    }

//    @Override
//    public List<Driver> findAll() {
//        List<Driver> resultList = new ArrayList<>();
//        Map<Integer, Driver> drivers = new HashMap<>();
//        Map<Integer, Car> cars = new HashMap<>();
//        try (Statement ps = connection.createStatement()) {
//            ResultSet rs = ps.executeQuery(
//                    "select * from driver left join car_driver on " +
//                            "driver.iddriver = car_driver.driver_iddriver left join " +
//                            "car on car_driver.car_idcar = " +
//                            "car.idcar");
//            while (rs.next()) {
//                Driver driver = extractFromResultSet(rs);
//                Car car =
//                        JDBCCarDao.extractFromResultSet(rs);
//                car = makeUniqueUser(cars, car);
//                driver = makeUniqueDriver(drivers, driver);
//                car.getDrivers().add(driver);
//                driver.getCars().add(car);
////                System.out.println(car);
//
//                resultList.add(driver);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return resultList;
//    }


    private User makeUniqueUser(
            Map<Integer, User> users, User user) {
        users.putIfAbsent(user.getId(),
                user);
        return users.get(user.getId());
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws Exception {

    }
}

