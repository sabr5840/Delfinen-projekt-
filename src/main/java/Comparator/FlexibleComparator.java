package Comparator;

import org.example.Member;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class FlexibleComparator implements Comparator<Member> {
    private String sortedList;

    public FlexibleComparator(String sortedInput) {
        this.sortedList = sortedInput;
    }

    @Override
    public int compare(Member o1, Member o2) {
        switch (sortedList) {
            case "Lastname" -> {
                return o1.getLastname().compareTo(o2.getLastname());
            }
            case "Passive" -> {
                return Boolean.compare(o1.isPassive(), o2.isPassive());
            }
            case "Junior" -> {
                return  Boolean.compare(o1.isJunior(), o2.isJunior());
            }
            case "exercise" -> {
                return Boolean.compare(o1.isExercise(), o2.isExercise());
            }
            case "Paid" -> {
                return Boolean.compare(o1.isHasPaid(), o2.isHasPaid());
            }
        }
        return 0;
    }
}