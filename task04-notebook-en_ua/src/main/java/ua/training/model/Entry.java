package ua.training.model;

import java.time.LocalDate;

public class Entry {
    private String lastName;
    private String firstName;
    private String middleName;
    private String lastNameFullFirstNameFirstLetter;
    private String nickName;
    private String comment;
    private MaritalStatus maritalStatus;
    private String phoneNumberHome;
    private String phoneNumberMobileMain;
    private String phoneNumberMobileAdditional;
    private String email;
    private String skype;
    private Address address;
    private LocalDate dateCreated;
    private LocalDate dateUpdated;

    public String getLastNameFullFirstNameFirstLetter() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = stringBuilder.append(lastName)
                .append(" ")
                .append(firstName.charAt(0))
                .append('.');
        return stringBuilder.toString();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setPhoneNumberHome(String phoneNumberHome) {
        this.phoneNumberHome = phoneNumberHome;
    }

    public void setPhoneNumberMobileMain(String phoneNumberMobileMain) {
        this.phoneNumberMobileMain = phoneNumberMobileMain;
    }

    public void setPhoneNumberMobileAdditional(String phoneNumberMobileAdditional) {
        this.phoneNumberMobileAdditional = phoneNumberMobileAdditional;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Override
    public String toString() {
        return "Entry: \n" +
                "lastName=" + lastName + "\n" +
                "firstName=" + firstName + "\n" +
                "middleName=" + middleName + "\n" +
                "LastNameFullFirstNameFirstLetter=" + getLastNameFullFirstNameFirstLetter() + "\n" +
                "nickName=" + nickName + "\n" +
                "comment=" + comment + "\n" +
                "maritalStatus=" + maritalStatus + "\n" +
                "phoneNumberHome=" + phoneNumberHome + "\n" +
                "phoneNumberMobileMain=" + phoneNumberMobileMain + "\n" +
                "phoneNumberMobileAdditional=" + phoneNumberMobileAdditional + "\n" +
                "email=" + email + "\n" +
                "skype=" + skype + "\n" +
                "address=" + this.getAddress().getFullAddress() + "\n" +
                "dateCreated=" + dateCreated + "\n" +
                "dateUpdated=" + dateUpdated;
    }
}