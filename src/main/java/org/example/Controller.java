package org.example;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;
import Comparator.FlexibleComparator;

public class Controller {

    private Filehandler filehandler = new Filehandler();
    private Database database = new Database();
    boolean isChanged = false;

    public void addMember(String firstname, String lastname, LocalDate birthYear, String address, int postalCode, String city, int phoneNo, String eMail,
                          boolean passive, boolean junior, boolean exercise, boolean hasPaid) throws FileNotFoundException {
        database.addMember(firstname, lastname, birthYear, address, postalCode, city, phoneNo, eMail, passive, junior, exercise, hasPaid);
        filehandler.saveData(database.getMembers());
        isChanged = true;
    }

    // Calls the search method from database
    public ArrayList<Member> searchFor (String searchTerm){
        return database.searchFor(searchTerm);
    }

    public ArrayList <Member> getMembers(){
        return database.getMembers();
    }

    public void saveData() throws FileNotFoundException {
        Filehandler filehandler = new Filehandler();
        filehandler.saveData(database.getMembers());
        isChanged = true;

    }

    // Calls the delete method from database
    public void deleteMember (Member deleteMember){
        database.deleteMember(deleteMember);
    }


    public void editData() {
        isChanged = true;

    }

    public ArrayList<Member>sort (String sortInput){
        Comparator comparator = new FlexibleComparator(sortInput);
        database.getMembers().sort(comparator);
        return database.getMembers();
    }
}
