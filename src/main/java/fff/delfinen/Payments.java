package fff.delfinen;
import Comparator.FlexibleComparator;
import fff.delfinen.ui.CashierMenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import static fff.delfinen.ui.UserInterface.scanner;

public class Payments {

    private Controller controller = new Controller();
    private ArrayList<Member> juniorList = new ArrayList<>();
    private ArrayList<Member> seniorList = new ArrayList<>();
    private ArrayList<Member> passiveList = new ArrayList<>();
    private ArrayList<Member> paidJuniors = new ArrayList<>();
    private ArrayList<Member> paidSeniors = new ArrayList<>();
    private ArrayList<Member> paidPassives = new ArrayList<>();
    private int juniorMember = 1000;
    private int seniorMember = 1600;
    private int passiveMember = 500;
    final int seniorRate = (seniorMember / 100 * 25);
    final int studentRateSenior = (seniorRate / 100 * 20);
    final int studentRateJunior = (juniorMember / 100 * 20);


    public int getStudentRateSenior(){
        return studentRateSenior;
    }

    public int getStudentRateJunior(){
        return studentRateJunior;
    }

    public int getSeniorMember(){
    return seniorMember;
    }

    public int getJuniorMember() {
        return juniorMember;
    }

    public int getPassiveMember() {
        return passiveMember;
    }

    public void setJuniorMember(int juniorMember) {
        this.juniorMember = juniorMember;
    }

    public void setSeniorMember(int seniorMember) {
        this.seniorMember = seniorMember;
    }

    public void setPassiveMember(int passiveMember) {
        this.passiveMember = passiveMember;
    }


    public int expectedPaymentTotal() {
        for (int i = 0; i < Database.members.size(); i++) {
            if (Database.members.get(i).isJunior()) {
                juniorList.add(Database.members.get(i));
            } else if (Database.members.get(i).isPassive()) {
                passiveList.add(Database.members.get(i));
            } else if (!Database.members.get(i).isJunior()) seniorList.add(Database.members.get(i));
        }

        for (Member member : seniorList) {
            if (member.isPaid()) {
                paidSeniors.add(member);
            }
        }
        for (Member member : passiveList) {
            if (member.isPaid()) {
                paidPassives.add(member);
            }
        }
        int totalJunior = juniorList.size() * 1000;
        int totalSenior = seniorList.size() * 1600;
        int totalePassive = passiveList.size() * 500;
        int total = totalJunior + totalSenior + totalePassive;
        System.out.println("Expected annual payment in total:");
        return total;
    }

    public int getPaymentsInTotal() {
        int total = 0;
        for (Member member : controller.getMembers()) {
            if (member.isPaid()) {
                if (member.isJunior()) {
                    total += 1000;
                } else if (member.isPassive()) {
                    total += 500;
                } else {
                    total += 1600;
                }
            }
        }
        return total;
    }

    public void paymentOverview(CashierMenu cashierMenu) {
        System.out.println("Payments in total: " + "\n" + getPaymentsInTotal() + "\n");
        System.out.println(expectedPaymentTotal());
    }


    public void viewPaymentStatusAllMembers() {
        for (Member member : controller.getMembers()) {
            System.out.println("Name: " + member.getFirstname() + "\n" + "Lastname: " + member.getLastname() + "\n" + "has paid the subscription: " + member.isPaid() + "\n");
        }
    }

    public void editPaymentStatus(CashierMenu cashierMenu) {
        System.out.println("Type name of member to edit payment status:");
        String fullName = scanner.nextLine();
        Member editPayment = cashierMenu.controller.memberSearch(fullName);
        if (editPayment != null){
            boolean writingError = false;
            do {
                try {
                    System.out.println("Type in new subscription status");
                    String hasPaid = scanner.nextLine();
                    if (!hasPaid.isEmpty()) {
                        editPayment.setPaid(Boolean.parseBoolean(hasPaid));
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error occurred - try again.");
                    writingError = true;
                }
            } while (writingError);
        }else {
            System.out.println("Member not found");
        }
        }

    public void viewMemberPastDue(){
        System.out.println("Members past due \n");
        for (Member member : Database.members){
            if (!member.isPaid()){
                System.out.println("Full name: " + member.getFirstname() + " " + member.getLastname());
            }
        }
    }

    public void sortMemberPastDue(CashierMenu userInterface) {
        Scanner scanner = new Scanner(System.in);
        int userinput = 0;
        boolean inputError;
        String sortedInput = "";

        System.out.println("Choose how you could like to sort members\n");
        System.out.println("1) sort member list by active/passive membership");
        System.out.println("2) sort member list by junior/senior member");
        System.out.println("3) sort member list by exerciser or competitive swimmer");

        ArrayList<Member> sortedList = controller.getMembers();

        try {
            userinput = scanner.nextInt();
            scanner.nextLine();
            switch (userinput) {
                case 1 -> {
                    sortedList.sort(new FlexibleComparator(sortedInput));
                    System.out.println("Active/passive membership status list\n");
                    for (Member member : sortedList)
                        System.out.println("Full name: " + member.getFirstname() + " " + member.getLastname() + "\n" + "Subscription status: " + member.isPaid() + "\n");
                }
                case 2 -> {
                    sortedList.sort(new FlexibleComparator(sortedInput));
                    System.out.println("junior/senior member status list\n");
                    for (Member member : sortedList)
                        System.out.println("Full name: " + member.getFirstname() + " " + member.getLastname() + "\n" + "Subscription status: " + member.isPaid() + "\n");
                }
                case 3 -> {
                    sortedList.sort(new FlexibleComparator(sortedInput));
                    System.out.println("Exerciser or competitive swimmer list\n");
                    for (Member member : sortedList)
                        System.out.println("Full name: " + member.getFirstname() + " " + member.getLastname() + "\n" + "Subscription status: " + member.isPaid() + "\n");
                }

            }

        } catch (InputMismatchException e) {
            System.out.println("Wrong inpu\n");
            System.out.println("Type 6, to return til menu");
            inputError = true;
            scanner.nextLine();
        }

    }


}
