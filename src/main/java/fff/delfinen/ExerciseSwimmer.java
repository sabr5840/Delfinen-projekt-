package fff.delfinen;

import fff.delfinen.ui.CoachMenu;

import java.util.Scanner;

public class ExerciseSwimmer {
    public CoachMenu coachMenu = new CoachMenu();
    public Member member = new Member();
    public Controller controller = new Controller();

    public void viewExerciseTeams() {
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
                    for (Member member : controller.getMembers()) {
                        if (member.isJunior())
                            System.out.println(member.getFirstname() + " " + member.getLastname());//vi vil vælge hvilken værdi der printes));
                        System.out.println(" ");
                    }
                case "Sr", "senior", "Senior", "sr":
                    for (Member member : controller.getMembers()) {
                        if (!member.isJunior()) {
                            System.out.println(member.getFirstname() + " " + member.getLastname());
                            System.out.println(" ");
                        }
                    }
                case "back", "Back", "return", "Return":
                    coachMenu.coachMenu();
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

}
