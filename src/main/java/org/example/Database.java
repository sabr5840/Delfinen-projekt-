package org.example;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Database {
    Filehandler filehandler = new Filehandler();
    public static ArrayList<SwimTiming> crawlList = new ArrayList<>();
    public static ArrayList<SwimTiming> breastList = new ArrayList<>();
    public static ArrayList<SwimTiming> backCrawlList = new ArrayList<>();
    public static ArrayList<SwimTiming> butterflyList = new ArrayList<>();

    // Arraylist
    public ArrayList<Member> members = new ArrayList<>();

    //Getter for arraylist of members
    public ArrayList<Member> getMembers() {
        return members;
    }

    public void addMember(String firstname, String lastname, LocalDate birthDate, String address, int postalCode, String city, int phoneNo, String eMail,
                          boolean passive, boolean junior, boolean exercise, boolean hasPaid) {

        Member member = new Member(firstname, lastname, birthDate, address, postalCode, city, phoneNo, eMail, passive, junior, exercise, hasPaid);
        members.add(member);

        System.out.println(members);
    }


    public ArrayList<Member> searchFor(String searchTerm) {
       ArrayList<Member> searchResult = new ArrayList<>();

       for (Member member : members){
           if (member.getFirstname().equalsIgnoreCase(searchTerm)){
               searchResult.add(member);
           }
       }
       return searchResult;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public boolean deleteMember(Member member){
        boolean succes;
        succes = members.remove(member);
        return succes;
    }

    public void loadData() throws FileNotFoundException {
        Filehandler filehandler = new Filehandler();
        this.members = filehandler.loadData();


        //isChanged = true;
    }

}


