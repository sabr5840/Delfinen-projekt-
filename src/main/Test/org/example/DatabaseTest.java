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
        database.registration("Simone Gottbrecht Pedersen", 1992, "Hejvej 8", 2100,
                "Copenhagen", 28891106, "simo79j5@stud.kea.dk", true, true, true);
        database.registration("Naja", 1992, "Mågevej 7", 2600, "Hillerød",
                56784399, "najamoe@gmal.com", true, true, true);
        database.registration("Sabrina Hammerich", 2001, "Belvederevej 8", 4500, "Helsingør",
                66666666, "sab456@stud.kea.dk", true, true, true);

        //act on method
        ArrayList<Member> test = database.getMembers();
        //assert result
        assertEquals(3, test.size());

    }

}