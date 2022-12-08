package fff.delfinen;

import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

class PaymentsTest {

    @org.junit.jupiter.api.Test
    void expectedPaymentTotal() {
        Payments payments = new Payments();
        int total = payments.expectedPaymentTotal();
        assertEquals(3600, total);
    }
    @BeforeEach
    void setUp() {
        Database database = new Database(); {
            database.addMember("Simone",  "Gottbrecht", LocalDate.ofEpochDay(1992), "Hejvej 8",
                    2100, "København", 28891106, "simo79j5@stud.kea.dk", true, false, true, true);
            database.addMember("Naja", "Moe", LocalDate.ofEpochDay(1950), "Kollegiet",
                    2950, "Vedbæk", 23322332, "asdf@.dk", false, false, false, false);
            database.addMember("Camilla", "Kløjgaard", LocalDate.ofEpochDay(1945), "Kollegiet 4",
                    2950, "Vedbæk", 32322332, "@@@.co", true, false, false, true);
            database.addMember("Mathilde", "Baby", LocalDate.ofEpochDay(2010), "Flotvej 4",
                    3400, "Hillerød", 34433443, "mathilde@dot.com", false, true,false, true);
        }
    }
}