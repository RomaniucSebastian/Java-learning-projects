package temaJDBC.db;

public class DbException extends Throwable {

    public DbException(String s, Exception e) {
        super(s, e);
    }
}
