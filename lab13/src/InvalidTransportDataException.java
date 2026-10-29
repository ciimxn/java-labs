public class InvalidTransportDataException extends Exception {
    public InvalidTransportDataException(String message) {
        super(message);
    }

    public InvalidTransportDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
