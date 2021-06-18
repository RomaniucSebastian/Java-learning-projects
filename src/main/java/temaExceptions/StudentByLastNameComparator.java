package temaExceptions;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class StudentByLastNameComparator implements Comparable<Student> {


    @Override
    public int compareTo(@NotNull Student o) {
        return o.getLastName().compareTo(o.getLastName());
    }
}
