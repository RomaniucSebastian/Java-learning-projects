package temaCollection;

import java.util.Comparator;

public class PersoanaAgeComparator implements Comparator<Persoana> {

    @Override
    public int compare(Persoana o1, Persoana o2) {
        return o1.getAge() - o2.getAge();
    }
}
