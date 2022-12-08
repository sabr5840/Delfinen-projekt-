package Comparator;

import fff.delfinen.Member;

import java.util.Comparator;

public class FlexibleComparator implements Comparator<Member> {
    private String sortedInput;

    public FlexibleComparator(String sortInput) {
        this.sortedInput = sortedInput;
    }

    @Override
    public int compare(Member o1, Member o2) {
        switch (sortedInput) {
            case "passive" -> {
                return Boolean.compare(o1.isPassive(), o2.isPassive());
            }
            case "junior" -> {
                return  Boolean.compare(o1.isJunior(), o2.isJunior());
            }
            case "exercise" -> {
                return Boolean.compare(o1.isExercise(), o2.isExercise());
            }
        }
        return 0;
    }
}