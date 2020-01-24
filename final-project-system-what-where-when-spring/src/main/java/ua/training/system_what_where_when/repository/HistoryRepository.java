package ua.training.system_what_where_when.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.system_what_where_when.entity.History;

public interface HistoryRepository extends JpaRepository<History, Long> {
    Page<History> findAll(Pageable pageable);
}