package temaIO;

import java.util.Comparator;

public class WinnerComparator implements Comparator<Competitor> {

    @Override
    public int compare(Competitor o1, Competitor o2) {
       return o1.getTotalTimeInSeconds() - o2.getTotalTimeInSeconds();
    }
}
