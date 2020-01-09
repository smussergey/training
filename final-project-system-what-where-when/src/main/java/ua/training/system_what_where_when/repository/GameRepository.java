package ua.training.system_what_where_when.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.system_what_where_when.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}