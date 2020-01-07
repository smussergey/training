package ua.training.system_what_where_when.service;

import ua.training.system_what_where_when.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByEmail(String email);

    User findById(Long id);

    void delete(Long id);
}
