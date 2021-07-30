package temaJDBC.dao;

import model.Accomodation;
import model.AccomodationFairRelation;
import model.RoomFair;
import model.RoomPrice;

import java.util.List;

public interface BookingDAO {

    void clearAllTables();

    void insertIntoAccomodation(Accomodation accomodation);

    void insertIntoRoomFair(RoomFair roomFair);

    void insertIntoAccomodationFairRelation(AccomodationFairRelation accomodationFairRelation);

    List<RoomPrice> readRoomsPrices();
}
