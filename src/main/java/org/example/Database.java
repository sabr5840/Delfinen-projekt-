package org.example;

import java.util.ArrayList;

public class Database {

    // Arraylist
    private ArrayList<Member> members = new ArrayList<>();

    //Getter for arraylist
    public ArrayList<Member> getMembers(){
        return members;
    }

    public void Registration(String name, int birthYear, String address, int zipCode, String city, int number, String eMail,
                          boolean passiveOrActiveMember, boolean juniorOrSenior, boolean competitionOrExcercise){

        Member member = new Member(name, birthYear, address, zipCode, city, number, eMail, passiveOrActiveMember, juniorOrSenior, competitionOrExcercise);
        members.add(member);
    }

    public ArrayList<Member> members() {
        return getMembers();
    }

    public ArrayList<Member> viewMembers() {
        return members;
    }
    public void updateMemberList(ArrayList<Member> members) {
        members = members;
    }

}


