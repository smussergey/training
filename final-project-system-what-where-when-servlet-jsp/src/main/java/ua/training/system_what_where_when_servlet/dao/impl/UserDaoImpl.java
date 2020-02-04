
package ua.training.system_what_where_when_servlet.dao.impl;

import org.apache.log4j.Logger;
import ua.training.system_what_where_when_servlet.dao.UserDao;
import ua.training.system_what_where_when_servlet.dao.mapper.UserDTOMapper;
import ua.training.system_what_where_when_servlet.dao.mapper.UserMapper;
import ua.training.system_what_where_when_servlet.dto.UserDTO;
import ua.training.system_what_where_when_servlet.entity.Role;
import ua.training.system_what_where_when_servlet.entity.exception.NotUniqueLoginException;
import ua.training.system_what_where_when_servlet.entity.User;

import java.sql.*;
import java.util.*;

public class UserDaoImpl implements UserDao {
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    private Connection connection;

    UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User user) {
        LOGGER.info(String.format("In UserDaoImpl, method create user: " + user));
//        boolean flag = false;
        try (PreparedStatement ps = connection.prepareStatement
                ("INSERT INTO user (name_ua, name_en, email, password, role )" +
                        " VALUES (?,?,?,?,?)")) {
            ps.setString(1, user.getNameUa());
            ps.setString(2, user.getNameEn());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole().name());
            ps.executeUpdate();
//            flag = true;
        } catch (Exception e) { //TODO check what exception to use
            LOGGER.error("SQLException: " + e.toString());
            throw new NotUniqueLoginException("Not Unique Login", user.getEmail());
        }
        LOGGER.info("User was saved");
//    return flag;
    }

    @Override
    public Optional<User> findById(int id) {

        Optional<User> result = Optional.empty();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE user_id = ?")) {
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
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE email = ?")) {
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


    @Override
    public Optional<User> findByUserName(String userName) {
        return findByEmail(userName);
    }

    @Override
    public List<UserDTO> getAllUserDTOsByRole(Role role) {
        List<UserDTO> userDTOs = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(" select user_id, name_en, name_ua from user " +
                " where user.role = ?")) {
            ps.setString(1, role.name());
            ResultSet rs;
            rs = ps.executeQuery();

            UserDTOMapper userDTOMapper = new UserDTOMapper();

            while (rs.next()) {
                UserDTO userDTO = userDTOMapper
                        .extractFromResultSet(rs);
                userDTOs.add(userDTO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDTOs;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

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

