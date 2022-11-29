package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Controller {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    private static final Database database = new Database();
    static boolean isChanged = false;

    public void addMember(String firstname, String lastname, int birthYear, String address, int postalCode, String city, int phoneNo, String eMail,
                         boolean passive, boolean junior, boolean exercise, boolean hasPaid) {
        database.addMember(firstname, lastname, birthYear, address, postalCode, city, phoneNo, eMail, passive, junior, exercise, hasPaid);
        isChanged = true;
    }

    public void saveData() throws FileNotFoundException {
        Filehandler filehandler = new Filehandler();
        filehandler.saveData(database.members());
        isChanged = true;

    }

    public void loadData() throws FileNotFoundException {
        Filehandler filehandler = new Filehandler();
        ArrayList<Member> members = filehandler.loadData();
        database.updateMemberList(members);
        isChanged = true;
    }

    public ArrayList<Member> viewMembers() {
        return database.getMembers();
    }

    public void editData() {
        isChanged = true;

    }

    public void searchMember() {
        String searchTerm = scanner.nextLine();

    }



}
