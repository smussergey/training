package ua.training.system_what_where_when.service;

import org.springframework.stereotype.Service;
import ua.training.system_what_where_when.dto.GameDTO;
import ua.training.system_what_where_when.model.AppealStage;
import ua.training.system_what_where_when.model.Game;
import ua.training.system_what_where_when.model.User;
import ua.training.system_what_where_when.util.ResourceBundleUtil;

@Service
public class GameDTOService {
    private static final String DELIMITER = ":";

    public GameDTO toGameDTO(Game game) {
        GameDTO gameDTO = new GameDTO();

        gameDTO.setId(game.getId());
        gameDTO.setDate(game.getDate());
        gameDTO.setPlayerNameUa(game.getUsers().get(0).getNameUa());//TODO improve
        gameDTO.setPlayerNameEn(game.getUsers().get(0).getNameEn());//TODO improve

        if (game.getUsers().size() > 1) { //TODO improve
            gameDTO.setOpponentNameUa(game.getUsers().get(1).getNameUa());
            gameDTO.setOpponentNameEn(game.getUsers().get(1).getNameEn());
        } else {
            gameDTO.setOpponentNameUa(ResourceBundleUtil.getBundleString("games.game.statistics.text.audience"));
            gameDTO.setOpponentNameEn(ResourceBundleUtil.getBundleString("games.game.statistics.text.audience"));
        }

        User firstPlayer = game.getUsers().get(0); //TODO correct
        long firstPlayerScores = game.getAnsweredQuestions()
                .stream()
                .filter(aq -> firstPlayer.equals(aq.getUserWhoGotPoint()))
                .count();

        long secondPlayerScores = game.getAnsweredQuestions()
                .stream()
                .count() - firstPlayerScores;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstPlayerScores);
        stringBuilder.append(DELIMITER);//TODO move ":" to properties
        stringBuilder.append(secondPlayerScores);
        String scores = stringBuilder.toString();
        gameDTO.setScores(scores);


//        if (game.getAppeals().size() > 0) { //TODO improve
//            gameDTO.setAppealStage(ResourceBundleUtil.getBundleStringForAppealStage(AppealStage.FILED.name())); //TODO correct
//        } else
//            gameDTO.setAppealStage(ResourceBundleUtil.getBundleStringForAppealStage(AppealStage.NOT_FILED.name())); //TODO correct
//        if (game.getAppeals().size() > 0) { //TODO improve
        if (game.getAppeals().isEmpty()) {
            gameDTO.setAppealStage(ResourceBundleUtil.getBundleStringForAppealStage(AppealStage.NOT_FILED.name()));
        } else {
            game.getAppeals().stream()
                    .forEach(appeal -> {
                        if (appeal.getAppealStage().equals(AppealStage.FILED)) {
                            gameDTO.setAppealStage(ResourceBundleUtil.getBundleStringForAppealStage(AppealStage.FILED.name()));
                        } else {
                            gameDTO.setAppealStage(ResourceBundleUtil.getBundleStringForAppealStage(AppealStage.CONSIDERED.name()));
                        } //else {
//                        gameDTO.setAppealStage(ResourceBundleUtil.getBundleStringForAppealStage(AppealStage.NOT_FILED.name()));
//                    }

                    });
        }
//        }
        return gameDTO;
    }


}
