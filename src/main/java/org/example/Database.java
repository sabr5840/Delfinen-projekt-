package org.example;

import java.util.ArrayList;

public class Database {

    // Arraylist
    private ArrayList<Member> members = new ArrayList<>();

    //Getter for arraylist
    public ArrayList<Member> getMembers() {
        return members;
    }

    public void addMember(String firstname, String lastname, int birthYear, String address, int zipCode, String city, int number, String eMail,
                             boolean passive, boolean junior, boolean excercise) {

        Member member = new Member();
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

    public void addMember() {
    }
}


