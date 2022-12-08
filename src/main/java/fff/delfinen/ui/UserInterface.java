package fff.delfinen.ui;
import fff.delfinen.Controller;
import fff.delfinen.Member;

import java.util.*;

public class UserInterface {

    public static Member member = new Member();
    public ChairmanMenu chairmanMenu;
    private CoachMenu coachMenu;
    public CashierMenu cashierMenu;

    //TODO: Kun static virker - ellers fejl i coachMenu hjælp someone
    static Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    public Controller controller = new Controller();

    public void start() {
        coachMenu = new CoachMenu(this, controller);
        chairmanMenu = new ChairmanMenu();
        cashierMenu = new CashierMenu(controller, this);
        controller.loadData();
        startMenu();
    }

    public void startMenu() {
        boolean success = false;
        Scanner employeeInput = new Scanner(System.in);
        System.out.println("Welcome to The Dolphins administrative system" +
                "\n----------------------------------------------");

        while (!success) {
            try {
                System.out.println("Please input your employee number:");
                int employeeNumber = employeeInput.nextInt();

                if ((employeeNumber >= 1) && (employeeNumber <= 10)) {
                    chairmanMenu.viewChairmanMenu();
                } else if ((employeeNumber >= 11) && (employeeNumber <= 20)) {
                    cashierMenu.cashierMenu();
                } else if ((employeeNumber >= 21) && (employeeNumber <= 30)) {
                    coachMenu.coachMenu();
                } else {
                    System.out.println("invalid employee number - please enter a valid number");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input - your employee number only consists of numbers");
                employeeInput.next();
            }
        }
    }

}










