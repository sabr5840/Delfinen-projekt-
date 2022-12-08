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
                payments.viewPaymentStatusByMembership(this);

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

    public void sortMemberPastDue(UserInterface userInterface) {

        int userInput = 0;
        boolean inputError;
        String sortedInput = "";

        System.out.println("Choose how you would like to sort members\n");
        System.out.println("1) Sort member list by active/passive membership");
        System.out.println("2) Sort member list by junior/senior member");
        System.out.println("3) Sort member list by exerciser or competitive swimmer");

        ArrayList<Member> sortedList = controller.getMembers();

        try {
            userInput = scanner.nextInt();
            scanner.nextLine();
            for (Member member : sortedList) {
                switch (userInput) {
                    case 1 -> {
                        Collections.sort(sortedList, new FlexibleComparator(sortedInput));
                        System.out.println("Active/passive membership status list\n");
                        System.out.println("Full name: " + member.getFirstname() + " " + member.getLastname() + "\n" + "Subscription status: " + member.isPaid());
                    }
                    case 2 -> {
                        Collections.sort(sortedList, new FlexibleComparator(sortedInput));
                        System.out.println("junior/senior member status list\n");
                        System.out.println("Full name: " + member.getFirstname() + " " + member.getLastname() + "\n" + "Subscription status: " + member.isPaid());
                    }
                    case 3 -> {
                        Collections.sort(sortedList, new FlexibleComparator(sortedInput));
                        System.out.println("Exerciser or competitive swimmer list\n");

                        System.out.println("Full name: " + member.getFirstname() + " " + member.getLastname() + "\n" + "Subscription status: " + member.isPaid());
                    }
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Wrong input ");
            inputError = true;
            scanner.nextLine();
        }


    }
}
