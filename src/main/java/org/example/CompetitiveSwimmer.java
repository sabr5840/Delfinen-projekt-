package org.example;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CompetitiveSwimmer extends Member {
    private boolean breast;
    private boolean crawl;
    private boolean backCrawl;
    private boolean butterfly;
    private double registerTime;
    private String competitiveJunior;
    private String competitiveSenior;


    public CompetitiveSwimmer(String firstName, String lastName, LocalDate birthDate, String address, int postalCode, String city, int phoneNo, String eMail, boolean passive, boolean junior, boolean exercise, boolean hasPaid) {
        super(firstName, lastName, birthDate, address, postalCode, city, phoneNo, eMail, passive, junior, exercise, hasPaid);
        this.breast = breast;
        this.crawl = crawl;
        this.backCrawl = backCrawl;
        this.butterfly = butterfly;
        this.registerTime = registerTime;
        this.competitiveJunior = competitiveJunior;
        this.competitiveSenior = competitiveSenior;
    }

    public static CompetitiveSwimmer breastSwimmer(String firstName, String lastName, LocalDate birthDate, String address, int postalCode, String city, int phoneNo, String eMail, boolean passive, boolean junior, boolean exercise, boolean hasPaid, double registerTime, String competitiveJunior, String competitiveSenior) {
        return new CompetitiveSwimmer(
                firstName,
                lastName,
                birthDate,
                address,
                postalCode,
                city,
                phoneNo,
                eMail,
                passive,
                junior,
                exercise,
                hasPaid
        );
    }

    public void chooseBreast() {
        ArrayList<CompetitiveSwimmer> breastList = new ArrayList<>();
        CompetitiveSwimmer competitiveSwimmer = new CompetitiveSwimmer(getFirstname(), getLastname(), getBirthDate(),
                getAddress(), getPostalCode(), getCity(), getPhoneNo(), geteMail(), isJunior(), isExercise(), isHasPaid(),
                getBreast());

        breastList.add(competitiveSwimmer);
        breast = true;

        returnBreast();
    }

    public String returnBreast() {

        if (breast) {
            return "Chosen";
        } else {
            return "Not chosen";
        }
    }

    public boolean getBreast() {
        return breast;
    }

    public void setBreast(boolean breast) {
        this.breast = breast;
    }

    public boolean getCrawl() {
        return crawl;
    }

    public void setCrawl(boolean crawl) {
        this.crawl = crawl;
    }

    public boolean getBackCrawl() {
        return backCrawl;
    }

    public void setBackCrawl(boolean backCrawl) {
        this.backCrawl = backCrawl;
    }

    public boolean getButterfly() {
        return butterfly;
    }

    public void setButterfly(boolean butterfly) {
        this.butterfly = butterfly;
    }

    public double getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(double registerTime) {
        this.registerTime = registerTime;
    }

    public String getCompetitiveJunior() {
        return competitiveJunior;
    }

    public void setCompetitiveJunior(String competitiveJunior) {
        this.competitiveJunior = competitiveJunior;
    }

    public String getCompetitiveSenior() {
        return competitiveSenior;
    }

    public void setCompetitiveSenior(String competitiveSenior) {
        this.competitiveSenior = competitiveSenior;
    }

    public void chooseDiscipline() {
        ArrayList<CompetitiveSwimmer> competitiveSwimmers;
        boolean isRunning = true;
        do {
            System.out.println("Please select swimming discipline:");
            System.out.println("1. Breast\n2. Crawl\n3. Back Crawl\n4. Butterfly\n5. Return\n6. Exit\n");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            scanner.nextLine();
            switch (userInput) {
                case 1:
                    chooseBreast();
                    break;
                case 2:
                    //chooseCrawl();
                    break;
                case 3:
                    //chooseBackCrawl();
                    break;
                case 4:
                    //chooseButterfly();
                    break;
                case 5:
                    //TODO: Back to coach menu
                    break;
                case 6:
                    System.out.println("Exiting programme");
                    System.exit(0);
            }
        } while (isRunning);
    }

    public void registerTime() {
        ArrayList<CompetitiveSwimmer> competitiveSwimmers;
    }

    public void registerCrawl(Duration timing) {
        Database.crawlList.add(new SwimTiming(this, timing));
    }

    public void viewCrawl() {
        for (SwimTiming swimTiming : Database.crawlList) {
            System.out.println(swimTiming);
        }
    }

    public String returnCrawl() {

        if (crawl) {
            return "Chosen";
        } else {
            return "Not chosen";
        }
    }

    public void registerBackCrawl(Duration timing) {
        Database.backCrawlList.add(new SwimTiming(this, timing));

    }

    public void registerBreast(Duration timing) {
        Database.breastList.add(new SwimTiming(this, timing));
    }

    public String viewBreast() {
        for (SwimTiming swimTiming : Database.breastList) {
            System.out.println(swimTiming);
        }
        {
            breast = true;
        }

        return null;
    }

}
   /* }
        public void chooseBackCrawl() {
            ArrayList<CompetitiveSwimmer> competitiveSwimmers;
            CompetitiveSwimmer competitiveSwimmer = new CompetitiveSwimmer(getFirstname(), getLastname(), getBirthDate(),
                    getAddress(), getPostalCode(), getCity(), getPhoneNo(), geteMail(), isPassive(), isJunior(),
                    isExercise(), isHasPaid());

        }

    }

}
*/




