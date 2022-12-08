package fff.delfinen.ui;
import fff.delfinen.Controller;
import fff.delfinen.MemberEditing;
import java.util.Scanner;

public class ChairmanMenu {
    public Controller controller;
    public UserInterface userInterface;
    private final MemberEditing memberEditing = new MemberEditing();

    public ChairmanMenu(Controller controller, UserInterface userInterface) {
        this.controller = controller;
        this.userInterface = userInterface;
    }

    public void viewChairmanMenu() {
        int chairmanChoice = 0;
        boolean isRunning = true;
        boolean writingError;
        do {
            System.out.println("Chairman menu"+
            "\n----------------------------------------------");
            System.out.println(
                    """
                            1) Registration of new member
                            2) Edit member information
                            3) Delete member
                            4) Search for member
                            5) View all members
                            6) Return to main menu
                            7) Quit program
                            """);
            chairmanChoice = UserInterface.scanner.nextInt();
            if (chairmanChoice == 1) {
                memberEditing.registerMember(userInterface, this);
            } else if (chairmanChoice == 2) {
                memberEditing.editMember(this);
            } else if (chairmanChoice == 3) {
                memberEditing.deleteMember(this);
            } else if (chairmanChoice == 4) {
                memberEditing.searchMember(this);
            } else if (chairmanChoice == 5) {
                memberEditing.viewMembers(this);
            } else if (chairmanChoice == 6) {
                userInterface.startMenu();
            }
            isRunning = false;
        } while (chairmanChoice != 7);
        System.out.println("Exiting programme");
        System.exit(0);
    }
}
