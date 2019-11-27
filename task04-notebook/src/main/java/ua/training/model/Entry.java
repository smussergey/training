package ua.training.model;

import java.time.LocalDate;

public class Entry {
    private String lastName;
    private String firstName;
    private String middleName;
    private String nickName;
    private String comment;
    private MaritalStatus maritalStatus;
    private String phoneNumberHome;
    private String phoneNumberMobileMain;
    private String phoneNumberMobileAdditional;
    private String email;
    private String skype;
    private String address;
    private LocalDate dateCreated;
    private LocalDate dateUpdated;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPhoneNumberHome() {
        return phoneNumberHome;
    }

    public void setPhoneNumberHome(String phoneNumberHome) {
        this.phoneNumberHome = phoneNumberHome;
    }

    public String getPhoneNumberMobileMain() {
        return phoneNumberMobileMain;
    }

    public void setPhoneNumberMobileMain(String phoneNumberMobileMain) {
        this.phoneNumberMobileMain = phoneNumberMobileMain;
    }

    public String getPhoneNumberMobileAdditional() {
        return phoneNumberMobileAdditional;
    }

    public void setPhoneNumberMobileAdditional(String phoneNumberMobileAdditional) {
        this.phoneNumberMobileAdditional = phoneNumberMobileAdditional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", comment='" + comment + '\'' +
                ", maritalStatus=" + maritalStatus +
                ", phoneNumberHome='" + phoneNumberHome + '\'' +
                ", phoneNumberMobileMain='" + phoneNumberMobileMain + '\'' +
                ", phoneNumberMobileAdditional='" + phoneNumberMobileAdditional + '\'' +
                ", email='" + email + '\'' +
                ", skype='" + skype + '\'' +
                ", address='" + address + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                '}';
    }
}