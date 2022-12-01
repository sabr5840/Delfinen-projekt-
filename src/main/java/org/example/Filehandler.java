package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Filehandler {
    private final String path = "Data/Members.csv";

    public ArrayList<Member> loadData() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Data/Members.csv"));
        ArrayList<Member> members = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Member memberObject = splitLines(line);

            members.add(memberObject);
        }
        return members;
    }

    public void saveData(ArrayList<Member> members) throws FileNotFoundException {

        PrintStream output = new PrintStream(path);

        for (Member member : members) {
            output.print(member.getFirstname());
            output.print(";");
            output.print(member.getLastname());
            output.print(";");
            output.print(member.getBirthDate());
            output.print(";");
            output.print(member.getAddress());
            output.print(";");
            output.print(member.getPostalCode());
            output.print(";");
            output.print(member.getCity());
            output.print(";");
            output.print(member.getPhoneNo());
            output.print(";");
            output.print(member.geteMail());
            output.print(";");
            output.print(member.isPassive());
            output.print(";");
            output.print(member.isJunior());
            output.print(";");
            output.print(member.isExercise());
            output.print(";");
            output.print(member.isHasPaid());
            output.println();
        }
    }

    private Member splitLines(String line) {
        String[] splits = line.split(";");

        Member member = new Member();

        //Takes wrong information when creating member - Tutor
        String firstName = splits[0];
        String lastName = splits[1];
        LocalDate birthDate = LocalDate.parse(splits[2]);
        String address = splits[3];
        int postalCode = Integer.parseInt(splits[4]);
        String city = splits[5];
        int phoneNo = Integer.parseInt(splits[6]);
        String email = splits[7];
        boolean passive = Boolean.parseBoolean(splits[8]);
        boolean junior = Boolean.parseBoolean(splits[9]);
        boolean excercise = Boolean.parseBoolean(splits[10]);
        boolean hasPaid = Boolean.parseBoolean(splits[11]);


        return new Member(firstName, lastName, birthDate, address, postalCode, city, phoneNo, email, passive, junior, excercise, hasPaid);

    }
}

