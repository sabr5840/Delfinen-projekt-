package fff.delfinen.ui;

import fff.delfinen.CompetitiveSwimmer;
import fff.delfinen.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class CoachMenu{

    // Menu for coach
    void coachMenu(UserInterface userInterface) {
        int coachChoice;
        do {
            boolean isRunning;
            boolean writingError;
            System.out.println("Coach menu");
            System.out.println("1) View exercise teams\n" +
                    "2) View competition teams\n" +
                    "3) Register members swimming discipline\n" +
                    "4) Register result score\n" + //TODO stævne, plecerng, tid
                    "5) View statistics\n" +
                    "6) Back to main menu\n" +
                    "7) Quit program");

            coachChoice = userInterface.scanner.nextInt();

            if (coachChoice == 1) {
                viewExcerciseTeams(userInterface);

            } else if (coachChoice == 2) {
                viewCompetitionTeams(userInterface);
            } else if (coachChoice == 3) {
                registerMembersSwimmingDiscipline();

            } else if (coachChoice == 4) {
                //TODO enklete svømmers bedste træningstid og dato løbende registreres + konkurrencesvømmer registreres stævne, placeing og tid

            } else if (coachChoice == 5) {
                System.out.println("Choose how you would like to see the statistics" +
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
                        System.out.println("TEST");
                        //TODO teamlist sorted by best time in butterfly
                        break;
                    case 2:
                        System.out.println("TEST");
                        //TODO teamlist sorted by best time in crawl
                        break;
                    case 3:
                        System.out.println("TEST");
                        //TODO teamlist sorted by best time in backcrawl
                        break;
                    case 4:
                        //TODO teamlist sorted by best time in breast
                        break;
                    case 5:
                        coachMenu(userInterface);
                        break;
                    case 6:
                        System.out.println("Exiting programme");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong input - please try again");
                }

            } else if (coachChoice == 5) {
                userInterface.startMenu();
            }
        } while (coachChoice == 6);
        System.exit(0);
    }

    private void registerMembersSwimmingDiscipline() {
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








       //

      //  System.out.println("Would you like to register more disciplines: yes or no?");
        //TODO add discipline to list //if else//save


    private void viewCompetitionTeams(UserInterface userInterface) {
        System.out.println("Choose between junior and senior swimmers");
        System.out.println("Type return if you wish to go back to last menu" +
                "Type Q if you wish to quit the programme");
        Scanner input = new Scanner(System.in);
        String teamInput = input.nextLine().toLowerCase();
        switch (teamInput) {
            case "Jr", "Junior", "junior", "jr":
                System.out.println("TEST");
                //TODO memberList of juniors sorted by alphabetical order and discipline //simone : crawl, butterfly
                break;
            case "Sr", "senior", "Senior", "sr":
                System.out.println("TEST");
                //TODO memberList of seniors sorted by alphabetical order and discipline// naja : backcrawl
                break;
            case "back", "Back", "return", "Return":
                coachMenu(userInterface);
                break;
            case "Q", "quit", "q":
                System.out.println("Exiting programme");
                System.exit(0);
                break;
            default:
                System.out.println("Wrong input - please try again");
        }
    }

    private void viewExcerciseTeams(UserInterface userInterface) {
        System.out.println("Choose between junior or senior swimmers");
        System.out.println("Type 'return' if you wish to return to last menu" +
                "Type Q if you wish to quit the programme");

        Scanner input = new Scanner(System.in);
        String coachInput = input.nextLine().toLowerCase();
        switch (coachInput) {
            case "Jr", "junior", "Junior", "jr":
                for (Member member : userInterface.controller.getMembers()) {
                    if (member.isJunior())
                        System.out.println(member.getFirstname());//vi vil vælge hvilken værdi der printes));
                }
                break;
            case "Sr", "senior", "Senior", "sr":
            for (Member member : userInterface.controller.getMembers()){
                if (member.isJunior() == false){
                    System.out.println(member.getFirstname() + member.getLastname());
                }
            }
                System.out.println(userInterface.member.isExercise());
                //TODO members list of senior swimmers by last name
                break;
            case "back", "Back", "return", "Return":
                coachMenu(userInterface);
                break;
            case "Q", "quit", "q":
                System.out.println("Exiting programme");
                System.exit(0);
                break;
            default:
                System.out.println("try again");
        }
    }
}
