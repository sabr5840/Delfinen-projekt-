package fff.delfinen.ui;

import fff.delfinen.Controller;
import fff.delfinen.Payments;

public class CashierMenu {

    public Controller controller;
    public UserInterface userInterface;
    private Payments payments = new Payments();

    public CashierMenu(Controller controller, UserInterface userInterface) {
        this.controller = controller;
        this.userInterface = userInterface;
    }


    void cashierMenu() {
        int cashierChoice;
        do {
            boolean isRunning;
            boolean writingError;
            System.out.println("\nCashier menu");
            System.out.println("1) View payment status for all members\n" +
                    "2) View payment status by membership-type\n" +
                    "3) View members who are past due" + "\n" +
                    "4) Edit payment status\n" +
                    "5) Payment overview\n" +
                    "6) Return to main men\n" +
                    "7) Quit program" + "\n");

            cashierChoice = userInterface.readInt();
            if (cashierChoice == 1) {
                payments.viewPaymentStatusAllMembers();
            } else if (cashierChoice == 2) {
                payments.viewPaymentStatusByMembership(this);

            } else if (cashierChoice == 3) {
                //TODO view only past-due members

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
