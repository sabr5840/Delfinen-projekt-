package fff.delfinen;
import fff.delfinen.ui.ChairmanMenu;
import fff.delfinen.ui.UserInterface;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class MemberEditing {



    public void viewMembers(ChairmanMenu chairmanMenu) {
        System.out.println("List of members:" + "\n");
        for (Member member : chairmanMenu.controller.getMembers()) {
            System.out.println("Full name: " + member.getFirstname() + " " + member.getLastname() + "\n" + "Date, month and year of birth: "
                    + member.getBirthDate() + "\n" + "Address: " + member.getAddress() + " " + member.getPostalCode() + " " + member.getCity() + "\n"
                    + "Phone number: " + member.getPhoneNo() + "\n" + "Email address: " + member.geteMail() +
                    "\n" + "Membership typer: " + member.isPassive() + ", " + member.isJunior() + ", " + member.isExercise() + "\n" + "Has paid the subscription: " + member.isPaid() + "\n");
        }
    }


    private void searchMember(ChairmanMenu chairmanMenu){
        System.out.println("Search for a specific member by their full name: \n ");

        String fullName = UserInterface.scanner.nextLine();
        Member editMember = chairmanMenu.controller.memberSearch(fullName);

        System.out.println();
    }

    public void deleteMember(ChairmanMenu chairmanMenu) {
        System.out.println("Search for the member you want to remove from the system:");

       System.out.println("Type in name for desired member");
        String fullName = UserInterface.scanner.nextLine();

        System.out.println("Are you sure, you want to delete the member? (true/false)");
        boolean delete = UserInterface.scanner.nextBoolean();
        if (delete) {
            boolean isMemberDeleted = chairmanMenu.controller.deleteMember(fullName);
            if (isMemberDeleted) {
                System.out.println("Member deleted from system");
            } else {
                System.out.println("Error, member not deleted");
            }
        } else {
            System.out.println("Delete member cancelled");
        }
    }

    public void editMember(ChairmanMenu chairmanMenu) {
        System.out.println("Member to edit");

        System.out.println("Type in full name for desired member to edit ");
        String fullName = UserInterface.scanner.nextLine();
        Member editMember = chairmanMenu.controller.memberSearch(fullName);

        System.out.println("Type new first name or press 'enter' to keep present name");
        String firstName = UserInterface.scanner.nextLine();
        if (!firstName.isEmpty()) {
            editMember.setFirstname(firstName);
        }
        System.out.println("Type new lastname or press 'enter' to keep present lastname");
        String lastName = UserInterface.scanner.nextLine();
        if (!lastName.isEmpty()) {
            editMember.setLastname(lastName);
        }

        System.out.println("Type new address or press 'enter' to keep present address");
        String address = UserInterface.scanner.nextLine();
        if (!address.isEmpty()) {
            editMember.setAddress(address);
        }

        boolean writingError;
        do {
            try {
                System.out.println("Type new postal code or press 'enter' to keep present postal code");
                String postalCode = UserInterface.scanner.nextLine();
                if (!postalCode.isEmpty()) {
                    editMember.setPostalCode(Integer.parseInt(postalCode));
                }
                writingError = false;
            } catch (NumberFormatException e) {
                System.out.println("Error occurred - try again");
                writingError = true;
            }
        } while (writingError);


        System.out.println("Type new city or press 'enter' to keep present city");
        String city = UserInterface.scanner.nextLine();
        if (!city.isEmpty()) {
            editMember.setCity(city);
        }

        boolean writingError1 = false;
        do {
            try {
                System.out.println("Type new phone number or press 'enter' to keep present phone number");
                String phoneNo = UserInterface.scanner.nextLine();
                if (!phoneNo.isEmpty()) {
                    editMember.setPhoneNo(Integer.parseInt(phoneNo));
                }
            } catch (NumberFormatException e) {
                System.out.println("Error occurred - try again.");
                writingError1 = true;
            }
        } while (writingError1);


        System.out.println("Type new e-mail or press 'enter' to keep present e-mail");
        String eMail = UserInterface.scanner.nextLine();
        if (!eMail.isEmpty()) {
            editMember.setAddress(eMail);
        }

        do {
            try {
                System.out.println("Type new Membership status (Passive or active) or 'enter' to keep present status");
                String passive = UserInterface.scanner.nextLine();
                if (!passive.isEmpty()) {
                   editMember.setPassive(Boolean.parseBoolean(passive));
                }
            } catch (NumberFormatException e) {
                System.out.println("Something went wrong - try again.");
                writingError1 = true;
            }
        } while (writingError1);

        do {
            try {
                System.out.println("Type new Membership status (competition swimmer or exerciser) or 'enter' to keep present status");
                String exercise = UserInterface.scanner.nextLine();
                if (!exercise.isEmpty()) {
                    editMember.setExercise(Boolean.parseBoolean(exercise));
                }
            } catch (NumberFormatException e) {
                System.out.println("Error occurred - try again.");
                writingError1 = true;
            }
        } while (writingError1);

        System.out.println("New member information changed to \n");

    }

    public void registerMember(UserInterface userInterface, ChairmanMenu chairmanMenu) {
        boolean writingError = false;
        System.out.println("Register new member");

        System.out.println("Firstname:");
        String firstname = UserInterface.scanner.next();

        System.out.println("Lastname:");
        String lastname = UserInterface.scanner.next();

        LocalDate birthDate = null;
        boolean dateInputError;
        boolean junior = true;
        do {
            try {
                System.out.println("Date of birth ('ddMMyyyy'):");
                birthDate = LocalDate.parse(UserInterface.scanner.next(), DateTimeFormatter.ofPattern("ddMMyyyy"));
                LocalDate todaysDate = LocalDate.now();
                dateInputError = false;
                if (ChronoUnit.YEARS.between(birthDate, todaysDate) < 18) {
                    junior = true;
                    userInterface.member.setJunior(true);
                    System.out.println("Member registered as junior");
                } else if( junior == false) {
                    userInterface.member.setJunior(false);
                    System.out.println("Member registered as senior");
                }
            } catch (DateTimeParseException | NumberFormatException e) {
                System.out.println("Date of birth must be in correct format 'ddMMyyyy'");
                dateInputError = true;
            }
        } while (dateInputError);

        System.out.println("Type in address:");
        String address = UserInterface.scanner.next();

        int postalCode = 0;
        do {
            try {
                System.out.println("Type in postal code:");
                postalCode = Integer.parseInt(UserInterface.scanner.next());
                if (postalCode > 0) {
                    userInterface.member.setPostalCode((postalCode));
                    writingError = false;
                }

            } catch (NumberFormatException e) {
                System.out.println("Something went wrong - try again");
                writingError = true;
            }
        } while (writingError);

        System.out.println("Type in city:");
        String city = UserInterface.scanner.next();


        int phoneNo = 0;
        do {
            try {
                System.out.println("Type in phone number:");
                phoneNo = Integer.parseInt(UserInterface.scanner.next());
                writingError = false;
            } catch (NumberFormatException e) {
                System.out.println("Fail");
                writingError = true;
            }
        } while (writingError);

        System.out.println("Type in e-mail:");
        String eMail = UserInterface.scanner.next();

        System.out.println("Type in active 'a' or passive 'p' member status:");
        boolean passive = true;
        char passiveOrActive;
        do {
            passiveOrActive = UserInterface.scanner.next().charAt(0);
            if (passiveOrActive == 'p') {
                passive = false;
                break;
            } else if (passiveOrActive == 'a') {
                break;
            } else
                System.out.println("Input error - try again");
        } while (passiveOrActive != 'p' || passiveOrActive != 'a');

        System.out.println("Type in competition swimmer 'c' or exerciser 'e' member status:");
        boolean exercise = true;
        char memberType;

        do {
            try {
                memberType = UserInterface.scanner.next().charAt(0);

                if (memberType == 'c') {
                    exercise = false;
                    break;
                } else if (memberType == 'e') {
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
        boolean Paid = true;
        char paidStatus;
        do {
            paidStatus = UserInterface.scanner.next().charAt(0);
            if (paidStatus == 'n') {
                Paid = false;
                break;
            } else if (paidStatus == 'y') {
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
                "Exercise or competition-swimmer: " + exercise + "\n" +
                "Subscription status: " + Paid);
        System.out.println("\nSave the new member? 'yes'/'no' ");
        String yesNo = UserInterface.scanner.next().toLowerCase();
        if (yesNo.equals("yes")) {
            System.out.println("New member saved in database");
            try {
                userInterface.controller.addMember(firstname, lastname, birthDate, address, postalCode, city, phoneNo, eMail, passive, junior, exercise, Paid);
            } catch (FileNotFoundException e) {
                System.out.println("saving failed - try again");
            }
        } else if (yesNo.equals("no")) {
            System.out.println("Member not saved - returning to previous menu");
            chairmanMenu.viewChairmanMenu();
        }
    }
}
