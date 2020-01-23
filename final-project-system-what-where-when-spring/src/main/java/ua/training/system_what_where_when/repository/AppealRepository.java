package ua.training.system_what_where_when.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.system_what_where_when.model.Appeal;

public interface AppealRepository extends JpaRepository<Appeal, Long> {
}