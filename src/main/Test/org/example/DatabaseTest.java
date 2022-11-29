package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        database.addMember("Simone",  "Gottbrecht", 1992, "Hejvej",
                2100, "København", 28891106, "simo79j5@stud.kea.dk", true, true, true, true);
        database.addMember("Simone",  "Gottbrecht", 1992, "Hejvej",
                2100, "København", 28891106, "simo79j5@stud.kea.dk", true, true, true, true);
        database.addMember("Simone",  "Gottbrecht", 1992, "Hejvej",
                2100, "København", 28891106, "simo79j5@stud.kea.dk", true, true, true, true);
        //act on method
        ArrayList<Member> test = database.getMembers();
        //assert result
        assertEquals(3, test.size());

    }

}