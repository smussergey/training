package ua.training.system_what_where_when.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.system_what_where_when.entity.Appeal;
import ua.training.system_what_where_when.entity.AppealStage;

import java.util.List;

public interface AppealRepository extends JpaRepository<Appeal, Long> {
    List<Appeal> findAllByAppealStage(AppealStage appealStage);
}