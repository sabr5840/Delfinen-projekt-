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
    private boolean passive;
    private boolean junior;
    private boolean excercise;


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

    public boolean isPassive() {
        return passive;
    }

    public void setPassive(boolean passive) {
        this.passive = passive;
    }

    public boolean isJunior() {
        return junior;
    }

    public void setJunior(boolean junior) {
        this.junior = junior;
    }

    public boolean isExcercise() {
        return excercise;
    }

    public void setExcercise(boolean excercise) {
        this.excercise = excercise;
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
                ", passive=" + passive +
                ", junior=" + junior +
                ", excercise=" + excercise +
                '}';
    }
}



