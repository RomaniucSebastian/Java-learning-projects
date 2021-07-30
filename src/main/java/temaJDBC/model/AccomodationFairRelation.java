package temaJDBC.model;

public class AccomodationFairRelation {
    private int idAccomodation;
    private int idRoomFair;

    public AccomodationFairRelation(int idAccomodation, int idRoomFair) {
        this.idAccomodation = idAccomodation;
        this.idRoomFair = idRoomFair;
    }

    public int getIdAccomodation() {
        return idAccomodation;
    }

    public int getIdRoomFair() {
        return idRoomFair;
    }

}
