
package ua.training.system_what_where_when_servlet.dao.impl;

import org.apache.log4j.Logger;
import ua.training.system_what_where_when_servlet.dao.UserDao;
import ua.training.system_what_where_when_servlet.dao.mapper.UserMapper;
import ua.training.system_what_where_when_servlet.entity.NotUniqueLoginException;
import ua.training.system_what_where_when_servlet.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    private Connection connection;

    UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User user) {
        LOGGER.info(String.format("In UserDaoImpl, method create user: " + user));

        try (PreparedStatement ps = connection.prepareStatement
                ("INSERT INTO user (name_ua, name_en, email, password, role )" +
                        " VALUES (?,?,?,?,?)")) {
            ps.setString(1, user.getNameUa());
            ps.setString(2, user.getNameEn());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole().name());
            ps.executeUpdate();
        } catch (Exception e) { //TODO check what exception to use
            LOGGER.error("SQLException: " + e.toString());
            throw new NotUniqueLoginException("Not Unique Login", user.getEmail());
        }
        LOGGER.info("User was saved");
    }

    @Override
    public Optional<User> findById(int id) {

        Optional<User> result = Optional.empty();
        try (PreparedStatement ps = connection.prepareCall("SELECT * FROM user WHERE id = ?")) {
            ps.setInt(1, id);
            ResultSet rs;
            rs = ps.executeQuery();
            UserMapper mapper = new UserMapper();
            if (rs.next()) {
                result = Optional.of(mapper.extractFromResultSet(rs));
            }
        } catch (SQLException ex) {
            LOGGER.error("Exception in class: UserDaoImpl, method: findById.", ex);
            throw new RuntimeException(ex); //TODO Correct
        }
        return result;
    }

    @Override
    public Optional<User> findByEmail(String email) {

        Optional<User> result = Optional.empty();
        try (PreparedStatement ps = connection.prepareCall("SELECT * FROM user WHERE email = ?")) {
            ps.setString(1, email);
            ResultSet rs;
            rs = ps.executeQuery();
            UserMapper mapper = new UserMapper();
            if (rs.next()) {
                result = Optional.of(mapper.extractFromResultSet(rs));
            }//TODO : ask question how avoid two user with the same email if necessary?
        } catch (SQLException ex) {
            LOGGER.error("Exception in class: UserDaoImpl, method: findByEmail.", ex);
            throw new RuntimeException(ex); //TODO Correct
        }
        return result;
    }
//    @Override
//    public Optional<User> findByEmail(String email) {
//        try (PreparedStatement ps = connection.prepareStatement
//                ("SELECT * FROM user WHERE email = ?")) {
//            ps.setString(1, email);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                User result = extractFromResultSet(rs);
//                return Optional.of(result); // TODO check this
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return findByEmail(userName);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

//    static User extractFromResultSet(ResultSet rs)
//            throws SQLException {
//        User result = new User();
//        result.setId(rs.getInt("user_id"));
//        result.setNameUa(rs.getString("name_ua"));
//        result.setNameEn(rs.getString("name_en"));
//        result.setEmail(rs.getString("email"));
//        result.setPassword(rs.getString("password"));
//        result.setRole(Role.valueOf(rs.getString("role")));
//
//        return result;
//    }

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


//    private User makeUniqueUser(
//            Map<Integer, User> users, User user) {
//        users.putIfAbsent(user.getId(),
//                user);
//        return users.get(user.getId());
//    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e); // TODO correct
        }
    }
}

