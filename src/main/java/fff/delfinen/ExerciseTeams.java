package fff.delfinen;
import fff.delfinen.ui.CoachMenu;
import fff.delfinen.ui.UserInterface;
import fff.delfinen.Database;

import java.util.Scanner;

public class ExerciseTeams {
public void viewExerciseTeams(CoachMenu coachMenu) {

        System.out.println("Choose between junior or senior swimmers");
        System.out.println("Type 'return' if you wish to return to last menu" +
                "Type Q if you wish to quit the programme");

        Scanner input = new Scanner(System.in);
        String coachInput = input.nextLine().toLowerCase();
        boolean isRunning;
        do {
            isRunning = true;
            switch (coachInput) {
                case "junior", "jr":
                    for (Member member : coachMenu.controller.getMembers()) {
                        if (member.isJunior()) {
                            System.out.println(member.getFirstname() + " " + member.getLastname());
                            System.out.println(" ");
                        }
                    }
                case "sr", "senior":
                    for (Member member : coachMenu.controller.getMembers()) {
                        if (member.isJunior() == false) {
                            System.out.println(member.getFirstname() + " " + member.getLastname());
                            System.out.println(" ");
                        }
                    }
                case "back","return":
                    coachMenu.coachMenu();
                    break;
                case "quit", "q":
                    System.out.println("Exiting programme");
                    System.exit(0);
                    break;
                default:
                    System.out.println("try again");
            }
        } while (!isRunning);
    }
}
