package temaJDBC;

import dao.BookingDAOImplementation;
import db.BookingDB;
import model.Accomodation;
import model.AccomodationFairRelation;
import model.RoomFair;
import model.RoomPrice;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BookingDB bookingDB = new BookingDB();
        BookingDAOImplementation bookingDAOImplementation = new BookingDAOImplementation(bookingDB);
        bookingDAOImplementation.clearAllTables();
        initializeAccomodationTable();
        initializeRoomFairTable();
        initializeAccomodationFairRelationTable();

        List<RoomPrice> list = bookingDAOImplementation.readRoomsPrices();
        list.forEach(System.out::println);

    }

    public static void initializeAccomodationTable() {
        BookingDB bookingDB = new BookingDB();
        BookingDAOImplementation bookingDAOImplementation = new BookingDAOImplementation(bookingDB);
        bookingDAOImplementation.insertIntoAccomodation(new Accomodation("Double", "1 x double", 2, " double"));
        bookingDAOImplementation.insertIntoAccomodation(new Accomodation("Double-Single", "2 x regular", 2, "regular"));
        bookingDAOImplementation.insertIntoAccomodation(new Accomodation("Appartment", "1 x double + 1 couch", 2, "appartment"));
    }

    public static void initializeRoomFairTable() {
        BookingDB bookingDB = new BookingDB();
        BookingDAOImplementation bookingDAOImplementation = new BookingDAOImplementation(bookingDB);
        bookingDAOImplementation.insertIntoRoomFair(new RoomFair(90, "Autumn"));
        bookingDAOImplementation.insertIntoRoomFair(new RoomFair(110, "Spring-Autumn"));
        bookingDAOImplementation.insertIntoRoomFair(new RoomFair(50, "Summer"));
        bookingDAOImplementation.insertIntoRoomFair(new RoomFair(220, "Winter"));
        bookingDAOImplementation.insertIntoRoomFair(new RoomFair(130, "Autumn"));
        bookingDAOImplementation.insertIntoRoomFair(new RoomFair(150, "Summer"));
    }

    public static void initializeAccomodationFairRelationTable() {
        BookingDB bookingDB = new BookingDB();
        BookingDAOImplementation bookingDAOImplementation = new BookingDAOImplementation(bookingDB);
        bookingDAOImplementation.insertIntoAccomodationFairRelation(new AccomodationFairRelation(1, 1));
        bookingDAOImplementation.insertIntoAccomodationFairRelation(new AccomodationFairRelation(1, 2));
        bookingDAOImplementation.insertIntoAccomodationFairRelation(new AccomodationFairRelation(1, 3));
        bookingDAOImplementation.insertIntoAccomodationFairRelation(new AccomodationFairRelation(2, 1));
        bookingDAOImplementation.insertIntoAccomodationFairRelation(new AccomodationFairRelation(2, 2));
        bookingDAOImplementation.insertIntoAccomodationFairRelation(new AccomodationFairRelation(2, 3));
        bookingDAOImplementation.insertIntoAccomodationFairRelation(new AccomodationFairRelation(3, 4));
        bookingDAOImplementation.insertIntoAccomodationFairRelation(new AccomodationFairRelation(3, 5));
        bookingDAOImplementation.insertIntoAccomodationFairRelation(new AccomodationFairRelation(3, 6));
    }


}
