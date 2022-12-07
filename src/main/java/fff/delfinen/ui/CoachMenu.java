package fff.delfinen.ui;

import fff.delfinen.Controller;
import fff.delfinen.Member;

import java.util.Scanner;

public class CoachMenu {
    private Controller controller;
    private UserInterface userInterface;


    public CoachMenu(UserInterface userInterface, Controller controller) {
        this.controller = controller;
        this.userInterface = userInterface;

    }

    // Menu for coach
    void coachMenu() {
        int coachChoice;
        do {
            boolean isRunning;
            boolean writingError;
            System.out.println("Coach menu");
            System.out.println(
                    "1) View exercise teams\n" +
                            "2) View competition teams\n" +
                            "3) Register members swimming discipline\n" +
                            "4) Register result score\n" + //TODO stævne, plecerng, tid
                            "5) View statistics\n" +
                            "6) Back to main menu\n" +
                            "7) Quit program");

            coachChoice = UserInterface.scanner.nextInt();

            if (coachChoice == 1) {
                viewExcerciseTeams();
            } else if (coachChoice == 2) {
                viewCompetitionTeams();
            } else if (coachChoice == 3) {
                registerMembersSwimmingDiscipline();
            } else if (coachChoice == 4) {
                //TODO enklete svømmers bedste træningstid og dato løbende registreres + konkurrencesvømmer registreres stævne, placeing og tid
            } else if (coachChoice == 5) {
                statistics();
            } else if (coachChoice == 5) {
                userInterface.startMenu();
            }
        } while (coachChoice == 6);
        System.exit(0);
    }

    void registerMembersSwimmingDiscipline() {
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

    void viewCompetitionTeams() {
        System.out.println("Choose between junior and senior swimmers");
        System.out.println("Type return if you wish to go back to last menu" +
                "Type Q if you wish to quit the programme");
        Scanner input = new Scanner(System.in);
        String teamInput = input.nextLine().toLowerCase();
        switch (teamInput) {
            case "Jr", "Junior", "junior", "jr":
                for (Member member : userInterface.controller.getMembers()) {
                    if (member.isExercise() == false && member.isJunior())
                        System.out.println(member.getFirstname() + " " + member.getLastname() + " " + member.isExercise());
                    System.out.println("");
                }
            case "Sr", "senior", "Senior", "sr":
                for (Member member : userInterface.controller.getMembers()) {
                    if (member.isExercise() == false && member.isJunior() == false)
                        System.out.println(member.getFirstname() + " " + member.getLastname() + " " + member.isExercise());
                    System.out.println("");
                }
            case "back", "Back", "return", "Return":
                coachMenu();
                break;
            case "Q", "quit", "q":
                System.out.println("Exiting programme");
                System.exit(0);
                break;
            default:
                System.out.println("Wrong input - please try again");
        }
    }

    void viewExcerciseTeams() {

        System.out.println("Choose between junior or senior swimmers");
        System.out.println("Type 'return' if you wish to return to last menu" +
                "Type Q if you wish to quit the programme");

        Scanner input = new Scanner(System.in);
        String coachInput = input.nextLine().toLowerCase();
        boolean isRunning;
        do {
            isRunning = true;
            switch (coachInput) {
                case "Jr", "junior", "Junior", "jr":
                    for (Member member : userInterface.controller.getMembers()) {
                        if (member.isJunior())
                            System.out.println(member.getFirstname() + " " + member.getLastname());//vi vil vælge hvilken værdi der printes));
                        System.out.println(" ");
                    }
                case "Sr", "senior", "Senior", "sr":
                    for (Member member : userInterface.controller.getMembers()) {
                        if (member.isJunior() == false) {
                            System.out.println(member.getFirstname() + " " + member.getLastname());
                            System.out.println(" ");
                        }
                    }
                case "back", "Back", "return", "Return":
                    coachMenu();
                    break;
                case "Q", "quit", "q":
                    System.out.println("Exiting programme");
                    System.exit(0);
                    break;
                default:
                    System.out.println("try again");
            }
        } while (isRunning == false);
    }

    public void statistics() {
        System.out.println(
                "Choose how you would like to see the statistics" +
                        "1) Best swimmers in butterfly \n" +
                        "2) Best swimmers in crawl \n" +
                        "3) Best swimmers in backcrawl \n" +
                        "4) Best swimmers in breast \n " +
                        "5) Return to previous menu\n" +
                        "6) Quit programme");
        Scanner input = new Scanner(System.in);
        int statsInput = input.nextInt();
        switch (statsInput) {
            case 1:
                System.out.println("NOT YET IMPLEMENTED");
                //TODO teamlist sorted by best time in butterfly
            case 2:
                System.out.println("NOT YET IMPLEMENTED");
                //TODO teamlist sorted by best time in crawl
            case 3:
                System.out.println("NOT YET IMPLEMENTED");
                //TODO teamlist sorted by best time in backcrawl
            case 4:
                //TODO teamlist sorted by best time in breast
            case 5:
                coachMenu();

            case 6:
                System.out.println("Exiting programme");
                System.exit(0);

            default:
                System.out.println("Wrong input - please try again");
        }
    }
}
