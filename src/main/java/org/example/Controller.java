package org.example;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Controller {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    private Database database = new Database();
    boolean isChanged = false;

    public void addMember(String firstname, String lastname, LocalDate birthYear, String address, int postalCode, String city, int phoneNo, String eMail,
                          boolean passive, boolean junior, boolean exercise, boolean hasPaid) {
        database.addMember(firstname, lastname, birthYear, address, postalCode, city, phoneNo, eMail, passive, junior, exercise, hasPaid);
        isChanged = true;
    }

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


    public void editData() {
        isChanged = true;

    }
}
