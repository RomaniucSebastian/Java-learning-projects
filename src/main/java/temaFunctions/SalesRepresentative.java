package temaFunctions;

import java.util.List;

public class SalesRepresentative {

    private String fullName;
    private int numberOfSales;
    private int quota;

    public SalesRepresentative(String fullName, int numberOfSales, int quota) {
        this.fullName = fullName;
        this.numberOfSales = numberOfSales;
        this.quota = quota;
    }

    @Override
    public String toString() {
        return "SaleRepresentative{" +
                "fullName=" + fullName + " " +
                ", numberOfSales=" + numberOfSales +
                ", quota=" + quota +
                "}";
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public int getQuota() {
        return quota;
    }

    public String getFullName() {
        return fullName;
    }
}
