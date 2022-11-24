package org.example;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class UserInterface {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        Controller controller = new Controller();

        public void menu() throws FileNotFoundException {

            int userChoice;
            do {
                boolean isRunning;
                System.out.println("Delfinen Swimming Club\n");
                System.out.println("Menu");
                System.out.println("1) Registration of new member\n" + "2) Save data\n" + "9) Exit system");

                userChoice = scanner.nextInt();
                scanner.nextLine();

                try {

                    if (userChoice == 1) {
                        System.out.println("Register new member here:\n");

                        System.out.println("Type in full name:");
                        String name = scanner.nextLine();

                        System.out.println("Type in birth year:");
                        int birthYear = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Type in address:");
                        String address = scanner.nextLine();

                        System.out.println("Type in zipcode:");
                        int zipCode = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Type in city:");
                        String city = scanner.nextLine();

                        System.out.println("Type in phonenumber:");
                        int number = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Type in Mail-adress:");
                        String email = scanner.nextLine();

                        System.out.println("Type in active or passive member status:");
                        boolean passiveOrActiveMember = scanner.nextLine().substring(0, 1).equalsIgnoreCase("Y");

                        System.out.println("Type in junior (under 18) or senior (above 18) member status:");
                        boolean juniorOrSeniorMember = scanner.nextLine().substring(0, 1).equalsIgnoreCase("Y");

                        System.out.println("Type in competition swimmer or exerciser member status:");
                        boolean competitionSwimmerOrExerciser = scanner.nextLine().substring(0, 1).equalsIgnoreCase("Y");

                        System.out.println("In order to save, load and see your members, follow the main menu");

                    } else if (userChoice == 6) {
                        controller.saveData();
                        System.out.println("Data saved");

                    }

                isRunning = false;
                }catch (InputMismatchException e){
                    System.out.println("Unkown input, try again");
                    isRunning = true;
                    scanner.nextInt();
                    scanner.nextLine();
                }


            }  while (userChoice == 9);
        }
    }



