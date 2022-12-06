package fff.delfinen.ui;

import fff.delfinen.Controller;
import fff.delfinen.Member;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;


public class ChairmanMenu {
    private Controller controller;
    private UserInterface userInterface;

    public ChairmanMenu(Controller controller, UserInterface userInterface) {
        this.controller = controller;
        this.userInterface = userInterface;
    }

    // Menu for chairman
    public void chMenu() {
        int chairmanChoice;
        boolean isRunning = true;
        boolean writingError;
        do {
            System.out.println("Chairman menu");
            System.out.println("1) Registration of new member\n" +
                    "2) Edit member information\n" +
                    "3) Delete member\n" +
                    "4) Search for member\n" +
                    "5) View all members\n" +
                    "6) Return to main menu\n" +
                    "7) Quit program\n");

            chairmanChoice = userInterface.scanner.nextInt();
            userInterface.scanner.nextLine();
            if (chairmanChoice == 1) {
                registerMember(userInterface);
            } else if (chairmanChoice == 2) {
                editMember(userInterface);
            } else if (chairmanChoice == 3) {
                delteMemberCM();
                //db.deleteMember(Member member);
            } else if (chairmanChoice == 4) {
                // TODO find ud af hvordan man søger efter medlem udfra både efternan + fornavn
            } else if (chairmanChoice == 5) {
                viewMembers(userInterface);
            } else if (chairmanChoice == 6) {
                userInterface.startMenu();
            }
            isRunning = false;
        } while (chairmanChoice != 7);
        System.out.println("Exiting programme");
        System.exit(0);
    }


    private void viewMembers(UserInterface userInterface) {
        System.out.println("List of members:" + "\n");
        for (Member member : userInterface.controller.getMembers()) {
            System.out.println("Full name: " + member.getFirstname() + " " + member.getLastname() + "\n" + "Date, month and year of birth: "
                    + member.getBirthDate() + "\n" + "Address: " + member.getAddress() + " " + member.getPostalCode() + " " + member.getCity() + "\n"
                    + "Phone number: " + member.getPhoneNo() + "\n" + "Email address: " + member.geteMail() +
                    "\n" + "Membership typer: " + member.isPassive() + ", " + member.isJunior() + ", " + member.isExercise() + "\n" + "Has paid the subscription: " + member.isHasPaid() + "\n");
        }
    }

    private void delteMemberCM() {
        System.out.println("Search for the member you want to remove from the system:");

        System.out.println("Type in name for desired member ");
        String fullName = userInterface.scanner.nextLine();

        System.out.println("Are you sure, you want to delete the member? (true/false)");
        boolean delete = userInterface.scanner.nextBoolean();
        if (delete) {

            boolean isMemberDeleted = controller.deleteMember(fullName);
            if (isMemberDeleted) {
                System.out.println("Member deleted from system");
            } else {
                System.out.println("Error, member not deleted");
            }

        } else {
            System.out.println("Delete member cancelled");
        }
    }


    //opdatere liste i databasen - når vi sletter skal vi gemme listen i databasen

