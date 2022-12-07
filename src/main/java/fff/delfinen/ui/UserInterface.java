package fff.delfinen.ui;

import fff.delfinen.Controller;
import fff.delfinen.Member;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {

    public Member member = new Member();
    private ChairmanMenu chairmanMenu;
    private CoachMenu coachMenu;
    private CashierMenu cashierMenu;

    //TODO: Kun static virker - ellers fejl i coachMenu
    public static Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    public Controller controller = new Controller();



    public void start() throws FileNotFoundException {
        coachMenu = new CoachMenu();
        chairmanMenu = new ChairmanMenu(controller, this);
        cashierMenu = new CashierMenu(controller,this);
        controller.loadData();
        startMenu();
    }

    public void startMenu() {
        boolean success = false;
        Scanner employeeInput = new Scanner(System.in);
        System.out.println("Welcome to The Dolphins administrative system");

        while (!success) {
            try {
                System.out.println("Please input your employee number");
                int employeeNumber = employeeInput.nextInt();

                if ((employeeNumber >= 1) && (employeeNumber <= 10)) {
                    chairmanMenu.viewChairmanMenu();
                } else if ((employeeNumber >= 11) && (employeeNumber <= 20)) {
                    cashierMenu.cashierMenu();
                } else if ((employeeNumber >= 21) && (employeeNumber <= 30)) {
                    coachMenu.coachMenu();
                } else if ((employeeNumber <= 0) || (employeeNumber > 30)) {
                    System.out.println("invalid employee number - please enter a valid number");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input - your employee number only consists of numbers");
                employeeInput.next();
            }
        }

    }

    // TODO: Flyt til controller+payments
    public void sortMemberPastDue() {
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
                    ArrayList<Member> sortedList = controller.sort(sortInput);
                    printSorted(sortedList);
                    inputError = false;
                } catch (InputMismatchException e) {
                    System.out.println("Error, try again");
                    inputError = true;
                    scanner.nextLine();
                }
            } while (inputError);
        }
    }

    private void printSorted(ArrayList<Member> sortedMembers) {
        // TODO skal have kigget på, hvordan den printer det rigtige ud
        for (Member member : sortedMembers) {
            System.out.println("Active/passive membership status" + member.isPassive() + "\n" + "Full name\n" + member.getFirstname() + " " + member.getLastname() + "\n" + "Subscription status\n" + member.isHasPaid());
            System.out.println("junior/senior member status" + member.isPassive() + "\n" + "Full name\n" + member.getFirstname() + " " + member.getLastname() + "\n" + "Subscription status\n" + member.isHasPaid());
            System.out.println("exerciser or competitive swimmer" + member.isPassive() + "\n" + "Full name\n" + member.getFirstname() + " " + member.getLastname() + "\n" + "Subscription status\n" + member.isHasPaid());
        }
    }
    public int readInt() {
        int input = scanner.nextInt();
        return input;
    }
}








