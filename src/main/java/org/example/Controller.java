package org.example;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Controller {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    private static final Database database = new Database();
    static boolean isChanged = false;

    public void saveData(String name, int birthYear, String address, int zipCode, String city, int number, String eMail,
                                    boolean passiveOrActiveMember, boolean juniorOrSenior, boolean competitionOrExcercise) {
        database.Registration(name,birthYear, address, zipCode, city, number, eMail, passiveOrActiveMember, juniorOrSenior, competitionOrExcercise);
        isChanged = true;
    }

    public void saveData() throws FileNotFoundException {
        Filehandler filehandler = new Filehandler();
        filehandler.saveData(database.Registration());
        isChanged = true;
    }

}
