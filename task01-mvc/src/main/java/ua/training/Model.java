package ua.training;

public class Model {

    private String firstWord;
    private String secondWord;

    // The Program logic

    public String getResult() {
        return firstWord + " " + secondWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }


}
