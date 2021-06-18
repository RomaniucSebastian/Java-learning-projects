package temaFunctions;

public class SalesRepresentativeUtils {

    public SalesRepresentative[] sort (SalesRepresentative[] reps) {

        for (int i = 0;  i< reps.length; i++){
            for(int j = i; j < reps.length; j++){
                int firstRevenue =reps[i].getNumberOfSales() * reps[i].getQuota();
                int secondRevenue =reps[j].getNumberOfSales() * reps[j].getQuota();
                if (secondRevenue > firstRevenue){
                    SalesRepresentative temp =reps[i];
                    reps[i]= reps[j];
                    reps[j]= temp;
                }
            }
        }
        return reps;
    }
}
