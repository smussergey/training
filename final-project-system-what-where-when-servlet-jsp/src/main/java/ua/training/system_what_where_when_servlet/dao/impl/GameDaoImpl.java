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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public Optional<Game> findById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Game> findAll() {
        Map<Integer, AnsweredQuestion> answeredQuestions = new HashMap<>();
        Map<Integer, Appeal> appeals = new HashMap<>();
        Map<Integer, Game> games = new HashMap<>();
        Map<Integer, User> users = new HashMap<>();

        final String query = "" +
//                " select * from game" +
//                " left join user_game using (game_id)" +
//                " left join user using (user_id)";

//                " select * from game" +
//                " left join user_game " +
//                "on game.game_id = user_game.game_id" +
//                " left join user " +
//                " on user_game.user_id = user.user_id";

                " select * from game" +
                " left join user_game " +
                " on game.game_id = user_game.game_id" +
                " left join user " +
                " on user_game.user_id = user.user_id" +
                " left join appeal " +
                " on user.user_id = appeal.user_id" +
                " left join answered_question " +
                " on appeal.appeal_id = answered_question.appeal_id ";

//                "select * from answered_question" +
//                "left join appeal" +
//                "on answered_question.appeal_id=appeal.appeal_id" +
//                "left join game" +
//                "on appeal.game_id = game.game_id" +
//                "left join user_game" +
//                "on game.game_id = user_game.game_id" +
//                "left join user" +
//                "on user_game.user_id = user.user_id";

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

                game.getUsers().add(user);

                if (rs.getInt("appeal_id") > 0) {
                    Appeal appeal = appealMapper
                            .extractFromResultSet(rs);
                    appeal = appealMapper
                            .makeUnique(appeals, appeal);
                    game.getAppeals().add(appeal);
                }
                AnsweredQuestion answeredQuestion = answeredQuestionMapper
                        .extractFromResultSet(rs);
                answeredQuestion = answeredQuestionMapper
                        .makeUnique(answeredQuestions, answeredQuestion);


                answeredQuestion.setUserWhoGotPoint(user);

                game.getAnsweredQuestions().add(answeredQuestion);


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
