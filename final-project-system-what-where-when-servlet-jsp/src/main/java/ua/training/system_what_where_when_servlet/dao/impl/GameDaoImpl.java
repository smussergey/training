package ua.training.system_what_where_when_servlet.dao.impl;

import org.apache.log4j.Logger;
import ua.training.system_what_where_when_servlet.dao.GameDao;
import ua.training.system_what_where_when_servlet.dao.mapper.AnsweredQuestionMapper;
import ua.training.system_what_where_when_servlet.dao.mapper.AppealMapper;
import ua.training.system_what_where_when_servlet.dao.mapper.GameMapper;
import ua.training.system_what_where_when_servlet.dao.mapper.UserMapper;
import ua.training.system_what_where_when_servlet.entity.AnsweredQuestion;
import ua.training.system_what_where_when_servlet.entity.Appeal;
import ua.training.system_what_where_when_servlet.entity.Game;
import ua.training.system_what_where_when_servlet.entity.User;

import java.sql.*;
import java.util.*;

public class GameDaoImpl implements GameDao {
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    private Connection connection;

    public GameDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Game entity) {

    }

    @Override
    public Optional<Game> findById(int id) {
        Map<Integer, AnsweredQuestion> answeredQuestions = new HashMap<>();
        Map<Integer, Appeal> appeals = new HashMap<>();
        Map<Integer, Game> games = new HashMap<>();
        Map<Integer, User> users = new HashMap<>();


        Optional<Game> result = Optional.empty();
        try (PreparedStatement ps = connection.prepareCall("" +
                " select * from user " +
                " left join user_game " +
                " on  user.user_id = user_game.user_id " +
                " left join game " +
                " on user_game.game_id = game.game_id " +
                " left join answered_question " +
                " on game.game_id = answered_question.game_id " +
                " left join appeal " +
                " on answered_question.appeal_id = appeal.appeal_id " +
                " where game.game_id = ?")) {

            ps.setInt(1, id);
            ResultSet rs;

            rs = ps.executeQuery();
            
            AnsweredQuestionMapper answeredQuestionMapper = new AnsweredQuestionMapper();
            AppealMapper appealMapper = new AppealMapper();
            GameMapper gameMapper = new GameMapper();
            UserMapper userMapper = new UserMapper();

            while (rs.next()) {
                Game game = gameMapper
                        .extractFromResultSet(rs);
                game = gameMapper
                        .makeUnique(games, game);

                User user = userMapper
                        .extractFromResultSet(rs);
                user = userMapper
                        .makeUnique(users, user);


                Appeal appeal = null;

                if (rs.getInt("appeal.appeal_id") > 0) {
                    appeal = appealMapper
                            .extractFromResultSet(rs);
                    appeal = appealMapper
                            .makeUnique(appeals, appeal);
                    game.getAppeals().add(appeal);
                }

                AnsweredQuestion answeredQuestion = answeredQuestionMapper
                        .extractFromResultSet(rs);
                answeredQuestion = answeredQuestionMapper
                        .makeUnique(answeredQuestions, answeredQuestion);
                answeredQuestion.setGame(game);
                if (rs.getInt("answered_question.user_id") > 0)
                    answeredQuestion.setUserWhoGotPoint(users.get(rs.getInt("answered_question.user_id")));
                if (rs.getInt("answered_question.appeal_id") > 0)
                    answeredQuestion.setAppeal(appeal);

                game.getAnsweredQuestions().add(answeredQuestion);

                if (game.getUsers().contains(user)) {
                } else {
                    game.getUsers().add(user);
                }
            }

            result = games.values().stream().findFirst();
        } catch (SQLException ex) {
            LOGGER.error("Exception in class: UserDaoImpl, method: findById.", ex);
            throw new RuntimeException(ex); //TODO Correct
        }
        return result;
    }

    @Override
    public List<Game> findAll() {
        Map<Integer, AnsweredQuestion> answeredQuestions = new HashMap<>();
        Map<Integer, Appeal> appeals = new HashMap<>();
        Map<Integer, Game> games = new HashMap<>();
        Map<Integer, User> users = new HashMap<>();

        final String query = "" +
                " select * from user " +
                " left join user_game " +
                " on  user.user_id = user_game.user_id " +
                " left join game " +
                " on user_game.game_id = game.game_id " +
                " left join answered_question " +
                " on game.game_id = answered_question.game_id " +
                " left join appeal " +
                " on answered_question.appeal_id = appeal.appeal_id " +
                " where game.game_id>0"; // TODO correct

        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);

            AnsweredQuestionMapper answeredQuestionMapper = new AnsweredQuestionMapper();
            AppealMapper appealMapper = new AppealMapper();
            GameMapper gameMapper = new GameMapper();
            UserMapper userMapper = new UserMapper();

            while (rs.next()) {
                Game game = gameMapper
                        .extractFromResultSet(rs);
                game = gameMapper
                        .makeUnique(games, game);

                User user = userMapper
                        .extractFromResultSet(rs);
                user = userMapper
                        .makeUnique(users, user);


                Appeal appeal = null;

                if (rs.getInt("appeal.appeal_id") > 0) {
                    appeal = appealMapper
                            .extractFromResultSet(rs);
                    appeal = appealMapper
                            .makeUnique(appeals, appeal);
                    game.getAppeals().add(appeal);
                }

                AnsweredQuestion answeredQuestion = answeredQuestionMapper
                        .extractFromResultSet(rs);
                answeredQuestion = answeredQuestionMapper
                        .makeUnique(answeredQuestions, answeredQuestion);
                answeredQuestion.setGame(game);
                if (rs.getInt("answered_question.user_id") > 0)
                    answeredQuestion.setUserWhoGotPoint(users.get(rs.getInt("answered_question.user_id")));
                if (rs.getInt("answered_question.appeal_id") > 0)
                    answeredQuestion.setAppeal(appeal);

                game.getAnsweredQuestions().add(answeredQuestion);

                if (game.getUsers().contains(user)) {
                } else {
                    game.getUsers().add(user);
                }
            }

            return new ArrayList<>(games.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Game entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e); // TODO correct
        }
    }
}
