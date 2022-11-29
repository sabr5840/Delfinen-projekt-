package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Filehandler {
    private final String path = "Data/Members.csv";

    public ArrayList<Member> loadData() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        ArrayList<Member> members = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Member memberObject = splitLines(line);

            members.add(memberObject);
        }
        return members;
    }

    public void saveData(ArrayList<Member> members) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(path));

        for (Member member : members) {
            output.print(member.getFirstname());
            output.print(";");
            output.print(member.getLastname());
            output.print(";");
            output.print(member.getBirthYear());
            output.print(";");
            output.print(member.getAddress());
            output.print(";");
            output.print(member.getPostalCode());
            output.print(";");
            output.print(member.getCity());
            output.print(";");
            output.print(member.getNumber());
            output.print(";");
            output.print(member.geteMail());
            output.print(";");
            output.print(member.isPassive());
            output.print(";");
            output.print(member.isJunior());
            output.print(";");
            output.print(member.isExcercise());
            output.print(";");


        }
    }

    private Member splitLines(String line) {
        String[] splits = line.split(";");

        Member memberData = new Member();

        //Takes wrong information when creating member - Tutor
        memberData.setFirstname(splits[0]);
        memberData.setLastname(splits[1]);
        int birtYear = Integer.parseInt(splits[2]);
        memberData.setAddress(splits[3]);
        int zipCode = Integer.parseInt(splits[4]);
        memberData.setCity(splits[5]);
        int number = Integer.parseInt(splits[6]);
        memberData.seteMail(splits[7]);
        boolean Passive = Boolean.parseBoolean(splits[8]);
        memberData.setPassive(Passive);
        boolean JuniorOrSenior = Boolean.parseBoolean(splits[9]);
        memberData.setJunior(JuniorOrSenior);
        boolean CompetitionOrExcercise = Boolean.parseBoolean(splits[10]);
        memberData.setExcercise(CompetitionOrExcercise);

        return memberData;
    }
}

