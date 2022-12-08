package fff.delfinen;
import fff.delfinen.ui.ChairmanMenu;
import fff.delfinen.ui.UserInterface;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import fff.delfinen.CompetitionTeams;

import static fff.delfinen.ui.UserInterface.scanner;

public class MemberEditing {
    Member member = new Member();

    public void viewMembers(ChairmanMenu chairmanMenu) {
        System.out.println("List of members:" + "\n");
        for (Member member : chairmanMenu.controller.getMembers()) {
            System.out.println("Full name: " + member.getFirstname() + " " + member.getLastname() + "\n" + "Date, month and year of birth: "
                    + member.getBirthDate() + "\n" + "Address: " + member.getAddress() + " " + member.getPostalCode() + " " + member.getCity() + "\n"
                    + "Phone number: " + member.getPhoneNo() + "\n" + "Email address: " + member.geteMail() +
                    "\n" + "Membership typer: " + member.isPassive() + ", " + member.isJunior() + ", " + member.isExercise() + "\n" + "Has paid the subscription: " + member.isPaid() + "\n");
        }
    }

    public void searchMember(ChairmanMenu chairmanMenu){
        System.out.println("Search for a specific member by their full name: \n ");
        scanner.nextLine();
        String fullName = scanner.nextLine();
        Member editMember = chairmanMenu.controller.memberSearch(fullName);
    }

    public void deleteMember(ChairmanMenu chairmanMenu) {
        System.out.println("Search for the member you want to remove from the system\n");
        scanner.nextLine();
       System.out.println("Type in name for desired member");
        String fullName = scanner.nextLine();

        System.out.println("Are you sure, you want to delete the member? (true/false)");
        boolean delete = scanner.nextBoolean();
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

    public int VaildNumber (){
        int results = -1;
        boolean writingError = true;
        do{
            try {
                results = Integer.parseInt(scanner.nextLine());
                if (results > 0){
                    writingError = false;
                }
            }catch (NumberFormatException e){
                System.out.println("error, try again");
                writingError = true;
            }
        }while (writingError);
        return results;

    }

    public void editMember(ChairmanMenu chairmanMenu) {
        System.out.println("Member to edit");
        scanner.nextLine();
        System.out.println("Type in full name for desired member to edit ");
        String fullName = scanner.nextLine();
        Member editMember = chairmanMenu.controller.memberSearch(fullName);

        System.out.println("Type new first name or press 'enter' to keep present name");
        String firstName = scanner.nextLine();
        if (!firstName.isEmpty()) {
            editMember.setFirstname(firstName);
        }
        System.out.println("Type new lastname or press 'enter' to keep present lastname");
        String lastName = scanner.nextLine();
        if (!lastName.isEmpty()) {
            editMember.setLastname(lastName);
        }

        System.out.println("Type new address or press 'enter' to keep present address");
        String address = scanner.nextLine();
        if (!address.isEmpty()) {
            editMember.setAddress(address);
        }

        System.out.println("Type new postal code or press 'enter' to keep present postal code");
        int postalCode = VaildNumber();
        UserInterface.member.setPostalCode(postalCode);

        System.out.println("Type new city or press 'enter' to keep present city");
        String city = scanner.nextLine();
        if (!city.isEmpty()) {
            editMember.setCity(city);
        }


        System.out.println("Type new phone number or press 'enter' to keep present phone number");
        int phoneNo = VaildNumber();
        UserInterface.member.setPhoneNo(postalCode);


        System.out.println("Type new e-mail or press 'enter' to keep present e-mail");
        String eMail = scanner.nextLine();
        if (!eMail.isEmpty()) {
            editMember.setAddress(eMail);
        }

        boolean writingError1 = false;
        do {
            try {
                System.out.println("Type new Membership status (Passive or active) or 'enter' to keep present status");
                String passive = scanner.nextLine();
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
                String exercise = scanner.nextLine();
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
        String firstname = scanner.next();

        System.out.println("Lastname:");
        String lastname = scanner.next();

        LocalDate birthDate = null;
        boolean dateInputError;
        boolean junior = true;
        do {
            try {
                System.out.println("Date of birth ('ddMMyyyy'):");
                birthDate = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("ddMMyyyy"));
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
        String address = scanner.next();

        int postalCode = 0;
        do {
            try {
                System.out.println("Type in postal code:");
                postalCode = Integer.parseInt(scanner.next());
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
        String city = scanner.next();


        int phoneNo = 0;
        do {
            try {
                System.out.println("Type in phone number:");
                phoneNo = Integer.parseInt(scanner.next());
                writingError = false;
            } catch (NumberFormatException e) {
                System.out.println("Fail");
                writingError = true;
            }
        } while (writingError);

        System.out.println("Type in e-mail:");
        String eMail = scanner.next();

        System.out.println("Type in active 'a' or passive 'p' member status:");
        boolean passive = true;
        char passiveOrActive;
        do {
            passiveOrActive = scanner.next().charAt(0);
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
                memberType = scanner.next().charAt(0);

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
            paidStatus = scanner.next().charAt(0);
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
                "Exercise or competition-swimmer: " + exercise + "\n" +
                "Subscription status: " + Paid);
        System.out.println("\nSave the new member? 'yes'/'no' ");
        String yesNo = scanner.next().toLowerCase();
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
