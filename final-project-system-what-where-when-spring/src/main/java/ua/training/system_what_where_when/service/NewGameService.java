package ua.training.system_what_where_when.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.training.system_what_where_when.model.*;
import ua.training.system_what_where_when.repository.GameRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
public class NewGameService {
    private final UserService userService;
    private final GameRepository gameRepository;

    public NewGameService(UserService userService, GameRepository gameRepository) {
        this.userService = userService;
        this.gameRepository = gameRepository;
    }

    public Game runNewGame(Long playerId, Long opponentId, int maxNumberOfScoresToFinishGame) {
        Game game = generateNewGameResults(playerId, opponentId, maxNumberOfScoresToFinishGame);

        log.info("in GameService: save() - numberOfPlayers: {}", game.getUsers().size());
        log.info("in GameService: save() - numberOfQuestionInGame: {}", game.getAnsweredQuestions().size());

        return save(game);
    }

    private Game generateNewGameResults(Long playerId, Long opponentId, int maxNumberOfScoresToFinishGame) {
        int playerScoresCount = 0;
        int opponentScoresCount = 0;
        List<AnsweredQuestion> answeredQuestionList = new ArrayList<>();

        User player = userService.findUserById(playerId);
        Optional<User> opponent = userService.findUserByIdOptional(opponentId);

        while (true) {
            AnsweredQuestion answeredQuestion = generateAnsweredQuestion(player, opponent);
            answeredQuestionList.add(answeredQuestion);

            if (player.equals(answeredQuestion.getUserWhoGotPoint())) {
                playerScoresCount++;
            } else {
                opponentScoresCount++;
            }

            if (playerScoresCount == maxNumberOfScoresToFinishGame
                    || opponentScoresCount == maxNumberOfScoresToFinishGame) {
                break;
            }
        }

        return buildNewGameToSave(player, opponent, answeredQuestionList);
    }

    private AnsweredQuestion generateAnsweredQuestion(User playingTeam, @Nullable Optional<User> opponent) {
        AnsweredQuestion answeredQuestion = new AnsweredQuestion();
        if (ThreadLocalRandom.current().nextBoolean()) {
            answeredQuestion.setUserWhoGotPoint(playingTeam);
        } else {
            opponent.ifPresent(opponentPlayer -> answeredQuestion.setUserWhoGotPoint(opponentPlayer));
        }
        return answeredQuestion;
    }

    private Game buildNewGameToSave(User player, Optional<User> opponent, List<AnsweredQuestion> answeredQuestionList) {
        Game game = new Game();
        game.setDate(LocalDate.now());
        game.addUser(player);
        opponent.ifPresent(opponentPlayer -> game.addUser(opponentPlayer));
        game.addAnsweredQuestions(answeredQuestionList);
        return game;
    }

    @Transactional
    public Game save(Game game) {
        return gameRepository.save(game);
    }
}
