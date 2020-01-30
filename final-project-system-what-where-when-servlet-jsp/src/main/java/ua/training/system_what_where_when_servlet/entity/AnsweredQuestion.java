package ua.training.system_what_where_when_servlet.entity;


public class AnsweredQuestion {
    private Integer id;
    private Game game;
    private Appeal appeal;
    private User userWhoGotPoint;

    public AnsweredQuestion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Appeal getAppeal() {
        return appeal;
    }

    public void setAppeal(Appeal appeal) {
        this.appeal = appeal;
    }

    public User getUserWhoGotPoint() {
        return userWhoGotPoint;
    }

    public void setUserWhoGotPoint(User userWhoGotPoint) {
        this.userWhoGotPoint = userWhoGotPoint;
    }
}
