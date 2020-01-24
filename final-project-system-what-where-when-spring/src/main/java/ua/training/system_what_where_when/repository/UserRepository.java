package ua.training.system_what_where_when.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.system_what_where_when.entity.Role;
import ua.training.system_what_where_when.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email); // TODO use Optional
    Optional<List<User>> findByRole(Role role); // TODO check if Optional is really needed
}
