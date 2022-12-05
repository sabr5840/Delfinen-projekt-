package fff.delfinen.ui;

import fff.delfinen.Member;

import java.util.ArrayList;

public class CashierMenu {

    // Menu for cashier
    void cashierMenu(UserInterface userInterface) {
        int cashierChoice;
        do {
            boolean isRunning;
            boolean writingError;
            System.out.println("Cashier menu");
            System.out.println("1) View payment status for all members\n" +
                    //TODO  skal man kunne registre has paid - skal måske slette hos chairman
                    "2) View payment status by membership-type\n" +
                    "3) View members who are past due" + "\n" +
                    "4) Edit payment status\n" +
                    "5) Payment overview\n" +
                    "6) Return to main men\n" +
                    "7) Quit program" + "\n");

            cashierChoice = userInterface.scanner.nextInt();
            if (cashierChoice == 1) {
                viewPaymentStatusAllMembers(userInterface);
            } else if (cashierChoice == 2) {
                viewPaymentStatusByMembership(userInterface);

            } else if (cashierChoice == 3) {
                //TODO view only past-due members

            } else if (cashierChoice == 4) {
                editPaymentStatus(userInterface);

            } else if (cashierChoice == 5) {
                System.out.println("Payment overview" + "\n");
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

    private static void quitProgramme() {
        System.out.println("Exiting programme");
        System.exit(0);
    }

    private static void editPaymentStatus(UserInterface userInterface) {
        boolean writingError;
        //TODO hør om en ligende get metode - bare til string
        System.out.println("Type name of member to edit payment");
        String searchTerm = userInterface.scanner.next();
        ArrayList<Member> searchResult = userInterface.controller.searchFor(searchTerm);

        if (searchResult.isEmpty()) {
            System.out.println("No member found");

        } else {
            System.out.println("Member found: ");
            for (int i = 0; i < searchResult.size(); i++) ;
            //System.out.println(((i)+ 1 )+ ") " + searchResult.get(i));

            System.out.println("Type name of member to edit");
            String fullname = userInterface.scanner.nextLine();
            // Member member = searchResult.get(number -1)

            boolean writingError2 = false;
            do {
                try {
                    System.out.println("Type in new subscription status");
                    String hasPaid = userInterface.scanner.nextLine();
                    if (!hasPaid.isEmpty()) {
                        userInterface.member.setHasPaid(Boolean.parseBoolean(hasPaid));
                    }
                    writingError2 = false;
                } catch (NumberFormatException e) {
                    System.out.println("Error occurred - try again.");
                    writingError = true;
                }
            } while (writingError2 == true);
        }
    }



    private static void viewPaymentStatusAllMembers(UserInterface userInterface) {
        for (Member member : userInterface.controller.getMembers()) {
            System.out.println("Name: " + member.getFirstname() + "\n" + "Lastname: " + member.getLastname() + "\n" + "has paid the subscription: " + member.isHasPaid() + "\n");
        }
    }

    private static void viewPaymentStatusByMembership(UserInterface userInterface) {
        userInterface.sortMemberPastDue();
    }

}