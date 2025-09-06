package mate.academy.hibernate.relations.lib;

public class DataProcessingException extends RuntimeException {

    public DataProcessingException(String message) {
        super(message);
    }

    public DataProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
