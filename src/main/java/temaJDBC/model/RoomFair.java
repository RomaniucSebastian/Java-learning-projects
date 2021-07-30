package temaJDBC.model;

public class RoomFair {

    private double value;
    private String season;

    public RoomFair(double value, String season) {
        this.value = value;
        this.season = season;
    }

    public double getValue() {
        return value;
    }

    public String getSeason() {
        return season;
    }
}