    private void editMember(UserInterface userInterface) {
        userInterface.controller.editData();
        System.out.println("Name of member to edit ");
        String searchTerm = userInterface.scanner.nextLine();

        Member searchResult = controller.memberSearch(searchTerm);

        if (searchResult == null) {
            System.out.println("No member found");
        } else {
            //TODO hør om en ligende get metode - bare til string - virker ikke skal laves om...
            System.out.println("Member found; ");
            int index = 1;

            System.out.println("\n Type name of member to edit");

            System.out.println("Type new first name or press `enter`to keep present name");
            String firstName = userInterface.scanner.nextLine();
            if (!firstName.isEmpty()) {
                userInterface.member.setFirstname(firstName);
            }
            System.out.println("Type new last name or press `enter`to keep present last name");
            String lastName = userInterface.scanner.nextLine();
            if (!lastName.isEmpty()) {
                userInterface.member.setLastname(lastName);
            }

            System.out.println("Type new address or press `enter`to keep present address");
            String address = userInterface.scanner.nextLine();
            if (!address.isEmpty()) {
                userInterface.member.setAddress(address);
            }

            boolean wiritingError = false;
            do {
                try {
                    System.out.println("Type new postal code or press `enter`to keep present postal code");
                    String postalCode = userInterface.scanner.nextLine();
                    if (!postalCode.isEmpty()) {
                        userInterface.member.setPostalCode(Integer.parseInt(postalCode));
                    }
                    wiritingError = false;
                } catch (NumberFormatException e) {
                    System.out.println("Error occurred - try again");
                    wiritingError = true;
                }
            } while (wiritingError == true);


            System.out.println("Type new city or press `enter`to keep present city");
            String city = userInterface.scanner.nextLine();
            if (!city.isEmpty()) {
                userInterface.member.setCity(city);
            }

            boolean wiritingError1 = false;
            boolean writingError1 = false;
            do {
                try {
                    System.out.println("Type new phone number or press `enter`to keep present phone number");
                    String phoneNo = userInterface.scanner.nextLine();
                    if (!phoneNo.isEmpty()) {
                        userInterface.member.setPhoneNo(Integer.parseInt(phoneNo));
                    }
                    wiritingError1 = false;
                } catch (NumberFormatException e) {
                    System.out.println("Error occurred - try again.");
                    writingError1 = true;
                }
            } while (writingError1 == true);


            System.out.println("Type new email or press `enter`to keep present email");
            String eMail = userInterface.scanner.nextLine();
            if (!eMail.isEmpty()) {
                userInterface.member.setAddress(eMail);
            }

            do {
                try {
                    System.out.println("Type new Membership status (Passive or active) or `enter`to keep present status");
                    String passive = userInterface.scanner.nextLine();
                    if (!passive.isEmpty()) {
                        userInterface.member.setPassive(Boolean.parseBoolean(passive));
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
                    String exercise = userInterface.scanner.nextLine();
                    if (!exercise.isEmpty()) {
                        userInterface.member.setExercise(Boolean.parseBoolean(exercise));
                    }
                    wiritingError = false;
                } catch (NumberFormatException e) {
                    System.out.println("Error occurred - try again.");
                    writingError1 = true;
                }
            } while (writingError1 == true);

            System.out.println("Member changed to: \n" + userInterface.member + "\n");
            System.out.println("Remember to save your changes by typing `2`");
        }
    }

    public void registerMember(UserInterface userInterface) {
        boolean writingError = false;
        System.out.println("Register new member here");

        System.out.println("First name:");
        String firstname = userInterface.scanner.nextLine();

        System.out.println("Last name:");
        String lastname = userInterface.scanner.nextLine();

        LocalDate birthDate = null;
        boolean dateInputError;
        boolean junior = true;
        String input;
        do {
            try {
                System.out.println("Date of birth ('ddMMyyyy'):");
                birthDate = LocalDate.parse(userInterface.scanner.nextLine(), DateTimeFormatter.ofPattern("ddMMyyyy"));
                LocalDate todaysDate = LocalDate.now();
                dateInputError = false;
                if (ChronoUnit.YEARS.between(birthDate, todaysDate) < 18) {
                    junior = true;
                    userInterface.member.setJunior(true);
                    System.out.println("Member registered as junior");
                } else if (ChronoUnit.YEARS.between(birthDate, todaysDate) > 18) {
                    junior = false;
                    userInterface.member.setJunior(false);
                    System.out.println("Member registered as senior");
                }
            } catch (DateTimeParseException | NumberFormatException e) {
                System.out.println("Date of birth must be in correct format 'ddMMyyyy'");
                dateInputError = true;
            }
        } while (dateInputError);

        System.out.println("Type in address:");
        String address = userInterface.scanner.nextLine();

        int postalCode = 0;
        do {
            try {
                System.out.println("Type in postal code:");
                postalCode = Integer.parseInt(userInterface.scanner.nextLine());
                if (postalCode > 0) {
                    userInterface.member.setPostalCode((postalCode));
                    writingError = false;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error ocurred - try again");
                writingError = true;
            }
        } while (writingError);

        System.out.println("Type in city:");
        String city = userInterface.scanner.nextLine();


        int phoneNo = 0;
        do {
            try {
                System.out.println("Type in phonenumber:");
                phoneNo = Integer.parseInt(userInterface.scanner.nextLine());
                writingError = false;
            } catch (NumberFormatException e) {
                System.out.println("Fail");
                writingError = true;
            }
        } while (writingError);

        System.out.println("Type in Mail-adress:");
        String eMail = userInterface.scanner.nextLine();

        System.out.println("Type in active 'a' or passive 'p' member status:");
        boolean passive = true;
        char passiveOrActive;
        do {
            passiveOrActive = userInterface.scanner.nextLine().charAt(0);
            if (passiveOrActive == 'p') {
                passive = false;
                break;
            } else if (passiveOrActive == 'a') {
                passive = true;
                break;
            } else
                System.out.println("Input error - try again");
        } while (passiveOrActive != 'p' || passiveOrActive != 'a');

        System.out.println("Type in competition swimmer 'c' or exerciser 'e' member status:");
        boolean exercise = true;
        char memberType;

        do {
            try {
                memberType = userInterface.scanner.nextLine().charAt(0);

                if (memberType == 'c') {
                    exercise = false;
                    break;
                } else if (memberType == 'e') {
                    exercise = true;
                    break;
                } else
                    System.out.println("Typing error - try again");
            } catch (NumberFormatException e) {
                System.out.println("Error occurred - try again");
                writingError = true;
            }
        }
        while (writingError);

        System.out.println("Has paid the subscription (y/n):");
        boolean hasPaid = true;
        char paidStatus;
        do {
            paidStatus = userInterface.scanner.nextLine().charAt(0);
            if (paidStatus == 'n') {
                hasPaid = false;
                break;
            } else if (paidStatus == 'y') {
                hasPaid = true;
                break;
            } else
                System.out.println("Typing error - try again");
            writingError = true;
        } while (writingError);

        System.out.println(" ");
        System.out.println("We have registered this information about the new member:\n" +
                "Full name: " + firstname + " " + lastname + "\n" +
                "Birth date: " + birthDate + "\n" +
                "Address: \n" + address + "\n" +
                postalCode + " " + city + "\n" +
                "Phone number: " + phoneNo + "\n" +
                "E-mail: " + eMail + "\n" +
                "Passive or active membership; " + passive + "\n" +
                //TODO junior or senior
                "Exercise or competetion-swimmer: " + exercise + "\n" +
                "Subscription status: " + hasPaid);
        System.out.println("Do you wish to save the new member? 'yes'/'no' ");
        String yesNo = userInterface.scanner.nextLine().toLowerCase();
        if (yesNo.equals("yes")) {
            System.out.println("New member saved in database");
            try {
                userInterface.controller.addMember(firstname, lastname, birthDate, address, postalCode, city, phoneNo, eMail, passive, junior, exercise, hasPaid);
            } catch (FileNotFoundException e) {
                System.out.println("ERROR: Could not save to file");
            }
        } else if (yesNo.equals("no")) {
            System.out.println("Member not saved, returning to previous menu");
            chMenu();
        }
    }
}
