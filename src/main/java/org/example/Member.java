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
    private boolean Junoir;
    private boolean excerise;

    //Constructor for attributes
    public Member(String firstname, String lastname, int birthYear, String address, int zipCode,
                  String city, int number, String eMail, boolean passiveOrActiveMember, boolean juniorOrSenior,
                  boolean competitionOrExcercise) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthYear = birthYear;
        this.address = address;
        this.postalCode = zipCode;
        this.city = city;
        this.number = number;
        this.eMail = eMail;
        this.passtive = passiveOrActiveMember;
        this.Junoir = juniorOrSenior;
        this.excerise = competitionOrExcercise;
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

    public int getNumber() {
        return number;
    }

    public String geteMail() {
        return eMail;
    }

    public boolean isPasstive() {
        return passtive;
    }

    public boolean isJunoir() {
        return Junoir;
    }

    public boolean isExcerise() {
        return excerise;
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

    public void setNumber(int number) {
        this.number = number;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }


    public String toString() {
        return "Member{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthYear=" + birthYear +
                ", address='" + address + '\'' +
                ", zipCode=" + postalCode +
                ", city='" + city + '\'' +
                ", number=" + number +
                ", eMail='" + eMail + '\'' +
                ", passiveOrActiveMember=" + passtive +
                ", juniorOrSenior=" + Junoir +
                ", competitionOrExcercise=" + excerise +
                '}';
    }
}

