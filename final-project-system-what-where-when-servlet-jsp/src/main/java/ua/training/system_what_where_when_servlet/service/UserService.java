package ua.training.system_what_where_when_servlet.service;

import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import ua.training.system_what_where_when_servlet.dao.DaoFactory;
import ua.training.system_what_where_when_servlet.dao.UserDao;
import ua.training.system_what_where_when_servlet.entity.User;

import java.util.Optional;

public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    private DaoFactory daoFactory;

    public UserService() {
        this.daoFactory = DaoFactory.getInstance();
    }

    public Optional<User> findByUserName(String username) {
        Optional<User> userOptional = Optional.empty();
        try {
            try (UserDao userDao = daoFactory.createUserDao()) {
                userOptional = userDao.findByUserName(username);
            }
        } catch (Exception e) {
            e.printStackTrace(); //TODO Correct
        }
        return userOptional;
    }

    public Optional<User> findByUserNameAndPassword(String username, String password) {
        Optional<User> userOptional = Optional.empty();
        try {
            try (UserDao userDao = daoFactory.createUserDao()) {
                userOptional = userDao.findByUserName(username);
            }
        } catch (Exception e) {
            e.printStackTrace(); //TODO Correct
        }

        if (!userOptional.isPresent()) {
            LOGGER.warn(String.format("User with username: %s not found", username));
            return Optional.empty();
        }

        LOGGER.info(String.format("User with username: %s was found", username));

        if (isPasswordValid(userOptional.get(), password)) {
            LOGGER.info(String.format("Password %s is valid", password));
            return userOptional;
        }

        LOGGER.warn(String.format("Password %s is not valid", password));
        return Optional.empty();
    }

    private boolean isPasswordValid(User user, String password) {
        LOGGER.info(String.format("Previous password is: %s", user.getPassword()));
        return BCrypt.checkpw(password, user.getPassword());
    }

}