package ua.training.system_what_where_when_servlet.dao;

import ua.training.system_what_where_when_servlet.entity.Game;

import java.util.List;

public interface GameDao extends GenericDao<Game> {
    List<Game> findAllByUsername(String username);
}
