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
        ArrayList<Member>members = new ArrayList<>();

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            Member memberObject = splitLines(line);

            members.add(memberObject);
        }
        return members;
    }

    public void saveData(ArrayList <Member> members) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(path));

        for (Member member : members){
            output.print(member.getName());
            output.print(";");
            output.print(member.getBirthYear());
            output.print(";");
            output.print(member.getAddress());
            output.print(";");
            output.print(member.getZipCode());
            output.print(";");
            output.print(member.getCity());
            output.print(";");
            output.print(member.getNumber());
            output.print(";");
            output.print(member.geteMail());
            output.print(";");
            output.print(member.isPassiveOrActiveMember());
            output.print(";");
            output.print(member.isJuniorOrSenior());
            output.print(";");
            output.print(member.isCompetitionOrExcercise());
            output.print(";");


        }
    }

    private Member splitLines(String linje) {
        String[] splits = linje.split(";");

        Member memberData = new Member();

        //Takes wrong information when creating member - Tutor
        memberData.setName(splits[0]);
        int birtYear = Integer.parseInt(splits[1]);
        memberData.setAddress(splits[2]);
        int zipCode = Integer.parseInt(splits[3]);
        memberData.setCity(splits[4]);
        int number = Integer.parseInt(splits[5]);
        memberData.seteMail(splits[6]);
        boolean PassiveOrActiveMember = Boolean.parseBoolean(splits[7]);
        memberData.setCompetitionOrExcercise(PassiveOrActiveMember);
        boolean JuniorOrSenior = Boolean.parseBoolean(splits[8]);
        memberData.setJuniorOrSenior(JuniorOrSenior);
        boolean CompetitionOrExcercise = Boolean.parseBoolean(splits[9]);
        memberData.setCompetitionOrExcercise(CompetitionOrExcercise);

        return memberData;
    }
}

