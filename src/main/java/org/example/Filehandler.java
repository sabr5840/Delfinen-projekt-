package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Filehandler {

    public void saveData(ArrayList<Member>members) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("data/member.csv"));

        // Print out saved data
        for (Member member: members){
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

    /* taget fra superhero - kan være det skal være en del af userstory ???

    private Member splitLines(String linje) {
        String[] splits = linje.split(";");

        Member heroData = new Member();

        heroData.setName(splits[0]);
        heroData.setRealName(splits[1]);
        int creationYear = Integer.parseInt(splits[2]);
        heroData.setCreationYear(creationYear);
        heroData.setSuperpower(splits[3]);
        boolean human = Boolean.parseBoolean(splits[4]);
        heroData.setHuman(human);
        Double strength = Double.parseDouble(splits[5]);
        heroData.setStrength(strength);

        return heroData;

    }

    */
}





