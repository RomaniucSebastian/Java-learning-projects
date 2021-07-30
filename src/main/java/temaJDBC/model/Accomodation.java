package temaJDBC.model;

public class Accomodation {
    private String type;
    private String bedType;
    private int maxGuests;
    private String description;

    public Accomodation(String type, String bedType, int maxGuests, String description) {
        this.type = type;
        this.bedType = bedType;
        this.maxGuests = maxGuests;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getBedType() {
        return bedType;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public String getDescription() {
        return description;
    }
}
