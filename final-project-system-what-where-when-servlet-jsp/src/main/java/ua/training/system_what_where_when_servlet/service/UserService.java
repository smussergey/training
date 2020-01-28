package ua.training.system_what_where_when_servlet.service;

import ua.training.system_what_where_when_servlet.dao.DaoFactory;
import ua.training.system_what_where_when_servlet.dao.UserDao;
import ua.training.system_what_where_when_servlet.entity.User;

import java.util.Optional;

public class UserService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public Optional<User> findByUserName(String userName) {
        Optional<User> result = Optional.empty();
        try {
            try (UserDao userDao = daoFactory.createUserDao()) {
                result = userDao.findByUserName(userName);
            }
        } catch (Exception e) {
            e.printStackTrace(); //TODO Correct
        }
        return result;
    }
}