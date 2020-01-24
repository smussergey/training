package ua.training.system_what_where_when.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.system_what_where_when.entity.Game;
import ua.training.system_what_where_when.entity.User;

public interface GameRepository extends JpaRepository<Game, Long> {
    Page<Game> findAll(Pageable pageable);

    Page<Game> findAllByUsers(User user, Pageable pageable);
}