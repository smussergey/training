package ua.training.system_what_where_when.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.system_what_where_when.model.Appeal;
import ua.training.system_what_where_when.model.AppealStage;

import java.util.List;
import java.util.Optional;

public interface AppealRepository extends JpaRepository<Appeal, Long> {
    List<Appeal> findAllByAppealStage(AppealStage appealStage);
}