package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Controller {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    private static final Database database = new Database();
    static boolean isChanged = false;

    public void saveData(String firstname, String lastname, int birthYear, String address, int zipCode, String city, int number, String eMail,
                         boolean passiveOrActiveMember, boolean juniorOrSenior, boolean competitionOrExcercise) {
        database.Registration(firstname, lastname, birthYear, address, zipCode, city, number, eMail, passiveOrActiveMember, juniorOrSenior, competitionOrExcercise);
        isChanged = true;
    }

    public void saveData(ArrayList<Member> members) throws FileNotFoundException {
        Filehandler filehandler = new Filehandler();
        filehandler.saveData(members);
        isChanged = true;

    }

    public void loadData() throws FileNotFoundException {
        Filehandler filehandler = new Filehandler();
        ArrayList<Member> members = filehandler.loadData();
        database.updateMemberList(members);
        isChanged = true;
    }

    public ArrayList<Member> viewMembers() {
        return database.viewMembers();
    }

    public void editData() {
        isChanged = true;

    }

    public void searchMember() {
        String searchTerm = scanner.nextLine();

    }

}
