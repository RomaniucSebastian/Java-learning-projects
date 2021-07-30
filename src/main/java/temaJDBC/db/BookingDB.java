package temaJDBC.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookingDB {

    public Connection connect() throws DbException {
        try {
            Class.forName("org.postgresql.Driver").newInstance();

            DriverManager.setLoginTimeout(60);

            String url = new StringBuilder()
                    .append("jdbc:")
                    .append("postgresql")
                    .append("://")
                    .append("localhost")
                    .append(":")
                    .append(5432)
                    .append("/")
                    .append("booking")
                    .append("?user=")
                    .append("postgres")
                    .append("&password=")
                    .append("pasiune").toString();

            return DriverManager.getConnection(url);
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            System.err.println("Data Base connection error: " + e.getMessage());
            throw new DbException("Culd not load the DB driver", e);

        }
    }
}
