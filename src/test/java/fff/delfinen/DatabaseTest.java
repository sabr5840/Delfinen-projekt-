package fff.delfinen;

import fff.delfinen.Database;
import fff.delfinen.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    private Database database;

    @BeforeEach
    void setUp() {
        database = new Database();
    }

    @Test
    void registration() {
        database.getMembers().clear(); //Hver gang man kører databasetest, skriv: database.getmembers().clear(); - Slettes igen efter kørt test
        database.addMember("Simone",  "Gottbrecht", LocalDate.ofEpochDay(1992), "Hejvej",
                2100, "København", 28891106, "simo79j5@stud.kea.dk", true, true, true, true);
        database.addMember("Simone",  "Gottbrecht", LocalDate.ofEpochDay(1992), "Hejvej",
                2100, "København", 28891106, "simo79j5@stud.kea.dk", true, true, true, true);
        database.addMember("Simone",  "Gottbrecht", LocalDate.ofEpochDay(1992), "Hejvej",
                2100, "København", 28891106, "simo79j5@stud.kea.dk", true, true, true, true);
        //act on method
        ArrayList<Member> test = database.getMembers();
        //assert result
        assertEquals(3, test.size());

    }

}