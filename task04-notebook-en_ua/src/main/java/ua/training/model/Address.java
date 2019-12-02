package ua.training.model;

public class Address {
    private String postCode;
    private String city;
    private String street;
    private String buildingNumber;
    private String apartmentNumber;

    public String getFullAddress() {
        return this.toString();
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }


    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return postCode + ", " + city + ", " + street + ", " + buildingNumber + ", " + apartmentNumber;
    }
}
