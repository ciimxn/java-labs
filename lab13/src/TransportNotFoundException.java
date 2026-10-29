public class TransportNotFoundException extends Exception {
    public TransportNotFoundException(String message) {
        super(message);
    }

    public TransportNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
