package service.repository;

public class WhereToNowDatabaseException extends Exception {
    public WhereToNowDatabaseException(String message) {
        super(message);
    }

    public WhereToNowDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
