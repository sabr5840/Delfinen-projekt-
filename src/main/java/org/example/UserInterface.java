package org.example;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class UserInterface {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        Controller controller = new Controller();
        Member member = new Member();
        Database db = new Database();

        public void menu() throws FileNotFoundException {

            int userChoice;
            do {
                boolean isRunning;
                boolean writingError;
                System.out.println("Delfinen Swimming Club\n");
                System.out.println("Menu");
                System.out.println("1) Registration of new member\n" + "2) Save data\n" + "3) load data\n" +
                        "4) Edit member information\n" + "5) Search for member\n" +
                        "6) View members\n" + "9) Exit system");

                userChoice = scanner.nextInt();
                scanner.nextLine();

                try {

                    if (userChoice == 1) {
                        System.out.println("Register new member here:\n");

                        System.out.println("Type in full name:");
                        String name = scanner.nextLine();

                        int birthYear = 0;
                        do {
                            try {
                                System.out.println("Type birthyear for the new member:");
                                birthYear = scanner.nextInt();
                                if (birthYear > 0) {
                                    member.setBirthYear((birthYear));
                                }
                                writingError = false;

                            } catch (NumberFormatException e) {
                                System.out.println("Error occurred - try again.");
                                writingError = true;
                            }

                        } while (writingError == true);

                        System.out.println("Type in address:");
                        String address = scanner.nextLine();
                        scanner.nextLine();

                        System.out.println("Type in zipcode:");
                        int zipCode = Integer.parseInt(scanner.nextLine());


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
                        boolean competitionOrExercise = scanner.nextLine().substring(0, 1).equalsIgnoreCase("Y");

                        System.out.println("In order to save, load and see your members, follow the main menu");


                        db.Registration(name, birthYear, address, zipCode, city, number, email, passiveOrActiveMember, juniorOrSeniorMember, competitionOrExercise);


                    } else if (userChoice == 2) {
                        controller.saveData(db.getMembers());
                        System.out.println("Data saved");

                    }else if (userChoice == 3){
                        controller.loadData();
                        System.out.println("Data loaded");

                    }else if (userChoice == 4) {
                        controller.editData();

                    }else if (userChoice == 6) {
                        System.out.println("Search for specific member by name");
                        controller.viewMembers();
                        System.out.println("Members:");


                    }


                isRunning = false;
                }catch (InputMismatchException e){
                    System.out.println("Unkown input, try again");
                    isRunning= true;
                    scanner.nextInt();
                    scanner.nextLine();
                }


            }  while (userChoice != 9);
            System.exit(0);
        }
    }



