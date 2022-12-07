package fff.delfinen.ui;

import fff.delfinen.Controller;
import fff.delfinen.Member;

import java.util.ArrayList;

public class CashierMenu {

    private Controller controller;
    private UserInterface userInterface;

    public CashierMenu(Controller controller, UserInterface userInterface) {
        this.controller = controller;
        this.userInterface = userInterface;
    }

    // Menu for cashier
    void cashierMenu() {
        int cashierChoice;
        do {
            boolean isRunning;
            boolean writingError;
            System.out.println("Cashier menu");
            System.out.println("1) View payment status for all members\n" +
                    "2) View payment status by membership-type\n" +
                    "3) View members who are past due" + "\n" +
                    "4) Edit payment status\n" +
                    "5) Payment overview\n" +
                    "6) Return to main men\n" +
                    "7) Quit program" + "\n");

            cashierChoice = userInterface.readInt();
            if (cashierChoice == 1) {
                viewPaymentStatusAllMembers();
            } else if (cashierChoice == 2) {
                viewPaymentStatusByMembership();

            } else if (cashierChoice == 3) {
                //TODO view only past-due members

            } else if (cashierChoice == 4) {
                editPaymentStatus();

            } else if (cashierChoice == 5) {
                // TODO: Flyt til payments
//                System.out.println("Payments in total " + "\n" + getPaymentsInTotal() + "\n");
//                System.out.println(expectedPaymentTotal());

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

    private void editPaymentStatus() {
        System.out.println("Type name of member to edit payment status");
        String fullName = userInterface.scanner.nextLine();
        Member editPayment = controller.memberSearch(fullName);
        if (editPayment != null){
            boolean writingError = false;
            do {
                try {
                    System.out.println("Type in new subscription status");
                    String hasPaid = userInterface.scanner.nextLine();
                    if (!hasPaid.isEmpty()) {
                        editPayment.setHasPaid(Boolean.parseBoolean(hasPaid));
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error occurred - try again.");
                    writingError = true;
                }
            } while (writingError == true);
        }else {
            System.out.println("Member not found");
        }
        }


    private  void viewPaymentStatusAllMembers() {
        for (Member member : controller.getMembers()) {
            System.out.println("Name: " + member.getFirstname() + "\n" + "Lastname: " + member.getLastname() + "\n" + "has paid the subscription: " + member.isHasPaid() + "\n");
        }
    }


    private void viewPaymentStatusByMembership() {
        userInterface.sortMemberPastDue();
    }

}
