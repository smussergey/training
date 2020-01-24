package ua.training.system_what_where_when.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.training.system_what_where_when.model.Game;
import ua.training.system_what_where_when.repository.GameRepository;

@Service
public class GameService {
    GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional
    public void deleteGameById(Long id) {
        gameRepository.deleteById(id);
    }

    @Transactional
    public void deleteGame(Game game) {
        gameRepository.delete(game);
    }
}
