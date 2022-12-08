package fff.delfinen;

import fff.delfinen.ui.CoachMenu;
import fff.delfinen.ui.UserInterface;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CompetitiveSwimmer extends Member {

UserInterface userInterface = new UserInterface();

    private boolean breast;
    private boolean crawl;
    private boolean backCrawl;
    private boolean butterfly;
    private double registerTime;
    private String competitiveJunior;
    private String competitiveSenior;
    private String exerciseJunior;
    private String exerciseSenior;


    public CompetitiveSwimmer() {
        this.registerTime = registerTime;
    }

    public void chooseBreast() {
        ArrayList<CompetitiveSwimmer> breastList = new ArrayList<>();
        CompetitiveSwimmer competitiveSwimmer = new CompetitiveSwimmer(
        );

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

    public void getCompetitiveJunior() {
    }

    public void setCompetitiveJunior(String competitiveJunior) {
        this.competitiveJunior = competitiveJunior;
    }

    public String getExerciseSenior(String exerciseSenior) {
        return exerciseSenior;
    }

    public String getExerciseJunior(String exerciseJunior) {
        return exerciseJunior;
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

    public void registerMembersSwimmingDiscipline() {
        boolean isRunning = true;
        Scanner input = new Scanner(System.in);
        System.out.println("Register competitive swimmers and their disciplines \n " +
                "\nWhich member would you like to register?");
        input.next();
        String statsInput = input.next();
        System.out.println("Which discipline would you like to register? (ex. Butterfly, Crawl, Backcrawl or Breast)");


        switch (statsInput) {
            case "breast", "Breast" -> System.out.println("U choose breast good day my lady");

            case "Butterfly", "butterfly" -> System.out.println("TEST");

            //TODO teamlist sorted by best time in crawl
            case "E" -> System.out.println("TEST");

            //TODO teamlist sorted by best time in backcrawl
            case "C" -> System.out.println();

            //TODO teamlist sorted by best time in breast

            case "A" -> {
                System.out.println("Exiting programme");
                System.exit(0);
            }
            default -> System.out.println("Wrong input - please try again");
        }
    }

    public void viewCompetitionTeams(CoachMenu coachMenu) {
        System.out.println("Choose between junior and senior swimmers");
        System.out.println("Type return if you wish to go back to last menu" +
                "Type Q if you wish to quit the programme");
        Scanner input = new Scanner(System.in);
        String teamInput = input.nextLine().toLowerCase();
        switch (teamInput) {
            case "junior", "jr":
                for (Member member : coachMenu.userInterface.controller.getMembers()) {
                    if (!member.isExercise() && member.isJunior())
                        System.out.println(member.getFirstname() + " " + member.getLastname() + " " + member.isExercise());
                    System.out.println("");
                }
            case "senior", "sr":
                for (Member member : coachMenu.userInterface.controller.getMembers()) {
                    if (!member.isExercise() && !member.isJunior())
                        System.out.println(member.getFirstname() + " " + member.getLastname() + " " + member.isExercise());
                    System.out.println("");
                }
            case "back", "return":
                coachMenu.coachMenu();
                break;
            case "quit", "q":
                System.out.println("Exiting programme");
                System.exit(0);
                break;
            default:
                System.out.println("Wrong input - please try again");
        }
    }
    public void statistics() {
        System.out.println(
                """
                        Choose how you would like to see the statistics:\s
                        1) Best swimmers in butterfly\s
                        2) Best swimmers in crawl\s
                        3) Best swimmers in backcrawl\s
                        4) Best swimmers in breast\s
                        5) Return to previous menu
                        6) Quit programme""");
        Scanner input = new Scanner(System.in);
        int statsInput = input.nextInt();


        switch (statsInput) {
            case 1:
                System.out.println("NOT YET IMPLEMENTED");
                //TODO teamlist sorted by best time in butterfly
                break;
            case 2:
                System.out.println("NOT YET IMPLEMENTED..");
                //TODO teamlist sorted by best time in crawl
                break;
            case 3:
                System.out.println("NOT YET IMPLEMENTED.");
                //TODO teamlist sorted by best time in backcrawl
                break;
            case 4:
                //TODO teamlist sorted by best time in breast
                break;
            case 5:
                //ååååååååååhhhhh
                break;
            case 6:
                System.out.println("Exiting programme");
                System.exit(0);
                break;
            default:
                System.out.println("Wrong input - please try again");
        }

}
    /*
        public void chooseBackCrawl() {
            ArrayList<CompetitiveSwimmer> competitiveSwimmers;
            CompetitiveSwimmer competitiveSwimmer = new CompetitiveSwimmer(getFirstname(), getLastname(), getBirthDate(),
                    getAddress(), getPostalCode(), getCity(), getPhoneNo(), geteMail(), isPassive(), isJunior(),
                    isExercise(), isPaid());

        }
*/
    }








