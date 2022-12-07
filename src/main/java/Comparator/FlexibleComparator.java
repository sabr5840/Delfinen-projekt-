package Comparator;

import fff.delfinen.Member;

import java.util.Comparator;

public class FlexibleComparator implements Comparator<Member> {
    private String sortInput;

    public FlexibleComparator(String sortInput) {
        this.sortInput = sortInput;
    }

    @Override
    public int compare(Member o1, Member o2) {
        switch (sortInput) {
            case "lastName" -> {
                return o1.getLastname().compareTo(o2.getLastname());
            }
            case "passive" -> {
                return Boolean.compare(o1.isPassive(), o2.isPassive());
            }
            case "junior" -> {
                return  Boolean.compare(o1.isJunior(), o2.isJunior());
            }
            case "exercise" -> {
                return Boolean.compare(o1.isExercise(), o2.isExercise());
            }
            case "paid" -> {
                return Boolean.compare(o1.isPaid(), o2.isPaid());
            }
            /*case "Discipline"-> {
                return o1.
            }
            case "TimeResults" -> {
                return Double.compare(o1.TimeResults(), o2.getResults());
            }*/

        }
        return 0;
    }
}