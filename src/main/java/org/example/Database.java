package org.example;

import java.util.ArrayList;

public class Database {

    // Arraylist
    private ArrayList<Member> Registration = new ArrayList<>();

    //Getter for arraylist
    private ArrayList<Member> getRegistration(){
        return Registration;
    }

    void Registration(String name, int birthYear, String address, int zipCode, String city, int number, String eMail,
                          boolean passiveOrActiveMember, boolean juniorOrSenior, boolean competitionOrExcercise){
        Member member = new Member(name, birthYear, address, zipCode, city, number, eMail, passiveOrActiveMember, juniorOrSenior, competitionOrExcercise);
        Registration.add(member);
    }

    public ArrayList<Member> Registration() {
        return getRegistration();
    }
}
