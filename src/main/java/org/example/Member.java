package org.example;


public class Member {
    //Fields of attributes
    private String firstname;
    private String lastname;
    private int birthYear;
    private String address;
    private int zipCode;
    private String city;
    private int number;
    private String eMail;
    private boolean passiveOrActiveMember;
    private boolean juniorOrSenior;
    private boolean competitionOrExcercise;

    //Constructor for attributes
    public Member(String firstname, String lastname, int birthYear, String address, int zipCode,
                  String city, int number, String eMail, boolean passiveOrActiveMember, boolean juniorOrSenior,
                  boolean competitionOrExcercise) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthYear = birthYear;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.number = number;
        this.eMail = eMail;
        this.passiveOrActiveMember = passiveOrActiveMember;
        this.juniorOrSenior = juniorOrSenior;
        this.competitionOrExcercise = competitionOrExcercise;
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

    public int getZipCode() {
        return zipCode;
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

    public boolean isPassiveOrActiveMember() {
        return passiveOrActiveMember;
    }

    public boolean isJuniorOrSenior() {
        return juniorOrSenior;
    }

    public boolean isCompetitionOrExcercise() {
        return competitionOrExcercise;
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

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
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

    public void setPassiveOrActiveMember(boolean passiveOrActiveMember) {
        this.passiveOrActiveMember = passiveOrActiveMember;
    }

    public void setJuniorOrSenior(boolean juniorOrSenior) {
        this.juniorOrSenior = juniorOrSenior;
    }

    public void setCompetitionOrExcercise(boolean competitionOrExcercise) {
        this.competitionOrExcercise = competitionOrExcercise;
    }

    //Ternary operator for boolean human
    public String getTernaryPA() {
        String getTernaryPA = (passiveOrActiveMember) ? "active" : "passive";
        return getTernaryPA;
    }

    //Ternary operator for membershiptype
    public String getTernaryJS() {
        String getTernaryJS = (juniorOrSenior) ? "junior" : "senior";
        return getTernaryJS;
    }

    //Ternary operator for boolean human
    public String getTernaryCE() {
        String getTernaryCE = (competitionOrExcercise) ? "competition" : "excercise";
        return getTernaryCE;
    }
    public String toString() {
        return "Member{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthYear=" + birthYear +
                ", address='" + address + '\'' +
                ", zipCode=" + zipCode +
                ", city='" + city + '\'' +
                ", number=" + number +
                ", eMail='" + eMail + '\'' +
                ", passiveOrActiveMember=" + passiveOrActiveMember +
                ", juniorOrSenior=" + juniorOrSenior +
                ", competitionOrExcercise=" + competitionOrExcercise +
                '}';
    }
}

