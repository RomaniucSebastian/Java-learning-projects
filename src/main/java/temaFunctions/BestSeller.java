package temaFunctions;

import temaFunctions.SalesRepresentative;
import temaFunctions.SalesRepresentativeUtils;

public class BestSeller {
    public static void main(String[] args) {


        SalesRepresentativeUtils utils = new SalesRepresentativeUtils();
        SalesRepresentative one = new SalesRepresentative("Mihai ", 12, 420);
        SalesRepresentative two = new SalesRepresentative("Ioana ", 18, 490);
        SalesRepresentative tree = new SalesRepresentative("Daniel ", 20, 550);
        SalesRepresentative four = new SalesRepresentative("Radu ", 14, 460);

        SalesRepresentative[] reps = {one, two, tree, four};
        SalesRepresentative[] repsSorted = utils.sort(reps);

        for (int i = 0; i < repsSorted.length; i++) {
            System.out.println(repsSorted[i].getFullName());
        }
    }
}
