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
            output.print(member.getPhoneNo());
            output.print(";");
            output.print(member.geteMail());
            output.print(";");
            output.print(member.isPassive());
            output.print(";");
            output.print(member.isJunoir());
            output.print(";");
            output.print(member.isExercise());
            output.print(";");


        }
    }

    private Member splitLines(String line) {
        String[] splits = line.split(";");

        Member memberData = new Member();

        //Takes wrong information when creating member - Tutor
        memberData.setFirstname(splits[0]);
        memberData.setLastname(splits[1]);
        int birthYear = Integer.parseInt(splits[2]);
        memberData.setAddress(splits[3]);
        int postalCode = Integer.parseInt(splits[4]);
        memberData.setCity(splits[5]);
        int phoneNo = Integer.parseInt(splits[6]);
        memberData.seteMail(splits[7]);
        boolean passive = Boolean.parseBoolean(splits[8]);
        memberData.setPassive(passive);
        boolean junior = Boolean.parseBoolean(splits[9]);
        memberData.setJunior(junior);
        boolean excercise = Boolean.parseBoolean(splits[10]);
        memberData.setExercise(excercise);


        String firstName = splits[0];
        String lastName = splits[1];

        String address = splits[3];
        String city = splits[5];
        String email = splits[7];

        return new Member(firstName, lastName, birthYear, address, postalCode, city, phoneNo, email, passive, junior, excercise, true);

        //return memberData;
    }

    public static void main(String[] args) {
        Filehandler handler = new Filehandler();

        try{
            ArrayList<Member> members = handler.loadData();
            for (Member member : members) {
                System.out.println(member);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

