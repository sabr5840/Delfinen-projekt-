package fff.delfinen;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

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

    public void loadData(){
        database.loadData();
    }

    // Calls the search method from database
    public Member memberSearch(String searchTerm){
        return database.memberSearch(searchTerm);
    }

    public ArrayList <Member> getMembers(){
        return database.getMembers();
    }


    public boolean deleteMember(String fullName){
        return database.deleteMember(fullName);
    }

    public ArrayList<Member>sort (String sortInput){
        Comparator comparator = new FlexibleComparator(sortInput);
        database.getMembers().sort(comparator);
        return database.getMembers();
    }





}
