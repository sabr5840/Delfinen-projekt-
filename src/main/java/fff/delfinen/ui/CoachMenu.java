package fff.delfinen.ui;

import fff.delfinen.Controller;
import fff.delfinen.ExerciseTeams;

public class CoachMenu {
    public Controller controller;
    public UserInterface userInterface;
    private final ExerciseTeams exerciseTeams = new ExerciseTeams();

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
                            2) Add member to competition team - not implemented
                            2) View competition teams - not implemented
                            3) Back to main menu
                            4) Quit program""");

            coachChoice = UserInterface.scanner.nextInt();

            if (coachChoice == 1) {
                exerciseTeams.viewExerciseTeams(this);
            } else if (coachChoice == 2) {
                //competitionTeams.setCompetitionTeams();
            } else if (coachChoice == 3) {
                //competitionTeams.viewCompetitionTeams();
            } else if (coachChoice == 4) {
                userInterface.startMenu();
            }
        } while (coachChoice == 5);
        System.exit(0);
    }
}