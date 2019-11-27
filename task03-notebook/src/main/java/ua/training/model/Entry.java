package ua.training.model;

public class Entry {
    private String lastName;
    private String firstName;
    private String middleName;
    String NICKNAME = "nick name:";
    String COMMENT = "comment:";
    String MARITAL_STATUS = "marital status:";
    String PHONE_NUMBER_HOME = "home phone number:";
    String PHONE_NUMBER_MOBILE_MAIN = "mobile phone number:";
    String PHONE_NUMBER_MOBILE_ADDITIONAL = "additional mobile phone number, in case you have:";
    String EMAIL = "email:";
    String SKYPE = "skype:";
    String ADDRESS = "address";
    String INPUT_DATE = "input date:";
    String MODIFIED_DATE = "modified date:";
    String INCORRECT_INPUT_DATA = "Wrong input!\n";

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }
}
