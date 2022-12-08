package fff.delfinen.ui;

import fff.delfinen.Controller;
import fff.delfinen.ExerciseSwimmer;

public class CoachMenu {
    public Controller controller;
    public UserInterface userInterface;
    private final ExerciseSwimmer exerciseSwimmer = new ExerciseSwimmer();

    public CoachMenu(UserInterface userInterface, Controller controller) {
        this.controller = controller;
        this.userInterface = userInterface;
    }
    public void coachMenu() {
        int coachChoice;
        do {
            boolean isRunning;
            boolean writingError;
            System.out.println("Coach menu" +
            "\n----------------------------------------------");
            System.out.println(
                    """
                            1) View exercise teams
                            2) View competition teams
                            3) Top 5 swimmers
                            4) Back to main menu
                            5) Quit program""");

            coachChoice = UserInterface.scanner.nextInt();

            if (coachChoice == 1) {
                exerciseSwimmer.viewExerciseTeams(this);
            } else if (coachChoice == 2) {

            } else if (coachChoice == 3) {

            } else if (coachChoice == 4) {
                userInterface.startMenu();
            }
        } while (coachChoice == 5);
        System.exit(0);
    }
}
