package fff.delfinen.ui;
import fff.delfinen.Controller;
import fff.delfinen.Member;
import fff.delfinen.Payments;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CashierMenu {

    public Controller controller;
    public UserInterface userInterface;
    private final Payments payments = new Payments();

    public CashierMenu(Controller controller, UserInterface userInterface) {
        this.controller = controller;
        this.userInterface = userInterface;
    }

    void cashierMenu() {
        int cashierChoice = 0;
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
    public void sortMemberPastDue(UserInterface userInterface) {
        Scanner scanner = new Scanner(System.in);

        int input = 0;
        boolean inputError;
        String sortInput = "";

        while (input != 9) {
            System.out.println("2. sort member list by active/passive membership");
            System.out.println("3. sort member list by junior/senior member");
            System.out.println("4. sort member list by exerciser or competitive swimmer");
            do {
                try {
                    input = scanner.nextInt();
                    scanner.nextLine();
                    switch (input) {
                        case 1 -> sortInput = "passive";
                        case 2 -> sortInput = "junior";
                        case 3 -> sortInput = "exercise";
                    }
                    ArrayList<Member> sortedList = userInterface.controller.sort(sortInput);
                    printSorted(sortedList);
                    inputError = false;
                } catch (InputMismatchException e) {
                    System.out.println("Something went wrong - try again");
                    inputError = true;
                    scanner.nextLine();
                }
            } while (inputError);
        }
    }
    private void printSorted(ArrayList<Member> sortedMembers) {
        // TODO skal have kigget på, hvordan den printer det rigtige ud
        for (Member member : sortedMembers) {
            System.out.println("Active/passive membership status" + member.isPassive() + "\n" + "Full name\n" + member.getFirstname() + " " + member.getLastname() + "\n" + "Subscription status\n" + member.isPaid());
            System.out.println("junior/senior member status" + member.isPassive() + "\n" + "Full name\n" + member.getFirstname() + " " + member.getLastname() + "\n" + "Subscription status\n" + member.isPaid());
            System.out.println("exerciser or competitive swimmer" + member.isPassive() + "\n" + "Full name\n" + member.getFirstname() + " " + member.getLastname() + "\n" + "Subscription status\n" + member.isPaid());
        }
    }

}
