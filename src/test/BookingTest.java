import dao.BookingDAOImplementation;
import db.BookingDB;
import db.DbException;
import junit.framework.TestCase;
import model.Accomodation;
import model.AccomodationFairRelation;
import model.RoomFair;
import model.RoomPrice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BookingTest extends TestCase {

    BookingDB bookingDB;
    BookingDAOImplementation bookingDAOImplementation;

    public void setUp() throws SQLException {
        System.out.println("Starting test!");
        bookingDB = new BookingDB();
        bookingDAOImplementation = new BookingDAOImplementation(bookingDB);
        bookingDAOImplementation.clearAllTables();
    }

    public void tearDown() {
        bookingDAOImplementation.clearAllTables();
        bookingDAOImplementation = null;
        bookingDB = null;
        System.out.println("Test completed!");
    }

    public void testInsertIntoAccomodation() throws SQLException, DbException {
        initializeAccomodationTable();
        assertEquals(3, countEntryesIntoTable("accomodation"));
    }

    public void testInsertIntoRoomFair() throws SQLException, DbException {
        initializeRoomFairTable();
        assertEquals(6, countEntryesIntoTable("room_fair"));
    }

    public void testInsertIntoAccomodationFairRelation() throws SQLException, DbException {
        initializeAccomodationTable();
        initializeRoomFairTable();
        initializeAccomodationFairRelationTable();
        assertEquals(9, countEntryesIntoTable("accomodation_fair_relation"));
    }

    public void testReadRoomPrices() {
        initializeAccomodationTable();
        initializeRoomFairTable();
        initializeAccomodationFairRelationTable();
        List<RoomPrice> list = bookingDAOImplementation.readRoomsPrices();
        list.forEach(System.out::println);
        assertEquals(9, list.size());

    }

    public void initializeAccomodationTable() {
        bookingDAOImplementation.insertIntoAccomodation(new Accomodation("Double", "1 x double", 2, "bla bla double"));
        bookingDAOImplementation.insertIntoAccomodation(new Accomodation("Double-Single", "2 x regular", 2, "bla bla 2 x regular"));
        bookingDAOImplementation.insertIntoAccomodation(new Accomodation("Appartment", "1 x double + 1 couch", 2, "bla bla appartment"));
    }

    public void initializeRoomFairTable() {
        bookingDAOImplementation.insertIntoRoomFair(new RoomFair(80, "Winter"));
        bookingDAOImplementation.insertIntoRoomFair(new RoomFair(100, "Spring-Autumn"));
        bookingDAOImplementation.insertIntoRoomFair(new RoomFair(150, "Summer"));
        bookingDAOImplementation.insertIntoRoomFair(new RoomFair(120, "Winter"));
        bookingDAOImplementation.insertIntoRoomFair(new RoomFair(180, "Spring-Autumn"));
        bookingDAOImplementation.insertIntoRoomFair(new RoomFair(250, "Summer"));
    }

    public void initializeAccomodationFairRelationTable() {
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

    public int countEntryesIntoTable(String tabelName) throws DbException, SQLException {
        int result;
        try (Connection connection = bookingDB.connect()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM " + tabelName + ";");
            rs.next();
            result = rs.getInt(1);
            return result;
        }
    }
}