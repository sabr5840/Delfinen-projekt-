package fff.delfinen.ui;
import Comparator.FlexibleComparator;
import fff.delfinen.Controller;
import fff.delfinen.Member;
import fff.delfinen.Payments;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

import static fff.delfinen.ui.UserInterface.scanner;

public class CashierMenu {

    public Controller controller;
    public UserInterface userInterface;
    private final Payments payments = new Payments();

    public CashierMenu(Controller controller, UserInterface userInterface) {
        this.controller = controller;
        this.userInterface = userInterface;
    }

    void cashierMenu() {
        int cashierChoice;
        do {
            boolean isRunning;
            boolean writingError;
            System.out.println("\nCashier menu" +
                    "\n----------------------------------------------");
            System.out.println("""
                    1) View payment status for all members
                    2) View payment status by membership-type
                    3) View members who are past due
                    4) Edit payment status
                    5) Payment overview
                    6) Return to main menu
                    7) Quit program
                    """);
            cashierChoice = scanner.nextInt();
            if (cashierChoice == 1) {
                payments.viewPaymentStatusAllMembers();
            } else if (cashierChoice == 2) {
                payments.sortMemberPastDue(this);

            } else if (cashierChoice == 3) {
                payments.viewMemberPastDue();

            } else if (cashierChoice == 4) {
                payments.editPaymentStatus(this);

            } else if (cashierChoice == 5) {
                payments.paymentOverview(this);

            } else if (cashierChoice == 6) {
                userInterface.startMenu();
            }
            isRunning = false;
        } while (cashierChoice != 7);
        quitProgramme();
    }

    private void quitProgramme() {
        System.out.println("Exiting programme");
        System.exit(0);
    }

}
