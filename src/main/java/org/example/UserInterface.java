package org.example;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    Controller controller = new Controller();
    Member member = new Member();
    Database db = new Database();
    ArrayList<Member> juniorList = new ArrayList<>();
    ArrayList<Member> seniorList = new ArrayList<>();
    ArrayList<Member> passiveList = new ArrayList<>();
    ArrayList<Member> paidJuniors = new ArrayList<>();
    ArrayList<Member> paidSeniors = new ArrayList<>();
    ArrayList<Member> paidPassives = new ArrayList<>();


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

    // Menu for chairman
    public void chairmanMenu() throws FileNotFoundException {
        int chairmanChoice;
        boolean isRunning = true;
        boolean writingError;
        do {

            System.out.println("Menu");
            System.out.println("1) Registration of new member\n" +
                    "2) Save data\n" +
                    "3) load data\n" +
                    "4) Edit member information\n" +
                    "5) Search for member\n" +
                    "6) View members\n" +
                    "7) Delete member\n" +
                    "9) Return to main menu\n" +
                    "10) Quit programme\n");

            chairmanChoice = scanner.nextInt();
            scanner.nextLine();
            if (chairmanChoice == 1) {
                registerMember();

            }else if (chairmanChoice == 2) {
                controller.saveData();
                System.out.println("Data saved");

            } else if (chairmanChoice == 3) {
                controller.loadData();
                System.out.println("Data loaded");

            } else if (chairmanChoice == 4) {
                controller.editData();
                System.out.println("Name of member to edit ");
                String searchTerm = scanner.next();
                ArrayList<Member> searchResult = controller.searchFor(searchTerm);

                if (searchResult.isEmpty()) {
                    System.out.println("No member found");
                } else {
                    //TODO hør om en ligende get metode - bare til string
                    System.out.println("Member found; ");
                    int i;
                    for (i = 0; i < searchResult.size(); i++) ;
                    //System.out.println(((i) + 1) + ") " + searchResult.get(i));

                    System.out.println("\n Type name of member to edit");
                    String fullname = scanner.nextLine();
                    //Member member = searchResult.get();

                    System.out.println("Type new first name or press `enter`to keep present name");
                    String firstName = scanner.nextLine();
                    if (!firstName.isEmpty()) {
                        member.setFirstname(firstName);
                    }
                    System.out.println("Type new last name or press `enter`to keep present last name");
                    String lastName = scanner.nextLine();
                    if (!lastName.isEmpty()) {
                        member.setLastname(lastName);
                    }

                    System.out.println("Type new adress or press `enter`to keep present adress");
                    String address = scanner.nextLine();
                    if (!address.isEmpty()) {
                        member.setAddress(address);
                    }

                    boolean wiritingError = false;
                    do {
                        try {
                            System.out.println("Type new postal code or press `enter`to keep present postal code");
                            String postalCode = scanner.nextLine();
                            if (!postalCode.isEmpty()) {
                                member.setPostalCode(Integer.parseInt(postalCode));
                            }
                            wiritingError = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Error occurred - try again");
                            wiritingError = true;
                        }
                    } while (wiritingError == true);


                    System.out.println("Type new city or press `enter`to keep present city");
                    String city = scanner.nextLine();
                    if (!city.isEmpty()) {
                        member.setCity(city);
                    }

                    boolean wiritingError1 = false;
                    boolean writingError1 = false;
                    do {
                        try {
                            System.out.println("Type new phone number or press `enter`to keep present phone number");
                            String phoneNo = scanner.nextLine();
                            if (!phoneNo.isEmpty()) {
                                member.setPhoneNo(Integer.parseInt(phoneNo));
                            }
                            wiritingError1 = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Error occurred - try again.");
                            writingError1 = true;
                        }
                    } while (writingError1 == true);


                    System.out.println("Type new email or press `enter`to keep present email");
                    String eMail = scanner.nextLine();
                    if (!eMail.isEmpty()) {
                        member.setAddress(eMail);
                    }

                    do {
                        try {
                            System.out.println("Type new Membership status (Passive or active) or `enter`to keep present status");
                            String passive = scanner.nextLine();
                            if (!passive.isEmpty()) {
                                member.setPassive(Boolean.parseBoolean(passive));
                            }
                            wiritingError = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Error occurred - try again.");
                            writingError1 = true;
                        }
                    } while (writingError1 == true);

                    do {
                        try {
                            System.out.println("Type new Membership status (competition swimmer or exerciser) or `enter`to keep present status");
                            String exercise = scanner.nextLine();
                            if (!exercise.isEmpty()) {
                                member.setExercise(Boolean.parseBoolean(exercise));
                            }
                            wiritingError = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Error occurred - try again.");
                            writingError1 = true;
                        }
                    } while (writingError1 == true);

                    System.out.println("Member changed to: \n" + member + "\n");
                    System.out.println("Remember to save your changes by typing `2`");
                }

            } else if (chairmanChoice == 7) {
                System.out.println("Search for the member you want to remove from the system:");
                String searchTerm = scanner.next();
                ArrayList<Member> searchResult = controller.searchFor(searchTerm);

                if (searchResult.isEmpty()){
                    System.out.println("No member found \n");
                }else {
                    System.out.println("Member found: ");
                    for (int i = 0; i<searchResult.size(); i++){

                    }
                    System.out.println("Type in name for desired member ");
                    String fullname = scanner.nextLine();
                    //Member member = searchResult.get(number - 1);

                    System.out.println("Are you sure, you want to delete the member? (true/false)");
                    boolean delete = scanner.nextBoolean();
                    if (delete ==  true){
                        controller.deleteMember(member);

                        System.out.println("Member deleted from system");
                    }else if (delete == false){
                        System.out.println("Member not deleted");
                    }
                }


            } else if (chairmanChoice == 8) {
                System.out.println("List of members:" + "\n");
                for (Member member : controller.getMembers()) {
                    System.out.println("First name: " + member.getFirstname() + "\n" + "Last name: " + member.getLastname() + "\n" + "Date, mouth and year of birth: "
                            + member.getBirthDate() + "\n" + "Address: " + member.getAddress() + " " + member.getPostalCode() + " " + member.getCity() + "\n"
                            + "Phone number: " + member.getPhoneNo() + "\n" + "Email address: " + member.geteMail() +
                            "\n" + "Membership typer: " + member.isPassive() + ", " + member.isJunior() + ", " + member.isExercise() + "\n" + "Has paid the subscription: " + member.isHasPaid() + "\n");
                }

            } else if (chairmanChoice == 9) {
                startMenu();
            }else if (chairmanChoice == 10) {
                System.exit(0);
            }
            isRunning = false;
        } while (isRunning = true);
    }

    // Menu for cashier
    private void cashierMenu() throws FileNotFoundException {
        int cashierChoice;
        do {
            boolean isRunning;
            boolean writingError;
            System.out.println("Menu");
            System.out.println("1) View payment status for all members\n" +
                    //TODO  skal man kunne registre has paid - skal måske slette hos chairman
                    "2) View payment status by membership-type\n" + //TODO membership type = passive or active members - hør po ad
                    "3) View members who are past due" + "\n" +
                    "4) Edit payment status\n" +
                    "5) Return to main men\n" +
                    "6) Quit program" + "\n");

            cashierChoice = scanner.nextInt();
            if (cashierChoice == 1) {
                for (Member member : controller.getMembers()) {
                    System.out.println("Name: " + member.getFirstname() + "\n" + "Lastname: " + member.getLastname() + "\n" + "has paid the subscription: " + member.isHasPaid() + "\n");

                    System.out.println("Paid Payments in total: ");
                    //For at finde det totale for alle medlemmer som har betalt
                    System.out.println((juniorList.size() * 1000) + (seniorList.size() * 1600) + (passiveList.size() * 500));

                }
            } else if (cashierChoice == 2) {
                //TODO paymentstatus by membership-type

                System.out.println("Junoir members: ");
                System.out.println("Senior members: ");
                System.out.println("Passive members:");


            } else if (cashierChoice == 3) {
                //TODO view past-due members

                System.out.println("Expected payments in total: " + "\n");
                System.out.println();

            } else if (cashierChoice == 4) {
                //TODO hør om en ligende get metode - bare til string
                System.out.println("Type name of member to edit payment");
                String searchTerm = scanner.next();
                ArrayList<Member> searchResult = controller.searchFor(searchTerm);

                if (searchResult.isEmpty()){
                    System.out.println("No member found");

                }else {
                    System.out.println("Member found: ");
                    for (int i = 0; i < searchResult.size(); i++);
                    //System.out.println(((i)+ 1 )+ ") " + searchResult.get(i));

                    System.out.println("Type name of member to edit");
                    String fullname = scanner.nextLine();
                   // Member member = searchResult.get(number -1)

                    boolean writingError2 = false;
                    do {
                        try {
                            System.out.println("Type in new subscription status");
                            String hasPaid = scanner.nextLine();
                            if (!hasPaid.isEmpty()){
                                member.setHasPaid(Boolean.parseBoolean(hasPaid));
                            }
                            writingError2 = false;
                        }catch (NumberFormatException e){
                            System.out.println("Error occurred - try again.");
                            writingError = true;
                        }
                    }while (writingError2 == true);

                }

            } else if (cashierChoice == 5) {
                startMenu();
            }
            isRunning = false;
        } while (cashierChoice != 6);
        System.out.println("exiting program");
        System.exit(0);
    }

    // Menu for coach
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

        controller.addMember(firstname, lastname, LocalDate.ofEpochDay(birthYear), address, postalCode, city, phoneNo, eMail, passive, true, exercise, hasPaid);
    }

    public void expectedPaymentTotal() {
        for (int i = 0; i < db.members.size(); i++){
            if (db.members.get(i).isJunior() == true){
                juniorList.add(db.members.get(i));
            } else if (db.members.get(i).isPassive() == true){
                passiveList.add(db.members.get(i));
            } else if (db.members.get(i).isJunior() == false){
                seniorList.add(db.members.get(i));
            }
        }

        for (int i = 0; i > juniorList.size(); i++) {
            if (juniorList.get(i).isHasPaid() == true) {
                paidJuniors.add(juniorList.get(i));
            }
        }
        for (int i = 0; i < seniorList.size(); i++) {
            if (seniorList.get(i).isHasPaid() == true) {
                paidSeniors.add(seniorList.get(i));
            }
        }
        for (int i = 0; i < passiveList.size(); i++) {
            if (passiveList.get(i).isHasPaid() == true) {
                paidPassives.add(passiveList.get(i));
            }
        }

        int totalJunior = juniorList.size() * 1000;
        int totalSenior = seniorList.size() * 1600;
        int totalePassive = passiveList.size() * 500;;
        int total = totalJunior + totalSenior + totalePassive;
        System.out.println("Expected payment in total: " + total);
    }
    public boolean findJuniors() {
        for (int i = 0; i < db.members.size(); i++) {
            if (db.members.get(i).isJunior()) {
                juniorList.add(db.members.get(i));
            }
            System.out.println(juniorList);
        }
        return false;
    }

}
