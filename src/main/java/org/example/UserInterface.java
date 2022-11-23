package org.example;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class UserInterface {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);

        public void menu() {

            int userChoice;
            do {
                boolean isRunning;
                System.out.println("HÅLLLÅÅÅÅ");

                System.out.println("Delfinen Swimming Club\n");
                System.out.println("Menu");
                System.out.println("1) Register new member\n" + "9) Exit system");

                //
                userChoice = scanner.nextInt();
                scanner.nextLine();

                try {

                    if (userChoice == 1) {


                        System.out.println("Register new member here:\n");

                        System.out.println("Type full name:");
                        String name = scanner.nextLine();

                        System.out.println("Type birth year:");
                        int birthYear = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Type address:");
                        String address = scanner.nextLine();

                        System.out.println("Type zipcode:");
                        int zipCode = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Type city:");
                        String city = scanner.nextLine();

                        System.out.println("Type number:");
                        int number = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Type e-Mail:");
                        String email = scanner.nextLine();

                        System.out.println("Active or passive member:");
                        boolean passiveOrActiveMember = scanner.nextLine().substring(0, 1).equalsIgnoreCase("Y");

                        System.out.println("Junior(under 18) or senior(above 18) - member:");
                        boolean juniorOrSeniorMember = scanner.nextLine().substring(0, 1).equalsIgnoreCase("Y");

                        System.out.println("Competition swimmer or exerciser?");
                        boolean competitionSwimmerOrExerciser = scanner.nextLine().substring(0, 1).equalsIgnoreCase("Y");


                    } else {


                    }
                    isRunning = false;
                } catch (InputMismatchException e) {
                    System.out.println("Unknown input - try again");
                    isRunning = true;
                    scanner.nextInt();
                    scanner.nextLine();
                }
            }  while (userChoice == 9);
        }
    }



