package fff.delfinen;

import java.time.LocalDate;

public class CompetitionTeams extends Member {
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
}
