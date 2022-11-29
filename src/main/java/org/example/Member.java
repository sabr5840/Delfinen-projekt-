package org.example;


public class Member {
    //Fields of attributes
    private String firstname;
    private String lastname;
    private int birthYear;
    private String address;
    private int postalCode;
    private String city;
    private int phoneNo;
    private String eMail;
    private boolean passive;
    private boolean junior;
    private boolean exercise;
    private boolean hasPaid;


    //Constructor for attributes
    public Member(String firstname, String lastname, int birthYear, String address, int postalCode,
                  String city, int phoneNo, String eMail, boolean passive, boolean junior,
                  boolean exercise, boolean hasPaid) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthYear = birthYear;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNo = phoneNo;
        this.eMail = eMail;
        this.passive = passive;
        this.junior = junior;
        this.exercise = exercise;
        this.hasPaid = hasPaid;

    }

    public Member() {
    }

    //Getter
    public String getFirstname() {
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getAddress() {
        return address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public String geteMail() {
        return eMail;
    }

    public boolean isPassive() {
        return passive;
    }

    public boolean isJunoir() {
        return junior;
    }

    public boolean isExercise() {
        return exercise;
    }

    public boolean isHasPaid(){
        return hasPaid;
    }

    //Setter
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setHasPaid(boolean hasPaid){
        this.hasPaid = hasPaid;
    }

    public void setPassive(boolean passive) {
        this.passive = passive;
    }

    public void setJunior(boolean junior) {
        this.junior = junior;
    }

    public void setExercise(boolean exercise) {
        this.exercise = exercise;
    }

    public String toString() {
        return "Member{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthYear=" + birthYear +
                ", address='" + address + '\'' +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", phoneNo=" + phoneNo +
                ", eMail='" + eMail + '\'' +
                ", passive=" + passive +
                ", junior=" + junior +
                ", exercise=" + exercise +
                ", hasPaid=" + hasPaid +
                '}';
    }
}

