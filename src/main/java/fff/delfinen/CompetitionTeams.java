package fff.delfinen;

import java.time.LocalDate;
import java.util.Scanner;

import fff.delfinen.ui.ChairmanMenu;
import fff.delfinen.ui.CoachMenu;
import fff.delfinen.ui.UserInterface;

import static fff.delfinen.ui.UserInterface.member;
import static fff.delfinen.ui.UserInterface.scanner;

public class CompetitionTeams {

    private final ChairmanMenu chairmanMenu = new ChairmanMenu(new Controller(), new UserInterface());

    String crawl = "crawl";
    String backcrawl = "backcrawl";
    String breaststroke = "breaststroke";
    String butterfly = "butterfly";

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

        System.out.println("Type which discipline you wish to add to the member");
        String discipline = scanner.nextLine().toLowerCase();
        if (discipline == crawl) {
            member.setDiscipline(crawl);
            System.out.println("Discipline is set to crawl");
        } else if (discipline == backcrawl) {
            member.setDiscipline(backcrawl);
            System.out.println("Discipline is set to backcrawl");
        } else if (discipline == breaststroke) {
            member.setDiscipline(breaststroke);
            System.out.println("Discipline is set to breaststroke");
        } else if (discipline == butterfly) {
            member.setDiscipline(butterfly);
            System.out.println("Discipline is set to butterfly");
        }
    }

    public void viewCompetitionTeams() {
        System.out.println("Which team do you wish to see");
        System.out.println("e.g crawl, backcrawl, breaststroke or butterfly");

        String input;
        input = scanner.nextLine().toLowerCase();
        switch (input) {
            case "crawl":
                System.out.println(member.getDiscipline());
            case "backcrawl":
                System.out.println(member.getDiscipline());
            case "breaststroke":
                System.out.println(member.getDiscipline());
            case "butterfly":
                System.out.println(member.getDiscipline());
        }
    }
}
