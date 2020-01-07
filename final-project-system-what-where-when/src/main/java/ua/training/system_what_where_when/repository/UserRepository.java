package ua.training.system_what_where_when.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.system_what_where_when.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
