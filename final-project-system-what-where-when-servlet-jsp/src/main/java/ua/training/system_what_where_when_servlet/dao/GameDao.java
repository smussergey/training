package ua.training.system_what_where_when_servlet.dao;

import ua.training.system_what_where_when_servlet.entity.AppealStage;
import ua.training.system_what_where_when_servlet.entity.Game;

import java.time.LocalDate;
import java.util.List;

public interface GameDao extends GenericDao<Game> {
    List<Game> findAllByUsername(String username);
    List<Game> findAllByAppealStageAndDateLaterThan (AppealStage appealStage, LocalDate localDate);
}
