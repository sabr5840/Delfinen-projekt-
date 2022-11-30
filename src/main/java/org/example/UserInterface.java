package org.example;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    Controller controller = new Controller();
    Member member = new Member();

    public void startMenu() throws FileNotFoundException {
        boolean success = false;
        Scanner employeeInput = new Scanner(System.in);
        System.out.println("Welcome to The Dolphins administrative system");

        while (!success) {
            try {
                System.out.println("Please input your employee number");
                int employeeNumber = employeeInput.nextInt();

                if ((employeeNumber >= 1) && (employeeNumber <= 10)) {
                    chairmanMenu();
                } else if ((employeeNumber >= 11) && (employeeNumber <= 20)) {
                    cashierMenu();
                } else if ((employeeNumber >= 21) && (employeeNumber <= 30)) {
                    coachMenu();
                } else if ((employeeNumber <= 0) || (employeeNumber > 30)) {
                    System.out.println("invalid employee number - please enter a valid number");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input - your employee number only consists of numbers");
                employeeInput.next();
            }
        }
    }

    //ChairmanMenu
    public void chairmanMenu() throws FileNotFoundException {
        int chairmanChoice;
        boolean isRunning = true;
        do {
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
                            "8) Quit programme");

            chairmanChoice = scanner.nextInt();
            scanner.nextLine();
            if (chairmanChoice == 1) {
                registerMember();
            } else if (chairmanChoice == 2) {
                controller.saveData();
                System.out.println("Data saved");
            } else if (chairmanChoice == 3) {
                controller.loadData();
                System.out.println("Data loaded");
            } else if (chairmanChoice == 4) {
                controller.editData();
            } else if (chairmanChoice == 5) {
                System.out.println("Search for specific member by name");
            } else if (chairmanChoice == 6) {
                System.out.println("Members:");
                controller.viewMembers();
            } else if (chairmanChoice == 7) {
                startMenu();
            } else if (chairmanChoice == 8) {
                System.out.println("exiting program");
                System.exit(0);
            }

        } while (isRunning = true);
    }

    //Cashier Menu
    private void cashierMenu() throws FileNotFoundException {
        int cashierChoice;
        boolean isRunning;
        do {

            boolean writingError;
            System.out.println("Menu");
            System.out.println("1) View payment status for all members\n" +
                    "2) View payment status by membership-type\n" + //TODO membership type = passive or active members
                    "3) View members who are past due\n" +
                    "4) Edit payment status\n" +
                    "5) Return to main men\n" +
                    "6) Quit program");
            cashierChoice = scanner.nextInt();

            if (cashierChoice == 1) {
                //TODO paymentstatus for all members
                for (Member member : controller.viewMembers()) {
                    System.out.println("Name: " + member.getFirstname() + "Lastname: " + member.getLastname() + "has paid the subscription" + member.isHasPaid());
                }

            } else if (cashierChoice == 2) {
                //TODO paymentstatus by membership-type
            } else if (cashierChoice == 3) {
                //TODO view past-due members
            } else if (cashierChoice == 4) {
                //TODO edit payment status (edit)
            } else if (cashierChoice == 5) {
                startMenu();
            } else if (cashierChoice == 6) {
                System.out.println("exiting program");
                System.exit(0);
            }
        } while (isRunning = true);

    }

    //CoachMenu
    private void coachMenu() throws FileNotFoundException {
        int coachChoice;
        do {
            boolean isRunning;
            boolean writingError;
            System.out.println("Menu");
            System.out.println("1) view exercise teams\n" +
                    "2) view competition teams\n" +
                    "3) View statistics\n" +
                    "4) back to main menu\n" +
                    "5) quit program");
            coachChoice = scanner.nextInt();

            if (coachChoice == 1) {
                System.out.println("choose between junior or senior swimmers");
                System.out.println("type 'return' if you wish to return to last menu" +
                        "type Q if you wish to quit the program");
                Scanner input = new Scanner(System.in);
                String coachInput = input.nextLine().toLowerCase();
                switch (coachInput) {
                    case "Jr", "junior", "Junior", "jr":
                        System.out.println("TEST");
                        //TODO members list of junior swimmers sorted by last name
                        break;
                    case "Sr", "senior", "Senior", "sr":
                        System.out.println("TEST");
                        //TODO members list of senior swimmers by last name
                        break;
                    case "back", "Back", "return", "Return":
                        coachMenu();
                        break;
                    case "Q", "quit", "q":
                        System.out.println("exiting program");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("try again");
                }

            } else if (coachChoice == 2) {
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
                        coachMenu();
                        break;
                    case "Q", "quit", "q":
                        System.out.println("exiting program");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong input - please try again");
                }
            } else if (coachChoice == 3) {
                System.out.println("Choose how you would like to see the statistics" +
                        "1) by team member\n" +
                        "2) by discipline\n" +
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
                        coachMenu();
                        break;
                    case 5:
                        System.out.println("exiting program");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong input - please try again");
                }
            } else if (coachChoice == 4) {
                startMenu();
            }
        } while (coachChoice == 5);
        System.exit(0);
    }


    public void registerMember() {
        boolean writingError = false;
        System.out.println("Register new member here");

        System.out.println("First name:");
        String firstname = scanner.nextLine();

        System.out.println("Last name:");
        String lastname = scanner.nextLine();


        int birthYear = 0;
        do {
            Scanner registerInput = new Scanner(System.in);
            try {
                System.out.println("Date of birth ('ddMMyyyy'):");
                String DOB = (scanner.nextLine());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

                birthYear = LocalDate.parse(DOB, formatter).getYear();
                int calculation = LocalDateTime.now().getYear();
                if (calculation - birthYear < 18)
                    System.out.println("member is registered as junior \n");
                else if (calculation - birthYear > 18)
                    System.out.println("member is registered as senior \n");

            } catch (DateTimeParseException e) {
                System.out.println("Date of birth must be in correct format 'ddMMyyyy'");
               registerInput.nextLine();

            }
        } while (writingError = false);

        System.out.println("Type in address:");
        String address = scanner.nextLine();

        int postalCode = 0;
        do {
            try {
                System.out.println("Type in postal code:");
                postalCode = Integer.parseInt(scanner.nextLine());
                if (postalCode > 0) {
                    member.setPostalCode((postalCode));
                }
                writingError = false;
            } catch (NumberFormatException e) {
                System.out.println("Error ocurred - try again");
                writingError = true;
            }
        } while (writingError == true);

        System.out.println("Type in city:");
        String city = scanner.nextLine();


        int phoneNo = 0;
        do {
            try {
                System.out.println("Type in phonenumber:");
                phoneNo = Integer.parseInt(scanner.nextLine());
                writingError = false;
            } catch (NumberFormatException e) {
                System.out.println("fail");
                writingError = true;
            }
        } while (writingError == true);


        System.out.println("Type in Mail-adress:");
        String eMail = scanner.nextLine();

        System.out.println("Type in active or passive member status:");
        boolean passive = scanner.nextLine().substring(0, 1).equalsIgnoreCase("Y");

        System.out.println("Type in competition swimmer or exerciser member status:");
        boolean exercise = scanner.nextLine().substring(0, 1).equalsIgnoreCase("Y");

        System.out.println("Has paid the subscription:");
        boolean hasPaid = scanner.nextLine().substring(0, 1).equalsIgnoreCase("Y");

        System.out.println("");
        System.out.println("We have registered this information about the new member:\n" +
                "Full name " + firstname + "" + "lastname \n" +
                "Birthyear " + birthYear + "\n" +
                "Address " + address + "\n" +
                "City " + postalCode + "" + city + "\n" +
                "Phone number " + phoneNo + "\n" +
                "E-mail " + eMail + "\n" +
                "Passive or active membership " + passive + "\n" +
                //TODO junior or senior
                "Exercise or competetion-swimmer? " + exercise + "\n" +
                "Is subscription paid? " + hasPaid);
        System.out.println("");
        controller.addMember(firstname, lastname, birthYear, address, postalCode, city, phoneNo, eMail, passive, true, exercise, hasPaid);
    }
}

