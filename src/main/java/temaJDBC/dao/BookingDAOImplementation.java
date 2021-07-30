package temaJDBC.dao;

import db.BookingDB;
import db.DbException;
import model.Accomodation;
import model.AccomodationFairRelation;
import model.RoomFair;
import model.RoomPrice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOImplementation implements BookingDAO {

    private BookingDB bookingDB;

    public BookingDAOImplementation(BookingDB bookingDB) {
        this.bookingDB = bookingDB;
    }


    @Override
    public void clearAllTables() {
        try {
            Connection connection = bookingDB.connect();
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM accomodation_fair_relation;\n" +
                    "DELETE FROM accomodation;\n" +
                    "DELETE FROM room_fair;");
            statement.execute("ALTER SEQUENCE accomodation_id_seq RESTART WITH 1;");
            statement.execute("ALTER SEQUENCE room_fair_id_seq RESTART WITH 1;");
            statement.execute("ALTER SEQUENCE accomodation_fair_relation_id_seq RESTART WITH 1;");
            connection.close();
        } catch (SQLException | DbException e) {
            System.err.println("Deleting tables error: " + e.getMessage());
        }
    }

    @Override
    public void insertIntoAccomodation(Accomodation accomodation) {
        try {
            Connection connection = bookingDB.connect();
            PreparedStatement statement = connection.prepareStatement("insert into accomodation(type, bed_type, " +
                    "max_guests, description) values (?, ?, ?, ?)");
            statement.setString(1, accomodation.getType());
            statement.setString(2, accomodation.getBedType());
            statement.setInt(3, accomodation.getMaxGuests());
            statement.setString(4, accomodation.getDescription());
            statement.executeUpdate();
            connection.close();

        } catch (SQLException | DbException e) {
            System.err.println("Accomodation insertion into table error: " + e.getMessage());
        }
    }

    @Override
    public void insertIntoRoomFair(RoomFair roomFair) {
        try {
            Connection connection = bookingDB.connect();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO room_fair(value, season) values (?, ?)");
            statement.setDouble(1, roomFair.getValue());
            statement.setString(2, roomFair.getSeason());
            statement.executeUpdate();
            connection.close();

        } catch (SQLException | DbException e) {
            System.err.println("RoomFair insertion into table error: " + e.getMessage());
        }
    }

    @Override
    public void insertIntoAccomodationFairRelation(AccomodationFairRelation accomodationFairRelation) {
        try {
            Connection connection = bookingDB.connect();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO accomodation_fair_relation(id_accomodation, id_room_fair) values (?, ?)");
            statement.setInt(1, accomodationFairRelation.getIdAccomodation());
            statement.setInt(2, accomodationFairRelation.getIdRoomFair());
            statement.executeUpdate();
            connection.close();

        } catch (SQLException | DbException e) {
            System.err.println("AccomodationFairRelation insertion into table error: " + e.getMessage());
        }
    }

    @Override
    public List<RoomPrice> readRoomsPrices() {
        List<RoomPrice> roomPrices = new ArrayList<>();

        try {
            Connection connection = bookingDB.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT accomodation.type, accomodation.bed_type, accomodation.max_guests, accomodation.description, room_fair.value, room_fair.season\n" +
                    "FROM accomodation\n" +
                    "JOIN accomodation_fair_relation ON accomodation.id = accomodation_fair_relation.id_accomodation\n" +
                    "JOIN room_fair ON room_fair.id = accomodation_fair_relation.id_room_fair;");

            while (resultSet.next()) {
                RoomPrice roomPrice = mapResultSetToRoomPrice(resultSet);
                roomPrices.add(roomPrice);
            }
            connection.close();

        } catch (SQLException | DbException e) {
            System.err.println("Reading rooms prices error: " + e.getMessage());
        }

        return roomPrices;
    }

    private RoomPrice mapResultSetToRoomPrice(ResultSet resultSet) throws SQLException {
        RoomPrice roomPrice = new RoomPrice();
        roomPrice.setType(resultSet.getString("type"));
        roomPrice.setBedType(resultSet.getString("bed_type"));
        roomPrice.setMaxGuests(resultSet.getInt("max_guests"));
        roomPrice.setDescription(resultSet.getString("description"));
        roomPrice.setValue(resultSet.getDouble("value"));
        roomPrice.setSeason(resultSet.getString("season"));

        return roomPrice;
    }
}
