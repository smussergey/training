package training.model;

public class Entry {
    private String lastName;
    private String nickName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}