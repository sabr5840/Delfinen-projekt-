package fff.delfinen;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Database {
    public static ArrayList<Member> members = new ArrayList<>();

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


    public Member memberSearch(String fullName) {

        for (Member member : members) {
            String name = member.getFirstname().toLowerCase() + " " + member.getLastname().toLowerCase();
            if (name.equals(fullName.toLowerCase())) {
                return member;
            }
        }
        return null;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public boolean deleteMember(String fullName) {
        Member member = memberSearch(fullName);
        if (member == null) {
            return false;
        }
        return getMembers().remove(member);
    }


    public void loadData() {
        Filehandler filehandler = new Filehandler();
        try {
            this.members = filehandler.loadData();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        //isChanged = true;
    }

}


