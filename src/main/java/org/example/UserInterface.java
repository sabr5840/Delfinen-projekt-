package org.example;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    Controller controller = new Controller();
    Member member = new Member();


    public void startMenu() throws FileNotFoundException {
        System.out.println("Welcome to The Dolphins administrative system");
        System.out.println("Please input your employee number");
        int employeeNumber = scanner.nextInt();

        if (employeeNumber < 10) {
            ChairmanMenu();
        } else if ((employeeNumber > 11) && (employeeNumber < 20)) {
            cashierMenu();
        } else if ((employeeNumber > 20) && (employeeNumber < 30)) {
            trainerMenu();
        }
    }

    private void trainerMenu() throws FileNotFoundException {
        int trainerChoice;
        do {
            boolean isRunning;
            boolean writingError;
            System.out.println("Menu");
            System.out.println("1) view excercise teams\n" +
                    "2) view competition teams\n" +
                    "3) View statistics\n" +
                    "4) back to main menu\n" +
                    "5) quit program");
            trainerChoice = scanner.nextInt();

            if (trainerChoice == 1) {
                System.out.println("choose between junior or senior swimmers");
                System.out.println("type 'return' if you wish to return to last menu" +
                        "type Q if you wish to quit the program");
                Scanner input = new Scanner(System.in);
                String trainerInput = input.nextLine().toLowerCase();
                switch (trainerInput) {
                    case "Jr", "junior", "Junior", "jr":
                        System.out.println("TEST");
                        //TODO members list of junior swimmers sorted by last name
                        break;
                    case "Sr", "senior", "Senior", "sr":
                        System.out.println("TEST");
                        //TODO members list of senior swimmers by last name
                        break;
                    case "back", "Back", "return", "Return":
                        trainerMenu();
                        break;
                    case "Q", "quit", "q":
                        System.out.println("exiting program");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("try again");
                }

            } else if (trainerChoice == 2) {
                System.out.println("Choose which team you would like to see" +
                        "Crawl, butterfly, backcrawl or breaststroke");
                System.out.println("type return if you wish to go back to last menu" +
                        "type Q if you wish to quit the program");
                Scanner input = new Scanner(System.in);
                String teamInput = input.nextLine().toLowerCase();
                switch (teamInput) {
                    case "crawl", "Crawl":
                        System.out.println("TEST");
                        //TODO teamlist
                        break;
                    case "butterfly", "Butterfly":
                        System.out.println("TEST");
                        //TODO teamlist
                        break;
                    case "backcrawl", "Backcrawl":
                        System.out.println("TEST");
                        //TODO teamlist
                        break;
                    case "breaststroke", "Breaststroke":
                        System.out.println("TEST");
                        //TODO teamlist
                        break;
                    case "back", "Back", "return", "Return":
                        trainerMenu();
                        break;
                    case "Q", "quit", "q":
                        System.out.println("exiting program");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong input - please try again");
                }
            } else if (trainerChoice == 3) {
                System.out.println("Choose how you would like to see the statistics" +
                        "1) by team member\n" +
                        "2) by dicipline\n" +
                        "3) by best times\n" +
                        "4) Return to previous menu\n" +
                        "5) Quit programme");
                Scanner input = new Scanner(System.in);
                int statsInput = input.nextInt();
                switch (statsInput) {
                    case 1:
                        System.out.println("TEST");
                        //TODO teamlist
                        break;
                    case 2:
                        System.out.println("TEST");
                        //TODO teamlist
                        break;
                    case 3:
                        System.out.println("TEST");
                        //TODO teamlist
                        break;
                    case 4:
                        trainerMenu();
                        break;
                    case 5:
                        System.out.println("exiting program");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong input - please try again");
                }
            } else if (trainerChoice == 4) {
                startMenu();
            }
        } while (trainerChoice == 5);
        System.exit(0);
    }

    private void cashierMenu() throws FileNotFoundException {
        int cashierChoice;
        do {
            boolean isRunning;
            boolean writingError;
            System.out.println("Menu");
            System.out.println("1) View payment status for all members\n" +
                    "2) View payment status by membership-type\n" + //TODO membership type = passive or active members
                    "3) View members who are past due" +
                    "4) Update payment status\n" +
                    "5) Return to main men\n" +
                    "6) Quit program");
            cashierChoice = scanner.nextInt();

            if (cashierChoice == 1) {
                //TODO paymentstatus for all members
                for (Member member : controller.viewMembers()){
                    System.out.println("Name: " + member.getFirstname() + "Lastname: " + member.getLastname() + "has paid the subscription" + member.isHasPaid());
                }

            } else if (cashierChoice == 2) {
                //TODO paymentstatus by membership-type
            } else if (cashierChoice == 3) {
                //TODO view past-due members
            } else if (cashierChoice == 4) {
                //TODO update payment status (edit)
            } else if (cashierChoice == 5) {
                startMenu();
            }
            isRunning = false;
        } while (cashierChoice != 6);
        System.out.println("exiting program");
        System.exit(0);
    }

    //ChairmanMenu
    public void ChairmanMenu() throws FileNotFoundException {
        int chairmanChoice;

        do {
            boolean isRunning;
            boolean writingError;
            System.out.println("Menu");
            System.out.println(
                    "1) Registration of new member\n" +
                            "2) Save data\n" +
                            "3) load data\n" +
                            "4) Edit member information\n" +
                            "5) Search for member\n" +
                            "6) View members\n" +
                            "7) Return to main menu\n" +
                            "9) Quit programme");

            chairmanChoice = scanner.nextInt();
            scanner.nextLine();
            if (chairmanChoice == 1) {
                registerMember();

             if (chairmanChoice == 2) {
                controller.saveData();
                System.out.println("Data saved");

            } else if (chairmanChoice == 3) {
                controller.loadData();
                System.out.println("Data loaded");

            } else if (chairmanChoice == 4) {
                controller.editData();

            } else if (chairmanChoice == 6) {
                System.out.println("Search for specific member by name");
                controller.viewMembers();
                System.out.println("Members:");

            } else if (chairmanChoice == 7) {
                startMenu();
            }
            isRunning = false;
        }
    }while (chairmanChoice != 9);
        System.out.println("exiting program");
        System.exit(0);
    }
    public void registerMember(){
        boolean isRunning;
        boolean writingError;
        System.out.println("Register new member here");

        System.out.println("First name:");
        String firstname = scanner.nextLine();

        System.out.println("Last name:");
        String lastname = scanner.nextLine();

        System.out.println("Date of birth ('dd/MM/yyyy')");
        String DOB = scanner.nextLine();

        int calculation = LocalDateTime.now().getYear();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int birthYear = LocalDate.parse(DOB, formatter).getYear();

        if (calculation - birthYear < 18)
            System.out.println("member is registered as junior \n");
        else if (calculation - birthYear > 18)
            System.out.println("member is registered as senior \n");

        System.out.println("Type in address:");
        String address = scanner.next();
        scanner.nextLine();

        int zipCode;
        do {
            zipCode = 0;
            try {
                System.out.println("Type in zipcode:");
                zipCode = Integer.parseInt(scanner.nextLine());
                if (zipCode > 0) {
                    member.setPostalCode((zipCode));
                }
                writingError = false;
            } catch (NumberFormatException e) {
                System.out.println("Error ocurred - try again");
                writingError = true;
            }
        } while (writingError == true);

        System.out.println("Type in city:");
        String city = scanner.nextLine();

        System.out.println("Type in phonenumber:");
        int number = scanner.nextInt();
        scanner.nextLine();
        //TODO skal laves ligesom ovenover i zipcode

        System.out.println("Type in Mail-adress:");
        String eMail = scanner.nextLine();

        System.out.println("Type in active or passive member status:");
        boolean passive = scanner.nextLine().substring(0, 1).equalsIgnoreCase("Y");

        System.out.println("Type in competition swimmer or exerciser member status:");
        boolean excercise = scanner.nextLine().substring(0, 1).equalsIgnoreCase("Y");

        System.out.println("Has paid the subscription:");
        boolean hasPaid = scanner.nextLine().substring(0, 1).equalsIgnoreCase("Y");

        System.out.println("In order to save, load and see your members, follow the main menu");

        controller.addMember(firstname, lastname, birthYear, address, zipCode, city, number, eMail, passive, true, excercise, hasPaid);

        System.out.println(toString());

    }
//WO
}
