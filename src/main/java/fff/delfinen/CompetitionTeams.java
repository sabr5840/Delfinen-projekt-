package fff.delfinen;

import java.time.LocalDate;
import java.util.Scanner;

import fff.delfinen.ui.ChairmanMenu;
import fff.delfinen.ui.CoachMenu;
import fff.delfinen.ui.UserInterface;

import static fff.delfinen.ui.UserInterface.scanner;


public class CompetitionTeams extends Member {

    private final ChairmanMenu chairmanMenu = new ChairmanMenu();

    String crawl;
    String backcrawl;
    String breaststroke;
    String butterfly;

    public CompetitionTeams(String firstname, String lastname, LocalDate birthDate, String address, int postalCode, String city, int phoneNo, String eMail, boolean passive, boolean junior, boolean exercise, boolean Paid, String crawl, String backcrawl, String breaststroke, String butterfly) {
        super(firstname, lastname, birthDate, address, postalCode, city, phoneNo, eMail, passive, junior, exercise, Paid);
        this.crawl = crawl;
        this.backcrawl = backcrawl;
        this.breaststroke = breaststroke;
        this.butterfly = butterfly;
    }

    public CompetitionTeams() {
    }

    public String getCrawl() {
        return crawl;
    }

    public void setCrawl(String crawl) {
        this.crawl = crawl;
    }

    public String getBackcrawl() {
        return backcrawl;
    }

    public void setBackcrawl(String backcrawl) {
        this.backcrawl = backcrawl;
    }

    public String getBreaststroke() {
        return breaststroke;
    }

    public void setBreaststroke(String breaststroke) {
        this.breaststroke = breaststroke;
    }

    public String getButterfly() {
        return butterfly;
    }

    public void setButterfly(String butterfly) {
        this.butterfly = butterfly;
    }

    public void setCompetitionTeams() {
        System.out.println("Search for member you wish to add to a competition team");
        scanner.nextLine();
        System.out.println("Type in full name for desired member to edit ");
        String fullName = scanner.nextLine();
        Member CompetitionTeams = chairmanMenu.controller.memberSearch(fullName);

        System.out.println("type wich discipline you wish to add to the member");
        String discipline = scanner.nextLine().toLowerCase();
        if (discipline == crawl) {
            setCrawl(crawl);
        } else if (discipline == backcrawl) {
            setBackcrawl(backcrawl);
        } else if (discipline == breaststroke) {
            setBreaststroke(breaststroke);
        } else if (discipline == butterfly) {
            setButterfly(butterfly);
        }
    }

    public void viewCompetitionTeams() {
        System.out.println("which team do you wish to see");
        System.out.println("e.g crawl, backcrawl, breaststroke or butterfly");

        String input;
        input = scanner.nextLine().toLowerCase();
        switch (input) {
            case "crawl":
                System.out.println(getCrawl());
            case "backcrawl":
                System.out.println(getBackcrawl());
            case "breaststroke":
                System.out.println(getBreaststroke());
            case "butterfly":
                System.out.println(getButterfly());
        }
    }
}
