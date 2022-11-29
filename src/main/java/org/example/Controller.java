package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Controller {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    private static final Database database = new Database();
    static boolean isChanged = false;

    public void addMember() {
        database.addMember();
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
        return database.viewMembers();
    }

    public void editData() {
        isChanged = true;

    }

    public void searchMember() {
        String searchTerm = scanner.nextLine();

    }

}
