package org.example;


public class Member {
    //Fields of attributes
    private String firstname;
    private String lastname;
    private int birthYear;
    private String address;
    private int postalCode;
    private String city;
    private int number;
    private String eMail;
    private boolean passtive;
    private boolean Junior;
    private boolean excerise;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public boolean isPasstive() {
        return passtive;
    }

    public void setPasstive(boolean passtive) {
        this.passtive = passtive;
    }

    public boolean isJunior() {
        return Junior;
    }

    public void setJunior(boolean junior) {
        Junior = junior;
    }

    public boolean isExcerise() {
        return excerise;
    }

    public void setExcerise(boolean excerise) {
        this.excerise = excerise;
    }

    @Override
    public String toString() {
        return "Member{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthYear=" + birthYear +
                ", address='" + address + '\'' +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", number=" + number +
                ", eMail='" + eMail + '\'' +
                ", passtive=" + passtive +
                ", Junior=" + Junior +
                ", excerise=" + excerise +
                '}';
    }
}



